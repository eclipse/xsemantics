package it.xsemantics.dsl.tests.runtime

import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsInjectorProvider
import it.xsemantics.dsl.tests.EmfFactoryUtils
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.runtime.ErrorInformation
import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.RuleFailedException
import it.xsemantics.runtime.TraceUtils
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class TraceUtilsTests extends XsemanticsBaseTest {
	
	@Inject extension TraceUtils
	
	@Inject extension EmfFactoryUtils

	@Test
	def void testWithNodeModelSources() {
		var ts = testFiles.testRuleInvokingAnotherRule.parseAndAssertNoError
		val ruleInvocations = ts.ruleInvocations
		Assert::assertEquals(2, ruleInvocations.size)
		val ex2 = new RuleFailedException("prev")
		ex2.addErrorInformation(new ErrorInformation(ruleInvocations.get(0)))
		ex2.addErrorInformation(new ErrorInformation(createEObject))
		val ex1 = new RuleFailedException("first", ex2)
		ex1.addErrorInformation(new ErrorInformation(ruleInvocations.get(1)))
		ex1.addErrorInformation(new ErrorInformation(createEObject))
		val list = ex1.allErrorInformation.removeNonNodeModelSources
		Assert::assertEquals(2, list.size)
		Assert::assertSame(ruleInvocations.get(1), list.get(0).source)
		Assert::assertSame(ruleInvocations.get(0), list.get(1).source)
	}
	
	@Test
	def void testFilteredErrorInformation() {
		var ts = testFiles.testRuleInvokingAnotherRule.parseAndAssertNoError
		val ruleInvocations = ts.ruleInvocations
		Assert::assertEquals(2, ruleInvocations.size)
		val ex2 = new RuleFailedException("prev")
		ex2.addErrorInformation(new ErrorInformation(ruleInvocations.get(0)))
		ex2.addErrorInformation(new ErrorInformation(createEObject))
		val ex1 = new RuleFailedException("first", ex2)
		ex1.addErrorInformation(new ErrorInformation(ruleInvocations.get(1)))
		ex1.addErrorInformation(new ErrorInformation(ruleInvocations.get(1))) // dup
		ex1.addErrorInformation(new ErrorInformation(createEObject))
		val list = ex1.filteredErrorInformation
		Assert::assertEquals(2, list.size)
		Assert::assertSame(ruleInvocations.get(1), list.get(0).source)
		Assert::assertSame(ruleInvocations.get(0), list.get(1).source)
	}
	
	@Test
	def void testInnermostRuleFailedExceptionWithNodeModelSources() {
		var ts = testFiles.testRuleInvokingAnotherRule.parseAndAssertNoError
		val ruleInvocations = ts.ruleInvocations
		Assert::assertEquals(2, ruleInvocations.size)
		val ex3 = new RuleFailedException("prev")
		// this has no error information with associated NodeModel
		ex3.addErrorInformation(new ErrorInformation(createEObject))
		ex3.addErrorInformation(new ErrorInformation(createEObject))
		val ex2 = new RuleFailedException("prev", ex3)
		// this should be the innermost
		ex2.addErrorInformation(new ErrorInformation(ruleInvocations.get(0)))
		ex2.addErrorInformation(new ErrorInformation(createEObject))
		val ex1 = new RuleFailedException("first", ex2)
		ex1.addErrorInformation(new ErrorInformation(ruleInvocations.get(1)))
		ex1.addErrorInformation(new ErrorInformation(ruleInvocations.get(1))) // dup
		ex1.addErrorInformation(new ErrorInformation(createEObject))
		val innerMost = ex1.innermostRuleFailedExceptionWithNodeModelSources
		Assert::assertSame(ex2, innerMost)
		val list = innerMost.filteredErrorInformation
		Assert::assertEquals(1, list.size)
		Assert::assertSame(ruleInvocations.get(0), list.get(0).source)
	}
		
	@Test
	def void testFailureAsList() {
		val ex2 = new RuleFailedException("prev")
		val ex1 = new RuleFailedException("first", ex2)
		val list = ex1.failureAsList
		assertMessage(list.get(0), "first");
		assertMessage(list.get(1), "prev");
	}
	
	@Test
	def void testFailureAsListWithNullMessage() {
		val ex2 = new RuleFailedException("prev")
		val nullMsg = new RuleFailedException(null, ex2) // must be discarded
		val ex1 = new RuleFailedException("first", nullMsg)
		val list = ex1.failureAsList
		Assert::assertEquals(2, list.size)
		assertMessage(list.get(0), "first");
		assertMessage(list.get(1), "prev");
	}
	
	@Test
	def void testFailureAsString() {
		val ex3 = new RuleFailedException("prev2")
		val ex2 = new RuleFailedException("  prev", ex3)
		val ex1 = new RuleFailedException("first", ex2)
		val trace = ex1.failureTraceAsString
		assertEqualsStrings(
			'''
			first
			 prev
			  prev2''', trace
		)
	}
	
	@Test
	def void testTraceAsString() {
		val trace = new RuleApplicationTrace()
		trace.addToTrace("foo")
		trace.addToTrace("bar")
		
		val trace2 = new RuleApplicationTrace()
		trace2.addToTrace("inner")
		
		val trace3 = new RuleApplicationTrace()
		trace3.addToTrace("innerinner")
		
		trace2.addAsSubtrace(trace3)
		trace2.addToTrace("inner2")
		
		trace.addAsSubtrace(trace2)
		trace.addToTrace("foobar")
		assertEqualsStrings(
			'''
			foo
			bar
			 inner
			  innerinner
			 inner2
			foobar''', trace.traceAsString
		)
	}
	
	@Test
	def void testAllErrorInformation() {
		val ex2 = new RuleFailedException("prev")
		val source2 = createEObject
		ex2.addErrorInformation(new ErrorInformation(source2))
		val ex1 = new RuleFailedException("first", ex2)
		val source1 = createEObject
		ex1.addErrorInformation(new ErrorInformation(source1))
		val list = ex1.allErrorInformation
		Assert::assertSame(source1, list.get(0).source)
		Assert::assertSame(source2, list.get(1).source)
	}
	
	@Test
	def void testRemoveDuplicateErrorInformation() {
		val ex2 = new RuleFailedException("prev")
		val source2 = createEObject
		ex2.addErrorInformation(new ErrorInformation(source2))
		ex2.addErrorInformation(new ErrorInformation(source2)) // considered duplicate
		ex2.addErrorInformation(new ErrorInformation(source2, 
			EcorePackage::eINSTANCE.EAttribute_EAttributeType
		)) // not duplicate
		val ex1 = new RuleFailedException("first", ex2)
		val source1 = createEObject
		ex1.addErrorInformation(new ErrorInformation(source1))
		val list = ex1.allErrorInformation.removeDuplicateErrorInformation
		Assert::assertEquals(3, list.size)
		Assert::assertSame(source1, list.get(0).source)
		Assert::assertSame(source2, list.get(1).source)
		Assert::assertSame(source2, list.get(2).source)
	}

	@Test
	def void testRemoveDuplicateErrorInformationWithData() {
		val ex2 = new RuleFailedException("prev")
		val source2 = createEObject
		val additionalData = #[1, 2]
		ex2.addErrorInformation(new ErrorInformation(source2, null, additionalData))
		ex2.addErrorInformation(new ErrorInformation(source2, null, additionalData)) // considered duplicate
		ex2.addErrorInformation(new ErrorInformation(source2, 
			EcorePackage::eINSTANCE.EAttribute_EAttributeType
		)) // not duplicate
		ex2.addErrorInformation(new ErrorInformation(source2, 
			EcorePackage::eINSTANCE.EAttribute_EAttributeType,
			additionalData
		)) // not duplicate

		val ex1 = new RuleFailedException("first", ex2)
		val source1 = createEObject
		ex1.addErrorInformation(new ErrorInformation(source1))
		val list = ex1.allErrorInformation.removeDuplicateErrorInformation
		Assert::assertEquals(4, list.size)
		Assert::assertSame(source1, list.get(0).source)
		Assert::assertSame(source2, list.get(1).source)
		Assert::assertSame(source2, list.get(2).source)
		Assert::assertSame(source2, list.get(3).source)
		Assert::assertSame(EcorePackage::eINSTANCE.EAttribute_EAttributeType, list.get(3).feature)
	}
	
	@Test
	def void testRemoveNonNodeModelSources() {
		val ex2 = new RuleFailedException("prev")
		val source2 = createEObject
		ex2.addErrorInformation(new ErrorInformation(source2))
		val ex1 = new RuleFailedException("first", ex2)
		val source1 = createEObject
		ex1.addErrorInformation(new ErrorInformation(source1))
		val list = ex1.allErrorInformation.removeNonNodeModelSources
		Assert::assertEquals(0, list.size)
	}

	@Test
	def void testLastElementNotTrace() {
		val t = new RuleApplicationTrace
		t.addToTrace("first")
		t.addAsSubtrace(new RuleApplicationTrace)
		t.addToTrace("last")
		t.addAsSubtrace(new RuleApplicationTrace)
		Assert.assertEquals("last", t.lastElementNotTrace)
	}
	
	def void assertMessage(RuleFailedException ex, String message) {
		Assert::assertEquals(message, ex.getMessage());
	}
}