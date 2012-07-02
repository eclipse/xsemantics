package it.xsemantics.example.expressions.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.expressions.Variable;
import it.xsemantics.example.expressions.typing.ExpressionsSemantics;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

public class ExpressionsSemanticsValidator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected ExpressionsSemantics xsemanticsSystem;
  
  @Check
  public void checkVariable(final Variable variable) {
    generateErrors(
    	xsemanticsSystem.checkVariable(variable),
    		variable);
  }
}
