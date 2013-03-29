package it.xsemantics.example.expressions.tests;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.ExpressionsInjectorProvider;
import it.xsemantics.example.expressions.typing.ExpressionsSemantics;
import it.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ExpressionsInjectorProvider.class)
@SuppressWarnings("all")
public class ExpressionsBaseTests {
  @Inject
  protected ExpressionsSemantics semantics;
  
  protected RuleApplicationTrace trace;
  
  @BeforeClass
  public static void setNewLine() {
    System.setProperty("line.separator", "\n");
  }
  
  @Before
  public void setUp() {
    RuleApplicationTrace _ruleApplicationTrace = new RuleApplicationTrace();
    this.trace = _ruleApplicationTrace;
  }
}
