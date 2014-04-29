package it.xsemantics.dsl.tests.generator.fj.caching

import com.google.inject.Inject
import it.xsemantics.example.fj.fj.Method
import it.xsemantics.example.fj.fj.Program
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.caching.XsemanticsCache
import it.xsemantics.runtime.caching.XsemanticsCacheTraceLoggerListener
import it.xsemantics.runtime.util.TraceUtils
import it.xsemantics.test.fj.first.FjFirstTypeSystem
import org.junit.Before

import static org.junit.Assert.*

abstract class AbstractFjFirstTypeSystemCachedTest {
	
	protected FjFirstTypeSystem cachedTypeSystem
	
	protected XsemanticsCacheTraceLoggerListener logger

	@Inject extension TraceUtils

	@Before
	def void setup() {
		cachedTypeSystem = createCachedTypeSystem
		logger = new XsemanticsCacheTraceLoggerListener
		cachedTypeSystem.cache.addListener(logger)
	}

	def abstract FjFirstTypeSystem createCachedTypeSystem();
	
	def protected assertSubtypingCached(Program p, String className1, String className2, CharSequence expectedTrace) {
		val C1 = p.classes.findFirst[name == className1]
		val C2 = p.classes.findFirst[name == className2]
		
		val trace1 = new RuleApplicationTrace
		cachedTypeSystem.subclass(null, trace1, C1, C2)
		assertEqualsStrings(expectedTrace.toString.trim, trace1.traceAsString.trim)
	}

	def protected assertSubtypingCachedFailed(Program p, String className1, String className2, CharSequence expectedTrace) {
		val C1 = p.classes.findFirst[name == className1]
		val C2 = p.classes.findFirst[name == className2]
		
		val result = cachedTypeSystem.subclass(C1, C2)
		assertEqualsStrings(expectedTrace.toString.trim,
			result.ruleFailedException.failureTraceAsString.trim
		)
	}

	def protected assertSuperclassesCached(Program p, String className1, CharSequence expectedTrace) {
		val C1 = p.classes.findFirst[name == className1]
		
		val trace1 = new RuleApplicationTrace
		cachedTypeSystem.superclasses(trace1, C1)
		assertEqualsStrings(expectedTrace.toString.trim, trace1.traceAsString.trim)
	}

	def protected assertSuperclassesCachedInTypecheck(Program p, String className1, CharSequence expectedTrace) {
		val C1 = p.classes.findFirst[name == className1]
		
		val trace1 = new RuleApplicationTrace
		cachedTypeSystem.check(null, trace1, C1)
		assertEqualsStrings(expectedTrace.toString.trim, trace1.traceAsString.trim)
	}

	def protected assertCacheStatisticsInTypecheck(Program p, XsemanticsCacheTraceLoggerListener listener, 
		String className1, CharSequence expectedHits, CharSequence expectedMissed
	) {
		val C1 = p.classes.findFirst[name == className1]
		
		cachedTypeSystem.check(null, new RuleApplicationTrace, C1)
		assertEqualsStrings(expectedHits.toString.trim, listener.hits.join("\n"))
		assertEqualsStrings(expectedMissed.toString.trim, listener.missed.join("\n"))
	}

	def protected firstMethodOfFirstClass(Program p) {
		(p.classes.head.members.head as Method)
	}

	def protected void assertCachedTrace(RuleApplicationTrace original, RuleApplicationTrace cached) {
		val prepared = new RuleApplicationTrace()
		prepared.addToTrace(XsemanticsCache.CACHED_STRING)
		prepared.addAsSubtrace(original)
		assertEqualsStrings(prepared.traceAsString, cached.traceAsString)
	}

	def protected assertEqualsStrings(Object expected, Object actual) {
		assertEquals(
			("" + expected).replaceAll("\r", ""), 
			("" + actual).replaceAll("\r", "")
		)
	}

}