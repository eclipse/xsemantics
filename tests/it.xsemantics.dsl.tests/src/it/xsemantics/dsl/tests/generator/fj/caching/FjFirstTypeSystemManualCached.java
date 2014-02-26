package it.xsemantics.dsl.tests.generator.fj.caching;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.caching.XsemanticsCache;
import it.xsemantics.runtime.caching.XsemanticsProvider;
import it.xsemantics.test.fj.first.FjFirstTypeSystem;

import com.google.inject.Inject;

public class FjFirstTypeSystemManualCached extends FjFirstTypeSystem {

	@Inject
	XsemanticsCache cache;

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
