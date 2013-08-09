package it.xsemantics.dsl.typing

import com.google.inject.Inject
import com.google.inject.Singleton
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.EnvironmentAccess
import it.xsemantics.dsl.xsemantics.Fail
import it.xsemantics.dsl.xsemantics.OrExpression
import it.xsemantics.dsl.xsemantics.RuleInvocation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference
import it.xsemantics.dsl.xsemantics.Rule

/**
 * Custom version of type computer for Custom XExpressions
 * introduced by Xsemantics
 */
@Singleton
class XsemanticsTypeComputer extends XbaseWithAnnotationsTypeComputer {
	
	@Inject extension XsemanticsUtils
	
	override computeTypes(XExpression expression, ITypeComputationState state) {
		switch (expression) {
			RuleInvocation: expression._computeTypes(state)
			OrExpression: expression._computeTypes(state)
			Fail: expression._computeTypes(state)
			EnvironmentAccess: expression._computeTypes(state)
			default: super.computeTypes(expression, state)
		}
	}
	
	override void _computeTypes(XBlockExpression b, ITypeComputationState typeState) {
		var state = typeState
		
		if (b.eContainer instanceof Rule) {
			val rule = b.eContainer as Rule

			// the premises block should not be checked against
			// return type
			state = state.withoutRootExpectation
			
			for (expInConcl : rule.expressionsInConclusion) {
				expInConcl.expression.computeTypes(state)
			}
		}
		
		if (b.eContainer instanceof RuleWithPremises) {
			val rule = b.eContainer as RuleWithPremises

			for (outputParam : rule.outputParams) {
				// insert the output parameter in the scope
				state.addLocalToCurrentScope(outputParam.parameter)				
			}
		}
		
		//super._computeTypes(b, state)
		
		// this is copied (and translated to Xtend) from the base class
		for (expectation: state.getExpectations()) {
			val expectedType = expectation.getExpectedType();
			if (expectedType != null && expectedType.isPrimitiveVoid()) {
				val expressions = b.getExpressions();
				if (!expressions.isEmpty()) {
					for(XExpression expression: expressions) {
						val expressionState = state.withoutExpectation(); // no expectation
						expressionState.computeTypes(expression);
						expression.addVariableDeclarationsToScope(state);
					}
				}
				expectation.acceptActualType(getPrimitiveVoid(state), ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
			} else {
				val expressions = b.getExpressions();
				if (!expressions.isEmpty()) {
					for(XExpression expression: expressions.subList(0, expressions.size() - 1)) {
						val expressionState = state.withoutExpectation();
						expressionState.computeTypes(expression);
						expression.addVariableDeclarationsToScope(state);
					}
					val lastExpression = IterableExtensions.last(expressions);
					state.computeTypes(lastExpression);
					// add the last expression to the scope, too in order validate for duplicate names, even
					// though the variable declaration could be removed automatically to keep only the side effect
					// of the initializer
					lastExpression.addVariableDeclarationsToScope(state);
				} else {
					expectation.acceptActualType(new AnyTypeReference(expectation.getReferenceOwner()), ConformanceHint.UNCHECKED);
				}
			}
		}
	}
	
	protected def void addVariableDeclarationsToScope(XExpression e, ITypeComputationState state) {
		switch (e) {
			XVariableDeclaration : addLocalToCurrentScope(e, state)
			RuleInvocation : {
				for (exp : e.expressions) {
					if (exp instanceof XVariableDeclaration) {
						addLocalToCurrentScope(exp as XVariableDeclaration, state);
					}
				}
			}
		}
	}
	
	protected def _computeTypes(RuleInvocation e, ITypeComputationState state) {
		for(expression: e.expressions) {
			val expressionState = state.withoutExpectation();
			expressionState.computeTypes(expression);
		}
		state.acceptActualType(getPrimitiveVoid(state))
	}

	protected def _computeTypes(OrExpression e, ITypeComputationState state) {
		e.branches.forEach[
			it.computeTypes(state)
		]
		state.acceptActualType(getPrimitiveVoid(state))
	}

	protected def _computeTypes(Fail e, ITypeComputationState state) {
		e.error => [
			error?.computeTypes(state)
			source?.computeTypes(state)
			feature?.computeTypes(state)
		]
		state.acceptActualType(getPrimitiveVoid(state))
	}
	
	protected def _computeTypes(EnvironmentAccess exp, ITypeComputationState state) {
		state.acceptActualType(state.converter.
			toLightweightReference(exp.type))
	}
}