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

package org.eclipse.xsemantics.dsl.tests.generator.fj.caching;

import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.Expression;
import org.eclipse.xsemantics.example.fj.fj.Type;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.XsemanticsCache;
import org.eclipse.xsemantics.runtime.XsemanticsProvider;
import org.eclipse.xsemantics.test.fj.first.FjFirstTypeSystem;

import java.util.List;

import com.google.inject.Inject;

/**
 * This is a manual implementation of caching, used as a reference implementation
 * for code generation, and also for possible future experiments.  This DOES NOT implement
 * caching for entry point methods, thus failures are not cached.
 * 
 * @author Lorenzo Bettini
 */
public class FjFirstTypeSystemManualCached extends FjFirstTypeSystem {

	@Inject
	XsemanticsCache cache;

	@Override
	protected List<Class> superclassesInternal(final RuleApplicationTrace _trace_,
			final Class cl) {
		return cache.get("superclassesInternal", (RuleEnvironment)null, _trace_,
				new XsemanticsProvider<List<Class>>(null, _trace_) {
					public List<Class> doGet() {
						return FjFirstTypeSystemManualCached.
								super.superclassesInternal(_trace_, cl);
					}
				}, cl);
	}
	
	@Override
	protected Result<Type> typeInternal(final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final Expression expression) {
		return cache.get("typeInternal", _environment_, _trace_,
				new XsemanticsProvider<Result<Type>>(_environment_, _trace_) {
					public Result<Type> doGet() {
						return FjFirstTypeSystemManualCached.super
								.typeInternal(_environment_, _trace_,
										expression);
					}
				}, expression);
	}

	@Override
	protected Result<Boolean> subclassInternal(final RuleEnvironment _environment_,
			final RuleApplicationTrace _trace_, final Class candidate, final Class superclass) {
		return cache.get("subclassInternal", _environment_, _trace_,
				new XsemanticsProvider<Result<Boolean>>(_environment_, _trace_) {
					public Result<Boolean> doGet() {
						return FjFirstTypeSystemManualCached.
								super.subclassInternal(_environment_, _trace_, candidate, superclass);
					}
				}, candidate, superclass);
	}
}
