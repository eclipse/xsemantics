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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.eclipse.xsemantics.dsl.tests.runtime.ResultTests;
import org.eclipse.xsemantics.dsl.tests.runtime.RuleApplicationTraceTests;
import org.eclipse.xsemantics.dsl.tests.runtime.RuleEnvironmentTests;
import org.eclipse.xsemantics.dsl.tests.runtime.RuleFailedExceptionTests;
import org.eclipse.xsemantics.dsl.tests.runtime.StringRepresentationPostProcessorTests;
import org.eclipse.xsemantics.dsl.tests.runtime.StringRepresentationTests;
import org.eclipse.xsemantics.dsl.tests.runtime.TraceUtilsTests;
import org.eclipse.xsemantics.dsl.tests.runtime.XsemanticsCacheListenerTest;
import org.eclipse.xsemantics.dsl.tests.runtime.XsemanticsCacheTests;
import org.eclipse.xsemantics.dsl.tests.runtime.XsemanticsCacheUtilsTests;
import org.eclipse.xsemantics.dsl.tests.runtime.XsemanticsRuntimeSystemTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ResultTests.class,
	RuleFailedExceptionTests.class,
	RuleApplicationTraceTests.class,
	TraceUtilsTests.class,
	StringRepresentationPostProcessorTests.class,
	StringRepresentationTests.class,
	RuleEnvironmentTests.class,
	XsemanticsRuntimeSystemTests.class,
	XsemanticsCacheUtilsTests.class,
	XsemanticsCacheTests.class,
	XsemanticsCacheListenerTest.class
})
public class XsemanticsRuntimeAllTests {

}
