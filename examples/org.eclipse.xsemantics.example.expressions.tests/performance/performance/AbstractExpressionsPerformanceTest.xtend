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

package org.eclipse.xsemantics.example.expressions.performance

import com.google.inject.Inject
import org.eclipse.xsemantics.example.expressions.expressions.Model
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper

abstract class AbstractExpressionsPerformanceTest {
	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper

	def protected testPerformance(int n) {
		/*
		 * i_0 = 0
		 * i_1 = i_0
		 * i_2 = i_0 + i_1
		 * i_3 = i_0 + i_1 + i_2
		 * etc..
		 */
		'''
			i_0 = 0
			i_1 = i_0
			«FOR i : 2..n»
				i_«i» = i_0«FOR j : 1..i-1» + i_«j»«ENDFOR»
			«ENDFOR»
		'''.parse.assertNoErrors
	}

}