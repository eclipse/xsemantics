package it.xsemantics.example.expressions.tests

import com.google.inject.Inject
import it.xsemantics.example.expressions.ExpressionsInjectorProvider
import it.xsemantics.runtime.RuleApplicationTrace
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ExpressionsInjectorProvider))
class ExpressionsBaseTests {

	@Inject protected IExpressionsSemantics semantics
	
	protected RuleApplicationTrace trace
	
	@Before
	def void setUp() {
		trace = new RuleApplicationTrace()
	}

}