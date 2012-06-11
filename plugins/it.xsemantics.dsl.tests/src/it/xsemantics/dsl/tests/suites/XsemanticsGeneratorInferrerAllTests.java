package it.xsemantics.dsl.tests.suites;

import it.xsemantics.dsl.tests.inferrer.TempXsemanticsUtilsTest;
import it.xsemantics.dsl.tests.inferrer.XsemanticsJvmModelInferrerTest;
import it.xsemantics.dsl.tests.inferrer.XsemanticsParserTestInferrer;
import it.xsemantics.dsl.tests.inferrer.XsemanticsValidatorTests;
import it.xsemantics.dsl.tests.inferrer.generator.InferrerGeneratedJavaCodeTest;
import it.xsemantics.dsl.tests.inferrer.generator.XsemanticsGeneratorExtensionsTest;
import it.xsemantics.dsl.tests.inferrer.generator.XsemanticsJvmModelGeneratorTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TempXsemanticsUtilsTest.class,
	XsemanticsParserTestInferrer.class,
	XsemanticsGeneratorExtensionsTest.class,
	XsemanticsJvmModelInferrerTest.class,
	XsemanticsJvmModelGeneratorTest.class,
	InferrerGeneratedJavaCodeTest.class,
	XsemanticsValidatorTests.class
})
public class XsemanticsGeneratorInferrerAllTests {

}
