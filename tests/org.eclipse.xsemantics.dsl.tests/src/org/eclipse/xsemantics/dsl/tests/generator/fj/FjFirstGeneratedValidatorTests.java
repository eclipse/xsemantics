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

package org.eclipse.xsemantics.dsl.tests.generator.fj;

import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedValidatorTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import org.eclipse.xsemantics.example.fj.tests.FJInjectorProvider;
import org.eclipse.xsemantics.test.fj.first.FjFirstTypeSystem;
import org.eclipse.xsemantics.test.fj.first.validation.FjFirstTypeSystemValidator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.junit.runner.RunWith;

import com.google.inject.Injector;

@InjectWith(FjFirstGeneratedValidatorTests.FjFirstGeneratedTypeSystemInjectorProvider.class)
@RunWith(XtextRunner.class)
public class FjFirstGeneratedValidatorTests extends
		FjAbstractGeneratedValidatorTests {

	public static class FjFirstGeneratedTypeSystemInjectorProvider extends FJInjectorProvider {
		public static class FjFirstTypeSystemWrapper extends FjFirstTypeSystem
				implements IFjTypeSystem {
		}

		@Override
		protected Injector internalCreateInjector() {
			return new FjCustomStandaloneSetupForTesting() {
				@Override
				protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
					return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {
						@Override
						public Class<? extends AbstractDeclarativeValidator> bindAbstractDeclarativeValidator() {
							return FjFirstTypeSystemValidator.class;
						}
					};
				}

				@Override
				protected Class<FjFirstTypeSystemWrapper> fjTypeSystemClass() {
					return FjFirstTypeSystemWrapper.class;
				}
			}.createInjectorAndDoEMFRegistration();
		}
	}

}
