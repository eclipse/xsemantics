package it.xsemantics.example.expressions.tests;

import it.xsemantics.example.expressions.tests.ExpressionsInjectorProviderFirst;
import it.xsemantics.example.expressions.tests.ExpressionsInterpreterTests;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ExpressionsInjectorProviderFirst.class)
@SuppressWarnings("all")
public class ExpressionsFirstInterpreterTests extends ExpressionsInterpreterTests {
  @Test
  public void testInterpreterAndOrWithString() {
  }
  
  @Test
  public void testInterpreterMultiWithString() {
  }
  
  @Test
  public void testInterpreterMinusWithString() {
  }
  
  @Test
  public void testSignedWithString() {
  }
  
  @Test
  public void testNegationWithString() {
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
    _builder_1.append("InterpretNumberLiteral: [] |- 6 ~> 6");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretNumberLiteral: [] |- 3 ~> 3");
    this.assertResultAndTrace(_builder, 0, "102", _builder_1);
  }
  
  @Test
  public void testMixedPlusRequestedInt() {
  }
  
  @Test
  public void testInterpreterVariableReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("b = true && true");
    _builder.newLine();
    _builder.append("i = b && (false || b)");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("InterpretAndOr: [] |- b && (false || b) ~> true");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretVariableRefenrence: [] |- b ~> true");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretAndOr: [] |- true && true ~> true");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretBooleanLiteral: [] |- true ~> true");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretBooleanLiteral: [] |- true ~> true");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretAndOr: [] |- false || b ~> true");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretBooleanLiteral: [] |- false ~> false");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretVariableRefenrence: [] |- b ~> true");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("InterpretAndOr: [] |- true && true ~> true");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("InterpretBooleanLiteral: [] |- true ~> true");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("InterpretBooleanLiteral: [] |- true ~> true");
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
    _builder_1.append("InterpretComparison: [] |- 1 < 2 ~> true");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretNumberLiteral: [] |- 1 ~> 1");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("InterpretNumberLiteral: [] |- 2 ~> 2");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("InterpretEquals: [] |- \'f0\' == (\'f\' + 0) ~> true");
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
}
