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
package org.eclipse.xsemantics.dsl.tests.generator.fj;

import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import org.eclipse.xsemantics.example.fj.tests.FJInjectorProvider;
import org.eclipse.xsemantics.test.fj.caching.FjFirstCachedTypeSystem;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Injector;

@InjectWith(FjFirstCachedGeneratedTypeSystemTests.FjFirstCachedGeneratedTypeSystemInjectorProvider.class)
@RunWith(XtextRunner.class)
public class FjFirstCachedGeneratedTypeSystemTests extends FjAbstractGeneratedTypeSystemTests {

	public static class FjFirstCachedGeneratedTypeSystemInjectorProvider extends FJInjectorProvider {
		public static class FjFirstCachedTypeSystemWrapper extends FjFirstCachedTypeSystem implements IFjTypeSystem {
		}

		@Override
		protected Injector internalCreateInjector() {
			return new FjCustomStandaloneSetupForTesting() {
				@Override
				protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
					return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {
						@SuppressWarnings("unused")
						public Class<? extends FjExpectedTraces> bindFjExpectedTraces() {
							return FjFirstCachedExpectedTraces.class;
						}
					};
				}

				@Override
				protected Class<FjFirstCachedTypeSystemWrapper> fjTypeSystemClass() {
					return FjFirstCachedTypeSystemWrapper.class;
				}
			}.createInjectorAndDoEMFRegistration();
		}
	}

	@Test
	public void testSubclassesFailedCached() throws Exception {
		final FjAbstractGeneratedTypeSystemTests.FjClassForTests classes = new FjAbstractGeneratedTypeSystemTests.FjClassForTests(
				testFiles.testClassHierarchy());
		assertSubclasses(classes.A, classes.B, false, classes.trace, expectedTraces.failSubclasses(),
				"class A { } -- class B extends A { }");
		assertSubclasses(classes.A, classes.B, false, classes.trace, expectedTraces.failSubclasses(),
				"class A { } -- class B extends A { }");
	}
}
