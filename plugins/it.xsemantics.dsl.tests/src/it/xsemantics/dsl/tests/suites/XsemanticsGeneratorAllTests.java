package it.xsemantics.dsl.tests.suites;

import it.xsemantics.dsl.tests.generator.GeneratedJavaCodeTest;
import it.xsemantics.dsl.tests.generator.UniqueNamesTest;
import it.xsemantics.dsl.tests.generator.XsemanticsErrorSpecificationGeneratorTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorExtensionsTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorRunnerTests;
import it.xsemantics.dsl.tests.generator.XsemanticsRuleGeneratorTest;
import it.xsemantics.dsl.tests.generator.XsemanticsSystemGeneratorTest;
import it.xsemantics.dsl.tests.generator.XsemanticsXExpressionCompilerTest;
import it.xsemantics.dsl.tests.generator.XsemanticsXbaseCompilerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	UniqueNamesTest.class,
	XsemanticsGeneratorExtensionsTest.class,
	XsemanticsXbaseCompilerTest.class,
	XsemanticsXExpressionCompilerTest.class,
	XsemanticsRuleGeneratorTest.class,
	XsemanticsGeneratorRunnerTests.class,
	XsemanticsErrorSpecificationGeneratorTest.class,
	XsemanticsSystemGeneratorTest.class,
	GeneratedJavaCodeTest.class
})
public class XsemanticsGeneratorAllTests {

}
