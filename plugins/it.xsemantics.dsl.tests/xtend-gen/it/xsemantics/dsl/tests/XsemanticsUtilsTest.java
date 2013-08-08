package it.xsemantics.dsl.tests;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.util.XsemanticsNodeModelUtils;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsUtilsTest extends XsemanticsBaseTest {
  @Inject
  @Extension
  private XsemanticsUtils _xsemanticsUtils;
  
  @Inject
  private XsemanticsNodeModelUtils nodeModelUtils;
  
  @Test
  public void testJudgmentDescriptions() {
    try {
      CharSequence _testJudgmentDescriptionsWithDuplicateSymbols = this.testFiles.testJudgmentDescriptionsWithDuplicateSymbols();
      XsemanticsSystem _parse = this.parser.parse(_testJudgmentDescriptionsWithDuplicateSymbols);
      final List<JudgmentDescription> descriptions = this.getJudgmentDescriptions(_parse, "|-", ":");
      int _size = descriptions.size();
      Assert.assertEquals(2, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRuleJudgmentDescription() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_firstRule);
    this.assertDescription(_judgmentDescription, "|-", ":");
  }
  
  @Test
  public void testRuleInvocationJudgmentDescription() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testRuleInvokingAnotherRule);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_parseAndAssertNoError);
    RuleInvocation _get = _ruleInvocations.get(0);
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_get);
    this.assertDescription(_judgmentDescription, "|-", ":");
  }
  
  @Test
  public void testRuleWithoutDescription() {
    CharSequence _testRuleWithoutJudgmentDescription = this.testFiles.testRuleWithoutJudgmentDescription();
    Rule _ruleWithoutValidation = this.getRuleWithoutValidation(_testRuleWithoutJudgmentDescription, 1);
    final JudgmentDescription description = this._xsemanticsUtils.judgmentDescription(_ruleWithoutValidation);
    Assert.assertNull(description);
  }
  
  @Test
  public void testJudgmentDescriptionWithoutRules() {
    CharSequence _testJudgmentDescriptions = this.testFiles.testJudgmentDescriptions();
    JudgmentDescription _firstJudgmentDescription = this.firstJudgmentDescription(_testJudgmentDescriptions);
    List<Rule> _rulesForJudgmentDescription = this._xsemanticsUtils.rulesForJudgmentDescription(_firstJudgmentDescription);
    boolean _isEmpty = _rulesForJudgmentDescription.isEmpty();
    Assert.assertTrue(_isEmpty);
  }
  
  @Test
  public void testJudgmentDescriptionWithRules() {
    CharSequence _testRulesOfTheSameKind = this.testFiles.testRulesOfTheSameKind();
    JudgmentDescription _firstJudgmentDescription = this.firstJudgmentDescription(_testRulesOfTheSameKind);
    List<Rule> _rulesForJudgmentDescription = this._xsemanticsUtils.rulesForJudgmentDescription(_firstJudgmentDescription);
    int _size = _rulesForJudgmentDescription.size();
    Assert.assertEquals(2, _size);
  }
  
  @Test
  public void testAllRulesOfTheSameKind() {
    CharSequence _testRulesOfTheSameKind = this.testFiles.testRulesOfTheSameKind();
    final XsemanticsSystem ts = this.parseAndAssertNoError(_testRulesOfTheSameKind);
    EList<Rule> _rules = ts.getRules();
    Rule _get = _rules.get(0);
    List<Rule> _allRulesOfTheSameKind = this._xsemanticsUtils.allRulesOfTheSameKind(_get);
    EList<Rule> _rules_1 = ts.getRules();
    Rule _get_1 = _rules_1.get(0);
    EList<Rule> _rules_2 = ts.getRules();
    Rule _get_2 = _rules_2.get(1);
    this.assertRules(_allRulesOfTheSameKind, _get_1, _get_2);
    EList<Rule> _rules_3 = ts.getRules();
    Rule _get_3 = _rules_3.get(2);
    List<Rule> _allRulesOfTheSameKind_1 = this._xsemanticsUtils.allRulesOfTheSameKind(_get_3);
    EList<Rule> _rules_4 = ts.getRules();
    Rule _get_4 = _rules_4.get(2);
    EList<Rule> _rules_5 = ts.getRules();
    Rule _get_5 = _rules_5.get(3);
    this.assertRules(_allRulesOfTheSameKind_1, _get_4, _get_5);
  }
  
  @Test
  public void testOutputParamsEmpty() {
    CharSequence _testJudgmentDescriptionsReferringToEcore3 = this.testFiles.testJudgmentDescriptionsReferringToEcore3();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsReferringToEcore3);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(_get);
    int _size = _outputJudgmentParameters.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testInputParamsForJudgmentDescription() {
    CharSequence _testJudgmentDescriptionsReferringToEcore3 = this.testFiles.testJudgmentDescriptionsReferringToEcore3();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsReferringToEcore3);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    List<InputParameter> _inputParams = this._xsemanticsUtils.inputParams(_get);
    int _size = _inputParams.size();
    Assert.assertEquals(3, _size);
  }
  
  @Test
  public void testInputParamsForRuleInPresenceOfExpressionInConclusion() {
    CharSequence _testRuleWithExpressionInConclusion = this.testFiles.testRuleWithExpressionInConclusion();
    Rule _firstRule = this.getFirstRule(_testRuleWithExpressionInConclusion);
    List<RuleParameter> _inputParams = this._xsemanticsUtils.inputParams(_firstRule);
    int _size = _inputParams.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testInputParamsForRuleWithoutExpressionInConclusion() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    List<RuleParameter> _inputParams = this._xsemanticsUtils.inputParams(_firstRule);
    int _size = _inputParams.size();
    Assert.assertEquals(2, _size);
  }
  
  @Test
  public void testInputEObjectParams() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    List<RuleParameter> _inputEObjectParams = this._xsemanticsUtils.inputEObjectParams(_firstRule);
    int _size = _inputEObjectParams.size();
    Assert.assertEquals(2, _size);
  }
  
  @Test
  public void testInputEObjectParamsWithNonEObjects() {
    CharSequence _testRulesWithNonEObjectParams = this.testFiles.testRulesWithNonEObjectParams();
    Rule _firstRule = this.getFirstRule(_testRulesWithNonEObjectParams);
    List<RuleParameter> _inputEObjectParams = this._xsemanticsUtils.inputEObjectParams(_firstRule);
    int _size = _inputEObjectParams.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testOutputParamsNotEmpty() {
    CharSequence _testJudgmentDescriptionsReferringToEcore3WithOutput = this.testFiles.testJudgmentDescriptionsReferringToEcore3WithOutput();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsReferringToEcore3WithOutput);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(_get);
    int _size = _outputJudgmentParameters.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testOutputJudgmentParametersForRule() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    List<OutputParameter> _outputJudgmentParameters = this._xsemanticsUtils.outputJudgmentParameters(_firstRule);
    int _size = _outputJudgmentParameters.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testOutputParamsNotEmptyForRule() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    boolean _hasOutputParams = this._xsemanticsUtils.hasOutputParams(_firstRule);
    Assert.assertTrue(_hasOutputParams);
  }
  
  @Test
  public void testOutputParamsEmptyForRule() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    boolean _hasOutputParams = this._xsemanticsUtils.hasOutputParams(_firstRule);
    Assert.assertFalse(_hasOutputParams);
  }
  
  @Test
  public void testOutputParamsForRule() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    List<RuleParameter> _outputParams = this._xsemanticsUtils.outputParams(_firstRule);
    int _size = _outputParams.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testIsInputParam() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    RuleParameter _ruleParameterByName = this.ruleParameterByName(_firstRule, "object");
    boolean _isInputParam = this._xsemanticsUtils.isInputParam(_ruleParameterByName);
    Assert.assertTrue(_isInputParam);
  }
  
  @Test
  public void testIsNotInputParam() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    RuleParameter _ruleParameterByName = this.ruleParameterByName(_firstRule, "object");
    boolean _isInputParam = this._xsemanticsUtils.isInputParam(_ruleParameterByName);
    Assert.assertFalse(_isInputParam);
  }
  
  @Test
  public void testIsInputJvmParam() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    RuleParameter _ruleParameterByName = this.ruleParameterByName(_firstRule, "object");
    JvmFormalParameter _parameter = _ruleParameterByName.getParameter();
    boolean _isInputParam = this._xsemanticsUtils.isInputParam(_parameter);
    Assert.assertTrue(_isInputParam);
  }
  
  @Test
  public void testIsNotInputJvmParam() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    RuleParameter _ruleParameterByName = this.ruleParameterByName(_firstRule, "object");
    JvmFormalParameter _parameter = _ruleParameterByName.getParameter();
    boolean _isInputParam = this._xsemanticsUtils.isInputParam(_parameter);
    Assert.assertFalse(_isInputParam);
  }
  
  @Test
  public void testOutputParamsForRuleInvocation() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testRuleWithOutputParams);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_parseAndAssertNoError);
    RuleInvocation _get = _ruleInvocations.get(0);
    List<OutputParameter> _outputParams = this._xsemanticsUtils.outputParams(_get);
    int _size = _outputParams.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testOuputArg() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    Rule _firstRule = this.getFirstRule(_testRuleInvokingAnotherRule);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_firstRule);
    final RuleInvocation ruleInvocation = _ruleInvocations.get(0);
    final List<XExpression> outputArgs = this._xsemanticsUtils.outputArgsExpressions(ruleInvocation);
    int _size = outputArgs.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testOuputArg2() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    Rule _firstRule = this.getFirstRule(_testRuleInvokingAnotherRule);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_firstRule);
    final RuleInvocation ruleInvocation = _ruleInvocations.get(1);
    final List<XExpression> outputArgs = this._xsemanticsUtils.outputArgsExpressions(ruleInvocation);
    int _size = outputArgs.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testInputArgs() {
    CharSequence _testRuleInvokingAnotherRule = this.testFiles.testRuleInvokingAnotherRule();
    Rule _firstRule = this.getFirstRule(_testRuleInvokingAnotherRule);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_firstRule);
    final RuleInvocation ruleInvocation = _ruleInvocations.get(0);
    final List<XExpression> inputArgs = this._xsemanticsUtils.inputArgsExpressions(ruleInvocation);
    int _size = inputArgs.size();
    Assert.assertEquals(2, _size);
  }
  
  @Test
  public void testInputArgsWithOutputParams() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_firstRule);
    final RuleInvocation ruleInvocation = _ruleInvocations.get(0);
    final List<XExpression> inputArgs = this._xsemanticsUtils.inputArgsExpressions(ruleInvocation);
    int _size = inputArgs.size();
    Assert.assertEquals(2, _size);
    EList<XExpression> _expressions = ruleInvocation.getExpressions();
    XExpression _get = _expressions.get(0);
    XExpression _get_1 = inputArgs.get(0);
    Assert.assertEquals(_get, _get_1);
    EList<XExpression> _expressions_1 = ruleInvocation.getExpressions();
    XExpression _get_2 = _expressions_1.get(2);
    XExpression _get_3 = inputArgs.get(1);
    Assert.assertEquals(_get_2, _get_3);
  }
  
  @Test
  public void testOutputArgsWithOutputParams() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    List<RuleInvocation> _ruleInvocations = this._xsemanticsUtils.getRuleInvocations(_firstRule);
    final RuleInvocation ruleInvocation = _ruleInvocations.get(0);
    final List<XExpression> inputArgs = this._xsemanticsUtils.outputArgsExpressions(ruleInvocation);
    int _size = inputArgs.size();
    Assert.assertEquals(1, _size);
    EList<XExpression> _expressions = ruleInvocation.getExpressions();
    XExpression _get = _expressions.get(1);
    XExpression _get_1 = inputArgs.get(0);
    Assert.assertEquals(_get, _get_1);
  }
  
  @Test
  public void testOutputConclusionElements() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    final Rule rule = this.getFirstRule(_testRuleWithOutputParams);
    final List<RuleConclusionElement> outputConclusionElements = this._xsemanticsUtils.outputConclusionElements(rule);
    int _size = outputConclusionElements.size();
    Assert.assertEquals(1, _size);
    RuleConclusion _conclusion = rule.getConclusion();
    EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
    RuleConclusionElement _get = _conclusionElements.get(1);
    RuleConclusionElement _get_1 = outputConclusionElements.get(0);
    Assert.assertEquals(_get, _get_1);
  }
  
  @Test
  public void testIterateIfThenElse() {
    String[] _split = "a,B,c".split(",");
    final List<String> stringList = IterableExtensions.<String>toList(((Iterable<String>)Conversions.doWrapArray(_split)));
    final ArrayList<String> toUpper = CollectionLiterals.<String>newArrayList();
    final ArrayList<String> toLower = CollectionLiterals.<String>newArrayList();
    final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
        public Boolean apply(final String it) {
          String _lowerCase = it.toLowerCase();
          boolean _equals = _lowerCase.equals(it);
          return Boolean.valueOf(_equals);
        }
      };
    final Procedure1<String> _function_1 = new Procedure1<String>() {
        public void apply(final String it) {
          toLower.add(it);
        }
      };
    final Procedure1<String> _function_2 = new Procedure1<String>() {
        public void apply(final String it) {
          toUpper.add(it);
        }
      };
    this._xsemanticsUtils.<String>iterateIfThenElse(stringList, _function, _function_1, _function_2);
    String _string = toLower.toString();
    Assert.assertEquals("[a, c]", _string);
    String _string_1 = toUpper.toString();
    Assert.assertEquals("[B]", _string_1);
  }
  
  @Test
  public void testOutputConclusionElementsWithoutOutputParams() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    final Rule rule = this.getFirstRule(_testSimpleRule);
    final List<RuleConclusionElement> outputConclusionElements = this._xsemanticsUtils.outputConclusionElements(rule);
    int _size = outputConclusionElements.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testOriginalSystemDefinition() {
    XsemanticsSystem _systemExtendsSystemWithJudgments = this.systemExtendsSystemWithJudgments();
    JvmParameterizedTypeReference _superSystem = _systemExtendsSystemWithJudgments.getSuperSystem();
    XsemanticsSystem _originalSystemDefinition = this._xsemanticsUtils.originalSystemDefinition(_superSystem);
    String _name = _originalSystemDefinition.getName();
    this.assertEqualsStrings(_name, "it.xsemantics.test.TypeSystem");
  }
  
  @Test
  public void testSuperSystemDefinition() {
    XsemanticsSystem _systemExtendsSystemWithJudgments = this.systemExtendsSystemWithJudgments();
    XsemanticsSystem _superSystemDefinition = this._xsemanticsUtils.superSystemDefinition(_systemExtendsSystemWithJudgments);
    String _name = _superSystemDefinition.getName();
    this.assertEqualsStrings(_name, "it.xsemantics.test.TypeSystem");
  }
  
  @Test
  public void testSuperSystemDefinitionWithNoSuperSystem() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testSimpleRule);
    XsemanticsSystem _superSystemDefinition = this._xsemanticsUtils.superSystemDefinition(_parseAndAssertNoError);
    Assert.assertNull(_superSystemDefinition);
  }
  
  @Test
  public void testAllSuperSystemDefinitions() {
    XsemanticsSystem _systemExtendsSystemWithJudgments = this.systemExtendsSystemWithJudgments();
    List<XsemanticsSystem> _allSuperSystemDefinitions = this._xsemanticsUtils.allSuperSystemDefinitions(_systemExtendsSystemWithJudgments);
    XsemanticsSystem _head = IterableExtensions.<XsemanticsSystem>head(_allSuperSystemDefinitions);
    String _name = _head.getName();
    this.assertEqualsStrings(_name, "it.xsemantics.test.TypeSystem");
  }
  
  @Test
  public void testAllSuperSystemDefinitions2() {
    XsemanticsSystem _systemExtendsExtendedTypeSystem = this.systemExtendsExtendedTypeSystem();
    final List<XsemanticsSystem> superSystems = this._xsemanticsUtils.allSuperSystemDefinitions(_systemExtendsExtendedTypeSystem);
    int _size = superSystems.size();
    Assert.assertEquals(2, _size);
    XsemanticsSystem _get = superSystems.get(0);
    String _name = _get.getName();
    this.assertEqualsStrings(_name, "it.xsemantics.test.ExtendedTypeSystem");
    XsemanticsSystem _get_1 = superSystems.get(1);
    String _name_1 = _get_1.getName();
    this.assertEqualsStrings(_name_1, "it.xsemantics.test.TypeSystem");
  }
  
  @Test
  public void testAllSuperSystemDefinitionsWithCycle() {
    CharSequence _testSystemBaseWithCycle = this.testFiles.testSystemBaseWithCycle();
    CharSequence _testSystemExtendsSystemWithJudgmentsReferringToEcore = this.testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore();
    XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(_testSystemBaseWithCycle, _testSystemExtendsSystemWithJudgmentsReferringToEcore);
    CharSequence _testSystemExtendsExtendedTypeSystem = this.testFiles.testSystemExtendsExtendedTypeSystem();
    XsemanticsSystem _parseWithBaseSystem_1 = this.parseWithBaseSystem(_parseWithBaseSystem, _testSystemExtendsExtendedTypeSystem);
    final List<XsemanticsSystem> superSystems = this._xsemanticsUtils.allSuperSystemDefinitions(_parseWithBaseSystem_1);
    int _size = superSystems.size();
    Assert.assertEquals(3, _size);
  }
  
  @Test
  public void testAllSuperSystemDefinitionsWithNoSuperSystem() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testSimpleRule);
    List<XsemanticsSystem> _allSuperSystemDefinitions = this._xsemanticsUtils.allSuperSystemDefinitions(_parseAndAssertNoError);
    int _size = _allSuperSystemDefinitions.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testSuperSystemJudgments() {
    XsemanticsSystem _systemExtendsSystemWithJudgments = this.systemExtendsSystemWithJudgments();
    List<JudgmentDescription> _superSystemJudgments = this._xsemanticsUtils.superSystemJudgments(_systemExtendsSystemWithJudgments);
    int _size = _superSystemJudgments.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testAllJudgments() {
    XsemanticsSystem _systemExtendsSystemWithAdditionalJudgment = this.systemExtendsSystemWithAdditionalJudgment();
    ArrayList<JudgmentDescription> _allJudgments = this._xsemanticsUtils.allJudgments(_systemExtendsSystemWithAdditionalJudgment);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("it.xsemantics.test.ExtendedTypeSystem subtype |- EClass c1 <: EClass c2");
    _builder.newLine();
    _builder.append("it.xsemantics.test.TypeSystem type |- EObject c : output EClass error \"this \" + c + \" made an error!\" source c feature c.eClass.eContainingFeature");
    _builder.newLine();
    this.assertJudgments(_allJudgments, _builder);
  }
  
  @Test
  public void testAllJudgments2() {
    XsemanticsSystem _systemExtendsExtendedTypeSystem = this.systemExtendsExtendedTypeSystem();
    ArrayList<JudgmentDescription> _allJudgments = this._xsemanticsUtils.allJudgments(_systemExtendsExtendedTypeSystem);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("it.xsemantics.test.ExtendedTypeSystem2 type2 ||- EClass c1 : EClass c2");
    _builder.newLine();
    _builder.append("it.xsemantics.test.ExtendedTypeSystem subtype |- EClass c1 <: EClass c2");
    _builder.newLine();
    _builder.append("it.xsemantics.test.TypeSystem type |- EObject c : output EClass error \"this \" + c + \" made an error!\" source c feature c.eClass.eContainingFeature");
    _builder.newLine();
    this.assertJudgments(_allJudgments, _builder);
  }
  
  @Test
  public void testAllJudgmentsWithOverride() {
    XsemanticsSystem _systemExtendsSystemWithJudgmentOverride = this.systemExtendsSystemWithJudgmentOverride();
    ArrayList<JudgmentDescription> _allJudgments = this._xsemanticsUtils.allJudgments(_systemExtendsSystemWithJudgmentOverride);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("it.xsemantics.test.ExtendedTypeSystemWithJudgmentOverride override type |- EObject obj : output EClass");
    _builder.newLine();
    _builder.append("it.xsemantics.test.ExtendedTypeSystemWithJudgmentOverride override subtype |- EClass c1 <: EClass c2 error stringRep(c1) + \" not <: \" + stringRep(c2) source c1 feature c1.eClass.eContainingFeature");
    _builder.newLine();
    _builder.append("it.xsemantics.test.ExtendedTypeSystem2 type2 ||- EClass c1 : EClass c2");
    _builder.newLine();
    _builder.append("it.xsemantics.test.ExtendedTypeSystem subtype |- EClass c1 <: EClass c2");
    _builder.newLine();
    _builder.append("it.xsemantics.test.TypeSystem type |- EObject c : output EClass error \"this \" + c + \" made an error!\" source c feature c.eClass.eContainingFeature");
    _builder.newLine();
    this.assertJudgments(_allJudgments, _builder);
  }
  
  @Test
  public void testSuperSystemJudgmentsWithNoSuperSystem() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testSimpleRule);
    List<JudgmentDescription> _superSystemJudgments = this._xsemanticsUtils.superSystemJudgments(_parseAndAssertNoError);
    int _size = _superSystemJudgments.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testRuleJudgmentDescriptionInherited() {
    final XsemanticsSystem ts = this.systemExtendsExtendedTypeSystem();
    Rule _rule = this.getRule(ts, 0);
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_rule);
    this.assertDescription(_judgmentDescription, "|-", ":");
    Rule _rule_1 = this.getRule(ts, 1);
    JudgmentDescription _judgmentDescription_1 = this._xsemanticsUtils.judgmentDescription(_rule_1);
    this.assertDescription(_judgmentDescription_1, "|-", "<:");
    Rule _rule_2 = this.getRule(ts, 2);
    JudgmentDescription _judgmentDescription_2 = this._xsemanticsUtils.judgmentDescription(_rule_2);
    this.assertDescription(_judgmentDescription_2, "||-", ":");
  }
  
  @Test
  public void testRuleInvocationJudgmentDescriptionInherited() {
    final XsemanticsSystem ts = this.systemExtendsExtendedTypeSystem();
    Rule _rule = this.getRule(ts, 0);
    RuleInvocation _ruleInvocationFromPremises = this.getRuleInvocationFromPremises(_rule);
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_ruleInvocationFromPremises);
    this.assertDescription(_judgmentDescription, 
      "|-", "<:");
    Rule _rule_1 = this.getRule(ts, 1);
    RuleInvocation _ruleInvocationFromPremises_1 = this.getRuleInvocationFromPremises(_rule_1);
    JudgmentDescription _judgmentDescription_1 = this._xsemanticsUtils.judgmentDescription(_ruleInvocationFromPremises_1);
    this.assertDescription(_judgmentDescription_1, 
      "||-", ":");
    Rule _rule_2 = this.getRule(ts, 2);
    RuleInvocation _ruleInvocationFromPremises_2 = this.getRuleInvocationFromPremises(_rule_2);
    JudgmentDescription _judgmentDescription_2 = this._xsemanticsUtils.judgmentDescription(_ruleInvocationFromPremises_2);
    this.assertDescription(_judgmentDescription_2, 
      "|-", ":");
  }
  
  @Test
  public void testAllRules() {
    XsemanticsSystem _systemExtendsSystemWithRuleOverride = this.systemExtendsSystemWithRuleOverride();
    ArrayList<Rule> _allRules = this._xsemanticsUtils.allRules(_systemExtendsSystemWithRuleOverride);
    int _size = _allRules.size();
    Assert.assertEquals(6, _size);
  }
  
  @Test
  public void testAllRulesByJudgmentDescription() {
    XsemanticsSystem _systemExtendsSystemWithRuleOverride = this.systemExtendsSystemWithRuleOverride();
    ArrayList<String> _newArrayList = Lists.<String>newArrayList(":");
    Iterable<Rule> _allRulesByJudgmentDescription = this._xsemanticsUtils.allRulesByJudgmentDescription(_systemExtendsSystemWithRuleOverride, "|-", _newArrayList);
    int _size = IterableExtensions.size(_allRulesByJudgmentDescription);
    Assert.assertEquals(2, _size);
  }
  
  @Test
  public void testCheckAllRules() {
    XsemanticsSystem _systemExtendsSystemWithRuleOverride = this.systemExtendsSystemWithRuleOverride();
    ArrayList<CheckRule> _allCheckRules = this._xsemanticsUtils.allCheckRules(_systemExtendsSystemWithRuleOverride);
    int _size = _allCheckRules.size();
    Assert.assertEquals(2, _size);
  }
  
  public void assertRules(final List<Rule> rules, final Rule expectedRule1, final Rule expectedRule2) {
    int _size = rules.size();
    Assert.assertEquals(2, _size);
    Rule _get = rules.get(0);
    Assert.assertEquals(expectedRule1, _get);
    Rule _get_1 = rules.get(1);
    Assert.assertEquals(expectedRule2, _get_1);
  }
  
  public void assertDescription(final JudgmentDescription description, final String judgmentSymbol, final String relationSymbol) {
    Assert.assertNotNull("judgment description is null", description);
    String _judgmentSymbol = description.getJudgmentSymbol();
    Assert.assertEquals(judgmentSymbol, _judgmentSymbol);
    EList<String> _relationSymbols = description.getRelationSymbols();
    String _get = _relationSymbols.get(0);
    Assert.assertEquals(relationSymbol, _get);
  }
  
  public List<JudgmentDescription> getJudgmentDescriptions(final XsemanticsSystem ts, final String judgmentSymbol, final String relationSymbol) {
    ArrayList<String> _newArrayList = Lists.<String>newArrayList(relationSymbol);
    Iterable<JudgmentDescription> _filterJudgmentDescriptions = this._xsemanticsUtils.filterJudgmentDescriptions(ts, judgmentSymbol, _newArrayList);
    ArrayList<JudgmentDescription> _newArrayList_1 = Lists.<JudgmentDescription>newArrayList(_filterJudgmentDescriptions);
    return _newArrayList_1;
  }
  
  public void assertJudgments(final List<JudgmentDescription> judgments, final CharSequence expected) {
    final Function1<JudgmentDescription,String> _function = new Function1<JudgmentDescription,String>() {
        public String apply(final JudgmentDescription it) {
          XsemanticsSystem _containingSystem = XsemanticsUtilsTest.this._xsemanticsUtils.containingSystem(it);
          String _name = _containingSystem.getName();
          String _plus = (_name + " ");
          String _programText = XsemanticsUtilsTest.this.nodeModelUtils.getProgramText(it);
          String _plus_1 = (_plus + _programText);
          return _plus_1;
        }
      };
    List<String> _map = ListExtensions.<JudgmentDescription, String>map(judgments, _function);
    String _join = IterableExtensions.join(_map, "\n");
    String _plus = (_join + "\n");
    this.assertEqualsStrings(expected, _plus);
  }
}
