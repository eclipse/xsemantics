package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.typing.XsemanticsTypeProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsTypeProviderTest extends XsemanticsBaseTest {
	
	@Inject
	protected XsemanticsTypeProvider typeProvider
	
	@Test
	def void testStandardXExpression() {
		assertExpressionType(
			testFiles.testRuleWithFeatureCallsForBinaryOps, 0,
			"boolean")
	}

	@Test
	def void testRuleInvocation() {
		assertExpressionType(
			testFiles.testRuleOnlyInvokingRules, 0,
			"null") // JvmAnyTypeReference
	}

	@Test
	def void testEnvironmentAccess() {
		assertExpressionType(
			testFiles.testWithEnvironmentAccess, 1,
			"org.eclipse.emf.ecore.EClass"
		)
	}

	def assertExpressionType(CharSequence prog, int premiseIndex, CharSequence expected) {
		val exp = prog.getRuleWithoutValidation(0).getPremise(premiseIndex)
		val type = typeProvider.getType(exp)
		assertEqualsStrings(expected, type.identifier)
	}
}