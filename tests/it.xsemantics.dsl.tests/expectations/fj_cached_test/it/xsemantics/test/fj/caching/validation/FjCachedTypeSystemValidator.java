package it.xsemantics.test.fj.caching.validation;

import com.google.inject.Inject;
import it.xsemantics.test.fj.caching.FjCachedTypeSystem;
import it.xsemantics.test.fj.first.validation.FjFirstTypeSystemValidator;

@SuppressWarnings("all")
public class FjCachedTypeSystemValidator extends FjFirstTypeSystemValidator {
  @Inject
  protected FjCachedTypeSystem xsemanticsSystem;
  
  @Override
  protected FjCachedTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
