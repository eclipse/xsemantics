package it.xsemantics.runtime.caching;

import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;

/**
 * @since 1.5
 */
public class XsemanticsCachedData<T extends Object> {
	private final RuleEnvironment _environment;

	public RuleEnvironment getEnvironment() {
		return this._environment;
	}

	private final RuleApplicationTrace _trace;

	public RuleApplicationTrace getTrace() {
		return this._trace;
	}

	private final T _result;

	public T getResult() {
		return this._result;
	}

	public XsemanticsCachedData(final RuleEnvironment environment,
			final RuleApplicationTrace trace, final T result) {
		super();
		this._environment = environment;
		this._trace = trace;
		this._result = result;
	}
}
