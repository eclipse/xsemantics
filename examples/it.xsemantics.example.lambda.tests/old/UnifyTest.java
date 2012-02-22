package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xtypes.runtime.TypeSystemResult;

import static it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.*;

public class UnifyTest extends LambdaAbstractTests {

	public void testVarAndArrow() throws Exception {
		String programString = "lambda x : X . lambda y : int -> string. x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());
		TypeVariable typeVariable = getTypeVariable(abstraction.getParam()
				.getType());
		ArrowType arrowType = getArrowType(getAbstraction(abstraction.getTerm())
				.getParam().getType());
		TypeSystemResult<Boolean> result = typeSystem.checkUnify(typeVariable,
				arrowType);
		assertTrue(result.getValue());
		printApplicationTrace(result);
	}

	public void testVarAndArrowArrow() throws Exception {
		String programString = "lambda x : X . lambda y : (int -> string) -> (string -> int). x";
		Program program = getLambdaProgram(programString);
		Abstraction abstraction = getAbstraction(program.getTerm());
		TypeVariable typeVariable = getTypeVariable(abstraction.getParam()
				.getType());
		ArrowType arrowType = getArrowType(getAbstraction(abstraction.getTerm())
				.getParam().getType());

		TypeSystemResult<Boolean> result = typeSystem.checkUnify(typeVariable,
				arrowType);
		assertTrue(result.getValue());
		assertApplicationTrace("./output/testVarAndArrowArrow.txt", result);
	}

}
