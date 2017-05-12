package it.xsemantics.dsl.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import it.xsemantics.dsl.tests.generator.UniqueNamesTest;
import it.xsemantics.dsl.tests.generator.XsemanticsCompilerTest;
import it.xsemantics.dsl.tests.generator.XsemanticsErrorSpecificationGeneratorTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratedFileHeaderTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratedJavaCodeTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorExtensionsTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorRunnerTests;
import it.xsemantics.dsl.tests.generator.XsemanticsJvmModelGeneratorTest;
import it.xsemantics.dsl.tests.generator.XsemanticsXbaseCompilerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	UniqueNamesTest.class,
	XsemanticsGeneratorExtensionsTest.class,
	XsemanticsXbaseCompilerTest.class,
	XsemanticsJvmModelGeneratorTest.class,
	XsemanticsCompilerTest.class,
	XsemanticsGeneratorRunnerTests.class,
	XsemanticsErrorSpecificationGeneratorTest.class,
	XsemanticsGeneratedJavaCodeTest.class,
	XsemanticsGeneratedFileHeaderTest.class
})
public class XsemanticsGeneratorAllTests {

}
