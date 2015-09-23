package it.xsemantics.dsl.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import it.xsemantics.dsl.tests.runtime.ResultTests;
import it.xsemantics.dsl.tests.runtime.RuleApplicationTraceTests;
import it.xsemantics.dsl.tests.runtime.RuleEnvironmentTests;
import it.xsemantics.dsl.tests.runtime.RuleFailedExceptionTests;
import it.xsemantics.dsl.tests.runtime.StringRepresentationPostProcessorTests;
import it.xsemantics.dsl.tests.runtime.StringRepresentationTests;
import it.xsemantics.dsl.tests.runtime.TraceUtilsTests;
import it.xsemantics.dsl.tests.runtime.XsemanticsCacheListenerTest;
import it.xsemantics.dsl.tests.runtime.XsemanticsCacheTests;
import it.xsemantics.dsl.tests.runtime.XsemanticsCacheUtilsTests;
import it.xsemantics.dsl.tests.runtime.XsemanticsRuntimeSystemTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ResultTests.class,
	RuleFailedExceptionTests.class,
	RuleApplicationTraceTests.class,
	TraceUtilsTests.class,
	StringRepresentationPostProcessorTests.class,
	StringRepresentationTests.class,
	RuleEnvironmentTests.class,
	XsemanticsRuntimeSystemTests.class,
	XsemanticsCacheUtilsTests.class,
	XsemanticsCacheTests.class,
	XsemanticsCacheListenerTest.class
})
public class XsemanticsRuntimeAllTests {

}
