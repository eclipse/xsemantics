package it.xsemantics.runtime;


/**
 * The actual object put into the {@link XsemanticsCache}
 * @author Lorenzo Bettini
 * @since 1.6
 */
public class XsemanticsCachedData<T extends Object> {
	private String name = "";
	
	private final RuleEnvironment environment;

	private final RuleApplicationTrace trace;

	private final T result;

	public XsemanticsCachedData(final RuleEnvironment environment,
			final RuleApplicationTrace trace, final T result) {
		super();
		this.environment = environment;
		this.trace = trace;
		this.result = result;
	}

	public RuleEnvironment getEnvironment() {
		return this.environment;
	}

	public RuleApplicationTrace getTrace() {
		return this.trace;
	}

	public T getResult() {
		return this.result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
