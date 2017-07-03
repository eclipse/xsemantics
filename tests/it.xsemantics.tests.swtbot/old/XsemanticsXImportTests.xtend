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

package it.xsemantics.tests.swtbot.imports

import it.xsemantics.tests.swtbot.XsemanticsWorkbenchBase
import it.xsemantics.tests.swtbot.util.SWTBotEclipseEditorCustom
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(SWTBotJunit4ClassRunner)
class XsemanticsXImportTests extends XsemanticsWorkbenchBase {

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
		
		new SWTBotEclipseEditorCustom(editor.reference, bot).autoCompleteProposal(textToInsert, 
			proposal.toString
		)
		
		editor.save

		assertEditorText(expectedAfterProposal)
	}
}