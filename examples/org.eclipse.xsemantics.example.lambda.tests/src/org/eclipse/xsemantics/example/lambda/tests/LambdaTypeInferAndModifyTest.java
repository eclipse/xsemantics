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

package org.eclipse.xsemantics.example.lambda.tests;

import static org.eclipse.xsemantics.example.lambda.tests.util.LambdaTestsUtil.getAbstraction;

import org.junit.Before;
import org.junit.Test;

import org.eclipse.xsemantics.example.lambda.lambda.Abstraction;
import org.eclipse.xsemantics.example.lambda.lambda.Program;
import org.eclipse.xsemantics.example.lambda.lambda.Term;
import org.eclipse.xsemantics.example.lambda.lambda.Type;
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaTypeModifier;
import org.eclipse.xsemantics.runtime.RuleFailedException;

public class LambdaTypeInferAndModifyTest extends LambdaAbstractTests {

	LambdaTypeModifier lambdaTypeModifier;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		lambdaTypeModifier = getInjector().getInstance(LambdaTypeModifier.class);
	}

	@Test
	public void testInferTypeAndSetAbstractionTypeWithNoExplicitType()
			throws Exception {
		String programString = "lambda x . x";
		Abstraction abstraction = getAbstractionFromString(programString);
		RuleFailedException failure = lambdaTypeModifier
				.setAbstractionParamType(abstraction);
		String expectedTypeString = "a";
		assertAbstractionParamType(abstraction, failure, expectedTypeString);
	}

	@Test
	public void testInferTypeAndModifyAbstractionTypeWithNoExplicitType()
			throws Exception {
		String programString = "lambda x . x";
		Abstraction abstraction = getAbstractionFromString(programString);
		RuleFailedException failure = lambdaTypeModifier
				.modifyAbstractionParamType(abstraction);
		String expectedTypeString = "a";
		assertAbstractionParamType(abstraction, failure, expectedTypeString);
	}

	@Test
	public void testInferTypeAndModifyAbstractionTypeWithExplicitType()
			throws Exception {
		String programString = "lambda x : int -> int . x";
		Abstraction abstraction = getAbstractionFromString(programString);
		RuleFailedException failure = lambdaTypeModifier
				.modifyAbstractionParamType(abstraction);
		String expectedTypeString = "a";
		assertAbstractionParamType(abstraction, failure, expectedTypeString);
	}

	@Test
	public void testInferTypeAndModifyAbstractionTypeCompose() throws Exception {
		String programString = "lambda f . lambda g. lambda x. (f (g x))";
		Abstraction abstraction = getAbstractionFromString(programString);
		RuleFailedException failure = lambdaTypeModifier
				.modifyAbstractionParamType(abstraction);
		String expectedTypeString = "a -> b";
		assertAbstractionParamType(abstraction, failure, expectedTypeString);
	}

	@Test
	public void testCannotInferTypeAndModifyAbstractionTypeWithExplicitType()
			throws Exception {
		String programString = "lambda x : int . x x";
		Abstraction abstraction = getAbstractionFromString(programString);
		RuleFailedException failure = lambdaTypeModifier
				.modifyAbstractionParamType(abstraction);
		assertTrue(failure != null);
		// the original type must still be there
		assertEquals("int", rep(abstraction.getParam().getType()));
	}

	@Test
	public void testInferTypeAndModifyAllTypes() throws Exception {
		String programString = "lambda f . lambda g. lambda x. (f (g x))";
		Term term = getTermFromString(programString);
		RuleFailedException failure = lambdaTypeModifier.setAllTypes(term);
		assertNotFailure(failure);
		Abstraction fAbstraction = getAbstraction(term);
		assertEquals("a -> b", rep(fAbstraction.getParam().getType()));
		Abstraction gAbstraction = getAbstraction(fAbstraction.getTerm());
		assertEquals("c -> a", rep(gAbstraction.getParam().getType()));
		assertEquals("c", rep(getAbstraction(gAbstraction.getTerm()).getParam()
				.getType()));
	}

	protected void assertAbstractionParamType(Abstraction abstraction,
			RuleFailedException failure, String expectedTypeString) {
		assertNotFailure(failure);
		Type type = abstraction.getParam().getType();
		assertTrue(type != null);
		assertEquals(expectedTypeString, rep(type));
	}

	protected void assertNotFailure(RuleFailedException failure) {
		assertTrue(failure == null);
	}

	protected Abstraction getAbstractionFromString(String programString)
			throws Exception {
		Term term = getTermFromString(programString);
		Abstraction abstraction = getAbstraction(term);
		return abstraction;
	}

	protected Term getTermFromString(String programString) throws Exception {
		Program program = getLambdaProgram(programString);
		Term term = program.getTerm();
		return term;
	}
}
