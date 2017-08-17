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

package org.eclipse.xsemantics.example.fj.util

import org.eclipse.xsemantics.example.fj.fj.Expression
import org.eclipse.xsemantics.example.fj.fj.This
import org.eclipse.xsemantics.example.fj.fj.Parameter
import java.util.List
import org.eclipse.xsemantics.example.fj.fj.ParamRef
import org.eclipse.xsemantics.example.fj.fj.MethodBody

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