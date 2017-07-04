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

package it.xsemantics.example.expressions.tests;

import it.xsemantics.example.expressions.ExpressionsInjectorProvider;
import it.xsemantics.example.expressions.ExpressionsRuntimeModule;
import it.xsemantics.example.expressions.ExpressionsStandaloneSetup;
import it.xsemantics.example.expressions.typing.ExpressionsSemantics;
import it.xsemantics.example.expressions.typing.ExtendedExpressionsSemantics;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ExtendedExpressionsInjectorProviderCustom extends
		ExpressionsInjectorProvider {

	@Override
	protected Injector internalCreateInjector() {
		return new ExpressionsStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ExpressionsRuntimeModule() {
					@Override
					public Class<? extends ExpressionsSemantics> bindExpressionsSemantics() {
						return ExtendedExpressionsSemantics.class;
					}
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
}
