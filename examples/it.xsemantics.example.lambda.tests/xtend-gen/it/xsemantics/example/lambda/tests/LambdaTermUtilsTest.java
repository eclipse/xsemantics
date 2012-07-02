package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.Term;
import it.xsemantics.example.lambda.tests.LambdaBaseTest;
import it.xsemantics.example.lambda.tests.LambdaInjectorWithNonBeautifiedTypesProvider;
import it.xsemantics.example.lambda.xsemantics.LambdaTermUtils;
import junit.framework.Assert;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = LambdaInjectorWithNonBeautifiedTypesProvider.class)
@SuppressWarnings("all")
public class LambdaTermUtilsTest extends LambdaBaseTest {
  @Test
  public void testExplicitType() {
    this.assertCloneWithoutTypes("lambda x : int . x", "lambda x . (x)");
  }
  
  @Test
  public void testExplicitTypes() {
    this.assertCloneWithoutTypes(
      "lambda x : int . lambda y : a -> b . y x", 
      "lambda x . (lambda y . ((y x)))");
  }
  
  @Test
  public void testNoTypes() {
    this.assertCloneWithoutTypes(
      "lambda x . lambda y . y x", 
      "lambda x . (lambda y . ((y x)))");
  }
  
  public void assertCloneWithoutTypes(final CharSequence original, final CharSequence expected) {
    final Program program = this.parseAndAssertNoError(original);
    final String beforeCloning = this.reprForSubstitutions.string(program);
    Term _term = program.getTerm();
    final Term clone = LambdaTermUtils.cloneWithoutTypes(_term);
    String _string = expected.toString();
    String _string_1 = this.reprForSubstitutions.string(clone);
    Assert.assertEquals(_string, _string_1);
    String _string_2 = this.reprForSubstitutions.string(program);
    Assert.assertEquals(beforeCloning, _string_2);
  }
}
