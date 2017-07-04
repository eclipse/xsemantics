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

import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.typesystem.lambda.validator.LambdaTypeSystemValidator;
import it.xsemantics.example.lambda.validation.LambdaJavaValidator;

import org.eclipse.xtext.junit.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit.validation.ValidatorTester;

public class LambdaValidatorTest extends LambdaAbstractTests {
	ValidatorTester<LambdaJavaValidator> tester;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		LambdaJavaValidator validator = get(LambdaJavaValidator.class);
		tester = new ValidatorTester<LambdaJavaValidator>(validator, getInjector());
	}

	public void testArrowTypeWithTypeVariable() throws Exception {
		String programString = "lambda x : X -> X. x";
		Program program = getLambdaProgram(programString);
		tester.validate(program).assertOK();
	}

	public void testArrowTypeWithWrongType() throws Exception {
		String programString = "lambda x : string. lambda y. -x";
		Program program = getLambdaProgram(programString);
		AssertableDiagnostics validate = tester.validate(program);
		System.out.println(validate);
		validate
				.assertAny(
						AssertableDiagnostics
								.errorCode(LambdaTypeSystemValidator.CHECK_TYPE_FAILED_PROGRAM));
	}
}
