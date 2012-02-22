package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.IntType;
import it.xsemantics.example.lambda.lambda.LambdaFactory;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.StringType;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xtypes.runtime.TypeSystemResult;
import it.xtypes.runtime.TypingJudgmentEnvironment;

import static it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.*;

public class SubstitutionTest extends LambdaAbstractTests {

	public void testSubstituteVar() throws Exception {
		String programString = "lambda x : X1 . x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());
		TypeVariable typeVariable = getTypeVariable(abstraction.getParam()
				.getType());

		TypingJudgmentEnvironment environment = new TypingJudgmentEnvironment();
		IntType intType = LambdaFactory.eINSTANCE.createIntType();
		environment.add("X1", intType);

		TypeSystemResult<Type> result = typeSystem
				.substitutionAsType(typeVariable);
		// we passed no environment so the result it's the original var
		assertTrue(result.getValue() == typeVariable);

		result = typeSystem.substitutionAsType(environment, typeVariable);
		// now we have the environment so the variable must be substituted
		assertTrue(result.getValue() instanceof IntType);
		// but with a clone
		assertFalse(result.getValue() == intType);
	}

	public void testSubstituteArrowType() throws Exception {
		String programString = "lambda x : X1 -> X2 . x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());
		Type abstractionType = abstraction.getParam().getType();

		TypingJudgmentEnvironment environment = new TypingJudgmentEnvironment();
		IntType intType = LambdaFactory.eINSTANCE.createIntType();
		environment.add("X1", intType);

		TypeSystemResult<Type> result = typeSystem.substitutionAsType(
				environment, abstractionType);
		assertApplicationTrace("./output/testSubstituteArrowType.txt", result);
		// now we have the environment so the variable must be substituted
		ArrowType arrowType = getArrowType(result.getValue());
		assertEquals("int -> a", rep(arrowType));
		assertTrue(arrowType.getLeft() instanceof IntType);
		// but with a clone
		assertFalse(arrowType.getLeft() == intType);
		// the right part was not substituted
		assertEquals("X2", getTypeVariable(arrowType.getRight()).getTypevarName());
	}

	public void testSubstituteArrowType2() throws Exception {
		String programString = "lambda x : X1 -> (X2 -> X1 -> int -> X2). x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());
		Type abstractionType = abstraction.getParam().getType();

		TypingJudgmentEnvironment environment = new TypingJudgmentEnvironment();
		IntType intType = LambdaFactory.eINSTANCE.createIntType();
		environment.add("X1", intType);
		StringType stringType = LambdaFactory.eINSTANCE.createStringType();
		environment.add("X2", stringType);

		TypeSystemResult<Type> result = typeSystem.substitutionAsType(
				environment, abstractionType);
		ArrowType arrowType = getArrowType(result.getValue());
		assertEquals(
				"int -> string -> int -> int -> string",
				rep(arrowType));
	}

}
