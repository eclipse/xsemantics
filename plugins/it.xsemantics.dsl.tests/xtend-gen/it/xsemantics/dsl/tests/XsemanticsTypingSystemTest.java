package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.typing.XsemanticsTypingSystem;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsTypingSystemTest extends XsemanticsBaseTest {
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
  public void testRuleInvocationExpressions() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    this.assertRuleInvocationExpressionsTypes(_testRuleInvokingAnotherRule, 0, EClass.class, EClass.class);
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
    CharSequence _testWithEnvironmentAccess = this.testFiles.testWithEnvironmentAccess();
    this.assertPremiseType(_testWithEnvironmentAccess, 1, 
      "org.eclipse.emf.ecore.EClass");
  }
  
  @Test
  public void testStandardXVariableDeclaration() {
    CharSequence _testRuleWithFeatureCallsForBinaryOps = this.testFiles.testRuleWithFeatureCallsForBinaryOps();
    this.assertPremiseType(_testRuleWithFeatureCallsForBinaryOps, 8, 
      "org.eclipse.emf.ecore.EClass");
  }
  
  @Test
  public void testExpressionInConclusion() {
    CharSequence _testAxiomWithExpressionInConclusion = this.testFiles.testAxiomWithExpressionInConclusion();
    Rule _ruleWithoutValidation = this.getRuleWithoutValidation(_testAxiomWithExpressionInConclusion, 0);
    ExpressionInConclusion _expressionInConclusion = this.expressionInConclusion(_ruleWithoutValidation, 0);
    this.assertEObjectType(_expressionInConclusion, 
      "org.eclipse.emf.ecore.EClass");
  }
  
  @Test
  public void testInputParameter() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    JudgmentDescription _firstJudgmentDescription = this.firstJudgmentDescription(_testSimpleRule);
    EList<JudgmentParameter> _judgmentParameters = _firstJudgmentDescription.getJudgmentParameters();
    JudgmentParameter _head = IterableExtensions.<JudgmentParameter>head(_judgmentParameters);
    this.assertEObjectType(_head, 
      "org.eclipse.emf.ecore.EClass");
  }
  
  @Test
  public void testOutputParameter() {
    CharSequence _testJudgmentDescriptionsReferringToEcoreWithOutput = this.testFiles.testJudgmentDescriptionsReferringToEcoreWithOutput();
    JudgmentDescription _firstJudgmentDescription = this.firstJudgmentDescription(_testJudgmentDescriptionsReferringToEcoreWithOutput);
    EList<JudgmentParameter> _judgmentParameters = _firstJudgmentDescription.getJudgmentParameters();
    JudgmentParameter _get = _judgmentParameters.get(1);
    this.assertEObjectType(_get, 
      "org.eclipse.emf.ecore.EObject");
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
  
  public void assertRuleInvocationExpressionsTypes(final CharSequence source, final int index, final Class leftClass, final Class rightClass) {
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
  
  public void assertPremiseType(final CharSequence prog, final int premiseIndex, final CharSequence expected) {
    Rule _ruleWithoutValidation = this.getRuleWithoutValidation(prog, 0);
    XExpression _premise = this.getPremise(_ruleWithoutValidation, premiseIndex);
    this.assertEObjectType(_premise, expected);
  }
  
  public void assertEObjectType(final EObject o, final CharSequence expected) {
    final JvmTypeReference type = this.typingSystem.getType(o);
    String _identifier = type.getIdentifier();
    this.assertEqualsStrings(expected, _identifier);
  }
}
