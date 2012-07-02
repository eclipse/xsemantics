package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.typing.XsemanticsTypingSystem;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.List;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsTypingTest extends XsemanticsBaseTest {
  @Inject
  protected XsemanticsTypingSystem typingSystem;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Test
  public void testRuleParameterTypes() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    this.assertRuleConclusionTypes(_testSimpleRule, EClass.class, EObject.class);
  }
  
  @Test
  public void testRuleConclusionTypesWithExpressions() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    this.assertRuleConclusionTypes(_testRuleWithExpressionInConclusion, EClass.class, EObject.class);
  }
  
  @Test
  public void testRuleInvocation() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    this.assertRuleInvocationTypes(_testRuleInvokingAnotherRule, 0, EClass.class, EClass.class);
  }
  
  @Test
  public void testBooleanBinaryOr() {
    XAbstractFeatureCall _xAbstractFeatureCall = this.getXAbstractFeatureCall(0);
    this.checkBooleanPremise(_xAbstractFeatureCall);
  }
  
  @Test
  public void testBooleanBinaryAnd() {
    XAbstractFeatureCall _xAbstractFeatureCall = this.getXAbstractFeatureCall(1);
    this.checkBooleanPremise(_xAbstractFeatureCall);
  }
  
  @Test
  public void testBooleanBinaryEquals() {
    XAbstractFeatureCall _xAbstractFeatureCall = this.getXAbstractFeatureCall(2);
    this.checkBooleanPremise(_xAbstractFeatureCall);
  }
  
  @Test
  public void testBooleanBinaryNotEquals() {
    XAbstractFeatureCall _xAbstractFeatureCall = this.getXAbstractFeatureCall(3);
    this.checkBooleanPremise(_xAbstractFeatureCall);
  }
  
  @Test
  public void testBooleanBinaryPlus() {
    XAbstractFeatureCall _xAbstractFeatureCall = this.getXAbstractFeatureCall(4);
    this.checkNotBooleanPremise(_xAbstractFeatureCall);
  }
  
  @Test
  public void testBooleanMethodCall() {
    XAbstractFeatureCall _xAbstractFeatureCall = this.getXAbstractFeatureCall(5);
    this.checkBooleanPremise(_xAbstractFeatureCall);
  }
  
  @Test
  public void testNotBooleanMethodCall() {
    XAbstractFeatureCall _xAbstractFeatureCall = this.getXAbstractFeatureCall(6);
    this.checkNotBooleanPremise(_xAbstractFeatureCall);
  }
  
  @Test
  public void testBooleanNegation() {
    XAbstractFeatureCall _xAbstractFeatureCall = this.getXAbstractFeatureCall(7);
    this.checkBooleanPremise(_xAbstractFeatureCall);
  }
  
  @Test
  public void testNotBooleanVariableDeclaration() {
    CharSequence _testForBooleanVariableDeclaration = this.testFiles.testForBooleanVariableDeclaration();
    XVariableDeclaration _firstVariableDeclaration = this.firstVariableDeclaration(_testForBooleanVariableDeclaration);
    this.checkNotBooleanPremise(_firstVariableDeclaration);
  }
  
  @Test
  public void testNotBooleanAssignment() {
    CharSequence _testForNonBooleanPremises = this.testFiles.testForNonBooleanPremises();
    XAssignment _firstAssignment = this.firstAssignment(_testForNonBooleanPremises);
    this.checkNotBooleanPremise(_firstAssignment);
  }
  
  @Test
  public void testNotBooleanIf() {
    CharSequence _testForNonBooleanPremises = this.testFiles.testForNonBooleanPremises();
    XIfExpression _firstIf = this.firstIf(_testForNonBooleanPremises);
    this.checkNotBooleanPremise(_firstIf);
  }
  
  @Test
  public void testNotBooleanFor() {
    CharSequence _testForNonBooleanPremises = this.testFiles.testForNonBooleanPremises();
    XForLoopExpression _firstFor = this.firstFor(_testForNonBooleanPremises);
    this.checkNotBooleanPremise(_firstFor);
  }
  
  @Test
  public void testEnvironmentAccess() {
    String _name = EClass.class.getName();
    CharSequence _testWithEnvironmentAccess = this.testFiles.testWithEnvironmentAccess();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testWithEnvironmentAccess);
    EnvironmentAccess _environmentAccess = this.getEnvironmentAccess(_parseAndAssertNoError);
    JvmTypeReference _type = this.typingSystem.getType(_environmentAccess);
    String _identifier = _type.getIdentifier();
    this.assertEqualsStrings(_name, _identifier);
  }
  
  public void checkBooleanPremise(final XAbstractFeatureCall featureCall) {
    String _string = featureCall.toString();
    boolean _isBooleanPremise = this.typingSystem.isBooleanPremise(featureCall);
    Assert.assertTrue(_string, _isBooleanPremise);
  }
  
  public void checkNotBooleanPremise(final XExpression expression) {
    String _string = expression.toString();
    boolean _isBooleanPremise = this.typingSystem.isBooleanPremise(expression);
    Assert.assertFalse(_string, _isBooleanPremise);
  }
  
  public void assertRuleConclusionTypes(final CharSequence source, final Class leftClass, final Class rightClass) {
    Rule _firstRule = this.getFirstRule(source);
    final RuleConclusion conclusion = _firstRule.getConclusion();
    String _name = leftClass.getName();
    EList<RuleConclusionElement> _conclusionElements = conclusion.getConclusionElements();
    RuleConclusionElement _get = _conclusionElements.get(0);
    JvmTypeReference _type = this.typingSystem.getType(_get);
    String _identifier = _type.getIdentifier();
    Assert.assertEquals(_name, _identifier);
    String _name_1 = rightClass.getName();
    EList<RuleConclusionElement> _conclusionElements_1 = conclusion.getConclusionElements();
    RuleConclusionElement _get_1 = _conclusionElements_1.get(1);
    JvmTypeReference _type_1 = this.typingSystem.getType(_get_1);
    String _identifier_1 = _type_1.getIdentifier();
    Assert.assertEquals(_name_1, _identifier_1);
  }
  
  public void assertRuleInvocationTypes(final CharSequence source, final int index, final Class leftClass, final Class rightClass) {
    Rule _firstRule = this.getFirstRule(source);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_firstRule);
    final RuleInvocation invocation = _ruleInvocations.get(index);
    String _name = leftClass.getName();
    EList<RuleInvocationExpression> _expressions = invocation.getExpressions();
    RuleInvocationExpression _get = _expressions.get(0);
    JvmTypeReference _type = this.typingSystem.getType(_get);
    String _identifier = _type.getIdentifier();
    Assert.assertEquals(_name, _identifier);
    String _name_1 = rightClass.getName();
    EList<RuleInvocationExpression> _expressions_1 = invocation.getExpressions();
    RuleInvocationExpression _get_1 = _expressions_1.get(1);
    JvmTypeReference _type_1 = this.typingSystem.getType(_get_1);
    String _identifier_1 = _type_1.getIdentifier();
    Assert.assertEquals(_name_1, _identifier_1);
  }
}
