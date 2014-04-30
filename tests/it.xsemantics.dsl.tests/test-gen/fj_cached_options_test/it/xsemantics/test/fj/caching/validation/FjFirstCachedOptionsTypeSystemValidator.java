package it.xsemantics.test.fj.caching.validation;

import com.google.inject.Inject;
import it.xsemantics.test.fj.caching.FjFirstCachedOptionsTypeSystem;
import it.xsemantics.test.fj.caching.validation.FjFirstCachedTypeSystemValidator;

@SuppressWarnings("all")
public class FjFirstCachedOptionsTypeSystemValidator extends FjFirstCachedTypeSystemValidator {
  @Inject
  protected FjFirstCachedOptionsTypeSystem xsemanticsSystem;
  
  @Override
  protected FjFirstCachedOptionsTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
