package it.xsemantics.dsl.typing

import com.google.inject.Singleton
import it.xsemantics.dsl.xsemantics.EnvironmentAccess
import it.xsemantics.dsl.xsemantics.Fail
import it.xsemantics.dsl.xsemantics.OrExpression
import it.xsemantics.dsl.xsemantics.RuleInvocation
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState

/**
 * Custom version of type computer for Custom XExpressions
 * introduced by Xsemantics
 */
@Singleton
class XsemanticsTypeComputer extends XbaseWithAnnotationsTypeComputer {
	
	override computeTypes(XExpression expression, ITypeComputationState state) {
		switch (expression) {
			RuleInvocation: expression._computeTypes(state)
			OrExpression: expression._computeTypes(state)
			Fail: expression._computeTypes(state)
			EnvironmentAccess: expression._computeTypes(state)
			default: super.computeTypes(expression, state)
		}
	}
	
	protected def _computeTypes(RuleInvocation e, ITypeComputationState state) {
		e.expressions.forEach[
			it.expression.computeTypes(state)
		]
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