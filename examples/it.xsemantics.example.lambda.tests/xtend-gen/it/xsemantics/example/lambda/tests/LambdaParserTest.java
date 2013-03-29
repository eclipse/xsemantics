package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.LambdaInjectorProvider;
import it.xsemantics.example.lambda.tests.LambdaBaseTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorProvider.class)
@SuppressWarnings("all")
public class LambdaParserTest extends LambdaBaseTest {
  @Test
  public void testParsingAndLinking() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("lambda x . lambda y . x y");
    _builder.newLine();
    this.parseAndAssertNoError(_builder);
  }
}
