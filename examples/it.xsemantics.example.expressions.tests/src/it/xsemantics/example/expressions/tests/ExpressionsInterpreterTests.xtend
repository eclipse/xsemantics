package it.xsemantics.example.expressions.tests

import com.google.inject.Inject
import it.xsemantics.example.expressions.expressions.Model
import it.xsemantics.runtime.util.TraceUtils
import junit.framework.Assert
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExpressionsInjectorProviderCustom))
class ExpressionsInterpreterTests extends ExpressionsBaseTests {

	@Inject extension ParseHelper<Model>
	
	@Inject extension TraceUtils
	
	@Test
	def void testInterpreter() {
		assertResult('''i = 10 - 5 - 1''', 0, 4)
	}
	
	@Test
	def void testInterpreterAndOr() {
		assertResult('''i = true && (false || true)''', 0, true)
	}
	
	@Test
	def void testInterpreterAndOrWithString() {
		assertResult('''i = true && (false || 'true')''', 0, true)
	}
	
	@Test
	def void testInterpreterMulti() {
		assertResult('''i = 2 * 3''', 0, 6)
	}
	
	@Test
	def void testInterpreterMultiWithString() {
		assertResult('''i = 2 * '3' ''', 0, 6)
	}
	
	@Test
	def void testInterpreterDiv() {
		assertResult('''i = 6 / 3''', 0, 2)
	}
	
	@Test
	def void testInterpreterMinus() {
		assertResult('''i = 6 - 2''', 0, 4)
	}
	
	@Test
	def void testInterpreterMinusWithString() {
		assertResult('''i = 6 - '2' ''', 0, 4)
	}
	
	@Test
	def void testSigned() {
		assertResult('''i = -2''', 0, -2)
	}
	
	@Test
	def void testSignedWithString() {
		assertResult('''i = -'2' ''', 0, -2)
	}
	
	@Test
	def void testNegation() {
		assertResult('''i = !true''', 0, false)
	}
	
	@Test
	def void testNegationWithString() {
		assertResult('''i = !'true' ''', 0, false)
	}
	
	@Test
	def void testStringComparisonEquals() {
		assertResult('''i = 'foo' == 'foo' ''', 0, true)
	}
	
	@Test
	def void testStringComparisonLess() {
		assertResult('''i = 'foa' < 'foo' ''', 0, true)
	}
	
	@Test
	def void testIntComparisonEquals() {
		assertResult('''i = 5 == (1+4) ''', 0, true)
	}
	
	@Test
	def void testIntComparisonLess() {
		assertResult('''i = 5 < 10 ''', 0, true)
	}
	
	@Test
	def void testIntPlus() {
		assertResult('''i = 5 + 10 ''', 0, 15)
	}
	
	@Test
	def void testStringPlus() {
		assertResult('''i = 'foo' + 'bar' ''', 0, "foobar")
	}
	
	@Test
	def void testMixedPlus() {
		assertResult('''i = 'foo' + 10 ''', 0, "foo10")
	}
	
	@Test
	def void testMixedPlusNonRequestedInt() {
		assertResultAndTrace('''i = '10' + (6 / 3) ''', 0, "102",
'''InterpretPlus: [] |- '10' + (6 / 3) ~> 102
 InterpretStringLiteral: [] |- '10' ~> 10
 InterpretMultiOrDiv: [] |- 6 / 3 ~> 2
  InterpretNumberLiteral: [expected <- IntType] |- 6 ~> 6
  InterpretNumberLiteral: [expected <- IntType] |- 3 ~> 3'''			
		)
	}

	@Test
	def void testMixedPlusRequestedInt() {
		assertResultAndTrace('''i = 'foo' + '10' * (6 / 3) ''', 0, "foo20",
'''InterpretPlus: [] |- 'foo' + '10' * (6 / 3) ~> foo20
 InterpretStringLiteral: [] |- 'foo' ~> foo
 InterpretMultiOrDiv: [] |- '10' * (6 / 3) ~> 20
  InterpretStringLiteral: [expected <- IntType] |- '10' ~> 10
  InterpretMultiOrDiv: [expected <- IntType] |- 6 / 3 ~> 2
   InterpretNumberLiteral: [expected <- IntType] |- 6 ~> 6
   InterpretNumberLiteral: [expected <- IntType] |- 3 ~> 3'''			
		)
	}
	
	@Test
	def void testInterpreterVariableReference() {
		assertResultAndTrace('''
		b = true && 'true'
		i = b && (false || b)''', 1, true,
'''
InterpretAndOr: [] |- b && (false || b) ~> true
 InterpretVariableRefenrence: [expected <- BooleanType] |- b ~> true
  InterpretAndOr: [expected <- BooleanType] |- true && 'true' ~> true
   InterpretBooleanLiteral: [expected <- BooleanType] |- true ~> true
   InterpretStringLiteral: [expected <- BooleanType] |- 'true' ~> true
 InterpretAndOr: [expected <- BooleanType] |- false || b ~> true
  InterpretBooleanLiteral: [expected <- BooleanType] |- false ~> false
  InterpretVariableRefenrence: [expected <- BooleanType] |- b ~> true
   InterpretAndOr: [expected <- BooleanType] |- true && 'true' ~> true
    InterpretBooleanLiteral: [expected <- BooleanType] |- true ~> true
    InterpretStringLiteral: [expected <- BooleanType] |- 'true' ~> true''')
	}
	
	def void assertResult(CharSequence program, int variableIndex, Object expectedResult) {
		assertResultAndTrace(program, variableIndex, expectedResult, null)		
	}
	
	def void assertResultAndTrace(CharSequence program, int variableIndex, 
			Object expectedResult, CharSequence expectedTrace) {
		val expression = program.parse.variables.get(variableIndex).expression
		val result = semantics.interpret(null, trace, expression)
		if (result.failed) {
			Assert::fail("unexpected failure: " + 
				result.ruleFailedException.failureTraceAsString
			)
		}
		Assert::assertEquals(expectedResult.toString, result.value.toString)		
		if (expectedTrace != null)
			Assert::assertEquals(expectedTrace.toString, trace.traceAsString)
	}
}