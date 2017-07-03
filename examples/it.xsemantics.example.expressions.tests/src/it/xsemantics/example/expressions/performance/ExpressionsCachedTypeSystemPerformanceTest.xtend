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

package it.xsemantics.example.expressions.performance

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(CachedExpressionsInjectorProviderCustom))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ExpressionsCachedTypeSystemPerformanceTest extends AbstractExpressionsPerformanceTest {

	@Test def aWarmUp() {
		testPerformance(10)
	}

	@Test def testPerformance10() {
		testPerformance(10)
	}

	@Test def testPerformance12() {
		testPerformance(12)
	}

	@Test def testPerformance14() {
		testPerformance(14)
	}

	@Test def testPerformance16() {
		testPerformance(16)
	}

	@Test def testPerformance18() {
		testPerformance(18)
	}

	@Test def testPerformance30() {
		testPerformance(30)
	}

	@Test def testPerformance50() {
		testPerformance(50)
	}

}