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

package it.xsemantics.example.lambda.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class LambdaTypeSystemAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				LambdaTypeSystemAllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TypeVariableTests.class);
		suite.addTestSuite(LambdaTypeBeautifierTests.class);
		suite.addTestSuite(OccurCheckTest.class);
		suite.addTestSuite(UnifyTest.class);
		suite.addTestSuite(SubstitutionTest.class);
		suite.addTestSuite(LambdaTypeTest.class);
		suite.addTestSuite(LambdaTypeInferAndModifyTest.class);
		suite.addTestSuite(LambdaValidatorTest.class);
		//$JUnit-END$
		return suite;
	}

}
