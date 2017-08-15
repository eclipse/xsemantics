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

package org.eclipse.xsemantics.dsl.typing.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.dsl.typing.XsemanticsTypeSystemGen;
import org.eclipse.xsemantics.dsl.validation.AbstractXsemanticsValidator;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;

@SuppressWarnings("all")
public class XsemanticsTypeSystemGenValidator extends AbstractXsemanticsValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected XsemanticsTypeSystemGen xsemanticsSystem;
  
  protected XsemanticsTypeSystemGen getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
