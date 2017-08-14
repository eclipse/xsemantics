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

package org.eclipse.xsemantics.dsl.tests.generator

import org.eclipse.xsemantics.dsl.generator.UniqueNames
import static org.junit.Assert.*
import org.junit.Test

class UniqueNamesTest {
	
	static class TestUniqueNames extends UniqueNames {
		new () {
			max = 2
		}
	}

	@Test
	def void testUnique() {
		val UniqueNames names = new UniqueNames()
		assertEquals("first", names.createName("first"));
		assertEquals("first_1", names.createName("first"));
		assertEquals("first_2", names.createName("first"));
	}

	@Test
	def void testUniqueMax() {
		val UniqueNames names = new TestUniqueNames() 
		assertEquals("first", names.createName("first"));
		assertEquals("first_1", names.createName("first"));
		// the max has been reached
		assertEquals("first", names.createName("first"));
	}
	
}