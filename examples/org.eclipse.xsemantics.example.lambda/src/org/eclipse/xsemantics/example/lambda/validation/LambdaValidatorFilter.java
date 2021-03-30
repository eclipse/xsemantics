/**
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 */
package org.eclipse.xsemantics.example.lambda.validation;

import static com.google.common.collect.Lists.newArrayList;

import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.TraceUtils;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorFilter;

import com.google.inject.Inject;

public class LambdaValidatorFilter extends XsemanticsValidatorFilter {
	@Inject
	private TraceUtils traceUtils;

	@Override
	public Iterable<RuleFailedException> filterRuleFailedExceptions(final RuleFailedException e) {
		final RuleFailedException inner = traceUtils.innermostRuleFailedExceptionWithNodeModelSources(e);
		if (inner != null) {
			return traceUtils.failureAsList(inner);
		} else {
			return newArrayList(e);
		}
	}
}
