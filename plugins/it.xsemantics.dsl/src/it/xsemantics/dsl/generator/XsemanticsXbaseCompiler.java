package it.xsemantics.dsl.generator;

import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription;
import it.xsemantics.dsl.xsemantics.EmptyEnvironment;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.EnvironmentComposition;
import it.xsemantics.dsl.xsemantics.EnvironmentMapping;
import it.xsemantics.dsl.xsemantics.EnvironmentReference;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.Fail;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.Later;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;

import com.google.inject.Inject;

public class XsemanticsXbaseCompiler extends XbaseCompiler {

	@Inject
	private FeatureCallToJavaMapping featureCallToJavaMapping;

	@Inject
	protected XsemanticsNodeModelUtils nodeModelUtils;

	@Inject
	protected XsemanticsUtils xsemanticsUtils;

	@Inject
	protected XsemanticsGeneratorExtensions generatorExtensions;

	@Inject
	protected XsemanticsTypeSystem typeSystem;

	@Override
	protected void doInternalToJavaStatement(XExpression obj,
			ITreeAppendable appendable, boolean isReferenced) {
		if (obj instanceof RuleInvocation) {
			_toJavaStatement((RuleInvocation) obj, appendable, isReferenced);
		} else if (obj instanceof OrExpression) {
			_toJavaStatement((OrExpression) obj, appendable, isReferenced);
		} else if (obj instanceof EnvironmentAccess) {
			_toJavaStatement((EnvironmentAccess) obj, appendable, isReferenced);
		} else if (obj instanceof Fail) {
			_toJavaStatement((Fail) obj, appendable, isReferenced);
		} else
			super.doInternalToJavaStatement(obj, appendable, isReferenced);
	}

	@Override
	protected void internalToConvertedExpression(XExpression obj,
			ITreeAppendable appendable) {
		if (obj instanceof RuleInvocation) {
			_toJavaExpression((RuleInvocation) obj, appendable);
		} else if (obj instanceof OrExpression) {
			_toJavaExpression((OrExpression) obj, appendable);
		} else if (obj instanceof EnvironmentAccess) {
			_toJavaExpression((EnvironmentAccess) obj, appendable);
		} else if (obj instanceof Fail) {
			_toJavaExpression((Fail) obj, appendable);
		} else
			super.internalToConvertedExpression(obj, appendable);
	}

	@Override
	protected void _toJavaStatement(XBlockExpression expr, ITreeAppendable b,
			boolean isReferenced) {
		if (insideClosure(expr)) {
			// make sure it is referenced if there's only one expression in the
			// block otherwise we might generate
			// an invalid Java statement
			super._toJavaStatement(
					expr,
					b,
					isReferenced
							|| (expr.getExpressions().size() == 1 && typeSystem
									.isBooleanPremise(expr.getExpressions()
											.get(0))));
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
			b.append("\n{").increaseIndentation();
			final EList<XExpression> expressions = expr.getExpressions();
			for (int i = 0; i < expressions.size(); i++) {
				XExpression ex = expressions.get(i);
				boolean hasToBeReferenced = isReferenced;
				if (i < expressions.size() - 1) {
					hasToBeReferenced = false;
				}
				compileBooleanXExpression(ex, b, hasToBeReferenced);
				if (hasToBeReferenced) {
					b.append("\n").append(getVarName(expr, b)).append(" = (");
					internalToConvertedExpression(ex, b, null);
					b.append(");");
				}
			}
			b.decreaseIndentation().append("\n}");
		}
	}
	
	@Override
	protected void appendFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		JvmIdentifiableElement feature = call.getFeature();
		AuxiliaryDescription auxiliaryDescription = generatorExtensions.associatedAuxiliaryDescription(feature);
		if (auxiliaryDescription == null) {
			super.appendFeatureCall(call, b);
			return;
		}
			
		CharSequence name = generatorExtensions.entryPointInternalMethodName(auxiliaryDescription);
		
		// copied from FeatureCallCompiler
		b.trace(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0).append(name);
		if (feature instanceof JvmExecutable) {
			b.append("(");
			// add the trace argument
			b.append(generatorExtensions.ruleApplicationTraceName());
			List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(call);
			if (!arguments.isEmpty()) {
				b.append(", ");
				XExpression receiver = (call instanceof XMemberFeatureCall) ? ((XMemberFeatureCall)call).getMemberCallTarget() : null;
				boolean shouldBreakFirstArgument = receiver == null || arguments.get(0) != receiver;
				appendArguments(arguments, b, shouldBreakFirstArgument);
			}
			b.append(")");
		}
	}

	protected boolean insideClosure(XBlockExpression expr) {
		return expr.eContainer() instanceof XClosure;
	}

	/**
	 * If it's boolean, wrapes in an if with throw RuleFailedException
	 * 
	 * @param expression
	 * @param b
	 * @param hasToBeReferenced
	 */
	protected void compileBooleanXExpression(XExpression expression,
			ITreeAppendable b, boolean hasToBeReferenced) {
		if (expression instanceof XBlockExpression) {
			// original generation
			// no need to handle XBlock as a boolean expression:
			// its expressions will be handled accordingly
			internalToJavaStatement(expression, b, hasToBeReferenced);
			return;
		}

		boolean isBoolean = typeSystem.isBooleanPremise(expression);
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
	 * Does nothing: rule invocation is compiled into a statement
	 * 
	 * @param ruleInvocation
	 * @param b
	 */
	public void _toJavaExpression(RuleInvocation ruleInvocation,
			ITreeAppendable b) {
		b.append("null");
	}

	public void _toJavaExpression(OrExpression orExpression, ITreeAppendable b) {
		b.append("null");
	}

	public void _toJavaStatement(RuleInvocation ruleInvocation,
			ITreeAppendable b, boolean isReferenced) {
		generateCommentWithOriginalCode(ruleInvocation, b);
		JudgmentDescription judgmentDescription = xsemanticsUtils
				.judgmentDescription(ruleInvocation,
						ruleInvocation.getJudgmentSymbol(),
						ruleInvocation.getRelationSymbols());
		final EList<RuleInvocationExpression> ruleInvocationExpressions = ruleInvocation
				.getExpressions();

		ruleInvocationExpressionsToJavaStatements(b, ruleInvocationExpressions);
		generateEnvironmentSpecificationAsStatements(
				ruleInvocation.getEnvironment(), b);

		boolean hasOutputParams = xsemanticsUtils
				.hasOutputParams(ruleInvocation);
		newLine(b);

		String resultVariable = "";
		if (hasOutputParams) {
			generatorExtensions.resultType(judgmentDescription, b);
			space(b);
			resultVariable = generateResultVariable(ruleInvocation, b);
			assign(b);
		}

		b.append(generatorExtensions.entryPointInternalMethodName(
				judgmentDescription).toString());
		b.append("(");
		generateEnvironmentSpecificationAsExpression(
				ruleInvocation.getEnvironment(), b);
		comma(b);
		b.append(generatorExtensions.additionalArgsForRuleInvocation(
				ruleInvocation).toString());
		comma(b);
		ruleInvocationExpressionsToJavaExpressions(b, ruleInvocation);
		b.append(");");

		if (hasOutputParams) {
			reassignResults(b, ruleInvocation, resultVariable, true);
		}
	}

	public void _toJavaStatement(final EnvironmentAccess environmentAccess,
			final ITreeAppendable b, boolean isReferenced) {
		generateCommentWithOriginalCode(environmentAccess, b);

		toJavaStatement(environmentAccess.getArgument(), b, true);

		if (isReferenced) {
			Later later = new Later() {
				public void exec(ITreeAppendable b) {
					compileEnvironmentAccess(environmentAccess, b);
				}
			};
			declareFreshLocalVariable(environmentAccess, b, later);
		} else {
			newLine(b);
			compileEnvironmentAccess(environmentAccess, b);
			b.append(";");
		}
	}

	protected void _toJavaExpression(EnvironmentAccess environmentAccess,
			ITreeAppendable b) {
		b.append(b.getName(environmentAccess));
	}

	protected void compileEnvironmentAccess(
			EnvironmentAccess environmentAccess, ITreeAppendable b) {
		b.append(generatorExtensions.environmentAccessMethod());
		b.append("(");
		b.append(environmentAccess.getEnvironment().getName());
		comma(b);
		toJavaExpression(environmentAccess.getArgument(), b);
		comma(b);
		generateJavaClassReference(environmentAccess.getType(),
				environmentAccess, b);
		b.append(")");
	}

	protected void _toJavaStatement(final OrExpression orExpression,
			final ITreeAppendable b, boolean isReferenced) {
		generateCommentWithOriginalCode(orExpression, b);

		final XExpression left = orExpression.getBranches().get(0);
		final XExpression right = orExpression.getBranches().get(1);

		tryStmnt(b);

		// make it referenced
		compileBooleanXExpression(left, b, true);

		catchStmnt(b, orExpression);

		// don't need to make it referenced
		compileBooleanXExpression(right, b, false);

		closeBracket(b);
	}

	public void throwNewRuleFailedException(final XExpression expression,
			final ITreeAppendable b) {
		b.append(generatorExtensions.sneakyThrowRuleFailedException());
		b.append("(");
		generateStringWithOriginalCode(expression, b);
		b.append(");");
	}

	protected void ruleInvocationExpressionsToJavaStatements(ITreeAppendable b,
			final EList<RuleInvocationExpression> ruleInvocationExpressions) {
		for (RuleInvocationExpression ruleInvocationExpression : ruleInvocationExpressions) {
			toJavaStatement(ruleInvocationExpression.getExpression(), b, true);
		}
	}

	protected void ruleInvocationExpressionsToJavaExpressions(
			ITreeAppendable b, final RuleInvocation ruleInvocation) {
		ruleInvocationExpressionsToJavaExpressions(b,
				xsemanticsUtils.inputArgsExpressions(ruleInvocation));
	}

	protected void ruleInvocationExpressionsToJavaExpressions(
			ITreeAppendable b,
			final List<RuleInvocationExpression> inputArgsExpressions) {
		Iterator<RuleInvocationExpression> expIt = inputArgsExpressions
				.iterator();
		while (expIt.hasNext()) {
			toJavaExpression(expIt.next().getExpression(), b);
			if (expIt.hasNext())
				comma(b);
		}
	}

	protected void reassignResults(ITreeAppendable b,
			RuleInvocation ruleInvocation, String resultVariable,
			boolean checkAssignable) {
		List<RuleInvocationExpression> expIt = xsemanticsUtils
				.outputArgsExpressions(ruleInvocation);
		if (expIt.isEmpty())
			return;
		newLine(b);
		Iterator<String> getMethods = XsemanticsGeneratorConstants
				.getResultGetMethods().iterator();
		for (RuleInvocationExpression ruleInvocationExpression : expIt) {
			final XExpression expression = ruleInvocationExpression
					.getExpression();
			final JvmTypeReference expressionType = typeSystem.getType(
					expression);
			final String getMethod = getMethods.next();

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
				XVariableDeclaration varDecl = (XVariableDeclaration) expression;
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

	protected void generateJavaClassReference(
			final JvmTypeReference expressionType,
			final XExpression expression, ITreeAppendable b) {
		b.append(expressionType.getType());
		b.append(".class");
	}

	public void _toJavaExpression(Fail fail, ITreeAppendable b) {
		b.append("null");
	}

	public void _toJavaStatement(Fail fail, ITreeAppendable b,
			boolean isReference) {
		generateCommentWithOriginalCode(fail, b);
		final ErrorSpecification errorSpecification = fail.getError();
		if (errorSpecification == null) {
			newLine(b);
			b.append("throwForExplicitFail();");
		} else {
			String errorMessageVar = compileErrorOfErrorSpecification(
					errorSpecification, b);
			String sourceVar = compileSourceOfErrorSpecification(
					errorSpecification, b);
			String featureVar = compileFeatureOfErrorSpecification(
					errorSpecification, b);
			newLine(b);
			b.append("throwForExplicitFail(");
			b.append(errorMessageVar);
			comma(b);
			b.append("new ");
			b.append(generatorExtensions.errorInformationType(fail).getType());
			b.append("(");
			b.append(sourceVar);
			comma(b);
			b.append(featureVar);
			b.append(")");
			b.append(");");
		}
	}

	protected void generateCommentWithOriginalCode(EObject modelElement,
			ITreeAppendable b) {
		b.append("\n").append("/* ")
				.append(nodeModelUtils.getProgramText(modelElement))
				.append(" */");
	}

	protected void generateStringWithOriginalCode(EObject modelElement,
			ITreeAppendable b) {
		b.append("\"")
				.append(generatorExtensions.javaString(nodeModelUtils
						.getProgramText(modelElement))).append("\"");
	}

	protected void newLine(ITreeAppendable b) {
		b.append("\n");
	}

	protected void space(ITreeAppendable b) {
		b.append(" ");
	}

	protected void comma(ITreeAppendable b) {
		b.append(", ");
	}

	protected void assign(ITreeAppendable b) {
		space(b);
		b.append("=");
		space(b);
	}

	/**
	 * Also declares a RuleFailedException variable for the passed expressions
	 * 
	 * @param b
	 * @param expression
	 * @return
	 */
	protected String catchStmnt(final ITreeAppendable b, XExpression expression) {
		b.decreaseIndentation();
		newLine(b);
		b.append("} catch (");
		b.append(generatorExtensions.exceptionType(expression).getType());
		b.append(" ");
		final String declareExceptionVariable = declareExceptionVariable(
				expression, b);
		b.append(declareExceptionVariable);
		b.append(") {");
		b.increaseIndentation();
		return declareExceptionVariable;
	}

	protected void tryStmnt(final ITreeAppendable b) {
		newLine(b);
		b.append("try {");
		b.increaseIndentation();
	}

	protected void closeBracket(final ITreeAppendable b) {
		b.decreaseIndentation();
		newLine(b);
		b.append("}");
	}

	protected String generateResultVariable(RuleInvocation ruleInvocation,
			ITreeAppendable b) {
		final String declareResultVariable = declareResultVariable(
				ruleInvocation, b);
		b.append(declareResultVariable);
		return declareResultVariable;
	}

	public String declareResultVariable(RuleInvocation ruleInvocation,
			ITreeAppendable b) {
		return b.declareSyntheticVariable(ruleInvocation, "result");
	}

	public String declareExceptionVariable(XExpression expression,
			ITreeAppendable b) {
		return b.declareSyntheticVariable(expression, "e");
	}

	public String compileErrorOfErrorSpecification(
			final ErrorSpecification errorSpecification, final ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getError(),
				b,
				getTypeReferences().getTypeForName(String.class,
						errorSpecification), "error");
	}

	public String compileSourceOfErrorSpecification(
			final ErrorSpecification errorSpecification, final ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getSource(),
				b,
				getTypeReferences().getTypeForName(EObject.class,
						errorSpecification), "source");
	}

	public String compileFeatureOfErrorSpecification(
			final ErrorSpecification errorSpecification, final ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getFeature(),
				b,
				getTypeReferences().getTypeForName(EStructuralFeature.class,
						errorSpecification), "feature");
	}

	protected String compileAndAssignToLocalVariable(
			final XExpression expression, final ITreeAppendable b,
			JvmTypeReference expectedType, String proposedVariable) {
		if (expression == null)
			return "null";

		toJavaStatement(expression, b, true);
		final Object syntheticObject = new Object();
		final String varName = b.declareSyntheticVariable(syntheticObject,
				proposedVariable);
		b.append("\n");
		serialize(expectedType, expression, b);
		b.append(" ").append(varName).append(" = ");
		toJavaExpression(expression, b);
		b.append(";");
		return b.getName(syntheticObject);
	}

	public void generateEnvironmentSpecificationAsExpression(
			EnvironmentSpecification environmentSpecification, ITreeAppendable b) {
		if (environmentSpecification instanceof EmptyEnvironment) {
			b.append(generatorExtensions.emptyEnvironmentInvocation());
		} else if (environmentSpecification instanceof EnvironmentReference) {
			b.append(((EnvironmentReference) environmentSpecification)
					.getEnvironment().getName());
		}
		if (environmentSpecification instanceof EnvironmentMapping) {
			EnvironmentMapping mapping = (EnvironmentMapping) environmentSpecification;
			b.append(generatorExtensions.environmentEntryInvocation());
			b.append("(");
			toJavaExpression(mapping.getKey(), b);
			comma(b);
			toJavaExpression(mapping.getValue(), b);
			b.append(")");
		} else if (environmentSpecification instanceof EnvironmentComposition) {
			EnvironmentComposition composition = (EnvironmentComposition) environmentSpecification;
			b.append(generatorExtensions.environmentCompositionInvocation());
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

	protected void generateEnvironmentSpecificationAsStatements(
			EnvironmentSpecification environmentSpecification, ITreeAppendable b) {
		if (environmentSpecification instanceof EnvironmentMapping) {
			EnvironmentMapping mapping = (EnvironmentMapping) environmentSpecification;
			toJavaStatement(mapping.getKey(), b, true);
			toJavaStatement(mapping.getValue(), b, true);
		} else if (environmentSpecification instanceof EnvironmentComposition) {
			EnvironmentComposition composition = (EnvironmentComposition) environmentSpecification;
			generateEnvironmentSpecificationAsStatements(
					composition.getCurrentEnvironment(), b);
			generateEnvironmentSpecificationAsStatements(
					composition.getSubEnvironment(), b);
		}
	}
}