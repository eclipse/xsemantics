package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.typing.TupleType
import it.xsemantics.dsl.typing.XsemanticsSubtyping
import it.xsemantics.dsl.typing.XsemanticsTypeSystem
import it.xsemantics.dsl.xsemantics.JudgmentParameter
import it.xsemantics.dsl.xsemantics.XsemanticsFactory
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import java.util.ArrayList
import junit.framework.Assert
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsSubtypingTest extends XsemanticsBaseTest {
	
	@Inject
	protected XsemanticsTypeSystem typeSystem
	
	@Inject
	protected TypeReferences typeReferences
	
	@Inject
	protected XsemanticsSubtyping subtyping
	
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
		Assert::assertTrue
			(subtyping.isEObject
				(typeReferences.getTypeForName(typeof(XsemanticsSystem), ts), ts))
	}
	
	@Test
	def void testIsEObjectFails() {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		Assert::assertFalse
			(subtyping.isEObject
				(typeReferences.getTypeForName(typeof(String), ts), ts))
	}
	
	@Test
	def void testIsEStructuralFeature() {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		Assert::assertTrue
			(subtyping.isEStructuralFeature
				(typeReferences.getTypeForName(typeof(EAttribute), ts), ts))
	}
	
	@Test
	def void testIsEStructuralFeatureFails() {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		Assert::assertFalse
			(subtyping.isEStructuralFeature
				(typeReferences.getTypeForName(typeof(XsemanticsSystem), ts), ts))
	}
	
	@Test
	def void testTupleTypeDifferentSize() {
		val tupleType = new TupleType()
		tupleType.add(typeForName(typeof(EAttribute)))
		Assert::assertFalse(
			subtyping.isConformant(new ArrayList<JudgmentParameter>(), tupleType)
		)
	}
	
	@Test
	def void testTupleTypeTrue() {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		val tupleType = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(EClass), ts))
		val judgmentParameters = judgmentParameters(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(Notifier), ts))
		Assert::assertTrue(
			subtyping.isConformant(judgmentParameters, tupleType)
		)
	}
	
	@Test
	def void testTupleTypeFalse() {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		val tupleType = tupleType(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(Object), ts))
		val judgmentParameters = judgmentParameters(
			typeReferences.getTypeForName(typeof(EObject), ts),
			typeReferences.getTypeForName(typeof(Notifier), ts))
		Assert::assertFalse(
			subtyping.isConformant(judgmentParameters, tupleType)
		)
	}
	
	@Test
	def void testTupleTypeNotEqualsDifferentSize() {
		val tupleType = new TupleType()
		tupleType.add(typeForName(typeof(EAttribute)))
		Assert::assertFalse(
			subtyping.equals(new TupleType(), tupleType)
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
		Assert::assertTrue(
			subtyping.equals(tupleType2, tupleType1)
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
		Assert::assertFalse(
			subtyping.equals(tupleType2, tupleType1)
		)
	}
	
	def typeForName(Class clazz) {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		typeReferences.getTypeForName(clazz, ts)
	}
	
	def tupleType(JvmTypeReference c1, JvmTypeReference c2) {
		val tupleType = new TupleType()
		tupleType.add(c1)
		tupleType.add(c2)
		tupleType
	}
	
	def judgmentParameters(JvmTypeReference c1, JvmTypeReference c2) {
		val tupleType = new ArrayList<JudgmentParameter>()
		tupleType.add(c1.judgmentParameter)
		tupleType.add(c2.judgmentParameter)
		tupleType
	}
	
	def judgmentParameter(JvmTypeReference typeRef) {
		val judgmentParameter = XsemanticsFactory::eINSTANCE.createOutputParameter()
		judgmentParameter.jvmTypeReference = typeRef
		judgmentParameter
	}
	
	def assertSubtyping(Class expected, Class actual) {
		// getTypeForName requires an EObject context
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		Assert::assertTrue(subtyping.isConformant(
				typeReferences.getTypeForName(expected, ts),
				typeReferences.getTypeForName(actual, ts)
		))
	}
	
	def assertEquals(Class left, Class right, boolean expectedEquals) {
		val ts = testFiles.testRuleWithExpressionInConclusion.parse
		assertEquals(typeReferences.getTypeForName(left, ts),
				typeReferences.getTypeForName(right, ts), expectedEquals)
	}
	
	def assertEquals(JvmTypeReference left, JvmTypeReference right, boolean expectedEquals) {
		Assert::assertTrue(subtyping.equals(left, right) == expectedEquals)
	}

}