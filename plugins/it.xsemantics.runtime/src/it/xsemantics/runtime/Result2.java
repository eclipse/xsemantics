/**
 * 
 */
package it.xsemantics.runtime;

/**
 * @author Lorenzo Bettini
 *
 */
public class Result2<F, S> extends Result<F> {

	private S second;
	
	public Result2(F first) {
		super(first);
	}

	public Result2(F first, S second) {
		this(first);
		this.second = second;
	}

	public Result2(RuleFailedException ruleFailedException) {
		super(ruleFailedException);
	}

	public S getSecond() {
		return second;
	}

}
