package it.xsemantics.dsl.typing

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.OutputParameter
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression
import it.xsemantics.dsl.xsemantics.RuleParameter
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer

class XsemanticsTypingSystem {
	
	@Inject
	protected ITypeProvider typeProvider
	
	@Inject
	private XbaseTypeConformanceComputer conformanceComputer
	
	@Inject
	private TypeReferences typeReferences
	
	@Inject extension XsemanticsUtils
	
	def JvmTypeReference getType(EObject element) {
		switch element {
			ExpressionInConclusion: typeProvider.getType(element.expression)
			RuleParameter: element.parameter.parameterType
			RuleInvocationExpression: typeProvider.getType(element.expression)
			InputParameter: element.parameter.parameterType
			OutputParameter: element.jvmTypeReference
			XExpression: typeProvider.getType(element)
			default: null
		}
	}
	
	def TupleType getInputTypes(Rule rule) {
		val tupleType = new TupleType();
		rule.inputParams.forEach [
			tupleType.add(it.getType)
		]
		return tupleType;
	}
	
	def isBooleanPremise(XExpression expression) {
		if (!expression.expressionToCheck) {
			return false;
		} else {
			val booleanType = typeReferences.getTypeForName(Boolean::TYPE, expression);
			val operationType = typeProvider.getType(expression);
			return conformanceComputer.isConformant(booleanType, operationType)
		}
	}
	
	def isExpressionToCheck(XExpression expression) {
		// don't consider boolean variable declaration and assignments and
		// if statements as boolean premises
		return (expression instanceof XFeatureCall) ||
			(expression instanceof XBinaryOperation) ||
			(expression instanceof XUnaryOperation) ||
			(expression instanceof XMemberFeatureCall)
	}
}