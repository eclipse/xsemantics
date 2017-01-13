package it.xsemantics.example.fjcached.performance

import com.google.inject.Inject
import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.example.fj.fj.Program
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJInjectorProvider))
class FjPerformanceTest extends AbstractFjPerformanceTest {
	
	@Inject extension ParseHelper<Program>
	
	@Inject extension ValidationTestHelper
	
	override validateInput(CharSequence input) {
		input.parse.assertNoErrors
	}
	
	
}