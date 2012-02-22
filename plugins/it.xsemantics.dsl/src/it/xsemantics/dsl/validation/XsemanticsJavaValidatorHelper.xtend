package it.xsemantics.dsl.validation

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsUtils
import it.xsemantics.dsl.xsemantics.CheckRule
import it.xsemantics.dsl.xsemantics.Rule

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

}