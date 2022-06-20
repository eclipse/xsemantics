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

package org.eclipse.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.xsemantics.dsl.tests.XsemanticsBaseTest
import org.eclipse.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsGeneratedJavaCodeTest extends XsemanticsBaseTest {

	@Rule
	@Inject public TemporaryFolder temporaryFolder

	@Inject extension CompilationTestHelper compilationTestHelper

	@Inject Provider<XtextResourceSet> resourceSetProvider

	var XtextResourceSet resourceSet

	@Before
	def void setUp() {
		resourceSet = resourceSetProvider.get
		compilationTestHelper.javaVersion = JavaVersion.JAVA8
	}

	val TESTS_INPUT_FILES = "./tests_input_files/"

	@Test
	def testRuleInvocation() {
		assertCorrectJavaCodeGeneration("ecore_ruleinvocation_test.xsemantics");
	}

	@Test
	def testFjFirst() {
		assertCorrectJavaCodeGeneration("fj_first_test.xsemantics");
	}

	@Test
	def testFjAlt() {
		// fj_alt_test depends on fj_first_test so we must load it first
		assertCorrectJavaCodeGeneration("fj_first_test.xsemantics", "fj_alt_test.xsemantics");
	}

	@Test
	def testFjCached() {
		// cached tests depend on fj_first_test so we must load it first
		assertCorrectJavaCodeGeneration("fj_first_test.xsemantics", "fj_cached_test.xsemantics",
			"fj_cached_options_test.xsemantics");
	}

	@Test
	def testEcore() {
		assertCorrectJavaCodeGeneration("ecore_test.xsemantics");
	}

	@Test
	def testParticularCases() {
		assertCorrectJavaCodeGeneration("ecore_particular_test.xsemantics");
	}

	@Test
	def testOrExpressions() {
		assertCorrectJavaCodeGeneration("ecore_or_test.xsemantics");
	}

	@Test
	def testExpressions() {
		assertCorrectJavaCodeGeneration("ecore_expressions_test.xsemantics");
	}

	@Test
	def testValidationEcore() {
		assertCorrectJavaCodeGeneration("ecore_validation_test.xsemantics");
	}

	def private assertCorrectJavaCodeGeneration(CharSequence... files) {
		for (file : files) {
			resourceSet.getResource(URI::createURI(TESTS_INPUT_FILES + file), true);
		}
		resourceSet.compile [
			assertNoValidationErrors
			// this will issue Java compilation on generated Java code
			compiledClass
		]
	}

}
