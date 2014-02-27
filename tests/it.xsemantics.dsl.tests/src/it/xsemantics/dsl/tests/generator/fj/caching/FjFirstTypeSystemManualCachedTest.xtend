package it.xsemantics.dsl.tests.generator.fj.caching

import com.google.inject.Inject
import it.xsemantics.example.fj.fj.Method
import it.xsemantics.example.fj.fj.Program
import it.xsemantics.example.fj.util.FjTypeUtils
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.util.TraceUtils
import it.xsemantics.test.fj.first.FjFirstTypeSystem
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*
import it.xsemantics.example.fj.fj.ClassType
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.caching.XsemanticsCache
import it.xsemantics.dsl.tests.runtime.XsemanticsCacheTraceLoggerListener

@InjectWith(typeof(FjFirstTypeSystemManualCachedInjectorProvider))
@RunWith(typeof(XtextRunner))
class FjFirstTypeSystemManualCachedTest {
	
	@Inject FjFirstTypeSystemManualCached cachedTypeSystem
	
	@Inject FjFirstTypeSystem origTypeSystem
	
	@Inject extension ParseHelper<Program>
	
	@Inject extension TraceUtils

	@Inject extension FjTypeUtils
	
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
	def void testCachedSubtyping() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertSubtypingCached("B", "A", 
'''
Subclassing: [] |- class B extends A {} <| class A {}
 Subclassing: [] |- class A {} <| class A {}
'''
			)
			
			// note that it reuses the cached subclasses(B, A)
			assertSubtypingCached("C", "A", 
'''
Subclassing: [] |- class C extends B {} <| class A {}
 cached:
  Subclassing: [] |- class B extends A {} <| class A {}
   Subclassing: [] |- class A {} <| class A {}
'''
			)

			// note that it reuses the cached subclasses(A, A)
			assertSubtypingCached("D", "A", 
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
			assertSubtypingCachedFailed("D", "C", 
'''
failed: Subclassing: [] |- class D extends A {} <| class C extends B {}
 failed: Subclassing: [] |- class A {} <| class C extends B {}
  failed: class1.superclass != null
'''
			)

			assertSubtypingCachedFailed("D", "C", 
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
   superclasses(class B extends A {}) = [class A {}]
  Methods: [] ||~ class B extends A {} >> []
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
		val logger = new XsemanticsCacheTraceLoggerListener
		cachedTypeSystem.cache.addListener(logger)
		
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertCacheStatisticsInTypecheck(logger,"C",
'''
''',
'''
superclasses(class C extends B {}) = [class B extends A {}, class A {}]
superclasses(class B extends A {}) = [class A {}]
'''
			)
			
			assertCacheStatisticsInTypecheck(logger,"C",
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
		cachedTypeSystem.cache.removeListener(logger)
	}

	def private assertSubtypingCached(Program p, String className1, String className2, CharSequence expectedTrace) {
		val C1 = p.classes.findFirst[name == className1]
		val C2 = p.classes.findFirst[name == className2]
		
		val trace1 = new RuleApplicationTrace
		cachedTypeSystem.subclass(null, trace1, C1, C2)
		expectedTrace.toString.trim.assertEquals(trace1.traceAsString.trim)
	}

	def private assertSubtypingCachedFailed(Program p, String className1, String className2, CharSequence expectedTrace) {
		val C1 = p.classes.findFirst[name == className1]
		val C2 = p.classes.findFirst[name == className2]
		
		val result = cachedTypeSystem.subclass(C1, C2)
		expectedTrace.toString.trim.assertEquals(
			result.ruleFailedException.failureTraceAsString.trim
		)
	}

	def private assertSuperclassesCached(Program p, String className1, CharSequence expectedTrace) {
		val C1 = p.classes.findFirst[name == className1]
		
		val trace1 = new RuleApplicationTrace
		cachedTypeSystem.superclasses(trace1, C1)
		expectedTrace.toString.trim.assertEquals(trace1.traceAsString.trim)
	}

	def private assertSuperclassesCachedInTypecheck(Program p, String className1, CharSequence expectedTrace) {
		val C1 = p.classes.findFirst[name == className1]
		
		val trace1 = new RuleApplicationTrace
		cachedTypeSystem.check(null, trace1, C1)
		expectedTrace.toString.trim.assertEquals(trace1.traceAsString.trim)
	}

	def private assertCacheStatisticsInTypecheck(Program p, XsemanticsCacheTraceLoggerListener listener, 
		String className1, CharSequence expectedHits, CharSequence expectedMissed
	) {
		val C1 = p.classes.findFirst[name == className1]
		
		cachedTypeSystem.check(null, new RuleApplicationTrace, C1)
		expectedHits.toString.trim.assertEquals(listener.hits.join("\n"))
		expectedMissed.toString.trim.assertEquals(listener.missed.join("\n"))
	}

	def private firstMethodOfFirstClass(Program p) {
		(p.classes.head.members.head as Method)
	}

	def private void assertCachedTrace(RuleApplicationTrace original, RuleApplicationTrace cached) {
		val prepared = new RuleApplicationTrace()
		prepared.addToTrace(XsemanticsCache.CACHED_STRING)
		prepared.addAsSubtrace(original)
		prepared.traceAsString.assertEquals(cached.traceAsString)
	}

}