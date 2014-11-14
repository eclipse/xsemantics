package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.xsemantics.XsemanticsPackage
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.diagnostics.Severity
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import static it.xsemantics.dsl.validation.XsemanticsValidator.*

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
			CYCLIC_HIERARCHY,
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
			EXTENDS_CANNOT_COEXIST_WITH_VALIDATOR_EXTENDS,
			"system 'extends' cannot coexist with 'validatorExtends'"
		)
	}

	@Test
	def void testInvalidRuleOverrideWithoutSystemExtends() {
		val ts = testFiles.testInvalidRuleOverrideWithoutSystemExtends.parse
		ts.assertError(
			XsemanticsPackage::eINSTANCE.rule,
			OVERRIDE_WITHOUT_SYSTEM_EXTENDS,
			"Cannot override rule without system 'extends'"
		)
		ts.assertError(
			XsemanticsPackage::eINSTANCE.checkRule,
			OVERRIDE_WITHOUT_SYSTEM_EXTENDS,
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
			DUPLICATE_RULE_WITH_SAME_ARGUMENTS,
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
			DUPLICATE_RULE_WITH_SAME_ARGUMENTS,
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
			MUST_OVERRIDE,
			"checkrule 'CheckEObject' must override checkrule, in system: it.xsemantics.test.ExtendedTypeSystem2"
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
			NOTHING_TO_OVERRIDE,
			"No rule to override: FromTypeSystem"
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
			NOTHING_TO_OVERRIDE,
			"No rule to override: DifferentName"
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
			NOTHING_TO_OVERRIDE,
			"No checkrule to override: WrongCheckEObject"
		)
		ts.assertError(
			XsemanticsPackage::eINSTANCE.checkRule,
			NOTHING_TO_OVERRIDE,
			"No checkrule to override: CheckEObject"
		)
	}

	@Test
	def void testInvalidJudgmentWithTheSameNameOfBaseSystem() {
		loadBaseSystems.
			parseWithBaseSystem(
				testFiles.testInvalidJudgmentWithTheSameNameOfBaseSystem
			).
		assertErrorMessages(
'''
judgment 'type' must override judgment, in system: it.xsemantics.test.TypeSystem
'''	
		)
	}

	@Test
	def void testInvalidJudgmentOverrideWithoutSystemExtends() {
		val ts = testFiles.testInvalidOverrideWithoutSystemExtends.parse
		ts.assertError(
			XsemanticsPackage.eINSTANCE.judgmentDescription,
			OVERRIDE_WITHOUT_SYSTEM_EXTENDS,
			"Cannot override judgment without system 'extends'"
		)
		ts.assertError(
			XsemanticsPackage.eINSTANCE.auxiliaryDescription,
			OVERRIDE_WITHOUT_SYSTEM_EXTENDS,
			"Cannot override auxiliary description without system 'extends'"
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
			NOTHING_TO_OVERRIDE,
			"No judgment to override: type"
		)
		ts.assertError(
			XsemanticsPackage::eINSTANCE.judgmentDescription,
			NOTHING_TO_OVERRIDE,
			"No judgment to override: subtype2"
		)
	}

	@Test
	def void testWrongAuxiliaryDescriptionOverride() {
		val ts = testFiles.testAuxiliaryDescriptions.
			parseWithBaseSystem(
				testFiles.testWrongAuxiliaryDescriptionOverride
			)
		ts.assertError(
			XsemanticsPackage.eINSTANCE.auxiliaryDescription,
			MUST_OVERRIDE,
			"auxiliary description 'isValue' must override auxiliary description, in system: it.xsemantics.test.TypeSystem"
		)
		ts.assertError(
			XsemanticsPackage.eINSTANCE.auxiliaryDescription,
			NOTHING_TO_OVERRIDE,
			"No auxiliary description to override: voidFun"
		)
		ts.assertError(
			XsemanticsPackage.eINSTANCE.auxiliaryDescription,
			NOTHING_TO_OVERRIDE,
			"No auxiliary description to override: objectClass"
		)
	}

	@Test
	def testNoRuleForJudgmentDescriptionOverridden() {
		systemExtendsSystemWithJudgmentOverride.
			assertNoIssues
	}

	@Test
	def testDuplicateAuxiliaryDescriptions() {
		testFiles.testDuplicateAuxiliaryDescriptions.
		assertErrorMessages(
'''
Duplicate name 'foo' (AuxiliaryDescription)
Duplicate name 'foo' (AuxiliaryDescription)
'''
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
		testFiles.testAuxiliaryDescriptionWithTheSameNameOfJudgment.
		assertErrorMessages(
'''
Duplicate name 'foo' (JudgmentDescription)
Duplicate name 'foo' (AuxiliaryDescription)
'''
		)
	}

	@Test
	def testAuxiliaryFunctionWithoutAuxiliaryDescription() {
		parser.parse(testFiles.testAuxiliaryFunctionWithoutAuxiliaryDescription).
			assertError(
			XsemanticsPackage::eINSTANCE.auxiliaryFunction,
			NO_AUXDESC_FOR_AUX_FUNCTION,
			"No auxiliary description for auxiliary function 'foobar'"
		)
	}

	@Test
	def testNonConformantAuxiliaryFunction() {
		val s = parser.parse(testFiles.testNonConformantAuxiliaryFunction)
		s.assertError(
			XsemanticsPackage::eINSTANCE.auxiliaryFunction,
			PARAMS_SIZE_DONT_MATCH,
			"expected 1 parameter(s), but was 2"
		)
		s.assertError(
			TypesPackage::eINSTANCE.jvmFormalParameter,
			NOT_SUBTYPE,
			"parameter type EObject is not subtype of AuxiliaryDescription declared type EClass"
		)
	}

	@Test
	def testDuplicateAuxiliaryFunctionsWithSameParameterTypes_Issue_9() {
		val s = parser.parse(testFiles.testDuplicateAuxiliaryFunctionsWithSameParameterTypes_Issue_9)
		s.assertError(
			XsemanticsPackage.eINSTANCE.auxiliaryFunction,
			DUPLICATE_AUXFUN_WITH_SAME_ARGUMENTS,
			"Duplicate auxiliary function of the same kind with parameters: EClass, EClass"
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
	def testInvalidRuleInvocationIsNotOfExpectedType() {
		val s = parser.parse(testFiles.testInvalidRuleInvocationIsNotOfExpectedType)
		s.assertError(
			XsemanticsPackage::eINSTANCE.ruleInvocation,
			org.eclipse.xtext.xbase.validation.IssueCodes::INCOMPATIBLE_TYPES,
			"Type mismatch: cannot convert from boolean to Integer"
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

	@Test
	def void testVisibilityForVarDeclInRuleInvocation() {
		parser.parse(testFiles
				.testVisibilityForVarDeclInRuleInvocation()).
		assertError(
			XbasePackage::eINSTANCE.XFeatureCall,
			Diagnostic::LINKING_DIAGNOSTIC,
			"Couldn't resolve reference to JvmIdentifiableElement 'cc'"
		)
	}

	@Test
	def void testDuplicateInjectedFields() {
		testFiles.testSystemWithDuplicateInjections.
		assertErrorMessages(
'''
Duplicate name 'strings' (Injected)
Duplicate name 'strings' (Injected)
'''
		)
	}

	@Test
	def void testWrongEnvironmentXExpression() {
		parser.parse(testFiles.testWrongEnvironmentXExpression).
		assertError(
			XbasePackage::eINSTANCE.XStringLiteral,
			org.eclipse.xtext.xbase.validation.IssueCodes::INCOMPATIBLE_TYPES,
			"Type mismatch: cannot convert from String to RuleEnvironment"
		)
	}

	@Test
	def void testWrongEnvironmentXExpression2() {
		parser.parse(testFiles.testWrongEnvironmentXExpression2).
		assertError(
			XbasePackage::eINSTANCE.XStringLiteral,
			org.eclipse.xtext.xbase.validation.IssueCodes::INCOMPATIBLE_TYPES,
			"Type mismatch: cannot convert from String to RuleEnvironment"
		)
	}

	@Test
	def void testErrorSpecificationFeatureNotEStructuralFeature() {
		parser.parse(testFiles.testErrorSpecificationFeatureNotEStructuralFeature).
		assertError(
			XbasePackage::eINSTANCE.XMemberFeatureCall,
			org.eclipse.xtext.xbase.validation.IssueCodes::INCOMPATIBLE_TYPES,
			"Type mismatch: cannot convert from EClass to EStructuralFeature"
		)
	}

	@Test
	def void testErrorSpecificationSourceNotEObject() {
		parser.parse(testFiles.testErrorSpecificationSourceNotEObject).
		assertError(
			XbasePackage::eINSTANCE.XMemberFeatureCall,
			org.eclipse.xtext.xbase.validation.IssueCodes::INCOMPATIBLE_TYPES,
			"Type mismatch: cannot convert from String to EObject"
		)
	}

	@Test
	def void testJudgmentDescriptionsWithDuplicates() {
		testFiles.testJudgmentDescriptionsWithDuplicates.
			assertErrorMessages(
'''
Duplicate name 'type' (JudgmentDescription)
Duplicate name 'type' (JudgmentDescription)
Duplicate name 'type' (JudgmentDescription)
'''
			)
	}

	@Test
	def void testDuplicateRuleNames() {
		testFiles.testDuplicateRuleNames.
			assertErrorMessages(
'''
Duplicate name 'Foo' (Axiom)
Duplicate name 'Foo' (Axiom)
'''
			)
	}

	@Test
	def void testDuplicateRuleNames2() {
		testFiles.testDuplicateRuleNames2.
			assertErrorMessages(
'''
Duplicate name 'Foo' (Axiom)
Duplicate name 'Foo' (RuleWithPremises)
'''
			)
	}

	@Test
	def void testDuplicateCheckRuleNames() {
		testFiles.testDuplicateCheckRuleNames().
			assertErrorMessages(
'''
Duplicate name 'Foo' (CheckRule)
Duplicate name 'Foo' (CheckRule)
'''
			)
	}

	@Test
	def void testDuplicateRuleAndCheckRuleNames() {
		testFiles.testDuplicateRuleAndCheckRuleNames().
			assertErrorMessages(
'''
Duplicate name 'Foo' (Axiom)
Duplicate name 'Foo' (CheckRule)
'''
			)
	}

	@Test
	def void testDuplicateParamNamesInJudgmentDescription() {
		testFiles.testDuplicateParamsInJudgmentDescription().
			assertErrorMessages(
'''
Duplicate name 'eClass' (InputParameter)
Duplicate name 'eClass' (InputParameter)
'''
			)
	}

	@Test
	def void testRulesOfTheSameKindWithSameArgumentTypes() {
		testFiles.testRulesOfTheSameKindWithSameArgumentTypes.
		assertErrorMessages(
'''
Duplicate rule of the same kind with parameters: Object, Integer, in system: it.xsemantics.test.TypeSystem
Duplicate rule of the same kind with parameters: Object, Integer, in system: it.xsemantics.test.TypeSystem
'''			
		)
	}

	@Test
	def void testAuxiliaryDescriptionsWithNoInputParam() {
		testFiles.testAuxiliaryDescriptionsWithNoInputParam.
			assertErrorMessages(
'''
No input parameter; at least one is needed
'''
			)
	}

	@Test
	def void testInvalidUseOfPrimitiveTypes_Issue_17() {
		testFiles.typeInvalidUseOfPrimitiveTypes_Issue_17.
			assertErrorMessages(
'''
Primitives cannot be used in this context.
Primitives cannot be used in this context.
Primitives cannot be used in this context.
'''
			)
	}

	@Test
	def void testCorrectUseOfPrimitiveTypes_Issue_17() {
		testFiles.typeCorrectUseOfPrimitiveTypes_Issue_17.
			parseAndAssertNoError
	}

	@Test
	def void testCorrectReturnInAuxiliaryFunctions_Issue_18() {
		testFiles.testCorrectReturnInAuxFunction_Issue_18.
			parseAndAssertNoError
	}

	@Test
	def void testAccessToPreviousFailureInOrExpression() {
		testFiles.testOrExpressionsAccessingPreviousFailure.parseAndAssertNoError
	}

	@Test
	def void testWrongAccessToPreviousFailureInFirstOrBranch() {
		'''
		«testFiles.typeSystemQualifiedName»
		
		import org.eclipse.emf.ecore.EClass
		import org.eclipse.emf.ecore.EObject
		
		judgments {
			type |- EClass c : EObject o
		}
		
		rule EClassEObject derives
			G |- EClass eClass : EObject object
		from {
			{
				// previousFailure is not available in the first branch
				println(previousFailure)
			}
			or
			{
				eClass.name == 'bar1'
			}
		}
		'''.assertErrorMessages(
			"Couldn't resolve reference to JvmIdentifiableElement 'previousFailure'."
		)
	}

	@Test
	def void testWrongWriteAccessToPreviousFailure() {
		'''
		«testFiles.typeSystemQualifiedName»
		
		import org.eclipse.emf.ecore.EClass
		import org.eclipse.emf.ecore.EObject
		
		judgments {
			type |- EClass c : EObject o
		}
		
		rule EClassEObject derives
			G |- EClass eClass : EObject object
		from {
			{
				eClass.name == 'bar1'
			}
			or
			{
				previousFailure = null
			}
		}
		'''.assertErrorMessages(
			"Assignment to final variable"
		)
	}

	@Test
	def void testWrongPreviousFailureVariableDeclaration() {
		'''
		«testFiles.typeSystemQualifiedName»
		
		import org.eclipse.emf.ecore.EClass
		import org.eclipse.emf.ecore.EObject
		
		judgments {
			type |- EClass c : EObject o
		}
		
		rule EClassEObject derives
			G |- EClass eClass : EObject object
		from {
			val previousFailure = 'test'
			{
				eClass.name == 'bar1'
			}
			or
			{
				println(previousFailure)
			}
		}
		'''.assertErrorMessages(
		'''
		Duplicate local variable previousFailure
		previousFailure is a reserved name'''
		)
	}

	def private assertErrorMessages(CharSequence input, CharSequence expected) {
		parse(input).assertErrorMessages(expected)
	}

	def private assertErrorMessages(XsemanticsSystem system, CharSequence expected) {
		expected.toString.trim.assertEqualsStrings(
			system.validate.filter[severity == Severity.ERROR].
				map[message].join("\n")
		)
	}

}
