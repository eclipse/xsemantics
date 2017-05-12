package it.xsemantics.dsl.tests.performance

import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsInjectorProvider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsPerformanceTest extends XsemanticsBaseTest {

	@Inject extension CompilationTestHelper

	@Rule
	@Inject public TemporaryFolder temporaryFolder

	@Test
	def void testBigFile() {
		resourceSet.getResource(
			URI.createURI(
			"./tests_performance_input_files/PerformanceTest.xsemantics"), true
		)
		resourceSet.compile[]
	}

}
