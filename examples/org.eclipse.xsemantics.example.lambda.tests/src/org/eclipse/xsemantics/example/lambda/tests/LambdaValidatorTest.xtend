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

package org.eclipse.xsemantics.example.lambda.tests

import com.google.inject.Inject
import org.eclipse.xsemantics.example.lambda.LambdaInjectorProvider
import org.eclipse.xsemantics.example.lambda.lambda.Program
import org.eclipse.xsemantics.example.lambda.validation.LambdaJavaValidator
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorProvider))
class LambdaValidatorTest extends LambdaBaseTest {
	
	ValidatorTester<LambdaJavaValidator> tester
	
	@Inject extension ParseHelper<Program>
	
	@Before
	override void setUp() {
		super.setUp
		tester = new ValidatorTester<LambdaJavaValidator>(validator, injector)
	}
	
	@Test
	def void testValidateOk() {
		assertOk('''lambda x . lambda y . x y''')
	}
	
	@Test
	def void testNonOptimalTypeVariables() {
		assertOk('''lambda x : a. lambda y : b . x y''')
	}
	
	@Test
	def void testOmega() {
		assertAll('''lambda x . x x''',
'''Diagnostic ERROR code=org.eclipse.xsemantics.example.lambda.xsemantics.ApplicationType "failed: ApplicationType: [x <- X1] |- subst{X1=a -> b} |> (x x) : Type" at Program.term->Abstraction.term->Application
Diagnostic ERROR code=org.eclipse.xsemantics.example.lambda.xsemantics.Unify "failed: cannot unify X2 with a -> b" at Program.term->Abstraction.term->Application
Diagnostic ERROR code=org.eclipse.xsemantics.example.lambda.xsemantics.Notoccur "failed: X2 occurs in a -> b" at Program.term->Abstraction.term->Application
Diagnostic ERROR code=org.eclipse.xsemantics.example.lambda.xsemantics.Notoccur "failed: X2 occurs in X2" at Program.term->Abstraction.term->Application
Diagnostic ERROR "failed: variable.typevarName != other.typevarName" at Program.term->Abstraction.term->Application'''
		)
	}
	
	def void assertOk(CharSequence program) {
		assertOk(tester.validate(program.parse))
	}
	
	def void assertOk(AssertableDiagnostics validate) {
		if (listOfDiagnostics(validate).size() != 0) {
			for (Diagnostic diag : listOfDiagnostics(validate)) {
				System::err.println(diag.toString());
			}
			Assert::fail("There are expected to be no diagnostics.: "
					+ diagnosticsToString(validate));
		}
	}
	
	def void assertAll(CharSequence program, CharSequence expectedErrors) {
		assertAll(
			tester.validate(program.parse),
			expectedErrors
		)
	}
	
	def void assertAll(AssertableDiagnostics validate,
			CharSequence expectedErrors) {
		assertEqualsStrings(
			removeObjectIdentifiers(expectedErrors.toString()).trim(),
			removeObjectIdentifiers(diagnosticsToString(validate))
		);
	}
	
	def listOfDiagnostics(AssertableDiagnostics validate) {
		return validate.getDiagnostic().getChildren();
	}
	
	def diagnosticsToString(AssertableDiagnostics validate) {
		validate.diagnostic.children.join("\n");
	}
	
	def removeObjectIdentifiers(String s) {
		s.replaceAll("@(\\w)+", "")
	}
}