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

package org.eclipse.xsemantics.example.lambda.tests

import com.google.inject.Inject
import org.eclipse.xsemantics.example.lambda.xsemantics.TypeSubstitutions
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaTypeSubstitutionTest extends LambdaBaseTest {
	
	@Inject TypeSubstitutions substitutions

	@Before
	def void resetSubstitutions() {
		setUp
		substitutions.reset
	}
	
	@Test
	def void testTypeVariableSubstitution() {
		assertResultAsString(
			system.typesubstitution(substitutions, lambdaUtils.createFreshTypeVariable),
			"X1"
		)
	}
	
	@Test
	def void testTypeVariableSubstitutionRecursive() {
		val firstVariable = lambdaUtils.createFreshTypeVariable
		val secondVariable = lambdaUtils.createFreshTypeVariable
		val thirdVariable = lambdaUtils.createFreshTypeVariable
		substitutions.add(firstVariable.typevarName, secondVariable)
		substitutions.add(secondVariable.typevarName, thirdVariable)
		assertResultAsString(
			system.typesubstitution(substitutions, firstVariable),
			"X3"
		)
	}
	
	@Test
	def void testArrowTypeSubstitutionRecursive() {
		val firstVariable = lambdaUtils.createFreshTypeVariable
		val secondVariable = lambdaUtils.createFreshTypeVariable
		val thirdVariable = lambdaUtils.createFreshTypeVariable
		val arrowType = lambdaUtils.createArrowType(firstVariable, secondVariable)
		substitutions.add(firstVariable.typevarName, secondVariable)
		substitutions.add(secondVariable.typevarName, thirdVariable)
		assertResultAsString(
			system.typesubstitution(substitutions, arrowType),
			"(X3 -> X3)"
		)
	}
}