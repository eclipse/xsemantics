package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.EnvironmentComposition;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Type;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsParserTest extends XsemanticsBaseTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private XsemanticsUtils _xsemanticsUtils;
  
  @Test
  public void testParsingOfName() {
    try {
      CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
      XsemanticsSystem _parse = this.parser.parse(_typeSystemQualifiedName);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingOfImports() {
    try {
      CharSequence _testFileWithImports = this.testFiles.testFileWithImports();
      XsemanticsSystem _parse = this.parser.parse(_testFileWithImports);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingOfJudgmentDescriptions() {
    try {
      CharSequence _testJudgmentDescriptions = this.testFiles.testJudgmentDescriptions();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptions);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingOfJudgmentDescriptions3() {
    try {
      CharSequence _testJudgmentDescriptions3 = this.testFiles.testJudgmentDescriptions3();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptions3);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingOfJudgmentDescriptionsWithOutput() {
    try {
      CharSequence _testJudgmentDescriptionsReferringToEcore3WithOutput = this.testFiles.testJudgmentDescriptionsReferringToEcore3WithOutput();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsReferringToEcore3WithOutput);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJudgmentDescriptionsRelatedToXtypes() {
    try {
      CharSequence _testJudgmentDescriptionsRelatedToXsemantics = this.testFiles.testJudgmentDescriptionsRelatedToXsemantics();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsRelatedToXsemantics);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJudgmentDescriptionsWithErrorSpecification() {
    try {
      CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsWithErrorSpecification);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJudgmentDescriptionsReferringToUnknownTypes() {
    try {
      CharSequence _testJudgmentDescriptionsReferringToUnknownTypes = this.testFiles.testJudgmentDescriptionsReferringToUnknownTypes();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsReferringToUnknownTypes);
      EClass _jvmParameterizedTypeReference = TypesPackage.eINSTANCE.getJvmParameterizedTypeReference();
      this._validationTestHelper.assertError(_parse, _jvmParameterizedTypeReference, 
        Diagnostic.LINKING_DIAGNOSTIC, 
        "Couldn\'t resolve reference to JvmType \'foo.bar.FooBar\'");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFjDescriptions() {
    try {
      CharSequence _fjJudgmentDescriptions = this.fjTestFiles.fjJudgmentDescriptions();
      final XsemanticsSystem typesystem = this.parser.parse(_fjJudgmentDescriptions);
      this._validationTestHelper.assertNoErrors(typesystem);
      List<JvmTypeReference> jvmReferences = this._xsemanticsUtils.getJvmTypes(typesystem);
      String _name = Expression.class.getName();
      JvmTypeReference _get = jvmReferences.get(0);
      String _identifier = _get.getIdentifier();
      Assert.assertEquals(_name, _identifier);
      String _name_1 = Type.class.getName();
      JvmTypeReference _get_1 = jvmReferences.get(1);
      String _identifier_1 = _get_1.getIdentifier();
      Assert.assertEquals(_name_1, _identifier_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJudgmentDescriptionsRelatedToEcore() {
    try {
      CharSequence _testJudgmentDescriptionsReferringToEcore = this.testFiles.testJudgmentDescriptionsReferringToEcore();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsReferringToEcore);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSimpleAxiom() {
    try {
      CharSequence _testSimpleAxiom = this.testFiles.testSimpleAxiom();
      XsemanticsSystem _parse = this.parser.parse(_testSimpleAxiom);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAxiomWithExpressionInConclusion() {
    try {
      CharSequence _testAxiomWithExpressionInConclusion = this.testFiles.testAxiomWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parser.parse(_testAxiomWithExpressionInConclusion);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSimpleRule() {
    try {
      CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
      XsemanticsSystem _parse = this.parser.parse(_testSimpleRule);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRuleWithExpressionInConclusion() {
    try {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parser.parse(_testRuleWithExpressionInConclusion);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRuleWithBlockExpressionInConclusion() {
    try {
      CharSequence _testRuleWithBlockExpressionInConclusion = this.testFiles.testRuleWithBlockExpressionInConclusion();
      XsemanticsSystem _parse = this.parser.parse(_testRuleWithBlockExpressionInConclusion);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRuleInvokingAnotherRule() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testRuleInvokingAnotherRule);
    this.checksForRuleInvocations(_parseAndAssertNoError);
  }
  
  @Test
  public void testRuleOnlyInvokingOtherRules() {
    CharSequence _testRuleOnlyInvokingRules = this.testFiles.testRuleOnlyInvokingRules();
    final XsemanticsSystem ts = this.parseAndAssertNoError(_testRuleOnlyInvokingRules);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
    int _size = _ruleInvocations.size();
    Assert.assertEquals(2, _size);
    EList<XExpression> expressions = this.getRulePremises(ts, 0);
    XExpression _get = expressions.get(0);
    this.assertIsInstance(RuleInvocation.class, _get);
    XExpression _get_1 = expressions.get(1);
    this.assertIsInstance(RuleInvocation.class, _get_1);
  }
  
  @Test
  public void testWithEnvironmentAccess() {
    CharSequence _testWithEnvironmentAccess = this.testFiles.testWithEnvironmentAccess();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testWithEnvironmentAccess);
    final EList<XExpression> premises = this.getRulePremises(_parseAndAssertNoError, 0);
    XExpression _get = premises.get(0);
    this.assertIsInstance(RuleInvocation.class, _get);
    XExpression _get_1 = premises.get(1);
    this.assertIsInstance(EnvironmentAccess.class, _get_1);
    XExpression _get_2 = premises.get(2);
    this.assertIsInstance(RuleInvocation.class, _get_2);
  }
  
  @Test
  public void testRuleInvokingAnotherRule3() {
    CharSequence _testRuleInvokingAnotherRule3 = this.testFiles.testRuleInvokingAnotherRule3();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testRuleInvokingAnotherRule3);
    this.checksForRuleInvocations(_parseAndAssertNoError);
  }
  
  @Test
  public void testRuleInvokingAnotherRuleWith3Params() {
    CharSequence _testRuleInvokingAnotherRuleWith3Params = this.testFiles.testRuleInvokingAnotherRuleWith3Params();
    this.parseAndAssertNoError(_testRuleInvokingAnotherRuleWith3Params);
  }
  
  public void checksForRuleInvocations(final XsemanticsSystem ts) {
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
    int _size = _ruleInvocations.size();
    Assert.assertEquals(2, _size);
    EList<XExpression> expressions = this.getRulePremises(ts, 0);
    XExpression _get = expressions.get(0);
    this.assertIsInstance(XBinaryOperation.class, _get);
    XExpression _get_1 = expressions.get(1);
    this.assertIsInstance(RuleInvocation.class, _get_1);
    XExpression _get_2 = expressions.get(2);
    this.assertIsInstance(RuleInvocation.class, _get_2);
    XExpression _get_3 = expressions.get(3);
    this.assertIsInstance(XVariableDeclaration.class, _get_3);
    XExpression _get_4 = expressions.get(4);
    this.assertIsInstance(XAssignment.class, _get_4);
    XExpression _get_5 = expressions.get(5);
    this.assertIsInstance(XUnaryOperation.class, _get_5);
    XExpression _get_6 = expressions.get(6);
    this.assertIsInstance(XBinaryOperation.class, _get_6);
    XExpression _get_7 = expressions.get(7);
    this.assertIsInstance(XBinaryOperation.class, _get_7);
  }
  
  @Test
  public void testRuleInvocationsWithOperatorsConflictingXbase() {
    CharSequence _testRuleInvocationsWithOperatorsConflictingXbase = this.testFiles.testRuleInvocationsWithOperatorsConflictingXbase();
    XsemanticsSystem ts = this.parseAndAssertNoError(_testRuleInvocationsWithOperatorsConflictingXbase);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
    int _size = _ruleInvocations.size();
    Assert.assertEquals(18, _size);
  }
  
  @Test
  public void testRuleWithErrorSpecifications() {
    CharSequence _testRuleWithErrorSpecifications = this.testFiles.testRuleWithErrorSpecifications();
    this.parseAndAssertNoError(_testRuleWithErrorSpecifications);
  }
  
  @Test
  public void testRuleWithSimpleErrorSpecifications() {
    CharSequence _testRuleWithSimpleErrorSpecifications = this.testFiles.testRuleWithSimpleErrorSpecifications();
    this.parseAndAssertNoError(_testRuleWithSimpleErrorSpecifications);
  }
  
  @Test
  public void testOrExpression() {
    CharSequence _testOrExpression = this.testFiles.testOrExpression();
    Rule _firstRule = this.getFirstRule(_testOrExpression);
    EList<XExpression> premises = this.getRulePremises(_firstRule);
    int _size = premises.size();
    Assert.assertEquals(1, _size);
    XExpression _get = premises.get(0);
    this.assertOrExpression(_get, 2);
  }
  
  @Test
  public void testOrExpression2() {
    CharSequence _testOrExpression2 = this.testFiles.testOrExpression2();
    Rule _firstRule = this.getFirstRule(_testOrExpression2);
    EList<XExpression> premises = this.getRulePremises(_firstRule);
    int _size = premises.size();
    Assert.assertEquals(3, _size);
    XExpression _get = premises.get(0);
    this.assertIsInstance(XBinaryOperation.class, _get);
    XExpression _get_1 = premises.get(1);
    this.assertOrExpression(_get_1, 2);
    XExpression _get_2 = premises.get(2);
    this.assertIsInstance(XBinaryOperation.class, _get_2);
  }
  
  @Test
  public void testOrExpressionWithBlocks() {
    CharSequence _testOrExpressionWithBlocks = this.testFiles.testOrExpressionWithBlocks();
    Rule _firstRule = this.getFirstRule(_testOrExpressionWithBlocks);
    EList<XExpression> premises = this.getRulePremises(_firstRule);
    int _size = premises.size();
    Assert.assertEquals(1, _size);
    XExpression _get = premises.get(0);
    this.assertOrExpression(_get, 2);
  }
  
  @Test
  public void testOrExpressionWithRuleInvocations() {
    CharSequence _testOrExpressionWithRuleInvocations = this.testFiles.testOrExpressionWithRuleInvocations();
    Rule _firstRule = this.getFirstRule(_testOrExpressionWithRuleInvocations);
    EList<XExpression> premises = this.getRulePremises(_firstRule);
    int _size = premises.size();
    Assert.assertEquals(1, _size);
    XExpression _get = premises.get(0);
    this.assertOrExpression(_get, 2);
  }
  
  @Test
  public void testOrExpressionWithRuleInvocations2() {
    CharSequence _testOrExpressionWithRuleInvocations2 = this.testFiles.testOrExpressionWithRuleInvocations2();
    Rule _firstRule = this.getFirstRule(_testOrExpressionWithRuleInvocations2);
    EList<XExpression> premises = this.getRulePremises(_firstRule);
    int _size = premises.size();
    Assert.assertEquals(1, _size);
    XExpression _get = premises.get(0);
    this.assertOrExpression(_get, 2);
  }
  
  @Test
  public void testOrExpressionWithManyBranches() {
    CharSequence _testOrExpressionWithManyBranches = this.testFiles.testOrExpressionWithManyBranches();
    Rule _firstRule = this.getFirstRule(_testOrExpressionWithManyBranches);
    EList<XExpression> premises = this.getRulePremises(_firstRule);
    int _size = premises.size();
    Assert.assertEquals(1, _size);
    XExpression _get = premises.get(0);
    this.assertOrExpression(_get, 2);
  }
  
  @Test
  public void testEmptyEnvironment() {
    CharSequence _testEmptyEnvironment = this.testFiles.testEmptyEnvironment();
    this.parseAndAssertNoError(_testEmptyEnvironment);
  }
  
  @Test
  public void testEnvironmentComposition() {
    CharSequence _testEnvironmentComposition = this.testFiles.testEnvironmentComposition();
    this.parseAndAssertNoError(_testEnvironmentComposition);
  }
  
  @Test
  public void testEnvironmentComposition2() {
    CharSequence _testEnvironmentComposition2 = this.testFiles.testEnvironmentComposition2();
    this.parseAndAssertNoError(_testEnvironmentComposition2);
  }
  
  @Test
  public void testSingleEnvironmentMapping() {
    CharSequence _testSingleEnvironmentMapping = this.testFiles.testSingleEnvironmentMapping();
    this.parseAndAssertNoError(_testSingleEnvironmentMapping);
  }
  
  @Test
  public void testEnvironmentMapping() {
    CharSequence _testEnvironmentCompositionWithMapping = this.testFiles.testEnvironmentCompositionWithMapping();
    this.parseAndAssertNoError(_testEnvironmentCompositionWithMapping);
  }
  
  @Test
  public void testEnvironmentMapping2() {
    CharSequence _testEnvironmentMapping2 = this.testFiles.testEnvironmentMapping2();
    Rule _firstRule = this.getFirstRule(_testEnvironmentMapping2);
    final RuleInvocation ruleInvocation = this.getRuleInvocationFromPremises(_firstRule);
    final EnvironmentSpecification envSpec = ruleInvocation.getEnvironment();
    this.assertIsInstance(EnvironmentComposition.class, envSpec);
    EnvironmentComposition _environmentComposition = this.getEnvironmentComposition(envSpec);
    EnvironmentSpecification _subEnvironment = _environmentComposition.getSubEnvironment();
    EnvironmentComposition _environmentComposition_1 = this.getEnvironmentComposition(_subEnvironment);
    EnvironmentSpecification _subEnvironment_1 = _environmentComposition_1.getSubEnvironment();
    this.getEnvironmentMapping(_subEnvironment_1);
  }
  
  @Test
  public void testCheckRule() {
    CharSequence _testCheckRule = this.testFiles.testCheckRule();
    this.parseAndAssertNoError(_testCheckRule);
  }
  
  @Test
  public void testStringRep() {
    CharSequence _testStringRep = this.testFiles.testStringRep();
    this.parseAndAssertNoError(_testStringRep);
  }
  
  @Test
  public void testForFail() {
    CharSequence _testForFail = this.testFiles.testForFail();
    this.parseAndAssertNoError(_testForFail);
  }
  
  @Test
  public void testForFailWithErrorSpecfication() {
    CharSequence _testForFailWithErrorSpecification = this.testFiles.testForFailWithErrorSpecification();
    this.parseAndAssertNoError(_testForFailWithErrorSpecification);
  }
  
  @Test
  public void testForClosures() {
    CharSequence _testForClosures = this.testFiles.testForClosures();
    this.parseAndAssertNoError(_testForClosures);
  }
  
  @Test
  public void testForScopeOfThisInRule() {
    CharSequence _testForScopeOfThisInRule = this.testFiles.testForScopeOfThisInRule();
    this.parseAndAssertNoError(_testForScopeOfThisInRule);
  }
  
  @Test
  public void testForScopeOfThisInClosure() {
    CharSequence _testForScopeOfThisInClosure = this.testFiles.testForScopeOfThisInClosure();
    this.parseAndAssertNoError(_testForScopeOfThisInClosure);
  }
  
  @Test
  public void testForScopeOfThisInCheckRule() {
    CharSequence _testForScopeOfThisInCheckRule = this.testFiles.testForScopeOfThisInCheckRule();
    this.parseAndAssertNoError(_testForScopeOfThisInCheckRule);
  }
  
  @Test
  public void testForScopeOfThisInJudgmentDescription() {
    CharSequence _testForScopeOfThisInJudgmentDescription = this.testFiles.testForScopeOfThisInJudgmentDescription();
    this.parseAndAssertNoError(_testForScopeOfThisInJudgmentDescription);
  }
  
  @Test
  public void testOutputParamFromInputParam() {
    CharSequence _testOutputParamFromInputParam = this.testFiles.testOutputParamFromInputParam();
    this.parseAndAssertNoError(_testOutputParamFromInputParam);
  }
  
  @Test
  public void testVariableDeclarationAsOutputArgument() {
    CharSequence _testVariableDeclarationAsOutputArgument = this.testFiles.testVariableDeclarationAsOutputArgument();
    this.parseAndAssertNoError(_testVariableDeclarationAsOutputArgument);
  }
  
  @Test
  public void testScopingForVariableDeclarationAsOutputArgument() {
    CharSequence _testScopingForVariableDeclarationAsOutputArgument = this.testFiles.testScopingForVariableDeclarationAsOutputArgument();
    this.parseAndAssertNoError(_testScopingForVariableDeclarationAsOutputArgument);
  }
  
  @Test
  public void testRuleWithBooleanExpressionsWithNoSideEffect() {
    try {
      CharSequence _testRuleWithBooleanExpressionsWithNoSideEffect = this.testFiles.testRuleWithBooleanExpressionsWithNoSideEffect();
      XsemanticsSystem _parse = this.parser.parse(_testRuleWithBooleanExpressionsWithNoSideEffect);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRuleWithBooleanExpressionsWithNoSideEffectInFor() {
    try {
      CharSequence _testRuleWithBooleanExpressionsWithNoSideEffectInFor = this.testFiles.testRuleWithBooleanExpressionsWithNoSideEffectInFor();
      XsemanticsSystem _parse = this.parser.parse(_testRuleWithBooleanExpressionsWithNoSideEffectInFor);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFailSideEffect() {
    try {
      CharSequence _testFailSideEffect = this.testFiles.testFailSideEffect();
      XsemanticsSystem _parse = this.parser.parse(_testFailSideEffect);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFailInsideClosureSideEffect() {
    try {
      CharSequence _testFailInsideClosureSideEffect = this.testFiles.testFailInsideClosureSideEffect();
      XsemanticsSystem _parse = this.parser.parse(_testFailInsideClosureSideEffect);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFailWithErrorSpecificationInsideClosureSideEffect() {
    try {
      CharSequence _testFailWithErrorSpecificationInsideClosureSideEffect = this.testFiles.testFailWithErrorSpecificationInsideClosureSideEffect();
      XsemanticsSystem _parse = this.parser.parse(_testFailWithErrorSpecificationInsideClosureSideEffect);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBooleanExpressionsInIf() {
    try {
      CharSequence _testBooleanExpressionsInIf = this.testFiles.testBooleanExpressionsInIf();
      XsemanticsSystem _parse = this.parser.parse(_testBooleanExpressionsInIf);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSystemWithInjections() {
    try {
      CharSequence _testSystemWithInjections = this.testFiles.testSystemWithInjections();
      XsemanticsSystem _parse = this.parser.parse(_testSystemWithInjections);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAccessToInjectedFields() {
    try {
      CharSequence _testAccessToInjectedFields = this.testFiles.testAccessToInjectedFields();
      XsemanticsSystem _parse = this.parser.parse(_testAccessToInjectedFields);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAccessToInjectedFieldsInExpressionInConclusion() {
    try {
      CharSequence _testAccessToInjectedFieldsInExpressionInConclusion = this.testFiles.testAccessToInjectedFieldsInExpressionInConclusion();
      XsemanticsSystem _parse = this.parser.parse(_testAccessToInjectedFieldsInExpressionInConclusion);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAccessToThisInExpressionInConclusion() {
    try {
      CharSequence _testAccessToThisInExpressionInConclusion = this.testFiles.testAccessToThisInExpressionInConclusion();
      XsemanticsSystem _parse = this.parser.parse(_testAccessToThisInExpressionInConclusion);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSystemWithValidatorExtends() {
    try {
      CharSequence _testSystemWithValidatorExtends = this.testFiles.testSystemWithValidatorExtends();
      XsemanticsSystem _parse = this.parser.parse(_testSystemWithValidatorExtends);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSystemExtends() {
    try {
      CharSequence _testSystemExtends = this.testFiles.testSystemExtends();
      XsemanticsSystem _parse = this.parser.parse(_testSystemExtends);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSystemExtendsTestBaseSystem() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("system it.xsemantics.dsl.tests.input.TestBaseSystem");
    _builder.newLine();
    CharSequence _testSystemExtendsTestBaseSystem = this.testFiles.testSystemExtendsTestBaseSystem();
    this.parseWithBaseSystemAndAssertNoError(_builder, _testSystemExtendsTestBaseSystem);
  }
  
  @Test
  public void testSystemExtendsTestBaseSystem2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("system it.xsemantics.dsl.tests.input.TestBaseSystem");
    _builder.newLine();
    CharSequence _testSystemExtendsTestBaseSystem = this.testFiles.testSystemExtendsTestBaseSystem();
    CharSequence _testSystemExtendsSystem2 = this.testFiles.testSystemExtendsSystem2();
    this.parseWithBaseSystemAndAssertNoError(_builder, _testSystemExtendsTestBaseSystem, _testSystemExtendsSystem2);
  }
  
  @Test
  public void testSystemExtendsExtendedTypeSystem() {
    XsemanticsSystem _systemExtendsExtendedTypeSystem = this.systemExtendsExtendedTypeSystem();
    this._validationTestHelper.assertNoErrors(_systemExtendsExtendedTypeSystem);
  }
  
  @Test
  public void testRuleOverride() {
    XsemanticsSystem _systemExtendsSystemWithRuleOverride = this.systemExtendsSystemWithRuleOverride();
    this._validationTestHelper.assertNoErrors(_systemExtendsSystemWithRuleOverride);
  }
  
  @Test
  public void testOverrideJudgment() {
    XsemanticsSystem _systemExtendsSystemWithJudgmentOverride = this.systemExtendsSystemWithJudgmentOverride();
    this._validationTestHelper.assertNoErrors(_systemExtendsSystemWithJudgmentOverride);
  }
  
  @Test
  public void testAuxiliaryDescriptions() {
    try {
      CharSequence _testAuxiliaryDescriptions = this.testFiles.testAuxiliaryDescriptions();
      XsemanticsSystem _parse = this.parser.parse(_testAuxiliaryDescriptions);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAuxiliaryFunctions() {
    try {
      CharSequence _testAuxiliaryFunctions = this.testFiles.testAuxiliaryFunctions();
      XsemanticsSystem _parse = this.parser.parse(_testAuxiliaryFunctions);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJudgmentDescriptionsWith3OutputParams() {
    try {
      CharSequence _testJudgmentDescriptionsWith3OutputParams = this.testFiles.testJudgmentDescriptionsWith3OutputParams();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsWith3OutputParams);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAuxiliaryFunctionsInvocation() {
    try {
      CharSequence _testAuxiliaryFunctionsInvocation = this.testFiles.testAuxiliaryFunctionsInvocation();
      XsemanticsSystem _parse = this.parser.parse(_testAuxiliaryFunctionsInvocation);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticImport() {
    try {
      CharSequence _testStaticImport = this.testFiles.testStaticImport();
      XsemanticsSystem _parse = this.parser.parse(_testStaticImport);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticExtensionImport() {
    try {
      CharSequence _testStaticExtensionImport = this.testFiles.testStaticExtensionImport();
      XsemanticsSystem _parse = this.parser.parse(_testStaticExtensionImport);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
