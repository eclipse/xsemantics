/**
 * 
 */
package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.LambdaStandaloneSetup;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.tests.util.LambdaTestsUtil;
import it.xsemantics.example.lambda.xsemantics.LambdaStringRepresentation;
import it.xsemantics.example.lambda.xsemantics.LambdaXsemanticsSystem;

import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Before;

/**
 * @author Lorenzo Bettini
 * 
 */
public class LambdaAbstractTests extends AbstractXtextTests {

	protected LambdaXsemanticsSystem typeSystem;

	protected LambdaStringRepresentation stringProvider;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		with(LambdaStandaloneSetup.class);
		typeSystem = get(LambdaXsemanticsSystem.class);
		stringProvider = get(LambdaStringRepresentation.class);
	}

	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		/* TODO 
		 * serializer tests fail
		 * java.lang.RuntimeException: State '{ArrowType.left=}' may not follow 'start'.
			Valid followers are: 
			Semantic Object: Program.term->Abstraction.term->Abstraction.param->Parameter'y'.type->ArrowType.left->ArrowType
			Context: Type_ArrowType_1_0
		 */
		return false;
	}

	protected Program getLambdaProgram(String program) throws Exception {
		return (Program) getModel(program);
	}

	public String rep(Type type) {
		return LambdaTestsUtil.rep(type);
	}

	public void repOut(Type type) {
		LambdaTestsUtil.repOut(type);
	}
}
