package it.xsemantics.example.lambda.tests;

import static it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.getAbstraction;
import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.Term;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.xsemantics.LambdaTypeModifier;
import it.xsemantics.runtime.RuleFailedException;

public class LambdaTypeInferAndModifyTest extends LambdaAbstractTests {

	LambdaTypeModifier lambdaTypeModifier;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		lambdaTypeModifier = getInjector().getInstance(LambdaTypeModifier.class);
	}

	public void testInferTypeAndSetAbstractionTypeWithNoExplicitType()
			throws Exception {
		String programString = "lambda x . x";
		Abstraction abstraction = getAbstractionFromString(programString);
		RuleFailedException failure = lambdaTypeModifier
				.setAbstractionParamType(abstraction);
		String expectedTypeString = "a";
		assertAbstractionParamType(abstraction, failure, expectedTypeString);
	}

	public void testInferTypeAndModifyAbstractionTypeWithNoExplicitType()
			throws Exception {
		String programString = "lambda x . x";
		Abstraction abstraction = getAbstractionFromString(programString);
		RuleFailedException failure = lambdaTypeModifier
				.modifyAbstractionParamType(abstraction);
		String expectedTypeString = "a";
		assertAbstractionParamType(abstraction, failure, expectedTypeString);
	}

	public void testInferTypeAndModifyAbstractionTypeWithExplicitType()
			throws Exception {
		String programString = "lambda x : int -> int . x";
		Abstraction abstraction = getAbstractionFromString(programString);
		RuleFailedException failure = lambdaTypeModifier
				.modifyAbstractionParamType(abstraction);
		String expectedTypeString = "a";
		assertAbstractionParamType(abstraction, failure, expectedTypeString);
	}

	public void testInferTypeAndModifyAbstractionTypeCompose() throws Exception {
		String programString = "lambda f . lambda g. lambda x. (f (g x))";
		Abstraction abstraction = getAbstractionFromString(programString);
		RuleFailedException failure = lambdaTypeModifier
				.modifyAbstractionParamType(abstraction);
		String expectedTypeString = "a -> b";
		assertAbstractionParamType(abstraction, failure, expectedTypeString);
	}

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

	public void assertAbstractionParamType(Abstraction abstraction,
			RuleFailedException failure, String expectedTypeString) {
		assertNotFailure(failure);
		Type type = abstraction.getParam().getType();
		assertTrue(type != null);
		assertEquals(expectedTypeString, rep(type));
	}

	protected void assertNotFailure(RuleFailedException failure) {
		assertTrue(failure == null);
	}

	public Abstraction getAbstractionFromString(String programString)
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
