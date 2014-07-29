/**
 * 
 */
package it.xsemantics.runtime;

/**
 * @author Lorenzo Bettini
 * 
 */
public class Result3<F, S, T> extends Result2<F, S> {

	private T third;

	public Result3(F first) {
		super(first);
	}

	public Result3(F first, S second) {
		super(first, second);
	}

	public Result3(F first, S second, T third) {
		this(first, second);
		this.third = third;
	}

	public Result3(RuleFailedException ruleFailedException) {
		super(ruleFailedException);
	}

	public T getThird() {
		return third;
	}

}
