package it.xsemantics.dsl.typing

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XInstanceOfExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

class XsemanticsTypeSystem {
	
	@Inject
	private CommonTypeComputationServices services
	
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
		for (p : rule.inputParams)
			tupleType.add(p.getType)
		
		return tupleType;
	}

	def TupleType getInputTypes(AuxiliaryFunction aux) {
		val tupleType = new TupleType();
		for (p : aux.parameters)
			tupleType.add(p.getType)
		
		return tupleType;
	}
	
	def equals(TupleType tupleType1, TupleType tupleType2) {
		return tupleType1.equals(tupleType2);
	}

	def equals(JudgmentDescription j1, JudgmentDescription j2) {
		if (j1.judgmentParameters.size != j2.judgmentParameters.size)
			return false
		val judgmentParametersIt = j1.judgmentParameters.iterator();
		for (jParam2 : j2.judgmentParameters) {
			val jParam1 = judgmentParametersIt.next()
			if (jParam1.eClass != jParam2.eClass ||
					!equals(getType(jParam1), getType(jParam2), jParam1))
				return false;
		}
		return true;
	}

	def equals(AuxiliaryDescription aux1, AuxiliaryDescription aux2) {
		if (aux1.parameters.size != aux2.parameters.size)
			return false
		if (!equals(aux1.type, aux2.type, aux1))
			return false
		val paramIt = aux1.parameters.iterator();
		for (param2 : aux2.parameters) {
			val param1 = paramIt.next()
			if (param1.eClass != param2.eClass ||
					!equals(getType(param1), getType(param2), param1))
				return false;
		}
		return true;
	}
	
	def equals(JvmTypeReference t1, JvmTypeReference t2, EObject context) {
		//isConformant(t1, t2, context) && isConformant(t2, t1, context);
		if (t1 === null)
			return t2 === null
		if (t2 === null)
			return t1 === null
		return t1.type.equals(t2.type)
	}
	
	def isConformant(JvmTypeReference expected,
			JvmTypeReference actual, EObject context) {
		actual.isSubtype(expected, context)
	}
	
	def isEObject(JvmTypeReference type, EObject context) {
		isConformant(
				typeReferences.getTypeForName(typeof(EObject), context), 
				type, context);
	}

	def isAbstractDeclarativeValidator(JvmTypeReference type, EObject context) {
		isConformant(
				typeReferences.getTypeForName(typeof(AbstractDeclarativeValidator), context),
				type, context);
	}
	
	def isEStructuralFeature(JvmTypeReference type, EObject context) {
		isConformant(typeReferences.getTypeForName(
				typeof(EStructuralFeature), context),
				type, context);
	}
	
	def isValidSuperSystem(JvmTypeReference type, EObject context) {
		isConformant(typeReferences.getTypeForName(
				typeof(XsemanticsRuntimeSystem), context),
				type, context);
	}
	
	def isBooleanPremise(XExpression expression) {
		if (!expression.expressionToCheck) {
			return false;
		} else {
			val booleanType = typeReferences.getTypeForName(Boolean::TYPE, expression);
			val operationType = getType(expression);
			return operationType.isSubtype(booleanType, expression)
		}
	}
	
	def isExpressionToCheck(XExpression expression) {
		// don't consider boolean variable declaration and assignments and
		// if statements as boolean premises
		return (expression instanceof XFeatureCall) ||
			(expression instanceof XBinaryOperation) ||
			(expression instanceof XUnaryOperation) ||
			(expression instanceof XMemberFeatureCall) ||
			(expression instanceof XBooleanLiteral) ||
			(expression instanceof XInstanceOfExpression)
	}

	def isSubtype(JvmTypeReference t1, JvmTypeReference t2, EObject context) {
		if (t1 == null || t2 == null)
			return false

		val type1 = t1.toLightweightTypeReference(context)
		val type2 = t2.toLightweightTypeReference(context)
		type2.isAssignableFrom(type1)
	}
	
	def toLightweightTypeReference(JvmTypeReference typeRef, EObject context) {
		return newTypeReferenceOwner(context).toLightweightTypeReference(typeRef)
	}

	def protected newTypeReferenceOwner(EObject context) {
		return new StandardTypeReferenceOwner(services, context);
	}

	def isPredicate(JudgmentDescription j) {
		if (j == null)
			return false
		j.outputJudgmentParameters.empty
	}

	def isPredicate(RuleInvocation ruleInvocation) {
		ruleInvocation.getJudgmentDescription.predicate
	}
}