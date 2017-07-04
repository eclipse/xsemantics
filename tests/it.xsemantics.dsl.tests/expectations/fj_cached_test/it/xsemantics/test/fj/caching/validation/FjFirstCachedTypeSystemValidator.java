package it.xsemantics.test.fj.caching.validation;

import com.google.inject.Inject;
import it.xsemantics.test.fj.caching.FjFirstCachedTypeSystem;
import it.xsemantics.test.fj.first.validation.FjFirstTypeSystemValidator;

@SuppressWarnings("all")
public class FjFirstCachedTypeSystemValidator extends FjFirstTypeSystemValidator {
  @Inject
  protected FjFirstCachedTypeSystem xsemanticsSystem;
  
  @Override
  protected FjFirstCachedTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
