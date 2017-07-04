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
package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.tests.loader.FJAbstractTests;
import it.xsemantics.example.fj.typesystem.fj.validator.FJTypeSystemValidator;
import it.xsemantics.example.fj.validation.FJJavaValidator;

import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;

import org.eclipse.xtext.junit.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit.validation.ValidatorTester;

/**
 * @author bettini
 * 
 */
public class FjValidatorTest extends FJAbstractTests {

	private ValidatorTester<FJJavaValidator> tester;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		FJJavaValidator validator = get(FJJavaValidator.class);
		tester = new ValidatorTester<FJJavaValidator>(validator, getInjector());
	}

	public void testFieldOk() throws Exception {
		Program program = getProgramFromString("class A { int i; int j; }");
		AssertableDiagnostics validate = tester.validate(program);
		validate.assertOK();
	}

	public void testFieldDuplicate() throws Exception {
		Program program = getProgramFromString("class A { int i; int i; }");
		Field i = FjAuxiliaryFunctions.selectFields(program.getClasses().get(0)).get(0);
		AssertableDiagnostics validate = tester.validate(i);
		validate.assertAny(AssertableDiagnostics
				.errorCode(FJTypeSystemValidator.CHECK_TYPE_FAILED_FIELD),
				AssertableDiagnostics
						.errorMsg("duplicate field in the same class"));
	}

	public void testFieldDuplicateInBaseClass() throws Exception {
		Program program = getProgramFromString("class A { int i; } class B extends A { int i; }");
		Field i = FjAuxiliaryFunctions.selectFields(program.getClasses().get(1)).get(0);
		AssertableDiagnostics validate = tester.validate(i);
		validate.assertAny(AssertableDiagnostics
				.errorCode(FJTypeSystemValidator.CHECK_TYPE_FAILED_FIELD),
				AssertableDiagnostics
						.errorMsg("duplicate field in base class"));
	}

	public void testMethodOk() throws Exception {
		Program program = getProgramFromString("class A { Object m() {return new A();} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0);
		AssertableDiagnostics validate = tester.validate(method);
		validate.assertOK();
	}

	public void testMethodOk2() throws Exception {
		Program program = getProgramFromString("class A { Object m() {return this;} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0);
		AssertableDiagnostics validate = tester.validate(method);
		validate.assertOK();
	}

	public void testMethodOk3() throws Exception {
		Program program = getProgramFromString("class A { Object i; Object m() {return this.i;} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0);
		AssertableDiagnostics validate = tester.validate(method);
		validate.assertOK();
	}
	
	public void testMethodDuplicate() throws Exception {
		Program program = getProgramFromString("class A { int n(Object s) {return 1;} String n() {return 'foo';} } ");
		AssertableDiagnostics validate = tester.validate(program);
		validate.assertAny(
				AssertableDiagnostics.error(0, "TMethodOk"),
				AssertableDiagnostics
						.errorCode(FJTypeSystemValidator.CHECK_TYPE_FAILED_METHOD),
				AssertableDiagnostics
						.errorMsg("duplicate method in the same class"));
	}
	
	public void testMainOk() throws Exception {
		Program program = getProgramFromString("class A { int i; int m() {return this.i;} } new A(10).m()");
		AssertableDiagnostics validate = tester.validate(program);
		validate.assertOK();
	}

	public void testMainWrongThis() throws Exception {
		Program program = getProgramFromString("this");
		AssertableDiagnostics validate = tester.validate(program);
		System.out.println(validate);
		validate.assertAny(
				AssertableDiagnostics
						.errorMsg("main expression This 'this' is not welltyped"));
	}
}
