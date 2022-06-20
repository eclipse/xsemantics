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
package org.eclipse.xsemantics.test.fj.first.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.example.fj.fj.Program;
import org.eclipse.xsemantics.example.fj.validation.AbstractFJValidator;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xsemantics.test.fj.first.FjFirstTypeSystem;
import org.eclipse.xtext.validation.Check;

@SuppressWarnings("all")
public class FjFirstTypeSystemValidator extends AbstractFJValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;

  @Inject
  protected FjFirstTypeSystem xsemanticsSystem;

  protected FjFirstTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }

  @Check
  public void checkMain(final Program program) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMain(program),
    		program);
  }

  @Check
  public void checkClassOk(final org.eclipse.xsemantics.example.fj.fj.Class clazz) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkClassOk(clazz),
    		clazz);
  }

  @Check
  public void checkMethodBody(final Method method) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMethodBody(method),
    		method);
  }

  @Check
  public void checkField(final Field field) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkField(field),
    		field);
  }

  @Check
  public void checkMethodOverride(final Method method) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMethodOverride(method),
    		method);
  }

  @Check
  public void checkClassHierachyNotCyclic(final org.eclipse.xsemantics.example.fj.fj.Class cl) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkClassHierachyNotCyclic(cl),
    		cl);
  }
}
