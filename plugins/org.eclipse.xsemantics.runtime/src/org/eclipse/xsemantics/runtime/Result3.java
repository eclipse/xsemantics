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
package org.eclipse.xsemantics.runtime;

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
