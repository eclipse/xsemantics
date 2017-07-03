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

package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.Application;
import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.IntType;
import it.xsemantics.example.lambda.lambda.Parameter;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.StringType;
import it.xsemantics.example.lambda.lambda.Term;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.Variable;
import it.xtypes.runtime.TypeSystemResult;
import it.xtypes.runtime.TypingJudgmentEnvironment;

import static it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.*;

public class LambdaTypeTest extends LambdaAbstractTests {

	public void testParamSameType() throws Exception {
		String programString = "lambda x : int . x x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Parameter parameter = abstraction.getParam();

		TypeSystemResult<Type> result = typeSystem.typeAsType(parameter);
		assertEquals(parameter.getType(), result.getValue());

		TypingJudgmentEnvironment environment = new TypingJudgmentEnvironment();
		environment.add(parameter, parameter.getType());

		Application application = getApplication(abstraction.getTerm());
		Variable x = getVariable(application.getFun());
		result = typeSystem.typeAsType(environment, x);
		assertEquals(parameter.getType(), result.getValue());
		x = getVariable(application.getArg());
		result = typeSystem.typeAsType(environment, x);
		assertEquals(parameter.getType(), result.getValue());
	}

	public void testParamSameType2() throws Exception {
		String programString = "lambda x . x x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Parameter parameter = abstraction.getParam();

		TypeSystemResult<Type> result = typeSystem.typeAsType(parameter);
		Type typeResult = result.getValue();
		String typeVariable = getTypeVariable(typeResult).getTypevarName();
		assertEquals("X1", typeVariable);

		TypingJudgmentEnvironment environment = new TypingJudgmentEnvironment();
		environment.add(parameter, typeResult);

		Application application = getApplication(abstraction.getTerm());
		Variable x = getVariable(application.getFun());
		result = typeSystem.typeAsType(environment, x);
		assertEquals(typeResult, result.getValue());
		x = getVariable(application.getArg());
		result = typeSystem.typeAsType(environment, x);
		assertEquals(typeResult, result.getValue());
	}

	public void testParamWithType() throws Exception {
		String programString = "lambda x : int . x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Parameter parameter = abstraction.getParam();

		TypeSystemResult<Type> result = typeSystem.typeAsType(parameter);
		assertEquals(parameter.getType(), result.getValue());
	}

	public void testParamWithNoType() throws Exception {
		String programString = "lambda x . x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Parameter parameter = abstraction.getParam();

		TypeSystemResult<Type> result = typeSystem.typeAsType(parameter);
		assertEquals("X1", getTypeVariable(result.getValue()).getTypevarName());
	}

	public void testIntConstantResult() throws Exception {
		String programString = "lambda x . 10";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		TypeSystemResult<Type> result = typeSystem.typeAsType(abstraction);
		assertEquals("a -> int", rep(result.getValue()));
	}

	public void testInferIntArrowTypeFromBody() throws Exception {
		String programString = "lambda x . -x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		TypeSystemResult<Type> result = typeSystem.typeAsType(abstraction);
		assertEquals("int -> int", rep(result.getValue()));
		assertApplicationTrace("./output/testInferIntArrowTypeFromBody.txt",
				result);
	}

	public void testIntConstant() throws Exception {
		String programString = "lambda x : X . 10";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction.getTerm();
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		printApplicationTrace(result);
		assertTrue(result.getValue() instanceof IntType);
	}

	public void testStringConstant() throws Exception {
		String programString = "lambda x : X . 'foo'";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction.getTerm();
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		printApplicationTrace(result);
		assertTrue(result.getValue() instanceof StringType);
	}

	public void testTypeAbstractionWithNoType() throws Exception {
		String programString = "lambda x . x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertApplicationTrace("./output/testTypeAbstractionWithNoType.txt",
				result);
		Type type = result.getValue();
		ArrowType arrowType = getArrowType(type);
		assertEquals("X1", getTypeVariable(arrowType.getLeft()).getTypevarName());
		assertEquals("X1", getTypeVariable(arrowType.getRight()).getTypevarName());
	}

	public void testTypeAbstractionWithType() throws Exception {
		String programString = "lambda x : string . x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertApplicationTrace("./output/testTypeAbstractionWithType.txt",
				result);
		ArrowType arrowType = getArrowType(result.getValue());
		assertTrue(arrowType.getLeft() instanceof StringType);
		assertTrue(arrowType.getRight() instanceof StringType);
	}

	public void testTypeAbstractionNested() throws Exception {
		String programString = "lambda x . lambda y. x y";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertApplicationTrace("./output/testTypeAbstractionNested.txt", result);
		assertEquals("(a -> b) -> a -> b", rep(result.getValue()));
	}

	public void testTypeAbstractionNested2() throws Exception {
		String programString = "lambda x . lambda y. y x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		// assertApplicationTrace("./output/testTypeAbstractionNested.txt",
		// result);
		assertEquals("a -> (a -> b) -> b", rep(result.getValue()));
	}

	public void testTypeVarBodyWithNoEnv() throws Exception {
		String programString = "lambda x . x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction.getTerm();
		// try to type body with no mapping for the param in the environment
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertFailureOutput("./output/testTypeVarBodyWithNoEnv.txt", result);
	}

	public void testTypeApplication() throws Exception {
		String programString = "(lambda x . x) 10";
		Program program = getLambdaProgram(programString);
		Application application = getApplication(program.getTerm());

		Term term = application;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		// printFailureTrace(result);
		repOut(result.getValue());
		assertApplicationTrace("./output/testTypeApplication.txt", result);
		assertTrue(result.getValue() instanceof IntType);
	}

	public void testTypeApplicationNested() throws Exception {
		String programString = "(lambda x . lambda y . y) 10";
		Program program = getLambdaProgram(programString);
		Application application = getApplication(program.getTerm());

		Term term = application;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertApplicationTrace("./output/testTypeApplicationNested.txt", result);
		assertEquals("a -> a", rep(result.getValue()));
	}

	public void testOmega() throws Exception {
		String programString = "lambda x . x x";
		Program program = getLambdaProgram(programString);

		Term term = program.getTerm();
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		// should fail
		assertFailureContainsStringInTrace(
				result,
				"rule UnifyVariableArrow failed: [X1 -> (TypeVariable 'X2' -> TypeVariable 'X3'), x -> TypeVariable 'X1'] |- TypeVariable 'X2' == (TypeVariable 'X2' -> TypeVariable 'X3')");
		assertFailureContainsStringInTrace(
				result,
				"NotOccurVarInArrow [X1 -> (TypeVariable 'X2' -> TypeVariable 'X3'), x -> TypeVariable 'X1'] |- TypeVariable 'X2' !- (TypeVariable 'X2' -> TypeVariable 'X3')");
	}

	public void testInferArgFunType() throws Exception {
		String programString = "lambda f . f 10";
		Program program = getLambdaProgram(programString);

		Term term = program.getTerm();
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(int -> a) -> a", rep(result.getValue()));
	}

	public void testInferArgFunType2() throws Exception {
		String programString = "lambda f . -(f 10)";
		Program program = getLambdaProgram(programString);

		Term term = program.getTerm();
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(int -> int) -> int", rep(result.getValue()));
	}

	public void testTypeIntArgFunType() throws Exception {
		String programString = "lambda f : int -> int . -(f 10)";
		Program program = getLambdaProgram(programString);

		Term term = program.getTerm();
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(int -> int) -> int", rep(result.getValue()));
	}
	
	public void testTypeDouble() throws Exception {
		String programString = "lambda f . (lambda x. (f (f x)))";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(a -> a) -> a -> a", rep(result.getValue()));
	}

	public void testTypeCompose() throws Exception {
		String programString = "lambda f . lambda g. lambda x. (f (g x))";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(a -> b) -> (c -> a) -> c -> b", rep(result.getValue()));
	}

	public void testTypeCompose2() throws Exception {
		String programString = "lambda f . lambda g. lambda x. (g (f x))";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(a -> b) -> (b -> c) -> a -> c", rep(result.getValue()));
	}

	public void testTypeComposeWithInferredInt() throws Exception {
		String programString = "lambda f . lambda g. lambda x. (g (f -x))";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(int -> a) -> (a -> b) -> int -> b",
				rep(result.getValue()));
	}

	public void testTypeComposeWithInferredInt2() throws Exception {
		String programString = "lambda f . lambda g. lambda x. (g -(f x))";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(a -> int) -> (int -> b) -> a -> b",
				rep(result.getValue()));
	}

	public void testTypeComposeWithInferredInt3() throws Exception {
		String programString = "lambda f . lambda g. lambda x. -(g (f x))";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(a -> b) -> (b -> int) -> a -> int",
				rep(result.getValue()));
	}

	public void testTypeComposeWithInferredInt4() throws Exception {
		String programString = "lambda f . lambda g. f (g 2)";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());

		Term term = abstraction;
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("(a -> b) -> (int -> a) -> b",
				rep(result.getValue()));
	}

	public void testTypeAbstractionAbstraction() throws Exception {
		String programString = "lambda x . lambda y . y";
		Program program = getLambdaProgram(programString);

		Term term = program.getTerm();
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("a -> b -> b", rep(result.getValue()));
	}

	public void testTypeAbstractionAbstraction2() throws Exception {
		String programString = "lambda x . lambda y . x";
		Program program = getLambdaProgram(programString);

		Term term = program.getTerm();
		TypeSystemResult<Type> result = typeSystem.typeAsType(term);
		assertEquals("a -> b -> a", rep(result.getValue()));
	}
}
