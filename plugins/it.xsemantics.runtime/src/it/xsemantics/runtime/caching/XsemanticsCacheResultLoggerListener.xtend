package it.xsemantics.runtime.caching

import com.google.inject.Inject
import it.xsemantics.runtime.StringRepresentation
import it.xsemantics.runtime.XsemanticsCachedData

/**
 * A utility class for recording Result strings 
 * involved in XsemanticsCache hits and misses
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
class XsemanticsCacheResultLoggerListener extends XsemanticsCacheLoggerListener {

	@Inject extension StringRepresentation

	/**
	 * @since 1.6
	 */
	override cacheHit(XsemanticsCachedData<?> data) {
		if (data.result !== null)
			hits += resultRepresentation(data)
	}

	/**
	 * @since 1.6
	 */
	override cacheMissed(XsemanticsCachedData<?> data) {
		if (data.result !== null)
			missed += resultRepresentation(data)
	}
	
	/**
	 * @since 1.6
	 */
	def resultRepresentation(XsemanticsCachedData<?> data) {
		data.name + ": " + data.result.string
	}

}
