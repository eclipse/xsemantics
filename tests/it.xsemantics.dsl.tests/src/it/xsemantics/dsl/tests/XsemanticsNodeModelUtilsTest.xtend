package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsNodeModelUtilsTest extends XsemanticsBaseTest {
	
	@Inject XsemanticsNodeModelUtils nodeModelUtils
	
	@Test
	def void testRuleInvocationString() {
		var ts = testFiles.testRuleInvokingAnotherRule.parseAndAssertNoError
		val ruleInvocations = ts.ruleInvocations
		Assert::assertEquals(2, ruleInvocations.size)
		Assert::assertEquals("G |- object.eClass : eClass",
			nodeModelUtils.getProgramText(ruleInvocations.get(0)))
		Assert::assertEquals("G |- eClass : object.eClass", 
			nodeModelUtils.getProgramText(ruleInvocations.get(1)))
	}
	
	@Test
	def void testNoNodeForObject() {
		val eClass = EcoreFactory::eINSTANCE.createEClass
		Assert::assertTrue(nodeModelUtils.getProgramText(eClass) === null)
	}
}