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

package org.eclipse.xsemantics.dsl.tests.ui.editor

import com.google.inject.Inject
import org.eclipse.xsemantics.dsl.tests.utils.ui.ProjectImportUtil
import org.eclipse.xsemantics.dsl.ui.tests.XsemanticsUiInjectorProvider
import org.eclipse.xsemantics.dsl.util.XsemanticsUtils
import org.eclipse.xsemantics.dsl.xsemantics.XsemanticsFile
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.testing.AbstractEditorTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XsemanticsUiInjectorProvider))
class XsemanticsEditorTest extends AbstractEditorTest {
	
	val TEST_PROJECT = "org.eclipse.xsemantics.dsl.ui.tests.project"
	
	@Inject extension XsemanticsUtils
	
	@Before
	override void setUp() {
		super.setUp
		createJavaProjectWithXtextNature
	}
	
	def void createJavaProjectWithXtextNature() {
		ProjectImportUtil
					.importJavaProject(TEST_PROJECT)
	}

	def createTestFile(CharSequence contents) {
		createFile(TEST_PROJECT + "/src/test.xsemantics", contents.toString)
	}
	
	@Test
	def void testEditorContentsModifiedInvalidatesComputedModelFeatures() {
		val editor = createTestFile(
'''
system my.test.System

judgments {
	type |- Object o
	type2 ||- Object o
}

axiom TestRule G |- Object o
'''
		).openEditor
		
		var system = editor.xsemanticsSystem
		
		var rule = system.rules.head
		val firstJudgment = system.judgmentDescriptions.head
		
		// the rule refers to the first judgment
		assertSame(firstJudgment, rule.getJudgmentDescription)
		
		// we remove the first judgment and this should invalidate the model
		editor.document.modify [
			xsemanticsSystem.
				judgmentDescriptions.remove(firstJudgment)
		]

		// now the computed feature rule.judgment must be recomputed
		rule = editor.xsemanticsSystem.rules.head
		// and refers to no judgment
		assertNull(rule.getJudgmentDescription)
	}

	def private getXsemanticsSystem(XtextEditor editor) {
		editor.document.readOnly [
			// 'it' is an XtextResource
			xsemanticsSystem
		]
	}

	def private getXsemanticsSystem(XtextResource resource) {
		(resource.contents.get(0) as XsemanticsFile).xsemanticsSystem
	}

}