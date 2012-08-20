package it.xsemantics.example.lambda.tests

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaNotOccurTest extends LambdaBaseTest {
	
	@Test
	def void NotOccurConstantTypes() {
		assertResultTrue(
			system.notoccur(lambdaUtils.createStringType, lambdaUtils.createIntType)
		)
	}
	
	@Test
	def void NotOccurDifferentTypeVariables() {
		assertResultTrue(
			system.notoccur(lambdaUtils.createFreshTypeVariable, lambdaUtils.createFreshTypeVariable)
		)
	}
	
	@Test
	def void NotOccurTypeVariablesFails() {
		val variable = lambdaUtils.createFreshTypeVariable
		assertFailure(
			system.notoccur(variable, lambdaUtils.createTypeVariable("X1"))
		)
	}
	
	@Test
	def void NotOccurTypeVariablesInArrowType() {
		assertResultTrue(
			system.notoccur(lambdaUtils.createFreshTypeVariable, 
				lambdaUtils.createFreshArrowType
			)
		)
	}
	
	@Test
	def void notOccurTypeVariablesInArrowTypeFails() {
		val variable = lambdaUtils.createTypeVariable("a")
		assertFailureTrace(
			system.notoccur(variable, 
				lambdaUtils.createArrowType(lambdaUtils.createFreshArrowType, 
					lambdaUtils.createArrowType
						(lambdaUtils.createFreshTypeVariable, lambdaUtils.createTypeVariable("a"))
				)
			), traces.notOccurTypeVariablesInArrowTypeFails()
		)
	}
}