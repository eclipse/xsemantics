package it.xsemantics.example.fj.tests;

import com.google.inject.Inject;
import it.xsemantics.example.fj.FJInjectorProvider;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.tests.FjBaseTests;
import it.xsemantics.example.fj.util.FjValueUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = FJInjectorProvider.class)
@SuppressWarnings("all")
public class FjSemanticsTests extends FjBaseTests {
  @Inject
  private FjValueUtils _fjValueUtils;
  
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
}
