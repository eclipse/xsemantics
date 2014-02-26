package it.xsemantics.dsl.tests.generator.fj.caching

import com.google.inject.Inject
import it.xsemantics.example.fj.fj.Program
import it.xsemantics.test.fj.first.FjFirstTypeSystem
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(FjFirstTypeSystemManualCachedInjectorProvider))
@RunWith(typeof(XtextRunner))
class FjFirstTypeSystemManualCachedTest {
	
	@Inject FjFirstTypeSystemManualCached cachedTypeSystem
	
	@Inject FjFirstTypeSystem origTypeSystem
	
	@Inject extension ParseHelper<Program> 
	
	@Test
	def void testCachedTyping() {
		'''
		class A {}
		new A()
		'''.
		parse.main => [
			var r1 = cachedTypeSystem.type(it)
			var r2 = cachedTypeSystem.type(it)
			assertSame(r1, r2)
			
			r1 = origTypeSystem.type(it)
			r2 = origTypeSystem.type(it)
			assertNotSame(r1, r2)
		]
	}
}