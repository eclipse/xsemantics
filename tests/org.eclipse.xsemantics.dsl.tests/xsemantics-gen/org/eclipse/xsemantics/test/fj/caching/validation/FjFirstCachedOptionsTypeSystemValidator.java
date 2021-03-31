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
package org.eclipse.xsemantics.test.fj.caching.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.test.fj.caching.FjFirstCachedOptionsTypeSystem;

@SuppressWarnings("all")
public class FjFirstCachedOptionsTypeSystemValidator extends FjFirstCachedTypeSystemValidator {
  @Inject
  protected FjFirstCachedOptionsTypeSystem xsemanticsSystem;
  
  @Override
  protected FjFirstCachedOptionsTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
