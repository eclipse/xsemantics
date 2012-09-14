package it.xsemantics.example.fj.tests;

import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.tests.FjBaseTests;
import it.xsemantics.example.fj.tests.FjInjectorProviderCustom;
import it.xsemantics.example.fj.typing.FjTypeSystem;
import it.xsemantics.example.fj.util.FjValueUtils;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleFailedException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = FjInjectorProviderCustom.class)
@SuppressWarnings("all")
public class FjSemanticsTests extends FjBaseTests {
  @Inject
  private FjValueUtils _fjValueUtils;
  
  @Inject
  private FjTypeSystem fjSystem;
  
  @Test
  public void testLiteralsAreValues() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("10");
    this.assertValue(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("true");
    this.assertValue(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"foo\"");
    this.assertValue(_builder_2);
  }
  
  @Test
  public void testNewWithNoArgsIsValue() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A()");
    _builder.newLine();
    this.assertValue(_builder);
  }
  
  @Test
  public void testNewWithEvaluatedArgsIsValue() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B b;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class B {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(new B(1))");
    _builder.newLine();
    this.assertValue(_builder);
  }
  
  @Test
  public void testMethodCallIsNotValue() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String m() { return \'foo\'; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A().m()");
    _builder.newLine();
    this.assertNotValue(_builder);
  }
  
  @Test
  public void testReduceNew() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A()");
    _builder.newLine();
    this.assertReduceOneStep(_builder, "new A()");
  }
  
  @Test
  public void testReduceFieldSelection() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(10).i");
    _builder.newLine();
    this.assertReduceOneStep(_builder, "10");
  }
  
  @Test
  public void testCongruenceReduceFieldSelection() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(new A(10, \'a\').i, \'b\').i");
    _builder.newLine();
    this.assertReduceOneStep(_builder, "new A(10, \'b\').i");
  }
  
  @Test
  public void testReduceAllNew() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("boolean b;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(new A(10, true, \'a\').i, false, \'b\').b");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RSelection: [] |- new A(new A(10, true, \'a\').i, false, \'b\').b ~> new A(10, false, \'b\').b");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("RNew: [] |- new A(new A(10, true, \'a\').i, false, \'b\') ~> new A(10, false, \'b\')");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("RSelection: [] |- new A(10, true, \'a\').i ~> 10");
    _builder_1.newLine();
    _builder_1.append("RSelection: [] |- new A(10, false, \'b\').b ~> false");
    this.assertReduceAll(_builder, _builder_1);
  }
  
  private void assertValue(final CharSequence prog) {
    Program _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Expression _main = _parseAndAssertNoError.getMain();
    boolean _isValue = this._fjValueUtils.isValue(_main);
    Assert.assertTrue(_isValue);
  }
  
  private void assertNotValue(final CharSequence prog) {
    Program _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Expression _main = _parseAndAssertNoError.getMain();
    boolean _isValue = this._fjValueUtils.isValue(_main);
    Assert.assertFalse(_isValue);
  }
  
  private Expression assertReduceOneStep(final CharSequence prog, final CharSequence expected) {
    Program _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Expression _main = _parseAndAssertNoError.getMain();
    Expression _copy = EcoreUtil.<Expression>copy(_main);
    Expression _assertReduceOneStep = this.assertReduceOneStep(_copy, expected);
    return _assertReduceOneStep;
  }
  
  private void assertReduceAll(final CharSequence prog, final CharSequence expectedTrace) {
    Program _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Expression _main = _parseAndAssertNoError.getMain();
    Expression exp = EcoreUtil.<Expression>copy(_main);
    Result<Expression> result = this.assertReduce(exp);
    Expression _value = result.getValue();
    boolean _isValue = this._fjValueUtils.isValue(_value);
    boolean _not = (!_isValue);
    boolean _while = _not;
    while (_while) {
      {
        Expression _value_1 = result.getValue();
        exp = _value_1;
        Result<Expression> _assertReduce = this.assertReduce(exp);
        result = _assertReduce;
      }
      Expression _value_1 = result.getValue();
      boolean _isValue_1 = this._fjValueUtils.isValue(_value_1);
      boolean _not_1 = (!_isValue_1);
      _while = _not_1;
    }
    String _string = expectedTrace.toString();
    String _traceAsString = this.traceUtils.traceAsString(this.trace);
    Assert.assertEquals(_string, _traceAsString);
  }
  
  private Expression assertReduceOneStep(final Expression exp, final CharSequence expected) {
    Expression _xblockexpression = null;
    {
      final Result<Expression> result = this.assertReduce(exp);
      String _string = expected.toString();
      Expression _value = result.getValue();
      String _string_1 = this.stringRep.string(_value);
      Assert.assertEquals(_string, _string_1);
      Expression _value_1 = result.getValue();
      _xblockexpression = (_value_1);
    }
    return _xblockexpression;
  }
  
  private Result<Expression> assertReduce(final Expression exp) {
    Result<Expression> _xblockexpression = null;
    {
      final Result<Expression> result = this.fjSystem.reduce(null, this.trace, exp);
      boolean _failed = result.failed();
      if (_failed) {
        RuleFailedException _ruleFailedException = result.getRuleFailedException();
        String _failureTraceAsString = this.traceUtils.failureTraceAsString(_ruleFailedException);
        InputOutput.<String>println(_failureTraceAsString);
        Assert.fail();
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
}
