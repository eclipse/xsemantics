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
package org.eclipse.xsemantics.example.fj.ui;

import org.eclipse.xsemantics.example.fj.ui.internal.FjActivator;

import com.google.inject.Injector;

/**
 * Activates FJ editors with different type system implementations.
 * 
 * @author Lorenzo Bettini
 */
public class FJSepExecutableExtensionFactory extends FJExecutableExtensionFactory {
	@Override
	protected Injector getInjector() {
		return FjActivator.getInstance()
				.getInjector(FJActivatorCustom.ORG_ECLIPSE_XSEMANTICS_EXAMPLE_FJ_SEP_TYPESYSTEM);
	}
}
