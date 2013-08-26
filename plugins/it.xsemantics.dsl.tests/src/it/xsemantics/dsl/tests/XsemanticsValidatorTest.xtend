package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.validation.IssueCodes
import it.xsemantics.dsl.xsemantics.XsemanticsPackage
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.junit.Test
import org.junit.runner.RunWith

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
			"Duplicate rule of the same kind with parameters: EObject, in system: it.xsemantics.test.ExtendedTypeSystem2"
		)
	}

	@Test
	def void testDuplicateRuleOfTheSameKindFromSuperSystemButWithDifferentName() {
		loadBaseSystems.
			parseWithBaseSystem(
				testFiles.testDuplicateRuleOfTheSameKindFromSuperSystemButWithDifferentName
			).
		assertError(
			XsemanticsPackage::eINSTANCE.rule,
			IssueCodes::DUPLICATE_RULE_WITH_SAME_ARGUMENTS,
			"Duplicate rule of the same kind with parameters: EObject, in system: it.xsemantics.test.ExtendedTypeSystem2"
		)
	}

	@Test
	def void testDuplicateCheckRuleOfTheSameKindFromBaseSystem() {
		loadBaseSystems.
			parseWithBaseSystem(
				testFiles.testDuplicateCheckRuleOfTheSameKindFromSuperSystem
			).
		assertError(
			XsemanticsPackage::eINSTANCE.checkRule,
			IssueCodes::DUPLICATE_RULE_NAME,
			"Duplicate checkrule with the same name, in system: it.xsemantics.test.ExtendedTypeSystem2"
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
			"No rule of the same kind to override: EClass"
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

	@Test
	def testNoRuleForJudgmentDescriptionOverridden() {
		systemExtendsSystemWithJudgmentOverride.
			assertNoIssues
	}

	@Test
	def testDuplicateAuxiliaryDescriptions() {
		parser.parse(testFiles.testDuplicateAuxiliaryDescriptions).
		assertError(
			XsemanticsPackage::eINSTANCE.auxiliaryDescription,
			IssueCodes::DUPLICATE_AUXILIARY_NAME,
			"Duplicate auxiliary description 'foo'"
		)
	}

	@Test
	def testAuxiliaryFunctionWithWrongReturnExpression() {
		parser.parse(testFiles.testAuxiliaryFunctionWithWrongReturnExpression).
			assertError(
			XbasePackage::eINSTANCE.XMemberFeatureCall,
			org.eclipse.xtext.xbase.validation.IssueCodes::INCOMPATIBLE_TYPES,
			"Type mismatch: cannot convert from EClass to Boolean"
		)
	}

	@Test
	def testAuxiliaryDescriptionWithTheSameNameOfJudgment() {
		parser.parse(testFiles.testAuxiliaryDescriptionWithTheSameNameOfJudgment).
			assertError(
			XsemanticsPackage::eINSTANCE.auxiliaryDescription,
			IssueCodes::DUPLICATE_AUXILIARY_NAME,
			"Duplicate judgment with the same name 'foo'"
		)
	}

	@Test
	def testAuxiliaryFunctionWithoutAuxiliaryDescription() {
		parser.parse(testFiles.testAuxiliaryFunctionWithoutAuxiliaryDescription).
			assertError(
			XsemanticsPackage::eINSTANCE.auxiliaryFunction,
			IssueCodes::NO_AUXDESC_FOR_AUX_FUNCTION,
			"No auxiliary description for auxiliary function 'foobar'"
		)
	}

	@Test
	def testNonConformantAuxiliaryFunction() {
		val s = parser.parse(testFiles.testNonConformantAuxiliaryFunction)
		s.assertError(
			XsemanticsPackage::eINSTANCE.auxiliaryFunction,
			IssueCodes::PARAMS_SIZE_DONT_MATCH,
			"expected 1 parameter(s), but was 2"
		)
		s.assertError(
			TypesPackage::eINSTANCE.jvmFormalParameter,
			IssueCodes::NOT_SUBTYPE,
			"parameter type EObject is not subtype of AuxiliaryDescription declared type EClass"
		)
	}

	@Test
	def testInvalidRuleInvocationIsVoidInClosures() {
		val s = parser.parse(testFiles.testRuleInvocationIsVoidInClosures)
		s.assertError(
			XsemanticsPackage::eINSTANCE.ruleInvocation,
			org.eclipse.xtext.xbase.validation.IssueCodes::INCOMPATIBLE_TYPES,
			"Type mismatch: cannot convert from void to Boolean"
		)
	}

	@Test
	def void testAccessToVarInsideClosure() {
		parser.parse(testFiles
				.testAccessToVarInsideClosure()).
		assertError(
			XbasePackage::eINSTANCE.XFeatureCall,
			org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS,
			"Cannot refer to the non-final variable s inside a lambda expression"
		)
	}

	@Test
	def void testVarDeclInRuleInvokationShadowsPreviousVariable() {
		parser.parse(testFiles
				.testVarDeclInRuleInvokationShadowsPreviousVariable()).
		assertError(
			XbasePackage::eINSTANCE.XVariableDeclaration,
			org.eclipse.xtext.xbase.validation.IssueCodes.VARIABLE_NAME_SHADOWING,
			"Duplicate local variable s"
		)
	}

	@Test
	def void testDuplicateParamNamesInRule() {
		parser.parse(testFiles
				.testDuplicateParamsInRule()).
		assertError(
			XsemanticsPackage::eINSTANCE.ruleParameter,
			org.eclipse.xtext.xbase.validation.IssueCodes.VARIABLE_NAME_SHADOWING,
			"Duplicate local variable eClass"
		)
	}


}