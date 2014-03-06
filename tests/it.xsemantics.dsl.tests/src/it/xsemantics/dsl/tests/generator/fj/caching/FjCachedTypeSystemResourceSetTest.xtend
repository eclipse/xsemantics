package it.xsemantics.dsl.tests.generator.fj.caching

import com.google.inject.Inject
import it.xsemantics.example.fj.FjCachedTypeSystemInjectorProvider
import it.xsemantics.example.fj.fj.Program
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(FjCachedTypeSystemInjectorProvider))
@RunWith(typeof(XtextRunner))
class FjCachedTypeSystemResourceSetTest {
	@Inject extension ParseHelper<Program>
	
	@Inject extension ValidationTestHelper
	
	@Test
	def void testTwoFjFiles() {
		getTwoFjPrograms(
			'''
			class A {}
			class B extends A {}
			''',
			'''
			class C {
				A m() { return new B(); }
			}
			'''
		) => [
			// second program
			value.assertNoErrors
			
			// now change the first file
			key.classes.last.superclass = null
			
			key.assertNoErrors
			value.assertNoErrors
		]
	}

	def private getTwoFjPrograms(CharSequence first, CharSequence second) {
		val firstProgram = first.parse
		val secondProgram = second.parse(firstProgram.eResource.resourceSet)
		firstProgram -> secondProgram
	}
}