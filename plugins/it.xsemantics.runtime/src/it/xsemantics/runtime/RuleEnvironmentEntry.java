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

package it.xsemantics.runtime;

/**
 * This will be used to store the runtime representation of a TypingStatement
 * into an environment
 * 
 * @author Lorenzo Bettini
 * 
 */
public class RuleEnvironmentEntry {
	Object left;

	Object right;

	public RuleEnvironmentEntry(Object left, Object right) {
		super();
		this.left = left;
		this.right = right;
	}

	public Object getLeft() {
		return left;
	}

	public Object getRight() {
		return right;
	}

}
