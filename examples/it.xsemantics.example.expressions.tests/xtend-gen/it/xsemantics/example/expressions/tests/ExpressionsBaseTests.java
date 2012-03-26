package it.xsemantics.example.expressions.tests;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.ExpressionsInjectorProvider;
import it.xsemantics.example.expressions.tests.IExpressionsSemantics;
import it.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(ExpressionsInjectorProvider.class)
public class ExpressionsBaseTests {
  @Inject
  protected IExpressionsSemantics semantics;
  
  protected RuleApplicationTrace trace;
  
  @Before
  public void setUp() {
    RuleApplicationTrace _ruleApplicationTrace = new RuleApplicationTrace();
    this.trace = _ruleApplicationTrace;
  }
}
