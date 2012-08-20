package it.xsemantics.example.lambda.tests

import it.xsemantics.example.lambda.lambda.Type
import junit.framework.Assert
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaUnifyTest extends LambdaBaseTest {

	@Test
	def void testUnifyTypeVar() {
		assertUnify(
			lambdaUtils.createFreshTypeVariable, lambdaUtils.createFreshTypeVariable,
			"X3 -- X3",
			"X1=X3, X2=X3"
		)
	}
	
	@Test
	def void testUnifyStringType() {
		assertUnify(
			lambdaUtils.createStringType, lambdaUtils.createStringType,
			"String -- String",
			""
		)
	}
	
	@Test
	def void testUnifyIntType() {
		assertUnify(
			lambdaUtils.createIntType, lambdaUtils.createIntType,
			"int -- int",
			""
		)
	}
	
	@Test
	def void testBasicTypeFails() {
		assertFailureTrace(
			system.unify(substitutions, lambdaUtils.createStringType, lambdaUtils.createIntType),
			"failed: UnifyType: [] |- subst{} |> String ~~ int ~> Type ~~ Type"
		)
	}
	
	@Test
	def void testUnifyTypeVarBasicType() {
		assertUnify(
			lambdaUtils.createFreshTypeVariable, lambdaUtils.createStringType,
			"String -- String",
			"X1=String"
		)
	}
	
	@Test
	def void testUnifyBasicTypeTypeVar() {
		assertUnify(
			lambdaUtils.createIntType, lambdaUtils.createFreshTypeVariable,
			"int -- int",
			"X1=int"
		)
	}
	
	@Test
	def void testUnifyTypeVarArrowType() {
		assertUnify(
			lambdaUtils.createFreshTypeVariable, lambdaUtils.createFreshArrowType,
			"(X2 -> X3) -- (X2 -> X3)",
			"X1=(X2 -> X3)"
		)
	}
	
	@Test
	def void testUnifyArrowTypeTypeVar() {
		assertUnify(
			lambdaUtils.createFreshArrowType, lambdaUtils.createFreshTypeVariable,
			"(X1 -> X2) -- (X1 -> X2)",
			"X3=(X1 -> X2)"
		)
	}
	
	@Test
	def void testUnifyArrowTypes() {
		assertUnify(
			lambdaUtils.createFreshArrowType, lambdaUtils.createFreshArrowType,
			"(X5 -> X6) -- (X5 -> X6)",
			"X1=X5, X2=X6, X3=X5, X4=X6"
		)
	}
	
	@Test
	def void testUnifyArrowTypes2() {
		assertUnify(
			lambdaUtils.createFreshArrowType, 
				lambdaUtils.createArrowType
					(lambdaUtils.createFreshArrowType, lambdaUtils.createFreshArrowType),
			"((X3 -> X4) -> (X5 -> X6)) -- ((X3 -> X4) -> (X5 -> X6))",
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
			"((int -> String) -> (X3 -> X4)) -- ((int -> String) -> (X3 -> X4))",
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
			"((int -> String) -> (String -> int)) -- ((int -> String) -> (String -> int))",
			"X1=int, X2=String, X3=String, X4=int"
		)
	}
	
	@Test
	def void unifyTypeVariableOccursInArrowTypeFails() {
		val variable = lambdaUtils.createTypeVariable("a")
		assertFailureTrace(
			system.unify(substitutions, variable, 
				lambdaUtils.createArrowType(lambdaUtils.createFreshArrowType, 
					lambdaUtils.createArrowType
						(lambdaUtils.createFreshTypeVariable, lambdaUtils.createTypeVariable("a"))
				)
			), traces.unifyTypeVariableOccursInArrowTypeFails()
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
		Assert::assertNotSame(left, result.first)
		Assert::assertNotSame(right, result.second)
	}
}