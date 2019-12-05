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

import java.util.List
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.validation.Issue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorProvider))
class LambdaValidatorTest extends LambdaAbstractBaseTest {

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
		assertAll(
			'''lambda x . x x''',
			'''
			failed: ApplicationType: [x <- X1] |- subst{X1=a -> b} |> (x x) : Type
			failed: cannot unify X2 with a -> b
			failed: X2 occurs in a -> b
			failed: X2 occurs in X2
			failed: variable.typevarName != other.typevarName
			'''
		)
	}

	def void assertOk(CharSequence program) {
		program.parseAndAssertNoError
	}

	def void assertAll(CharSequence program, CharSequence expectedErrors) {
		assertAll(
			program.parse.validate,
			expectedErrors
		)
	}

	def void assertAll(List<Issue> validate, CharSequence expectedErrors) {
		assertEqualsStrings(
			removeObjectIdentifiers(expectedErrors.toString()).trim(),
			removeObjectIdentifiers(diagnosticsToString(validate))
		);
	}

	def diagnosticsToString(List<Issue> validate) {
		validate.filter[severity == Severity.ERROR].
				map[message].join("\n")
	}

	def removeObjectIdentifiers(String s) {
		s.replaceAll("@(\\w)+", "")
	}
}
