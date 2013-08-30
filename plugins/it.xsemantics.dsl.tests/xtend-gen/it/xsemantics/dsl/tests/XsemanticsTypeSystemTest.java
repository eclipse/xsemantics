package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.typing.TupleType;
import it.xsemantics.dsl.typing.XsemanticsTypeSystem;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.List;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsTypeSystemTest extends XsemanticsBaseTest {
  @Inject
  protected XsemanticsTypeSystem typeSystem;
  
  @Inject
  @Extension
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  protected TypeReferences typeReferences;
  
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
  
  @Test
  public void testEObjectSubtyping() {
    this.assertSubtyping(Notifier.class, EObject.class);
  }
  
  @Test
  public void testObjectSubtyping() {
    this.assertSubtyping(Object.class, EObject.class);
  }
  
  @Test
  public void testNotEquals() {
    this.assertEquals(Notifier.class, EObject.class, false);
  }
  
  @Test
  public void testEquals() {
    this.assertEquals(EObject.class, EObject.class, true);
  }
  
  @Test
  public void testIsEObject() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(XsemanticsSystem.class, ts);
    boolean _isEObject = this.typeSystem.isEObject(_typeForName, ts);
    Assert.assertTrue(_isEObject);
  }
  
  @Test
  public void testIsEObjectFails() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(String.class, ts);
    boolean _isEObject = this.typeSystem.isEObject(_typeForName, ts);
    Assert.assertFalse(_isEObject);
  }
  
  @Test
  public void testIsEStructuralFeature() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(EAttribute.class, ts);
    boolean _isEStructuralFeature = this.typeSystem.isEStructuralFeature(_typeForName, ts);
    Assert.assertTrue(_isEStructuralFeature);
  }
  
  @Test
  public void testIsEStructuralFeatureFails() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(XsemanticsSystem.class, ts);
    boolean _isEStructuralFeature = this.typeSystem.isEStructuralFeature(_typeForName, ts);
    Assert.assertFalse(_isEStructuralFeature);
  }
  
  @Test
  public void testTupleTypeNotEqualsDifferentSize() {
    TupleType _tupleType = new TupleType();
    final TupleType tupleType = _tupleType;
    JvmTypeReference _typeForName = this.typeForName(EAttribute.class);
    tupleType.add(_typeForName);
    TupleType _tupleType_1 = new TupleType();
    XsemanticsSystem _fakeContext = this.fakeContext();
    boolean _equals = this.typeSystem.equals(_tupleType_1, tupleType, _fakeContext);
    Assert.assertFalse(_equals);
  }
  
  @Test
  public void testTupleTypeEquals() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(EClass.class, ts);
    final TupleType tupleType1 = this.tupleType(_typeForName, _typeForName_1);
    JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(EClass.class, ts);
    final TupleType tupleType2 = this.tupleType(_typeForName_2, _typeForName_3);
    boolean _equals = this.typeSystem.equals(tupleType2, tupleType1, ts);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void testTupleTypeNotEquals() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(EClass.class, ts);
    final TupleType tupleType1 = this.tupleType(_typeForName, _typeForName_1);
    JvmTypeReference _typeForName_2 = this.typeReferences.getTypeForName(EObject.class, ts);
    JvmTypeReference _typeForName_3 = this.typeReferences.getTypeForName(Notifier.class, ts);
    final TupleType tupleType2 = this.tupleType(_typeForName_2, _typeForName_3);
    XsemanticsSystem _fakeContext = this.fakeContext();
    boolean _equals = this.typeSystem.equals(tupleType2, tupleType1, _fakeContext);
    Assert.assertFalse(_equals);
  }
  
  private XsemanticsSystem fakeContext() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    XsemanticsSystem _parse = this.parse(_testRuleWithExpressionInConclusion);
    return _parse;
  }
  
  @Test
  public void testJudgmentDescriptionsEquals() {
    CharSequence _testForJudgmentParameters = this.testFiles.testForJudgmentParameters();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testForJudgmentParameters);
    final EList<JudgmentDescription> judgments = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = judgments.get(0);
    JudgmentDescription _get_1 = judgments.get(1);
    boolean _equals = this.typeSystem.equals(_get, _get_1);
    Assert.assertTrue(_equals);
    JudgmentDescription _get_2 = judgments.get(0);
    JudgmentDescription _get_3 = judgments.get(2);
    boolean _equals_1 = this.typeSystem.equals(_get_2, _get_3);
    Assert.assertFalse(_equals_1);
    JudgmentDescription _get_4 = judgments.get(0);
    JudgmentDescription _get_5 = judgments.get(3);
    boolean _equals_2 = this.typeSystem.equals(_get_4, _get_5);
    Assert.assertFalse(_equals_2);
  }
  
  public void checkBooleanPremise(final XAbstractFeatureCall featureCall) {
    String _string = featureCall.toString();
    boolean _isBooleanPremise = this.typeSystem.isBooleanPremise(featureCall);
    Assert.assertTrue(_string, _isBooleanPremise);
  }
  
  public void checkNotBooleanPremise(final XExpression expression) {
    String _string = expression.toString();
    boolean _isBooleanPremise = this.typeSystem.isBooleanPremise(expression);
    Assert.assertFalse(_string, _isBooleanPremise);
  }
  
  public void assertRuleConclusionTypes(final CharSequence source, final Class<? extends Object> leftClass, final Class<? extends Object> rightClass) {
    Rule _firstRule = this.getFirstRule(source);
    final RuleConclusion conclusion = _firstRule.getConclusion();
    String _name = leftClass.getName();
    EList<RuleConclusionElement> _conclusionElements = conclusion.getConclusionElements();
    RuleConclusionElement _get = _conclusionElements.get(0);
    JvmTypeReference _type = this.typeSystem.getType(_get);
    String _identifier = _type.getIdentifier();
    Assert.assertEquals(_name, _identifier);
    String _name_1 = rightClass.getName();
    EList<RuleConclusionElement> _conclusionElements_1 = conclusion.getConclusionElements();
    RuleConclusionElement _get_1 = _conclusionElements_1.get(1);
    JvmTypeReference _type_1 = this.typeSystem.getType(_get_1);
    String _identifier_1 = _type_1.getIdentifier();
    Assert.assertEquals(_name_1, _identifier_1);
  }
  
  public void assertRuleInvocationExpressionsTypes(final CharSequence source, final int index, final Class<? extends Object> leftClass, final Class<? extends Object> rightClass) {
    Rule _firstRule = this.getFirstRule(source);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_firstRule);
    final RuleInvocation invocation = _ruleInvocations.get(index);
    String _name = leftClass.getName();
    EList<XExpression> _expressions = invocation.getExpressions();
    XExpression _get = _expressions.get(0);
    JvmTypeReference _type = this.typeSystem.getType(_get);
    String _identifier = _type.getIdentifier();
    Assert.assertEquals(_name, _identifier);
    String _name_1 = rightClass.getName();
    EList<XExpression> _expressions_1 = invocation.getExpressions();
    XExpression _get_1 = _expressions_1.get(1);
    JvmTypeReference _type_1 = this.typeSystem.getType(_get_1);
    String _identifier_1 = _type_1.getIdentifier();
    Assert.assertEquals(_name_1, _identifier_1);
  }
  
  public void assertPremiseType(final CharSequence prog, final int premiseIndex, final CharSequence expected) {
    Rule _ruleWithoutValidation = this.getRuleWithoutValidation(prog, 0);
    XExpression _premise = this.getPremise(_ruleWithoutValidation, premiseIndex);
    this.assertEObjectType(_premise, expected);
  }
  
  public void assertEObjectType(final EObject o, final CharSequence expected) {
    final JvmTypeReference type = this.typeSystem.getType(o);
    String _identifier = type.getIdentifier();
    this.assertEqualsStrings(expected, _identifier);
  }
  
  public JvmTypeReference typeForName(final Class<? extends Object> clazz) {
    JvmTypeReference _xblockexpression = null;
    {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
      JvmTypeReference _typeForName = this.typeReferences.getTypeForName(clazz, ts);
      _xblockexpression = (_typeForName);
    }
    return _xblockexpression;
  }
  
  public TupleType tupleType(final JvmTypeReference c1, final JvmTypeReference c2) {
    TupleType _xblockexpression = null;
    {
      TupleType _tupleType = new TupleType();
      final TupleType tupleType = _tupleType;
      tupleType.add(c1);
      tupleType.add(c2);
      _xblockexpression = (tupleType);
    }
    return _xblockexpression;
  }
  
  public void assertSubtyping(final Class<? extends Object> expected, final Class<? extends Object> actual) {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(expected, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(actual, ts);
    boolean _isConformant = this.typeSystem.isConformant(_typeForName, _typeForName_1, ts);
    Assert.assertTrue(_isConformant);
  }
  
  public void assertEquals(final Class<? extends Object> left, final Class<? extends Object> right, final boolean expectedEquals) {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    final XsemanticsSystem ts = this.parse(_testRuleWithExpressionInConclusion);
    JvmTypeReference _typeForName = this.typeReferences.getTypeForName(left, ts);
    JvmTypeReference _typeForName_1 = this.typeReferences.getTypeForName(right, ts);
    this.assertEquals(_typeForName, _typeForName_1, expectedEquals, ts);
  }
  
  public void assertEquals(final JvmTypeReference left, final JvmTypeReference right, final boolean expectedEquals, final EObject context) {
    boolean _equals = this.typeSystem.equals(left, right, context);
    boolean _equals_1 = (_equals == expectedEquals);
    Assert.assertTrue(_equals_1);
  }
}
