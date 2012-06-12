package it.xsemantics.example.fj.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.typing.FjTypeSystem;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

/**
 * A version of the FJ system where type computation involves also
 * type checking.
 */
public class FjTypeSystemValidator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected FjTypeSystem xsemanticsSystem;
  
  @Check
  public void checkMethodBody(final Method method) {
    generateErrors(
    	xsemanticsSystem.checkMethodBody(method),
    		method);
  }
  
  @Check
  public void checkField(final Field field) {
    generateErrors(
    	xsemanticsSystem.checkField(field),
    		field);
  }
  
  @Check
  public void checkMethodOverride(final Method method) {
    generateErrors(
    	xsemanticsSystem.checkMethodOverride(method),
    		method);
  }
  
  @Check
  public void checkClassHierachyNotCyclic(final it.xsemantics.example.fj.fj.Class cl) {
    generateErrors(
    	xsemanticsSystem.checkClassHierachyNotCyclic(cl),
    		cl);
  }
  
  @Check
  public void checkMain(final Program program) {
    generateErrors(
    	xsemanticsSystem.checkMain(program),
    		program);
  }
}
