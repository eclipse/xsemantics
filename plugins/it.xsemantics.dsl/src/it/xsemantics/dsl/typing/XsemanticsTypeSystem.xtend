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
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.validation.AbstractDeclarativeValidator

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
	
	def equals(TupleType tupleType1, TupleType tupleType2) {
		if (tupleType1.size() != tupleType2.size())
			return false;
		val judgmentParametersIt = tupleType1.iterator();
		for (JvmTypeReference jvmTypeReference : tupleType2) {
			if (!equals(judgmentParametersIt.next(), jvmTypeReference))
				return false;
		}
		return true;
	}
	
	def equals(JvmTypeReference t1, JvmTypeReference t2) {
		isConformant(t1, t2) && isConformant(t2, t1);
	}
	
	def isConformant(JvmTypeReference expected,
			JvmTypeReference actual) {
		conformanceComputer.isConformant(expected, actual);
	}
	
	def isEObject(JvmTypeReference type, EObject context) {
		isConformant(
				typeReferences.getTypeForName(typeof(EObject), context), type);
	}

	def isAbstractDeclarativeValidator(JvmTypeReference type, EObject context) {
		isConformant(
				typeReferences.getTypeForName(typeof(AbstractDeclarativeValidator), context), type);
	}
	
	def isEStructuralFeature(JvmTypeReference type, EObject context) {
		isConformant(typeReferences.getTypeForName(
				typeof(EStructuralFeature), context), type);
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