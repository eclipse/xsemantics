/**
 * 
 */
package it.xsemantics.runtime;

/**
 * Utility class to listen to cache events (especially for testing)
 * 
 * @author Lorenzo Bettini
 * @since 1.6
 */
public interface XsemanticsCacheListener {
	
	public void cacheMissed(XsemanticsCachedData<?> data);
	
	public void cacheHit(XsemanticsCachedData<?> data);
	
	public void reset();
}
