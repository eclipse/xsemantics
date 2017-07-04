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

package it.xsemantics.dsl.validation

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.Injected
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.JudgmentDescription
import it.xsemantics.dsl.xsemantics.Rule
import org.eclipse.xtext.common.types.JvmFormalParameter

import static extension org.eclipse.xtext.EcoreUtil2.*

class XsemanticsJavaValidatorHelper {
	
	@Inject extension XsemanticsUtils
	
	def noRulesWithTheSameNameOfCheckRule(Rule rule) {
		rule.containingSystem.checkrules.findFirst [
			it != rule && it.name == rule.name
		] == null
	}
	
	def noRulesWithTheSameName(Rule rule) {
		rule.containingSystem.rules.findFirst [
			it != rule && it.name == rule.name
		] == null
	}
	
	def noCheckRulesWithTheSameNameOfRule(CheckRule rule) {
		rule.containingSystem.rules.findFirst [
			it != rule && it.name == rule.name
		] == null
	}
	
	def noCheckRulesWithTheSameName(CheckRule rule) {
		rule.containingSystem.checkrules.findFirst [
			it != rule && it.name == rule.name
		] == null
	}
	
	def judgmentDescriptionWithTheSameName(JudgmentDescription j) {
		j.containingSystem.allJudgments.findFirst [
			it != j && it.name == j.name
		]
	}

	def auxiliaryDescriptionWithTheSameName(AuxiliaryDescription aux) {
		aux.containingSystem.auxiliaryDescriptions.findFirst [
			it != aux && it.name == aux.name
		]
	}
	
	def auxiliaryDescriptionWithTheSameNameOfJudgment(AuxiliaryDescription aux) {
		aux.containingSystem.judgmentDescriptions.findFirst [
			it != aux && it.name == aux.name
		]
	}
	
	def findDuplicateParameter(InputParameter param) {
		param.containingJudgmentDescription.judgmentParameters.
			typeSelect(typeof(InputParameter)).
				map([ it.parameter ]).
					findDuplicateJvmFormalParameter(param.parameter)
	}
	
	def findDuplicateJvmFormalParameter(Iterable<JvmFormalParameter> params, JvmFormalParameter param) {
		params.exists [ 
			it != param && it.name == param.name
		]
	}
	
	def hasDuplicateInjectedField(Injected i) {
		i.containingSystem.injections.exists[
			it != i && it.name == i.name
		]
	}

}