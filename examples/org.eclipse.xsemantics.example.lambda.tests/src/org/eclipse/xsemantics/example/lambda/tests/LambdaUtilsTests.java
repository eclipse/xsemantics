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

/**
 * 
 */
package org.eclipse.xsemantics.example.lambda.tests;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import org.eclipse.xsemantics.example.lambda.lambda.ArrowType;
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable;
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaUtils;
import org.eclipse.xsemantics.runtime.StringRepresentation;

/**
 * @author bettini
 *
 */
@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
public class LambdaUtilsTests {

	@Inject StringRepresentation stringRep;
	
	@Inject LambdaUtils lambdaUtils;
	
	@Before
	public void setUp() {
		lambdaUtils.resetCounter();
	}
	
	@Test
	public void testFreshVars() {
		assertTypeVarName("X1", lambdaUtils.createFreshTypeVariable());
		assertTypeVarName("X2", lambdaUtils.createFreshTypeVariable());
	}
	
	@Test
	public void testFreshVarsAfterReset() {
		assertTypeVarName("X1", lambdaUtils.createFreshTypeVariable());
		lambdaUtils.resetCounter();
		assertTypeVarName("X1", lambdaUtils.createFreshTypeVariable());
	}
	
	@Test
	public void testFreshArrowType() {
		assertArrowType("(X1 -> X2)", lambdaUtils.createFreshArrowType());
	}
	
	protected void assertTypeVarName(String expected, TypeVariable typeVariable) {
		Assert.assertEquals(expected, typeVariable.getTypevarName());
	}
	
	protected void assertArrowType(String expected, ArrowType arrowType) {
		Assert.assertEquals(expected, stringRep.string(arrowType));
	}
}
