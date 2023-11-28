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
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;

import org.eclipse.xsemantics.example.lambda.lambda.ArrowType;
import org.eclipse.xsemantics.example.lambda.lambda.IntType;
import org.eclipse.xsemantics.example.lambda.lambda.StringType;
import org.eclipse.xsemantics.example.lambda.lambda.Type;
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
public class LambdaUnifyTest extends LambdaAbstractBaseTest {
	@Test
	public void testUnifyTypeVar() {
		assertUnify(lambdaUtils.createFreshTypeVariable(), lambdaUtils.createFreshTypeVariable(), "X3",
				"X1=X3, X2=X3");
	}

	@Test
	public void testUnifyStringType() {
		assertUnify(lambdaUtils.createStringType(), lambdaUtils.createStringType(), "String", "");
	}

	@Test
	public void testUnifyIntType() {
		assertUnify(lambdaUtils.createIntType(), lambdaUtils.createIntType(), "int", "");
	}

	@Test
	public void testBasicTypeFails() {
		StringType stringType = lambdaUtils.createStringType();
		IntType intType = lambdaUtils.createIntType();
		RuleFailedException thrown = assertThrows(RuleFailedException.class, () -> {
			system.unify(substitutions, stringType, intType);
		});
		assertEquals("failed: cannot unify String with int", thrown.getMessage());
	}

	@Test
	public void testUnifyTypeVarBasicType() {
		assertUnify(lambdaUtils.createFreshTypeVariable(), lambdaUtils.createStringType(), "String",
				"X1=String");
	}

	@Test
	public void testUnifyBasicTypeTypeVar() {
		assertUnify(lambdaUtils.createIntType(), lambdaUtils.createFreshTypeVariable(), "int", "X1=int");
	}

	@Test
	public void testUnifyTypeVarArrowType() {
		assertUnify(lambdaUtils.createFreshTypeVariable(), lambdaUtils.createFreshArrowType(),
				"(X2 -> X3)", "X1=(X2 -> X3)");
	}

	@Test
	public void testUnifyArrowTypeTypeVar() {
		assertUnify(lambdaUtils.createFreshArrowType(), lambdaUtils.createFreshTypeVariable(),
				"(X1 -> X2)", "X3=(X1 -> X2)");
	}

	@Test
	public void testUnifyArrowTypes() {
		assertUnify(lambdaUtils.createFreshArrowType(), lambdaUtils.createFreshArrowType(), "(X5 -> X6)",
				"X1=X5, X2=X6, X3=X5, X4=X6");
	}

	@Test
	public void testUnifyArrowTypes2() {
		assertUnify(lambdaUtils.createFreshArrowType(),
				lambdaUtils.createArrowType(lambdaUtils.createFreshArrowType(),
						lambdaUtils.createFreshArrowType()),
				"((X3 -> X4) -> (X5 -> X6))", "X1=(X3 -> X4), X2=(X5 -> X6)");
	}

	@Test
	public void testUnifyArrowTypesWithBasicTypes() {
		assertUnify(lambdaUtils.createFreshArrowType(),
				lambdaUtils.createArrowType(lambdaUtils.createArrowType(lambdaUtils.createIntType(),
						lambdaUtils.createStringType()), lambdaUtils.createFreshArrowType()),
				"((int -> String) -> (X3 -> X4))", "X1=(int -> String), X2=(X3 -> X4)");
	}

	@Test
	public void testUnifyArrowTypesWithBasicTypes2() {
		assertUnify(
				lambdaUtils.createArrowType(lambdaUtils.createFreshArrowType(),
						lambdaUtils.createArrowType(lambdaUtils.createStringType(),
								lambdaUtils.createIntType())),
				lambdaUtils.createArrowType(lambdaUtils.createArrowType(lambdaUtils.createIntType(),
						lambdaUtils.createStringType()), lambdaUtils.createFreshArrowType()),
				"((int -> String) -> (String -> int))", "X1=int, X2=String, X3=String, X4=int");
	}

	@Test
	public void unifyTypeVariableOccursInArrowTypeFails() {
		final TypeVariable variable = lambdaUtils.createTypeVariable("a");
		ArrowType arrowType = lambdaUtils.createArrowType(lambdaUtils.createFreshArrowType(),
				lambdaUtils.createArrowType(lambdaUtils.createFreshTypeVariable(),
						lambdaUtils.createTypeVariable("a")));
		RuleFailedException thrown = assertThrows(RuleFailedException.class, () -> {
			system.unify(substitutions, variable,
					arrowType);
		});
		assertEquals("failed: cannot unify a with ((X1 -> X2) -> (X3 -> a))", thrown.getMessage());
	}

	public void assertUnify(final Type left, final Type right, final String expectedResult,
			final String expectedSubsts) {
		// make sure we use the same instance of LambdaUtils
		system.setLambdaUtils(lambdaUtils);
		final Type result = system.unify(substitutions, left, right);
		assertResult2AsString(result, expectedResult);
		assertTypeSubstitutions(substitutions, expectedSubsts);
		assertNotSame(left, result);
		assertNotSame(right, result);
	}
}
