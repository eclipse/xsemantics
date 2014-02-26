package it.xsemantics.runtime.caching

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.IResourceScopeCache
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.RuleApplicationTrace

/**
 * @since 1.5
 */
@Singleton
class XsemanticsCache {
	
	@Inject private IResourceScopeCache cache

	def <T> T get(String methodName, RuleEnvironment environment, RuleApplicationTrace trace, 
			Provider<XsemanticsCachedData<T>> provider, Object...elements) {
		val cached = get(methodName, provider, elements)
		if (environment !== null && environment !== cached.environment) {
			environment.increment(cached.environment)
		}
		if (trace !== null && trace !== cached.trace) {
			if (trace.empty)
				trace.replaceWith(cached.trace)
			else
				trace.addAsSubtrace(cached.trace)
		}
		cached.result
	}
	
	def <T> T get(String methodName, Provider<T> provider, Object...elements) {
		cache.get(methodName -> elements.getKeys(), elements.getResource(), provider)
	}

	def getResource(Object...elements) {
		elements.filter(EObject).head?.eResource
	}

	def getKeys(Object...elements) {
		elements.reduce[p1, p2| p1 -> p2]
	}
}