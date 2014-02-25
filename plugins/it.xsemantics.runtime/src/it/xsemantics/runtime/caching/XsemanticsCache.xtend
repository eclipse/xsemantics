package it.xsemantics.runtime.caching

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.IResourceScopeCache

/**
 * @since 1.5
 */
@Singleton
class XsemanticsCache {
	
	@Inject private IResourceScopeCache cache
	
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