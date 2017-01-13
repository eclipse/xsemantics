package it.xsemantics.example.expressions.tests

import com.google.inject.Inject
import it.xsemantics.example.expressions.expressions.Model
import it.xsemantics.runtime.StringRepresentation
import it.xsemantics.runtime.TraceUtils
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExtendedExpressionsInjectorProviderCustom))
class ExpressionsTypingTests extends ExpressionsBaseTests {

	@Inject extension ParseHelper<Model>
	
	@Inject extension TraceUtils
	
	@Inject extension StringRepresentation
	
	@Test
	def void testInt() {
		assertResult('''i = 10 - 5 - 1''', 0, "IntType")
	}
	
	@Test
	def void testArithmeticSigned() {
		assertResult('''i = -(1 + 5)''', 0, "IntType")
	}
	
	@Test
	def void testArithmeticSignedWithString() {
		assertResultAndTrace(
			'''i = -('1')''', 0, 
			"IntType",
'''
ArithmeticSigned: [] |- -('1') : IntType
 StringLiteral: ['expected' <- IntType] |- '1' : IntType
  StringToInt: ['expected' <- IntType] |~ '1' |> IntType''')
	}
	
	@Test
	def void testArithmeticSignedWithStringWrong() {
		assertResultAndTrace(
			'''i = -('zzz')''', 0, 
			null,
'''
failed: cannot type -('zzz')
 StringType cannot be assigned to IntType''')
	}

	@Test
	def void testBooleanNegation() {
		assertResult('''i = !(true)''', 0, "BooleanType")
	}
	
	@Test
	def void testBooleanNegationWithString() {
		assertResultAndTrace(
			'''i = !('true')''', 0, "BooleanType",
'''
BooleanNegation: [] |- !('true') : BooleanType
 StringLiteral: ['expected' <- BooleanType] |- 'true' : BooleanType
  StringToBool: ['expected' <- BooleanType] |~ 'true' |> BooleanType'''
		)
	}
	
	@Test
	def void testBooleanNegationWithStringWrong() {
		assertResultAndTrace(
			'''i = !('abc')''', 0, null,
'''
failed: cannot type !('abc')
 StringType cannot be assigned to BooleanType'''
		)
	}
	
	@Test
	def void testMulti() {
		assertResult('''i = 10 * -(1 + 5)''', 0, "IntType")
	}
	
	@Test
	def void testMultiWithString() {
		assertResult('''i = 10 * -('1' + 5)''', 0, "IntType")
	}
	
	@Test
	def void testMinus() {
		assertResult('''i = 10 - -(1 + 5)''', 0, "IntType")
	}
	
	@Test
	def void testMinusWithString() {
		assertResult('''i = 10 - '1' ''', 0, "IntType")
	}
	
	@Test
	def void testIntPlus() {
		assertResult('''i = 10 + 5 ''', 0, "IntType")
	}
	
	@Test
	def void testStringPlus() {
		assertResult('''i = 10 + 'foo' ''', 0, "StringType")
	}
	
	@Test
	def void testExpectedIntPlus() {
		assertResult('''i = (10 + '1') * 5 ''', 0, "IntType")
	}

	@Test
	def void testAnd() {
		assertResult('''i = true && (false || true)''', 0, "BooleanType")
	}
	
	@Test
	def void testAndWithString() {
		assertResult('''i = true && ('false' || true)''', 0, "BooleanType")
	}
	
	@Test
	def void testVariable() {
		assertResult(
			'''
			i = true && ('false' || true)
			j = i || true''', 1, "BooleanType")
	}
	
	def void assertResult(CharSequence program, int variableIndex, String expectedResult) {
		assertResultAndTrace(program, variableIndex, expectedResult, null)		
	}
	
	def void assertResultAndTrace(CharSequence program, int variableIndex, 
			String expectedResult, CharSequence expectedTrace) {
		val expression = program.parse.variables.get(variableIndex).expression
		val result = semantics.type(null, trace, expression)
		if (expectedResult !== null) {
			if (result.failed) {
				Assert::fail("unexpected failure: " + 
					result.ruleFailedException.failureTraceAsString
				)
			}
			assertEqualsStrings(expectedResult, result.value.string)
			if (expectedTrace !== null)
				assertEqualsStrings(expectedTrace.toString, trace.traceAsString)
		} else {
			if (!result.failed) {
				Assert::fail("unexpected success: " + 
					trace.traceAsString
				)
			}
			if (expectedTrace !== null)
				assertEqualsStrings(expectedTrace.toString,
					result.ruleFailedException.failureTraceAsString
				)
		}
	}
}