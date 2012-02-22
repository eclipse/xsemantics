package it.xsemantics.example.lambda.xsemantics.validation;

import com.google.inject.Inject;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.xsemantics.LambdaXsemanticsSystem;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

public class LambdaXsemanticsSystemValidator extends XsemanticsBasedDeclarativeValidator {
	@Inject
	protected LambdaXsemanticsSystem xsemanticsSystem;

	@Check
	public void checkProgram(final Program program) {
		generateErrors(
			xsemanticsSystem.checkProgram(program),
			program);
	}
}
