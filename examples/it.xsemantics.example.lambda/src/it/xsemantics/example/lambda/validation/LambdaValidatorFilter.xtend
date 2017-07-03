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

package it.xsemantics.example.lambda.validation

import com.google.common.collect.Lists
import com.google.inject.Inject
import it.xsemantics.runtime.RuleFailedException
import it.xsemantics.runtime.TraceUtils
import it.xsemantics.runtime.validation.XsemanticsValidatorFilter

class LambdaValidatorFilter extends XsemanticsValidatorFilter {
	
	@Inject extension TraceUtils
	
	override filterRuleFailedExceptions(RuleFailedException e) {
		val inner = e.innermostRuleFailedExceptionWithNodeModelSources
		if (inner !== null)
			return inner.failureAsList
		else // we must return at least a failure, so we default to the passed one
			return Lists::newArrayList(e)
	}
	
}