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

package org.eclipse.xsemantics.example.expressions.tests

import com.google.inject.Inject
import org.eclipse.xsemantics.example.expressions.typing.ExpressionsSemantics
import org.eclipse.xsemantics.runtime.RuleApplicationTrace
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExpressionsInjectorProvider))
abstract class ExpressionsAbstractBaseTests {

	@Inject protected ExpressionsSemantics semantics

	protected RuleApplicationTrace trace

//	@BeforeClass
//	def static void setNewLine() {
//		System::setProperty("line.separator", "\n")
//	}

	@Before
	def void setUp() {
		trace = new RuleApplicationTrace()
	}

	def assertEqualsStrings(Object expected, Object actual) {
		Assert.assertEquals(
			("" + expected).replaceAll("\r", ""),
			("" + actual).replaceAll("\r", "")
		)
	}
}
