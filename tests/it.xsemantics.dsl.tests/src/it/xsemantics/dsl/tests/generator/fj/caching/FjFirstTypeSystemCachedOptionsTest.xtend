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

package it.xsemantics.dsl.tests.generator.fj.caching

import com.google.inject.Inject
import com.google.inject.Provider
import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.example.fj.fj.Program
import it.xsemantics.test.fj.caching.FjFirstCachedOptionsTypeSystem
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(FJInjectorProvider))
@RunWith(typeof(XtextRunner))
class FjFirstTypeSystemCachedOptionsTest extends FjFirstTypeSystemCachedTest {
	
	@Inject Provider<FjFirstCachedOptionsTypeSystem> cachedTypeSystemProvider
	
	@Inject extension ParseHelper<Program>

	override createCachedTypeSystem() {
		cachedTypeSystemProvider.get()
	}

	@Test
	override void testFailureCached() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertSubclassCachedResult("D", "C", "")

			// failures are not cached because entry point methods are not cached
			assertSubclassCachedResult("D", "C", "")
		]
	}

	@Test
	override void testSubtypingCached() {
		'''
		class A {
			String s1;
			int i1;
			A a1;
			B b1;
		}
		class B extends A {}
		'''
		.parse => [
			val A = classes.head
			val StringType = A.members.get(0).type
			val IntType = A.members.get(1).type
			val AType = A.members.get(2).type
			val BType = A.members.get(3).type
			// subtyping is cached on basic types
			assertSubtypingCachedResult(StringType, IntType, "")
			assertSubtypingCachedResult(StringType, IntType, "subtype: Result failed")
			assertSubtypingCachedResult(StringType, StringType, "subtype: Result failed")
			assertSubtypingCachedResult(StringType, StringType, "subtype: Result failed; subtype: Result true")
			// subtyping is not cached on class types, but subclass is
			assertSubtypingCachedResult(AType, AType, "subtype: Result failed; subtype: Result true")
			assertSubtypingCachedResult(BType, AType, "subtype: Result failed; subtype: Result true; subclassInternal: Result true")
			assertSubtypingCachedResult(AType, AType, "subtype: Result failed; subtype: Result true; subclassInternal: Result true; subclassInternal: Result true")
			assertSubtypingCachedResult(BType, AType, "subtype: Result failed; subtype: Result true; subclassInternal: Result true; subclassInternal: Result true; subclassInternal: Result true")
		]
	}
}