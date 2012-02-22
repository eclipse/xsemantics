/**
 * 
 */
package it.xsemantics.runtime;

/**
 * @author bettini
 *
 */
public class Result2<FirstT, SecondT> extends Result<FirstT> {

	private SecondT second;
	
	public Result2(FirstT first) {
		super(first);
	}

	public Result2(FirstT first, SecondT second) {
		this(first);
		this.second = second;
	}

	public Result2(RuleFailedException ruleFailedException) {
		super(ruleFailedException);
	}

	public SecondT getSecond() {
		return second;
	}

	public void setSecond(SecondT second) {
		this.second = second;
	}
	
	
}
