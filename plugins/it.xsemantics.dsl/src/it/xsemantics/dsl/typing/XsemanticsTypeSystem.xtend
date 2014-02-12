package it.xsemantics.dsl.typing

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.JudgmentParameter
import it.xsemantics.dsl.xsemantics.Rule
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
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.XInstanceOfExpression
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction

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
	
	def equals(TupleType tupleType1, TupleType tupleType2, EObject context) {
//		if (tupleType1.size() != tupleType2.size())
//			return false;
//		val judgmentParametersIt = tupleType1.iterator();
//		for (JvmTypeReference jvmTypeReference : tupleType2) {
//			if (!equals(judgmentParametersIt.next(), jvmTypeReference, context))
//				return false;
//		}
		return tupleType1.equals(tupleType2);
	}

	def equals(JudgmentDescription j1, JudgmentDescription j2) {
		if (j1.judgmentParameters.size != j2.judgmentParameters.size)
			return false
		val judgmentParametersIt = j1.judgmentParameters.iterator();
		for (JudgmentParameter jParam2 : j2.judgmentParameters) {
			val jParam1 = judgmentParametersIt.next()
			if (jParam1.eClass != jParam2.eClass ||
					!equals(getType(jParam1), getType(jParam2), jParam1))
				return false;
		}
		return true;
	}
	
	def equals(JvmTypeReference t1, JvmTypeReference t2, EObject context) {
		//isConformant(t1, t2, context) && isConformant(t2, t1, context);
		if (t1 == null)
			return t2 == null
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
		val converter = new OwnedConverter
			(new StandardTypeReferenceOwner(services, context))
		converter.toLightweightReference(typeRef)
	}

	def isPredicate(JudgmentDescription j) {
		if (j == null)
			return false
		j.outputJudgmentParameters.empty
	}

	def isPredicate(RuleInvocation ruleInvocation) {
		ruleInvocation.orSetJudgmentDescription.predicate
	}
}