package it.xsemantics.example.fj.tests

import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.runtime.RuleApplicationTrace
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.BeforeClass
import org.junit.runner.RunWith
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import it.xsemantics.example.fj.fj.Program
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import it.xsemantics.runtime.util.TraceUtils
import it.xsemantics.runtime.StringRepresentation
import static extension org.eclipse.xtext.EcoreUtil2.*
import it.xsemantics.example.fj.fj.Method

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJInjectorProvider))
class FjBaseTests {

	@Inject extension ParseHelper<Program>
	
	@Inject extension ValidationTestHelper
	
	@Inject protected TraceUtils traceUtils
	
	@Inject protected StringRepresentation stringRep
	
	protected RuleApplicationTrace trace
	
	@BeforeClass
	def static void setNewLine() {
		System::setProperty("line.separator", "\n")
	}
	
	@Before
	def void setUp() {
		trace = new RuleApplicationTrace()
	}
	
	def parseAndAssertNoError(CharSequence prog) {
		prog.parse => [
			it.assertNoErrors
		]
	}
	
	def methodByName(Program p, String methodName) {
		p.getAllContentsOfType(typeof(Method)).findFirst [
			name == methodName
		]
	}

}