package it.xsemantics.dsl.tests

import it.xsemantics.dsl.xsemantics.RuleWithPremises
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsScopingTest extends XsemanticsBaseTest {
	
	@Test
	def void testScopingForParameters() {
		val xBlockExpression = (testFiles.testScopingForParameters.parseAndAssertNoError.
			rules.head as RuleWithPremises).premises as XBlockExpression
		val leftOperandReferringToOutputParam = ((xBlockExpression).
			expressions.head as XBinaryOperation).leftOperand
		println((leftOperandReferringToOutputParam as XMemberFeatureCall).feature)
		val leftOperandReferringToInputParam = ((xBlockExpression).
			expressions.head as XBinaryOperation).leftOperand
		println((leftOperandReferringToInputParam as XMemberFeatureCall).feature)
		
	}
	

}