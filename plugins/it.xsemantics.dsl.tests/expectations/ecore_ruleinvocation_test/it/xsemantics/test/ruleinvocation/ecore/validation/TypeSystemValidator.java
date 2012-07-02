package it.xsemantics.test.ruleinvocation.ecore.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import it.xsemantics.test.ruleinvocation.ecore.TypeSystem;

public class TypeSystemValidator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected TypeSystem xsemanticsSystem;
}
