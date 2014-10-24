package it.xsemantics.dsl.tests.ui.outline

import it.xsemantics.dsl.XsemanticsUiInjectorProvider
import it.xsemantics.dsl.ui.internal.XsemanticsActivator
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.ui.tests.editor.outline.AbstractOutlineWorkbenchTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Ignore

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XsemanticsUiInjectorProvider))
class XsemanticsOutlineTest extends AbstractOutlineWorkbenchTest {
	
	override protected getEditorId() {
		XsemanticsActivator.IT_XSEMANTICS_DSL_XSEMANTICS
	}
	
	@Test
	def void testOutline() {
		val outline = getOutlineTreeViewer(
'''
system my.test.System

inject Object injectedField

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

	@Ignore("Luna") @Test
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
test
  injectedField
  aux
  type
  noAuxDesc
  NoJudgmentDesc
'''			
		)
	}
}