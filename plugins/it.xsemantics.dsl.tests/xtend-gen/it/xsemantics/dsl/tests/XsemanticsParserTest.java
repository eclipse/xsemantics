package it.xsemantics.dsl.tests;

import com.google.inject.Inject;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.EnvironmentComposition;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.List;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
public class XsemanticsParserTest extends XsemanticsBaseTest {
  @Inject
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Test
  public void testParsingOfName() {
    try {
      CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
      XsemanticsSystem _parse = this.parser.parse(_typeSystemQualifiedName);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingOfImports() {
    try {
      CharSequence _testFileWithImports = this.testFiles.testFileWithImports();
      XsemanticsSystem _parse = this.parser.parse(_testFileWithImports);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingOfJudgmentDescriptions() {
    try {
      CharSequence _testJudgmentDescriptions = this.testFiles.testJudgmentDescriptions();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptions);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingOfJudgmentDescriptions3() {
    try {
      CharSequence _testJudgmentDescriptions3 = this.testFiles.testJudgmentDescriptions3();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptions3);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingOfJudgmentDescriptionsWithOutput() {
    try {
      CharSequence _testJudgmentDescriptionsReferringToEcore3WithOutput = this.testFiles.testJudgmentDescriptionsReferringToEcore3WithOutput();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsReferringToEcore3WithOutput);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJudgmentDescriptionsRelatedToXtypes() {
    try {
      CharSequence _testJudgmentDescriptionsRelatedToXsemantics = this.testFiles.testJudgmentDescriptionsRelatedToXsemantics();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsRelatedToXsemantics);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJudgmentDescriptionsWithErrorSpecification() {
    try {
      CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsWithErrorSpecification);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJudgmentDescriptionsReferringToUnknownTypes() {
    try {
      CharSequence _testJudgmentDescriptionsReferringToUnknownTypes = this.testFiles.testJudgmentDescriptionsReferringToUnknownTypes();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsReferringToUnknownTypes);
      EClass _jvmParameterizedTypeReference = TypesPackage.eINSTANCE.getJvmParameterizedTypeReference();
      this._validationTestHelper.assertError(_parse, _jvmParameterizedTypeReference, Diagnostic.LINKING_DIAGNOSTIC, "Couldn\'t resolve reference to JvmType \'foo.bar.FooBar\'");
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFjDescriptions() {
    try {
      {
        CharSequence _fjJudgmentDescriptions = this.fjTestFiles.fjJudgmentDescriptions();
        XsemanticsSystem _parse = this.parser.parse(_fjJudgmentDescriptions);
        final XsemanticsSystem typesystem = _parse;
        this._validationTestHelper.assertNoErrors(typesystem);
        List<JvmTypeReference> _jvmTypes = this._xsemanticsUtils.getJvmTypes(typesystem);
        List<JvmTypeReference> jvmReferences = _jvmTypes;
        String _name = it.xsemantics.example.fj.fj.Expression.class.getName();
        JvmTypeReference _get = jvmReferences.get(0);
        String _identifier = _get.getIdentifier();
        Assert.assertEquals(_name, _identifier);
        String _name_1 = it.xsemantics.example.fj.fj.Type.class.getName();
        JvmTypeReference _get_1 = jvmReferences.get(1);
        String _identifier_1 = _get_1.getIdentifier();
        Assert.assertEquals(_name_1, _identifier_1);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJudgmentDescriptionsRelatedToEcore() {
    try {
      CharSequence _testJudgmentDescriptionsReferringToEcore = this.testFiles.testJudgmentDescriptionsReferringToEcore();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsReferringToEcore);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSimpleAxiom() {
    try {
      CharSequence _testSimpleAxiom = this.testFiles.testSimpleAxiom();
      XsemanticsSystem _parse = this.parser.parse(_testSimpleAxiom);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSimpleRule() {
    try {
      CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
      XsemanticsSystem _parse = this.parser.parse(_testSimpleRule);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRuleWithExpressionInConclusion() {
    try {
      CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
      XsemanticsSystem _parse = this.parser.parse(_testRuleWithExpressionInConclusion);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRuleWithExpressionInConclusion2() {
    try {
      CharSequence _testRuleWithExpressionInConclusion2 = this.testFiles.testRuleWithExpressionInConclusion2();
      XsemanticsSystem _parse = this.parser.parse(_testRuleWithExpressionInConclusion2);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRuleWithBlockExpressionInConclusion() {
    try {
      CharSequence _testRuleWithBlockExpressionInConclusion = this.testFiles.testRuleWithBlockExpressionInConclusion();
      XsemanticsSystem _parse = this.parser.parse(_testRuleWithBlockExpressionInConclusion);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Exception _e) {
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
      XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testRuleOnlyInvokingRules);
      final XsemanticsSystem ts = _parseAndAssertNoError;
      List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
      int _size = _ruleInvocations.size();
      Assert.assertEquals(2, _size);
      EList<XExpression> _rulePremises = this.getRulePremises(ts, 0);
      EList<XExpression> expressions = _rulePremises;
      XExpression _get = expressions.get(0);
      this.assertIsInstance(it.xsemantics.dsl.xsemantics.RuleInvocation.class, _get);
      XExpression _get_1 = expressions.get(1);
      this.assertIsInstance(it.xsemantics.dsl.xsemantics.RuleInvocation.class, _get_1);
  }
  
  @Test
  public void testWithEnvironmentAccess() {
      CharSequence _testWithEnvironmentAccess = this.testFiles.testWithEnvironmentAccess();
      XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testWithEnvironmentAccess);
      EList<XExpression> _rulePremises = this.getRulePremises(_parseAndAssertNoError, 0);
      final EList<XExpression> premises = _rulePremises;
      XExpression _get = premises.get(0);
      this.assertIsInstance(it.xsemantics.dsl.xsemantics.RuleInvocation.class, _get);
      XExpression _get_1 = premises.get(1);
      this.assertIsInstance(it.xsemantics.dsl.xsemantics.EnvironmentAccess.class, _get_1);
      XExpression _get_2 = premises.get(2);
      this.assertIsInstance(it.xsemantics.dsl.xsemantics.RuleInvocation.class, _get_2);
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
  
  @Test
  public void testRuleInvokingAnotherRuleNotValid() {
    CharSequence _testRuleInvokingAnotherRuleNotValid = this.testFiles.testRuleInvokingAnotherRuleNotValid();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testRuleInvokingAnotherRuleNotValid);
    this.checksForRuleInvocations(_parseAndAssertNoError);
  }
  
  public void checksForRuleInvocations(final XsemanticsSystem ts) {
      List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(ts);
      int _size = _ruleInvocations.size();
      Assert.assertEquals(2, _size);
      EList<XExpression> _rulePremises = this.getRulePremises(ts, 0);
      EList<XExpression> expressions = _rulePremises;
      XExpression _get = expressions.get(0);
      this.assertIsInstance(org.eclipse.xtext.xbase.XBinaryOperation.class, _get);
      XExpression _get_1 = expressions.get(1);
      this.assertIsInstance(it.xsemantics.dsl.xsemantics.RuleInvocation.class, _get_1);
      XExpression _get_2 = expressions.get(2);
      this.assertIsInstance(it.xsemantics.dsl.xsemantics.RuleInvocation.class, _get_2);
      XExpression _get_3 = expressions.get(3);
      this.assertIsInstance(org.eclipse.xtext.xbase.XVariableDeclaration.class, _get_3);
      XExpression _get_4 = expressions.get(4);
      this.assertIsInstance(org.eclipse.xtext.xbase.XAssignment.class, _get_4);
      XExpression _get_5 = expressions.get(5);
      this.assertIsInstance(org.eclipse.xtext.xbase.XUnaryOperation.class, _get_5);
      XExpression _get_6 = expressions.get(6);
      this.assertIsInstance(org.eclipse.xtext.xbase.XBinaryOperation.class, _get_6);
      XExpression _get_7 = expressions.get(7);
      this.assertIsInstance(org.eclipse.xtext.xbase.XBinaryOperation.class, _get_7);
  }
  
  @Test
  public void testRuleInvocationsWithOperatorsConflictingXbase() {
      CharSequence _testRuleInvocationsWithOperatorsConflictingXbase = this.testFiles.testRuleInvocationsWithOperatorsConflictingXbase();
      XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testRuleInvocationsWithOperatorsConflictingXbase);
      XsemanticsSystem ts = _parseAndAssertNoError;
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
  public void testOrExpression() {
      CharSequence _testOrExpression = this.testFiles.testOrExpression();
      Rule _firstRule = this.getFirstRule(_testOrExpression);
      EList<XExpression> _rulePremises = this.getRulePremises(_firstRule);
      EList<XExpression> premises = _rulePremises;
      int _size = premises.size();
      Assert.assertEquals(1, _size);
      XExpression _get = premises.get(0);
      this.assertOrExpression(_get, 2);
  }
  
  @Test
  public void testOrExpression2() {
      CharSequence _testOrExpression2 = this.testFiles.testOrExpression2();
      Rule _firstRule = this.getFirstRule(_testOrExpression2);
      EList<XExpression> _rulePremises = this.getRulePremises(_firstRule);
      EList<XExpression> premises = _rulePremises;
      int _size = premises.size();
      Assert.assertEquals(3, _size);
      XExpression _get = premises.get(0);
      this.assertIsInstance(org.eclipse.xtext.xbase.XBinaryOperation.class, _get);
      XExpression _get_1 = premises.get(1);
      this.assertOrExpression(_get_1, 2);
      XExpression _get_2 = premises.get(2);
      this.assertIsInstance(org.eclipse.xtext.xbase.XBinaryOperation.class, _get_2);
  }
  
  @Test
  public void testOrExpressionWithBlocks() {
      CharSequence _testOrExpressionWithBlocks = this.testFiles.testOrExpressionWithBlocks();
      Rule _firstRule = this.getFirstRule(_testOrExpressionWithBlocks);
      EList<XExpression> _rulePremises = this.getRulePremises(_firstRule);
      EList<XExpression> premises = _rulePremises;
      int _size = premises.size();
      Assert.assertEquals(1, _size);
      XExpression _get = premises.get(0);
      this.assertOrExpression(_get, 2);
  }
  
  @Test
  public void testOrExpressionWithRuleInvocations() {
      CharSequence _testOrExpressionWithRuleInvocations = this.testFiles.testOrExpressionWithRuleInvocations();
      Rule _firstRule = this.getFirstRule(_testOrExpressionWithRuleInvocations);
      EList<XExpression> _rulePremises = this.getRulePremises(_firstRule);
      EList<XExpression> premises = _rulePremises;
      int _size = premises.size();
      Assert.assertEquals(1, _size);
      XExpression _get = premises.get(0);
      this.assertOrExpression(_get, 2);
  }
  
  @Test
  public void testOrExpressionWithRuleInvocations2() {
      CharSequence _testOrExpressionWithRuleInvocations2 = this.testFiles.testOrExpressionWithRuleInvocations2();
      Rule _firstRule = this.getFirstRule(_testOrExpressionWithRuleInvocations2);
      EList<XExpression> _rulePremises = this.getRulePremises(_firstRule);
      EList<XExpression> premises = _rulePremises;
      int _size = premises.size();
      Assert.assertEquals(1, _size);
      XExpression _get = premises.get(0);
      this.assertOrExpression(_get, 2);
  }
  
  @Test
  public void testOrExpressionWithManyBranches() {
      CharSequence _testOrExpressionWithManyBranches = this.testFiles.testOrExpressionWithManyBranches();
      Rule _firstRule = this.getFirstRule(_testOrExpressionWithManyBranches);
      EList<XExpression> _rulePremises = this.getRulePremises(_firstRule);
      EList<XExpression> premises = _rulePremises;
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
      RuleInvocation _ruleInvocationFromPremises = this.getRuleInvocationFromPremises(_firstRule);
      final RuleInvocation ruleInvocation = _ruleInvocationFromPremises;
      EnvironmentSpecification _environment = ruleInvocation.getEnvironment();
      final EnvironmentSpecification envSpec = _environment;
      this.assertIsInstance(it.xsemantics.dsl.xsemantics.EnvironmentComposition.class, envSpec);
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
  public void testWrongReturnInPremises() {
    CharSequence _testWrongReturnInPremises = this.testFiles.testWrongReturnInPremises();
    this.parseAndAssertNoError(_testWrongReturnInPremises);
  }
}
