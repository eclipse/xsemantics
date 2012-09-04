package it.xsemantics.dsl.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import it.xsemantics.dsl.xsemantics.XsemanticsPackage
import it.xsemantics.dsl.validation.IssueCodes

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsValidatorTest extends XsemanticsBaseTest {
	
	@Inject extension ValidationTestHelper
	
	@Test
	def void testCyclicHierarchy() {
		testFiles.testSystemBaseWithCycle.
			parseWithBaseSystem
			(testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore).
				parseWithBaseSystem
					(testFiles.testSystemBaseWithCycle2).
		assertError(
			XsemanticsPackage::eINSTANCE.xsemanticsSystem,
			IssueCodes::CYCLIC_HIERARCHY,
			"Cycle in extends relation"
		)
	}

	@Test
	def void testSystemExtendsWithValidatorExtends() {
		testFiles.testJudgmentDescriptions.parseWithBaseSystem(
			testFiles.testSystemExtendsWithValidatorExtends
		).
		assertError(
			XsemanticsPackage::eINSTANCE.xsemanticsSystem,
			IssueCodes::EXTENDS_CANNOT_COEXIST_WITH_VALIDATOR_EXTENDS,
			"system 'extends' cannot coexist with 'validatorExtends'"
		)
	}

	@Test
	def void testInvalidRuleOverrideWithoutSystemExtends() {
		val ts = testFiles.testInvalidRuleOverrideWithoutSystemExtends.parse
		ts.assertError(
			XsemanticsPackage::eINSTANCE.rule,
			IssueCodes::OVERRIDE_WITHOUT_SYSTEM_EXTENDS,
			"Cannot override rule without system 'extends'"
		)
		ts.assertError(
			XsemanticsPackage::eINSTANCE.checkRule,
			IssueCodes::OVERRIDE_WITHOUT_SYSTEM_EXTENDS,
			"Cannot override checkrule without system 'extends'"
		)
	}

	@Test
	def void testDuplicateRuleOfTheSameKindFromBaseSystem() {
		loadBaseSystems.
			parseWithBaseSystem(
				testFiles.testDuplicateRuleOfTheSameKindFromSuperSystem
			).
		assertError(
			XsemanticsPackage::eINSTANCE.rule,
			IssueCodes::DUPLICATE_RULE_WITH_SAME_ARGUMENTS,
			"Duplicate rule of the same kind with parameters: org.eclipse.emf.ecore.EObject, in system: it.xsemantics.test.ExtendedTypeSystem2"
		)
	}

	@Test
	def void testNoRuleOfTheSameKindToOverride() {
		loadBaseSystems.
			parseWithBaseSystem(
				testFiles.testNoRuleOfTheSameKindToOverride
			).
		assertError(
			XsemanticsPackage::eINSTANCE.rule,
			IssueCodes::NO_RULE_TO_OVERRIDE_OF_THE_SAME_KIND,
			"No rule of the same kind to override: org.eclipse.emf.ecore.EClass"
		)
	}
	
	@Test
	def void testOverrideRuleWithDifferentName() {
		loadBaseSystems.
			parseWithBaseSystem(
				testFiles.testOverrideRuleWithDifferentName
			).
		assertError(
			XsemanticsPackage::eINSTANCE.rule,
			IssueCodes::OVERRIDE_RULE_MUST_HAVE_THE_SAME_NAME,
			"Must have the same name of the rule to override: FromTypeSystem"
		)
	}

	@Test
	def void testNoCheckRuleToOverride() {
		val ts = loadBaseSystems.
			parseWithBaseSystem(
				testFiles.testNoCheckRuleToOverride
			)
		ts.assertError(
			XsemanticsPackage::eINSTANCE.checkRule,
			IssueCodes::NO_RULE_TO_OVERRIDE_OF_THE_SAME_KIND,
			"No checkrule to override: WrongCheckEObject"
		)
		ts.assertError(
			XsemanticsPackage::eINSTANCE.checkRule,
			IssueCodes::NO_RULE_TO_OVERRIDE_OF_THE_SAME_KIND,
			"No checkrule to override: CheckEObject"
		)
	}

	@Test
	def void testInvalidJudgmentWithTheSameNameOfBaseSystem() {
		loadBaseSystems.
			parseWithBaseSystem(
				testFiles.testInvalidJudgmentWithTheSameNameOfBaseSystem
			).
		assertError(
			XsemanticsPackage::eINSTANCE.judgmentDescription,
			IssueCodes::DUPLICATE_JUDGMENT_NAME,
			"Duplicate judgment 'type', in system: it.xsemantics.test.TypeSystem"
		)
	}

	@Test
	def void testInvalidJudgmentOverrideWithoutSystemExtends() {
		val ts = testFiles.testInvalidJudgmentOverrideWithoutSystemExtends.parse
		ts.assertError(
			XsemanticsPackage::eINSTANCE.judgmentDescription,
			IssueCodes::OVERRIDE_WITHOUT_SYSTEM_EXTENDS,
			"Cannot override judgment without system 'extends'"
		)
	}

	@Test
	def void testInvalidOverrideJudgment() {
		val ts = loadBaseSystems.
			parseWithBaseSystem(
				testFiles.testInvalidOverrideJudgment
			)
		ts.assertError(
			XsemanticsPackage::eINSTANCE.judgmentDescription,
			IssueCodes::NO_JUDGMENT_TO_OVERRIDE_OF_THE_SAME_KIND,
			"No judgment of the same kind to override: override type |- EObject obj : EClass c"
		)
		ts.assertError(
			XsemanticsPackage::eINSTANCE.judgmentDescription,
			IssueCodes::OVERRIDE_JUDGMENT_MUST_HAVE_THE_SAME_NAME,
			"Must have the same name of the judgment to override: subtype"
		)
	}

}