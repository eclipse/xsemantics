package it.xsemantics.example.expressions.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.expressions.Variable;
import it.xsemantics.example.expressions.typing.ExpressionsSemantics;
import it.xsemantics.example.expressions.validation.AbstractExpressionsJavaValidator;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.Check;

public class ExpressionsSemanticsValidator extends AbstractExpressionsJavaValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected ExpressionsSemantics xsemanticsSystem;
  
  protected ExpressionsSemantics getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Check
  public void checkVariable(final Variable variable) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkVariable(variable),
    		variable);
  }
}
