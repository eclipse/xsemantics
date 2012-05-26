package it.xsemantics.example.expressions.tests;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.example.expressions.expressions.Expression;
import it.xsemantics.example.expressions.expressions.Model;
import it.xsemantics.example.expressions.expressions.Type;
import it.xsemantics.example.expressions.expressions.Variable;
import it.xsemantics.example.expressions.tests.ExpressionsBaseTests;
import it.xsemantics.example.expressions.tests.ExpressionsInjectorProviderCustom;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.StringRepresentation;
import it.xsemantics.runtime.util.TraceUtils;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ExpressionsInjectorProviderCustom.class)
@SuppressWarnings("all")
public class ExpressionsTypingTests extends ExpressionsBaseTests {
  @Inject
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  private TraceUtils _traceUtils;
  
  @Inject
  private StringRepresentation _stringRepresentation;
  
  @Test
  public void testInt() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 - 5 - 1");
    this.assertResult(_builder, 0, "IntType");
  }
  
  @Test
  public void testArithmeticSigned() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = -(1 + 5)");
    this.assertResult(_builder, 0, "IntType");
  }
  
  @Test
  public void testArithmeticSignedWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = -(\'1\')");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ArithmeticSigned: [] |- -(\'1\') : IntType");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("StringLiteral: [\'expected\' <- IntType] |- \'1\' : IntType");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("StringToInt: [\'expected\' <- IntType] |~ \'1\' |> IntType");
    this.assertResultAndTrace(_builder, 0, 
      "IntType", _builder_1);
  }
  
  @Test
  public void testArithmeticSignedWithStringWrong() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = -(\'zzz\')");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("failed: cannot type -(\'zzz\')");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("StringType cannot be assigned to IntType");
    this.assertResultAndTrace(_builder, 0, 
      null, _builder_1);
  }
  
  @Test
  public void testBooleanNegation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = !(true)");
    this.assertResult(_builder, 0, "BooleanType");
  }
  
  @Test
  public void testBooleanNegationWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = !(\'true\')");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("BooleanNegation: [] |- !(\'true\') : BooleanType");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("StringLiteral: [\'expected\' <- BooleanType] |- \'true\' : BooleanType");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("StringToBool: [\'expected\' <- BooleanType] |~ \'true\' |> BooleanType");
    this.assertResultAndTrace(_builder, 0, "BooleanType", _builder_1);
  }
  
  @Test
  public void testBooleanNegationWithStringWrong() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = !(\'abc\')");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("failed: cannot type !(\'abc\')");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("StringType cannot be assigned to BooleanType");
    this.assertResultAndTrace(_builder, 0, null, _builder_1);
  }
  
  @Test
  public void testMulti() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 * -(1 + 5)");
    this.assertResult(_builder, 0, "IntType");
  }
  
  @Test
  public void testMultiWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 * -(\'1\' + 5)");
    this.assertResult(_builder, 0, "IntType");
  }
  
  @Test
  public void testMinus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 - -(1 + 5)");
    this.assertResult(_builder, 0, "IntType");
  }
  
  @Test
  public void testMinusWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 - \'1\' ");
    this.assertResult(_builder, 0, "IntType");
  }
  
  @Test
  public void testIntPlus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 + 5 ");
    this.assertResult(_builder, 0, "IntType");
  }
  
  @Test
  public void testStringPlus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 + \'foo\' ");
    this.assertResult(_builder, 0, "StringType");
  }
  
  @Test
  public void testExpectedIntPlus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = (10 + \'1\') * 5 ");
    this.assertResult(_builder, 0, "IntType");
  }
  
  @Test
  public void testAnd() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = true && (false || true)");
    this.assertResult(_builder, 0, "BooleanType");
  }
  
  @Test
  public void testAndWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = true && (\'false\' || true)");
    this.assertResult(_builder, 0, "BooleanType");
  }
  
  @Test
  public void testVariable() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = true && (\'false\' || true)");
    _builder.newLine();
    _builder.append("j = i || true");
    this.assertResult(_builder, 1, "BooleanType");
  }
  
  public void assertResult(final CharSequence program, final int variableIndex, final String expectedResult) {
    this.assertResultAndTrace(program, variableIndex, expectedResult, null);
  }
  
  public void assertResultAndTrace(final CharSequence program, final int variableIndex, final String expectedResult, final CharSequence expectedTrace) {
    try {
      Model _parse = this._parseHelper.parse(program);
      EList<Variable> _variables = _parse.getVariables();
      Variable _get = _variables.get(variableIndex);
      final Expression expression = _get.getExpression();
      final Result<Type> result = this.semantics.type(null, this.trace, expression);
      boolean _notEquals = (!Objects.equal(expectedResult, null));
      if (_notEquals) {
        boolean _failed = result.failed();
        if (_failed) {
          RuleFailedException _ruleFailedException = result.getRuleFailedException();
          String _failureTraceAsString = this._traceUtils.failureTraceAsString(_ruleFailedException);
          String _plus = ("unexpected failure: " + _failureTraceAsString);
          Assert.fail(_plus);
        }
        Type _value = result.getValue();
        String _string = this._stringRepresentation.string(_value);
        Assert.assertEquals(expectedResult, _string);
        boolean _notEquals_1 = (!Objects.equal(expectedTrace, null));
        if (_notEquals_1) {
          String _string_1 = expectedTrace.toString();
          String _traceAsString = this._traceUtils.traceAsString(this.trace);
          Assert.assertEquals(_string_1, _traceAsString);
        }
      } else {
        boolean _failed_1 = result.failed();
        boolean _not = (!_failed_1);
        if (_not) {
          String _traceAsString_1 = this._traceUtils.traceAsString(this.trace);
          String _plus_1 = ("unexpected success: " + _traceAsString_1);
          Assert.fail(_plus_1);
        }
        boolean _notEquals_2 = (!Objects.equal(expectedTrace, null));
        if (_notEquals_2) {
          String _string_2 = expectedTrace.toString();
          RuleFailedException _ruleFailedException_1 = result.getRuleFailedException();
          String _failureTraceAsString_1 = this._traceUtils.failureTraceAsString(_ruleFailedException_1);
          Assert.assertEquals(_string_2, _failureTraceAsString_1);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
