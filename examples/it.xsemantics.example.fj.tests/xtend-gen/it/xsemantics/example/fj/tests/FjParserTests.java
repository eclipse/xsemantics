package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.FJInjectorProvider;
import it.xsemantics.example.fj.tests.FjBaseTests;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = FJInjectorProvider.class)
@SuppressWarnings("all")
public class FjParserTests extends FjBaseTests {
  @Test
  public void testParsing() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int myInt;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int getMyInt() { return this.myInt; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.parseAndAssertNoError(_builder);
  }
}
