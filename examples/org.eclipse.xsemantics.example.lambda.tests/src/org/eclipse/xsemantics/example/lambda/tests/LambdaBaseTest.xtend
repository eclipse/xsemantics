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
import com.google.inject.Injector
import org.eclipse.xsemantics.example.lambda.LambdaInjectorProvider
import org.eclipse.xsemantics.example.lambda.lambda.Abstraction
import org.eclipse.xsemantics.example.lambda.lambda.ArrowType
import org.eclipse.xsemantics.example.lambda.lambda.Constant
import org.eclipse.xsemantics.example.lambda.lambda.Program
import org.eclipse.xsemantics.example.lambda.lambda.Term
import org.eclipse.xsemantics.example.lambda.lambda.Type
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable
import org.eclipse.xsemantics.example.lambda.lambda.Variable
import org.eclipse.xsemantics.example.lambda.validation.LambdaJavaValidator
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaStringRepresentation
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaStringRepresentationWithTypeBeautifier
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaUtils
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaXsemanticsSystem
import org.eclipse.xsemantics.example.lambda.xsemantics.TypeSubstitutions
import org.eclipse.xsemantics.runtime.Result
import org.eclipse.xsemantics.runtime.RuleApplicationTrace
import org.eclipse.xsemantics.runtime.StringRepresentation
import org.eclipse.xsemantics.runtime.TraceUtils
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Before
import org.junit.BeforeClass
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorProvider))
class LambdaBaseTest {
	@Inject protected LambdaJavaValidator validator

	@Inject protected Injector injector
    
	@Inject extension ParseHelper<Program>

	@Inject extension ValidationTestHelper
	
	@Inject protected LambdaXsemanticsSystem system
	
	@Inject extension StringRepresentation
	
	@Inject protected LambdaExpectedTraces traces
	
	@Inject extension TraceUtils
	
	protected TypeSubstitutions substitutions
	
	@Inject protected LambdaStringRepresentation reprForSubstitutions
	
	@Inject protected LambdaStringRepresentationWithTypeBeautifier reprBeautifier
	
	@Inject protected LambdaUtils lambdaUtils
	
	protected RuleApplicationTrace trace
	
	@BeforeClass
	def static void setNewLine() {
		System::setProperty("line.separator", "\n")
	}
	
	@Before
	def void setUp() {
		lambdaUtils.resetCounter
		substitutions = new TypeSubstitutions()
		trace = new RuleApplicationTrace()
	}

	def parseAndGetProgram(CharSequence prog) {
		prog.parse
	}
	
	def parseAndAssertNoError(CharSequence prog) {
		val model = prog.parse
		model.assertNoErrors
		model
	}
	
	def <T> void assertFailure(Result<T> result) {
		if (!result.failed)
			Assert::assertTrue("should have failed, instead got: " +
				result.value.string + "\n" + 
				trace.traceAsString, 
				result.failed
			);
	}

	def void assertFailure(Boolean result) {
		if (result)
			Assert::assertTrue("should have failed", result);
	}
	
	def <T> void assertFailureTrace(Result<T> result, CharSequence expectedTrace) {
		assertFailure(result)
		assertEqualsStrings(expectedTrace, result.ruleFailedException.failureTraceAsString)
	}

	def assertEqualsStrings(Object expected, Object actual) {
		Assert.assertEquals(
			("" + expected).replaceAll("\r", ""), 
			("" + actual).replaceAll("\r", "")
		)
	}
	
	def <T> void assertResultAsString(Result<T> result, String expected) {
		if (result.failed) {
			Assert::assertFalse("should not have failed: " + 
				result.ruleFailedException.failureTraceAsString, result.failed
			)
		}
		assertEqualsStrings(expected, result.value.string)
	}

	def <T> void assertResultAsString(T result, String expected) {
		Assert::assertNotNull(result)
		assertEqualsStrings(expected, result.string)
	}
	
	def <T> void assertResultAsStringBeautifier(Result<T> result, String expected) {
		if (result.failed) {
			Assert::assertFalse("should not have failed: " + 
				result.ruleFailedException.failureTraceAsString, result.failed
			)
		}
		assertEqualsStrings(expected, reprBeautifier.string(result.value))
	}
	
	def void assertResult2AsString(Type result, String expected) {
		Assert::assertNotNull(result);
		Assert::assertNotNull(result);
		assertEqualsStrings(expected, result.string)
	}
	
	def void assertResultTrue(Boolean result) {
		Assert.assertTrue(result)
	}
	
	def getTypeVariable(Type type) {
		type as TypeVariable
	}
	
	def getArrowType(Type type) {
		type as ArrowType
	}
	
	def getTerm(CharSequence prog) {
		prog.parseAndGetProgram.term
	}
	
	def getAbstraction(CharSequence prog) {
		prog.term.abstraction
	}
	
	def getAbstraction(Term term) {
		term as Abstraction
	}
	
	def getVariable(Term term) {
		term as Variable
	}
	
	def getConstant(Term term) {
		term as Constant
	}
	
	def assertTypeVariable(Type type, String expectedName) {
		Assert::assertEquals(expectedName, getTypeVariable(type).typevarName)
	}
	
	def assertArrowType(Type type, String expectedName) {
		Assert::assertEquals(expectedName, getArrowType(type).string)
	}
	
	def assertTypeSubstitutions(TypeSubstitutions substitutions, String expected) {
		assertEqualsStrings(
			"subst{" + expected + "}", 
			reprForSubstitutions.string(substitutions)
		)
	}
}