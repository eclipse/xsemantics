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
import it.xsemantics.test.fj.caching.FjFirstCachedTypeSystem
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(FJInjectorProvider))
@RunWith(typeof(XtextRunner))
class FjFirstTypeSystemCachedTest extends FjFirstTypeSystemManualCachedTest {
	
	@Inject Provider<FjFirstCachedTypeSystem> cachedTypeSystemProvider
	
	@Inject extension ParseHelper<Program>
	
	override createCachedTypeSystem() {
		cachedTypeSystemProvider.get()
	}
	
	@Test
	override void testCachedSuperclassesUsedInTypecheck() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertSuperclassesCachedInTypecheck("C",
'''
CheckClass: [] |- class C extends B {}
 superclasses(class C extends B {}) = [class B extends A {}, class A {}]
 Fields: [] ||- class B extends A {} >> []
  superclasses(class B extends A {}) = [class A {}]
 Methods: [] ||~ class B extends A {} >> []
'''
			)
		
			// we reuse the superclasses computation
			// implicitly also when computing fields
			assertSuperclassesCachedInTypecheck("C",
'''
CheckClass: [] |- class C extends B {}
 cached:
  superclasses(class C extends B {}) = [class B extends A {}, class A {}]
 cached:
  Fields: [] ||- class B extends A {} >> []
 cached:
  Methods: [] ||~ class B extends A {} >> []
'''
			)
		]
	}

	@Test
	override void testXsemanticsCacheListener() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertCacheStatisticsInTypecheck(traceLogger,"C",
'''
''',
'''
superclasses(class C extends B {}) = [class B extends A {}, class A {}]
superclasses(class B extends A {}) = [class A {}]
Fields: [] ||- class B extends A {} >> []
Methods: [] ||~ class B extends A {} >> []
'''
			)
			
			// the second time, superclasses(class B extends A {}) = [class A {}]
			// is not used at all
			assertCacheStatisticsInTypecheck(traceLogger,"C",
'''
superclasses(class C extends B {}) = [class B extends A {}, class A {}]
Fields: [] ||- class B extends A {} >> []
Methods: [] ||~ class B extends A {} >> []
''',
'''
superclasses(class C extends B {}) = [class B extends A {}, class A {}]
superclasses(class B extends A {}) = [class A {}]
Fields: [] ||- class B extends A {} >> []
Methods: [] ||~ class B extends A {} >> []
'''
			)
		]
		cachedTypeSystem.cache.removeListener(traceLogger)
	}

	@Test
	def void testFailureCached() {
		'''
		class A {}
		class B extends A {}
		class C extends B {}
		class D extends A {}
		'''
		.parse => [
			assertSubclassCachedResult("D", "C", "")

			// also failures are cached because entry point methods are cached
			assertSubclassCachedResult("D", "C", "subclass: Result failed")
		]
	}

	@Test
	def void testSubtypingCached() {
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
			// subtyping is not cached
			assertSubtypingCachedResult(StringType, IntType, "")
			assertSubtypingCachedResult(StringType, IntType, "")
			assertSubtypingCachedResult(StringType, StringType, "")
			assertSubtypingCachedResult(StringType, StringType, "")
			// subtyping is not cached, but subclass is
			assertSubtypingCachedResult(AType, AType, "")
			assertSubtypingCachedResult(BType, AType, "subclassInternal: Result true")
			assertSubtypingCachedResult(AType, AType, "subclassInternal: Result true; subclassInternal: Result true")
			assertSubtypingCachedResult(BType, AType, "subclassInternal: Result true; subclassInternal: Result true; subclassInternal: Result true")
		]
	}
}