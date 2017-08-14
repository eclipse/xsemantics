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

package org.eclipse.xsemantics.runtime;

public class StringRepresentationPostProcessor {
	
	/**
	 * @since 1.8
	 */
	protected int numOfMaxChars = 40;
	
	/**
	 * @since 1.8
	 */
	protected String omissisString = "...";
	
	public String process(String string) {
		if (string == null) {
			return "";
		}
		return stopAtNewLine(limitChars(string, maxChars()));
	}
	
	public int maxChars() {
		return numOfMaxChars;
	}
	
	public String omissis() {
		return omissisString;
	}
	
	public String stopAtNewLine(String string) {
		int firstNewLine = string.indexOf("\n");
		if (firstNewLine > 0) {
			return string.substring(0, firstNewLine);
		}
		return string;
	}
	
	public String limitChars(String string, int limit) {
		if (string.length() > limit) {
			return string.substring(0, limit) + omissis();
		}
		return string;
	}
}