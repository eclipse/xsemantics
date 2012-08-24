package it.xsemantics.dsl.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.dsl.typing.XsemanticsTypeSystemGen;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;

public class XsemanticsTypeSystemGenValidator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected XsemanticsTypeSystemGen xsemanticsSystem;
}
