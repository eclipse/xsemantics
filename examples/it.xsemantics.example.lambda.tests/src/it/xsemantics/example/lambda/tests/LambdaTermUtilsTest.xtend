package it.xsemantics.example.lambda.tests

import it.xsemantics.example.lambda.xsemantics.LambdaTermUtils
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaTermUtilsTest extends LambdaBaseTest {
	
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
		val beforeCloning= reprForSubstitutions.string(program)
		val clone = LambdaTermUtils::cloneWithoutTypes(program.term)
		Assert::assertEquals(expected.toString, reprForSubstitutions.string(clone))
		// make sure the original program is not modified
		Assert::assertEquals(beforeCloning, reprForSubstitutions.string(program))
	}
}