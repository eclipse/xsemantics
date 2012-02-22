package it.xsemantics.dsl.tests.input

import it.xsemantics.dsl.tests.input.XsemanticsTestFiles

class FjTypeSystemFiles extends XsemanticsTestFiles {
	
	def fjTypeSystem() '''
	system it.xsemantics.test.Fj
	'''
	
	def fjTypeSystemWithImports() '''
	«fjTypeSystem»
	
	import it.xsemantics.example.fj.fj.*
	'''
	
	def fjJudgmentDescriptions() '''
	«fjTypeSystemWithImports»
	
	judgments {
		type |- Expression expression : output Type
		subtype |- Type left <: Type right
	}
	'''
	
	def fjExpressionTypeRules() '''
	«fjJudgmentDescriptions»
	
	axiom TNew
		G |- New newExp : newExp.type
	
	rule BasicSubtyping
		derives G |- BasicType left <: BasicType right
	from {
		left.basic.equals(right.basic)
	}
	'''
	
}