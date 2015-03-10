package it.xsemantics.runtime.caching.util

import org.eclipse.emf.ecore.EObject

/**
 * Utility functions for caching.
 * 
 * @author Lorenzo Bettini
 * 
 * @since 1.8
 */
class XsemanticsCacheUtils {
	
	def getResource(Object...elements) {
		elements.filter(EObject).head?.eResource
	}

	def getKeys(Object...elements) {
		elements.reduce[p1, p2| p1 -> p2]
	}
}