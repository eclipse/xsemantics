package it.xsemantics.dsl.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;

public class XsemanticsTypeSystemValidator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected XsemanticsTypeSystem xsemanticsSystem;
}
