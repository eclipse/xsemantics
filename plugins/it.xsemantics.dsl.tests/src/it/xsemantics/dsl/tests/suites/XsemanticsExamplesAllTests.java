package it.xsemantics.dsl.tests.suites;

import it.xsemantics.example.expressions.tests.ExpressionsAllTests;
import it.xsemantics.example.lambda.tests.LambdaAllTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ExpressionsAllTests.class,
	LambdaAllTests.class
})
public class XsemanticsExamplesAllTests {

}
