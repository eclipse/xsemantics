package it.xsemantics.dsl.tests.ui.contentassist

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith
import it.xsemantics.dsl.XsemanticsUiInjectorProvider
import static extension org.junit.Assert.*

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
						"<~!", "!~>", "error", "override");
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
			proposal.displayString.assertNotEquals("myNewVar")
		]
		// myNewVar should not be proposed, since it is
		// not visible in that context
	}
}