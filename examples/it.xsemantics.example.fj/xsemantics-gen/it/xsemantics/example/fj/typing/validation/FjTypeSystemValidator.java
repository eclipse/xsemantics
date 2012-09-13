package it.xsemantics.example.fj.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.typing.FjTypeSystem;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

/**
 * A version of the FJ system where type computation involves also
 * type checking.
 */
public class FjTypeSystemValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected FjTypeSystem xsemanticsSystem;
  
  protected FjTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Check
  public void checkMethodBody(final Method method) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMethodBody(method),
    		method);
  }
  
  @Check
  public void checkField(final Field field) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkField(field),
    		field);
  }
  
  @Check
  public void checkMethodOverride(final Method method) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMethodOverride(method),
    		method);
  }
  
  @Check
  public void checkClassHierachyNotCyclic(final it.xsemantics.example.fj.fj.Class cl) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkClassHierachyNotCyclic(cl),
    		cl);
  }
  
  @Check
  public void checkMain(final Program program) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMain(program),
    		program);
  }
}
