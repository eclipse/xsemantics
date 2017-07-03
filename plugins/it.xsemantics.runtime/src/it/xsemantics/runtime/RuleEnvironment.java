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
package it.xsemantics.runtime;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Implements the environment for a typing judgment
 * 
 * @author Lorenzo Bettini
 * 
 */
public class RuleEnvironment {

	protected Map<Object, Object> environment = new LinkedHashMap<Object, Object>();

	protected RuleEnvironment next = null;

	public RuleEnvironment(RuleEnvironment e) {
		if (e == null) {
			environment = new LinkedHashMap<Object, Object>();
		} else {
			environment = new LinkedHashMap<Object, Object>(e.getEnvironment());
		}
	}

	public RuleEnvironment() {
	}

	public RuleEnvironment(RuleEnvironmentEntry environmentEntry) {
		add(environmentEntry);
	}

	public RuleEnvironment(RuleEnvironment firstComponent,
			RuleEnvironment secondComponent) {
		this(firstComponent);
		environment.putAll(secondComponent.getEnvironment());
	}

	public Map<Object, Object> getEnvironment() {
		return environment;
	}

	public RuleEnvironment getNext() {
		return next;
	}

	public void setNext(RuleEnvironment next) {
		this.next = next;
	}

	public void setNext(RuleEnvironmentEntry runtimeEnvironmentEntry) {
		RuleEnvironment next2 = new RuleEnvironment();
		setNext(next2);
		next2.add(runtimeEnvironmentEntry);
	}

	public void add(RuleEnvironmentEntry runtimeEnvironmentEntry) {
		add(runtimeEnvironmentEntry.getLeft(),
				runtimeEnvironmentEntry.getRight());
	}

	public boolean add(Object o1, Object o2) {
		return add(o1, o2, false);
	}

	/**
	 * If checkExist is true, before inserting, also checks that there is no
	 * other statement in the environment with left equal to the passed
	 * typingStatement left (otherwise returns false=
	 * 
	 * @param typingStatement
	 * @param checkExist
	 * @return
	 */
	public boolean add(Object o1, Object o2, boolean checkExist) {
		if (checkExist && environment.containsKey(o1)) {
			return false;
		}

		environment.put(o1, o2);

		return true;
	}

	/**
	 * If the key is not found in this environment tries recursively with the
	 * next one
	 * 
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		Object object = environment.get(key);
		if (object == null && next != null) {
			return next.get(key);
		}
		return object;
	}

	/**
	 * Adds all the entries of the passed environment to this one (existing
	 * mappings for the same key will be overwritten).
	 * @param ruleEnvironment
	 */
	public void increment(RuleEnvironment ruleEnvironment) {
		if (ruleEnvironment != null) {
			environment.putAll(ruleEnvironment.getEnvironment());
		}
	}

	/**
	 * Same as add
	 * @param runtimeEnvironmentEntry
	 */
	public void increment(RuleEnvironmentEntry runtimeEnvironmentEntry) {
		increment(runtimeEnvironmentEntry.getLeft(),
				runtimeEnvironmentEntry.getRight());
	}
	
	/**
	 * Same as add
	 * @param o1
	 * @param o2
	 */
	public void increment(Object o1, Object o2) {
		add(o1, o2);
	}

	/**
	 * Removes all the mapping that have as keys the keys of the
	 * passed environment.
	 * @param ruleEnvironment
	 */
	public void decrement(RuleEnvironment ruleEnvironment) {
		if (ruleEnvironment != null) {
			environment.keySet().removeAll(
				ruleEnvironment.getEnvironment().keySet());
		}
	}


	/**
	 * Remove the mapping with the passed object as key
	 * @param o1
	 */
	public void decrement(Object o1) {
		environment.remove(o1);
	}

	/**
	 * Adds all the entries of the passed environment, but it returns false
	 * if there are mappings in the passed environment with the same key
	 * of the current environment; the current environment is NOT restored
	 * to its original state in case of failure.
	 * @param ruleEnvironment if null it's succeeds
	 * @return
	 */
	public boolean union(RuleEnvironment ruleEnvironment) {
		if (ruleEnvironment == null) {
			return true;
		}
		
		Set<Entry<Object, Object>> entrySet = ruleEnvironment
				.getEnvironment().entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			if (!union(entry.getKey(), entry.getValue())) {
				return false;
			}
		}
		return true;
	}

	public boolean union(RuleEnvironmentEntry runtimeEnvironmentEntry) {
		return union(runtimeEnvironmentEntry.getLeft(),
				runtimeEnvironmentEntry.getRight());
	}

	public boolean union(Object o1, Object o2) {
		return add(o1, o2, true);
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		
		StringBuilder buffer = new StringBuilder(
			IterableExtensions.join(
				IterableExtensions.map(getEnvironment().entrySet(), 
						new Functions.Function1<Entry<Object, Object>, String>() {
							@Override
							public String apply(Map.Entry<Object,Object> p) {
								return p.getKey() + " -> " + p.getValue();
							}
						}
				),
				", "
			)
		);
		
		if (next != null) {
			buffer.append(" :: [");
			buffer.append(next.toString());
			buffer.append("]");
		}
		return buffer.toString();
	}

	/**
	 * @since 1.5
	 */
	public boolean isEmpty() {
		return environment.isEmpty();
	}

	/**
	 * @since 1.5
	 */
	public int size() {
		return environment.size();
	}

	/**
	 * @since 1.5
	 */
	public void clear() {
		environment.clear();
	}

	/**
	 * @since 1.5
	 */
	public Set<Object> keySet() {
		return environment.keySet();
	}

	/**
	 * @since 1.5
	 */
	public Collection<Object> values() {
		return environment.values();
	}

	/**
	 * @since 1.5
	 */
	public Set<Entry<Object, Object>> entrySet() {
		return environment.entrySet();
	}

	/**
	 * If the passed object is a RuleEnvironment then returns equals on the
	 * two {@link Map} contained objects.
	 * 
	 * @since 1.5
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof RuleEnvironment) {
			return environment.equals(((RuleEnvironment) o).getEnvironment());
		}
		return super.equals(o);
	}

	/**
	 * @since 1.5
	 */
	@Override
	public int hashCode() {
		return environment.hashCode();
	}

}
