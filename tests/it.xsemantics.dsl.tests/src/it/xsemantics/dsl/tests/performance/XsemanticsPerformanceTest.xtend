package it.xsemantics.dsl.tests.performance

import com.google.common.io.CharStreams
import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import java.io.InputStreamReader
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
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
		val system = CharStreams.toString[|
			new InputStreamReader(class.getResourceAsStream("PerformanceTest.xsemantics"))
		]
		
		system.compile[]
	}
	
}
