package it.xsemantics.dsl.typing

import com.google.inject.Inject
import com.google.inject.Singleton
import it.xsemantics.dsl.XsemanticsConstants
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.EmptyEnvironment
import it.xsemantics.dsl.xsemantics.EnvironmentComposition
import it.xsemantics.dsl.xsemantics.EnvironmentMapping
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import it.xsemantics.dsl.xsemantics.Fail
import it.xsemantics.dsl.xsemantics.OrExpression
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import it.xsemantics.runtime.RuleEnvironment
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference

/**
 * Custom version of type computer for Custom XExpressions
 * introduced by Xsemantics
 */
@Singleton
class XsemanticsTypeComputer extends XbaseWithAnnotationsTypeComputer {
	
	@Inject extension XsemanticsUtils
	
	@Inject extension XsemanticsTypeSystem
	
	override computeTypes(XExpression expression, ITypeComputationState state) {
		switch (expression) {
			RuleInvocation: expression._computeTypes(state)
			OrExpression: expression._computeTypes(state)
			Fail: expression._computeTypes(state)
			ErrorSpecification: expression._computeTypes(state)
			default: super.computeTypes(expression, state)
		}
	}
	
	override void _computeTypes(XBlockExpression b, ITypeComputationState typeState) {
		var state = typeState
		
		if (b.eContainer instanceof Rule ||
				b.eContainer instanceof CheckRule) {
			// the premises block should not be checked against
			// return type
			state = state.withoutRootExpectation
		}
		
		if (b.eContainer instanceof AuxiliaryFunction) {
			val aux = b.eContainer as AuxiliaryFunction
			val type = aux.getAuxiliaryDescription?.type
			
			// if the return type is null we assume boolean
			// and we must not check it
			if (type === null)
				state = state.withExpectation(state.getPrimitiveVoid)
			// we will adjust the boolean result in the compiler
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
			if (expectedType !== null && expectedType.isPrimitiveVoid()) {
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
						addLocalToCurrentScope(exp, state);
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
		e.environment.handleEnvironmentSpecification(
			state.withExpectation(getTypeForName(RuleEnvironment, state))
		)
		if (state.hasTypeExpectations && e.isPredicate)
			state.acceptActualType(getTypeForName(Boolean.TYPE, state))
		else
			state.acceptActualType(getPrimitiveVoid(state))
	}

	protected def hasTypeExpectations(ITypeComputationState state) {
		!state.expectations.empty
	}

	protected def _computeTypes(OrExpression e, ITypeComputationState state) {
		var firstBranch = true
		for (b : e.branches) {
			var s = state.withoutExpectation
			
			// make sure to avoid adding the same variable if it's already in scope
			// and avoid adding it for the first or branch (not already contained in
			// an or branch)
			if (!firstBranch && e.eContainer.containingOrExpression === null) {
				val implicitVar = XbaseFactory.eINSTANCE.createXVariableDeclaration => [
					writeable = false
					name = XsemanticsConstants.PREVIOUS_FAILURE
					// setting the declared type won't work
					// type = ruleFailedExceptionType(e)
				]
				// the element must be in a resource
				e.eResource.contents += implicitVar
				// and assign a type to it (this will also add it to the scope)
				s = s.assignType(
					implicitVar,
					ruleFailedExceptionType(e).toLightweightTypeReference(e)
				)
			}
			firstBranch = false
			b.computeTypes(s)
		}
		
		state.acceptActualType(getPrimitiveVoid(state))
	}
	
	protected def dispatch void handleEnvironmentSpecification(EmptyEnvironment e, ITypeComputationState state) {
		state.acceptActualType(getTypeForName(RuleEnvironment, state))
	}

	protected def dispatch void handleEnvironmentSpecification(EnvironmentComposition e, ITypeComputationState state) {
		e.currentEnvironment.handleEnvironmentSpecification(state)
		e.subEnvironment.handleEnvironmentSpecification(state)
	}

	protected def dispatch void handleEnvironmentSpecification(EnvironmentMapping e, ITypeComputationState state) {
		// in Xbase 2.6 we must call computeTypes on the state, not use the computeTypes(XExpression, ITypeComputationState)
		// otherwise XStringLiteral compilation will then raise a NPE
//		e.key.computeTypes(state.withNonVoidExpectation)
//		e.value.computeTypes(state.withNonVoidExpectation)
		state.withNonVoidExpectation.computeTypes(e.key)
		state.withNonVoidExpectation.computeTypes(e.value)
	}

	protected def dispatch void handleEnvironmentSpecification(XExpression e, ITypeComputationState state) {
		state.computeTypes(e)
	}

	protected def _computeTypes(Fail e, ITypeComputationState state) {
		e.error?.computeTypes(state)
		state.acceptActualType(getPrimitiveVoid(state))
	}

	protected def _computeTypes(ErrorSpecification e, ITypeComputationState state) {
		if (e.error !== null)
			state.withExpectation(getTypeForName(String, state)).computeTypes(e.error)
		if (e.source !== null)
			state.withExpectation(getTypeForName(EObject, state)).computeTypes(e.source)
		if (e.feature !== null)
			state.withExpectation(getTypeForName(EStructuralFeature, state)).computeTypes(e.feature)
		if (e.data !== null)
			state.withNonVoidExpectation.computeTypes(e.data)
		// in Xbase 2.6 we must call computeTypes on the state, not use the computeTypes(XExpression, ITypeComputationState)
		// otherwise XStringLiteral compilation will then raise a NPE
//		e.error?.computeTypes(state.withExpectation(getTypeForName(String, state)))
//		e.source?.computeTypes
//			(state.withExpectation(getTypeForName(EObject, state)))
//		e.feature?.computeTypes
//			(state.withExpectation(getTypeForName(EStructuralFeature, state)))
		state.acceptActualType(getPrimitiveVoid(state))
	}
	
}