package it.xsemantics.test.fj.lambda.validation;

import com.google.inject.Inject;
import it.xsemantics.test.fj.first.validation.FjFirstTypeSystemValidator;
import it.xsemantics.test.fj.lambda.FjTestsForLambdas;

@SuppressWarnings("all")
public class FjTestsForLambdasValidator extends FjFirstTypeSystemValidator {
  @Inject
  protected FjTestsForLambdas xsemanticsSystem;
  
  @Override
  protected FjTestsForLambdas getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
