package it.xsemantics.example.fj.tests;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.MethodBody;
import it.xsemantics.example.fj.fj.Parameter;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.Selection;
import it.xsemantics.example.fj.tests.FjBaseTests;
import it.xsemantics.example.fj.tests.FjInjectorProviderCustom;
import it.xsemantics.example.fj.typing.FjTypeSystem;
import it.xsemantics.example.fj.util.FjSemanticsUtils;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleFailedException;
import org.eclipse.emf.common.util.EList;
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
  private FjSemanticsUtils _fjSemanticsUtils;
  
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
  public void testReplaceThis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class B { }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B o;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("A m(A a, int i) { return this.m(this, 10); }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(new B())");
    _builder.newLine();
    this.assertThisReplacement(_builder, "new A(new B()).m(new A(new B()), 10)");
  }
  
  @Test
  public void testReplaceParams() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class B { }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B o;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("A m(A a, B b, int i, String s) { return a.m(a, b, i, s); }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(new B()).m(new A(new B()), new A(new B()).o, 10, \'foo\')");
    _builder.newLine();
    this.assertParamsReplacement(_builder, 
      "new A(new B()).m(new A(new B()), new A(new B()).o, 10, \'foo\')");
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
    this.assertReduceOneStep(_builder, "new A()", null);
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
    this.assertReduceOneStep(_builder, "10", null);
  }
  
  @Test
  public void testReduceMethodSelection() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class B { String s; }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B o;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B m(B b, String s) { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.getB(s);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B getB(String s) { return this.o; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(new B(\'foo\')).m(new B(\'bar\'), \'aaa\')");
    _builder.newLine();
    this.assertReduceOneStep(_builder, 
      "new A(new B(\'foo\')).getB(\'aaa\')", null);
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
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RSelection: [] |- new A(new A(10, \'a\').i, \'b\').i ~> new A(10, \'b\').i");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("RNew: [] |- new A(new A(10, \'a\').i, \'b\') ~> new A(10, \'b\')");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("RSelection: [] |- new A(10, \'a\').i ~> 10");
    this.assertReduceOneStep(_builder, 
      "new A(10, \'b\').i", _builder_1);
  }
  
  @Test
  public void testCongruenceReduceMethodSelection() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int m(int arg) { return arg; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(10, \'b\').m(new A(20, \'c\').i)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RSelection: [] |- new A(10, \'b\').m(new A(20, \'c\').i) ~> new A(10, \'b\').m(20)");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("RSelection: [] |- new A(20, \'c\').i ~> 20");
    this.assertReduceOneStep(_builder, 
      "new A(10, \'b\').m(20)", _builder_1);
  }
  
  @Test
  public void testReduceAllFieldSelection() {
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
  
  @Test
  public void testReduceAllMethodSelection() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class B { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getS() { return this.s; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B o;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B m(B b, String s) { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.getB(s);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B getB(String s) { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.o;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("new A(new B(\'foo\')).m(new B(\'bar\'), \'aaa\').getS()");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RSelection: [] |- new A(new B(\'foo\')).m(new B(\'bar\'), \'aaa\').getS() ~> new A(new B(\'foo\')).getB(\'aaa\').getS()");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("RSelection: [] |- new A(new B(\'foo\')).m(new B(\'bar\'), \'aaa\') ~> new A(new B(\'foo\')).getB(\'aaa\')");
    _builder_1.newLine();
    _builder_1.append("RSelection: [] |- new A(new B(\'foo\')).getB(\'aaa\').getS() ~> new A(new B(\'foo\')).o.getS()");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("RSelection: [] |- new A(new B(\'foo\')).getB(\'aaa\') ~> new A(new B(\'foo\')).o");
    _builder_1.newLine();
    _builder_1.append("RSelection: [] |- new A().o.getS() ~> new B(\'foo\').getS()");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("RSelection: [] |- new A(new B(\'foo\')).o ~> new B(\'foo\')");
    _builder_1.newLine();
    _builder_1.append("RSelection: [] |- new B(\'foo\').getS() ~> new B(\'foo\').s");
    _builder_1.newLine();
    _builder_1.append("RSelection: [] |- new B(\'foo\').s ~> \'foo\' ");
    this.assertReduceAll(_builder, _builder_1);
  }
  
  private void assertValue(final CharSequence prog) {
    Program _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Expression _main = _parseAndAssertNoError.getMain();
    boolean _isValue = this._fjSemanticsUtils.isValue(_main);
    Assert.assertTrue(_isValue);
  }
  
  private void assertNotValue(final CharSequence prog) {
    Program _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Expression _main = _parseAndAssertNoError.getMain();
    boolean _isValue = this._fjSemanticsUtils.isValue(_main);
    Assert.assertFalse(_isValue);
  }
  
  private void assertThisReplacement(final CharSequence prog, final CharSequence expected) {
    final Program p = this.parseAndAssertNoError(prog);
    Method _methodByName = this.methodByName(p, "m");
    MethodBody _body = _methodByName.getBody();
    Expression _expression = _body.getExpression();
    final Expression mBodyExp = EcoreUtil.<Expression>copy(_expression);
    Expression _main = p.getMain();
    this._fjSemanticsUtils.replaceThis(mBodyExp, _main);
    String _string = expected.toString();
    String _string_1 = this.stringRep.string(mBodyExp);
    Assert.assertEquals(_string, _string_1);
  }
  
  private void assertParamsReplacement(final CharSequence prog, final CharSequence expected) {
    final Program p = this.parseAndAssertNoError(prog);
    final Method m = this.methodByName(p, "m");
    MethodBody _body = m.getBody();
    Expression _expression = _body.getExpression();
    final Expression mBodyExp = EcoreUtil.<Expression>copy(_expression);
    EList<Parameter> _params = m.getParams();
    Expression _main = p.getMain();
    EList<Expression> _args = ((Selection) _main).getArgs();
    this._fjSemanticsUtils.replaceParams(mBodyExp, _params, _args);
    String _string = expected.toString();
    String _string_1 = this.stringRep.string(mBodyExp);
    Assert.assertEquals(_string, _string_1);
  }
  
  private void assertReduceAll(final CharSequence prog, final CharSequence expectedTrace) {
    Program _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Expression _main = _parseAndAssertNoError.getMain();
    Expression exp = EcoreUtil.<Expression>copy(_main);
    Result<Expression> result = this.assertReduce(exp);
    Expression _value = result.getValue();
    boolean _isValue = this._fjSemanticsUtils.isValue(_value);
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
      boolean _isValue_1 = this._fjSemanticsUtils.isValue(_value_1);
      boolean _not_1 = (!_isValue_1);
      _while = _not_1;
    }
    String _string = expectedTrace.toString();
    String _trim = _string.trim();
    String _traceAsString = this.traceUtils.traceAsString(this.trace);
    Assert.assertEquals(_trim, _traceAsString);
  }
  
  private Expression assertReduceOneStep(final CharSequence prog, final CharSequence expected, final CharSequence expectedTrace) {
    Program _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Expression _main = _parseAndAssertNoError.getMain();
    Expression _copy = EcoreUtil.<Expression>copy(_main);
    Expression _assertReduceOneStep = this.assertReduceOneStep(_copy, expected, expectedTrace);
    return _assertReduceOneStep;
  }
  
  private Expression assertReduceOneStep(final Expression exp, final CharSequence expected, final CharSequence expectedTrace) {
    Expression _xblockexpression = null;
    {
      final Result<Expression> result = this.assertReduce(exp);
      boolean _notEquals = (!Objects.equal(expected, null));
      if (_notEquals) {
        String _string = expected.toString();
        Expression _value = result.getValue();
        String _string_1 = this.stringRep.string(_value);
        Assert.assertEquals(_string, _string_1);
      }
      boolean _notEquals_1 = (!Objects.equal(expectedTrace, null));
      if (_notEquals_1) {
        String _string_2 = expectedTrace.toString();
        String _traceAsString = this.traceUtils.traceAsString(this.trace);
        Assert.assertEquals(_string_2, _traceAsString);
      }
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
