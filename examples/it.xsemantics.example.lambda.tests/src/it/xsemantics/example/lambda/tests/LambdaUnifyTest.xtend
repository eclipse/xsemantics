package it.xsemantics.example.lambda.tests

import it.xsemantics.example.lambda.lambda.Type
import junit.framework.Assert
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static it.xsemantics.example.lambda.xsemantics.LambdaUtils.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaUnifyTest extends LambdaBaseTest {
	
	@Test
	def void testUnifyTypeVar() {
		assertUnify(
			createFreshTypeVariable, createFreshTypeVariable,
			"X3 -- X3",
			"X1=X3, X2=X3"
		)
	}
	
	@Test
	def void testUnifyStringType() {
		assertUnify(
			createStringType, createStringType,
			"String -- String",
			""
		)
	}
	
	@Test
	def void testUnifyIntType() {
		assertUnify(
			createIntType, createIntType,
			"int -- int",
			""
		)
	}
	
	@Test
	def void testBasicTypeFails() {
		assertFailureTrace(
			system.unify(substitutions, createStringType, createIntType),
			"failed: UnifyType: [] |- subst{} |> String ~~ int ~> Type ~~ Type"
		)
	}
	
	@Test
	def void testUnifyTypeVarBasicType() {
		assertUnify(
			createFreshTypeVariable, createStringType,
			"String -- String",
			"X1=String"
		)
	}
	
	@Test
	def void testUnifyBasicTypeTypeVar() {
		assertUnify(
			createIntType, createFreshTypeVariable,
			"int -- int",
			"X1=int"
		)
	}
	
	@Test
	def void testUnifyTypeVarArrowType() {
		assertUnify(
			createFreshTypeVariable, createFreshArrowType,
			"(X2 -> X3) -- (X2 -> X3)",
			"X1=(X2 -> X3)"
		)
	}
	
	@Test
	def void testUnifyArrowTypeTypeVar() {
		assertUnify(
			createFreshArrowType, createFreshTypeVariable,
			"(X1 -> X2) -- (X1 -> X2)",
			"X3=(X1 -> X2)"
		)
	}
	
	@Test
	def void testUnifyArrowTypes() {
		assertUnify(
			createFreshArrowType, createFreshArrowType,
			"(X5 -> X6) -- (X5 -> X6)",
			"X1=X5, X2=X6, X3=X5, X4=X6"
		)
	}
	
	@Test
	def void testUnifyArrowTypes2() {
		assertUnify(
			createFreshArrowType, 
				createArrowType(createFreshArrowType, createFreshArrowType),
			"((X3 -> X4) -> (X5 -> X6)) -- ((X3 -> X4) -> (X5 -> X6))",
			"X1=(X3 -> X4), X2=(X5 -> X6)"
		)
	}
	
	@Test
	def void testUnifyArrowTypesWithBasicTypes() {
		assertUnify(
			createFreshArrowType, 
			createArrowType(
				createArrowType(createIntType, createStringType),
				createFreshArrowType
			),
			"((int -> String) -> (X3 -> X4)) -- ((int -> String) -> (X3 -> X4))",
			"X1=(int -> String), X2=(X3 -> X4)"
		)
	}
	
	@Test
	def void testUnifyArrowTypesWithBasicTypes2() {
		assertUnify(
			createArrowType(
				createFreshArrowType,
				createArrowType(createStringType, createIntType)
			), 
			createArrowType(
				createArrowType(createIntType, createStringType),
				createFreshArrowType
			),
			"((int -> String) -> (String -> int)) -- ((int -> String) -> (String -> int))",
			"X1=int, X2=String, X3=String, X4=int"
		)
	}
	
	@Test
	def void unifyTypeVariableOccursInArrowTypeFails() {
		val variable = createTypeVariable("a")
		assertFailureTrace(
			system.unify(substitutions, variable, 
				createArrowType(createFreshArrowType, 
					createArrowType(createFreshTypeVariable, createTypeVariable("a"))
				)
			), traces.unifyTypeVariableOccursInArrowTypeFails()
		)
	}
	
	def assertUnify(Type left, Type right, String expectedResult, String expectedSubsts) {
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