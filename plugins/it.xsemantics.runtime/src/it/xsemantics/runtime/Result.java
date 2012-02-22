/**
 * 
 */
package it.xsemantics.runtime;

/**
 * The result of a rule invocation
 * 
 * @author Lorenzo Bettini
 * 
 */
public class Result<T> extends ResultWithFailure {

	private T value;

	public Result(T value) {
		super();
		this.value = value;
	}

	public Result(RuleFailedException ruleFailedException) {
		super(ruleFailedException);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getFirst() {
		return value;
	}

	public void setFirst(T value) {
		this.value = value;
	}

}
