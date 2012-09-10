package it.xsemantics.example.fj.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.typing.FjSepTypeSystem;
import it.xsemantics.example.fj.typing.validation.FjTypeSystemValidator;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.Check;

/**
 * A version of the FJ system where type computation and
 * checking are separated.
 */
public class FjSepTypeSystemValidator extends FjTypeSystemValidator {
  @Inject
  protected FjSepTypeSystem xsemanticsSystem;
  
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Check
  public void checkClassOk(final it.xsemantics.example.fj.fj.Class clazz) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkClassOk(clazz),
    		clazz);
  }
  
  @Override
  @Check
  public void checkMain(final Program program) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkMain(program),
    		program);
  }
  
  @Override
  @Check
  public void checkMethodBody(final Method method) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkMethodBody(method),
    		method);
  }
  
  @Override
  @Check
  public void checkField(final Field field) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkField(field),
    		field);
  }
  
  @Override
  @Check
  public void checkMethodOverride(final Method method) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkMethodOverride(method),
    		method);
  }
}
