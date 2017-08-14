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

package org.eclipse.xsemantics.runtime.caching

import com.google.inject.Inject
import org.eclipse.xsemantics.runtime.TraceUtils
import org.eclipse.xsemantics.runtime.XsemanticsCachedData

/**
 * A utility class for recording RuleApplicationTrace strings 
 * involved in XsemanticsCache hits and misses
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
class XsemanticsCacheTraceLoggerListener extends XsemanticsCacheLoggerListener {
	
	@Inject extension TraceUtils

	/**
	 * @since 1.6
	 */
	override cacheHit(XsemanticsCachedData<?> data) {
		if (data.trace !== null)
			hits += dataTraceRepresentation(data)
	}

	/**
	 * @since 1.6
	 */
	override cacheMissed(XsemanticsCachedData<?> data) {
		if (data.trace !== null)
			missed += dataTraceRepresentation(data)
	}

	/**
	 * @since 1.6
	 */
	def dataTraceRepresentation(XsemanticsCachedData<?> data) {
		data.trace.lastElementNotTrace.toString.removeIndentation
	}
}
