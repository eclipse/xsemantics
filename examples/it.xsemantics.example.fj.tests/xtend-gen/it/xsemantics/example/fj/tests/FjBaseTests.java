package it.xsemantics.example.fj.tests;

import com.google.inject.Inject;
import it.xsemantics.example.fj.FJInjectorProvider;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = FJInjectorProvider.class)
@SuppressWarnings("all")
public class FjBaseTests {
  @Inject
  private ParseHelper<Program> _parseHelper;
  
  @Inject
  private ValidationTestHelper _validationTestHelper;
  
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
  
  public Program parseAndAssertNoError(final CharSequence prog) {
    try {
      Program _parse = this._parseHelper.parse(prog);
      final Procedure1<Program> _function = new Procedure1<Program>() {
          public void apply(final Program it) {
            FjBaseTests.this._validationTestHelper.assertNoErrors(it);
          }
        };
      Program _doubleArrow = ObjectExtensions.<Program>operator_doubleArrow(_parse, _function);
      return _doubleArrow;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
