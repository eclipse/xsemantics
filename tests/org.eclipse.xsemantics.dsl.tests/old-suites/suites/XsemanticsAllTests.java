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

package org.eclipse.xsemantics.dsl.tests.suites;

import org.eclipse.xsemantics.dsl.tests.performance.XsemanticsPerformanceTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	XsemanticsDslAllTests.class,
	XsemanticsRuntimeAllTests.class,
	XsemanticsGeneratorAllTests.class,
	XsemanticsGeneratedTypeSystemsAllTests.class,
	XsemanticsCachedTypeSystemsAllTests.class,
//	XsemanticsExamplesAllTests.class,
	XsemanticsPerformanceTest.class
})
public class XsemanticsAllTests {

}
