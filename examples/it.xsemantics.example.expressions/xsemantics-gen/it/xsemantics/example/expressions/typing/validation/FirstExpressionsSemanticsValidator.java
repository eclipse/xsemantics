package it.xsemantics.example.expressions.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.expressions.Variable;
import it.xsemantics.example.expressions.typing.FirstExpressionsSemantics;
import it.xsemantics.example.expressions.validation.AbstractExpressionsJavaValidator;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.Check;

public class FirstExpressionsSemanticsValidator extends AbstractExpressionsJavaValidator {
  @Inject
  protected FirstExpressionsSemantics xsemanticsSystem;
  
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Check
  public void checkVariable(final Variable variable) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkVariable(variable),
    		variable);
  }
}
