package it.xsemantics.dsl.validation

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.Rule
import org.eclipse.xtext.common.types.JvmFormalParameter
import it.xsemantics.dsl.xsemantics.RuleParameter
import static extension org.eclipse.xtext.EcoreUtil2.*
import it.xsemantics.dsl.xsemantics.JudgmentDescription

class XsemanticsJavaValidatorHelper {
	
	@Inject extension XsemanticsUtils
	
	def noRulesWithTheSameNameOfCheckRule(Rule rule) {
		rule.containingTypeSystem.checkrules.findFirst [
			it != rule && it.name == rule.name
		] == null
	}
	
	def noRulesWithTheSameName(Rule rule) {
		rule.containingTypeSystem.rules.findFirst [
			it != rule && it.name == rule.name
		] == null
	}
	
	def noCheckRulesWithTheSameNameOfRule(CheckRule rule) {
		rule.containingTypeSystem.rules.findFirst [
			it != rule && it.name == rule.name
		] == null
	}
	
	def noCheckRulesWithTheSameName(CheckRule rule) {
		rule.containingTypeSystem.checkrules.findFirst [
			it != rule && it.name == rule.name
		] == null
	}
	
	def judgmentDescriptionWithTheSameName(JudgmentDescription j) {
		j.containingTypeSystem.allJudgments.findFirst [
			it != j && it.name == j.name
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