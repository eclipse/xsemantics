package it.xsemantics.example.fj.util

import it.xsemantics.example.fj.fj.Expression
import it.xsemantics.example.fj.fj.New
import it.xsemantics.example.fj.fj.Constant

class FjValueUtils {
	
	def dispatch isValue(Expression exp) { false }
	
	def dispatch isValue(Constant exp) { true }
	
	def dispatch isValue(New exp) {
		exp.args.forall [
			it.isValue
		]
	}
}