package it.xsemantics.dsl.tests.generator.fj.caching

import com.google.inject.Inject
import com.google.inject.Provider
import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.example.fj.fj.ClassType
import it.xsemantics.example.fj.fj.Program
import it.xsemantics.example.fj.util.FjTypeUtils
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.StringRepresentation
import it.xsemantics.runtime.TraceUtils
import it.xsemantics.test.fj.first.FjFirstTypeSystem
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

@InjectWith(typeof(FJInjectorProvider))
@RunWith(typeof(XtextRunner))
class FjFirstTypeSystemManualCachedTest extends AbstractFjFirstTypeSystemCachedTest {
	
	@Inject Provider<FjFirstTypeSystemManualCached> cachedTypeSystemProvider

	@Inject FjFirstTypeSystem origTypeSystem
	
	@Inject extension ParseHelper<Program>
	
	@Inject extension TraceUtils

	@Inject extension FjTypeUtils
	
	@Inject extension StringRepresentation
	
	override createCachedTypeSystem() {
		cachedTypeSystemProvider.get()
	}
	
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

	@Test
	def void testCachedRuleApplicationTrace() {
		'''
		class A {}
		new A()
		'''.
		parse.main => [
			val trace = new RuleApplicationTrace
			cachedTypeSystem.type(null, trace, it)
			
			val trace2 = new RuleApplicationTrace
			cachedTypeSystem.type(null, trace2, it)
			trace.assertCachedTrace(trace2)
		]
	}

	@Test
	def void testEnvironmentIsCached() {
		'''
		class A {
			A m() { return this; }
		}
		'''.
		parse.firstMethodOfFirstClass.body.expression => [
			val trace = new RuleApplicationTrace
			val envForThis = it.environmentWithMappedThisAsContainingClass
			cachedTypeSystem.type(envForThis, trace, it)
			
			// even though we pass a null environment the cached
			// result is returned
			val trace2 = new RuleApplicationTrace
			val result = cachedTypeSystem.type(null, trace2, it)
			(result.value as ClassType).classref.name.assertEquals("A")
			trace.assertCachedTrace(trace2)
			
			// even though we pass an empty environment the cached
			// result is returned and the passed environment is updated
			// with the cached one
			val trace3 = new RuleApplicationTrace
			val emptyEnv = new RuleEnvironment
			cachedTypeSystem.type(emptyEnv, trace3, it)
			trace.assertCachedTrace(trace3)
			"A".assertEquals((emptyEnv.get("this") as ClassType).classref.name)
		]
	}

	@Test
	def void testCachedDataDoesNotChangeEnvironmentsAndTraceIfTheyAreTheSame() {
		'''
		class A {}
		new A()
		'''.
		parse.main => [
			var trace = new RuleApplicationTrace
			val env = new RuleEnvironment
			cachedTypeSystem.type(env, trace, it)
			val envRepr = env.string
			trace = new RuleApplicationTrace
			cachedTypeSystem.type(env, trace, it)
			'''
			cached:
			 TNew: [] |- new A() : A'''.assertEqualsStrings(trace.traceAsString)
			envRepr.assertEquals(env.string)
		]
	}

	@Test
	def void testCachedSubclass() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertSubclassCached("B", "A", 
'''
Subclassing: [] |- class B extends A {} <| class A {}
 Subclassing: [] |- class A {} <| class A {}
'''
			)
			
			// note that it reuses the cached subclasses(B, A)
			assertSubclassCached("C", "A", 
'''
Subclassing: [] |- class C extends B {} <| class A {}
 cached:
  Subclassing: [] |- class B extends A {} <| class A {}
'''
			)

			// note that it reuses the cached subclasses(A, A)
			assertSubclassCached("D", "A", 
'''
Subclassing: [] |- class D extends A {} <| class A {}
 cached:
  Subclassing: [] |- class A {} <| class A {}
'''
			)
		]
	}

	@Test
	def void testFailureNotCached() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertSubclassCachedFailed("D", "C", 
'''
failed: Subclassing: [] |- class D extends A {} <| class C extends B {}
 failed: Subclassing: [] |- class A {} <| class C extends B {}
  failed: class1.superclass != null
'''
			)

			assertSubclassCachedFailed("D", "C", 
'''
failed: Subclassing: [] |- class D extends A {} <| class C extends B {}
 failed: Subclassing: [] |- class A {} <| class C extends B {}
  failed: class1.superclass != null
'''
			)
		]
	}

	@Test
	def void testCachedSuperclasses() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertSuperclassesCached("B", 
'''
superclasses(class B extends A {}) = [class A {}]
'''
			)
			
			assertSuperclassesCached("B", 
'''
cached:
 superclasses(class B extends A {}) = [class A {}]
'''
			)
		
			// superclasses is not recursive so we don't reuse
			// computation of previous superclasses
			assertSuperclassesCached("C", 
'''
superclasses(class C extends B {}) = [class B extends A {}, class A {}]
'''
			)
		]
	}

	@Test
	def void testCachedSuperclassesUsedInTypecheck() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertSuperclassesCachedInTypecheck("C",
'''
CheckClass: [] |- class C extends B {}
 superclasses(class C extends B {}) = [class B extends A {}, class A {}]
 Fields: [] ||- class B extends A {} >> []
  superclasses(class B extends A {}) = [class A {}]
 Methods: [] ||~ class B extends A {} >> []
'''
			)
		
			// we reuse the superclasses computation
			// implicitly also when computing fields
			assertSuperclassesCachedInTypecheck("C",
'''
CheckClass: [] |- class C extends B {}
 cached:
  superclasses(class C extends B {}) = [class B extends A {}, class A {}]
 Fields: [] ||- class B extends A {} >> []
  cached:
   superclasses(class B extends A {}) = [class A {}]
 Methods: [] ||~ class B extends A {} >> []
'''
			)
		]
	}

	@Test
	def void testXsemanticsCacheListener() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertCacheStatisticsInTypecheck(traceLogger,"C",
'''
''',
'''
superclasses(class C extends B {}) = [class B extends A {}, class A {}]
superclasses(class B extends A {}) = [class A {}]
'''
			)
			
			assertCacheStatisticsInTypecheck(traceLogger,"C",
'''
superclasses(class C extends B {}) = [class B extends A {}, class A {}]
superclasses(class B extends A {}) = [class A {}]
''',
'''
superclasses(class C extends B {}) = [class B extends A {}, class A {}]
superclasses(class B extends A {}) = [class A {}]
'''
			)
		]
		cachedTypeSystem.cache.removeListener(traceLogger)
	}

}