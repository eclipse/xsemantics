package it.xsemantics.dsl.tests.ui.contentassist

class XsemanticsTestFilesForContentAssist {
	
	def inputForJudgmentSymbols() {
'''
system my.test.ts.TypeSystem

judgments {
	type '''.toString
	}
	
	def inputForRelationSymbols() {
'''
system my.test.ts.TypeSystem

judgments {
	type |- Object o '''.toString
	}

	def inputForInjections() {
'''
system my.test.ts.TypeSystem

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EClass
import java.util.List

inject List<EClass> mylist

judgments {
	type |- EObject o : output EClass
}

'''.toString
	}
}