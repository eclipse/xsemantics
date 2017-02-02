package it.xsemantics.example.lambda.tests

import it.xsemantics.runtime.RuleFailedException
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaInjectorWithNonBeautifiedTypesProvider))
class LambdaNotOccurTest extends LambdaBaseTest {
	
	@Rule public ExpectedException thrown= ExpectedException.none();
	
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
		thrown.expect( RuleFailedException );
    	thrown.expectMessage("failed: X1 occurs in X1");
		
		val variable = lambdaUtils.createFreshTypeVariable
		system.notoccur(variable, lambdaUtils.createTypeVariable("X1"))
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
		thrown.expect( RuleFailedException );
    	thrown.expectMessage("failed: a occurs in ((X1 -> X2) -> (X3 -> a))");
		
		val variable = lambdaUtils.createTypeVariable("a")
		system.notoccur(trace, variable, 
						lambdaUtils.createArrowType(lambdaUtils.createFreshArrowType, 
							lambdaUtils.createArrowType
								(lambdaUtils.createFreshTypeVariable, lambdaUtils.createTypeVariable("a"))
						)
					)
//		val trace = new RuleApplicationTrace
//		var notoccur = false
//		try {
//			notoccur = system.notoccur(trace, variable, 
//						lambdaUtils.createArrowType(lambdaUtils.createFreshArrowType, 
//							lambdaUtils.createArrowType
//								(lambdaUtils.createFreshTypeVariable, lambdaUtils.createTypeVariable("a"))
//						)
//					)
//		} finally {
//			assertFailureTrace(
//				notoccur, 
//				trace,
//				traces.notOccurTypeVariablesInArrowTypeFails()
//			)
//		}
	}
}