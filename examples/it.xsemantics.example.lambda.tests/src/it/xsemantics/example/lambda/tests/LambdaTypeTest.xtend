package it.xsemantics.example.lambda.tests

import it.xsemantics.example.lambda.lambda.Abstraction
import it.xsemantics.example.lambda.lambda.Term
import it.xsemantics.runtime.RuleEnvironment
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaTypeTest extends LambdaBaseTest {
	
	@Test
	def void testStringConstantType() {
		assertAbstractionTermType("lambda x . 'foo'", "String", "")
	}
	
	@Test
	def void testIntConstantType() {
		assertAbstractionTermType("lambda x . 10", "int", "")
	}
	
	@Test
	def void testExplicitParamType() {
		assertParamType("lambda x : int . x", "int")
	}
	
	@Test
	def void testImplicitParamType() {
		assertParamType("lambda x . x", "X1")
	}
	
	@Test
	def void testExplicitVariableType() {
		val abstraction = "lambda x : int . x".abstraction
		assertType(abstraction.environmentForParam, abstraction.term.variable,
			"int", "")
	}
	
	@Test
	def void testImplicitVariableType() {
		val abstraction = "lambda x . x".abstraction
		assertType(abstraction.environmentForParam, abstraction.term.variable,
			"X1", "")
	}
	
	@Test
	def void testArithmeticsConstantType() {
		assertAbstractionTermType("lambda x . -10", "int", "")
	}
	
	@Test
	def void testArithmeticsWithTypeVariable() {
		assertAbstractionType("lambda x . -x", "int -> int", "X1=int")
	}
	
	@Test
	def void testArithmeticsFails() {
		assertAbstractionTypeFailureTrace("lambda x . - 'foo'",
			traces.arithmeticsFails()
		)
	}
	
	@Test
	def void testAbstractionExplicitVariableType() {
		assertAbstractionType("lambda x : int . x",
			"int -> int", "")
	}
	
	@Test
	def void testAbstractionImplicitVariableType() {
		val abstraction = "lambda x . x".abstraction
		assertType(abstraction,
			"a -> a", "")
	}
	
	@Test
	def void testAbstractionWithArithmetics() {
		assertType("lambda x . -x".abstraction,
			"int -> int", "X1=int")
	}
	
	@Test
	def void testApplicationType() {
		assertAbstractionType("lambda x .lambda y . x y", "(a -> b) -> a -> b",
		"X1=(X3 -> X4), X2=X5, X3=X5")
	}
	
	@Test
	def void testApplicationType2() {
		assertAbstractionType("lambda x .lambda y . y x", "a -> (a -> b) -> b",
		"X1=X5, X2=(X3 -> X4), X3=X5")
	}
	
	@Test
	def void testCompose() {
		assertAbstractionType("lambda f . lambda g. lambda x. (f (g x))",
		"(a -> b) -> (c -> a) -> c -> b",
		"X1=(X4 -> X5), X2=(X6 -> X7), X3=X8, X4=X9, X6=X8, X7=X9")
	}
	
	@Test
	def void testCompose2() {
		assertAbstractionType("lambda f . lambda g. lambda x. (g (f x))",
		"(a -> b) -> (b -> c) -> a -> c",
		"X1=(X6 -> X7), X2=(X4 -> X5), X3=X8, X4=X9, X6=X8, X7=X9")
	}
	
	@Test
	def void testCompose3() {
		assertAbstractionType("lambda x . lambda y. lambda z. x z (y z)",
		"(a -> b -> c) -> (a -> b) -> a -> c",
		"X9=X11, X10=X12, X1=(X4 -> X5), X2=(X9 -> X10), X3=X6, X4=X6, X5=(X7 -> X8), X6=X11, X7=X12")
	}
	
	@Test
	def void testOmega() {
		assertAbstractionTypeFailureTrace("lambda x . x x", traces.omegaFails())
	}

	@Test
	def void testOmega2() {
		assertAbstractionTypeFailureTrace
		("lambda f . lambda g. lambda x. (f (f f))", 
'''
failed: AbstractionType: [] |- subst{X1=(X4 -> X5), X4=X8, X5=X9, X6=X8, X7=X9} |> lambda f . (lambda g . (lambda x . ((f (f f))))) : ArrowType
 failed: AbstractionType: [f <- X1] |- subst{X1=(X4 -> X5), X4=X8, X5=X9, X6=X8, X7=X9} |> lambda g . (lambda x . ((f (f f)))) : ArrowType
  failed: AbstractionType: [f <- X1, g <- X2] |- subst{X1=(X4 -> X5), X4=X8, X5=X9, X6=X8, X7=X9} |> lambda x . ((f (f f))) : ArrowType
   failed: ApplicationType: [f <- X1, g <- X2, x <- X3] |- subst{X1=(X4 -> X5), X4=X8, X5=X9, X6=X8, X7=X9} |> (f (f f)) : Type
    failed: ApplicationType: [f <- X1, g <- X2, x <- X3] |- subst{X1=(X4 -> X5), X4=X8, X5=X9, X6=X8, X7=X9} |> (f f) : Type
     failed: cannot unify X8 with (X8 -> X9)
      failed: X8 occurs in (X8 -> X9)
       failed: X8 occurs in X8
        failed: variable.typevarName != other.typevarName'''
		)
	}
	
	def environmentForParam(Abstraction abstraction) {
		val env = new RuleEnvironment()
		env.add(abstraction.param, system.paramtype(abstraction.param).value)
		env
	}
	
	def void assertParamType(CharSequence prog, String expectedType) {
		assertResultAsString(
			system.paramtype(prog.abstraction.param), expectedType
		)
	}
	
	def void assertAbstractionTypeFailureTrace(CharSequence prog, CharSequence expectedTrace) {
		assertFailureTrace(system.type(null, trace, substitutions, prog.abstraction), expectedTrace)
	}
	
	def void assertAbstractionType(CharSequence prog, String expectedType, String expectedSubsts) {
		assertType(null, prog.abstraction, expectedType, expectedSubsts)
	}
	
	def void assertAbstractionTermType(CharSequence prog, String expectedType, String expectedSubsts) {
		assertType(null, prog.abstraction.term, expectedType, expectedSubsts)
	}
	
	def void assertType(CharSequence prog, String expectedType, String expectedSubsts) {
		assertType(null, prog.term, expectedType, expectedSubsts)
	}
	
	def void assertType(Term term, String expectedType, String expectedSubsts) {
		assertType(null, term, expectedType, expectedSubsts)
	}
	
	def void assertType(RuleEnvironment env, Term term, String expectedType, String expectedSubsts) {
		assertResultAsStringBeautifier(
			system.type(env, null, substitutions, term), expectedType
		)
		assertTypeSubstitutions(substitutions, expectedSubsts)
	}
}