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

package org.eclipse.xsemantics.example.lambda.tests

import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaTermUtils
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaTermUtilsTest extends LambdaAbstractBaseTest {

	@Test
	def void testExplicitType() {
		assertCloneWithoutTypes("lambda x : int . x", "lambda x . (x)")
	}

	@Test
	def void testExplicitTypes() {
		assertCloneWithoutTypes(
			"lambda x : int . lambda y : a -> b . y x",
			"lambda x . (lambda y . ((y x)))"
		)
	}

	@Test
	def void testNoTypes() {
		assertCloneWithoutTypes(
			"lambda x . lambda y . y x",
			"lambda x . (lambda y . ((y x)))"
		)
	}

	def void assertCloneWithoutTypes(CharSequence original, CharSequence expected) {
		val program = original.parseAndAssertNoError
		val beforeCloning = reprForSubstitutions.string(program)
		val clone = LambdaTermUtils::cloneWithoutTypes(program.term)
		Assert::assertEquals(expected.toString, reprForSubstitutions.string(clone))
		// make sure the original program is not modified
		Assert::assertEquals(beforeCloning, reprForSubstitutions.string(program))
	}
}
