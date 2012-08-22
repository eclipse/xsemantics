package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest
import it.xsemantics.dsl.util.XsemanticsUtils
import junit.framework.Assert
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsGeneratorExtensionsTest extends XsemanticsGeneratorBaseTest {

	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject extension XsemanticsUtils

	@Test
	def void testTypeSystemToPackageWithNullName() {
		Assert::assertEquals(null,
			'system '.parse.toPackage)
	}
	
	@Test
	def void testTypeSystemToPackage() {
		Assert::assertEquals("it.xsemantics.test",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toPackage)
	}
	
	@Test
	def void testTypeSystemToJavaFullyQualifiedName() {
		Assert::assertEquals("it.xsemantics.test.TypeSystem",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toJavaFullyQualifiedName)
	}
	
	@Test
	def void testTypeSystemToJavaClassName() {
		Assert::assertEquals("TypeSystem",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toJavaClassName)
	}
	
	@Test
	def void testTypeSystemToValidatorPackage() {
		Assert::assertEquals("it.xsemantics.test.validation",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toValidatorPackage)
	}
	
	@Test
	def void testTypeSystemToValidatorJavaFullyQualifiedName() {
		Assert::assertEquals("it.xsemantics.test.validation.TypeSystemValidator",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toValidatorJavaFullyQualifiedName)
	}
	
	@Test
	def void testRuleToPackage() {
		Assert::assertEquals("it.xsemantics.test.rules",
			testFiles.testSimpleRule.firstRule.toPackage)
	}
	
	@Test
	def void testRuleToFullyQualifiedName() {
		Assert::assertEquals("it.xsemantics.test.rules.EClassEObject",
			testFiles.testSimpleRule.firstRule.toJavaFullyQualifiedName)
	}
	
	@Test
	def void testRuleToJavaName() {
		Assert::assertEquals("EClassEObject",
			testFiles.testSimpleRule.firstRule.toJavaClassName)
	}
	
	@Test
	def void testRuleToJavaNameFirstToUpper() {
		Assert::assertEquals("EClassEObject",
			testFiles.testSimpleAxiom.firstRule.toJavaClassName)
	}

	@Test
	def void testJudgmentDescriptionInputArgs() {
		Assert::assertEquals("c, o",
				testFiles.testSimpleRule.firstRule.judgmentDescription.
				inputArgs().toString)
	}
	
	@Test
	def void testRuleInputParameterNames() {
		Assert::assertEquals("eClass, object",
				testFiles.testSimpleRule.firstRule.
				inputParameterNames().toString)
	}
	
	@Test
	def void testPolymorphicDispatcherNumOfArgs() {
		Assert::assertEquals("4",
				testFiles.testSimpleRule.firstRule.judgmentDescription.
				polymorphicDispatcherNumOfArgs().toString)
	}
	
	@Test
	def void testPolymorphicDispatcherNumOfArgs2() {
		Assert::assertEquals("4",
				testFiles.testRuleWithOutputParams.firstRule.judgmentDescription.
				polymorphicDispatcherNumOfArgs().toString)
	}
	
	@Test
	def void testSuffixStartingFrom2WithTwoOutputs() {
		Assert::assertEquals("2",
				testFiles.testJudgmentDescriptionsWith2OutputParams.
				parseAndAssertNoError.getJudgmentDescriptions.get(0).
				suffixStartingFrom2)
	}
	
	@Test
	def void testSuffixStartingFrom2WithOneOutput() {
		Assert::assertEquals("",
				testFiles.testJudgmentDescriptionsEObjectEClass.
				parseAndAssertNoError.getJudgmentDescriptions.get(0).
				suffixStartingFrom2)
	}
	
	@Test
	def void testSuffixStartingFrom2WithoutOutput() {
		Assert::assertEquals("",
				testFiles.testJudgmentDescriptionsReferringToEcore.
				parseAndAssertNoError.getJudgmentDescriptions.get(0).
				suffixStartingFrom2)
	}
	
	@Test
	def void testAdditionalArgs() {
		Assert::assertEquals("_environment_, _trace_",
				additionalArgs.toString)
	}
	
	@Test
	def void testAdditionalArgsForRule() {
		Assert::assertEquals("G, _subtrace_",
				testFiles.testSimpleRule.firstRule.additionalArgsForRule.toString)
	}

	@Test
	def void testAdditionalArgsForRuleInvocation() {
		Assert::assertEquals("_trace_",
				testFiles.testRuleOnlyInvokingRules.firstRule.
				ruleInvocationFromPremises.additionalArgsForRuleInvocation.toString)
	}

	@Test
	def void testJavaString() {
		Assert::assertEquals("foo", "foo".javaString)
		Assert::assertEquals("\\'foo\\'", "'foo'".javaString)
		Assert::assertEquals('\\"foo\\"', '"foo"'.javaString)
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
	def void testResultTypeWithTwoOutputParameters() {
		testFiles.testJudgmentDescriptionsWith2OutputParams.
			assertResultType("Result2<EObject,EStructuralFeature>")
	}

	@Test
	def void testResultForCheckRule() {
		val a = createAppendable
		testFiles.testCheckRule.parseAndAssertNoError.
			checkrules.get(0).resultType(a)
		assertEqualsStrings("Result<Boolean>", a)
	}
	
	def assertResultType(CharSequence prog, CharSequence expected) {
		val a = createAppendable
		prog.parseAndAssertNoError.judgmentDescriptions.get(0).
			resultType(a)
		assertEqualsStrings(expected, a)
	}

}