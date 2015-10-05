package it.xsemantics.example.expressions.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.typing.CachedExpressionsSemantics;
import it.xsemantics.example.expressions.typing.validation.ExtendedExpressionsSemanticsValidator;

/**
 * This system caches typing for variables, which involves
 * expensive type inference
 */
@SuppressWarnings("all")
public class CachedExpressionsSemanticsValidator extends ExtendedExpressionsSemanticsValidator {
  @Inject
  protected CachedExpressionsSemantics xsemanticsSystem;
  
  @Override
  protected CachedExpressionsSemantics getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
