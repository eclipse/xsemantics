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

package org.eclipse.xsemantics.example.fj.tests

import com.google.inject.Inject
import org.eclipse.xsemantics.example.fj.fj.Program
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJInjectorProvider))
class FjValidatorTest {

	@Inject extension ParseHelper<Program>

	@Inject extension ValidationTestHelper

	@Test
	def void testUnresolvedReferenceInMain() {
		'''
			class A { }
			
			new A().f
		'''.parse.validate => [

			// this is the only error that we should get
			// the rest of the type system does not detect other errors
			'''Couldn't resolve reference to Member 'f'.'''
				.toString
				.assertEquals(map[message].join("\n"))

		]

	}

}
