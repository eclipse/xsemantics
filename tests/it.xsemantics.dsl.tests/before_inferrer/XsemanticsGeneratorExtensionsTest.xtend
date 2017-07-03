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

package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.runtime.XsemanticsRuntimeSystem
import junit.framework.Assert
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsGeneratorExtensionsTest extends XsemanticsGeneratorBaseTest {

	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject extension XsemanticsUtils
	
	@Test
	def void testTypeSystemToPackage() {
		Assert::assertEquals("it.xsemantics.test",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toPackage)
	}
	
	@Test
	def void testTypeSystemToJavaClassFile() {
		Assert::assertEquals("it/xsemantics/test/TypeSystem.java",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toJavaClassFile)
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
	def void testTypeSystemToJavaClassNameNoQualified() {
		Assert::assertEquals("TypeSystem",
			testFiles.typeSystemNoQualifiedName.parseAndAssertNoError.toJavaClassName)
		Assert::assertEquals("TypeSystem.java",
			testFiles.typeSystemNoQualifiedName.parseAndAssertNoError.toJavaClassFile)
	}
	
	@Test
	def void testTypeSystemToValidatorPackage() {
		Assert::assertEquals("it.xsemantics.test.validation",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toValidatorPackage)
	}
	
	@Test
	def void testTypeSystemToValidatorJavaClassFile() {
		Assert::assertEquals("it/xsemantics/test/validation/TypeSystemValidator.java",
			testFiles.typeSystemQualifiedName.parseAndAssertNoError.toValidatorJavaClassFile)
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
	def void testRuleToJavaClassFile() {
		Assert::assertEquals("it/xsemantics/test/rules/EClassEObject.java",
			testFiles.testSimpleRule.firstRule.toJavaClassFile)
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
	def void testJvmTypeForTypeSystem() {
		val jvmType = testFiles.typeSystemQualifiedName.parseAndAssertNoError.createJvmType
		Assert::assertEquals("it.xsemantics.test.TypeSystem", jvmType.identifier)
	}
	
	@Test
	def void testJvmTypeForBaseTypeSystem() {
		Assert::assertEquals(typeof(XsemanticsRuntimeSystem).name,
			createJvmTypeForTypeSystemBaseClass.identifier)
	}
	
	@Test
	def void testJvmTypeForRule() {
		val jvmType = testFiles.testSimpleRule.firstRule.createJvmType
		Assert::assertEquals("it.xsemantics.test.rules.EClassEObject", jvmType.identifier)
	}
	
	@Test
	def void testInjectAnnotation() {
		Assert::assertEquals("@Inject", new ImportManager(true).injectAnnotation)
	}
	
	@Test
	def void testCheckAnnotation() {
		Assert::assertEquals("@Check", new ImportManager(true).checkAnnotation)
	}
	
	@Test
	def void testRuleInputParameters() {
		Assert::assertEquals("final EClass eClass, final EObject object",
				testFiles.testSimpleRule.firstRule.
				inputParameters(new ImportManager(true)).toString)
	}
	
	@Test
	def void errorInformationArgs() {
		Assert::assertEquals(", new ErrorInformation(eClass), new ErrorInformation(object)",
				testFiles.testSimpleRule.firstRule.
				errorInformationArgs(new ImportManager(true)).toString)
	}
	
	@Test
	def void errorInformationArgsEmpty() {
		Assert::assertEquals("",
				testFiles.testRulesWithOnlyNonEObjectParams.firstRule.
				errorInformationArgs(new ImportManager(true)).toString)
	}
	
	@Test
	def void testJudgmentDescriptionInputParameters() {
		Assert::assertEquals("final EClass c, final EObject o",
				testFiles.testSimpleRule.firstRule.judgmentDescription.
				inputParameters(new ImportManager(true)).toString)
	}
	
	@Test
	def void testJudgmentDescriptionInputParametersWithParametrizedTypes() {
		Assert::assertEquals("final List<Import> list, final Set<JudgmentDescription> set",
				testFiles.testJudgmentDescriptionsRelatedToXsemantics.
				parseAndAssertNoError.getJudgmentDescriptions.get(0).
				inputParameters(new ImportManager(true)).toString)
	}
	
	@Test
	def void testInputParametersWithNameClashes() {
		Assert::assertEquals("final Type left, final Type right",
				fjTestFiles.fjJudgmentDescriptions.
				parseAndAssertNoError.getJudgmentDescriptions.get(1).
				inputParameters(new ImportManager(true)).toString)
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
	def void testRuleReturnTypeWithoutOutputParams() {
		Assert::assertEquals("Boolean",
				testFiles.testSimpleRule.firstRule.
				ruleResultTypeParameters(new ImportManager(true)).toString)
	}
	
	@Test
	def void testResultTypeForCheckRule() {
		Assert::assertEquals("Result<Boolean>",
				testFiles.testCheckRule.firstCheckRule.
				resultType(new ImportManager(true)).toString)
	}
	
	@Test
	def void testInputParameterForCheckRule() {
		Assert::assertEquals("final EObject obj",
				testFiles.testCheckRule.firstCheckRule.
				inputParameter(new ImportManager(true)).toString)
	}
	
	@Test
	def void testRuleReturnWithoutOutputParams() {
		Assert::assertEquals("Result<Boolean>",
				testFiles.testSimpleRule.firstRule.
				resultType(new ImportManager(true)).toString)
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
	def void testJudgmentDescriptionResultType() {
		Assert::assertEquals("Result<Boolean>",
				testFiles.testSimpleRule.parseAndAssertNoError.getJudgmentDescriptions.get(0).
				resultType(new ImportManager(true)).toString)
	}
	
	@Test
	def void testJudgmentDescriptionResultType2() {
		Assert::assertEquals("Result2<EObject, EStructuralFeature>",
				testFiles.testJudgmentDescriptionsWith2OutputParams.
				parseAndAssertNoError.getJudgmentDescriptions.get(0).
				resultType(new ImportManager(true)).toString)
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
	def void testJudgmentDescriptionResultTypeWithAppendable() {
		val appendable = createAppendable
		Assert::assertEquals("Result<Boolean>",
				testFiles.testSimpleRule.parseAndAssertNoError.getJudgmentDescriptions.get(0).
				resultType(appendable).toString)
	}
	
	@Test
	def void testAdditionalParamsDeclaration() {
		Assert::assertEquals("final RuleEnvironment _environment_, final RuleApplicationTrace _trace_",
				(new ImportManager(true)).additionalParamsDeclaration.toString)
	}
	
	@Test
	def void testAdditionalParamsDeclarationForRule() {
		Assert::assertEquals("final RuleEnvironment G, final RuleApplicationTrace _trace_",
				testFiles.testSimpleRule.firstRule.additionalParamsDeclaration(new ImportManager(true)).toString)
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
	def void testRuleIssueDeclaration() {
		assertEqualsStrings('public final static String ECLASSEOBJECT = "it.xsemantics.test.rules.EClassEObject";',
			testFiles.testSimpleRule.firstRule.ruleIssueDeclaration(new ImportManager(true))
		)
	}
	
}