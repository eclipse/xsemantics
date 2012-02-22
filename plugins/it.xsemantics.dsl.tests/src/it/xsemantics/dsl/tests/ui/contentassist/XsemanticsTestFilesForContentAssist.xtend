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
}