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
public class ResultWithFailure {

	private RuleFailedException ruleFailedException;

	public ResultWithFailure() {
	}

	public ResultWithFailure(RuleFailedException ruleFailedException) {
		super();
		this.ruleFailedException = ruleFailedException;
	}

	public RuleFailedException getRuleFailedException() {
		return ruleFailedException;
	}

	public void setRuleFailedException(RuleFailedException ruleFailedException) {
		this.ruleFailedException = ruleFailedException;
	}

	public boolean failed() {
		return ruleFailedException != null;
	}
}
