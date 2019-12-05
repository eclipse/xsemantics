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

import org.eclipse.xsemantics.example.lambda.lambda.Type;
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable;
import org.eclipse.xsemantics.example.lambda.xsemantics.TypeSubstitutions;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author bettini
 *
 */
public class TypeSubstitutionsTest extends LambdaAbstractBaseTest {

	TypeSubstitutions substitutions;

	@Override
	@Before
	public void setUp() {
		lambdaUtils.resetCounter();
		substitutions = new TypeSubstitutions();
	}

	@Test
	public void testWithMappedVar() {
		TypeVariable typeVariable = lambdaUtils.createFreshTypeVariable();
		addSubst(typeVariable, lambdaUtils.createFreshTypeVariable());
		Type mapped = mapped(typeVariable);
		Assert.assertTrue(mapped != null);
		assertTypeVariable(mapped, "X2");
	}

	@Test
	public void testReset() {
		TypeVariable typeVariable = lambdaUtils.createFreshTypeVariable();
		addSubst(typeVariable, lambdaUtils.createFreshTypeVariable());
		substitutions.reset();
		Type mapped = mapped(typeVariable);
		Assert.assertTrue(mapped == null);
	}

	protected void addSubst(TypeVariable typeVariable, Type type) {
		substitutions.add(typeVariable.getTypevarName(), type);
	}

	protected Type mapped(TypeVariable typeVariable) {
		return substitutions.mapped(typeVariable.getTypevarName());
	}
}
