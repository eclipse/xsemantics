package it.xsemantics.test.fj.first.validation;

import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.validation.AbstractFJJavaValidator;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import it.xsemantics.test.fj.first.FjFirstTypeSystem;
import org.eclipse.xtext.validation.Check;

public class FjFirstTypeSystemValidator extends AbstractFJJavaValidator {
  @Inject
  protected FjFirstTypeSystem xsemanticsSystem;
  
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Check
  public void checkMain(final Program program) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkMain(program),
    		program);
  }
  
  @Check
  public void checkClassOk(final it.xsemantics.example.fj.fj.Class clazz) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkClassOk(clazz),
    		clazz);
  }
  
  @Check
  public void checkMethodBody(final Method method) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkMethodBody(method),
    		method);
  }
  
  @Check
  public void checkField(final Field field) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkField(field),
    		field);
  }
  
  @Check
  public void checkMethodOverride(final Method method) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkMethodOverride(method),
    		method);
  }
  
  @Check
  public void checkClassHierachyNotCyclic(final it.xsemantics.example.fj.fj.Class cl) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkClassHierachyNotCyclic(cl),
    		cl);
  }
}
