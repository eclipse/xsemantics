/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package it.xsemantics.example.expressions.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.expressions.Variable;
import it.xsemantics.example.expressions.typing.ExpressionsSemantics;
import it.xsemantics.example.expressions.validation.AbstractExpressionsJavaValidator;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.Check;

/**
 * This system allows to convert implicitly
 * integers and booleans to strings, and '+' can
 * be used also for string concatenations
 */
@SuppressWarnings("all")
public class ExpressionsSemanticsValidator extends AbstractExpressionsJavaValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected ExpressionsSemantics xsemanticsSystem;
  
  protected ExpressionsSemantics getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Check
  public void checkVariable(final Variable variable) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkVariable(variable),
    		variable);
  }
}
