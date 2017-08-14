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

package org.eclipse.xsemantics.dsl.tests.runtime

import com.google.inject.Inject
import org.eclipse.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.xsemantics.dsl.tests.EmfFactoryUtils
import org.eclipse.xsemantics.dsl.tests.XsemanticsBaseTest
import org.eclipse.xsemantics.dsl.tests.classes.TestableCache
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsCacheTests extends XsemanticsBaseTest {
	
	@Inject extension EmfFactoryUtils
	
	@Inject TestableCache cache

	@Test
	def void testEffectiveCaching() {
		val resource = createResourceSet.createResource[]
		val key1 = createEObject
		val key2 = createEObject
		resource.contents += key1
		resource.contents += key2
		
		val provider = [| new Object ]
		val o1 = cache.internalGet("test", provider, key1)
		val o2 = cache.internalGet("test", provider, key1)
		o1.assertSame(o2)
		
		val o3 = cache.internalGet("test", provider, key2)
		o1.assertNotSame(o3)
	}
}