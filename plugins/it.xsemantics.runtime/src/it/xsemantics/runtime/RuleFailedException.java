/**
 * 
 */
package it.xsemantics.runtime;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents the failure of a rule application
 * 
 * @author Lorenzo Bettini
 * 
 */
public class RuleFailedException extends Exception {
	
	protected String issue;

	protected List<ErrorInformation> errorInformations = new LinkedList<ErrorInformation>();

	/**
	 * the previous exception in the trace of failures
	 */
	protected RuleFailedException previous;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RuleFailedException() {
		super();
	}

	public RuleFailedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		if (arg1 instanceof RuleFailedException) {
			this.previous = (RuleFailedException) arg1;
		}
	}

	public RuleFailedException(String arg0) {
		super(arg0);
	}

	public RuleFailedException(String failed, String issue2, Throwable t) {
		this(failed, t);
		this.issue = issue2;
	}

	public RuleFailedException(String arg0, RuleFailedException previous) {
		this(arg0);
		this.previous = previous;
	}

	public RuleFailedException(Throwable arg0) {
		super(arg0);
	}

	public List<ErrorInformation> getErrorInformations() {
		return errorInformations;
	}

	public void addErrorInformation(ErrorInformation errorInformation) {
		errorInformations.add(errorInformation);
	}
	
	public void addErrorInformations(ErrorInformation... errorInformations) {
		for (int i = 0; i < errorInformations.length; ++i)
			addErrorInformation(errorInformations[i]);
	}

	public void setPrevious(RuleFailedException previous) {
		this.previous = previous;
	}

	public RuleFailedException getPrevious() {
		return previous;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}
}