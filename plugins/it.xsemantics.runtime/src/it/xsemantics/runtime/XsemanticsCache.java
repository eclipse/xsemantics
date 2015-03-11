package it.xsemantics.runtime;

import com.google.inject.ImplementedBy;

/**
 * Caches judgment and auxiliary functions computations.
 * 
 * @author Lorenzo Bettini
 * 
 * @since 1.6
 */
@ImplementedBy(XsemanticsCacheDefaultImpl.class)
public interface XsemanticsCache {
	
	/**
	 * The main entry point for the cache; this will be called
	 * by the generated Xsemantics system.
	 * 
	 * @param methodName
	 * @param environment
	 * @param trace
	 * @param provider
	 * @param elements
	 * @return
	 */
	<T> T get(String methodName, RuleEnvironment environment, RuleApplicationTrace trace, 
			XsemanticsProvider<T> provider, Object...elements);

	void addListener(final XsemanticsCacheListener l);

	void removeListener(final XsemanticsCacheListener l);
}