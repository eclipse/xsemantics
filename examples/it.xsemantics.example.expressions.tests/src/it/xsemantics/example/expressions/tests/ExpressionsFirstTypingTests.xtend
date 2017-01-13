package it.xsemantics.example.expressions.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExpressionsInjectorProviderFirst))
class ExpressionsFirstTypingTests extends ExpressionsTypingTests {

	@Test
	override void testArithmeticSignedWithString() {
		assertResultAndTrace(
			'''i = -('1')''', 0, 
			null,
'''
failed: cannot type -('1')
 StringType cannot be assigned to IntType''')
	}
	
	@Test
	override void testBooleanNegationWithString() {
		assertResultAndTrace(
			'''i = !('true')''', 0, null,
'''
failed: cannot type !('true')
 StringType cannot be assigned to BooleanType'''
		)
	}
	
	@Test
	override void testMultiWithString() {
		assertResult('''i = 10 * -('1' + 5)''', 0, null)
	}
	
	@Test
	override void testMinusWithString() {
		assertResult('''i = 10 - '1' ''', 0, null)
	}
	
	@Test
	override void testExpectedIntPlus() {
		assertResult('''i = (10 + '1') * 5 ''', 0, null)
	}
	
	@Test
	override void testAndWithString() {
		assertResult('''i = true && ('false' || true)''', 0, null)
	}
	
	@Test
	override void testVariable() {
		assertResult(
			'''
			i = true && ('false' || true)
			j = i || true''', 1, null)
	}
}