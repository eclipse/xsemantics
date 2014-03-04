package it.xsemantics.runtime.caching

import static extension org.eclipse.xtext.util.Strings.*

/**
 * A utility class for recording RuleApplicationTrace strings 
 * involved in XsemanticsCache hits and misses
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
class XsemanticsCacheTraceLoggerListener extends XsemanticsCacheLoggerListener {

	override cacheHit(XsemanticsCachedData<?> data) {
		if (data.trace !== null)
			hits += dataTraceRepresentation(data)
	}

	override cacheMissed(XsemanticsCachedData<?> data) {
		if (data.trace !== null)
			missed += dataTraceRepresentation(data)
	}

	def dataTraceRepresentation(XsemanticsCachedData<?> data) {
		data.trace.trace.head.toString.removeLeadingWhitespace
	}
}
