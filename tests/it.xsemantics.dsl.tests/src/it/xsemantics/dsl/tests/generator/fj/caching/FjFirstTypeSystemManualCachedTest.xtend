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
			var trace = new RuleApplicationTrace
			cachedTypeSystem.type(null, trace, it)
			val s = trace.traceAsString
			
			trace = new RuleApplicationTrace
			cachedTypeSystem.type(null, trace, it)
			s.assertEquals(trace.traceAsString)
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
			var trace = new RuleApplicationTrace
			val envForThis = it.environmentWithMappedThisAsContainingClass
			cachedTypeSystem.type(envForThis, trace, it)
			val s = trace.traceAsString
			
			// even though we pass a null environment the cached
			// result is returned
			trace = new RuleApplicationTrace
			val result = cachedTypeSystem.type(null, trace, it)
			(result.value as ClassType).classref.name.assertEquals("A")
			s.assertEquals(trace.traceAsString)
			
			// even though we pass an empty environment the cached
			// result is returned and the passed environment is updated
			// with the cached one
			trace = new RuleApplicationTrace
			val emptyEnv = new RuleEnvironment
			cachedTypeSystem.type(emptyEnv, trace, it)
			s.assertEquals(trace.traceAsString)
			"A".assertEquals((emptyEnv.get("this") as ClassType).classref.name)
		]
	}

	def private firstMethodOfFirstClass(Program p) {
		(p.classes.head.members.head as Method)
	}
}