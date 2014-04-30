package it.xsemantics.dsl.tests.suites;

import it.xsemantics.dsl.tests.generator.fj.caching.FjFirstTypeSystemCachedOptionsTest;
import it.xsemantics.dsl.tests.generator.fj.caching.FjFirstTypeSystemCachedTest;
import it.xsemantics.dsl.tests.generator.fj.caching.FjFirstTypeSystemManualCachedTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	FjFirstTypeSystemManualCachedTest.class,
	FjFirstTypeSystemCachedTest.class,
	FjFirstTypeSystemCachedOptionsTest.class
})
public class XsemanticsCachedTypeSystemsAllTests {

}
