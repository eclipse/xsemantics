package it.xsemantics.dsl.generator

import com.google.inject.Inject
import it.xsemantics.dsl.typing.XsemanticsTypeSystem
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.EmptyEnvironment
import it.xsemantics.dsl.xsemantics.EnvironmentAccess
import it.xsemantics.dsl.xsemantics.EnvironmentComposition
import it.xsemantics.dsl.xsemantics.EnvironmentMapping
import it.xsemantics.dsl.xsemantics.EnvironmentReference
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import it.xsemantics.dsl.xsemantics.Fail
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.OrExpression
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleConclusion
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction

class XsemanticsXbaseCompiler extends XbaseCompiler {
	@Inject extension XsemanticsUtils
	@Inject extension XsemanticsGeneratorExtensions
	@Inject extension XsemanticsNodeModelUtils
	@Inject extension XsemanticsTypeSystem typeSystem
	
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
				
				return appendable
			}
			AuxiliaryFunction: {
				if (rule.auxiliaryDescription.type != null)
					return super.compile(obj, appendable, expectedReturnType, declaredExceptions)
				
				// else we must put an explicit return true, since
				// the Java method is expected to be boolean
				internalToJavaStatement(obj, appendable, false)
				appendable.newLine.append("return true;")
				return appendable
			}
		}
		
		switch (obj) {
			ErrorSpecification: {
				val error = compileErrorOfErrorSpecification(obj, appendable)
				val source = compileSourceOfErrorSpecification(obj, appendable)
				val feature = compileFeatureOfErrorSpecification(obj, appendable)
   				
   				appendable.newLine

   				obj.eContainer.compileFinalPartOfThrowExceptionMethod
   					(appendable, error, source, feature)
   				
   				return appendable
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
	
	def dispatch compileFinalPartOfThrowExceptionMethod(EObject o, 
			ITreeAppendable a, String error, String source, String feature) {
		a.append("/* NOT IMPLEMENTED */")
	}

	def dispatch compileFinalPartOfThrowExceptionMethod(JudgmentDescription judgmentDescription, 
			ITreeAppendable a, String error, String source, String feature) {
		a.append('''
			«throwRuleFailedExceptionMethod»(«error»,
				_issue, _ex, new ''')
		judgmentDescription.errorInformationType.serialize(judgmentDescription, a)
		a.append('''(«source», «feature»));''')
	}

	def dispatch compileFinalPartOfThrowExceptionMethod(RuleConclusion ruleConclusion,
			ITreeAppendable a, String error, String source, String feature) {
		val rule = ruleConclusion.containingRule
		a.append('''
   					«throwRuleFailedExceptionMethod»(«error»,
   						«rule.ruleIssueString», e_«rule.applyRuleName», new ''')
		rule.errorInformationType.serialize(rule, a)
		a.append('''(«source», «feature»));''')
	}

	def dispatch compileFinalPartOfThrowExceptionMethod(AuxiliaryDescription aux,
			ITreeAppendable a, String error, String source, String feature) {
		a.append('''
			«throwRuleFailedExceptionMethod»(«error»,
				_issue, _ex, new ''')
		aux.errorInformationType.serialize(aux, a)
		a.append('''(«source», «feature»));''')
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

	/**
	 * When we invoke an auxiliary function we must also add the
	 * trace argument.
	 */
	override protected void appendFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		val feature = call.getFeature();
		val auxiliaryDescription = feature.associatedAuxiliaryDescription();
		if (auxiliaryDescription == null) {
			super.appendFeatureCall(call, b);
			return;
		}
			
		val name = auxiliaryDescription.entryPointInternalMethodName();
		
		// copied from FeatureCallCompiler
		b.trace(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0).append(name);
		if (feature instanceof JvmExecutable) {
			b.append("(");
			// add the trace argument
			b.append(ruleApplicationTraceName());
			val arguments = call.getActualArguments();
			if (!arguments.isEmpty()) {
				b.append(", ");
				val receiver = 
					if (call instanceof XMemberFeatureCall)
						(call as XMemberFeatureCall).getMemberCallTarget()
					else
						null;
				val shouldBreakFirstArgument = receiver == null || arguments.get(0) != receiver;
				appendArguments(arguments, b, shouldBreakFirstArgument);
			}
			b.append(")");
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

	def dispatch void doInternalToJavaStatement(Fail fail, ITreeAppendable b,
			boolean isReference) {
		generateCommentWithOriginalCode(fail, b);
		val errorSpecification = fail.getError();
		if (errorSpecification == null) {
			newLine(b);
			b.append("throwForExplicitFail();");
		} else {
			toJavaStatement(errorSpecification, b, isReference);
		}
	}

	def dispatch void doInternalToJavaStatement(ErrorSpecification errorSpecification, ITreeAppendable b,
			boolean isReference) {
		val errorMessageVar = compileErrorOfErrorSpecification(
				errorSpecification, b);
		val sourceVar = compileSourceOfErrorSpecification(
				errorSpecification, b);
		val featureVar = compileFeatureOfErrorSpecification(
				errorSpecification, b);
		newLine(b);
		b.append("throwForExplicitFail(");
		b.append(errorMessageVar);
		comma(b);
		b.append("new ");
		b.append(errorSpecification.errorInformationType().getType());
		b.append("(");
		b.append(sourceVar);
		comma(b);
		b.append(featureVar);
		b.append(")");
		b.append(");");
	}

	def dispatch void doInternalToJavaStatement(RuleInvocation ruleInvocation,
			ITreeAppendable b, boolean isReferenced) {
		generateCommentWithOriginalCode(ruleInvocation, b);
		val judgmentDescription = ruleInvocation
				.judgmentDescription(
						ruleInvocation.getJudgmentSymbol(),
						ruleInvocation.getRelationSymbols());
		val ruleInvocationExpressions = ruleInvocation
				.getExpressions();

		ruleInvocationExpressionsToJavaStatements(b, ruleInvocationExpressions);
		generateEnvironmentSpecificationAsStatements(
				ruleInvocation.getEnvironment(), b);

		val hasOutputParams = ruleInvocation.hasOutputParams();
		newLine(b);

		var resultVariable = "";
		if (hasOutputParams) {
			judgmentDescription.resultType(b);
			space(b);
			resultVariable = generateResultVariable(ruleInvocation, b);
			assign(b);
		}

		b.append(judgmentDescription.entryPointInternalMethodName().toString());
		b.append("(");
		generateEnvironmentSpecificationAsExpression(
				ruleInvocation.getEnvironment(), b);
		comma(b);
		b.append(ruleInvocation.additionalArgsForRuleInvocation().toString());
		comma(b);
		ruleInvocationExpressionsToJavaExpressions(b, ruleInvocation);
		b.append(");");

		if (hasOutputParams) {
			reassignResults(b, ruleInvocation, resultVariable, true);
		}
	}

	def protected void ruleInvocationExpressionsToJavaStatements(ITreeAppendable b,
			List<XExpression> ruleInvocationExpressions) {
		for (ruleInvocationExpression : ruleInvocationExpressions) {
			toJavaStatement(ruleInvocationExpression, b, true);
		}
	}

	def protected void generateEnvironmentSpecificationAsStatements(
			EnvironmentSpecification environmentSpecification, ITreeAppendable b) {
		if (environmentSpecification instanceof EnvironmentMapping) {
			val mapping = environmentSpecification as EnvironmentMapping;
			toJavaStatement(mapping.getKey(), b, true);
			toJavaStatement(mapping.getValue(), b, true);
		} else if (environmentSpecification instanceof EnvironmentComposition) {
			val composition = environmentSpecification as EnvironmentComposition;
			generateEnvironmentSpecificationAsStatements(
					composition.getCurrentEnvironment(), b);
			generateEnvironmentSpecificationAsStatements(
					composition.getSubEnvironment(), b);
		}
	}

	def void generateEnvironmentSpecificationAsExpression(
			EnvironmentSpecification environmentSpecification, ITreeAppendable b) {
		if (environmentSpecification instanceof EmptyEnvironment) {
			b.append(emptyEnvironmentInvocation());
		} else if (environmentSpecification instanceof EnvironmentReference) {
			b.append((environmentSpecification as EnvironmentReference)
					.getEnvironment().getName());
		}
		if (environmentSpecification instanceof EnvironmentMapping) {
			val mapping = environmentSpecification as EnvironmentMapping;
			b.append(environmentEntryInvocation());
			b.append("(");
			toJavaExpression(mapping.getKey(), b);
			comma(b);
			toJavaExpression(mapping.getValue(), b);
			b.append(")");
		} else if (environmentSpecification instanceof EnvironmentComposition) {
			val composition = environmentSpecification as EnvironmentComposition;
			b.append(environmentCompositionInvocation());
			b.append("(");
			b.increaseIndentation();
			newLine(b);
			generateEnvironmentSpecificationAsExpression(
					composition.getCurrentEnvironment(), b);
			comma(b);
			generateEnvironmentSpecificationAsExpression(
					composition.getSubEnvironment(), b);
			b.decreaseIndentation();
			newLine(b);
			b.append(")");
		}
	}

	def protected String generateResultVariable(RuleInvocation ruleInvocation,
			ITreeAppendable b) {
		val declareResultVariable = declareResultVariable(
				ruleInvocation, b);
		b.append(declareResultVariable);
		return declareResultVariable;
	}

	def String declareResultVariable(RuleInvocation ruleInvocation,
			ITreeAppendable b) {
		return b.declareSyntheticVariable(ruleInvocation, "result");
	}

	def protected void ruleInvocationExpressionsToJavaExpressions(
			ITreeAppendable b, RuleInvocation ruleInvocation) {
		ruleInvocationExpressionsToJavaExpressions(b,
				ruleInvocation.inputArgsExpressions());
	}

	def protected void ruleInvocationExpressionsToJavaExpressions(
			ITreeAppendable b,
			List<XExpression> inputArgsExpressions) {
		val expIt = inputArgsExpressions
				.iterator();
		while (expIt.hasNext()) {
			toJavaExpression(expIt.next(), b);
			if (expIt.hasNext())
				comma(b);
		}
	}

	def protected void reassignResults(ITreeAppendable b,
			RuleInvocation ruleInvocation, String resultVariable,
			boolean checkAssignable) {
		val expIt = ruleInvocation
				.outputArgsExpressions();
		if (expIt.isEmpty())
			return;
		newLine(b);
		val getMethods = XsemanticsGeneratorConstants
				.getResultGetMethods().iterator();
		for (expression : expIt) {
			val expressionType = typeSystem.getType(
					expression);
			val getMethod = getMethods.next();

			if (checkAssignable) {
				b.append("checkAssignableTo");
				b.append("(");
				b.append(resultVariable + "." + getMethod);
				comma(b);
				generateJavaClassReference(expressionType, expression, b);
				b.append(");");
				newLine(b);
			}
			// assignment with cast
			if (expression instanceof XVariableDeclaration) {
				// this is not contemplated by xbase compiler
				val varDecl = expression as XVariableDeclaration;
				b.append(b.getName(varDecl));
			} else {
				toJavaExpression(expression, b);
			}
			assign(b);
			b.append("(");
			serialize(expressionType, expression, b);
			b.append(")");
			space(b);
			b.append(resultVariable + "." + getMethod);
			b.append(";");
			newLine(b);
		}
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

	def void space(ITreeAppendable b) {
		b.append(" ");
	}

	def void assign(ITreeAppendable b) {
		space(b);
		b.append("=");
		space(b);
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