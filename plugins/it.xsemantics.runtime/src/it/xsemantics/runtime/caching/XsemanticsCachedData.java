package it.xsemantics.runtime.caching;

import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;

/**
 * The actual object put into the {@link XsemanticsCache}
 * @author Lorenzo Bettini
 * @since 1.5
 */
public class XsemanticsCachedData<T extends Object> {
	private String name = "";
	
	private final RuleEnvironment _environment;

	private final RuleApplicationTrace _trace;

	private final T _result;

	public XsemanticsCachedData(final RuleEnvironment environment,
			final RuleApplicationTrace trace, final T result) {
		super();
		this._environment = environment;
		this._trace = trace;
		this._result = result;
	}

	public RuleEnvironment getEnvironment() {
		return this._environment;
	}

	public RuleApplicationTrace getTrace() {
		return this._trace;
	}

	public T getResult() {
		return this._result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
