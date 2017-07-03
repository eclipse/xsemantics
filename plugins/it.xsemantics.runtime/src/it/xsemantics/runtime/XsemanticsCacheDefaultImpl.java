/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

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
 * Default implementation of {@link XsemanticsCache}, using a
 * {@link IResourceScopeCache}.
 * 
 * @author Lorenzo Bettini
 * 
 * @since 1.8
 */
@Singleton
public class XsemanticsCacheDefaultImpl implements XsemanticsCache {
	
	@Inject private IResourceScopeCache cache;
	
	@Inject private XsemanticsCacheUtils cacheUtils;
	
	/**
	 * @since 1.8
	 */
	protected String cachedString = "cached:";
	
	private List<XsemanticsCacheListener> listeners = new ArrayList<XsemanticsCacheListener>();

	@Override
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
				trace.addToTrace(cachedString);
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
	
	protected <T> T internalGet(String methodName, Provider<T> provider,
			Object... elements) {
		return cache.<T> get(
				Pair.<String, Object> of(methodName, cacheUtils.getKeys(elements)),
				cacheUtils.getResource(elements), provider);
	}

	@Override
	public void addListener(final XsemanticsCacheListener l) {
		this.listeners.add(l);
	}

	@Override
	public void removeListener(final XsemanticsCacheListener l) {
		this.listeners.remove(l);
	}
	
	private Object lastElementNotTrace(final RuleApplicationTrace trace) {
		// this is copied from TraceUtils, otherwise Sonarqube 5 reports
		// a dependency cycle because it uses source folders instead of
		// Java packages.
		return IterableExtensions.<Object> findLast(trace.trace, new Function1<Object, Boolean>() {
			@Override
			public Boolean apply(final Object it) {
				return Boolean.valueOf(!(it instanceof RuleApplicationTrace));
			}
		});
	}
}