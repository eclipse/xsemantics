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

@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
public class LambdaTermUtilsTest extends LambdaBaseTest {
  @Test
  public void testExplicitType() {
    this.assertCloneWithoutTypes("lambda x : int . x", "lambda x . (x)");
  }
  
  @Test
  public void testExplicitTypes() {
    this.assertCloneWithoutTypes("lambda x : int . lambda y : a -> b . y x", "lambda x . (lambda y . ((y x)))");
  }
  
  @Test
  public void testNoTypes() {
    this.assertCloneWithoutTypes("lambda x . lambda y . y x", "lambda x . (lambda y . ((y x)))");
  }
  
  public void assertCloneWithoutTypes(final CharSequence original, final CharSequence expected) {
      Program _parseAndAssertNoError = this.parseAndAssertNoError(original);
      final Program program = _parseAndAssertNoError;
      String _string = this.reprForSubstitutions.string(program);
      final String beforeCloning = _string;
      Term _term = program.getTerm();
      Term _cloneWithoutTypes = LambdaTermUtils.cloneWithoutTypes(_term);
      final Term clone = _cloneWithoutTypes;
      String _string_1 = expected.toString();
      String _string_2 = this.reprForSubstitutions.string(clone);
      Assert.assertEquals(_string_1, _string_2);
      String _string_3 = this.reprForSubstitutions.string(program);
      Assert.assertEquals(beforeCloning, _string_3);
  }
}
