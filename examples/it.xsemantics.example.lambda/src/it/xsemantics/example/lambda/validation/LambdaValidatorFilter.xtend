package it.xsemantics.example.lambda.validation

import it.xsemantics.runtime.validation.XsemanticsValidatorFilter
import it.xsemantics.runtime.RuleFailedException
import com.google.inject.Inject
import it.xsemantics.runtime.util.TraceUtils

class LambdaValidatorFilter extends XsemanticsValidatorFilter {
	
	@Inject extension TraceUtils
	
	override filterRuleFailedExceptions(RuleFailedException e) {
		e.innermostRuleFailedExceptionWithNodeModelSources.failureAsList
	}
	
}