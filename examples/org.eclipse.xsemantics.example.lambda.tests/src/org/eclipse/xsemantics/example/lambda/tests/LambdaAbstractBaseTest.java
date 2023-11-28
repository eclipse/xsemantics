/**
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 */
package org.eclipse.xsemantics.example.lambda.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.xsemantics.example.lambda.lambda.Abstraction;
import org.eclipse.xsemantics.example.lambda.lambda.ArrowType;
import org.eclipse.xsemantics.example.lambda.lambda.Constant;
import org.eclipse.xsemantics.example.lambda.lambda.Program;
import org.eclipse.xsemantics.example.lambda.lambda.Term;
import org.eclipse.xsemantics.example.lambda.lambda.Type;
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable;
import org.eclipse.xsemantics.example.lambda.lambda.Variable;
import org.eclipse.xsemantics.example.lambda.tests.util.LambdaTestsUtil;
import org.eclipse.xsemantics.example.lambda.validation.LambdaValidator;
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaStringRepresentation;
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaStringRepresentationWithTypeBeautifier;
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaUtils;
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaXsemanticsSystem;
import org.eclipse.xsemantics.example.lambda.xsemantics.TypeSubstitutions;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.StringRepresentation;
import org.eclipse.xsemantics.runtime.TraceUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Injector;

@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorProvider.class)
public abstract class LambdaAbstractBaseTest {
	@Inject
	protected LambdaValidator validator;

	@Inject
	protected Injector injector;

	@Inject
	@Extension
	protected ParseHelper<Program> parseHelper;

	@Inject
	@Extension
	protected ValidationTestHelper validationTestHelper;

	@Inject
	protected LambdaXsemanticsSystem system;

	@Inject
	@Extension
	private StringRepresentation stringRepresentation;

	@Inject
	protected LambdaExpectedTraces traces;

	@Inject
	@Extension
	private TraceUtils traceUtils;

	protected TypeSubstitutions substitutions;

	@Inject
	protected LambdaStringRepresentation reprForSubstitutions;

	@Inject
	protected LambdaStringRepresentationWithTypeBeautifier reprBeautifier;

	@Inject
	protected LambdaUtils lambdaUtils;

	protected RuleApplicationTrace trace;

	@BeforeClass
	public static void setNewLine() {
		System.setProperty("line.separator", "\n");
	}

	@Before
	public void setUp() {
		lambdaUtils.resetCounter();
		substitutions = new TypeSubstitutions();
		trace = new RuleApplicationTrace();
	}

	public Program parseAndGetProgram(final CharSequence prog) {
		try {
			return parseHelper.parse(prog);
		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}

	public Program parseAndAssertNoError(final CharSequence prog) {
		try {
			final Program model = parseHelper.parse(prog);
			validationTestHelper.assertNoErrors(model);
			return model;
		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}

	protected Program getLambdaProgram(final String program) {
		try {
			return parseHelper.parse(program);
		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}

	public <T extends Object> void assertFailure(final Result<T> result) {
		if (!result.failed()) {
			assertTrue(
				"should have failed, instead got: " + stringRepresentation.string(result.getValue())
				+ "\n" + traceUtils.traceAsString(trace),
				result.failed());
		}
	}

	public void assertFailure(final Boolean result) {
		if (result.booleanValue()) {
			assertTrue("should have failed", result.booleanValue());
		}
	}

	public <T extends Object> void assertFailureTrace(final Result<T> result, final CharSequence expectedTrace) {
		assertFailure(result);
		assertEqualsStrings(expectedTrace, traceUtils.failureTraceAsString(result.getRuleFailedException()));
	}

	public void assertEqualsStrings(final Object expected, final Object actual) {
		Assert.assertEquals(("" + expected).replace("\r", ""), ("" + actual).replace("\r", ""));
	}

	public <T extends Object> void assertResultAsString(final Result<T> result, final String expected) {
		if (result.failed()) {
			assertFalse("should not have failed: " +
					traceUtils.failureTraceAsString(result.getRuleFailedException()),
				result.failed());
		}
		assertEqualsStrings(expected,
			stringRepresentation.string(result.getValue()));
	}

	public <T extends Object> void assertResultAsString(final T result, final String expected) {
		assertNotNull(result);
		assertEqualsStrings(expected, stringRepresentation.string(result));
	}

	public <T extends Object> void assertResultAsStringBeautifier(final Result<T> result, final String expected) {
		if (result.failed()) {
			Assert.assertFalse("should not have failed: " +
					traceUtils.failureTraceAsString(result.getRuleFailedException()),
				result.failed());
		}
		assertEqualsStrings(expected, reprBeautifier.string(result.getValue()));
	}

	public void assertResult2AsString(final Type result, final String expected) {
		assertNotNull(result);
		assertNotNull(result);
		assertEqualsStrings(expected, stringRepresentation.string(result));
	}

	public void assertResultTrue(final Boolean result) {
		assertTrue((result).booleanValue());
	}

	public TypeVariable getTypeVariable(final Type type) {
		return (TypeVariable) type;
	}

	public ArrowType getArrowType(final Type type) {
		return (ArrowType) type;
	}

	public Term getTerm(final CharSequence prog) {
		return parseAndGetProgram(prog).getTerm();
	}

	public Abstraction getAbstraction(final CharSequence prog) {
		return getAbstraction(getTerm(prog));
	}

	public Abstraction getAbstraction(final Term term) {
		return (Abstraction) term;
	}

	public Variable getVariable(final Term term) {
		return (Variable) term;
	}

	public Constant getConstant(final Term term) {
		return (Constant) term;
	}

	public void assertTypeVariable(final Type type, final String expectedName) {
		assertEquals(expectedName, getTypeVariable(type).getTypevarName());
	}

	public void assertArrowType(final Type type, final String expectedName) {
		assertEquals(expectedName, stringRepresentation.string(getArrowType(type)));
	}

	public void assertTypeSubstitutions(final TypeSubstitutions substitutions, final String expected) {
		assertEqualsStrings("subst{" + expected + "}", reprForSubstitutions.string(substitutions));
	}

	public String rep(final Type type) {
		return LambdaTestsUtil.rep(type);
	}
}
