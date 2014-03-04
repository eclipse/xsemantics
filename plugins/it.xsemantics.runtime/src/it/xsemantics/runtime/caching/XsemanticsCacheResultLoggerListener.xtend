package it.xsemantics.runtime.caching

import com.google.inject.Inject
import it.xsemantics.runtime.StringRepresentation

/**
 * A utility class for recording Result strings 
 * involved in XsemanticsCache hits and misses
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
class XsemanticsCacheResultLoggerListener extends XsemanticsCacheLoggerListener {

	@Inject extension StringRepresentation

	override cacheHit(XsemanticsCachedData<?> data) {
		if (data.result !== null)
			hits += data.result.string
	}

	override cacheMissed(XsemanticsCachedData<?> data) {
		if (data.result !== null)
			missed += data.result.string
	}

}
