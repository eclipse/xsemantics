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
package org.eclipse.xsemantics.dsl.tests.generator.fj.common;

import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.Program;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;

import com.google.inject.Inject;

/**
 * @author bettini
 * 
 */
public abstract class FjAbstractTests {

	@Inject
	private ParseHelper<Program> parser;

	protected FjInputFilesForTyping testFiles = new FjInputFilesForTyping();

	protected FjTestsUtils fjTestsUtils = new FjTestsUtils();

	protected Program getProgram(CharSequence program) throws Exception {
		return getProgram(program.toString());
	}

	protected Program getProgram(String model) throws Exception {
		return parser.parse(model);
	}

	public Class fjClassForName(Program program, String className) {
		return fjTestsUtils.fjClassForName(program, className);
	}

	protected void assertEqualsStrings(Object expected, Object actual) {
		Assert.assertEquals(
			("" + expected).replace("\r", ""), 
			("" + actual).replace("\r", "")
		);
	}

}
