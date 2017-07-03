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

package it.xsemantics.example.maven.test.typesystem.validation;

import com.google.inject.Inject;
import it.xsemantics.example.maven.test.typesystem.MyExtendedTypeSystem;
import it.xsemantics.example.maven.test.typesystem.validation.MyModelTypeSystemValidator;

@SuppressWarnings("all")
public class MyExtendedTypeSystemValidator extends MyModelTypeSystemValidator {
  @Inject
  protected MyExtendedTypeSystem xsemanticsSystem;
  
  @Override
  protected MyExtendedTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
