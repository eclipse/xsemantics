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
package org.eclipse.xsemantics.runtime.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.SimpleCache;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * Temporary patched version:
 * https://github.com/LorenzoBettini/xsemantics/issues/82
 * https://github.com/eclipse/xtext-core/issues/238
 * 
 * @author Lorenzo Bettini
 *
 */
public class PatchedPolymorphicDispatcher<RT> extends PolymorphicDispatcher<RT> {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(PolymorphicDispatcher.class);
	private final List<? extends Object> targets;
	private final Predicate<Method> methodFilter;

	private Collection<MethodDesc> methods;

	private final ErrorHandler<RT> handler;

	public PatchedPolymorphicDispatcher(final List<? extends Object> targets, Predicate<Method> methodFilter) {
		this(targets, methodFilter, new DefaultErrorHandler<RT>());
	}

	public PatchedPolymorphicDispatcher(final List<? extends Object> targets, Predicate<Method> methodFilter, ErrorHandler<RT> handler) {
		super(Collections.emptyList(), methodFilter, handler);
		this.targets = targets;
		this.methodFilter = methodFilter;
		this.handler = handler;
		methods = getCandidateMethods();
	}

	@Override
	protected int compare(MethodDesc o1, MethodDesc o2) {
		final Class<?>[] paramTypes1 = o1.getParameterTypes();
		final Class<?>[] paramTypes2 = o2.getParameterTypes();

		// sort by number of parameters
		if (paramTypes1.length > paramTypes2.length)
			return 1;
		if (paramTypes2.length > paramTypes1.length)
			return -1;

		// sort by parameter types from left to right
		for (int i = 0; i < paramTypes1.length; i++) {
			final Class<?> class1 = paramTypes1[i];
			final Class<?> class2 = paramTypes2[i];

			if (class1.equals(class2))
				continue;
			if (class1.isAssignableFrom(class2) || Void.class.equals(class2))
				return -1;
			if (class2.isAssignableFrom(class1) || Void.class.equals(class1))
				return 1;
		}

		// sort by declaring class (more specific comes first).
		if (!o1.getDeclaringClass().equals(o2.getDeclaringClass())) {
			if (o1.getDeclaringClass().isAssignableFrom(o2.getDeclaringClass()))
				return 1;
			if (o2.getDeclaringClass().isAssignableFrom(o1.getDeclaringClass()))
				return -1;
		}

		// sort by target
		final int compareTo = ((Integer) targets.indexOf(o2.getTarget())).compareTo(targets.indexOf(o1.getTarget()));
		return compareTo;
	}

	private final SimpleCache<List<Class<?>>, List<MethodDesc>> cache =
		new SimpleCache<List<Class<?>>, List<MethodDesc>>(
			new Function<List<Class<?>>, List<MethodDesc>>() {
				@Override
				public List<MethodDesc> apply(List<Class<?>> paramTypes) {
					// 'result' contains all best-matched MethodDesc for which 
					// pairwise compare(m1, m2) == 0, meaning they're equal or unrelated. 
					List<MethodDesc> result = new ArrayList<MethodDesc>();
					Iterator<MethodDesc> iterator = methods.iterator();
					NEXT: while (iterator.hasNext()) {
						MethodDesc methodDesc = iterator.next();
						if (methodDesc.isInvokeable(paramTypes)) {
							if (result.isEmpty()) {
								result.add(methodDesc);
							} else {
								Iterator<MethodDesc> it = result.iterator();
								while(it.hasNext()) {
									MethodDesc next = it.next();
									int compare = compare(next, methodDesc);
									if (compare < 0) {
										it.remove();
									} else if (compare > 0) {
										continue NEXT;
									}
								}
								result.add(methodDesc);
							}
						}
					}
					return result;
				}
			}
		);

	@Override
	@SuppressWarnings("unchecked")
	public RT invoke(Object... params) {
		if (methodFilter instanceof MethodNameFilter) {
			MethodNameFilter filter = (MethodNameFilter) methodFilter;
			if (params.length<filter.getMinParams() || params.length > filter.getMaxParams()) {
				throw new IllegalArgumentException("Wrong number of arguments. Expected "+filter.getMinParams()+" to "+filter.getMaxParams()+".");
			}
		}
		List<MethodDesc> result = cache.get(getTypes(params));
		// check if ambiguous
		if (result.size()>1)
			return handleAmbigousMethods(result, params);
		
		if (result.isEmpty())
			return handleNoSuchMethod(params);

		try {
			MethodDesc current = result.get(0);
			current.getMethod().setAccessible(true);
			return (RT) current.getMethod().invoke(current.getTarget(), params);
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof Error)
				throw (Error) e.getTargetException();
			return handler.handle(params, e.getTargetException());
		} catch (IllegalArgumentException e) {
			return handler.handle(params, e);
		} catch (IllegalAccessException e) {
			return handler.handle(params, e);
		}
	}

	/**
	 * @param params
	 * @return
	 */
	private List<Class<?>> getTypes(Object[] params) {
		List<Class<?>> result = new ArrayList<Class<?>>(params.length);
		for (int i = 0; i < params.length; i++) {
			if (params[i]!=null) {
				result.add(params[i].getClass());
			} else {
				result.add(getDefaultClass(i));
			}
		}
		return result;
	}

	private Collection<MethodDesc> getCandidateMethods() {
		Collection<MethodDesc> cachedDescriptors = new ArrayList<MethodDesc>();
		for (Object target : targets) {
			Class<?> current = target.getClass();
			while (current != Object.class) {
				Method[] methods = current.getDeclaredMethods();
				for (Method method : methods) {
					if (methodFilter.apply(method)) {
						cachedDescriptors.add(createMethodDesc(target, method));
					}
				}
				current = current.getSuperclass();
			}
		}
		return cachedDescriptors;
	}

}
