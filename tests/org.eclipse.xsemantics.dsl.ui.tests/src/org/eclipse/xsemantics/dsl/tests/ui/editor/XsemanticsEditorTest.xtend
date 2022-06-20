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
import java.nio.file.Paths
import java.nio.file.Files
import java.util.stream.Collectors
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.xtext.ui.editor.reconciler.XtextReconciler
import java.io.IOException

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
		ProjectImportUtil.importJavaProject(TEST_PROJECT)
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
			xsemanticsSystem.judgmentDescriptions.remove(firstJudgment)
		]

		// now the computed feature rule.judgment must be recomputed
		rule = editor.xsemanticsSystem.rules.head
		// and refers to no judgment
		assertNull(rule.getJudgmentDescription)
	}

	@Test
	def void testModificationInEditorDoesNotGenerateXtextReconcilerJobException() throws Exception {
		// see https://github.com/eclipse/xsemantics/issues/155
		// see https://github.com/LorenzoBettini/javamm/issues/132
		// see https://github.com/LorenzoBettini/jbase/issues/131
		val testProgram = '''
			import org.eclipse.emf.ecore.EObject
			import org.eclipse.emf.ecore.EClass
			
			system org.xtext.example.mydsl.typing.MyDslTyping
			
			judgments {
				inferName |- EObject g : output String
			}
			
			rule InferName
				G |- EClass g : String n
			from {
				if (true) {
					System.out.println("")
				}
			}
		'''
		val createTestFile = createTestFile(testProgram);
		waitForBuild();
		val openEditor = openEditor(createTestFile);
		val document = openEditor.getDocumentProvider()
				.getDocument(openEditor.getEditorInput());
		val offset = document.get().indexOf('"');
		document.replace(offset+1, 0, "h");
		assertEquals('''
			import org.eclipse.emf.ecore.EObject
			import org.eclipse.emf.ecore.EClass
			
			system org.xtext.example.mydsl.typing.MyDslTyping
			
			judgments {
				inferName |- EObject g : output String
			}
			
			rule InferName
				G |- EClass g : String n
			from {
				if (true) {
					System.out.println("h")
				}
			}
		'''.toString, document.get());
		Job.getJobManager().join(XtextReconciler.getName(), monitor());
		assertNoXtextReconcilerJobInLog();
		openEditor.doSave(monitor());
		waitForBuild();
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

	def private void assertNoXtextReconcilerJobInLog() throws IOException {
		val location = root().getLocation();
		val logPath = Paths.get(location + "/.metadata/.log");
		if (!Files.exists(logPath))
			return;
		val readAllLines = Files.readAllLines(logPath);
		for (String string : readAllLines) {
			if (string.contains("An internal error occurred during: \"XtextReconcilerJob\""))
				fail("found XtextReconcilerJob exception:\n" +
					readAllLines.stream().collect(Collectors.joining("\n")));
		}
	}
}
