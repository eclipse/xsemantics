package it.xsemantics.example.maven.test.typesystem.validation;

import com.google.inject.Inject;
import it.xsemantics.example.maven.test.typesystem.MyExtendedTypeSystem;
import it.xsemantics.example.maven.test.typesystem.validation.MyModelTypeSystemValidator;

@SuppressWarnings("all")
public class MyExtendedTypeSystemValidator extends MyModelTypeSystemValidator {
  @Inject
  protected MyExtendedTypeSystem xsemanticsSystem;
  
  @Override
  protected MyExtendedTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
