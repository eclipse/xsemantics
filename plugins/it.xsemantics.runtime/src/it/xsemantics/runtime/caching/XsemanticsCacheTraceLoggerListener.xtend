package it.xsemantics.runtime.caching

import com.google.inject.Inject
import it.xsemantics.runtime.TraceUtils
import it.xsemantics.runtime.XsemanticsCachedData

/**
 * A utility class for recording RuleApplicationTrace strings 
 * involved in XsemanticsCache hits and misses
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
class XsemanticsCacheTraceLoggerListener extends XsemanticsCacheLoggerListener {
	
	@Inject extension TraceUtils

	/**
	 * @since 1.6
	 */
	override cacheHit(XsemanticsCachedData<?> data) {
		if (data.trace !== null)
			hits += dataTraceRepresentation(data)
	}

	/**
	 * @since 1.6
	 */
	override cacheMissed(XsemanticsCachedData<?> data) {
		if (data.trace !== null)
			missed += dataTraceRepresentation(data)
	}

	/**
	 * @since 1.6
	 */
	def dataTraceRepresentation(XsemanticsCachedData<?> data) {
		data.trace.lastElementNotTrace.toString.removeIndentation
	}
}
