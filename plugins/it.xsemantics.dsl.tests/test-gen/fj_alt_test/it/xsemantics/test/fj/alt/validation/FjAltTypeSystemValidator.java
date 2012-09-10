package it.xsemantics.test.fj.alt.validation;

import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import it.xsemantics.test.fj.alt.FjAltTypeSystem;
import it.xsemantics.test.fj.first.validation.FjFirstTypeSystemValidator;
import org.eclipse.xtext.validation.Check;

public class FjAltTypeSystemValidator extends FjFirstTypeSystemValidator {
  @Inject
  protected FjAltTypeSystem xsemanticsSystem;
  
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Override
  @Check
  public void checkMain(final Program program) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkMain(program),
    		program);
  }
  
  @Override
  @Check
  public void checkClassOk(final it.xsemantics.example.fj.fj.Class clazz) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkClassOk(clazz),
    		clazz);
  }
}
