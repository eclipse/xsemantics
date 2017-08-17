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

package org.eclipse.xsemantics.dsl.tests.performance

import com.google.inject.Inject
import org.eclipse.xsemantics.dsl.tests.XsemanticsBaseTest
import org.eclipse.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsPerformanceTest extends XsemanticsBaseTest {

	@Inject extension CompilationTestHelper

	@Rule
	@Inject public TemporaryFolder temporaryFolder

	@Test
	def void testBigFile() {
		resourceSet.getResource(
			URI.createURI(
			"./tests_performance_input_files/PerformanceTest.xsemantics"), true
		)
		resourceSet.compile[]
	}

}
