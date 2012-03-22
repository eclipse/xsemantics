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

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsUtilsTest extends XsemanticsBaseTest {
	
	@Inject extension XsemanticsUtils
	
	@Test
	def void testJudgmentDescriptions() {
		val descriptions = 
			parser.parse(testFiles.testJudgmentDescriptionsWithDuplicateSymbols).
				getJudgmentDescriptions('|-', ':')
		Assert::assertEquals(2, descriptions.size)
	}

	@Test
	def void testRuleDescription() {
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
	def void testRulesOfTheSameKind() {
		val ts = testFiles.testRulesOfTheSameKind.parseAndAssertNoError
		ts.getRules.get(0).rulesOfTheSameKind.assertRules(ts.getRules.get(0), ts.getRules.get(1))
		ts.getRules.get(2).rulesOfTheSameKind.assertRules(ts.getRules.get(2), ts.getRules.get(3))
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
	
	def void assertRules(List<Rule> rules, Rule expectedRule1, Rule expectedRule2) {
		Assert::assertEquals(2, rules.size)
		Assert::assertEquals(expectedRule1, rules.get(0))
		Assert::assertEquals(expectedRule2, rules.get(1))
	}
	
	def void assertDescription(JudgmentDescription description, String judgmentSymbol, String relationSymbol) {
		Assert::assertNotNull(description)
		Assert::assertEquals(judgmentSymbol, description.judgmentSymbol)
		Assert::assertEquals(relationSymbol, description.relationSymbols.get(0))
	}
	
	def List<JudgmentDescription> getJudgmentDescriptions(XsemanticsSystem ts, String judgmentSymbol, String relationSymbol) {
		Lists::newArrayList(filterJudgmentDescriptions(ts, judgmentSymbol, 
			Lists::newArrayList(relationSymbol)
		))
	}
}