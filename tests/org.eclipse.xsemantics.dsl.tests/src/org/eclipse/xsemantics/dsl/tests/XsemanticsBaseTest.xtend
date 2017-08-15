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

package org.eclipse.xsemantics.dsl.tests

import com.google.common.base.Joiner
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xsemantics.dsl.XsemanticsConstants
import org.eclipse.xsemantics.dsl.tests.input.FjTypeSystemFiles
import org.eclipse.xsemantics.dsl.tests.input.XsemanticsTestFiles
import org.eclipse.xsemantics.dsl.xsemantics.CheckRule
import org.eclipse.xsemantics.dsl.xsemantics.EnvironmentComposition
import org.eclipse.xsemantics.dsl.xsemantics.EnvironmentMapping
import org.eclipse.xsemantics.dsl.xsemantics.ErrorSpecification
import org.eclipse.xsemantics.dsl.xsemantics.ExpressionInConclusion
import org.eclipse.xsemantics.dsl.xsemantics.JudgmentDescription
import org.eclipse.xsemantics.dsl.xsemantics.OrExpression
import org.eclipse.xsemantics.dsl.xsemantics.Rule
import org.eclipse.xsemantics.dsl.xsemantics.RuleConclusionElement
import org.eclipse.xsemantics.dsl.xsemantics.RuleInvocation
import org.eclipse.xsemantics.dsl.xsemantics.RuleParameter
import org.eclipse.xsemantics.dsl.xsemantics.RuleWithPremises
import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsFile
import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsSystem
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.testing.CompilationTestHelper.Result
import org.junit.runner.RunWith

import static org.junit.Assert.*

import static extension org.eclipse.xtext.EcoreUtil2.*

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
abstract class XsemanticsBaseTest {
	
	@Inject
	protected XsemanticsTestFiles testFiles
	
	@Inject
	protected FjTypeSystemFiles fjTestFiles
	
	@Inject
	protected ParseHelper<XsemanticsFile> parser
	
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider
	
	@Inject extension ValidationTestHelper
	
	new() {
		// the following are useless... but it's just to have coverage
		// for the protected constructors ("required" by sonar)...
		new XsemanticsConstants() {
			
		}
	}
	
//	@BeforeClass
//	def static void setNewLine() {
//		System::setProperty("line.separator", "\n")
//	}
	
	def parseAndAssertNoError(CharSequence s) {
		var ts = parse(s)
		ts.assertNoErrors
		ts
	}

	def parse(CharSequence s) {
		parser.parse(s).xsemanticsSystem
	}

	def parseAndValidate(CharSequence s) {
		parse(s) => [validate]
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
		assertTrue("no rule for index " + index + ", only " + rules.size,
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
		assertTrue("no rule for index " + index + ", only " + rules.size,
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
		assertTrue(o.getClass.name + " is not an instance of " + superClass.name,
			superClass.isAssignableFrom(o.getClass))
	}
	
	def assertOrExpression(XExpression exp, int branches) {
		assertEquals(branches, exp.orExpression.branches.size)
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
	
	def assertEqualsStrings(Object expected, Object actual) {
		assertEquals(
			("" + expected).replaceAll("\r", ""), 
			("" + actual).replaceAll("\r", "")
		)
	}

	def systemExtendsSystemWithJudgments() {
		parseSystemsAndAssertNoErrors(
			testFiles.testJudgmentDescriptions,
			testFiles.testSystemExtendsSystemWithJudgments
		)
	}

	def systemExtendsSystemWithAdditionalJudgment() {
		parseSystemsAndAssertNoErrors(
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
			testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore
		)
	}

	def systemExtendsExtendedTypeSystem() {
		parseSystemsAndAssertNoErrors(
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
			testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore,
			testFiles.testSystemExtendsExtendedTypeSystem
		)
	}

	def systemExtendsSystemWithRuleOverride() {
		#[
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
			testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore,
			testFiles.testSystemExtendsExtendedTypeSystem,
			testFiles.testRuleOverride
		]
	}

	def systemExtendsSystemWithJudgmentOverride() {
		withBaseSystems(testFiles.testOverrideJudgment)
	}

	def withBaseSystems(CharSequence input) {
		#[
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
			testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore,
			testFiles.testSystemExtendsExtendedTypeSystem,
			input
		]
	}

	def parseWithBaseSystems(CharSequence input) {
		withBaseSystems(input).parseSystems
	}

	/**
	 * It returns the system corresponding to the last input in the list.
	 */
	def parseSystems(CharSequence... inputs) {
		val rs = resourceSetProvider.get
		var XsemanticsSystem current = null
		for (input : inputs) {
			current = parser.parse(input, rs).xsemanticsSystem
		}
		return current
	}

	/**
	 * It returns the system corresponding to the last input in the list.
	 */
	def parseSystemsAndAssertNoErrors(CharSequence... inputs) {
		val rs = createResourceSet
		var XsemanticsSystem current = null
		for (input : inputs) {
			current = parser.parse(input, rs).xsemanticsSystem
			current.assertNoErrors
		}
		return current
	}

	def createResourceSet() {
		resourceSetProvider.get
	}

	def getRuleInvocations(EObject element) {
		EcoreUtil2::getAllContentsOfType(element, typeof(RuleInvocation))
	}

	protected def assertNoValidationErrors(Result it) {
		val allErrors = getErrorsAndWarnings.filter[severity == Severity.ERROR]
		if (!allErrors.empty) {
			throw new IllegalStateException("One or more resources contained errors : "+
				Joiner.on(',').join(allErrors)
			);
		}
	}
}
