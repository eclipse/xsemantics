package it.xsemantics.example.lambda.tests

import it.xsemantics.example.lambda.LambdaInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
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