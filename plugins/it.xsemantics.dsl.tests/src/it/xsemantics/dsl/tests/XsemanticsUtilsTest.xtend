package it.xsemantics.dsl.tests

import com.google.common.collect.Lists
import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import java.util.List
import junit.framework.Assert
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsUtilsTest extends XsemanticsBaseTest {
	
	@Inject extension XsemanticsUtils
	
	@Inject XsemanticsNodeModelUtils nodeModelUtils
	
	@Test
	def void testJudgmentDescriptions() {
		val descriptions = 
			parser.parse(testFiles.testJudgmentDescriptionsWithDuplicateSymbols).
				getJudgmentDescriptions('|-', ':')
		Assert::assertEquals(2, descriptions.size)
	}

	@Test
	def void testRuleJudgmentDescription() {
		assertDescription(testFiles.
			testSimpleRule.
				firstRule.judgmentDescription, "|-", ":"
		)
	}
	
	@Test
	def void testRuleInvocationJudgmentDescription() {
		assertDescription(testFiles.testRuleInvokingAnotherRule.
			parseAndAssertNoError.ruleInvocations.get(0).judgmentDescription, "|-", ":")
	}
	
	@Test
	def void testRuleWithoutDescription() {
		val description = testFiles.
			testRuleWithoutJudgmentDescription.
				getRuleWithoutValidation(1).judgmentDescription
		Assert::assertNull(description)
	}
	
	@Test
	def void testJudgmentDescriptionWithoutRules() {
		Assert::assertTrue(
			testFiles.testJudgmentDescriptions.
				firstJudgmentDescription.rulesForJudgmentDescription.empty
		)
	}
	
	@Test
	def void testJudgmentDescriptionWithRules() {
		Assert::assertEquals(2,
			testFiles.testRulesOfTheSameKind.
				firstJudgmentDescription.rulesForJudgmentDescription.size
		)
	}
	
	@Test
	def void testAllRulesOfTheSameKind() {
		val ts = testFiles.testRulesOfTheSameKind.parseAndAssertNoError
		ts.getRules.get(0).allRulesOfTheSameKind.assertRules(ts.getRules.get(0), ts.getRules.get(1))
		ts.getRules.get(2).allRulesOfTheSameKind.assertRules(ts.getRules.get(2), ts.getRules.get(3))
	}
	
	@Test
	def void testOutputParamsEmpty() {
		Assert::assertEquals(0, 
			testFiles.testJudgmentDescriptionsReferringToEcore3.parseAndAssertNoError.
			getJudgmentDescriptions.get(0).outputJudgmentParameters.size())
	}
	
	@Test
	def void testInputParamsForJudgmentDescription() {
		Assert::assertEquals(3, 
			testFiles.testJudgmentDescriptionsReferringToEcore3.parseAndAssertNoError.
			getJudgmentDescriptions.get(0).inputParams.size())
	}
	
	@Test
	def void testInputParamsForRuleInPresenceOfExpressionInConclusion() {
		Assert::assertEquals(1, 
			testFiles.testRuleWithExpressionInConclusion.firstRule.
			inputParams.size())
	}
	
	@Test
	def void testInputParamsForRuleWithoutExpressionInConclusion() {
		Assert::assertEquals(2, 
			testFiles.testRuleWithOutputParams.firstRule.
			inputParams.size())
	}
	
	@Test
	def void testInputEObjectParams() {
		Assert::assertEquals(2, 
			testFiles.testRuleWithOutputParams.firstRule.
			inputEObjectParams.size())
	}
	
	@Test
	def void testInputEObjectParamsWithNonEObjects() {
		Assert::assertEquals(1, 
			testFiles.testRulesWithNonEObjectParams.firstRule.
			inputEObjectParams.size())
	}
	
	@Test
	def void testOutputParamsNotEmpty() {
		Assert::assertEquals(1, 
			testFiles.testJudgmentDescriptionsReferringToEcore3WithOutput.parseAndAssertNoError.
			getJudgmentDescriptions.get(0).outputJudgmentParameters.size())
	}
	
	@Test
	def void testOutputJudgmentParametersForRule() {
		Assert::assertEquals(1, 
			testFiles.testRuleWithOutputParams.firstRule.
			outputJudgmentParameters.size())
	}
	
	@Test
	def void testOutputParamsNotEmptyForRule() {
		Assert::assertTrue(testFiles.testRuleWithOutputParams.firstRule.
			hasOutputParams)
	}
	
	@Test
	def void testOutputParamsEmptyForRule() {
		Assert::assertFalse(testFiles.testSimpleRule.firstRule.
			hasOutputParams)
	}
	
	@Test
	def void testOutputParamsForRule() {
		Assert::assertEquals(1, 
			testFiles.testRuleWithOutputParams.firstRule.
			outputParams.size())
	}
	
	@Test
	def void testIsInputParam() {
		Assert::assertTrue(testFiles.testSimpleRule.firstRule.
			ruleParameterByName("object").inputParam)
	}
	
	@Test
	def void testIsNotInputParam() {
		Assert::assertFalse(testFiles.testRuleWithOutputParams.firstRule.
			ruleParameterByName("object").inputParam)
	}
	
	@Test
	def void testIsInputJvmParam() {
		Assert::assertTrue(testFiles.testSimpleRule.firstRule.
			ruleParameterByName("object").parameter.inputParam)
	}
	
	@Test
	def void testIsNotInputJvmParam() {
		Assert::assertFalse(testFiles.testRuleWithOutputParams.firstRule.
			ruleParameterByName("object").parameter.inputParam)
	}
	
	@Test
	def void testOutputParamsForRuleInvocation() {
		Assert::assertEquals(1, 
			testFiles.testRuleWithOutputParams.parseAndAssertNoError.
			ruleInvocations.get(0).
			outputParams.size())
	}
	
	@Test
	def void testOuputArg() {
		val ruleInvocation = testFiles.testRuleInvokingAnotherRule.firstRule.
			ruleInvocations.get(0)
		val outputArgs = ruleInvocation.outputArgsExpressions
		Assert::assertEquals(0, outputArgs.size)
	}
	
	@Test
	def void testOuputArg2() {
		val ruleInvocation = testFiles.testRuleInvokingAnotherRule.firstRule.
			ruleInvocations.get(1)
		val outputArgs = ruleInvocation.outputArgsExpressions
		Assert::assertEquals(0, outputArgs.size)
	}
	
	@Test
	def void testInputArgs() {
		val ruleInvocation = testFiles.testRuleInvokingAnotherRule.firstRule.
			ruleInvocations.get(0)
		val inputArgs = ruleInvocation.inputArgsExpressions
		Assert::assertEquals(2, inputArgs.size)
	}

	@Test
	def void testInputArgsWithOutputParams() {
		val ruleInvocation = testFiles.testRuleWithOutputParams.firstRule.
			ruleInvocations.get(0)
		val inputArgs = ruleInvocation.inputArgsExpressions
		Assert::assertEquals(2, inputArgs.size)
		Assert::assertEquals(ruleInvocation.expressions.get(0), inputArgs.get(0))
		Assert::assertEquals(ruleInvocation.expressions.get(2), inputArgs.get(1))
	}
	
	@Test
	def void testOutputArgsWithOutputParams() {
		val ruleInvocation = testFiles.testRuleWithOutputParams.firstRule.
			ruleInvocations.get(0)
		val inputArgs = ruleInvocation.outputArgsExpressions
		Assert::assertEquals(1, inputArgs.size)
		Assert::assertEquals(ruleInvocation.expressions.get(1), inputArgs.get(0))
	}
	
	@Test
	def void testOutputConclusionElements() {
		val rule = testFiles.testRuleWithOutputParams.firstRule
		val outputConclusionElements = rule.outputConclusionElements
		Assert::assertEquals(1, outputConclusionElements.size)
		Assert::assertEquals(rule.conclusion.conclusionElements.get(1),
			outputConclusionElements.get(0)
		)
	}
	
	@Test
	def void testIterateIfThenElse() {
		val stringList = 'a,B,c'.split(',').toList
		val toUpper = newArrayList()
		val toLower = newArrayList()
		stringList.iterateIfThenElse(
			[ it.toLowerCase.equals(it) ],
			[ toLower += it ],
			[ toUpper += it ]
		)
		Assert::assertEquals("[a, c]", toLower.toString)
		Assert::assertEquals("[B]", toUpper.toString)
	}
	
	@Test
	def void testOutputConclusionElementsWithoutOutputParams() {
		val rule = testFiles.testSimpleRule.firstRule
		val outputConclusionElements = rule.outputConclusionElements
		Assert::assertEquals(0, outputConclusionElements.size)
	}

	@Test
	def void testOriginalSystemDefinition() {
		systemExtendsSystemWithJudgments.
				superSystem.
				originalSystemDefinition.
				name.assertEqualsStrings('it.xsemantics.test.TypeSystem')
	}

	@Test
	def void testSuperSystemDefinition() {
		systemExtendsSystemWithJudgments.
				superSystemDefinition.
				name.assertEqualsStrings('it.xsemantics.test.TypeSystem')
	}

	@Test
	def void testSuperSystemDefinitionWithNoSuperSystem() {
		Assert::assertNull(testFiles.testSimpleRule.parseAndAssertNoError.
				superSystemDefinition)
	}

	@Test
	def void testAllSuperSystemDefinitions() {
		systemExtendsSystemWithJudgments.
				allSuperSystemDefinitions.
				head.name.
				assertEqualsStrings('it.xsemantics.test.TypeSystem')
	}

	@Test
	def void testAllSuperSystemDefinitions2() {
		val superSystems = systemExtendsExtendedTypeSystem.
				allSuperSystemDefinitions
		Assert::assertEquals(2, superSystems.size)
		superSystems.get(0).name.
				assertEqualsStrings('it.xsemantics.test.ExtendedTypeSystem')
		superSystems.get(1).name.
				assertEqualsStrings('it.xsemantics.test.TypeSystem')
	}

	@Test
	def void testAllSuperSystemDefinitionsWithCycle() {
		val superSystems = testFiles.testSystemBaseWithCycle.
			parseWithBaseSystem
			(testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore).
				parseWithBaseSystem(testFiles.testSystemExtendsExtendedTypeSystem).
					allSuperSystemDefinitions
		// due to the cycle the initial type system appears twice
		Assert::assertEquals(3, superSystems.size)
	}

	@Test
	def void testAllSuperSystemDefinitionsWithNoSuperSystem() {
		Assert::assertEquals(0, testFiles.testSimpleRule.parseAndAssertNoError.
				allSuperSystemDefinitions.size)
	}

	@Test
	def void testSuperSystemJudgments() {
		Assert::assertEquals(1, systemExtendsSystemWithJudgments.
				superSystemJudgments.size)
	}

	@Test
	def void testAllJudgments() {
		systemExtendsSystemWithAdditionalJudgment.
				allJudgments.assertJudgments(
'''
it.xsemantics.test.ExtendedTypeSystem subtype |- EClass c1 <: EClass c2
it.xsemantics.test.TypeSystem type |- EObject c : output EClass error "this " + c + " made an error!" source c feature c.eClass.eContainingFeature
'''					
				)
	}

	@Test
	def void testAllJudgments2() {
		systemExtendsExtendedTypeSystem.
				allJudgments.assertJudgments(
'''
it.xsemantics.test.ExtendedTypeSystem2 type2 ||- EClass c1 : EClass c2
it.xsemantics.test.ExtendedTypeSystem subtype |- EClass c1 <: EClass c2
it.xsemantics.test.TypeSystem type |- EObject c : output EClass error "this " + c + " made an error!" source c feature c.eClass.eContainingFeature
'''					
				)
	}

	@Test
	def void testAllJudgmentsWithOverride() {
		systemExtendsSystemWithJudgmentOverride.
				allJudgments.assertJudgments(
'''
it.xsemantics.test.ExtendedTypeSystemWithJudgmentOverride override type |- EObject obj : output EClass
it.xsemantics.test.ExtendedTypeSystemWithJudgmentOverride override subtype |- EClass c1 <: EClass c2 error stringRep(c1) + " not <: " + stringRep(c2) source c1 feature c1.eClass.eContainingFeature
it.xsemantics.test.ExtendedTypeSystem2 type2 ||- EClass c1 : EClass c2
it.xsemantics.test.ExtendedTypeSystem subtype |- EClass c1 <: EClass c2
it.xsemantics.test.TypeSystem type |- EObject c : output EClass error "this " + c + " made an error!" source c feature c.eClass.eContainingFeature
'''					
				)
	}

	@Test
	def void testSuperSystemJudgmentsWithNoSuperSystem() {
		Assert::assertEquals(0, 
				testFiles.testSimpleRule.parseAndAssertNoError.
				superSystemJudgments.size)
	}

	@Test
	def void testRuleJudgmentDescriptionInherited() {
		val ts = systemExtendsExtendedTypeSystem
		assertDescription(ts.getRule(0).judgmentDescription, "|-", ":")
		assertDescription(ts.getRule(1).judgmentDescription, "|-", "<:")
		assertDescription(ts.getRule(2).judgmentDescription, "||-", ":")
	}

	@Test
	def void testRuleInvocationJudgmentDescriptionInherited() {
		val ts = systemExtendsExtendedTypeSystem
		assertDescription
			(ts.getRule(0).ruleInvocationFromPremises.judgmentDescription,
				"|-", "<:")
		assertDescription
			(ts.getRule(1).ruleInvocationFromPremises.judgmentDescription,
				"||-", ":")
		assertDescription
			(ts.getRule(2).ruleInvocationFromPremises.judgmentDescription,
				"|-", ":")
	}

	@Test
	def void testAllRules() {
		Assert::assertEquals(6, systemExtendsSystemWithRuleOverride.
				allRules.size)
	}

	@Test
	def void testAllRulesByJudgmentDescription() {
		Assert::assertEquals(2, systemExtendsSystemWithRuleOverride.
				allRulesByJudgmentDescription("|-", Lists::newArrayList(":")).
					size)
	}

	@Test
	def void testCheckAllRules() {
		Assert::assertEquals(2, systemExtendsSystemWithRuleOverride.
				allCheckRules.size)
	}

	def void assertRules(List<Rule> rules, Rule expectedRule1, Rule expectedRule2) {
		Assert::assertEquals(2, rules.size)
		Assert::assertEquals(expectedRule1, rules.get(0))
		Assert::assertEquals(expectedRule2, rules.get(1))
	}
	
	def void assertDescription(JudgmentDescription description, String judgmentSymbol, String relationSymbol) {
		Assert::assertNotNull("judgment description is null", description)
		Assert::assertEquals(judgmentSymbol, description.judgmentSymbol)
		Assert::assertEquals(relationSymbol, description.relationSymbols.get(0))
	}
	
	def List<JudgmentDescription> getJudgmentDescriptions(XsemanticsSystem ts, String judgmentSymbol, String relationSymbol) {
		Lists::newArrayList(filterJudgmentDescriptions(ts, judgmentSymbol, 
			Lists::newArrayList(relationSymbol)
		))
	}

	def assertJudgments(List<JudgmentDescription> judgments, CharSequence expected) {
		expected.assertEqualsStrings(
			judgments.map[ 
				it.containingSystem.name + " " +
				nodeModelUtils.getProgramText(it)
			].join('\n') + '\n')
	}
}