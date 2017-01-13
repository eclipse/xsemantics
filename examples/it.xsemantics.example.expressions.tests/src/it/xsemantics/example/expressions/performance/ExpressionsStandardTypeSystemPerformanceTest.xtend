package it.xsemantics.example.expressions.performance

import it.xsemantics.example.expressions.tests.ExtendedExpressionsInjectorProviderCustom
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExtendedExpressionsInjectorProviderCustom))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ExpressionsStandardTypeSystemPerformanceTest extends AbstractExpressionsPerformanceTest {

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
}