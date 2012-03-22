package it.xsemantics.dsl.validation

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.InputParameter
import it.xsemantics.dsl.xsemantics.Rule
import org.eclipse.xtext.common.types.JvmFormalParameter
import it.xsemantics.dsl.xsemantics.RuleParameter
import static extension org.eclipse.xtext.EcoreUtil2.*

class XsemanticsJavaValidatorHelper {
	
	@Inject extension XsemanticsUtils
	
	def noRulesWithTheSameName(Rule rule) {
		rule.containingTypeSystem.checkrules.findFirst [
			it != rule && it.name == rule.name
		] == null
	}
	
	def noRulesWithTheSameName(CheckRule rule) {
		rule.containingTypeSystem.rules.findFirst [
			it != rule && it.name == rule.name
		] == null
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