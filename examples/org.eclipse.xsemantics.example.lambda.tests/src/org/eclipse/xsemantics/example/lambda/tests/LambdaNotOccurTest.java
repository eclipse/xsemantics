/**
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 */
package org.eclipse.xsemantics.example.lambda.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.eclipse.xsemantics.example.lambda.lambda.ArrowType;
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
public class LambdaNotOccurTest extends LambdaAbstractBaseTest {
	@Test
	public void NotOccurConstantTypes() {
		assertResultTrue(
				system.notoccur(lambdaUtils.createStringType(), lambdaUtils.createIntType()));
	}

	@Test
	public void NotOccurDifferentTypeVariables() {
		assertResultTrue(system.notoccur(lambdaUtils.createFreshTypeVariable(),
				lambdaUtils.createFreshTypeVariable()));
	}

	@Test
	public void NotOccurTypeVariablesFails() {
		final TypeVariable variable = lambdaUtils.createFreshTypeVariable();
		TypeVariable typeVariable = lambdaUtils.createTypeVariable("X1");
		RuleFailedException thrown = assertThrows(RuleFailedException.class, () -> {
			system.notoccur(variable, typeVariable);
		});
		assertEquals("failed: X1 occurs in X1", thrown.getMessage());
	}

	@Test
	public void NotOccurTypeVariablesInArrowType() {
		assertResultTrue(system.notoccur(lambdaUtils.createFreshTypeVariable(),
				lambdaUtils.createFreshArrowType()));
	}

	@Test
	public void notOccurTypeVariablesInArrowTypeFails() {
		final TypeVariable variable = lambdaUtils.createTypeVariable("a");
		ArrowType arrowType = lambdaUtils.createArrowType(lambdaUtils.createFreshArrowType(),
				lambdaUtils.createArrowType(lambdaUtils.createFreshTypeVariable(),
						lambdaUtils.createTypeVariable("a")));
		RuleFailedException thrown = assertThrows(RuleFailedException.class, () -> {
			system.notoccur(trace, variable, arrowType);
		});
		assertEquals("failed: a occurs in ((X1 -> X2) -> (X3 -> a))", thrown.getMessage());
	}
}
