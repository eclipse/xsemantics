package it.xsemantics.example.expressions.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.typing.ExtendedExpressionsSemantics;
import it.xsemantics.example.expressions.typing.validation.ExpressionsSemanticsValidator;

/**
 * This system is more involved:
 * we want to implicitly convert string literals to numbers
 * and to booleans when this is possible
 */
@SuppressWarnings("all")
public class ExtendedExpressionsSemanticsValidator extends ExpressionsSemanticsValidator {
  @Inject
  protected ExtendedExpressionsSemantics xsemanticsSystem;
  
  @Override
  protected ExtendedExpressionsSemantics getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
