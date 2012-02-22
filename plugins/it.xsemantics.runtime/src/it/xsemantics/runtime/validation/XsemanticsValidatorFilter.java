/**
 * 
 */
package it.xsemantics.runtime.validation;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.util.TraceUtils;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Provides and possibly filters error information
 * 
 * @author Lorenzo Bettini
 * 
 */
public class XsemanticsValidatorFilter {

	@Inject
	protected TraceUtils traceUtils;

	public Iterable<RuleFailedException> filterRuleFailedExceptions(
			RuleFailedException e) {
		final RuleFailedException inner = traceUtils
						.innermostRuleFailedExceptionWithNodeModelSources(e);
		if (inner != null)
			return Lists.newArrayList(inner);
		// we must return at least a failure, so we default to the passed one
		return Lists.newArrayList(e);
	}

	public Iterable<ErrorInformation> filterErrorInformation(
			RuleFailedException e) {
		return traceUtils.filteredErrorInformation(e);
	}
}
