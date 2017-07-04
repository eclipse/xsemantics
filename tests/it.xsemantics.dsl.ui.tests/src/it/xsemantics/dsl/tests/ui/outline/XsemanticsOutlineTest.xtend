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

package it.xsemantics.dsl.tests.ui.outline

import it.xsemantics.dsl.tests.utils.ui.PluginProjectHelper
import it.xsemantics.dsl.ui.internal.DslActivator
import it.xsemantics.dsl.ui.tests.XsemanticsUiInjectorProvider
import it.xsemantics.tests.pde.utils.PDETargetPlatformUtils
import org.eclipse.core.runtime.CoreException
import org.eclipse.xtext.testing.Flaky
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.tests.editor.outline.AbstractOutlineWorkbenchTest
import org.junit.BeforeClass
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XsemanticsUiInjectorProvider))
class XsemanticsOutlineTest extends AbstractOutlineWorkbenchTest {

	@Rule
	public Flaky.Rule flakyRule = new Flaky.Rule();
	
	@BeforeClass
	def static void setupTargetPlatform() {
		PDETargetPlatformUtils.setTargetPlatform();
	}
	
	override protected getEditorId() {
		DslActivator.IT_XSEMANTICS_DSL_XSEMANTICS
	}
	
	override protected createTestJavaProject() throws CoreException {
		val injector = DslActivator.getInstance().getInjector(DslActivator.IT_XSEMANTICS_DSL_XSEMANTICS);
		
		val projectHelper = injector.getInstance(PluginProjectHelper)
		
		projectHelper.createJavaPluginProject
			(TEST_PROJECT, newArrayList("it.xsemantics.runtime"))
	}
	
	@Test
	def void testOutline() {
		val outline = getOutlineTreeViewer(
'''
system my.test.System

inject Object injectedField
var Object field

auxiliary {
	aux(String s) : Integer
}

judgments {
	type |- Object o
	type2 ||- Object o
}

auxiliary aux(String s) { 0 }

axiom TestAxiom G |- Object o

rule TestRule G ||- Object o from {}

checkrule TestCheckRule for
	Object o
from {}
'''
		)
		outline.assertAllLabels(
'''
my.test.System
  injectedField
  field
  aux
    aux (aux)
  type
    TestAxiom (type)
  type2
    TestRule (type2)
  TestCheckRule
'''			
		)
	}

	@Test
	def void testEmptyOutline() {
		val outline = getOutlineTreeViewer(
'''
'''
		)
		outline.assertAllLabels(
'''
'''			
		)
	}

	@Test
	def void testOutlineWithNoJudgmentAuxiliaryDescriptions() {
		val outline = getOutlineTreeViewer(
'''
system my.test.System

inject Object injectedField

auxiliary {
	aux(String s) : Integer
}

judgments {
	type |- Object o
}

auxiliary noAuxDesc(String s) { 0 }

axiom NoJudgmentDesc G ||- Object o
'''
		)
		outline.assertAllLabels(
'''
my.test.System
  injectedField
  aux
  type
  noAuxDesc
  NoJudgmentDesc
'''			
		)
	}

	@Flaky
	@Test
	def void testOutlineWithDescriptionInAnotherResourceOnEditorOpen() {
		createFileInTestProject("a",
'''
system my.test.System1

auxiliary {
	aux(String s) : Integer
}

judgments {
	type |- Object o
}
'''
		)
		
		val outline = getOutlineTreeViewer(
'''
system my.test.System extends my.test.System1

// this is not handled at the moment,
// see https://github.com/LorenzoBettini/xsemantics/issues/43
// auxiliary aux(String s) { 0 }

axiom TestAxiom G |- Object o
'''
		)
		outline.assertAllLabels(
'''
my.test.System
  TestAxiom
'''			
		)
	
		// Opening an editor on an existing file does not show the correct outline:
		// the TestAxiom is not contained in the node of the corresponding JudgmentDescription
		// of the supersystem...
		// For the moment this won't work due to the way Xsemantics bind a Rule to
		// the corresponding JudgmentDescription: it relies on resolving the supersystem type reference
		// and get the associated JudgmentDescription.
		// This does not work on opening the editor, since the type reference cannot be resolved
		// (the resource set contains only the resource opened by the editor)
		// as soon as you make a modification in the editor the outline works correctly
		// since the type reference can be resolved, and the associated JudgmentDescription as well.
		// SEE THE FOLLOWING TEST, that simulates editing of the contents of the editor.
	}

	@Ignore("Unreliable Test") @Test
	def void testOutlineWithDescriptionInAnotherResourceOnEditorModification() {
		// Unfortunately this test has problems with synchronizations...
		// it does not work reliably
		createFileInTestProject("a",
'''
system my.test.System1

auxiliary {
	aux(String s) : Integer
}

judgments {
	type |- Object o
}
'''
		)
		
		val outline = getOutlineTreeViewerAfterEditorContentsReplacement(
'''
system my.test.System extends my.test.System1

axiom TestAxiom G |- Object o
'''
		)
		outline.assertAllLabels(
'''
my.test.System
  type
    TestAxiom (type)
'''			
		)
	}
}