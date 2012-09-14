package it.xsemantics.example.fj.tests;

import com.google.inject.Inject;
import it.xsemantics.example.fj.FJInjectorProvider;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.tests.FjBaseTests;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = FJInjectorProvider.class)
@SuppressWarnings("all")
public class FjParserTests extends FjBaseTests {
  @Inject
  private ParseHelper<Program> _parseHelper;
  
  @Inject
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testExpressionAssociativity() {
    try {
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
      Program _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
