package it.xsemantics.dsl.tests.generator.fj.caching

import com.google.inject.Inject
import it.xsemantics.example.fj.fj.FjPackage
import it.xsemantics.example.fj.typing.FjTypeSystem
import it.xsemantics.example.fjcached.FjcachedInjectorProvider
import it.xsemantics.example.fjcached.fjcached.FjCachedProgram
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(FjcachedInjectorProvider))
@RunWith(typeof(XtextRunner))
class FjCachedTypeSystemResourceSetTest {
	@Inject extension ParseHelper<FjCachedProgram>
	
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
			// in the second program the returned value
			// is not subclass of A anymore
			value.assertError(
				FjPackage.eINSTANCE.^new,
				FjTypeSystem.EXPRESSIONASSIGNABLETOTYPE,
				"new B() is not assignable for A"
			)
		]
	}

	def private getTwoFjPrograms(CharSequence first, CharSequence second) {
		val firstProgram = first.parse.cachedprogram
		val secondProgram = second.parse(firstProgram.eResource.resourceSet).cachedprogram
		firstProgram -> secondProgram
	}
}