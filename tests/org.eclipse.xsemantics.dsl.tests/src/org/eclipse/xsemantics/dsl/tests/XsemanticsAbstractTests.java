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
package org.eclipse.xsemantics.dsl.tests;

import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Assert;
import org.junit.Before;

import org.eclipse.xsemantics.dsl.XsemanticsStandaloneSetup;
import org.eclipse.xsemantics.dsl.tests.input.FjTypeSystemFiles;
import org.eclipse.xsemantics.dsl.tests.input.XsemanticsTestFiles;

/**
 * @author bettini
 * 
 */
public class XsemanticsAbstractTests extends AbstractXtextTests {

	protected static final String TESTS_INPUT_FILES = "./tests_input_files/";
	
	protected static final String TESTS_INPUT_FILES_WITH_ERRORS = "./tests_input_files_with_errors/";

	protected static final String EXPECTATION_DIR = "expectations/";

	protected static final String RESULT_DIR = "test-gen/";

	protected XsemanticsTestFiles testFiles = new XsemanticsTestFiles();

	protected FjTypeSystemFiles fjTSFiles = new FjTypeSystemFiles();

	protected EmfFactoryUtils emfUtils = new EmfFactoryUtils();

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		with(XsemanticsStandaloneSetup.class);
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// serializer tests do not work due to java.lang.ClassCastException: org.eclipse.xtext.impl.RuleCallImpl cannot be cast to org.eclipse.xtext.Alternatives
		return false;
	}

	protected void assertEqualsStrings(Object expected, Object actual) {
		Assert.assertEquals(
				("" + expected).replaceAll("\r", ""), 
				("" + actual).replaceAll("\r", "")
			);
	}
}
