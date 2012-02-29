package it.xsemantics.example.expressions.tests

import com.google.inject.Inject
import it.xsemantics.example.expressions.expressions.AndOrExpression
import it.xsemantics.example.expressions.expressions.ArithmeticSigned
import it.xsemantics.example.expressions.expressions.BooleanNegation
import it.xsemantics.example.expressions.expressions.Comparison
import it.xsemantics.example.expressions.expressions.Expression
import it.xsemantics.example.expressions.expressions.Minus
import it.xsemantics.example.expressions.expressions.Model
import it.xsemantics.example.expressions.expressions.MultiOrDiv
import it.xsemantics.example.expressions.expressions.Plus
import it.xsemantics.runtime.StringRepresentation
import junit.framework.Assert
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExpressionsInjectorProviderCustom))
class ExpressionsParserTests extends ExpressionsBaseTests {

	@Inject extension ParseHelper<Model>
	
	@Inject extension StringRepresentation
	
	@Test
	def void testExpressionAssociativity() {
		Assert::assertEquals(
'''
&&
	<
		+
			*
				1
				10
			/
				-
					2
				3
		1
	!
		true
'''.toString,
'''
i = 1 * 10 + -2 / 3 < 1 && !true
'''.
				parse.variables.get(0).expression.expressionToString
		)
	}
	
	def expressionToString(Expression expression) {
		switch (expression) {
			AndOrExpression:
			'''
			«expression.op»
				«expression.left.expressionToString»
				«expression.right.expressionToString»
			'''
			Comparison:
			'''
			«expression.op»
				«expression.left.expressionToString»
				«expression.right.expressionToString»
			'''
			Plus:
			'''
			+
				«expression.left.expressionToString»
				«expression.right.expressionToString»
			'''
			Minus:
			'''
			-
				«expression.left.expressionToString»
				«expression.right.expressionToString»
			'''
			MultiOrDiv:
			'''
			«expression.op»
				«expression.left.expressionToString»
				«expression.right.expressionToString»
			'''
			BooleanNegation:
			'''
			!
				«expression.expression.expressionToString»
			'''
			ArithmeticSigned:
			'''
			-
				«expression.expression.expressionToString»
			'''
			default: expression.string
		}.toString
	}
}