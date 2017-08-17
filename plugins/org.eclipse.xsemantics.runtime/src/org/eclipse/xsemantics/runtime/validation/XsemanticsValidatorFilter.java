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

/**
 * 
 */
package org.eclipse.xsemantics.runtime.validation;

import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.TraceUtils;

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
		if (inner != null) {
			return Lists.newArrayList(inner);
		}
		// we must return at least a failure, so we default to the passed one
		return Lists.newArrayList(e);
	}

	public Iterable<ErrorInformation> filterErrorInformation(
			RuleFailedException e) {
		return traceUtils.filteredErrorInformation(e);
	}
}
