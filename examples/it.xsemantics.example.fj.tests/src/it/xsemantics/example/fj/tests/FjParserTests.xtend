package it.xsemantics.example.fj.tests

import it.xsemantics.example.fj.FJInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJInjectorProvider))
class FjParserTests extends FjBaseTests {
	
	@Test
	def void testParsing() {
		'''
		class A {
			int myInt;
			int getMyInt() { return this.myInt; }
		}
		'''.parseAndAssertNoError
	}
	

}