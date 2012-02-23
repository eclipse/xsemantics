package it.xsemantics.example.expressions.tests

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.junit.Test

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
'''InterpretPlus: [] |- '10' + (6 / 3) ~> 102
 InterpretStringLiteral: [] |- '10' ~> 10
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
}