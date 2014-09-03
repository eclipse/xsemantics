package it.xsemantics.runtime

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.IResourceScopeCache

/**
 * Caches judgment and auxiliary functions computations.
 * 
 * @since 1.6
 */
@Singleton
class XsemanticsCache {
	
	@Inject private IResourceScopeCache cache
	
	@Inject extension TraceUtils
	
	public static var CACHED_STRING = "cached:"
	
	private val listeners = new ArrayList<XsemanticsCacheListener>

	def <T> T get(String methodName, RuleEnvironment environment, RuleApplicationTrace trace, 
			XsemanticsProvider<T> provider, Object...elements) {
		val cached = internalGet(methodName, provider, elements)
		
		if (!provider.called) {
			for (l : listeners)
				l.cacheHit(cached)

			// update the additional arguments with cached data
			if (environment !== null && environment !== cached.environment) {
				environment.increment(cached.environment)
			}
			
			if (trace !== null && trace !== cached.trace) {
				trace.addToTrace(CACHED_STRING)
				if (cached.trace !== null) {
					trace.addObjectAsSubtrace(cached.trace.lastElementNotTrace)
				}
			}
		} else {
			cached.name = methodName

			for (l : listeners)
				l.cacheMissed(cached)
		}

		cached.result
	}
	
	def <T> T internalGet(String methodName, Provider<T> provider, Object...elements) {
		cache.get(methodName -> elements.getKeys(), elements.getResource(), provider)
	}

	def getResource(Object...elements) {
		elements.filter(EObject).head?.eResource
	}

	def getKeys(Object...elements) {
		elements.reduce[p1, p2| p1 -> p2]
	}

	def void addListener(XsemanticsCacheListener l) {
		listeners += l
	}

	def void removeListener(XsemanticsCacheListener l) {
		listeners.remove(l)
	}
}