package it.xsemantics.example.fjcached.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.fj.typing.validation.FjSepTypeSystemValidator;
import it.xsemantics.example.fjcached.typing.FjCachedTypeSystem;

/**
 * A version of the FJ system where type computation and
 * checking are separated.
 */
@SuppressWarnings("all")
public class FjCachedTypeSystemValidator extends FjSepTypeSystemValidator {
  @Inject
  protected FjCachedTypeSystem xsemanticsSystem;
  
  @Override
  protected FjCachedTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
