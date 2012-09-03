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
}