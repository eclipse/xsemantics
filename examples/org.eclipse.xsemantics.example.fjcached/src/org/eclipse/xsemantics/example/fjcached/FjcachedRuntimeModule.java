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
package org.eclipse.xsemantics.example.fjcached;

import org.eclipse.xsemantics.example.fj.typing.FjTypeSystem;
import org.eclipse.xsemantics.example.fjcached.typing.FjCachedTypeSystem;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class FjcachedRuntimeModule extends AbstractFjcachedRuntimeModule {

	public Class<? extends FjTypeSystem> bindFjTypeSystem() {
		return FjCachedTypeSystem.class;
	}
}
