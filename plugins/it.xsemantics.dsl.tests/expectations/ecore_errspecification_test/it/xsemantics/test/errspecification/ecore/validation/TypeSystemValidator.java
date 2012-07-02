package it.xsemantics.test.errspecification.ecore.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import it.xsemantics.test.errspecification.ecore.TypeSystem;

public class TypeSystemValidator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected TypeSystem xsemanticsSystem;
}
