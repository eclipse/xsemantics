package it.xsemantics.example.fj.tests

import com.google.inject.Inject
import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.example.fj.fj.Program
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJInjectorProvider))
class FjParserTests extends FjBaseTests {

	@Inject extension ParseHelper<Program>
	
	@Inject extension ValidationTestHelper
	
	@Test
	def void testExpressionAssociativity() {
		'''
		class A {
			int myInt;
			int getMyInt() { return this.myInt; }
		}
		'''.parse.assertNoErrors
	}
	

}