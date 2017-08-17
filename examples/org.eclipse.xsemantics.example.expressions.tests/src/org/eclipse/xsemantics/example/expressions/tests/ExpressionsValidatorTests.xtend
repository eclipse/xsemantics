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

package org.eclipse.xsemantics.example.expressions.tests

import com.google.inject.Inject
import org.eclipse.xsemantics.example.expressions.expressions.ExpressionsPackage
import org.eclipse.xsemantics.example.expressions.expressions.Model
import org.eclipse.xsemantics.example.expressions.typing.ExpressionsSemantics
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExtendedExpressionsInjectorProviderCustom))
class ExpressionsValidatorTests extends ExpressionsBaseTests {

	@Inject extension ParseHelper<Model>
	
	@Inject extension ValidationTestHelper
	
	@Test
	def void testInt() {
		'''i = 10 - 5 - 1'''.parse.assertNoErrors
	}
	
	@Test
	def void testArithmeticSignedWithString() {
		'''i = -('zzz')'''.parse.
			assertError(
				ExpressionsPackage::eINSTANCE.arithmeticSigned,
				ExpressionsSemantics::ARITHMETICSIGNED
			)
	}
}