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
package it.xsemantics.example.lambda.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author bettini
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	LambdaTypeBeautifierTests.class,
	LambdaUtilsTests.class,
	TypeSubstitutionsTests.class,
	TypeVariableTests.class,
	LambdaParserTest.class,
	LambdaTypeSubstitutionTest.class,
	LambdaNotOccurTest.class,
	LambdaUnifyTest.class,
	LambdaTypeTest.class,
	LambdaUtilsTests.class,
	LambdaTypeInferAndModifyTest.class,
	LambdaValidatorTest.class
})
public class LambdaAllTests {

}
