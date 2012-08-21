package it.xsemantics.dsl.tests.suites;

import it.xsemantics.dsl.tests.generator.GeneratedJavaCodeTest;
import it.xsemantics.dsl.tests.generator.UniqueNamesTest;
import it.xsemantics.dsl.tests.generator.XsemanticsErrorSpecificationGeneratorTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorExtensionsTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorRunnerTests;
import it.xsemantics.dsl.tests.generator.XsemanticsJvmModelGeneratorTest;
import it.xsemantics.dsl.tests.generator.XsemanticsJvmModelInferrerTest;
import it.xsemantics.dsl.tests.generator.XsemanticsXbaseCompilerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	UniqueNamesTest.class,
	XsemanticsGeneratorExtensionsTest.class,
	XsemanticsXbaseCompilerTest.class,
	XsemanticsJvmModelInferrerTest.class,
	XsemanticsJvmModelGeneratorTest.class,
	XsemanticsGeneratorRunnerTests.class,
	XsemanticsErrorSpecificationGeneratorTest.class,
	GeneratedJavaCodeTest.class
})
public class XsemanticsGeneratorAllTests {

}
