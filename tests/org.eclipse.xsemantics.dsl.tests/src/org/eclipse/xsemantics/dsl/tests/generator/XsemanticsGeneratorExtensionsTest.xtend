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

package org.eclipse.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import org.eclipse.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import org.eclipse.xsemantics.dsl.util.XsemanticsUtils
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsGeneratorExtensionsTest extends XsemanticsGeneratorBaseTest {

	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject extension XsemanticsUtils

	@Test
	def void testTypeSystemToValidatorPackage() {
		assertEquals("org.eclipse.xsemantics.test.validation",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toValidatorPackage)
	}
	
	@Test
	def void testTypeSystemToValidatorJavaFullyQualifiedName() {
		assertEquals("org.eclipse.xsemantics.test.validation.TypeSystemValidator",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toValidatorJavaFullyQualifiedName)
	}
	
	@Test
	def void testRuleToJavaName() {
		assertEquals("EClassEObject",
			testFiles.testSimpleRule.firstRule.toJavaClassName)
	}
	
	@Test
	def void testRuleToJavaNameFirstToUpper() {
		assertEquals("EClassEObject",
			testFiles.testSimpleAxiom.firstRule.toJavaClassName)
	}

	@Test
	def void testJudgmentDescriptionInputArgs() {
		assertEquals("c, o",
				testFiles.testSimpleRule.firstRule.getJudgmentDescription.
				inputArgs().toString)
	}
	
	@Test
	def void testRuleInputParameterNames() {
		assertEquals("eClass, object",
				testFiles.testSimpleRule.firstRule.
				inputParameterNames().toString)
	}
	
	@Test
	def void testPolymorphicDispatcherNumOfArgs() {
		assertEquals("4",
				testFiles.testSimpleRule.firstRule.getJudgmentDescription.
				polymorphicDispatcherNumOfArgs().toString)
	}
	
	@Test
	def void testPolymorphicDispatcherNumOfArgs2() {
		assertEquals("4",
				testFiles.testRuleWithOutputParams.firstRule.getJudgmentDescription.
				polymorphicDispatcherNumOfArgs().toString)
	}
	
	@Test
	def void testSuffixStartingFrom2With3Outputs() {
		assertEquals("3",
				testFiles.testJudgmentDescriptionsWith3OutputParams.
				parseAndAssertNoError.getJudgmentDescriptions.get(0).
				suffixStartingFrom2)
	}

	@Test
	def void testSuffixStartingFrom2With2Outputs() {
		assertEquals("2",
				testFiles.testJudgmentDescriptionsWith2OutputParams.
				parseAndAssertNoError.getJudgmentDescriptions.get(0).
				suffixStartingFrom2)
	}
	
	@Test
	def void testSuffixStartingFrom2With1Output() {
		assertEquals("",
				testFiles.testJudgmentDescriptionsEObjectEClass.
				parseAndAssertNoError.getJudgmentDescriptions.get(0).
				suffixStartingFrom2)
	}
	
	@Test
	def void testSuffixStartingFrom2WithoutOutput() {
		assertEquals("",
				testFiles.testJudgmentDescriptionsReferringToEcore.
				parseAndAssertNoError.getJudgmentDescriptions.get(0).
				suffixStartingFrom2)
	}
	
	@Test
	def void testAdditionalArgs() {
		assertEquals("_environment_, _trace_",
				additionalArgs.toString)
	}
	
	@Test
	def void testAdditionalArgsForRule() {
		assertEquals("G, _subtrace_",
				testFiles.testSimpleRule.firstRule.additionalArgsForRule.toString)
	}

	@Test
	def void testAdditionalArgsForRuleInvocation() {
		assertEquals("_trace_",
				testFiles.testRuleOnlyInvokingRules.firstRule.
				ruleInvocationFromPremises.additionalArgsForRuleInvocation.toString)
	}

	@Test
	def void testJavaString() {
		assertEquals("foo", "foo".javaString)
		assertEquals("\\'foo\\'", "'foo'".javaString)
		assertEquals('\\"foo\\"', '"foo"'.javaString)
	}
	
	@Test
	def void testErrorForRuleWithoutOutput() {
		assertEqualsStrings(
		'''ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object)''',
		testFiles.testSimpleRule.firstRule.errorForRule)
	}
	
	@Test
	def void testErrorForRuleWithOutput() {
		assertEqualsStrings(
		'''ruleName("EClassEObjectEStructuralFeature") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + "EObject" + " : " + stringRep(feat)''',
		testFiles.testRuleWithOutputParams.firstRule.errorForRule)
	}
	
	@Test
	def void testTraceStringForRuleWithoutOutput() {
		assertEqualsStrings(
		'''ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object)''',
		testFiles.testSimpleRule.firstRule.traceStringForRule)
	}
	
	@Test
	def void testTraceStringForRuleWithOutput() {
		assertEqualsStrings(
		'''ruleName("EClassEObjectEStructuralFeature") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond())''',
		testFiles.testRuleWithTwoOutputParams.firstRule.traceStringForRule)
	}
	
	@Test
	def void testRuleIssueString() {
		assertEqualsStrings("ECLASSEOBJECT",
			testFiles.testSimpleRule.firstRule.ruleIssueString
		)
	}
	
	@Test
	def void testResultTypeWithNoOutputParameter() {
		testFiles.testSimpleRule.assertResultType("Result<Boolean>")
	}

	@Test
	def void testResultTypeWithOneOutputParameter() {
		testFiles.testJudgmentDescriptionsReferringToEcoreWithOutput.
			assertResultType("Result<EObject>")
	}

	@Test
	def void testResultTypeWith2OutputParameters() {
		testFiles.testJudgmentDescriptionsWith2OutputParams.
			assertResultType("Result2<EObject, EStructuralFeature>")
	}

	@Test
	def void testResultTypeWith3OutputParameters() {
		testFiles.testJudgmentDescriptionsWith3OutputParams.
			assertResultType("Result3<EObject, EStructuralFeature, String>")
	}

	@Test
	def void testResultForCheckRule() {
		val a = createAppendable
		testFiles.testCheckRule.parseAndAssertNoError.
			checkrules.get(0).resultType(a)
		assertEqualsStrings("Result<Boolean>", a)
	}

	@Test
	def void testAssociatedToAuxiliaryFunction() {
		val system = testFiles.testAuxiliaryFunctionsInvocation.parseAndAssertNoError
		val featureCall = system.getRule(0).
			rulePremises.get(0) as XAbstractFeatureCall
		assertEquals(
			system.auxiliaryDescriptions.get(0),
			featureCall.feature.associatedAuxiliaryDescription
		)
	}

	@Test
	def void testExpressionInConclusionMethodName() {
		testFiles.testExpressionsInConclusion.parse.rules.head.
			expressionsInConclusion => [
				"_applyRuleTestRule_1".
				assertEquals(get(0).expressionInConclusionMethodName)
				"_applyRuleTestRule_2".
				assertEquals(get(1).expressionInConclusionMethodName)
			]
	}

	@Test
	def void testInputEObjectParams() {
		assertEquals(2, 
			testFiles.testRuleWithOutputParams.firstRule.
			inputEObjectParams.size())
	}
	
	@Test
	def void testInputEObjectParamsWithNonEObjects() {
		assertEquals(1, 
			testFiles.testRulesWithNonEObjectParams.firstRule.
			inputEObjectParams.size())
	}
	
	def assertResultType(CharSequence prog, CharSequence expected) {
		val a = createAppendable
		prog.parseAndAssertNoError.judgmentDescriptions.get(0).
			resultType(a)
		assertEqualsStrings(expected, a)
	}

}