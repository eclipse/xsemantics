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
import org.eclipse.xsemantics.example.expressions.typing.CachedExpressionsSemantics;
import org.eclipse.xsemantics.example.expressions.typing.validation.ExtendedExpressionsSemanticsValidator;

/**
 * This system caches typing for variables, which involves
 * expensive type inference
 */
@SuppressWarnings("all")
public class CachedExpressionsSemanticsValidator extends ExtendedExpressionsSemanticsValidator {
  @Inject
  protected CachedExpressionsSemantics xsemanticsSystem;
  
  @Override
  protected CachedExpressionsSemantics getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
