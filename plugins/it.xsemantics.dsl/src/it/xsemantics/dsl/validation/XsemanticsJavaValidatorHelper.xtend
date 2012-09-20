package it.xsemantics.dsl.validation

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.Rule
import org.eclipse.xtext.common.types.JvmFormalParameter
import it.xsemantics.dsl.xsemantics.RuleParameter
import it.xsemantics.dsl.xsemantics.JudgmentDescription

import static extension org.eclipse.xtext.EcoreUtil2.*
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription

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
	
	def findDuplicateParameter(RuleParameter param) {
		param.containingRule.conclusion.
			conclusionElements.typeSelect(typeof(RuleParameter)).
				map([ it.parameter ]).
					findDuplicateJvmFormalParameter(param.parameter)
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

}