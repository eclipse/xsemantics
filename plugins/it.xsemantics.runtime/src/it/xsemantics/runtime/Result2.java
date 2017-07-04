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
