package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.typing.XsemanticsTypeProvider;
import it.xsemantics.dsl.xsemantics.Rule;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XExpression;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsTypeProviderTest extends XsemanticsBaseTest {
  @Inject
  protected XsemanticsTypeProvider typeProvider;
  
  @Test
  public void testStandardXExpression() {
    CharSequence _testRuleWithFeatureCallsForBinaryOps = this.testFiles.testRuleWithFeatureCallsForBinaryOps();
    this.assertExpressionType(_testRuleWithFeatureCallsForBinaryOps, 0, 
      "boolean");
  }
  
  @Test
  public void testRuleInvocation() {
    CharSequence _testRuleOnlyInvokingRules = this.testFiles.testRuleOnlyInvokingRules();
    this.assertExpressionType(_testRuleOnlyInvokingRules, 0, 
      "null");
  }
  
  @Test
  public void testEnvironmentAccess() {
    CharSequence _testWithEnvironmentAccess = this.testFiles.testWithEnvironmentAccess();
    this.assertExpressionType(_testWithEnvironmentAccess, 1, 
      "org.eclipse.emf.ecore.EClass");
  }
  
  public void assertExpressionType(final CharSequence prog, final int premiseIndex, final CharSequence expected) {
    Rule _ruleWithoutValidation = this.getRuleWithoutValidation(prog, 0);
    final XExpression exp = this.getPremise(_ruleWithoutValidation, premiseIndex);
    final JvmTypeReference type = this.typeProvider.getType(exp);
    String _identifier = type.getIdentifier();
    this.assertEqualsStrings(expected, _identifier);
  }
}
