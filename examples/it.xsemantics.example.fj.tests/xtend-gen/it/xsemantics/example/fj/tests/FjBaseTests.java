package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.FJInjectorProvider;
import it.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = FJInjectorProvider.class)
@SuppressWarnings("all")
public class FjBaseTests {
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
