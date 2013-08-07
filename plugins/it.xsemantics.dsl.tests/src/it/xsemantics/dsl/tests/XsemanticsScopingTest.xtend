package it.xsemantics.dsl.tests

import it.xsemantics.dsl.xsemantics.RuleWithPremises
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.junit.Test
import org.junit.runner.RunWith
import com.google.inject.Inject
import org.eclipse.xtext.junit4.validation.ValidationTestHelper

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsScopingTest extends XsemanticsBaseTest {

	@Inject extension ValidationTestHelper

	@Test
	def void testScopingForParameters() {
		val system = testFiles.testScopingForParameters.parse
		system.validate
		val xBlockExpression = (system.rules.head as RuleWithPremises).premises as XBlockExpression
		val leftOperandReferringToOutputParam = ((xBlockExpression).expressions.head as XBinaryOperation).leftOperand
		println((leftOperandReferringToOutputParam as XMemberFeatureCall).feature)
		val leftOperandReferringToInputParam = ((xBlockExpression).expressions.get(1) as XBinaryOperation).leftOperand
		println((leftOperandReferringToInputParam as XMemberFeatureCall).feature)
		"org.eclipse.emf.ecore.EObject.eContainer()".assertEqualsStrings((leftOperandReferringToInputParam as XMemberFeatureCall).
			feature.identifier
		)
		"name".assertEqualsStrings((leftOperandReferringToOutputParam as XMemberFeatureCall).
			feature.identifier
		)
	}

}
