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

package org.eclipse.xsemantics.dsl.tests.generator.fj.common;

import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.dsl.validation.testutils.ValidatorTester;
import org.eclipse.xtext.testing.validation.AssertableDiagnostics;
import org.eclipse.xtext.testing.validation.AssertableDiagnostics.DiagnosticPredicate;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.junit.Test;

import com.google.inject.Inject;

public abstract class FjAbstractGeneratedValidatorTests extends FjAbstractTests {

	@Inject
	protected ValidatorTester<AbstractDeclarativeValidator> tester;

	@Inject
	protected FjExpectedTraces expectedTraces;

	protected FjInputFilesForTyping testFiles = new FjInputFilesForTyping();

	protected FjTestsUtils utils = new FjTestsUtils();

	@Test
	public void testMethodCall() throws Exception {
		assertOk(getProgram(testFiles.testForMethodCall()));
	}

	@Test
	public void testCheckNewWrongSubtypeSimpler() throws Exception {
		assertAll(testFiles.testNewWrongArgSubtypeSimpler(),
				expectedTraces.validateCheckNewWrongSubtypeSimpler());
	}
	
	@Test
	public void testCheckNewWrongArgNum() throws Exception {
		assertAll(testFiles.testNewWrongArgNum(),
				expectedTraces.validateCheckNewWrongArgNum());
	}

	@Test
	public void testCyclicClassHierarchy() throws Exception {
		assertAll(testFiles.testCyclicClassHierarchy(),
				expectedTraces.validateCyclicClassHierarchy());
	}
	
	@Test
	public void testSubclassDeclaresSameFieldOfSuperClass() throws Exception {
		assertAll(testFiles.testSubclassDeclaresSameFieldOfSuperClass(),
				expectedTraces.validateSubclassDeclaresSameFieldOfSuperClass());
	}

	protected void assertOk(EObject element) {
		assertOk(tester.validate(element));
	}

	protected void assertOk(AssertableDiagnostics validate) {
		if (!listOfDiagnostics(validate).isEmpty()) {
			System.err.println(utils.diagnosticsToString(validate));
			fail("There are expected to be no diagnostics.: "
					+ utils.diagnosticsToString(validate));
		}
	}

	protected void assertAll(CharSequence programToValidate,
			CharSequence expectedErrors) throws Exception {
		assertAll(expectedErrors.toString(),
				tester.validate(getProgram(programToValidate)));
	}

	protected void assertAll(CharSequence expectedErrors,
			AssertableDiagnostics validate) {
		assertEqualsStrings(utils.removeObjectIdentifiers(expectedErrors.toString())
				.trim(), utils.removeObjectIdentifiers(utils
				.diagnosticsToString(validate)));
	}

	protected void assertAll(AssertableDiagnostics validate,
			DiagnosticPredicate... predicates) {
		System.err.println(utils.diagnosticsToString(validate));
		validate.assertAll(predicates);
	}

	protected List<Diagnostic> listOfDiagnostics(AssertableDiagnostics validate) {
		return validate.getDiagnostic().getChildren();
	}
}
