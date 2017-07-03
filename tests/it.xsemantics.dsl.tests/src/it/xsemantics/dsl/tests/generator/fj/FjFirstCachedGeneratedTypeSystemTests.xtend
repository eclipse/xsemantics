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

package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests
import org.junit.Test
import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests.FjClassForTests
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting
import it.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting
import it.xsemantics.test.fj.caching.FjFirstCachedTypeSystem
import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem

class FjFirstCachedGeneratedTypeSystemTests extends
		FjAbstractGeneratedTypeSystemTests {
	
	static class FjFirstCachedStandaloneSetup extends FjCustomStandaloneSetupForTesting {
	
		override protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
			return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {
				@SuppressWarnings("unused")
				def java.lang.Class<? extends FjExpectedTraces> bindFjExpectedTraces() {
					return FjFirstCachedExpectedTraces;
				}
			}
		}
	
		static class FjFirstCachedTypeSystemWrapper extends
				FjFirstCachedTypeSystem implements IFjTypeSystem {
	
		}
	
		override protected Class<FjFirstCachedTypeSystemWrapper> fjTypeSystemClass() {
			return FjFirstCachedStandaloneSetup.FjFirstCachedTypeSystemWrapper;
		}
	}

	override fjCustomStandaloneSetupClass() {
		return FjFirstCachedStandaloneSetup;
	}

	@Test
	def void testSubclassesFailedCached() {
		val classes = new FjClassForTests(
				testFiles.testClassHierarchy());
		assertSubclasses(classes.A, classes.B, false, classes.trace,
				expectedTraces.failSubclasses(),
				"class A { } -- class B extends A { }");
		assertSubclasses(classes.A, classes.B, false, classes.trace,
				expectedTraces.failSubclasses(),
				"class A { } -- class B extends A { }");
	}
}
