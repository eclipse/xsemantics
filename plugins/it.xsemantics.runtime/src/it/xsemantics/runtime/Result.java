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

	public T getFirst() {
		return value;
	}

}
