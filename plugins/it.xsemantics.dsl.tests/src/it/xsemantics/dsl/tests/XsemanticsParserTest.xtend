package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.EnvironmentComposition
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.example.fj.fj.Expression
import it.xsemantics.example.fj.fj.Type
import junit.framework.Assert
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.junit.Test
import org.junit.runner.RunWith
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import it.xsemantics.dsl.xsemantics.EnvironmentAccess

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsParserTest extends XsemanticsBaseTest {
	
	@Inject extension ValidationTestHelper
	
	@Inject extension XsemanticsUtils
	
	@Test
	def void testParsingOfName() {
		parser.parse(testFiles.typeSystemQualifiedName).assertNoErrors
	}
 
 	@Test
	def void testParsingOfImports() {
		parser.parse(testFiles.testFileWithImports).assertNoErrors
	}
	
	@Test
	def void testParsingOfJudgmentDescriptions() {
		parser.parse(testFiles.testJudgmentDescriptions).assertNoErrors
	}
	
	@Test
	def void testParsingOfJudgmentDescriptions3() {
		parser.parse(testFiles.testJudgmentDescriptions3).assertNoErrors
	}
	
	@Test
	def void testParsingOfJudgmentDescriptionsWithOutput() {
		parser.parse(testFiles.testJudgmentDescriptionsReferringToEcore3WithOutput).assertNoErrors
	}
	
	@Test
	def void testJudgmentDescriptionsRelatedToXtypes() {
		parser.parse(testFiles.testJudgmentDescriptionsRelatedToXsemantics).assertNoErrors
	}
	
	@Test
	def void testJudgmentDescriptionsWithErrorSpecification() {
		parser.parse(testFiles.testJudgmentDescriptionsWithErrorSpecification).assertNoErrors
	}
	
	@Test
	def void testJudgmentDescriptionsReferringToUnknownTypes() {
		parser.parse(testFiles.testJudgmentDescriptionsReferringToUnknownTypes).assertError(
				TypesPackage::eINSTANCE.jvmParameterizedTypeReference,
				Diagnostic::LINKING_DIAGNOSTIC,
				"Couldn't resolve reference to JvmType 'foo.bar.FooBar'")
	}

	@Test
	def void testFjDescriptions() {
		val typesystem = parser.parse(fjTestFiles.fjJudgmentDescriptions)
		typesystem.assertNoErrors
		var jvmReferences = typesystem.jvmTypes
		Assert::assertEquals(typeof(Expression).name, jvmReferences.get(0).identifier)
		Assert::assertEquals(typeof(Type).name, jvmReferences.get(1).identifier)
	}
	
	@Test
	def void testJudgmentDescriptionsRelatedToEcore() {
		parser.parse(testFiles.testJudgmentDescriptionsReferringToEcore).assertNoErrors
	}
	
	@Test
	def void testSimpleAxiom() {
		parser.parse(testFiles.testSimpleAxiom).assertNoErrors
	}
	
	@Test
	def void testSimpleRule() {
		parser.parse(testFiles.testSimpleRule).assertNoErrors
	}

	@Test
	def void testRuleWithExpressionInConclusion() {
		parser.parse(testFiles.testRuleWithExpressionInConclusion).assertNoErrors
	}
	
	@Test
	def void testRuleWithBlockExpressionInConclusion() {
		parser.parse(testFiles.testRuleWithBlockExpressionInConclusion).assertNoErrors
	}

	@Test
	def void testRuleInvokingAnotherRule() {
		testFiles.testRuleInvokingAnotherRule.parseAndAssertNoError.
			checksForRuleInvocations
	}
	
	@Test
	def void testRuleOnlyInvokingOtherRules() {
		val ts = testFiles.testRuleOnlyInvokingRules.parseAndAssertNoError
		Assert::assertEquals(2, ts.ruleInvocations.size)
		var expressions = ts.getRulePremises(0)
		assertIsInstance(typeof(RuleInvocation), expressions.get(0))
		assertIsInstance(typeof(RuleInvocation), expressions.get(1))
	}
	
	@Test
	def void testWithEnvironmentAccess() {
		val premises = testFiles.testWithEnvironmentAccess.
			parseAndAssertNoError.getRulePremises(0)
		assertIsInstance(typeof(RuleInvocation), premises.get(0))
		assertIsInstance(typeof(EnvironmentAccess), premises.get(1))
		assertIsInstance(typeof(RuleInvocation), premises.get(2))
	}
	
	@Test
	def void testRuleInvokingAnotherRule3() {
		testFiles.testRuleInvokingAnotherRule3.parseAndAssertNoError.
			checksForRuleInvocations
	}
	
	@Test
	def void testRuleInvokingAnotherRuleWith3Params() {
		testFiles.testRuleInvokingAnotherRuleWith3Params.parseAndAssertNoError
	}
	
	def void checksForRuleInvocations(XsemanticsSystem ts) {
		Assert::assertEquals(2, ts.ruleInvocations.size)
		var expressions = ts.getRulePremises(0)
		assertIsInstance(typeof(XBinaryOperation), expressions.get(0))
		assertIsInstance(typeof(RuleInvocation), expressions.get(1))
		assertIsInstance(typeof(RuleInvocation), expressions.get(2))
		assertIsInstance(typeof(XVariableDeclaration), expressions.get(3))
		assertIsInstance(typeof(XAssignment), expressions.get(4))
		assertIsInstance(typeof(XUnaryOperation), expressions.get(5))
		assertIsInstance(typeof(XBinaryOperation), expressions.get(6))
		assertIsInstance(typeof(XBinaryOperation), expressions.get(7))
	}

	@Test
	def void testRuleInvocationsWithOperatorsConflictingXbase() {
		var ts = testFiles.testRuleInvocationsWithOperatorsConflictingXbase.parseAndAssertNoError
		Assert::assertEquals(18, ts.ruleInvocations.size)
	}
	
	@Test
	def void testRuleWithErrorSpecifications() {
		testFiles.testRuleWithErrorSpecifications.parseAndAssertNoError
	}
	
	@Test
	def void testOrExpression() {
		var premises = testFiles.testOrExpression.firstRule.rulePremises
		Assert::assertEquals(1, premises.size)
		assertOrExpression(premises.get(0), 2)
	}
	
	@Test
	def void testOrExpression2() {
		var premises = testFiles.testOrExpression2.firstRule.rulePremises
		Assert::assertEquals(3, premises.size)
		assertIsInstance(typeof(XBinaryOperation), premises.get(0))
		assertOrExpression(premises.get(1), 2)
		assertIsInstance(typeof(XBinaryOperation), premises.get(2))
	}
	
	@Test
	def void testOrExpressionWithBlocks() {
		var premises = testFiles.testOrExpressionWithBlocks.firstRule.rulePremises
		Assert::assertEquals(1, premises.size)
		assertOrExpression(premises.get(0), 2)
	}
	
	@Test
	def void testOrExpressionWithRuleInvocations() {
		var premises = testFiles.testOrExpressionWithRuleInvocations.firstRule.rulePremises
		Assert::assertEquals(1, premises.size)
		assertOrExpression(premises.get(0), 2)
	}
	
	@Test
	def void testOrExpressionWithRuleInvocations2() {
		var premises = testFiles.testOrExpressionWithRuleInvocations2.firstRule.rulePremises
		Assert::assertEquals(1, premises.size)
		assertOrExpression(premises.get(0), 2)
	}
	
	@Test
	def void testOrExpressionWithManyBranches() {
		var premises = testFiles.testOrExpressionWithManyBranches.firstRule.rulePremises
		Assert::assertEquals(1, premises.size)
		assertOrExpression(premises.get(0), 2)
	}
	
	@Test
	def void testEmptyEnvironment() {
		testFiles.testEmptyEnvironment.parseAndAssertNoError
	}
	
	@Test
	def void testEnvironmentComposition() {
		testFiles.testEnvironmentComposition.parseAndAssertNoError
	}
	
	@Test
	def void testEnvironmentComposition2() {
		testFiles.testEnvironmentComposition2.parseAndAssertNoError
	}
	
	@Test
	def void testSingleEnvironmentMapping() {
		testFiles.testSingleEnvironmentMapping.parseAndAssertNoError
	}
	
	@Test
	def void testEnvironmentMapping() {
		testFiles.testEnvironmentCompositionWithMapping.parseAndAssertNoError
	}
	
	@Test
	def void testEnvironmentMapping2() {
		val ruleInvocation = testFiles.testEnvironmentMapping2.firstRule.ruleInvocationFromPremises
		val envSpec = ruleInvocation.environment
		assertIsInstance(typeof(EnvironmentComposition), envSpec)
		envSpec.environmentComposition.
			subEnvironment.environmentComposition.
				subEnvironment.environmentMapping
	}
	
	@Test
	def void testCheckRule() {
		testFiles.testCheckRule.parseAndAssertNoError
	}
	
	@Test
	def void testStringRep() {
		testFiles.testStringRep.parseAndAssertNoError
	}
	
	@Test
	def void testForFail() {
		testFiles.testForFail.parseAndAssertNoError
	}
	
	@Test
	def void testForFailWithErrorSpecfication() {
		testFiles.testForFailWithErrorSpecification.parseAndAssertNoError
	}
	
	@Test
	def void testForClosures() {
		testFiles.testForClosures.parseAndAssertNoError
	}
	
	@Test
	def void testForScopeOfThisInRule() {
		testFiles.testForScopeOfThisInRule.parseAndAssertNoError
	}
	
	@Test
	def void testForScopeOfThisInCheckRule() {
		testFiles.testForScopeOfThisInCheckRule.parseAndAssertNoError
	}
	
	@Test
	def void testForScopeOfThisInJudgmentDescription() {
		testFiles.testForScopeOfThisInJudgmentDescription.parseAndAssertNoError
	}
	
	@Test
	def void testOutputParamFromInputParam() {
		testFiles.testOutputParamFromInputParam.parseAndAssertNoError
	}
	
	@Test
	def void testVariableDeclarationAsOutputArgument() {
		testFiles.testVariableDeclarationAsOutputArgument.parseAndAssertNoError
	}
	
	@Test
	def void testScopingForVariableDeclarationAsOutputArgument() {
		testFiles.testScopingForVariableDeclarationAsOutputArgument.parseAndAssertNoError
	}
	
	@Test
	def void testWrongReturnInPremises() {
		testFiles.testWrongReturnInPremises.parseAndAssertNoError
	}
	
	// Xtext 2.3
	
	@Test
	def void testRuleWithBooleanExpressionsWithNoSideEffect() {
		parser.parse(testFiles.testRuleWithBooleanExpressionsWithNoSideEffect).assertNoErrors
	}
}