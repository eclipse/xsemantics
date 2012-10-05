package it.xsemantics.example.fj.util

import it.xsemantics.example.fj.fj.Expression
import it.xsemantics.example.fj.fj.This
import it.xsemantics.example.fj.fj.Parameter
import java.util.List
import it.xsemantics.example.fj.fj.ParamRef
import it.xsemantics.example.fj.fj.MethodBody

import static extension org.eclipse.xtext.EcoreUtil2.*

class FjSemanticsUtils {
	
	def replaceThisAndParams(MethodBody body, Expression thisReplacement, List<Parameter> params, List<Expression> args) {
		body.copy => [
			eAllOfType(typeof(This)).forEach [
				eContainer.replace(
					eContainingFeature,
					it,
					thisReplacement.copy
				)
			]
			eAllOfType(typeof(ParamRef)).forEach [
				val paramIndex = params.indexOf(it.parameter)
				eContainer.replace(
					eContainingFeature,
					it,
					args.get(paramIndex).copy
				)
			]
		]
	}

	def replaceThis(MethodBody body, Expression thisReplacement) {
		body.copy.expression => [
			eAllOfType(typeof(This)).forEach [
				eContainer.replace(
					eContainingFeature,
					it,
					thisReplacement.copy
				)
			]
		]
	}

	def replaceParams(MethodBody body, List<Parameter> params, List<Expression> args) {
		body.copy.expression => [
			eAllOfType(typeof(ParamRef)).forEach [
				val paramIndex = params.indexOf(it.parameter)
				eContainer.replace(
					eContainingFeature,
					it,
					args.get(paramIndex).copy
				)
			]
		]
	}
}