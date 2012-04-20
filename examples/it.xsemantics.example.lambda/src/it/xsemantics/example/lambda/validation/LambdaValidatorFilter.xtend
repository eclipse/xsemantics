package it.xsemantics.example.lambda.validation

import it.xsemantics.runtime.validation.XsemanticsValidatorFilter
import it.xsemantics.runtime.RuleFailedException
import com.google.inject.Inject
import it.xsemantics.runtime.util.TraceUtils
import com.google.common.collect.Lists

class LambdaValidatorFilter extends XsemanticsValidatorFilter {
	
	@Inject extension TraceUtils
	
	override filterRuleFailedExceptions(RuleFailedException e) {
		val inner = e.innermostRuleFailedExceptionWithNodeModelSources
		if (inner != null)
			return inner.failureAsList
		else // we must return at least a failure, so we default to the passed one
			return Lists::newArrayList(e)
	}
	
}