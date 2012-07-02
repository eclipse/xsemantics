package it.xsemantics.test.validation.ecore.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import it.xsemantics.test.validation.ecore.TypeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.validation.Check;

public class TypeSystemValidator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected TypeSystem xsemanticsSystem;
  
  @Check
  public void checkEClass(final EClass eClass) {
    generateErrors(
    	xsemanticsSystem.checkEClass(eClass),
    		eClass);
  }
}
