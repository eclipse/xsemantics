package it.xsemantics.dsl.tests.runtime

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.runtime.caching.XsemanticsCacheResultLoggerListener
import it.xsemantics.runtime.caching.XsemanticsCacheTraceLoggerListener
import it.xsemantics.runtime.caching.XsemanticsCachedData
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsCacheListenerTest extends XsemanticsBaseTest {
	
	@Inject XsemanticsCacheTraceLoggerListener traceLogger
	
	@Inject XsemanticsCacheResultLoggerListener resultLogger

	@After
	def void setUp() {
		traceLogger.reset
		resultLogger.reset
	}

	@Test
	def void testXsemanticsCacheTraceLoggerListenerWithNull() {
		traceLogger.cacheHit(new XsemanticsCachedData(null, null, null))
		traceLogger.cacheMissed(new XsemanticsCachedData(null, null, null))
	}
	
	@Test
	def void testXsemanticsCacheResultLoggerListenerWithNull() {
		resultLogger.cacheHit(new XsemanticsCachedData(null, null, null))
		resultLogger.cacheMissed(new XsemanticsCachedData(null, null, null))
	}

}