/**
 * 
 */
package it.xsemantics.runtime;



/**
 * We use this to keep track of whether this provider's get method has
 * been called in order to understand if we use a cached value or not
 * in {@link XsemanticsCache}; this helps us to provide a better
 * {@link RuleApplicationTrace}.
 * 
 * @author Lorenzo Bettini
 * @since 1.6
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

	@Override
	public XsemanticsCachedData<T> get() {
		called = true;
		T doGet = doGet();
		RuleApplicationTrace snapshot = trace != null ? trace.snapshot() : null;
		return new XsemanticsCachedData<T>(environment, snapshot, doGet);
	}

	public abstract T doGet();

	public boolean isCalled() {
		return called;
	}

}
