/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

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
public class RuleFailedException extends RuntimeException {
	
	protected final String issue;

	protected final transient List<ErrorInformation> errorInformations = new LinkedList<ErrorInformation>();

	/**
	 * the previous exception in the trace of failures
	 */
	protected final RuleFailedException previous;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RuleFailedException() {
		super();
		this.issue = null;
		this.previous = null;
	}

	public RuleFailedException(String arg0) {
		super(arg0);
		this.issue = null;
		this.previous = null;
	}

	public RuleFailedException(String failed, String issue2, Throwable t) {
		super(failed, t);
		if (t instanceof RuleFailedException) {
			this.previous = (RuleFailedException) t;
		} else {
			this.previous = null;
		}
		this.issue = issue2;
	}

	public RuleFailedException(String arg0, RuleFailedException previous) {
		super(arg0);
		this.issue = null;
		this.previous = previous;
	}

	public List<ErrorInformation> getErrorInformations() {
		return errorInformations;
	}

	public void addErrorInformation(ErrorInformation errorInformation) {
		errorInformations.add(errorInformation);
	}
	
	public void addErrorInformations(ErrorInformation... errorInformations) {
		for (int i = 0; i < errorInformations.length; ++i) {
			addErrorInformation(errorInformations[i]);
		}
	}

	public RuleFailedException getPrevious() {
		return previous;
	}

	public String getIssue() {
		return issue;
	}

}