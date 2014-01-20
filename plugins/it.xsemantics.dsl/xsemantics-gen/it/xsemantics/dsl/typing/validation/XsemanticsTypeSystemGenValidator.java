package it.xsemantics.dsl.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.dsl.typing.XsemanticsTypeSystemGen;
import it.xsemantics.dsl.validation.AbstractXsemanticsValidator;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;

@SuppressWarnings("all")
public class XsemanticsTypeSystemGenValidator extends AbstractXsemanticsValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected XsemanticsTypeSystemGen xsemanticsSystem;
  
  protected XsemanticsTypeSystemGen getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
