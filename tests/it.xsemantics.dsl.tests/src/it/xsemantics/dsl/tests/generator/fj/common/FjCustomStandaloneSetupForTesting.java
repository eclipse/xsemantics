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

package it.xsemantics.dsl.tests.generator.fj.common;

import it.xsemantics.example.fj.FJStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class FjCustomStandaloneSetupForTesting extends
		FJStandaloneSetup {

	private FjCustomRuntimeModuleForTesting fjCustomRuntimeModuleForTesting;

	public FjCustomStandaloneSetupForTesting() {
		fjCustomRuntimeModuleForTesting = createFjCustomRuntimeModule();
	}

	protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
		return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass());
	}

	abstract protected Class<? extends IFjTypeSystem> fjTypeSystemClass();

	@Override
	public Injector createInjector() {
		return Guice.createInjector(fjCustomRuntimeModuleForTesting);
	}

}