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

import com.google.common.collect.Lists
import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.OutputParameter
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import java.util.List
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsUtilsTest extends XsemanticsBaseTest {
	
	@Inject extension XsemanticsUtils
	
	@Inject XsemanticsNodeModelUtils nodeModelUtils
	
	@Test
	def void testRuleJudgmentDescription() {
		assertDescription(testFiles.
			testSimpleRule.
				firstRule.getJudgmentDescription, "|-", ":"
		)
	}
	
	@Test
	def void testRuleInvocationJudgmentDescription() {
		assertDescription(testFiles.testRuleInvokingAnotherRule.
			parseAndAssertNoError.ruleInvocations.get(0).getJudgmentDescription, "|-", ":")
	}
	
	@Test
	def void testRuleWithoutDescription() {
		val description = testFiles.
			testRuleWithoutJudgmentDescription.
				getRuleWithoutValidation(1).getJudgmentDescription
		assertNull(description)
	}
	
	@Test
	def void testJudgmentDescriptionWithoutRules() {
		assertTrue(
			testFiles.testJudgmentDescriptions.
				firstJudgmentDescription.rulesForJudgmentDescription.empty
		)
	}
	
	@Test
	def void testJudgmentDescriptionWithRules() {
		assertEquals(2,
			testFiles.testRulesOfTheSameKind.
				firstJudgmentDescription.rulesForJudgmentDescription.size
		)
	}
	
	@Test
	def void testAllRulesOfTheSameKind() {
		val ts = testFiles.testRulesOfTheSameKind.parseAndAssertNoError
		ts.getRules.get(0) => [
			ts.allRulesByJudgmentDescription(conclusion.judgmentSymbol, conclusion.relationSymbols).
				assertRules(ts.getRules.get(0), ts.getRules.get(1))
		]
		ts.getRules.get(2) => [
			ts.allRulesByJudgmentDescription(conclusion.judgmentSymbol, conclusion.relationSymbols)
				.assertRules(ts.getRules.get(2), ts.getRules.get(3))
		]
	}
	
	@Test
	def void testOutputParamsEmpty() {
		assertEquals(0, 
			testFiles.testJudgmentDescriptionsReferringToEcore3.parseAndAssertNoError.
			getJudgmentDescriptions.get(0).outputJudgmentParameters.size())
	}
	
	@Test
	def void testInputParamsForJudgmentDescription() {
		assertEquals(3, 
			testFiles.testJudgmentDescriptionsReferringToEcore3.parseAndAssertNoError.
			getJudgmentDescriptions.get(0).inputParams.size())
	}
	
	@Test
	def void testInputParamsForRuleInPresenceOfExpressionInConclusion() {
		assertEquals(1, 
			testFiles.testRuleWithExpressionInConclusion.firstRule.
			inputParams.size())
	}
	
	@Test
	def void testInputParamsForRuleWithoutExpressionInConclusion() {
		assertEquals(2, 
			testFiles.testRuleWithOutputParams.firstRule.
			inputParams.size())
	}
	
	@Test
	def void testOutputParamsNotEmpty() {
		assertEquals(1, 
			testFiles.testJudgmentDescriptionsReferringToEcore3WithOutput.parseAndAssertNoError.
			getJudgmentDescriptions.get(0).outputJudgmentParameters.size())
	}
	
	@Test
	def void testOutputJudgmentParametersForRule() {
		assertEquals(1, 
			testFiles.testRuleWithOutputParams.firstRule.
			outputJudgmentParameters.size())
	}
	
	@Test
	def void testOutputParamsNotEmptyForRule() {
		assertTrue(testFiles.testRuleWithOutputParams.firstRule.
			hasOutputParams)
	}
	
	@Test
	def void testOutputParamsEmptyForRule() {
		assertFalse(testFiles.testSimpleRule.firstRule.
			hasOutputParams)
	}
	
	@Test
	def void testOutputParamsForRule() {
		assertEquals(1, 
			testFiles.testRuleWithOutputParams.firstRule.
			outputParams.size())
	}

	@Test
	def void testOutputParamsForRuleWithoutJudgmentDescriptionEmpty() {
		assertEquals(0, 
			'''
			system test
			judgments {
				type |- Object o : Object o1
			}
			axiom Foo G |- String s
			'''.getRuleWithoutValidation(0).
			outputParams.size())
	}
	
	@Test
	def void testIsInputParam() {
		assertTrue(testFiles.testSimpleRule.firstRule.
			ruleParameterByName("object").inputParam)
	}
	
	@Test
	def void testIsNotInputParam() {
		assertFalse(testFiles.testRuleWithOutputParams.firstRule.
			ruleParameterByName("object").inputParam)
	}
	
	@Test
	def void testIsInputJvmParam() {
		assertTrue(testFiles.testSimpleRule.firstRule.
			ruleParameterByName("object").parameter.inputParam)
	}
	
	@Test
	def void testIsNotInputJvmParam() {
		assertFalse(testFiles.testRuleWithOutputParams.firstRule.
			ruleParameterByName("object").parameter.inputParam)
	}
	
	@Test
	def void testOutputParamsForRuleInvocation() {
		assertEquals(1, 
			testFiles.testRuleWithOutputParams.parseAndAssertNoError.
			ruleInvocations.get(0).
			outputParams.size())
	}
	
	@Test
	def void testOuputArg() {
		val ruleInvocation = testFiles.testRuleInvokingAnotherRule.firstRule.
			ruleInvocations.get(0)
		val outputArgs = ruleInvocation.outputArgsExpressions
		assertEquals(0, outputArgs.size)
	}
	
	@Test
	def void testOuputArg2() {
		val ruleInvocation = testFiles.testRuleInvokingAnotherRule.firstRule.
			ruleInvocations.get(1)
		val outputArgs = ruleInvocation.outputArgsExpressions
		assertEquals(0, outputArgs.size)
	}
	
	@Test
	def void testInputArgs() {
		val ruleInvocation = testFiles.testRuleInvokingAnotherRule.firstRule.
			ruleInvocations.get(0)
		val inputArgs = ruleInvocation.inputArgsExpressions
		assertEquals(2, inputArgs.size)
	}

	@Test
	def void testInputArgsWithOutputParams() {
		val ruleInvocation = testFiles.testRuleWithOutputParams.firstRule.
			ruleInvocations.get(0)
		val inputArgs = ruleInvocation.inputArgsExpressions
		assertEquals(2, inputArgs.size)
		assertEquals(ruleInvocation.expressions.get(0), inputArgs.get(0))
		assertEquals(ruleInvocation.expressions.get(2), inputArgs.get(1))
	}
	
	@Test
	def void testOutputArgsWithOutputParams() {
		val ruleInvocation = testFiles.testRuleWithOutputParams.firstRule.
			ruleInvocations.get(0)
		val inputArgs = ruleInvocation.outputArgsExpressions
		assertEquals(1, inputArgs.size)
		assertEquals(ruleInvocation.expressions.get(1), inputArgs.get(0))
	}
	
	@Test
	def void testOutputConclusionElements() {
		val rule = testFiles.testRuleWithOutputParams.firstRule
		val outputConclusionElements = rule.outputConclusionElements
		assertEquals(1, outputConclusionElements.size)
		assertEquals(rule.conclusion.conclusionElements.get(1),
			outputConclusionElements.get(0)
		)
	}
	
	@Test
	def void testOutputConclusionElementsWithoutOutputParams() {
		val rule = testFiles.testSimpleRule.firstRule
		val outputConclusionElements = rule.outputConclusionElements
		assertEquals(0, outputConclusionElements.size)
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
		assertNull(testFiles.testSimpleRule.parseAndAssertNoError.
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
		assertEquals(2, superSystems.size)
		superSystems.get(0).name.
				assertEqualsStrings('it.xsemantics.test.ExtendedTypeSystem')
		superSystems.get(1).name.
				assertEqualsStrings('it.xsemantics.test.TypeSystem')
	}

	@Test
	def void testAllSuperSystemDefinitionsWithCycle() {
		val superSystems = parseSystems(
			testFiles.testSystemBaseWithCycle,
			testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore,
			testFiles.testSystemExtendsExtendedTypeSystem
		).allSuperSystemDefinitions
		// due to the cycle the initial type system appears twice
		assertEquals(3, superSystems.size)
	}

	@Test
	def void testAllSuperSystemDefinitionsWithNoSuperSystem() {
		assertEquals(0, testFiles.testSimpleRule.parseAndAssertNoError.
				allSuperSystemDefinitions.size)
	}

	@Test
	def void testSuperSystemJudgments() {
		assertEquals(1, systemExtendsSystemWithJudgments.
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
		systemExtendsSystemWithJudgmentOverride
			.parseSystemsAndAssertNoErrors.
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
		assertEquals(0, 
				testFiles.testSimpleRule.parseAndAssertNoError.
				superSystemJudgments.size)
	}

	@Test
	def void testRuleJudgmentDescriptionInherited() {
		val ts = systemExtendsExtendedTypeSystem
		assertDescription(ts.getRule(0).getJudgmentDescription, "|-", ":")
		assertDescription(ts.getRule(1).getJudgmentDescription, "|-", "<:")
		assertDescription(ts.getRule(2).getJudgmentDescription, "||-", ":")
	}

	@Test
	def void testRuleInvocationJudgmentDescriptionInherited() {
		val ts = systemExtendsExtendedTypeSystem
		assertDescription
			(ts.getRule(0).ruleInvocationFromPremises.getJudgmentDescription,
				"|-", "<:")
		assertDescription
			(ts.getRule(1).ruleInvocationFromPremises.getJudgmentDescription,
				"||-", ":")
		assertDescription
			(ts.getRule(2).ruleInvocationFromPremises.getJudgmentDescription,
				"|-", ":")
	}

	@Test
	def void testAllRules() {
		assertEquals(6, 
			systemExtendsSystemWithRuleOverride.parseSystemsAndAssertNoErrors.
				allRules.size)
	}

	@Test
	def void testAllRulesByJudgmentDescription() {
		assertEquals(2, 
			systemExtendsSystemWithRuleOverride.parseSystemsAndAssertNoErrors.
				allRulesByJudgmentDescription("|-", Lists::newArrayList(":")).
					size)
	}

	@Test
	def void testCheckAllRules() {
		assertEquals(2, 
			systemExtendsSystemWithRuleOverride.parseSystemsAndAssertNoErrors.
				allCheckRules.size)
	}

	def void assertRules(Iterable<Rule> rules, Rule expectedRule1, Rule expectedRule2) {
		assertEquals("rules: " + rules.map[name], 2, rules.size)
		assertEquals(expectedRule1, rules.get(0))
		assertEquals(expectedRule2, rules.get(1))
	}
	
	def void assertDescription(JudgmentDescription description, String judgmentSymbol, String relationSymbol) {
		assertNotNull("judgment description is null", description)
		assertEquals(judgmentSymbol, description.judgmentSymbol)
		assertEquals(relationSymbol, description.relationSymbols.get(0))
	}
	
	def assertJudgments(Iterable<JudgmentDescription> judgments, CharSequence expected) {
		expected.assertEqualsStrings(
			judgments.map[ 
				it.containingSystem.name + " " +
				nodeModelUtils.getProgramText(it)
			].join('\n') + '\n')
	}

	def private List<OutputParameter> outputJudgmentParameters(Rule rule) {
		rule.getJudgmentDescription.outputJudgmentParameters
	}

	def private boolean hasOutputParams(Rule rule) {
		!rule.outputParams.empty
	}

	def private superSystemJudgments(XsemanticsSystem system) {
		system.superSystemDefinition?.judgmentDescriptions ?:
			Lists::newArrayList
	}

}