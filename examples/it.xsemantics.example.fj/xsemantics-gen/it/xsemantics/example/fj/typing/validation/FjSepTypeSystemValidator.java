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

package it.xsemantics.example.fj.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.typing.FjSepTypeSystem;
import it.xsemantics.example.fj.typing.validation.FjTypeSystemValidator;
import org.eclipse.xtext.validation.Check;

/**
 * A version of the FJ system where type computation and
 * checking are separated.
 */
@SuppressWarnings("all")
public class FjSepTypeSystemValidator extends FjTypeSystemValidator {
  @Inject
  protected FjSepTypeSystem xsemanticsSystem;
  
  @Override
  protected FjSepTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Check
  public void checkClassOk(final it.xsemantics.example.fj.fj.Class clazz) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkClassOk(clazz),
    		clazz);
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
  public void checkMethodBody(final Method method) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMethodBody(method),
    		method);
  }
  
  @Override
  @Check
  public void checkField(final Field field) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkField(field),
    		field);
  }
  
  @Override
  @Check
  public void checkMethodOverride(final Method method) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMethodOverride(method),
    		method);
  }
}
