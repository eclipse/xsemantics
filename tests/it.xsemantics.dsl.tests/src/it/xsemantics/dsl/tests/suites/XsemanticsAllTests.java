package it.xsemantics.dsl.tests.suites;

import it.xsemantics.dsl.tests.performance.XsemanticsPerformanceTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	XsemanticsDslAllTests.class,
	XsemanticsRuntimeAllTests.class,
	XsemanticsGeneratorAllTests.class,
	XsemanticsGeneratedTypeSystemsAllTests.class,
	XsemanticsCachedTypeSystemsAllTests.class,
	XsemanticsExamplesAllTests.class,
	XsemanticsPerformanceTest.class
})
public class XsemanticsAllTests {

}
