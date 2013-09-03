package it.xsemantics.example.fj.tests;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.example.fj.FJInjectorProvider;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.StringRepresentation;
import it.xsemantics.runtime.util.TraceUtils;
import java.util.List;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(FJInjectorProvider.class)
@SuppressWarnings("all")
public class FjBaseTests {
  @Inject
  @Extension
  private ParseHelper<Program> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  protected TraceUtils traceUtils;
  
  @Inject
  protected StringRepresentation stringRep;
  
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Method methodByName(final Program p, final String methodName) {
    List<Method> _allContentsOfType = EcoreUtil2.<Method>getAllContentsOfType(p, Method.class);
    final Function1<Method,Boolean> _function = new Function1<Method,Boolean>() {
      public Boolean apply(final Method it) {
        String _name = it.getName();
        boolean _equals = Objects.equal(_name, methodName);
        return Boolean.valueOf(_equals);
      }
    };
    Method _findFirst = IterableExtensions.<Method>findFirst(_allContentsOfType, _function);
    return _findFirst;
  }
}
