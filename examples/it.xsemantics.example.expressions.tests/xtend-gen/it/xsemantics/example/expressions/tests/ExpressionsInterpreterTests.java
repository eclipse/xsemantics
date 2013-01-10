package it.xsemantics.example.expressions.tests;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.expressions.Expression;
import it.xsemantics.example.expressions.expressions.Model;
import it.xsemantics.example.expressions.expressions.Variable;
import it.xsemantics.example.expressions.tests.ExpressionsBaseTests;
import it.xsemantics.example.expressions.tests.ExtendedExpressionsInjectorProviderCustom;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.util.TraceUtils;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ExtendedExpressionsInjectorProviderCustom.class)
@SuppressWarnings("all")
public class ExpressionsInterpreterTests extends ExpressionsBaseTests {
  @Inject
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  private TraceUtils _traceUtils;
  
  @Test
  public void testInterpreter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 - 5 - 1");
    this.assertResult(_builder, 0, Integer.valueOf(4));
  }
  
  @Test
  public void testInterpreterAndOr() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = true && (false || true)");
    this.assertResult(_builder, 0, Boolean.valueOf(true));
  }
  
  @Test
  public void testInterpreterAndOrWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = true && (false || \'true\')");
    this.assertResult(_builder, 0, Boolean.valueOf(true));
  }
  
  @Test
  public void testInterpreterMulti() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 2 * 3");
    this.assertResult(_builder, 0, Integer.valueOf(6));
  }
  
  @Test
  public void testInterpreterMultiWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 2 * \'3\' ");
    this.assertResult(_builder, 0, Integer.valueOf(6));
  }
  
  @Test
  public void testInterpreterDiv() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 6 / 3");
    this.assertResult(_builder, 0, Integer.valueOf(2));
  }
  
  @Test
  public void testInterpreterMinus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 6 - 2");
    this.assertResult(_builder, 0, Integer.valueOf(4));
  }
  
  @Test
  public void testInterpreterMinusWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 6 - \'2\' ");
    this.assertResult(_builder, 0, Integer.valueOf(4));
  }
  
  @Test
  public void testSigned() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = -2");
    int _minus = (-2);
    this.assertResult(_builder, 0, Integer.valueOf(_minus));
  }
  
  @Test
  public void testSignedWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = -\'2\' ");
    int _minus = (-2);
    this.assertResult(_builder, 0, Integer.valueOf(_minus));
  }
  
  @Test
  public void testNegation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = !true");
    this.assertResult(_builder, 0, Boolean.valueOf(false));
  }
  
  @Test
  public void testNegationWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = !\'true\' ");
    this.assertResult(_builder, 0, Boolean.valueOf(false));
  }
  
  @Test
  public void testStringComparisonEquals() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = \'foo\' == \'foo\' ");
    this.assertResult(_builder, 0, Boolean.valueOf(true));
  }
  
  @Test
  public void testStringComparisonLess() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = \'foa\' < \'foo\' ");
    this.assertResult(_builder, 0, Boolean.valueOf(true));
  }
  
  @Test
  public void testIntComparisonEquals() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 5 == (1+4) ");
    this.assertResult(_builder, 0, Boolean.valueOf(true));
  }
  
  @Test
  public void testIntComparisonLess() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 5 < 10 ");
    this.assertResult(_builder, 0, Boolean.valueOf(true));
  }
  
  @Test
  public void testIntPlus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 5 + 10 ");
    this.assertResult(_builder, 0, Integer.valueOf(15));
  }
  
  @Test
  public void testStringPlus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = \'foo\' + \'bar\' ");
    this.assertResult(_builder, 0, "foobar");
  }
  
  @Test
  public void testMixedPlus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = \'foo\' + 10 ");
    this.assertResult(_builder, 0, "foo10");
  }
  
  @Test
  public void testMixedPlusNonRequestedInt() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = \'10\' + (6 / 3) ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("InterpretPlus: [] |- \'10\' + (6 / 3) ~> \'102\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretStringLiteral: [] |- \'10\' ~> \'10\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretMultiOrDiv: [] |- 6 / 3 ~> 2");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretNumberLiteral: [\'expected\' <- IntType] |- 6 ~> 6");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretNumberLiteral: [\'expected\' <- IntType] |- 3 ~> 3");
    this.assertResultAndTrace(_builder, 0, "102", _builder_1);
  }
  
  @Test
  public void testMixedPlusRequestedInt() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = \'foo\' + \'10\' * (6 / 3) ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("InterpretPlus: [] |- \'foo\' + \'10\' * (6 / 3) ~> \'foo20\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretStringLiteral: [] |- \'foo\' ~> \'foo\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretMultiOrDiv: [] |- \'10\' * (6 / 3) ~> 20");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretStringLiteral: [\'expected\' <- IntType] |- \'10\' ~> 10");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretMultiOrDiv: [\'expected\' <- IntType] |- 6 / 3 ~> 2");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretNumberLiteral: [\'expected\' <- IntType] |- 6 ~> 6");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretNumberLiteral: [\'expected\' <- IntType] |- 3 ~> 3");
    this.assertResultAndTrace(_builder, 0, "foo20", _builder_1);
  }
  
  @Test
  public void testInterpreterVariableReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = true && \'true\'");
    _builder.newLine();
    _builder.append("i = b && (false || b)");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("InterpretAndOr: [] |- b && (false || b) ~> true");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretVariableRefenrence: [\'expected\' <- BooleanType] |- b ~> true");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretAndOr: [\'expected\' <- BooleanType] |- true && \'true\' ~> true");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretBooleanLiteral: [\'expected\' <- BooleanType] |- true ~> true");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretStringLiteral: [\'expected\' <- BooleanType] |- \'true\' ~> true");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretAndOr: [\'expected\' <- BooleanType] |- false || b ~> true");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretBooleanLiteral: [\'expected\' <- BooleanType] |- false ~> false");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretVariableRefenrence: [\'expected\' <- BooleanType] |- b ~> true");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretAndOr: [\'expected\' <- BooleanType] |- true && \'true\' ~> true");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("InterpretBooleanLiteral: [\'expected\' <- BooleanType] |- true ~> true");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("InterpretStringLiteral: [\'expected\' <- BooleanType] |- \'true\' ~> true");
    this.assertResultAndTrace(_builder, 1, Boolean.valueOf(true), _builder_1);
  }
  
  @Test
  public void testInterpretAndOfComparisons() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("d = (1 < 2) && (\'f0\' == (\'f\' + 0))");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("InterpretAndOr: [] |- (1 < 2) && (\'f0\' == (\'f\' + 0)) ~> true");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretComparison: [\'expected\' <- BooleanType] |- 1 < 2 ~> true");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretNumberLiteral: [] |- 1 ~> 1");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretNumberLiteral: [] |- 2 ~> 2");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretEquals: [\'expected\' <- BooleanType] |- \'f0\' == (\'f\' + 0) ~> true");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretStringLiteral: [] |- \'f0\' ~> \'f0\'");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretPlus: [] |- \'f\' + 0 ~> \'f0\'");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretStringLiteral: [] |- \'f\' ~> \'f\'");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretNumberLiteral: [] |- 0 ~> 0");
    this.assertResultAndTrace(_builder, 0, Boolean.valueOf(true), _builder_1);
  }
  
  public void assertResult(final CharSequence program, final int variableIndex, final Object expectedResult) {
    this.assertResultAndTrace(program, variableIndex, expectedResult, null);
  }
  
  public void assertResultAndTrace(final CharSequence program, final int variableIndex, final Object expectedResult, final CharSequence expectedTrace) {
    try {
      Model _parse = this._parseHelper.parse(program);
      EList<Variable> _variables = _parse.getVariables();
      Variable _get = _variables.get(variableIndex);
      final Expression expression = _get.getExpression();
      final Result<Object> result = this.semantics.interpret(null, this.trace, expression);
      boolean _failed = result.failed();
      if (_failed) {
        RuleFailedException _ruleFailedException = result.getRuleFailedException();
        String _failureTraceAsString = this._traceUtils.failureTraceAsString(_ruleFailedException);
        String _plus = ("unexpected failure: " + _failureTraceAsString);
        Assert.fail(_plus);
      }
      String _string = expectedResult.toString();
      Object _value = result.getValue();
      String _string_1 = _value.toString();
      Assert.assertEquals(_string, _string_1);
      boolean _notEquals = ObjectExtensions.operator_notEquals(expectedTrace, null);
      if (_notEquals) {
        String _string_2 = expectedTrace.toString();
        String _traceAsString = this._traceUtils.traceAsString(this.trace);
        Assert.assertEquals(_string_2, _traceAsString);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
