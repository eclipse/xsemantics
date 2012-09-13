package it.xsemantics.dsl.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.dsl.typing.XsemanticsTypeSystemGen;
import it.xsemantics.dsl.validation.AbstractXsemanticsJavaValidator;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;

public class XsemanticsTypeSystemGenValidator extends AbstractXsemanticsJavaValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected XsemanticsTypeSystemGen xsemanticsSystem;
  
  protected XsemanticsTypeSystemGen getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
