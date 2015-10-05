package it.xsemantics.example.fjcached.performance

import com.google.inject.Inject
import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.example.fj.fj.Program
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
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