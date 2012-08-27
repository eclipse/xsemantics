package it.xsemantics.example.lambda.xsemantics.validation;

import com.google.inject.Inject;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.validation.AbstractLambdaJavaValidator;
import it.xsemantics.example.lambda.xsemantics.LambdaXsemanticsSystem;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.Check;

public class LambdaXsemanticsSystemValidator extends AbstractLambdaJavaValidator {
  @Inject
  protected LambdaXsemanticsSystem xsemanticsSystem;
  
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Check
  public void checkProgram(final Program program) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkProgram(program),
    		program);
  }
}
