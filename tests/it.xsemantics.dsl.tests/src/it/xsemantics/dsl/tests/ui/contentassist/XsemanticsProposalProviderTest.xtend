package it.xsemantics.dsl.tests.ui.contentassist

import it.xsemantics.dsl.XsemanticsUiInjectorProvider
import it.xsemantics.dsl.tests.utils.ui.PluginProjectHelper
import it.xsemantics.dsl.ui.internal.XsemanticsActivator
import it.xsemantics.tests.pde.utils.PDETargetPlatformUtils
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import it.xsemantics.runtime.XsemanticsRuntimeSystem

@InjectWith(typeof(XsemanticsUiInjectorProvider))
@RunWith(typeof(XtextRunner))
public class XsemanticsProposalProviderTest extends
		AbstractContentAssistTest {

	XsemanticsTestFilesForContentAssist testInputs = new XsemanticsTestFilesForContentAssist();
	
	static IJavaProject pluginJavaProject
	
	val static PROJECT_NAME = "customPluginProject"
	
	@BeforeClass
	def static void setUp() {
		PDETargetPlatformUtils.setTargetPlatform();
		
		val injector = XsemanticsActivator.getInstance().getInjector(XsemanticsActivator.IT_XSEMANTICS_DSL_XSEMANTICS);
		
		val projectHelper = injector.getInstance(PluginProjectHelper)
		
		pluginJavaProject = projectHelper.createJavaPluginProject
			(PROJECT_NAME, newArrayList("it.xsemantics.runtime", "org.eclipse.xtext.xbase.lib"))
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
			org.eclipse.xtext.validation.AbstractDeclarativeValidator.name,
			org.eclipse.xtext.validation.ImportUriValidator.name,
			org.eclipse.xtext.validation.NamesAreUniqueValidator.name,
			org.eclipse.xtext.xtext.XtextValidator.name
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