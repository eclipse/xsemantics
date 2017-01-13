package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.xsemantics.EnvironmentMapping
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsScopingTest extends XsemanticsBaseTest {

	@Inject extension ValidationTestHelper

	@Test
	def void testScopingForParameters() {
		val system = testFiles.testScopingForParameters.parse
		system.assertNoErrors
		val xBlockExpression = (system.rules.head as RuleWithPremises).premises as XBlockExpression
		val leftOperandReferringToOutputParam = ((xBlockExpression).expressions.head as XBinaryOperation).leftOperand
		//println((leftOperandReferringToOutputParam as XMemberFeatureCall).feature)
		val leftOperandReferringToInputParam = ((xBlockExpression).expressions.get(1) as XBinaryOperation).leftOperand
		//println((leftOperandReferringToInputParam as XMemberFeatureCall).feature)
		"org.eclipse.emf.ecore.EObject.eContainer()".assertEqualsStrings((leftOperandReferringToInputParam as XMemberFeatureCall).
			feature.identifier
		)
		"org.eclipse.emf.ecore.ENamedElement.getName()".assertEqualsStrings((leftOperandReferringToOutputParam as XMemberFeatureCall).
			feature.identifier
		)
	}

	@Test
	def void testScopingForVariableAsOutputParam() {
		val system = testFiles.testScopingForVariableDeclarationAsOutputArgument.parse
		//system.assertNoErrors
		val xBlockExpression = (system.rules.head as RuleWithPremises).premises as XBlockExpression
		val leftOperandReferringToOutputParam = ((xBlockExpression).expressions.get(1) as XBinaryOperation).leftOperand
		"org.eclipse.emf.ecore.ENamedElement.getName()".assertEqualsStrings((leftOperandReferringToOutputParam as XMemberFeatureCall).
			feature.identifier
		)
	}
	
	@Test
	def void testScopingForExpressionInConclusion() {
		val expInConcl = 
			testFiles.testAxiomWithExpressionInConclusion.
				getRuleWithoutValidation(0).
					expressionInConclusion(0).expression
		//system.assertNoErrors
		val feature = (expInConcl as XMemberFeatureCall).feature
		"org.eclipse.emf.ecore.EObject.eClass()".assertEqualsStrings(
			feature.identifier
		)
	}
	
	@Test
	def void testScopingForErrorSpecificationInJudgment() {
		val errSpec = testFiles.
			testJudgmentDescriptionsWithErrorSpecification.
				parse.judgmentDescriptions.head.error as ErrorSpecification
		val feature = (errSpec.feature as XMemberFeatureCall).feature
		"org.eclipse.emf.ecore.EObject.eContainingFeature()".assertEqualsStrings(
			feature.identifier
		)
	}

	@Test
	def void testScopingForErrorSpecificationInRule() {
		val errSpec = testFiles.
			testRuleWithErrorSpecifications.
				parse.rules.head.conclusion.error as ErrorSpecification
		val feature = (errSpec.feature as XMemberFeatureCall).feature
		"org.eclipse.emf.ecore.EObject.eContainingFeature()".assertEqualsStrings(
			feature.identifier
		)
	}

	@Test
	def void testScopingForEnvironmentMapping() {
		val system = testFiles.
			testSingleEnvironmentMapping.parse
		val xBlockExpression = (system.rules.head as RuleWithPremises).premises as XBlockExpression
		val ruleInvk = xBlockExpression.expressions.head as RuleInvocation
		val envMapping = ruleInvk.environment as EnvironmentMapping
		val feature = (envMapping.value as XFeatureCall).feature
		"object".assertEqualsStrings(
			feature.identifier
		)
	}

}
