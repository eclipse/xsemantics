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

package org.eclipse.xsemantics.example.expressions.tests;

import org.eclipse.xsemantics.example.expressions.ExpressionsInjectorProvider;
import org.eclipse.xsemantics.example.expressions.ExpressionsRuntimeModule;
import org.eclipse.xsemantics.example.expressions.ExpressionsStandaloneSetup;
import org.eclipse.xsemantics.example.expressions.typing.ExpressionsSemantics;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ExpressionsInjectorProviderFirst extends
		ExpressionsInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		return new ExpressionsStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ExpressionsRuntimeModule() {
					@Override
					public Class<? extends ExpressionsSemantics> bindExpressionsSemantics() {
						return ExpressionsSemantics.class;
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
}
