package it.xsemantics.runtime.caching

import it.xsemantics.runtime.XsemanticsCacheListener
import java.util.ArrayList

/**
 * A utility base class for listening to XsemanticsCache hits and misses
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
abstract class XsemanticsCacheLoggerListener implements XsemanticsCacheListener {

	val hits = new ArrayList<String>
	
	val missed = new ArrayList<String>
	
	override void reset() {
		hits.clear
		missed.clear
	}

	def getHits() {
		return hits
	}

	def getMissed() {
		return missed
	}
}
