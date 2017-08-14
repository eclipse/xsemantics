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

import org.eclipse.xsemantics.example.lambda.lambda.Type
import org.eclipse.xsemantics.runtime.RuleFailedException
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaUnifyTest extends LambdaBaseTest {
	
	@Rule public ExpectedException thrown= ExpectedException.none();

	@Test
	def void testUnifyTypeVar() {
		assertUnify(
			lambdaUtils.createFreshTypeVariable, lambdaUtils.createFreshTypeVariable,
			"X3",
			"X1=X3, X2=X3"
		)
	}
	
	@Test
	def void testUnifyStringType() {
		assertUnify(
			lambdaUtils.createStringType, lambdaUtils.createStringType,
			"String",
			""
		)
	}
	
	@Test
	def void testUnifyIntType() {
		assertUnify(
			lambdaUtils.createIntType, lambdaUtils.createIntType,
			"int",
			""
		)
	}
	
	@Test
	def void testBasicTypeFails() {
		thrown.expect( RuleFailedException );
    	thrown.expectMessage("failed: cannot unify String with int");
		
		system.unify(substitutions, lambdaUtils.createStringType, lambdaUtils.createIntType)
	}
	
	@Test
	def void testUnifyTypeVarBasicType() {
		assertUnify(
			lambdaUtils.createFreshTypeVariable, lambdaUtils.createStringType,
			"String",
			"X1=String"
		)
	}
	
	@Test
	def void testUnifyBasicTypeTypeVar() {
		assertUnify(
			lambdaUtils.createIntType, lambdaUtils.createFreshTypeVariable,
			"int",
			"X1=int"
		)
	}
	
	@Test
	def void testUnifyTypeVarArrowType() {
		assertUnify(
			lambdaUtils.createFreshTypeVariable, lambdaUtils.createFreshArrowType,
			"(X2 -> X3)",
			"X1=(X2 -> X3)"
		)
	}
	
	@Test
	def void testUnifyArrowTypeTypeVar() {
		assertUnify(
			lambdaUtils.createFreshArrowType, lambdaUtils.createFreshTypeVariable,
			"(X1 -> X2)",
			"X3=(X1 -> X2)"
		)
	}
	
	@Test
	def void testUnifyArrowTypes() {
		assertUnify(
			lambdaUtils.createFreshArrowType, lambdaUtils.createFreshArrowType,
			"(X5 -> X6)",
			"X1=X5, X2=X6, X3=X5, X4=X6"
		)
	}
	
	@Test
	def void testUnifyArrowTypes2() {
		assertUnify(
			lambdaUtils.createFreshArrowType, 
				lambdaUtils.createArrowType
					(lambdaUtils.createFreshArrowType, lambdaUtils.createFreshArrowType),
			"((X3 -> X4) -> (X5 -> X6))",
			"X1=(X3 -> X4), X2=(X5 -> X6)"
		)
	}
	
	@Test
	def void testUnifyArrowTypesWithBasicTypes() {
		assertUnify(
			lambdaUtils.createFreshArrowType, 
			lambdaUtils.createArrowType(
				lambdaUtils.createArrowType
					(lambdaUtils.createIntType, lambdaUtils.createStringType),
				lambdaUtils.createFreshArrowType
			),
			"((int -> String) -> (X3 -> X4))",
			"X1=(int -> String), X2=(X3 -> X4)"
		)
	}
	
	@Test
	def void testUnifyArrowTypesWithBasicTypes2() {
		assertUnify(
			lambdaUtils.createArrowType(
				lambdaUtils.createFreshArrowType,
				lambdaUtils.createArrowType
					(lambdaUtils.createStringType, lambdaUtils.createIntType)
			), 
			lambdaUtils.createArrowType(
				lambdaUtils.createArrowType
					(lambdaUtils.createIntType, lambdaUtils.createStringType),
				lambdaUtils.createFreshArrowType
			),
			"((int -> String) -> (String -> int))",
			"X1=int, X2=String, X3=String, X4=int"
		)
	}
	
	@Test
	def void unifyTypeVariableOccursInArrowTypeFails() {
		thrown.expect( RuleFailedException );
    	thrown.expectMessage("failed: cannot unify a with ((X1 -> X2) -> (X3 -> a))");
    	
		val variable = lambdaUtils.createTypeVariable("a")
		system.unify(substitutions, variable, 
				lambdaUtils.createArrowType(lambdaUtils.createFreshArrowType, 
					lambdaUtils.createArrowType
						(lambdaUtils.createFreshTypeVariable, lambdaUtils.createTypeVariable("a"))
				)
			)
	}
	
	def assertUnify(Type left, Type right, String expectedResult, String expectedSubsts) {
		// make sure we use the same instance of LambdaUtils
		system.lambdaUtils = lambdaUtils
		val result = system.unify(substitutions, left, right)
		assertResult2AsString(
			result,
			expectedResult
		)
		assertTypeSubstitutions(substitutions, expectedSubsts)
		Assert::assertNotSame(left, result)
		Assert::assertNotSame(right, result)
	}
}