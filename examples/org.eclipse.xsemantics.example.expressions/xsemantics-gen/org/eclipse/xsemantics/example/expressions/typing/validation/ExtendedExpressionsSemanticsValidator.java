/**
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 */
package org.eclipse.xsemantics.example.expressions.typing.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.example.expressions.typing.ExtendedExpressionsSemantics;
import org.eclipse.xsemantics.example.expressions.typing.validation.ExpressionsSemanticsValidator;

/**
 * This system is more involved:
 * we want to implicitly convert string literals to numbers
 * and to booleans when this is possible
 */
@SuppressWarnings("all")
public class ExtendedExpressionsSemanticsValidator extends ExpressionsSemanticsValidator {
  @Inject
  protected ExtendedExpressionsSemantics xsemanticsSystem;
  
  @Override
  protected ExtendedExpressionsSemantics getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
