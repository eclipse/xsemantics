package it.xsemantics.example.fj.util

import it.xsemantics.example.fj.fj.Expression
import it.xsemantics.example.fj.fj.New
import it.xsemantics.example.fj.fj.Constant

import static extension org.eclipse.xtext.EcoreUtil2.*
import it.xsemantics.example.fj.fj.This
import it.xsemantics.example.fj.fj.Parameter
import java.util.List
import it.xsemantics.example.fj.fj.ParamRef

class FjSemanticsUtils {
	
	def dispatch isValue(Expression exp) { false }
	
	def dispatch isValue(Constant exp) { true }
	
	def dispatch isValue(New exp) {
		exp.args.forall [
			it.isValue
		]
	}
	
	def replaceThis(Expression exp, Expression replacement) {
		exp.getAllContentsOfType(typeof(This)).forEach [
			eContainer.replace(
				eContainingFeature,
				it,
				replacement.copy
			)
		]
	}

	def replaceParams(Expression exp, List<Parameter> params, List<Expression> args) {
		exp.getAllContentsOfType(typeof(ParamRef)).forEach [
			val paramIndex = params.indexOf(it.parameter)
			eContainer.replace(
				eContainingFeature,
				it,
				args.get(paramIndex).copy
			)
		]
	}
}