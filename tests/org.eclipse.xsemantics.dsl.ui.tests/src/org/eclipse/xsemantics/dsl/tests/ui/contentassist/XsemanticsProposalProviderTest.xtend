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

package org.eclipse.xsemantics.dsl.tests.ui.contentassist

import org.eclipse.xsemantics.dsl.tests.utils.ui.PluginProjectHelper
import org.eclipse.xsemantics.dsl.ui.internal.DslActivator
import org.eclipse.xsemantics.dsl.ui.tests.XsemanticsUiInjectorProvider
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem
import org.eclipse.xsemantics.tests.pde.utils.PDETargetPlatformUtils
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.ImportUriValidator
import org.eclipse.xtext.validation.NamesAreUniqueValidator
import org.eclipse.xtext.xtext.XtextValidator
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(XsemanticsUiInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsProposalProviderTest extends
		AbstractContentAssistTest {

	XsemanticsTestFilesForContentAssist testInputs = new XsemanticsTestFilesForContentAssist();
	
	static IJavaProject pluginJavaProject
	
	val static PROJECT_NAME = "customPluginProject"
	
	@BeforeClass
	def static void setUp() {
		PDETargetPlatformUtils.setTargetPlatform();
		
		val injector = DslActivator.getInstance().getInjector(DslActivator.ORG_ECLIPSE_XSEMANTICS_DSL_XSEMANTICS);
		
		val projectHelper = injector.getInstance(PluginProjectHelper)
		
		pluginJavaProject = projectHelper.createJavaPluginProject
			(PROJECT_NAME, newArrayList("org.eclipse.xsemantics.runtime", "org.eclipse.xtext.xbase.lib"))
	}
	
	@AfterClass
	def static void tearDown() {
		pluginJavaProject.project.delete(true, new NullProgressMonitor)
	}
	
	override getJavaProject(ResourceSet resourceSet) {
		pluginJavaProject
	}

	@Test
	def void testProposalsForJudgmentSymbol() {
		newBuilder().append(testInputs.inputForJudgmentSymbols())
				.assertText("|-", "|=", "|>", "||-", "||=", "||>", "||~", "|~");
	}

	@Test
	def void testProposalsForRelationSymbol() {
		newBuilder().append(testInputs.inputForRelationSymbols())
				.assertText(":", "<:", ":>", "<<", ">>", "<|", "|>", "<-",
						"-->", "<~", "~>", "~~", "<!", "!>", "<<!", "!>>",
						"<~!", "!~>", "cached", "error", "override", "\\/", "/\\");
	}

	@Test
	def void testProposalsForInjectionsInConclusion() {
		newBuilder.
		append(testInputs.inputForInjections).
		append(
		'''
		rule TestRule
			G |- EObject o : my'''
		).
		assertProposal("mylist")
	}

	@Test
	def void testProposalsForInjectionsInPremises() {
		newBuilder.
		append(testInputs.inputForInjections).
		append(
		'''
		rule TestRule
			G |- EObject o : EClass myOutputParam
		from {
			my'''
		).
		assertProposal("mylist")
	}

	@Test
	def void testProposalsForOutputParam() {
		newBuilder.
		append(testInputs.inputForInjections).
		append(
		'''
		rule TestRule
			G |- EObject o : EClass myOutputParam
		from {
			my'''
		).
		assertProposal("myOutputParam")
	}

	@Test
	def void testProposalsForVarDeclInRuleInvocation() {
		newBuilder.
		append(testInputs.inputForInjections).
		append(
		'''
		rule TestRule
			G |- EObject o : EClass myOutputParam
		from {
			G |- o : var EClass myNewVar
			my'''
		).
		assertProposal("myNewVar")
	}

	@Test
	def void testProposalsForVarDeclInRuleInvocation2() {
		newBuilder.
		append(testInputs.inputForRuleInvocation).
		append(
		'''
		rule TestRule
			G |- EObject o : EClass o1 : EClass o2
		from {
			G |- o : var EClass myNewVar : my'''
		).
		computeCompletionProposals.forEach[
			proposal |
			assertFalse(proposal.displayString, proposal.displayString == 'myNewVar')
		]
		// myNewVar should not be proposed, since it is
		// not visible in that context
	}

	@Test
	def void testNoOutputParamsInClosure() {
		newBuilder.
		append(
		'''
		import java.util.ArrayList

		system my.test.TypeSystem
			
		judgments {
			type |- Object o : output Object
		}
		
		rule Type G |- String inputP : Object myOutputP
		from {
			new ArrayList().findFirst [
				println('''
		).
		computeCompletionProposals.map[displayString] => [
			assertTrue(contains('myOutputP')) // in Xbase 2.6.0 that's proposed as well
		]
	}

	@Test
	def void testNoWritableVarInClosure() {
		newBuilder.
		append(
		'''
		import java.util.ArrayList

		system my.test.TypeSystem
			
		judgments {
			type |- Object o : output Object
		}
		
		rule Type G |- String inputP : Object myOutputP
		from {
			val nonWritable = 1
			var writableVar = 0
			new ArrayList().findFirst [
				println('''
		).
		computeCompletionProposals.map[displayString] => [
			assertTrue(contains("nonWritable"))
			assertTrue(contains('writableVar')) // in Xbase 2.6.0 that's proposed as well
		]
	}

	@Test
	def void testWritableVarOutsideClosure() {
		newBuilder.
		append(
		'''
		import java.util.ArrayList

		system my.test.TypeSystem
			
		judgments {
			type |- Object o : output Object
		}
		
		rule Type G |- String inputP : Object myOutputP
		from {
			val nonWritable = 1
			var writableVar = 0
			println('''
		).
		computeCompletionProposals.map[displayString] => [
			assertTrue(contains("nonWritable"))
			assertTrue(contains('writableVar'))
		]
	}

	@Test
	def void testProposalsForStandardBlocks() {
		'''
		import java.util.ArrayList
		
		system my.test.TypeSystem
			
		judgments {
			type |- Object o
		}
		
		rule Type G |- String s
		from {
			for (loopVar : new ArrayList()) {
				var declaredVar = 0;
				println('''
		.assertProposalsContain("loopVar", "declaredVar")
	}

	@Test
	def void testProposalsForVarDeclInRuleInvocationFromClosure() {
		newBuilder.
		append(testInputs.inputForRuleInvocation).
		append(
		'''
		rule TestRule
			G |- EObject o : EClass o1 : EClass o2
		from {
			G |- o : var EClass myNewVar : var EClass myNewVar2
			new java.util.ArrayList().forEach[
				println('''
		).
		computeCompletionProposals.map[displayString] => [
			assertFalse(contains("myNewVar")) // in Xbase 2.6.0 that's proposed as well
			assertFalse(contains('myNewVar2')) // in Xbase 2.6.0 that's proposed as well
		]
	}

	@Test
	def void testProposalsForVarDeclInRuleInvocationOutsideClosure() {
		newBuilder.
		append(testInputs.inputForRuleInvocation).
		append(
		'''
		rule TestRule
			G |- EObject o : EClass o1 : EClass o2
		from {
			G |- o : var EClass myNewVar : var EClass myNewVar2
			for (loopVar : new java.util.ArrayList()) {
				println('''
		).
		computeCompletionProposals.map[displayString] => [
			assertTrue(contains("myNewVar"))
			assertTrue(contains('myNewVar2'))
		]
	}

	@Test
	def void testProposalsForCachedClause() {
		'''
		import java.util.ArrayList
		
		system my.test.TypeSystem
			
		judgments {
			type |- Object o '''
		.assertProposalsContain("cached")
	}

	@Test
	def void testProposalsForSystemExtends() {
		newBuilder.
		append(
		'''
		system my.test.TypeSystem extends '''
		).
		assertText(XsemanticsRuntimeSystem.name);
		// that's the only possible completion in this test:
		// a system can extend only a type that is-a XsemanticsRuntimeSystem
	}

	@Test
	def void testProposalsForValidatorExtends() {
		newBuilder.
		append(
		'''
		system my.test.TypeSystem 
		
		validatorExtends '''
		).
		assertText(
			AbstractDeclarativeValidator.name,
			ImportUriValidator.name,
			NamesAreUniqueValidator.name,
			XtextValidator.name
		);
		// that's the only possible completion in this test:
		// a validator can extend only a type that is-a AbstractDeclarativeValidator
	}

	@Test
	def void testProposalForBasicType() {
		newBuilder.
		append(
'''
system my.test.System

judgments {
	type |- Strin''').
		applyProposal("String").
		expectContent(
'''
system my.test.System

judgments {
	type |- String'''
		)	

	}

	@Test
	def void testProposalAndImportForListType() {
		newBuilder.
		append(
'''
system my.test.System

judgments {
	type |- LinkedL''').
		applyProposal("LinkedList").
		expectContent(
'''
import java.util.LinkedList

system my.test.System

judgments {
	type |- LinkedList'''
		)	

	}

	def private assertProposalsContain(CharSequence input, String... expected) {
		newBuilder.append(input.toString).
		computeCompletionProposals.map[displayString] => [
			for (e : expected)
				assertTrue(e + " was not proposed in " + join(", "), contains(e))
		]
	}
}