package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.typing.XsemanticsTypeSystem
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.EnvironmentAccess
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import it.xsemantics.dsl.xsemantics.OrExpression
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

class CustomXbaseCompiler extends XbaseCompiler {
	@Inject extension XsemanticsUtils
	@Inject extension XsemanticsGeneratorExtensions
	@Inject extension XsemanticsNodeModelUtils
	@Inject extension XsemanticsTypeSystem
	
	override compile(XExpression obj, ITreeAppendable appendable, JvmTypeReference expectedReturnType, Set<JvmTypeReference> declaredExceptions) {
		val rule = obj.eContainer
		switch (rule) {
			RuleWithPremises: {
				rule.declareVariablesForOutputParams(appendable) 
   				rule.compileRuleBody(rule.judgmentDescription.resultType, appendable)
			
				return appendable
			}
			CheckRule: {
				rule.compilePremises(appendable)
   				if (!appendable.toString.empty)
					appendable.newLine
				appendable.append("return new ")
				rule.resultType(appendable)
				appendable.append("(true);")
			}			
		}
		
		return super.compile(obj, appendable, expectedReturnType, declaredExceptions)
	}
	
	def void compileRuleBody(Rule rule, JvmTypeReference resultType, ITreeAppendable result) {
		compilePremises(rule, result)

		rule.compileReturnResult(resultType, result)
	}
	
	def dispatch compilePremises(Rule rule, ITreeAppendable result) {
		return
	}

	def dispatch compilePremises(RuleWithPremises rule, ITreeAppendable result) {
		toJavaStatement(rule.premises, result, false)
	}

	def dispatch compilePremises(CheckRule rule, ITreeAppendable result) {
		toJavaStatement(rule.premises, result, false)
	}
	
	def String compileErrorOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getError(),
				b,
				getTypeReferences().getTypeForName(typeof(String),
						errorSpecification), "error");
	}

	def String compileSourceOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getSource(),
				b,
				getTypeReferences().getTypeForName(typeof(EObject),
						errorSpecification), "source");
	}

	def String compileFeatureOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getFeature(),
				b,
				getTypeReferences().getTypeForName(typeof(EStructuralFeature),
						errorSpecification), "feature");
	}

	def protected String compileAndAssignToLocalVariable(
			XExpression expression, ITreeAppendable b,
			JvmTypeReference expectedType, String proposedVariable) {
		if (expression == null)
			return "null";

		toJavaStatement(expression, b, true);
		val syntheticObject = new Object();
		val varName = b.declareSyntheticVariable(syntheticObject,
				proposedVariable);
		b.append("\n");
		serialize(expectedType, expression, b);
		b.append(" ").append(varName).append(" = ");
		toJavaExpression(expression, b);
		b.append(";");
		return b.getName(syntheticObject);
	}

	/**
	 * We need to wrap boolean expressions with try-catch-throw RuleFailedException,
	 * since in Xsemantics a boolean expression is an assertion
	 */
	override protected void _toJavaStatement(XBlockExpression expr, ITreeAppendable b,
			boolean isReferenced) {
		if (insideClosure(expr)) {
			// make sure it is referenced if there's only one expression in the
			// block otherwise we might generate
			// an invalid Java statement
			super._toJavaStatement(
					expr,
					b,
					isReferenced
							|| (expr.getExpressions().size() == 1 && 
									expr.getExpressions()
											.get(0).isBooleanPremise));
		} else {
			if (expr.getExpressions().isEmpty())
				return;
			if (expr.getExpressions().size() == 1) {
				compileBooleanXExpression(expr.getExpressions().get(0), b,
						isReferenced);
				return;
			}
			if (isReferenced)
				declareSyntheticVariable(expr, b);
			val needsBraces = isReferenced;
			if (needsBraces) {
				b.newLine().append("{").increaseIndentation();
				b.openPseudoScope();
			}
			val expressions = expr.getExpressions();
			var i = 0
			for (ex : expressions) {
				var hasToBeReferenced = isReferenced;
				if (i < expressions.size() - 1) {
					hasToBeReferenced = false;
				}
				compileBooleanXExpression(ex, b, hasToBeReferenced);
				if (hasToBeReferenced) {
					b.append("\n").append(getVarName(expr, b)).append(" = (");
					internalToConvertedExpression(ex, b, null);
					b.append(");");
				}
				i = i + 1
			}
			if (needsBraces) {
				b.closeScope();
				b.decreaseIndentation().newLine().append("}");
			}
		}
	}

	/**
	 * If it's boolean, wraps in an if with throw RuleFailedException
	 * 
	 * @param expression
	 * @param b
	 * @param hasToBeReferenced
	 */
	def void compileBooleanXExpression(XExpression expression,
			ITreeAppendable b, boolean toBeReferenced) {
		var hasToBeReferenced = toBeReferenced		
		
		if (expression instanceof XBlockExpression) {
			// original generation
			// no need to handle XBlock as a boolean expression:
			// its expressions will be handled accordingly
			internalToJavaStatement(expression, b, hasToBeReferenced);
			return;
		}

		val isBoolean = expression.isBooleanPremise();
		if (isBoolean)
			hasToBeReferenced = true;

		// original generation
		internalToJavaStatement(expression, b, hasToBeReferenced);

		if (isBoolean) {
			generateCommentWithOriginalCode(expression, b);
			newLine(b);
			b.append("if (!");
			toJavaExpression(expression, b);
			b.append(") {");
			b.increaseIndentation();
			newLine(b);
			throwNewRuleFailedException(expression, b);
			closeBracket(b);
		}
	}

	def void throwNewRuleFailedException(XExpression expression,
			ITreeAppendable b) {
		b.append(sneakyThrowRuleFailedException());
		b.append("(");
		generateStringWithOriginalCode(expression, b);
		b.append(");");
	}

	def dispatch void doInternalToJavaStatement(XExpression e,
			ITreeAppendable b, boolean isReferenced) {
		super.doInternalToJavaStatement(e, b, isReferenced)
	}

	def dispatch void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		super.internalToConvertedExpression(obj, appendable);
	}

	def dispatch void doInternalToJavaStatement(EnvironmentAccess environmentAccess,
			ITreeAppendable b, boolean isReferenced) {
		generateCommentWithOriginalCode(environmentAccess, b);

		toJavaStatement(environmentAccess.getArgument(), b, true);

		if (isReferenced) {
			declareFreshLocalVariable(environmentAccess, b)
				[ app | compileEnvironmentAccess(environmentAccess, app) ]
		} else {
			newLine(b);
			compileEnvironmentAccess(environmentAccess, b);
			b.append(";");
		}
	}

	def dispatch void doInternalToJavaStatement(OrExpression orExpression,
			ITreeAppendable b, boolean isReferenced) {
		generateCommentWithOriginalCode(orExpression, b);

		val left = orExpression.getBranches().get(0);
		val right = orExpression.getBranches().get(1);

		tryStmnt(b);

		// don't make it referenced: for blocks the type will be null
		compileBooleanXExpression(left, b, false);

		catchStmnt(b, orExpression);

		// don't make it referenced: for blocks the type will be null
		compileBooleanXExpression(right, b, false);

		closeBracket(b);
	}

	def dispatch void internalToConvertedExpression(EnvironmentAccess environmentAccess,
			ITreeAppendable b) {
		b.append(b.getName(environmentAccess));
	}

	def void generateCommentWithOriginalCode(EObject modelElement,
			ITreeAppendable b) {
		b.append("\n").append("/* ")
				.append(modelElement.getProgramText())
				.append(" */");
	}

	def void generateStringWithOriginalCode(EObject modelElement,
			ITreeAppendable b) {
		b.append("\"")
				.append(modelElement.getProgramText.javaString).append("\"");
	}

	def void compileEnvironmentAccess(
			EnvironmentAccess environmentAccess, ITreeAppendable b) {
		b.append(environmentAccessMethod());
		b.append("(");
		b.append(environmentAccess.getEnvironment().getName());
		comma(b);
		toJavaExpression(environmentAccess.getArgument(), b);
		comma(b);
		generateJavaClassReference(environmentAccess.getType(),
				environmentAccess, b);
		b.append(")");
	}

	def void comma(ITreeAppendable b) {
		b.append(", ");
	}

	def void newLine(ITreeAppendable b) {
		b.append("\n");
	}

	def void closeBracket(ITreeAppendable b) {
		b.decreaseIndentation();
		newLine(b);
		b.append("}");
	}

	def void tryStmnt(ITreeAppendable b) {
		newLine(b);
		b.append("try {");
		b.increaseIndentation();
	}

	/**
	 * Also declares a RuleFailedException variable for the passed expressions
	 * 
	 * @param b
	 * @param expression
	 * @return
	 */
	def String catchStmnt(ITreeAppendable b, XExpression expression) {
		b.decreaseIndentation();
		newLine(b);
		b.append("} catch (");
		b.append(expression.exceptionType().getType());
		b.append(" ");
		val declareExceptionVariable = declareExceptionVariable(
				expression, b);
		b.append(declareExceptionVariable);
		b.append(") {");
		b.increaseIndentation();
		return declareExceptionVariable;
	}

	def String declareExceptionVariable(XExpression expression,
			ITreeAppendable b) {
		return b.declareSyntheticVariable(expression, "e");
	}

	def void generateJavaClassReference(
			JvmTypeReference expressionType,
			XExpression expression, ITreeAppendable b) {
		b.append(expressionType.getType());
		b.append(".class");
	}

	def boolean insideClosure(XBlockExpression expr) {
		return expr.eContainer() instanceof XClosure;
	}
}