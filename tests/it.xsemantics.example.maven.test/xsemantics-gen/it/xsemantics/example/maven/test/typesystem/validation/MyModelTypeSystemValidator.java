package it.xsemantics.example.maven.test.typesystem.validation;

import com.google.inject.Inject;
import it.xsemantics.example.maven.test.typesystem.MyModelTypeSystem;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

@SuppressWarnings("all")
public class MyModelTypeSystemValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected MyModelTypeSystem xsemanticsSystem;
  
  protected MyModelTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
