package it.xsemantics.example.expressions.performance

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(CachedExpressionsInjectorProviderCustom))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ExpressionsCachedTypeSystemPerformanceTest extends AbstractExpressionsPerformanceTest {

	@Test def aWarmUp() {
		testPerformance(10)
	}

	@Test def testPerformance10() {
		testPerformance(10)
	}

	@Test def testPerformance12() {
		testPerformance(12)
	}

	@Test def testPerformance14() {
		testPerformance(14)
	}

	@Test def testPerformance16() {
		testPerformance(16)
	}

	@Test def testPerformance18() {
		testPerformance(18)
	}

	@Test def testPerformance30() {
		testPerformance(30)
	}

	@Test def testPerformance50() {
		testPerformance(50)
	}

}