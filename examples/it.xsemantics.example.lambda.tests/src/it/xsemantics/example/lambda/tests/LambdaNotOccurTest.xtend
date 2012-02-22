package it.xsemantics.example.lambda.tests

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static it.xsemantics.example.lambda.xsemantics.LambdaUtils.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaNotOccurTest extends LambdaBaseTest {
	
	@Test
	def void NotOccurConstantTypes() {
		assertResultTrue(
			system.notoccur(createStringType, createIntType)
		)
	}
	
	@Test
	def void NotOccurDifferentTypeVariables() {
		assertResultTrue(
			system.notoccur(createFreshTypeVariable, createFreshTypeVariable)
		)
	}
	
	@Test
	def void NotOccurTypeVariablesFails() {
		val variable = createFreshTypeVariable
		assertFailure(
			system.notoccur(variable, createTypeVariable("X1"))
		)
	}
	
	@Test
	def void NotOccurTypeVariablesInArrowType() {
		assertResultTrue(
			system.notoccur(createFreshTypeVariable, 
				createFreshArrowType
			)
		)
	}
	
	@Test
	def void notOccurTypeVariablesInArrowTypeFails() {
		val variable = createTypeVariable("a")
		assertFailureTrace(
			system.notoccur(variable, 
				createArrowType(createFreshArrowType, 
					createArrowType(createFreshTypeVariable, createTypeVariable("a"))
				)
			), traces.notOccurTypeVariablesInArrowTypeFails()
		)
	}
}