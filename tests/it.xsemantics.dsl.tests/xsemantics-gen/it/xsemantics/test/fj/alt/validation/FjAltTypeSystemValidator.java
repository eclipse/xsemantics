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
package it.xsemantics.test.fj.alt.validation;

import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.test.fj.alt.FjAltTypeSystem;
import it.xsemantics.test.fj.first.validation.FjFirstTypeSystemValidator;
import org.eclipse.xtext.validation.Check;

/**
 * alternative type system for FJ using external auxiliary functions
 */
@SuppressWarnings("all")
public class FjAltTypeSystemValidator extends FjFirstTypeSystemValidator {
  @Inject
  protected FjAltTypeSystem xsemanticsSystem;
  
  @Override
  protected FjAltTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Override
  @Check
  public void checkMain(final Program program) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMain(program),
    		program);
  }
  
  @Override
  @Check
  public void checkClassOk(final it.xsemantics.example.fj.fj.Class clazz) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkClassOk(clazz),
    		clazz);
  }
}
