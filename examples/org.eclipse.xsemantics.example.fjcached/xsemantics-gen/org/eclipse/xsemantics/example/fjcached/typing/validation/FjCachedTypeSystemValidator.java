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
package org.eclipse.xsemantics.example.fjcached.typing.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.example.fj.typing.validation.FjTypeSystemValidator;
import org.eclipse.xsemantics.example.fjcached.typing.FjCachedTypeSystem;

/**
 * A version of the FJ system where caching is used.
 */
@SuppressWarnings("all")
public class FjCachedTypeSystemValidator extends FjTypeSystemValidator {
  @Inject
  protected FjCachedTypeSystem xsemanticsSystem;
  
  @Override
  protected FjCachedTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
