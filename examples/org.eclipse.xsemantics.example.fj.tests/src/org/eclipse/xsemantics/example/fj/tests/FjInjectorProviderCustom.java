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
package org.eclipse.xsemantics.example.fj.tests;

import org.eclipse.xsemantics.example.fj.FJRuntimeModule;
import org.eclipse.xsemantics.example.fj.FJStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Lorenzo Bettini
 * 
 */
public class FjInjectorProviderCustom extends FJInjectorProvider {
	@Override
	protected Injector internalCreateInjector() {
		return new FJStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new FJRuntimeModule() {
					@Override
					public java.lang.Class<? extends org.eclipse.xsemantics.runtime.StringRepresentation> bindStringRepresentation() {
						return FjStringRepresentationForTest.class;
					};
				});
			}
		}.createInjectorAndDoEMFRegistration();
	}
}
