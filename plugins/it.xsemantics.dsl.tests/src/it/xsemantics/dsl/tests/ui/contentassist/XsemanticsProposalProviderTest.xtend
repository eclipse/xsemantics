package it.xsemantics.dsl.tests.ui.contentassist

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith
import it.xsemantics.dsl.XsemanticsUiInjectorProvider

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

}