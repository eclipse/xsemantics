package it.xsemantics.dsl.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	XsemanticsDslAllTests.class,
	XsemanticsRuntimeAllTests.class,
	XsemanticsGeneratorAllTests.class,
	XsemanticsGeneratedTypeSystemsAllTests.class,
	XsemanticsExamplesAllTests.class
})
public class XsemanticsAllTests {

}
