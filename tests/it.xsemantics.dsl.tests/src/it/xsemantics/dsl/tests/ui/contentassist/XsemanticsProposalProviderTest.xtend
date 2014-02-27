package it.xsemantics.dsl.tests.ui.contentassist

import it.xsemantics.dsl.XsemanticsUiInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(XsemanticsUiInjectorProvider))
@RunWith(typeof(XtextRunner))
public class XsemanticsProposalProviderTest extends
		AbstractContentAssistTest {

	XsemanticsTestFilesForContentAssist testInputs = new XsemanticsTestFilesForContentAssist();

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
		computeCompletionProposals.forEach[
			proposal |
			assertFalse(proposal.displayString, proposal.displayString == 'myOutputP')
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
			assertFalse(contains('writableVar'))
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
				var declaredVar = 0
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
			assertFalse(contains("myNewVar"))
			assertFalse(contains('myNewVar2'))
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

	def private assertProposalsContain(CharSequence input, String... expected) {
		newBuilder.append(input.toString).
		computeCompletionProposals.map[displayString] => [
			for (e : expected)
				assertTrue(e + " was not proposed in " + join(", "), contains(e))
		]
	}
}