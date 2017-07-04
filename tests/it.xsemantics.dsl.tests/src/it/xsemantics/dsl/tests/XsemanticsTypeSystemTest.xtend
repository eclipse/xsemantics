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

package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.typing.TupleType
import it.xsemantics.dsl.typing.XsemanticsTypeSystem
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsTypeSystemTest extends XsemanticsBaseTest {
	
	@Inject
	protected XsemanticsTypeSystem typeSystem
	
	@Inject
	protected TypeReferences typeReferences
	
	@Test
	def void testRuleParameterTypes() {
		assertRuleConclusionTypes(testFiles.testSimpleRule, typeof(EClass), typeof(EObject))
	}
	
	@Test
	def void testRuleConclusionTypesWithExpressions() {
		assertRuleConclusionTypes(testFiles.testRuleWithExpressionInConclusion, typeof(EClass), typeof(EObject))
	}
	
	@Test
	def void testRuleInvocationExpressions() {
		assertRuleInvocationExpressionsTypes(testFiles.testRuleInvokingAnotherRule, 0, typeof(EClass), typeof(EClass))
	}
	
	@Test
	def void testBooleanBinaryOr() {
		checkBooleanPremise(getXAbstractFeatureCall(0))
	}
	
	@Test
	def void testBooleanBinaryAnd() {
		checkBooleanPremise(getXAbstractFeatureCall(1))
	}
	
	@Test
	def void testBooleanBinaryEquals() {
		checkBooleanPremise(getXAbstractFeatureCall(2))
	}
	
	@Test
	def void testBooleanBinaryNotEquals() {
		checkBooleanPremise(getXAbstractFeatureCall(3))
	}
	
	@Test
	def void testBooleanBinaryPlus() {
		checkNotBooleanPremise(getXAbstractFeatureCall(4))
	}
	
	@Test
	def void testBooleanMethodCall() {
		checkBooleanPremise(getXAbstractFeatureCall(5))
	}
	
	@Test
	def void testNotBooleanMethodCall() {
		checkNotBooleanPremise(getXAbstractFeatureCall(6))
	}
	
	@Test
	def void testBooleanNegation() {
		checkBooleanPremise(getXAbstractFeatureCall(7))
	}
	
	@Test
	def void testNotBooleanVariableDeclaration() {
		checkNotBooleanPremise(
			testFiles.testForBooleanVariableDeclaration.
				firstVariableDeclaration
		)
	}
	
	@Test
	def void testNotBooleanAssignment() {
		checkNotBooleanPremise(
			testFiles.testForNonBooleanPremises.firstAssignment
		)
	}
	
	@Test
	def void testNotBooleanIf() {
		checkNotBooleanPremise(
			testFiles.testForNonBooleanPremises.firstIf
		)
	}
	
	@Test
	def void testNotBooleanFor() {
		checkNotBooleanPremise(
			testFiles.testForNonBooleanPremises.firstFor
		)
	}
	
	@Test
	def void testStandardXVariableDeclaration() {
		assertPremiseType(
			testFiles.testRuleWithFeatureCallsForBinaryOps, 8,
			"org.eclipse.emf.ecore.EClass")
	}

	@Test
	def void testExpressionInConclusion() {
		assertEObjectType(
			testFiles.testAxiomWithExpressionInConclusion.
				getRuleWithoutValidation(0).
					expressionInConclusion(0),
			"org.eclipse.emf.ecore.EClass"
		)
	}

	@Test
	def void testInputParameter() {
		assertEObjectType(
			testFiles.testSimpleRule.
				firstJudgmentDescription.judgmentParameters.head,
			"org.eclipse.emf.ecore.EClass"
		)
	}

	@Test
	def void testOutputParameter() {
		assertEObjectType(
			testFiles.testJudgmentDescriptionsReferringToEcoreWithOutput.
				firstJudgmentDescription.judgmentParameters.get(1),
			"org.eclipse.emf.ecore.EObject"
		)
	}

	@Test
	def void testEObjectSubtyping() {
		assertSubtyping(typeof(Notifier), typeof(EObject))
	}
	
	@Test
	def void testObjectSubtyping() {
		assertSubtyping(typeof(Object), typeof(EObject))
	}
	
	@Test
	def void testNotEquals() {
		assertEquals(typeof(Notifier), typeof(EObject), false)
	}
	
	@Test
	def void testEquals() {
		assertEquals(typeof(EObject), typeof(EObject), true)
	}
	
	@Test
	def void testIsEObject() {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		assertTrue
			(typeSystem.isEObject
				(typeReferences.getTypeForName(typeof(XsemanticsSystem), ts), ts))
	}
	
	@Test
	def void testIsEObjectFails() {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		assertFalse
			(typeSystem.isEObject
				(typeReferences.getTypeForName(typeof(String), ts), ts))
	}
	
	@Test
	def void testIsEStructuralFeature() {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		assertTrue
			(typeSystem.isEStructuralFeature
				(typeReferences.getTypeForName(typeof(EAttribute), ts), ts))
	}
	
	@Test
	def void testIsEStructuralFeatureFails() {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		assertFalse
			(typeSystem.isEStructuralFeature
				(typeReferences.getTypeForName(typeof(XsemanticsSystem), ts), ts))
	}
	
	@Test
	def void testTupleTypeNotEqualsDifferentSize() {
		val tupleType = new TupleType()
		tupleType.add(typeForName(typeof(EAttribute)))
		assertFalse(
			typeSystem.equals(new TupleType(), tupleType)
		)
	}
	
	@Test
	def void testTupleTypeEquals() {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		val tupleType1 = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(EClass), ts))
		val tupleType2 = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(EClass), ts))
		assertTrue(
			typeSystem.equals(tupleType2, tupleType1)
		)
	}

	@Test
	def void testTupleTypeEqualsWithNull() {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		val tupleType1 = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(EClass), ts))
		assertFalse(
			typeSystem.equals(tupleType1, null)
		)
	}

	@Test
	def void testTupleTypeEqualsWithANonTupleType() {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		val tupleType1 = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(EClass), ts))
		assertFalse(
			tupleType1.equals("foo")
		)
	}

	@Test
	def void testTupleTypeEqualsWithDifferentSize() {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		val tupleType1 = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(EClass), ts))
		val tupleType2 = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts))
		assertFalse(
			typeSystem.equals(tupleType1, tupleType2)
		)
	}

	@Test
	def void testTupleTypeNotEquals() {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		val tupleType1 = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(EClass), ts))
		val tupleType2 = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(Notifier), ts))
		assertFalse(
			typeSystem.equals(tupleType2, tupleType1)
		)
	}

	@Test
	def testJudgmentDescriptionsEquals() {
		val judgments =	testFiles.testForJudgmentParameters.
				parseAndAssertNoError.judgmentDescriptions
		assertTrue(typeSystem.equals(judgments.get(0), judgments.get(1)))
		assertFalse(typeSystem.equals(judgments.get(0), judgments.get(2)))
		assertFalse(typeSystem.equals(judgments.get(0), judgments.get(3)))
	}

	@Test
	def testAuxiliaryDescriptionsEquals() {
		val aux =	testFiles.testForAuxiliaryDescriptionEquals.
				parseAndAssertNoError.auxiliaryDescriptions
		assertTrue(typeSystem.equals(aux.get(0), aux.get(1)))
		assertFalse(typeSystem.equals(aux.get(0), aux.get(2)))
		assertFalse(typeSystem.equals(aux.get(0), aux.get(3)))
	}
	
	@Test
	def void testPredicateJudgments() {
		testFiles.testPredicateJudgments.parseAndAssertNoError => [
			typeSystem.isPredicate(judgmentDescriptions.head).assertFalse
			typeSystem.isPredicate(judgmentDescriptions.last).assertTrue
			
			typeSystem.isPredicate(
				getRule(1).ruleInvocationFromPremises
			).assertFalse
			
			typeSystem.isPredicate(
				getRule(0).ruleInvocationFromPremises
			).assertTrue
		]
	}

	@Test
	def void testHashCodeOfTupleType() {
		testFiles.testDuplicateAuxiliaryFunctionsWithSameParameterTypes_Issue_9.
		parseAndValidate.auxiliaryFunctions => [
			assertEquals(
				typeSystem.getInputTypes(head).hashCode,
				typeSystem.getInputTypes(last).hashCode
			)
		]
	}

	@Test
	def void testHashCodeOfTupleTypeWithUnresolvedTypes() {
		testFiles.testForUnresolvedTypeTypeReferences.
		parseAndValidate.auxiliaryFunctions => [
			assertEquals(
				typeSystem.getInputTypes(head).hashCode,
				typeSystem.getInputTypes(last).hashCode
			)
		]
	}
	
	def checkBooleanPremise(XAbstractFeatureCall featureCall) {
		assertTrue(featureCall.toString,
			typeSystem.isBooleanPremise(featureCall)
		)
	}
	
	def checkNotBooleanPremise(XExpression expression) {
		assertFalse(expression.toString,
			typeSystem.isBooleanPremise(expression)
		)
	}
	
	def void assertRuleConclusionTypes(CharSequence source, Class<?> leftClass, Class<?> rightClass) {
		val conclusion = source.getFirstRule.conclusion
		assertEquals(leftClass.name, 
			typeSystem.getType(conclusion.conclusionElements.get(0)).identifier
		)
		assertEquals(rightClass.name, 
			typeSystem.getType(conclusion.conclusionElements.get(1)).identifier
		)
	}
	
	def void assertRuleInvocationExpressionsTypes(CharSequence source, int index, Class<?> leftClass, Class<?> rightClass) {
		val invocation = source.firstRule.ruleInvocations.get(index)
		assertEquals(leftClass.name, typeSystem.getType(invocation.expressions.get(0)).identifier)
		assertEquals(rightClass.name, typeSystem.getType(invocation.expressions.get(1)).identifier)
	}

	def assertPremiseType(CharSequence prog, int premiseIndex, CharSequence expected) {
		prog.getRuleWithoutValidation(0).getPremise(premiseIndex).
			assertEObjectType(expected)
	}

	def assertEObjectType(EObject o, CharSequence expected) {
		val type = typeSystem.getType(o)
		assertEqualsStrings(expected, type.identifier)
	}
	
	def typeForName(Class<?> clazz) {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		typeReferences.getTypeForName(clazz, ts)
	}
	
	def tupleType(JvmTypeReference... c) {
		new TupleType() => [addAll(c)]
	}
	
	def assertSubtyping(Class<?> expected, Class<?> actual) {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		assertTrue(typeSystem.isConformant(
				typeReferences.getTypeForName(expected, ts),
				typeReferences.getTypeForName(actual, ts),
				ts
		))
	}
	
	def assertEquals(Class<?> left, Class<?> right, boolean expectedEquals) {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		assertEquals(typeReferences.getTypeForName(left, ts),
				typeReferences.getTypeForName(right, ts), 
				expectedEquals, ts)
	}
	
	def assertEquals(JvmTypeReference left, JvmTypeReference right, 
			boolean expectedEquals, EObject context) {
		assertTrue(typeSystem.equals(left, right, context) == expectedEquals)
	}
	
}