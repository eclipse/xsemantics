package it.xsemantics.dsl.tests.performance

import com.google.common.io.CharStreams
import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsCompilationTestHelper
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import java.io.InputStreamReader
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsPerformanceTest extends XsemanticsBaseTest {
	
	@Inject extension XsemanticsCompilationTestHelper
	
	@Test
	def void testBigFile() {
		val system = CharStreams.toString[|
			new InputStreamReader(class.getResourceAsStream("PerformanceTest.xsemantics"))
		]
		
		system.compileAll[]
	}
	
}
