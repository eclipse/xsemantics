package it.xsemantics.example.fjcached.performance

import com.google.inject.Inject
import it.xsemantics.example.fjcached.FjcachedInjectorProvider
import it.xsemantics.example.fjcached.fjcached.FjCachedProgram
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FjcachedInjectorProvider))
class FjCachedPerformanceTest extends AbstractFjPerformanceTest {
	
	@Inject extension ParseHelper<FjCachedProgram>
	
	@Inject extension ValidationTestHelper
	
	override validateInput(CharSequence input) {
		input.parse.assertNoErrors
	}
	
	
}