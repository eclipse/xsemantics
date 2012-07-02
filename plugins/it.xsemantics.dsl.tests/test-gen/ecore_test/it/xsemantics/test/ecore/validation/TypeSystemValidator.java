package it.xsemantics.test.ecore.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import it.xsemantics.test.ecore.TypeSystem;

public class TypeSystemValidator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected TypeSystem xsemanticsSystem;
}
