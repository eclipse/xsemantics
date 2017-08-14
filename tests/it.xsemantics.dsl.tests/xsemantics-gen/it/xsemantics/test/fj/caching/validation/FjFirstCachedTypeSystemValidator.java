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
package it.xsemantics.test.fj.caching.validation;

import com.google.inject.Inject;
import it.xsemantics.test.fj.caching.FjFirstCachedTypeSystem;
import it.xsemantics.test.fj.first.validation.FjFirstTypeSystemValidator;

@SuppressWarnings("all")
public class FjFirstCachedTypeSystemValidator extends FjFirstTypeSystemValidator {
  @Inject
  protected FjFirstCachedTypeSystem xsemanticsSystem;
  
  @Override
  protected FjFirstCachedTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
