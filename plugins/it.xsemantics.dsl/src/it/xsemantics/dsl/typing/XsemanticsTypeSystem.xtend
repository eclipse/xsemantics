package it.xsemantics.dsl.typing

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.Rule
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer

class XsemanticsTypeSystem {
	
	@Inject
	private XbaseTypeConformanceComputer conformanceComputer
	
	@Inject
	private TypeReferences typeReferences
	
	@Inject
	private XsemanticsTypeSystemGen xsemanticsTypeSystemGen
	
	@Inject extension XsemanticsUtils
	
	def JvmTypeReference getType(EObject element) {
		xsemanticsTypeSystemGen.type(element).value
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
			val operationType = getType(expression);
			return conformanceComputer.isConformant(booleanType, operationType)
		}
	}
	
	def isExpressionToCheck(XExpression expression) {
		// don't consider boolean variable declaration and assignments and
		// if statements as boolean premises
		return (expression instanceof XFeatureCall) ||
			(expression instanceof XBinaryOperation) ||
			(expression instanceof XUnaryOperation) ||
			(expression instanceof XMemberFeatureCall) ||
			(expression instanceof XBooleanLiteral)
	}
}