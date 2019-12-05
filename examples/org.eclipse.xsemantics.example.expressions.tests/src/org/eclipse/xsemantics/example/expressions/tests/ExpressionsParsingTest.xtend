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

package org.eclipse.xsemantics.example.expressions.tests

import com.google.inject.Inject
import org.eclipse.xsemantics.example.expressions.expressions.AndOrExpression
import org.eclipse.xsemantics.example.expressions.expressions.ArithmeticSigned
import org.eclipse.xsemantics.example.expressions.expressions.BooleanNegation
import org.eclipse.xsemantics.example.expressions.expressions.Comparison
import org.eclipse.xsemantics.example.expressions.expressions.Expression
import org.eclipse.xsemantics.example.expressions.expressions.Minus
import org.eclipse.xsemantics.example.expressions.expressions.Model
import org.eclipse.xsemantics.example.expressions.expressions.MultiOrDiv
import org.eclipse.xsemantics.example.expressions.expressions.Plus
import org.eclipse.xsemantics.runtime.StringRepresentation
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExtendedExpressionsInjectorProviderCustom))
class ExpressionsParsingTest extends ExpressionsAbstractBaseTests {

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
			'''.parse.variables.get(0).expression.expressionToString
		)
	}

	def String expressionToString(Expression expression) {
		switch (expression) {
			AndOrExpression: '''
				«expression.op»
					«expression.left.expressionToString»
					«expression.right.expressionToString»
			'''
			Comparison: '''
				«expression.op»
					«expression.left.expressionToString»
					«expression.right.expressionToString»
			'''
			Plus: '''
				+
					«expression.left.expressionToString»
					«expression.right.expressionToString»
			'''
			Minus: '''
				-
					«expression.left.expressionToString»
					«expression.right.expressionToString»
			'''
			MultiOrDiv: '''
				«expression.op»
					«expression.left.expressionToString»
					«expression.right.expressionToString»
			'''
			BooleanNegation: '''
				!
					«expression.expression.expressionToString»
			'''
			ArithmeticSigned: '''
				-
					«expression.expression.expressionToString»
			'''
			default:
				expression.string
		}.toString
	}
}
