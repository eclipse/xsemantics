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

/**
 * 
 */
package org.eclipse.xsemantics.runtime;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Keeps a trace of applied rules (and also failures)
 * 
 * @author Lorenzo Bettini
 * 
 */
public class RuleApplicationTrace {
	
	private static final String DEEP_CLONING = "deep cloning of trace disabled";

	private static final Logger LOGGER = Logger.getLogger(RuleApplicationTrace.class);

	protected List<Object> trace = new ArrayList<>();

	public RuleApplicationTrace() {
		// nothing to do
	}

	public void addToTrace(Object traceElement) {
		if (traceElement != null) {
			trace.add(traceElement);
		}
	}

	public void addAsSubtrace(RuleApplicationTrace subTrace) {
		if (subTrace != null) {
			trace.add(subTrace);
		}
	}

	/**
	 * @since 1.5
	 */
	public void addObjectAsSubtrace(Object traceElement) {
		if (traceElement != null) {
			RuleApplicationTrace subTrace = new RuleApplicationTrace();
			subTrace.addToTrace(traceElement);
			trace.add(subTrace);
		}	
	}

	public List<Object> getTrace() {
		return trace;
	}

	/**
	 * @since 1.5
	 */
	public boolean isEmpty() {
		return trace.isEmpty();
	}

	/**
	 * Returns a "snapshot" of the current trace (i.e., it partially deeply clones
	 * possible subtraces); this is useful for storing snapshots in cached
	 * computations.
	 * 
	 * If there are instantiation exceptions during the deep cloning of a
	 * RuleApplicationTrace, e.g., {@link InstantiationException} or
	 * {@link IllegalAccessException}, the clone gracefully falls back to the
	 * very same instance.
	 * 
	 * Note that only possibly nested RuleApplicationTrace instances are cloned,
	 * not the other objects of the trace, i.e., strings are not cloned.
	 * 
	 * @since 1.5
	 */
	public RuleApplicationTrace snapshot() {
		return performSafeDeepCloning();
	}
	
	/**
	 * @since 1.6
	 */
	protected RuleApplicationTrace performSafeDeepCloning() {
		RuleApplicationTrace cloned = null;
		
		try {
			cloned = getClass().getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			LOGGER.info(DEEP_CLONING, e);
			return this;
		}
		cloned.trace = new ArrayList<>();
		for (Object orig : trace) {
			if (orig instanceof RuleApplicationTrace) {
				cloned.trace.add(((RuleApplicationTrace)orig).performSafeDeepCloning());
			} else {
				cloned.trace.add(orig);
			}
		}
		return cloned;
	}
}
