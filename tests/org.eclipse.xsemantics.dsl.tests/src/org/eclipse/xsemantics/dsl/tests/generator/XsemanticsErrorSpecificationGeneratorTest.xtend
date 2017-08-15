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
import org.eclipse.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.xsemantics.dsl.generator.XsemanticsErrorSpecificationGenerator
import org.eclipse.xsemantics.dsl.xsemantics.ErrorSpecification
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsErrorSpecificationGeneratorTest extends XsemanticsGeneratorBaseTest {

	@Inject XsemanticsErrorSpecificationGenerator errSpecGenerator
	
	@Test
	def void testCompileErrorOfErrorSpecification() {
		checkErrorOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
'''

String error = (("this " + c) + " made an error!");''', "error")
	}
	
	@Test
	def void testCompileSourceOfErrorSpecification() {
		checkSourceOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
'''

EObject source = c;''', "source")
	}
	
	@Test
	def void testCompileFeatureOfErrorSpecification() {
		checkFeatureOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
'''

EStructuralFeature _eContainingFeature = c.eClass().eContainingFeature();
EStructuralFeature feature = _eContainingFeature;''', "feature")
	}
	
	@Test
	def void testCompileEmptySourceOfErrorSpecification() {
		checkSourceOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature,
			"", "null")
	}
	
	@Test
	def void testCompileEmptyFeatureOfErrorSpecification() {
		checkFeatureOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature,
			"", "null")
	}

	def void checkErrorOfErrorSpecification(CharSequence inputProgram, CharSequence expected, CharSequence expectedVar) {
		checkCompilationOfErrorSpecification(inputProgram,
			[ errSpec, b | errSpecGenerator.compileErrorOfErrorSpecification(errSpec, b) ],
			expected, expectedVar
		)
	}
	
	def void checkSourceOfErrorSpecification(CharSequence inputProgram, CharSequence expected, CharSequence expectedVar) {
		checkCompilationOfErrorSpecification(inputProgram,
			[ errSpec, b | errSpecGenerator.compileSourceOfErrorSpecification(errSpec, b) ],
			expected, expectedVar
		)
	}
	
	def void checkFeatureOfErrorSpecification(CharSequence inputProgram, CharSequence expected, CharSequence expectedVar) {
		checkCompilationOfErrorSpecification(inputProgram,
			[ errSpec, b | errSpecGenerator.compileFeatureOfErrorSpecification(errSpec, b) ],
			expected, expectedVar
		)
	}
	
	def void checkCompilationOfErrorSpecification(CharSequence inputProgram,
		(ErrorSpecification, ITreeAppendable)=>String compilation,
		CharSequence expected, CharSequence expectedVar
	) {
		val jDesc = inputProgram.parseAndAssertNoError.firstJudgmentDescription
		val errSpec = jDesc.firstErrorSpecification
		val appendable = createAppendable
		val variable = compilation.apply(errSpec, appendable)
		assertEqualsStrings(expected, appendable)
		assertEqualsStrings(expectedVar, variable)
	}
	
}