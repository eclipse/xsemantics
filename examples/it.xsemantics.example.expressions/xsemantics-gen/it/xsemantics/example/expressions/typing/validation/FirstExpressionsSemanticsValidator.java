package it.xsemantics.example.expressions.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.expressions.Variable;
import it.xsemantics.example.expressions.typing.FirstExpressionsSemantics;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

public class FirstExpressionsSemanticsValidator extends XsemanticsBasedDeclarativeValidator {
	@Inject
	protected FirstExpressionsSemantics xsemanticsSystem;

	@Check
	public void checkVariable(final Variable variable) {
		generateErrors(
			xsemanticsSystem.checkVariable(variable),
			variable);
	}
}
