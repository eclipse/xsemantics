package it.xsemantics.example.fj.tests

import it.xsemantics.example.fj.FJInjectorProvider
import it.xsemantics.runtime.RuleApplicationTrace
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.BeforeClass
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJInjectorProvider))
class FjBaseTests {

	protected RuleApplicationTrace trace
	
	@BeforeClass
	def static void setNewLine() {
		System::setProperty("line.separator", "\n")
	}
	
	@Before
	def void setUp() {
		trace = new RuleApplicationTrace()
	}

}