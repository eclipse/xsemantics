package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.tests.input.FjTypeSystemFiles
import it.xsemantics.dsl.tests.input.XsemanticsTestFiles
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.EnvironmentAccess
import it.xsemantics.dsl.xsemantics.EnvironmentComposition
import it.xsemantics.dsl.xsemantics.EnvironmentMapping
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.OrExpression
import it.xsemantics.dsl.xsemantics.Rule
import it.xsemantics.dsl.xsemantics.RuleConclusionElement
import it.xsemantics.dsl.xsemantics.RuleInvocation
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.RuleWithPremises
import it.xsemantics.dsl.xsemantics.XsemanticsSystem
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.xtext.EcoreUtil2

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
abstract class XsemanticsBaseTest {
	
	@Inject
	protected XsemanticsTestFiles testFiles
	
	@Inject
	protected FjTypeSystemFiles fjTestFiles
	
	@Inject
	protected ParseHelper<XsemanticsSystem> parser
	
	@Inject extension ValidationTestHelper
	
	@BeforeClass
	def static void setNewLine() {
		System::setProperty("line.separator", "\n")
	}
	
	def parseAndAssertNoError(CharSequence s) {
		var ts = parser.parse(s)
		ts.assertNoErrors
		ts
	}

	/* s extends baseSystem2 which extends baseSystem */
	def parseWithBaseSystemAndAssertNoError(CharSequence baseSystem, 
		CharSequence baseSystem2, CharSequence s
	) {
		val ts = baseSystem.parseWithBaseSystem(baseSystem2)
		ts.assertNoErrors
		ts.parseWithBaseSystem(s)
	}
	
	def parseWithBaseSystemAndAssertNoError(CharSequence baseSystem, CharSequence s) {
		val base = parser.parse(baseSystem)
		base.assertNoErrors
		val ts = base.parseWithBaseSystem(s)
		ts.assertNoErrors
		ts
	}

	def parseWithBaseSystemAndAssertNoError(XsemanticsSystem baseSystem, CharSequence s) {
		val ts = baseSystem.parseWithBaseSystem(s)
		ts.assertNoErrors
		ts
	}

	def parseWithBaseSystem(CharSequence baseSystem, CharSequence s) {
		val base = parser.parse(baseSystem)
		base.parseWithBaseSystem(s)
	}

	def parseWithBaseSystem(XsemanticsSystem baseSystem, CharSequence s) {
		parser.parse(s, baseSystem.eResource.resourceSet)
	}
	
	def parse(CharSequence s) {
		parser.parse(s)
	}

	def parseAndValidate(CharSequence s) {
		parser.parse(s) => [validate]
	}
	
	def getFirstRule(CharSequence s) {
		getRule(s, 0)
	}
	
	def getRule(CharSequence s, int index) {
		s.parseAndAssertNoError.getRule(index)
	}
	
	def getRuleWithoutValidation(CharSequence s, int index) {
		s.parse.getRule(index)
	}
	
	def getRule(XsemanticsSystem ts, int index) {
		val rules = ts.getRules
		Assert::assertTrue("no rule for index " + index + ", only " + rules.size,
			rules.size > index
		)
		rules.get(index)
	}
	
	def getFirstCheckRule(CharSequence s) {
		getCheckRule(s, 0)
	}
	
	def getCheckRule(CharSequence s, int index) {
		s.parseAndAssertNoError.getCheckRule(index)
	}
	
	def getCheckRule(XsemanticsSystem ts, int index) {
		val rules = ts.getCheckrules
		Assert::assertTrue("no rule for index " + index + ", only " + rules.size,
			rules.size > index
		)
		rules.get(index)
	}
	
	def firstVariableDeclaration(CharSequence s) {
		s.parseAndAssertNoError.
			getAllContentsOfType(typeof(XVariableDeclaration)).get(0)
	}
	
	def firstAssignment(CharSequence s) {
		s.parseAndAssertNoError.
			getAllContentsOfType(typeof(XAssignment)).get(0)
	}
	
	def firstIf(CharSequence s) {
		s.parseAndAssertNoError.
			getAllContentsOfType(typeof(XIfExpression)).get(0)
	}
	
	def firstFor(CharSequence s) {
		s.parseAndAssertNoError.
			getAllContentsOfType(typeof(XForLoopExpression)).get(0)
	}
	
	def firstJudgmentDescription(CharSequence s) {
		s.parseAndAssertNoError.firstJudgmentDescription
	}
	
	def firstJudgmentDescription(XsemanticsSystem ts) {
		ts.getAllContentsOfType(typeof(JudgmentDescription)).get(0)
	}
	
	def firstErrorSpecification(EObject o) {
		o.getAllContentsOfType(typeof(ErrorSpecification)).get(0)
	}
	
	def getRuleWithPremises(XsemanticsSystem ts, int index) {
		ts.getRule(index).ruleWithPremises
	}
	
	def getRulePremises(XsemanticsSystem ts, int index) {
		(ts.getRuleWithPremises(index).premises as XBlockExpression).expressions
	}
	
	def getRuleWithPremises(Rule rule) {
		rule as RuleWithPremises
	}
	
	def getRulePremises(Rule rule) {
		(rule.ruleWithPremises.premises as XBlockExpression).expressions
	}
	
	def getRulePremisesAsBlock(Rule rule) {
		(rule.ruleWithPremises.premises as XBlockExpression)
	}
	
	def getRulePremisesAsBlock(CheckRule rule) {
		(rule.premises as XBlockExpression)
	}

	def getPremise(Rule rule, int index) {
		rule.rulePremises.get(index)
	}
	
	def ruleParameter(RuleConclusionElement ruleConclusionElement) {
		(ruleConclusionElement as RuleParameter)
	}
	
	def ruleParameterByName(Rule rule, String name) {
		rule.conclusion.conclusionElements.
			typeSelect(typeof(RuleParameter)).findFirst [
				it.parameter.name == name
			]
	}

	def expressionInConclusion(Rule rule, int index) {
		rule.conclusion.conclusionElements.typeSelect(typeof(ExpressionInConclusion)).
			get(index).ruleExpression
	}
	
	def ruleExpression(RuleConclusionElement ruleConclusionElement) {
		(ruleConclusionElement as ExpressionInConclusion)
	}
	
	def assertIsInstance(Class<?> superClass, Object o) {
		Assert::assertTrue(o.getClass.name + " is not an instance of " + superClass.name,
			superClass.isAssignableFrom(o.getClass))
	}
	
	def assertOrExpression(XExpression exp, int branches) {
		Assert::assertEquals(branches, exp.orExpression.branches.size)
	}
	
	def getOrExpression(XExpression exp) {
		exp as OrExpression
	}
	
	def getRuleInvocationFromPremises(Rule rule) {
		rule.rulePremises.get(0) as RuleInvocation
	}
	
	def getEnvironmentComposition(XExpression envSpec) {
		envSpec as EnvironmentComposition
	}
	
	def getEnvironmentMapping(XExpression envSpec) {
		envSpec as EnvironmentMapping
	}
	
	def getEnvironmentSpecificationOfRuleInvocation(Rule rule) {
		rule.ruleInvocationFromPremises.environment
	}

	def getXAbstractFeatureCall(int index) {
		testFiles.testRuleWithFeatureCallsForBinaryOps.parse.
			getXAbstractFeatureCalls.get(index)
	}

	def getXAbstractFeatureCalls(XsemanticsSystem ts) {
		ts.getRules.get(0).rulePremises.typeSelect(typeof(XAbstractFeatureCall))
	}
	
	def getEnvironmentAccess(XsemanticsSystem ts) {
		ts.getRules.get(0).rulePremises.typeSelect(typeof(EnvironmentAccess)).get(0)
	}
	
	def assertEqualsStrings(Object expected, Object actual) {
		Assert::assertEquals("" + expected, "" + actual)
	}

	def systemExtendsSystemWithJudgments() {
		testFiles.testJudgmentDescriptions.
			parseWithBaseSystemAndAssertNoError
			(testFiles.testSystemExtendsSystemWithJudgments)
	}

	def systemExtendsSystemWithAdditionalJudgment() {
		testFiles.testJudgmentDescriptionsWithErrorSpecification.
			parseWithBaseSystemAndAssertNoError
			(testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore)
	}

	def systemExtendsExtendedTypeSystem() {
		testFiles.testJudgmentDescriptionsWithErrorSpecification.
			parseWithBaseSystemAndAssertNoError
			(
				testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore,
				testFiles.testSystemExtendsExtendedTypeSystem
			)
	}

	def systemExtendsSystemWithRuleOverride() {
		testFiles.testJudgmentDescriptionsWithErrorSpecification.
			parseWithBaseSystemAndAssertNoError
			(
				testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore,
				testFiles.testSystemExtendsExtendedTypeSystem
			).
			parseWithBaseSystemAndAssertNoError(
				testFiles.testRuleOverride
			)
	}

	def systemExtendsSystemWithJudgmentOverride() {
		loadBaseSystems.
			parseWithBaseSystemAndAssertNoError(
				testFiles.testOverrideJudgment
			)
	}

	def loadBaseSystems() {
		testFiles.testJudgmentDescriptionsWithErrorSpecification.
			parseWithBaseSystemAndAssertNoError
			(
				testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore,
				testFiles.testSystemExtendsExtendedTypeSystem
			)
	}

	def getRuleInvocations(EObject element) {
		EcoreUtil2::getAllContentsOfType(element, typeof(RuleInvocation))
	}

}
