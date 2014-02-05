package it.xsemantics.tests.swtbot.wizards

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(SWTBotJunit4ClassRunner)
class XsemanticsXImportTests extends XsemanticsWorkbenchBase {
	
	@Test
	def void testProjectWithNoErrors() {
		assertTrue("Project doesn't exist", isProjectCreated(TEST_PROJECT));
		setEditorContents(
'''
system my.test.System

judgments {
	type |- String s
}
'''			
		)
		waitForAutoBuildAndAssertNoErrors
	}

	@Test
	def void testProposalForBasicType() {
'''
system my.test.System

judgments {
	type |- Strin'''.
	assertProposal(
		"String - java.lang",
'''
system my.test.System

judgments {
	type |- String'''
	)			

	}

	@Test
	def void testProposalForJavaList() {
'''
system my.test.System

judgments {
	type |- Lis'''.
	assertProposal(
		"List - java.util",
'''
import java.util.List

system my.test.System

judgments {
	type |- List'''
	)			

	}

	def private void assertProposal(CharSequence input, CharSequence proposal, CharSequence expectedAfterProposal) {
		assertProposal(input, "", proposal, expectedAfterProposal)
	}

	def private void assertProposal(CharSequence input, String textToInsert, CharSequence proposal, CharSequence expectedAfterProposal) {
		val editor = setEditorContents(input)
		
		val lines = input.toString.split("\n").length
		
		editor.toTextEditor.navigateTo(lines-1, 50)
		
		editor.toTextEditor.autoCompleteProposal(textToInsert, 
			proposal.toString
		)
		
		editor.save

		assertEditorText(expectedAfterProposal)
	}
}