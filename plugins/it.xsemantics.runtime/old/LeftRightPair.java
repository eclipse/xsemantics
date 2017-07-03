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
public class LeftRightPair<LeftT, RightT> {
	protected LeftT left = null;

	protected RightT right = null;

	public LeftRightPair() {

	}

	public LeftRightPair(LeftT left, RightT right) {
		super();
		this.left = left;
		this.right = right;
	}

	public LeftT getLeft() {
		return left;
	}

	public void setLeft(LeftT left) {
		this.left = left;
	}

	public RightT getRight() {
		return right;
	}

	public void setRight(RightT right) {
		this.right = right;
	}

}
