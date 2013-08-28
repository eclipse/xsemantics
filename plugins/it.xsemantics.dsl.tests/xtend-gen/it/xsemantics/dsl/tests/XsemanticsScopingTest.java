package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.EnvironmentMapping;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsScopingTest extends XsemanticsBaseTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testScopingForParameters() {
    CharSequence _testScopingForParameters = this.testFiles.testScopingForParameters();
    final XsemanticsSystem system = this.parse(_testScopingForParameters);
    this._validationTestHelper.assertNoErrors(system);
    EList<Rule> _rules = system.getRules();
    Rule _head = IterableExtensions.<Rule>head(_rules);
    XExpression _premises = ((RuleWithPremises) _head).getPremises();
    final XBlockExpression xBlockExpression = ((XBlockExpression) _premises);
    EList<XExpression> _expressions = xBlockExpression.getExpressions();
    XExpression _head_1 = IterableExtensions.<XExpression>head(_expressions);
    final XExpression leftOperandReferringToOutputParam = ((XBinaryOperation) _head_1).getLeftOperand();
    EList<XExpression> _expressions_1 = xBlockExpression.getExpressions();
    XExpression _get = _expressions_1.get(1);
    final XExpression leftOperandReferringToInputParam = ((XBinaryOperation) _get).getLeftOperand();
    JvmIdentifiableElement _feature = ((XMemberFeatureCall) leftOperandReferringToInputParam).getFeature();
    String _identifier = _feature.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.EObject.eContainer()", _identifier);
    JvmIdentifiableElement _feature_1 = ((XMemberFeatureCall) leftOperandReferringToOutputParam).getFeature();
    String _identifier_1 = _feature_1.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.ENamedElement.getName()", _identifier_1);
  }
  
  @Test
  public void testScopingForVariableAsOutputParam() {
    CharSequence _testScopingForVariableDeclarationAsOutputArgument = this.testFiles.testScopingForVariableDeclarationAsOutputArgument();
    final XsemanticsSystem system = this.parse(_testScopingForVariableDeclarationAsOutputArgument);
    EList<Rule> _rules = system.getRules();
    Rule _head = IterableExtensions.<Rule>head(_rules);
    XExpression _premises = ((RuleWithPremises) _head).getPremises();
    final XBlockExpression xBlockExpression = ((XBlockExpression) _premises);
    EList<XExpression> _expressions = xBlockExpression.getExpressions();
    XExpression _get = _expressions.get(1);
    final XExpression leftOperandReferringToOutputParam = ((XBinaryOperation) _get).getLeftOperand();
    JvmIdentifiableElement _feature = ((XMemberFeatureCall) leftOperandReferringToOutputParam).getFeature();
    String _identifier = _feature.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.ENamedElement.getName()", _identifier);
  }
  
  @Test
  public void testScopingForExpressionInConclusion() {
    CharSequence _testAxiomWithExpressionInConclusion = this.testFiles.testAxiomWithExpressionInConclusion();
    Rule _ruleWithoutValidation = this.getRuleWithoutValidation(_testAxiomWithExpressionInConclusion, 0);
    ExpressionInConclusion _expressionInConclusion = this.expressionInConclusion(_ruleWithoutValidation, 0);
    final XExpression expInConcl = _expressionInConclusion.getExpression();
    final JvmIdentifiableElement feature = ((XMemberFeatureCall) expInConcl).getFeature();
    String _identifier = feature.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.EObject.eClass()", _identifier);
  }
  
  @Test
  public void testScopingForErrorSpecificationInJudgment() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    XsemanticsSystem _parse = this.parse(_testJudgmentDescriptionsWithErrorSpecification);
    EList<JudgmentDescription> _judgmentDescriptions = _parse.getJudgmentDescriptions();
    JudgmentDescription _head = IterableExtensions.<JudgmentDescription>head(_judgmentDescriptions);
    XExpression _error = _head.getError();
    final ErrorSpecification errSpec = ((ErrorSpecification) _error);
    XExpression _feature = errSpec.getFeature();
    final JvmIdentifiableElement feature = ((XMemberFeatureCall) _feature).getFeature();
    String _identifier = feature.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.EObject.eContainingFeature()", _identifier);
  }
  
  @Test
  public void testScopingForErrorSpecificationInRule() {
    CharSequence _testRuleWithErrorSpecifications = this.testFiles.testRuleWithErrorSpecifications();
    XsemanticsSystem _parse = this.parse(_testRuleWithErrorSpecifications);
    EList<Rule> _rules = _parse.getRules();
    Rule _head = IterableExtensions.<Rule>head(_rules);
    RuleConclusion _conclusion = _head.getConclusion();
    XExpression _error = _conclusion.getError();
    final ErrorSpecification errSpec = ((ErrorSpecification) _error);
    XExpression _feature = errSpec.getFeature();
    final JvmIdentifiableElement feature = ((XMemberFeatureCall) _feature).getFeature();
    String _identifier = feature.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.EObject.eContainingFeature()", _identifier);
  }
  
  @Test
  public void testScopingForEnvironmentMapping() {
    CharSequence _testSingleEnvironmentMapping = this.testFiles.testSingleEnvironmentMapping();
    final XsemanticsSystem system = this.parse(_testSingleEnvironmentMapping);
    EList<Rule> _rules = system.getRules();
    Rule _head = IterableExtensions.<Rule>head(_rules);
    XExpression _premises = ((RuleWithPremises) _head).getPremises();
    final XBlockExpression xBlockExpression = ((XBlockExpression) _premises);
    EList<XExpression> _expressions = xBlockExpression.getExpressions();
    XExpression _head_1 = IterableExtensions.<XExpression>head(_expressions);
    final RuleInvocation ruleInvk = ((RuleInvocation) _head_1);
    EnvironmentSpecification _environment = ruleInvk.getEnvironment();
    final EnvironmentMapping envMapping = ((EnvironmentMapping) _environment);
    XExpression _value = envMapping.getValue();
    final JvmIdentifiableElement feature = ((XFeatureCall) _value).getFeature();
    String _identifier = feature.getIdentifier();
    this.assertEqualsStrings("object", _identifier);
  }
  
  @Test
  public void testScopingForEnvironmentAccess() {
    CharSequence _testWithEnvironmentAccess = this.testFiles.testWithEnvironmentAccess();
    final XsemanticsSystem system = this.parse(_testWithEnvironmentAccess);
    EList<Rule> _rules = system.getRules();
    Rule _head = IterableExtensions.<Rule>head(_rules);
    XExpression _premises = ((RuleWithPremises) _head).getPremises();
    final XBlockExpression xBlockExpression = ((XBlockExpression) _premises);
    EList<XExpression> _expressions = xBlockExpression.getExpressions();
    XExpression _get = _expressions.get(3);
    final EnvironmentAccess envAccess = ((EnvironmentAccess) _get);
    XExpression _argument = envAccess.getArgument();
    final JvmIdentifiableElement feature = ((XMemberFeatureCall) _argument).getFeature();
    String _identifier = feature.getIdentifier();
    this.assertEqualsStrings("org.eclipse.emf.ecore.ENamedElement.getName()", _identifier);
  }
}
