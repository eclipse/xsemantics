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
package it.xsemantics.test.ecore.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import it.xsemantics.test.ecore.TypeSystem;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

@SuppressWarnings("all")
public class TypeSystemValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected TypeSystem xsemanticsSystem;
  
  protected TypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
