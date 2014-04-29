package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests
import org.junit.Test
import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests.FjClassForTests

class FjFirstCachedGeneratedTypeSystemTests extends
		FjAbstractGeneratedTypeSystemTests {

	override fjCustomStandaloneSetupClass() {
		return FjFirstCachedStandaloneSetup;
	}

	@Test
	def void testSubclassesFailedCached() {
		val classes = new FjClassForTests(
				testFiles.testClassHierarchy());
		assertSubclasses(classes.A, classes.B, false, classes.trace,
				expectedTraces.failSubclasses(),
				"class A { } -- class B extends A { }");
		assertSubclasses(classes.A, classes.B, false, classes.trace,
				expectedTraces.failSubclasses(),
				"class A { } -- class B extends A { }");
	}
}
