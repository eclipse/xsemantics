/**
 * 
 */
package it.xsemantics.runtime.caching;

/**
 * Utility class to listen to cache events (especially for testing)
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
public class XsemanticsCacheListener {
	
	public void cacheMissed(XsemanticsCachedData<?> data) {}
	
	public void cacheHit(XsemanticsCachedData<?> data) {}
}
