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
	
	override void _computeTypes(XBlockExpression b, ITypeComputationState state) {
		if (b.eContainer instanceof RuleWithPremises) {
			val rule = b.eContainer as RuleWithPremises

			for (outputParam : rule.outputParams) {
				// insert the output parameter in the scope
				state.addLocalToCurrentScope(outputParam.parameter)				
			}

			super._computeTypes(b, state.withoutRootExpectation)
		} else {
			super._computeTypes(b, state)
		}
	}
	
	protected def _computeTypes(RuleInvocation e, ITypeComputationState state) {
		for (ruleInvkExp : e.expressions) {
			ruleInvkExp.expression.computeTypes(state)
		}
//		for (varDecl : e.variableDeclarations) {
//			addLocalToCurrentScope(varDecl, state)
//		}
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