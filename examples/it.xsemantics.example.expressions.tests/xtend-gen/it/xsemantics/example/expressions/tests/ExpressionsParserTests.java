package it.xsemantics.example.expressions.tests;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.expressions.AndOrExpression;
import it.xsemantics.example.expressions.expressions.ArithmeticSigned;
import it.xsemantics.example.expressions.expressions.BooleanNegation;
import it.xsemantics.example.expressions.expressions.Comparison;
import it.xsemantics.example.expressions.expressions.Expression;
import it.xsemantics.example.expressions.expressions.Minus;
import it.xsemantics.example.expressions.expressions.Model;
import it.xsemantics.example.expressions.expressions.MultiOrDiv;
import it.xsemantics.example.expressions.expressions.Plus;
import it.xsemantics.example.expressions.expressions.Variable;
import it.xsemantics.example.expressions.tests.ExpressionsBaseTests;
import it.xsemantics.example.expressions.tests.ExpressionsInjectorProviderCustom;
import it.xsemantics.runtime.StringRepresentation;
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
public class ExpressionsParserTests extends ExpressionsBaseTests {
  @Inject
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  private StringRepresentation _stringRepresentation;
  
  @Test
  public void testExpressionAssociativity() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("&&");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("+");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("*");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("10");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("/");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("-");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("2");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("3");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("!");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("true");
      _builder.newLine();
      String _string = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("i = 1 * 10 + -2 / 3 < 1 && !true");
      _builder_1.newLine();
      Model _parse = this._parseHelper.parse(_builder_1);
      EList<Variable> _variables = _parse.getVariables();
      Variable _get = _variables.get(0);
      Expression _expression = _get.getExpression();
      String _expressionToString = this.expressionToString(_expression);
      Assert.assertEquals(_string, _expressionToString);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String expressionToString(final Expression expression) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (expression instanceof AndOrExpression) {
        final AndOrExpression _andOrExpression = (AndOrExpression)expression;
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _op = _andOrExpression.getOp();
        _builder.append(_op, "");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Expression _left = _andOrExpression.getLeft();
        String _expressionToString = this.expressionToString(_left);
        _builder.append(_expressionToString, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Expression _right = _andOrExpression.getRight();
        String _expressionToString_1 = this.expressionToString(_right);
        _builder.append(_expressionToString_1, "	");
        _builder.newLineIfNotEmpty();
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expression instanceof Comparison) {
        final Comparison _comparison = (Comparison)expression;
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _op = _comparison.getOp();
        _builder.append(_op, "");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Expression _left = _comparison.getLeft();
        String _expressionToString = this.expressionToString(_left);
        _builder.append(_expressionToString, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Expression _right = _comparison.getRight();
        String _expressionToString_1 = this.expressionToString(_right);
        _builder.append(_expressionToString_1, "	");
        _builder.newLineIfNotEmpty();
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expression instanceof Plus) {
        final Plus _plus = (Plus)expression;
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("+");
        _builder.newLine();
        _builder.append("\t");
        Expression _left = _plus.getLeft();
        String _expressionToString = this.expressionToString(_left);
        _builder.append(_expressionToString, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Expression _right = _plus.getRight();
        String _expressionToString_1 = this.expressionToString(_right);
        _builder.append(_expressionToString_1, "	");
        _builder.newLineIfNotEmpty();
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expression instanceof Minus) {
        final Minus _minus = (Minus)expression;
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("-");
        _builder.newLine();
        _builder.append("\t");
        Expression _left = _minus.getLeft();
        String _expressionToString = this.expressionToString(_left);
        _builder.append(_expressionToString, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Expression _right = _minus.getRight();
        String _expressionToString_1 = this.expressionToString(_right);
        _builder.append(_expressionToString_1, "	");
        _builder.newLineIfNotEmpty();
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expression instanceof MultiOrDiv) {
        final MultiOrDiv _multiOrDiv = (MultiOrDiv)expression;
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _op = _multiOrDiv.getOp();
        _builder.append(_op, "");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Expression _left = _multiOrDiv.getLeft();
        String _expressionToString = this.expressionToString(_left);
        _builder.append(_expressionToString, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Expression _right = _multiOrDiv.getRight();
        String _expressionToString_1 = this.expressionToString(_right);
        _builder.append(_expressionToString_1, "	");
        _builder.newLineIfNotEmpty();
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expression instanceof BooleanNegation) {
        final BooleanNegation _booleanNegation = (BooleanNegation)expression;
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("!");
        _builder.newLine();
        _builder.append("\t");
        Expression _expression = _booleanNegation.getExpression();
        String _expressionToString = this.expressionToString(_expression);
        _builder.append(_expressionToString, "	");
        _builder.newLineIfNotEmpty();
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expression instanceof ArithmeticSigned) {
        final ArithmeticSigned _arithmeticSigned = (ArithmeticSigned)expression;
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("-");
        _builder.newLine();
        _builder.append("\t");
        Expression _expression = _arithmeticSigned.getExpression();
        String _expressionToString = this.expressionToString(_expression);
        _builder.append(_expressionToString, "	");
        _builder.newLineIfNotEmpty();
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      String _string = this._stringRepresentation.string(expression);
      _switchResult = _string;
    }
    String _string = _switchResult.toString();
    return _string;
  }
}
