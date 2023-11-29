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

import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import org.eclipse.xsemantics.example.fj.tests.FJInjectorProvider;
import org.eclipse.xsemantics.test.fj.first.FjFirstTypeSystem;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.runner.RunWith;

import com.google.inject.Injector;

@InjectWith(FjFirstGeneratedTypeSystemTests.FjFirstGeneratedTypeSystemInjectorProvider.class)
@RunWith(XtextRunner.class)
public class FjFirstGeneratedTypeSystemTests extends
		FjAbstractGeneratedTypeSystemTests {

	public static class FjFirstGeneratedTypeSystemInjectorProvider extends FJInjectorProvider {
		public static class FjFirstTypeSystemWrapper extends FjFirstTypeSystem
				implements IFjTypeSystem {
		}

		@Override
		protected Injector internalCreateInjector() {
			return new FjCustomStandaloneSetupForTesting() {
				@Override
				protected Class<FjFirstTypeSystemWrapper> fjTypeSystemClass() {
					return FjFirstTypeSystemWrapper.class;
				}
			}.createInjectorAndDoEMFRegistration();
		}
	}

}
