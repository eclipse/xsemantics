package it.xsemantics.runtime;

import it.xsemantics.runtime.caching.util.XsemanticsCacheUtils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Caches judgment and auxiliary functions computations.
 * 
 * @author Lorenzo Bettini
 * 
 * @since 1.6
 */
@Singleton
public class XsemanticsCache {
	
	@Inject private IResourceScopeCache cache;
	
	@Inject private XsemanticsCacheUtils cacheUtils;
	
	public static String CACHED_STRING = "cached:";
	
	private List<XsemanticsCacheListener> listeners = new ArrayList<XsemanticsCacheListener>();

	public <T> T get(String methodName, RuleEnvironment environment, RuleApplicationTrace trace, 
			XsemanticsProvider<T> provider, Object...elements) {
		XsemanticsCachedData<T> cached = internalGet(methodName, provider, elements);
		
		if (!provider.isCalled()) {
			for (XsemanticsCacheListener l : listeners) {
				l.cacheHit(cached);
			}

			// update the additional arguments with cached data
			if (environment != null && environment != cached.getEnvironment()) {
				environment.increment(cached.getEnvironment());
			}
			
			if (trace != null && trace != cached.getTrace()) {
				trace.addToTrace(CACHED_STRING);
				if (cached.getTrace() != null) {
					trace.addObjectAsSubtrace(lastElementNotTrace(cached.getTrace()));
				}
			}
		} else {
			cached.setName(methodName);

			for (XsemanticsCacheListener l : listeners) {
				l.cacheMissed(cached);
			}
		}

		return cached.getResult();
	}
	
	public <T> T internalGet(String methodName, Provider<T> provider,
			Object... elements) {
		return cache.<T> get(
				Pair.<String, Object> of(methodName, cacheUtils.getKeys(elements)),
				cacheUtils.getResource(elements), provider);
	}

	public void addListener(final XsemanticsCacheListener l) {
		this.listeners.add(l);
	}

	public void removeListener(final XsemanticsCacheListener l) {
		this.listeners.remove(l);
	}
	
	/**
	 * Returns the last element in the trace that is not a RuleApplicationTrace
	 * 
	 * @since 1.8
	 */
	public Object lastElementNotTrace(final RuleApplicationTrace trace) {
		return IterableExtensions.<Object> findLast(trace.trace, new Function1<Object, Boolean>() {
			@Override
			public Boolean apply(final Object it) {
				return Boolean.valueOf(!(it instanceof RuleApplicationTrace));
			}
		});
	}
}