package it.xsemantics.example.lambda.tests

import it.xsemantics.example.lambda.LambdaInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorProvider))
class LambdaParserTest extends LambdaBaseTest {
	
	@Test
	def void testParsingAndLinking() {
		'''
			lambda x . lambda y . x y
		'''.parseAndAssertNoError
	}
}