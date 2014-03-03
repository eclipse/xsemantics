package it.xsemantics.runtime.caching

import it.xsemantics.runtime.caching.XsemanticsCacheListener
import it.xsemantics.runtime.caching.XsemanticsCachedData
import java.util.ArrayList

import static extension org.eclipse.xtext.util.Strings.*

/**
 * A utility class for recording RuleApplicationTrace strings 
 * involved in XsemanticsCache hits and misses
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
class XsemanticsCacheTraceLoggerListener extends XsemanticsCacheListener {

	val hits = new ArrayList<String>
	
	val missed = new ArrayList<String>

	override cacheHit(XsemanticsCachedData<?> data) {
		super.cacheHit(data)
		hits += data.trace.trace.head.toString.removeLeadingWhitespace
	}

	override cacheMissed(XsemanticsCachedData<?> data) {
		super.cacheMissed(data)
		missed += data.trace.trace.head.toString.removeLeadingWhitespace
	}

	def getHits() {
		return hits
	}

	def getMissed() {
		return missed
	}
}
