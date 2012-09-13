package it.xsemantics.test.validation.ecore.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import it.xsemantics.test.validation.ecore.TypeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

public class TypeSystemValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected TypeSystem xsemanticsSystem;
  
  protected TypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Check
  public void checkEClass(final EClass eClass) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkEClass(eClass),
    		eClass);
  }
}
