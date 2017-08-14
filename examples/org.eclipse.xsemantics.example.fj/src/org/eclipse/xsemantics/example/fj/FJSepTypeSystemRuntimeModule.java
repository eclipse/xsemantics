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

/**
 * 
 */
package org.eclipse.xsemantics.example.fj;

import org.eclipse.xsemantics.example.fj.typing.FjSepTypeSystem;
import org.eclipse.xsemantics.example.fj.typing.FjTypeSystem;

/**
 * Uses the alternate version (type inference and type check) of
 * the {@link FjTypeSystem}
 * 
 * @author Lorenzo Bettini
 *
 */
public class FJSepTypeSystemRuntimeModule extends FJRuntimeModule {
	public Class<? extends FjTypeSystem> bindFjTypeSystem() {
		return FjSepTypeSystem.class;
	}
}
