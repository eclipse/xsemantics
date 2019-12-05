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

package org.eclipse.xsemantics.example.fjcached.tests

import com.google.inject.Inject
import org.eclipse.xsemantics.example.fj.fj.FjPackage
import org.eclipse.xsemantics.example.fj.typing.FjTypeSystem
import org.eclipse.xsemantics.example.fjcached.fjcached.FjCachedProgram
import org.eclipse.xsemantics.runtime.XsemanticsCache
import org.eclipse.xsemantics.runtime.caching.XsemanticsCacheResultLoggerListener
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FjcachedInjectorProvider))
class FjCachedTest {

	@Inject extension ParseHelper<FjCachedProgram>

	@Inject extension ValidationTestHelper

	@Inject XsemanticsCacheResultLoggerListener cacheListener

	@Inject XsemanticsCache cache

	@Before
	def void addCacheListener() {
		cacheListener.reset
		cache.addListener(cacheListener)
	}

	@After
	def void removeCacheListener() {
		cache.removeListener(cacheListener)
	}

	@Test
	def void testFjPair() {
		'''
			/*
			 * This is an example FJ program
			 */
			
			class MyObject { }
			
			class A extends MyObject { }
			class B extends MyObject { }
			
			class Pair extends MyObject {
			    MyObject fst;
			    MyObject snd;
			
			    Pair setfst(MyObject newfst) {
			        return new Pair(newfst, this.snd);
			    }
			
			    Pair setsnd(MyObject newscd) {
			        return new Pair(this.fst, newscd);
			    }
			}
			
			// the main expression
			new Pair(new A(), new B()).setfst(new B()).fst
		'''.parse.assertNoErrors
		assertResultsAreCached
	}

	@Test
	def void testValidationIsInherited() {
		'''
			class C {
				C m() { return 10; }
			}
		'''.parse.assertError(
			FjPackage.eINSTANCE.intConstant,
			FjTypeSystem.EXPRESSIONASSIGNABLETOTYPE,
			"failed: 10 is not assignable for C"
		)
	}

	def private assertResultsAreCached() {
		println("missed: " + cacheListener.missed)
		println("hits  : " + cacheListener.hits)
		assertFalse("cache missed is empty!", cacheListener.missed.empty)
		assertFalse("cache hits is empty!", cacheListener.hits.empty)
	}
}
