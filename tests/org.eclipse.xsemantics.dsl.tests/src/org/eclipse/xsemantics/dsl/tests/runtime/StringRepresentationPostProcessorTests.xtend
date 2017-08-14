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

import com.google.common.base.Strings
import com.google.inject.Inject
import org.eclipse.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.xsemantics.dsl.tests.XsemanticsBaseTest
import org.eclipse.xsemantics.runtime.StringRepresentationPostProcessor
import org.junit.Assert
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class StringRepresentationPostProcessorTests extends XsemanticsBaseTest {
	
	@Inject extension StringRepresentationPostProcessor processor
	
	@Test
	def void testStopAtNewLineAbsent() {
		assertEqualsStrings("no new line", "no new line".stopAtNewLine)
	}
	
	@Test
	def void testStopAtNewLine() {
		assertEqualsStrings("no new line", 
		'''
		no new line
		some new
		lines
		'''.toString.stopAtNewLine)
	}
	
	@Test
	def void testLimitTo() {
		assertEqualsStrings("1234...", "123456".limitChars(4))
	}
	
	@Test
	def void testLimitToWithSmaller() {
		assertEqualsStrings("12", "12".limitChars(4))
	}
	
	@Test
	def void testLimitSameLength() {
		assertEqualsStrings("12", "12".limitChars(2))
	}
	
	@Test
	def void testProcessNull() {
		assertEqualsStrings("", process(null))
	}
	
	@Test
	def void testProcessLongString() {
		Assert::assertEquals(processor.maxChars +
			processor.omissis.length,
			Strings::repeat("a", processor.maxChars + 30)
				.process.length
		)
	}
	
	@Test
	def void testProcess() {
		assertEqualsStrings("no new line", 
		'''
		no new line
		some new
		lines
		'''.toString.process)
	}
}