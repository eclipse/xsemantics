package it.xsemantics.example.expressions.performance

import com.google.inject.Inject
import it.xsemantics.example.expressions.expressions.Model
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper

abstract class AbstractExpressionsPerformanceTest {
	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper

	def protected testPerformance(int n) {
		/*
		 * i_0 = 0
		 * i_1 = i_0
		 * i_2 = i_0 + i_1
		 * i_3 = i_0 + i_1 + i_2
		 * etc..
		 */
		'''
			i_0 = 0
			i_1 = i_0
			«FOR i : 2..n»
				i_«i» = i_0«FOR j : 1..i-1» + i_«j»«ENDFOR»
			«ENDFOR»
		'''.parse.assertNoErrors
	}

}