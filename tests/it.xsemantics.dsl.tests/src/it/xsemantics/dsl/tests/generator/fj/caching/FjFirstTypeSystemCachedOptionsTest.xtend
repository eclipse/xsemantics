package it.xsemantics.dsl.tests.generator.fj.caching

import com.google.inject.Inject
import com.google.inject.Provider
import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.example.fj.fj.Program
import it.xsemantics.test.fj.caching.FjFirstCachedOptionsTypeSystem
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(FJInjectorProvider))
@RunWith(typeof(XtextRunner))
class FjFirstTypeSystemCachedOptionsTest extends FjFirstTypeSystemCachedTest {
	
	@Inject Provider<FjFirstCachedOptionsTypeSystem> cachedTypeSystemProvider
	
	@Inject extension ParseHelper<Program>

	override createCachedTypeSystem() {
		cachedTypeSystemProvider.get()
	}

	@Test
	override void testFailureCached() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertSubtypingCachedFailedResult("D", "C", "")

			// failures are not cached because entry point methods are not cached
			assertSubtypingCachedFailedResult("D", "C", "")
		]
	}
}