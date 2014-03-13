/**
 * 
 */
package it.xsemantics.runtime;

/**
 * @author bettini
 * 
 */
public class Result3<FirstT, SecondT, ThirdT> extends Result2<FirstT, SecondT> {

	private ThirdT third;

	public Result3(FirstT first) {
		super(first);
	}

	public Result3(FirstT first, SecondT second) {
		super(first, second);
	}

	public Result3(FirstT first, SecondT second, ThirdT third) {
		this(first, second);
		this.third = third;
	}

	public Result3(RuleFailedException ruleFailedException) {
		super(ruleFailedException);
	}

	public ThirdT getThird() {
		return third;
	}

}
