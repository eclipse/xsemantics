/**
 * 
 */
package it.xsemantics.runtime.caching;

import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;


/**
 * We use this to keep track of whether this provider's get method has
 * been called in order to understand if we use a cached value or not
 * in {@link XsemanticsCache}; this helps us to provide a better
 * {@link RuleApplicationTrace}.
 * 
 * @author Lorenzo Bettini
 * @since 1.5
 */
public abstract class XsemanticsProvider<T> implements com.google.inject.Provider<XsemanticsCachedData<T>> {

	private RuleEnvironment environment;
	
	private RuleApplicationTrace trace;
	
	private boolean called = false;
	
	public XsemanticsProvider(RuleEnvironment environment,
			RuleApplicationTrace trace) {
		super();
		this.environment = environment;
		this.trace = trace;
	}

	public XsemanticsCachedData<T> get() {
		called = true;
		return new XsemanticsCachedData<T>(environment, trace, doGet());
	}

	public abstract T doGet();

	public boolean isCalled() {
		return called;
	}

}
