package it.xsemantics.test.expressions.ecore.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import it.xsemantics.test.expressions.ecore.TypeSystem;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class TypeSystemValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected TypeSystem xsemanticsSystem;
  
  protected TypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
