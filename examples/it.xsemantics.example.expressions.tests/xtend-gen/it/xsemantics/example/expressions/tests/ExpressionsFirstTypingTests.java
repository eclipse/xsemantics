package it.xsemantics.example.expressions.tests;

import it.xsemantics.example.expressions.tests.ExpressionsInjectorProviderFirst;
import it.xsemantics.example.expressions.tests.ExpressionsTypingTests;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ExpressionsInjectorProviderFirst.class)
@SuppressWarnings("all")
public class ExpressionsFirstTypingTests extends ExpressionsTypingTests {
  @Test
  public void testArithmeticSignedWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = -(\'1\')");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("failed: cannot type -(\'1\')");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("StringType cannot be assigned to IntType");
    this.assertResultAndTrace(_builder, 0, 
      null, _builder_1);
  }
  
  @Test
  public void testBooleanNegationWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = !(\'true\')");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("failed: cannot type !(\'true\')");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("StringType cannot be assigned to BooleanType");
    this.assertResultAndTrace(_builder, 0, null, _builder_1);
  }
  
  @Test
  public void testMultiWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 * -(\'1\' + 5)");
    this.assertResult(_builder, 0, null);
  }
  
  @Test
  public void testMinusWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = 10 - \'1\' ");
    this.assertResult(_builder, 0, null);
  }
  
  @Test
  public void testExpectedIntPlus() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = (10 + \'1\') * 5 ");
    this.assertResult(_builder, 0, null);
  }
  
  @Test
  public void testAndWithString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = true && (\'false\' || true)");
    this.assertResult(_builder, 0, null);
  }
  
  @Test
  public void testVariable() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i = true && (\'false\' || true)");
    _builder.newLine();
    _builder.append("j = i || true");
    this.assertResult(_builder, 1, null);
  }
}
