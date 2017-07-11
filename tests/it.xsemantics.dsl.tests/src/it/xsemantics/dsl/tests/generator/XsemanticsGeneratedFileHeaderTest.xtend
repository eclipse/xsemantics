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

package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import com.google.inject.Provider
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsGeneratedFileHeaderTest extends XsemanticsBaseTest {

	@Rule
	@Inject public TemporaryFolder temporaryFolder

	@Inject Provider<XtextResourceSet> resourceSetProvider

	@Inject extension CompilationTestHelper

	var XtextResourceSet resourceSet

	val SAMPLE_HEADER = ('''
		/**
		 * (C) This is a test
		 * copyright header.
		 */
	''').toString().replaceAll("\r", "");

	@Before
	def void setUp() {
		resourceSet = resourceSetProvider.get
	}

	val TESTS_INPUT_FILES = "./tests_input_files/"

	@Test
	def testFjFirst() {
		assertCorrectFileHeader("header_test.xsemantics");
	}

	def private assertCorrectFileHeader(CharSequence... files) {
		for (file : files) {
			resourceSet.getResource(URI::createURI(TESTS_INPUT_FILES + file), true);
		}

		resourceSet.compile [
			assertNoValidationErrors

			getAllGeneratedResources.forEach [ name, content |
				val start = content.subSequence(0, SAMPLE_HEADER.length + 10).toString().replaceAll("\r", "").
					substring(0, SAMPLE_HEADER.length);
				assertEquals("Header not correctly generated for " + name, SAMPLE_HEADER, start);
			]

			// this will issue Java compilation on generated Java code
			compiledClass
		]
	}

}
