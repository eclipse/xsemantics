/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package org.eclipse.xsemantics.dsl.generator

import com.google.inject.Inject
import org.eclipse.xsemantics.dsl.XsemanticsConstants
import org.eclipse.xsemantics.dsl.typing.XsemanticsTypeSystem
import org.eclipse.xsemantics.dsl.util.XsemanticsNodeModelUtils
import org.eclipse.xsemantics.dsl.util.XsemanticsUtils
import org.eclipse.xsemantics.dsl.xsemantics.AuxiliaryFunction
import org.eclipse.xsemantics.dsl.xsemantics.CachedClause
import org.eclipse.xsemantics.dsl.xsemantics.CheckRule
import org.eclipse.xsemantics.dsl.xsemantics.Description
import org.eclipse.xsemantics.dsl.xsemantics.EmptyEnvironment
import org.eclipse.xsemantics.dsl.xsemantics.EnvironmentComposition
import org.eclipse.xsemantics.dsl.xsemantics.EnvironmentMapping
import org.eclipse.xsemantics.dsl.xsemantics.ErrorSpecification
import org.eclipse.xsemantics.dsl.xsemantics.Fail
import org.eclipse.xsemantics.dsl.xsemantics.OrExpression
import org.eclipse.xsemantics.dsl.xsemantics.RuleConclusion
import org.eclipse.xsemantics.dsl.xsemantics.RuleInvocation
import org.eclipse.xsemantics.dsl.xsemantics.RuleWithPremises
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.EcoreUtil2

class XsemanticsXbaseCompiler extends XbaseCompiler {
	@Inject extension XsemanticsUtils
	@Inject extension XsemanticsGeneratorExtensions
	@Inject extension XsemanticsNodeModelUtils
	@Inject extension XsemanticsTypeSystem typeSystem
	@Inject TypeReferences typeReferences
	
	override compile(XExpression obj, ITreeAppendable appendable, JvmTypeReference expectedReturnType, Set<JvmTypeReference> declaredExceptions) {
		val rule = obj.eContainer
		switch (rule) {
			RuleWithPremises: {
				rule.declareVariablesForOutputParams(appendable) 
   				rule.compileRuleBody(rule.getJudgmentDescription.resultType, appendable)
			
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
				if (rule.getAuxiliaryDescription.type !== null)
					return super.compile(obj, appendable, expectedReturnType, declaredExceptions)
				
				// else we must put an explicit return true, since
				// the Java method is expected to be boolean
				internalToJavaStatement(obj, appendable, false)
				appendable.newLine.append("return true;")
				return appendable
			}
		}
		
		if (obj instanceof ErrorSpecification) {
			val error = compileErrorOfErrorSpecification(obj, appendable)
			val source = compileSourceOfErrorSpecification(obj, appendable)
			val feature = compileFeatureOfErrorSpecification(obj, appendable)
			val data = compileDataOfErrorSpecification(obj, appendable)
			
			appendable.newLine

			obj.eContainer.compileFinalPartOfThrowExceptionMethod
				(appendable, error, source, feature, data)
			
			return appendable
		}
		
		return super.compile(obj, appendable, expectedReturnType, declaredExceptions)
	}
	
	def void compileRuleBody(RuleWithPremises rule, JvmTypeReference resultType, ITreeAppendable result) {
		compilePremises(rule, result)

		rule.compileReturnResult(resultType, result)
	}
	
	def compilePremises(RuleWithPremises rule, ITreeAppendable result) {
		toJavaStatement(rule.premises, result, false)
	}

	def compilePremises(CheckRule rule, ITreeAppendable result) {
		toJavaStatement(rule.premises, result, false)
	}
	
	def dispatch compileFinalPartOfThrowExceptionMethod(Description desc, 
			ITreeAppendable a, String error, String source, String feature, String data) {
		a.append('''
			«throwRuleFailedExceptionMethod»(«error»,
				_issue, _ex, new ''')
		desc.errorInformationType.serialize(desc, a)
		compileArgsForErrorInformationConstructor(a, source, feature, data)
	}
	
	def dispatch compileFinalPartOfThrowExceptionMethod(RuleConclusion ruleConclusion,
			ITreeAppendable a, String error, String source, String feature, String data) {
		val rule = ruleConclusion.containingRule
		a.append('''
   					«throwRuleFailedExceptionMethod»(«error»,
   						«rule.ruleIssueString», e_«rule.applyRuleName», new ''')
		rule.errorInformationType.serialize(rule, a)
		compileArgsForErrorInformationConstructor(a, source, feature, data)
	}
	
	private def compileArgsForErrorInformationConstructor(ITreeAppendable a, String source, String feature, String data) {
		if (data.empty)
			a.append('''(«source», «feature»));''')
		else
			a.append('''(«source», «feature», «data»));''')
	}

	def String compileErrorOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getError(),
				b,
				typeReferences.getTypeForName(typeof(String),
						errorSpecification), "error");
	}

	def String compileSourceOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getSource(),
				b,
				typeReferences.getTypeForName(typeof(EObject),
						errorSpecification), "source");
	}

	def String compileFeatureOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		return compileAndAssignToLocalVariable(
				errorSpecification.getFeature(),
				b,
				typeReferences.getTypeForName(typeof(EStructuralFeature),
						errorSpecification), "feature");
	}

	def String compileDataOfErrorSpecification(
			ErrorSpecification errorSpecification, ITreeAppendable b) {
		// data has been introduced recently, and I'd like to avoid
		// to update all the generated test code, so we avoid passing
		// the data to ErrorInformation if we don't need to
		if (errorSpecification.getData() === null) {
			return "";
		}
		
		return compileAndAssignToLocalVariable(
				errorSpecification.getData(),
				b,
				typeReferences.getTypeForName(Object,
						errorSpecification), "data");
	}

	def protected String compileAndAssignToLocalVariable(
			XExpression expression, ITreeAppendable b,
			JvmTypeReference expectedType, String proposedVariable) {
		if (expression === null)
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
		if (insideClosure(expr) || insideCachedCondition(expr)) {
			super._toJavaStatement(
					expr,
					b,
					isReferenced);
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

	override protected isVariableDeclarationRequired(XExpression expr, ITreeAppendable b, boolean recursive) {
		// in Xtext 2.5.1 this method does not behave correctly in case
		// we need a referenced compile expression (for boolean premises)
		if (expr.booleanPremise) {
			val container = expr.eContainer
			if (container instanceof XBlockExpression) {
				val siblings = container.getExpressions();
				// if it's the last expression of the block
				if (siblings.get(siblings.size() - 1) == expr) {
					// in Xtext 2.5.1 this would return false
					// but for auxiliary functions we need the variable declaration
					// which we'll use both for testing the evaluated value
					// (and if false, throw an exception)
					// and for returning the value itself
					if (container.eContainer instanceof AuxiliaryFunction)
						return true;
					return false; // the behavior in 2.5.1
				}
			}
		}
		
		return super.isVariableDeclarationRequired(expr, b, recursive)
	}

	/**
	 * When we invoke an auxiliary function we must also add the
	 * trace argument.
	 */
	override protected void appendFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		val feature = call.getFeature();
		val auxiliaryDescription = feature.associatedAuxiliaryDescription();
		if (auxiliaryDescription === null) {
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
						call.getMemberCallTarget()
					else
						null;
				val shouldBreakFirstArgument = receiver === null || arguments.get(0) != receiver;
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

	def dispatch void doInternalToJavaStatement(OrExpression orExpression,
			ITreeAppendable b, boolean isReferenced) {
		
		generateCommentWithOriginalCode(orExpression, b);

		// generating into a block makes sure that two sibling block expressions
		// will not have two conflicting variable declarations for previousFailure
		// (this is easier than trying to detect two sibling block expressions)
		// see https://github.com/LorenzoBettini/xsemantics/issues/46
		openBracket(b)

		// we must declare it only once per Java scope
		// see https://github.com/LorenzoBettini/xsemantics/issues/46
		if (orExpression.previousFailureMustBeDeclared) {
			declarePreviousFailureVariable(orExpression, b);
		}

		val left = orExpression.getBranches().get(0);
		val right = orExpression.getBranches().get(1);

		tryStmnt(b);

		// don't make it referenced: for blocks the type will be null
		compileBooleanXExpression(left, b, false);

		catchStmnt(b, orExpression);

		// don't make it referenced: for blocks the type will be null
		compileBooleanXExpression(right, b, false);

		closeBracket(b);

		closeBracket(b);
	}
	
	def private declarePreviousFailureVariable(OrExpression orExpression, ITreeAppendable b) {
		b.newLine;
		b.declareVariable(
				orExpression, XsemanticsConstants.PREVIOUS_FAILURE);
		b.append(orExpression.ruleFailedExceptionType().getType())
		b.append(" " + XsemanticsConstants.PREVIOUS_FAILURE + " = null;")
	}

	def private previousFailureMustBeDeclared(OrExpression e) {
		var container = e.eContainer
		while (container !== null) {
			// an outer or expression already declares
			// previousFailure variable in the generated code
			if (container instanceof OrExpression) {
				return false
			}
			
			// previousFailure is not final, so it must not be
			// accessible in an or expression of a lambda
			// moreover a lambda makes contained or expressions independent
			// from possible outer or expressions
			if (container instanceof XClosure) {
				return true
			}

			container = container.eContainer
		}
		return true
	}

	/**
	 * To respect the semantics of previousFailureMustBeDeclared we must check
	 * whether it's contained in an OrExpression: when we're inside an OrExpression
	 * we compile the lambda into an anonymous class, so that redeclaring
	 * "previousFailure" local variable does not generate invalid Java code
	 */
	override protected canCompileToJavaLambda(XClosure closure, LightweightTypeReference typeRef, JvmOperation operation) {
		return
			EcoreUtil2.getContainerOfType(closure, OrExpression) === null
			&&
			super.canCompileToJavaLambda(closure, typeRef, operation)
	}

	def dispatch void doInternalToJavaStatement(Fail fail, ITreeAppendable b,
			boolean isReference) {
		generateCommentWithOriginalCode(fail, b);
		val errorSpecification = fail.getError();
		if (errorSpecification === null) {
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
		val dataVar = compileDataOfErrorSpecification(
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
		if (!dataVar.empty) {
			comma(b);
			b.append(dataVar);
		}
		b.append(")");
		b.append(");");
	}

	def dispatch void doInternalToJavaStatement(RuleInvocation ruleInvocation,
			ITreeAppendable b, boolean isReferenced) {
		generateCommentWithOriginalCode(ruleInvocation, b);
		val judgmentDescription = ruleInvocation.getJudgmentDescription;
		val ruleInvocationExpressions = ruleInvocation
				.getExpressions();

		ruleInvocationExpressionsToJavaStatements(b, ruleInvocationExpressions);
		generateEnvironmentSpecificationAsStatements(
				ruleInvocation.getEnvironment(), b);
		
		if (isReferenced) {
			// if we're here, the RuleInvocation is used as a boolean expression
			ruleInvocation.declareFreshLocalVariable(b) [
				append(judgmentDescription.succeededMethodName().toString());
				append("(");
				generateEnvironmentSpecificationAsExpression(
					ruleInvocation.getEnvironment(), it);
				comma(it);
				append(ruleInvocation.additionalArgsForRuleInvocation().toString());
				comma(it);
				ruleInvocationArgumentsToJavaExpressions(it, ruleInvocation);
				append(")");				
			]
			
		} else {

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
			ruleInvocationArgumentsToJavaExpressions(b, ruleInvocation);
			b.append(");");
	
			if (hasOutputParams) {
				reassignResults(b, ruleInvocation, resultVariable);
			}
		
		}
	}

	def protected void ruleInvocationExpressionsToJavaStatements(ITreeAppendable b,
			List<XExpression> ruleInvocationExpressions) {
		for (ruleInvocationExpression : ruleInvocationExpressions) {
			toJavaStatement(ruleInvocationExpression, b, true);
		}
	}

	def protected void generateEnvironmentSpecificationAsStatements(
			XExpression environmentSpecification, ITreeAppendable b) {
				
		if (environmentSpecification instanceof EmptyEnvironment) {
			// already handled as expression
			return
		}
				
		if (environmentSpecification instanceof EnvironmentMapping) {
			toJavaStatement(environmentSpecification.getKey(), b, true);
			toJavaStatement(environmentSpecification.getValue(), b, true);
		} else if (environmentSpecification instanceof EnvironmentComposition) {
			generateEnvironmentSpecificationAsStatements(
					environmentSpecification.getCurrentEnvironment(), b);
			generateEnvironmentSpecificationAsStatements(
					environmentSpecification.getSubEnvironment(), b);
		} else {
			toJavaStatement(environmentSpecification, b, true);
		}
	}

	def void generateEnvironmentSpecificationAsExpression(
			XExpression environmentSpecification, ITreeAppendable b) {
		if (environmentSpecification instanceof EnvironmentMapping) {
			b.append(environmentEntryInvocation());
			b.append("(");
			toJavaExpression(environmentSpecification.getKey(), b);
			comma(b);
			toJavaExpression(environmentSpecification.getValue(), b);
			b.append(")");
		} else if (environmentSpecification instanceof EnvironmentComposition) {
			b.append(environmentCompositionInvocation());
			b.append("(");
			b.increaseIndentation();
			newLine(b);
			generateEnvironmentSpecificationAsExpression(
					environmentSpecification.getCurrentEnvironment(), b);
			comma(b);
			generateEnvironmentSpecificationAsExpression(
					environmentSpecification.getSubEnvironment(), b);
			b.decreaseIndentation();
			newLine(b);
			b.append(")");
		} else {
			toJavaExpression(environmentSpecification, b);
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

	def protected void ruleInvocationArgumentsToJavaExpressions(
			ITreeAppendable b, RuleInvocation ruleInvocation) {
		ruleInvocationArgumentsToJavaExpressions(b,
				ruleInvocation.inputArgsExpressions());
	}

	def protected void ruleInvocationArgumentsToJavaExpressions(
			ITreeAppendable b,
			Iterable<XExpression> inputArgsExpressions) {
		val expIt = inputArgsExpressions
				.iterator();
		while (expIt.hasNext()) {
			toJavaExpression(expIt.next(), b);
			if (expIt.hasNext())
				comma(b);
		}
	}

	def protected void reassignResults(ITreeAppendable b,
			RuleInvocation ruleInvocation, String resultVariable) {
		val expressions = ruleInvocation.outputArgsExpressions();
		
		newLine(b);
		val getMethods = XsemanticsGeneratorExtensions.getResultGetMethods().iterator();
		for (expression : expressions) {
			val expressionType = typeSystem.getType(
					expression);
			val getMethod = getMethods.next();

			b.append("checkAssignableTo");
			b.append("(");
			b.append(resultVariable + "." + getMethod);
			comma(b);
			generateJavaClassReference(expressionType, expression, b);
			b.append(");");
			newLine(b);

			// assignment with cast
			if (expression instanceof XVariableDeclaration) {
				// this is not contemplated by xbase compiler
				b.append(b.getName(expression));
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

	def dispatch void internalToConvertedExpression(RuleInvocation ruleInvocation,
			ITreeAppendable b) {
		b.append(ruleInvocation.getVarName(b))
	}

	def dispatch void internalToConvertedExpression(EmptyEnvironment e, ITreeAppendable b) {
		b.append(emptyEnvironmentInvocation());
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

	def void openBracket(ITreeAppendable b) {
		newLine(b);
		b.append("{");
		b.increaseIndentation();
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
		b.newLine();
		b.append(XsemanticsConstants.PREVIOUS_FAILURE + " = extractRuleFailedException("
			+ declareExceptionVariable + ");"
		);
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

	def boolean insideClosure(XExpression expr) {
		return expr.eContainer() instanceof XClosure;
	}

	def boolean insideCachedCondition(XExpression expr) {
		return expr.getContainerOfType(CachedClause) !== null
	}
}
