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

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExpressionsInjectorProviderFirst))
class ExpressionsFirstInterpreterTests extends ExpressionsInterpreterTests {

	// in this system we don't have coercions, so some
	// interpreter tests must not be executed, since their expressions
	// are not well-typed
	
	@Test
	override void testInterpreterAndOrWithString() {
		
	}
	
	@Test
	override void testInterpreterMultiWithString() {
		
	}
	
	@Test
	override void testInterpreterMinusWithString() {
		
	}
	
	@Test
	override void testSignedWithString() {
		
	}
	
	@Test
	override void testNegationWithString() {
		
	}
	
	@Test
	override void testMixedPlusNonRequestedInt() {
		assertResultAndTrace('''i = '10' + (6 / 3) ''', 0, "102",
'''InterpretPlus: [] |- '10' + (6 / 3) ~> '102'
 InterpretStringLiteral: [] |- '10' ~> '10'
 InterpretMultiOrDiv: [] |- 6 / 3 ~> 2
  InterpretNumberLiteral: [] |- 6 ~> 6
  InterpretNumberLiteral: [] |- 3 ~> 3'''			
		)
	}
	
	@Test
	override void testMixedPlusRequestedInt() {

	}

	@Test
	override void testInterpreterVariableReference() {
		assertResultAndTrace('''
		b = true && true
		i = b && (false || b)''', 1, true,
'''
InterpretAndOr: [] |- b && (false || b) ~> true
 InterpretVariableRefenrence: [] |- b ~> true
  InterpretAndOr: [] |- true && true ~> true
   InterpretBooleanLiteral: [] |- true ~> true
   InterpretBooleanLiteral: [] |- true ~> true
 InterpretAndOr: [] |- false || b ~> true
  InterpretBooleanLiteral: [] |- false ~> false
  InterpretVariableRefenrence: [] |- b ~> true
   InterpretAndOr: [] |- true && true ~> true
    InterpretBooleanLiteral: [] |- true ~> true
    InterpretBooleanLiteral: [] |- true ~> true''')
	}
	
	@Test
	override void testInterpretAndOfComparisons() {
		assertResultAndTrace('''d = (1 < 2) && ('f0' == ('f' + 0))''', 0, true,
'''
InterpretAndOr: [] |- (1 < 2) && ('f0' == ('f' + 0)) ~> true
 InterpretComparison: [] |- 1 < 2 ~> true
  InterpretNumberLiteral: [] |- 1 ~> 1
  InterpretNumberLiteral: [] |- 2 ~> 2
 InterpretEquals: [] |- 'f0' == ('f' + 0) ~> true
  InterpretStringLiteral: [] |- 'f0' ~> 'f0'
  InterpretPlus: [] |- 'f' + 0 ~> 'f0'
   InterpretStringLiteral: [] |- 'f' ~> 'f'
   InterpretNumberLiteral: [] |- 0 ~> 0'''
		)
	}
}