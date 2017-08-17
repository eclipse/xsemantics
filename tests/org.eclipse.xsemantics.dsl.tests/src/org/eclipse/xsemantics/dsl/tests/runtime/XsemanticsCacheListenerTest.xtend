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

package org.eclipse.xsemantics.dsl.tests.runtime

import com.google.inject.Inject
import org.eclipse.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.xsemantics.dsl.tests.XsemanticsBaseTest
import org.eclipse.xsemantics.runtime.XsemanticsCachedData
import org.eclipse.xsemantics.runtime.caching.XsemanticsCacheResultLoggerListener
import org.eclipse.xsemantics.runtime.caching.XsemanticsCacheTraceLoggerListener
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsCacheListenerTest extends XsemanticsBaseTest {
	
	@Inject XsemanticsCacheTraceLoggerListener traceLogger
	
	@Inject XsemanticsCacheResultLoggerListener resultLogger

	@After
	def void setUp() {
		traceLogger.reset
		resultLogger.reset
	}

	@Test
	def void testXsemanticsCacheTraceLoggerListenerWithNull() {
		traceLogger.cacheHit(new XsemanticsCachedData(null, null, null))
		traceLogger.cacheMissed(new XsemanticsCachedData(null, null, null))
	}
	
	@Test
	def void testXsemanticsCacheResultLoggerListenerWithNull() {
		resultLogger.cacheHit(new XsemanticsCachedData(null, null, null))
		resultLogger.cacheMissed(new XsemanticsCachedData(null, null, null))
	}

}