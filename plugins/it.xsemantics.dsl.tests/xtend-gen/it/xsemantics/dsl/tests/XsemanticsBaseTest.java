package it.xsemantics.dsl.tests;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.tests.input.FjTypeSystemFiles;
import it.xsemantics.dsl.tests.input.XsemanticsTestFiles;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.EnvironmentComposition;
import it.xsemantics.dsl.xsemantics.EnvironmentMapping;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsBaseTest {
  @Inject
  protected XsemanticsTestFiles testFiles;
  
  @Inject
  protected FjTypeSystemFiles fjTestFiles;
  
  @Inject
  protected ParseHelper<XsemanticsSystem> parser;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @BeforeClass
  public static void setNewLine() {
    System.setProperty("line.separator", "\n");
  }
  
  public XsemanticsSystem parseAndAssertNoError(final CharSequence s) {
    try {
      XsemanticsSystem _xblockexpression = null;
      {
        XsemanticsSystem ts = this.parser.parse(s);
        this._validationTestHelper.assertNoErrors(ts);
        _xblockexpression = (ts);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * s extends baseSystem2 which extends baseSystem
   */
  public XsemanticsSystem parseWithBaseSystemAndAssertNoError(final CharSequence baseSystem, final CharSequence baseSystem2, final CharSequence s) {
    XsemanticsSystem _xblockexpression = null;
    {
      final XsemanticsSystem ts = this.parseWithBaseSystem(baseSystem, baseSystem2);
      this._validationTestHelper.assertNoErrors(ts);
      XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(ts, s);
      _xblockexpression = (_parseWithBaseSystem);
    }
    return _xblockexpression;
  }
  
  public XsemanticsSystem parseWithBaseSystemAndAssertNoError(final CharSequence baseSystem, final CharSequence s) {
    try {
      XsemanticsSystem _xblockexpression = null;
      {
        final XsemanticsSystem base = this.parser.parse(baseSystem);
        this._validationTestHelper.assertNoErrors(base);
        final XsemanticsSystem ts = this.parseWithBaseSystem(base, s);
        this._validationTestHelper.assertNoErrors(ts);
        _xblockexpression = (ts);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XsemanticsSystem parseWithBaseSystemAndAssertNoError(final XsemanticsSystem baseSystem, final CharSequence s) {
    XsemanticsSystem _xblockexpression = null;
    {
      final XsemanticsSystem ts = this.parseWithBaseSystem(baseSystem, s);
      this._validationTestHelper.assertNoErrors(ts);
      _xblockexpression = (ts);
    }
    return _xblockexpression;
  }
  
  public XsemanticsSystem parseWithBaseSystem(final CharSequence baseSystem, final CharSequence s) {
    try {
      XsemanticsSystem _xblockexpression = null;
      {
        final XsemanticsSystem base = this.parser.parse(baseSystem);
        XsemanticsSystem _parseWithBaseSystem = this.parseWithBaseSystem(base, s);
        _xblockexpression = (_parseWithBaseSystem);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XsemanticsSystem parseWithBaseSystem(final XsemanticsSystem baseSystem, final CharSequence s) {
    try {
      Resource _eResource = baseSystem.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      XsemanticsSystem _parse = this.parser.parse(s, _resourceSet);
      return _parse;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XsemanticsSystem parse(final CharSequence s) {
    try {
      XsemanticsSystem _parse = this.parser.parse(s);
      return _parse;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Rule getFirstRule(final CharSequence s) {
    Rule _rule = this.getRule(s, 0);
    return _rule;
  }
  
  public Rule getRule(final CharSequence s, final int index) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(s);
    Rule _rule = this.getRule(_parseAndAssertNoError, index);
    return _rule;
  }
  
  public Rule getRuleWithoutValidation(final CharSequence s, final int index) {
    XsemanticsSystem _parse = this.parse(s);
    Rule _rule = this.getRule(_parse, index);
    return _rule;
  }
  
  public Rule getRule(final XsemanticsSystem ts, final int index) {
    Rule _xblockexpression = null;
    {
      final EList<Rule> rules = ts.getRules();
      String _plus = ("no rule for index " + Integer.valueOf(index));
      String _plus_1 = (_plus + ", only ");
      int _size = rules.size();
      String _plus_2 = (_plus_1 + Integer.valueOf(_size));
      int _size_1 = rules.size();
      boolean _greaterThan = (_size_1 > index);
      Assert.assertTrue(_plus_2, _greaterThan);
      Rule _get = rules.get(index);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
  public CheckRule getFirstCheckRule(final CharSequence s) {
    CheckRule _checkRule = this.getCheckRule(s, 0);
    return _checkRule;
  }
  
  public CheckRule getCheckRule(final CharSequence s, final int index) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(s);
    CheckRule _checkRule = this.getCheckRule(_parseAndAssertNoError, index);
    return _checkRule;
  }
  
  public CheckRule getCheckRule(final XsemanticsSystem ts, final int index) {
    CheckRule _xblockexpression = null;
    {
      final EList<CheckRule> rules = ts.getCheckrules();
      String _plus = ("no rule for index " + Integer.valueOf(index));
      String _plus_1 = (_plus + ", only ");
      int _size = rules.size();
      String _plus_2 = (_plus_1 + Integer.valueOf(_size));
      int _size_1 = rules.size();
      boolean _greaterThan = (_size_1 > index);
      Assert.assertTrue(_plus_2, _greaterThan);
      CheckRule _get = rules.get(index);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
  public XVariableDeclaration firstVariableDeclaration(final CharSequence s) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(s);
    List<XVariableDeclaration> _allContentsOfType = EcoreUtil2.<XVariableDeclaration>getAllContentsOfType(_parseAndAssertNoError, XVariableDeclaration.class);
    XVariableDeclaration _get = _allContentsOfType.get(0);
    return _get;
  }
  
  public XAssignment firstAssignment(final CharSequence s) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(s);
    List<XAssignment> _allContentsOfType = EcoreUtil2.<XAssignment>getAllContentsOfType(_parseAndAssertNoError, XAssignment.class);
    XAssignment _get = _allContentsOfType.get(0);
    return _get;
  }
  
  public XIfExpression firstIf(final CharSequence s) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(s);
    List<XIfExpression> _allContentsOfType = EcoreUtil2.<XIfExpression>getAllContentsOfType(_parseAndAssertNoError, XIfExpression.class);
    XIfExpression _get = _allContentsOfType.get(0);
    return _get;
  }
  
  public XForLoopExpression firstFor(final CharSequence s) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(s);
    List<XForLoopExpression> _allContentsOfType = EcoreUtil2.<XForLoopExpression>getAllContentsOfType(_parseAndAssertNoError, XForLoopExpression.class);
    XForLoopExpression _get = _allContentsOfType.get(0);
    return _get;
  }
  
  public JudgmentDescription firstJudgmentDescription(final CharSequence s) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(s);
    JudgmentDescription _firstJudgmentDescription = this.firstJudgmentDescription(_parseAndAssertNoError);
    return _firstJudgmentDescription;
  }
  
  public JudgmentDescription firstJudgmentDescription(final XsemanticsSystem ts) {
    List<JudgmentDescription> _allContentsOfType = EcoreUtil2.<JudgmentDescription>getAllContentsOfType(ts, JudgmentDescription.class);
    JudgmentDescription _get = _allContentsOfType.get(0);
    return _get;
  }
  
  public ErrorSpecification firstErrorSpecification(final EObject o) {
    List<ErrorSpecification> _allContentsOfType = EcoreUtil2.<ErrorSpecification>getAllContentsOfType(o, ErrorSpecification.class);
    ErrorSpecification _get = _allContentsOfType.get(0);
    return _get;
  }
  
  public RuleWithPremises getRuleWithPremises(final XsemanticsSystem ts, final int index) {
    Rule _rule = this.getRule(ts, index);
    RuleWithPremises _ruleWithPremises = this.getRuleWithPremises(_rule);
    return _ruleWithPremises;
  }
  
  public EList<XExpression> getRulePremises(final XsemanticsSystem ts, final int index) {
    RuleWithPremises _ruleWithPremises = this.getRuleWithPremises(ts, index);
    XExpression _premises = _ruleWithPremises.getPremises();
    EList<XExpression> _expressions = ((XBlockExpression) _premises).getExpressions();
    return _expressions;
  }
  
  public RuleWithPremises getRuleWithPremises(final Rule rule) {
    return ((RuleWithPremises) rule);
  }
  
  public EList<XExpression> getRulePremises(final Rule rule) {
    RuleWithPremises _ruleWithPremises = this.getRuleWithPremises(rule);
    XExpression _premises = _ruleWithPremises.getPremises();
    EList<XExpression> _expressions = ((XBlockExpression) _premises).getExpressions();
    return _expressions;
  }
  
  public XBlockExpression getRulePremisesAsBlock(final Rule rule) {
    RuleWithPremises _ruleWithPremises = this.getRuleWithPremises(rule);
    XExpression _premises = _ruleWithPremises.getPremises();
    return ((XBlockExpression) _premises);
  }
  
  public XBlockExpression getRulePremisesAsBlock(final CheckRule rule) {
    XExpression _premises = rule.getPremises();
    return ((XBlockExpression) _premises);
  }
  
  public XExpression getPremise(final Rule rule, final int index) {
    EList<XExpression> _rulePremises = this.getRulePremises(rule);
    XExpression _get = _rulePremises.get(index);
    return _get;
  }
  
  public RuleParameter ruleParameter(final RuleConclusionElement ruleConclusionElement) {
    return ((RuleParameter) ruleConclusionElement);
  }
  
  public RuleParameter ruleParameterByName(final Rule rule, final String name) {
    RuleConclusion _conclusion = rule.getConclusion();
    EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
    List<RuleParameter> _typeSelect = EcoreUtil2.<RuleParameter>typeSelect(_conclusionElements, RuleParameter.class);
    final Function1<RuleParameter,Boolean> _function = new Function1<RuleParameter,Boolean>() {
      public Boolean apply(final RuleParameter it) {
        JvmFormalParameter _parameter = it.getParameter();
        String _name = _parameter.getName();
        boolean _equals = Objects.equal(_name, name);
        return Boolean.valueOf(_equals);
      }
    };
    RuleParameter _findFirst = IterableExtensions.<RuleParameter>findFirst(_typeSelect, _function);
    return _findFirst;
  }
  
  public ExpressionInConclusion expressionInConclusion(final Rule rule, final int index) {
    RuleConclusion _conclusion = rule.getConclusion();
    EList<RuleConclusionElement> _conclusionElements = _conclusion.getConclusionElements();
    List<ExpressionInConclusion> _typeSelect = EcoreUtil2.<ExpressionInConclusion>typeSelect(_conclusionElements, ExpressionInConclusion.class);
    ExpressionInConclusion _get = _typeSelect.get(index);
    ExpressionInConclusion _ruleExpression = this.ruleExpression(_get);
    return _ruleExpression;
  }
  
  public ExpressionInConclusion ruleExpression(final RuleConclusionElement ruleConclusionElement) {
    return ((ExpressionInConclusion) ruleConclusionElement);
  }
  
  public void assertIsInstance(final Class<? extends Object> superClass, final Object o) {
    Class<? extends Object> _class = o.getClass();
    String _name = _class.getName();
    String _plus = (_name + " is not an instance of ");
    String _name_1 = superClass.getName();
    String _plus_1 = (_plus + _name_1);
    Class<? extends Object> _class_1 = o.getClass();
    boolean _isAssignableFrom = superClass.isAssignableFrom(_class_1);
    Assert.assertTrue(_plus_1, _isAssignableFrom);
  }
  
  public void assertOrExpression(final XExpression exp, final int branches) {
    OrExpression _orExpression = this.getOrExpression(exp);
    EList<XExpression> _branches = _orExpression.getBranches();
    int _size = _branches.size();
    Assert.assertEquals(branches, _size);
  }
  
  public OrExpression getOrExpression(final XExpression exp) {
    return ((OrExpression) exp);
  }
  
  public RuleInvocation getRuleInvocationFromPremises(final Rule rule) {
    EList<XExpression> _rulePremises = this.getRulePremises(rule);
    XExpression _get = _rulePremises.get(0);
    return ((RuleInvocation) _get);
  }
  
  public EnvironmentComposition getEnvironmentComposition(final EnvironmentSpecification envSpec) {
    return ((EnvironmentComposition) envSpec);
  }
  
  public EnvironmentMapping getEnvironmentMapping(final EnvironmentSpecification envSpec) {
    return ((EnvironmentMapping) envSpec);
  }
  
  public EnvironmentSpecification getEnvironmentSpecificationOfRuleInvocation(final Rule rule) {
    RuleInvocation _ruleInvocationFromPremises = this.getRuleInvocationFromPremises(rule);
    EnvironmentSpecification _environment = _ruleInvocationFromPremises.getEnvironment();
    return _environment;
  }
  
  public XAbstractFeatureCall getXAbstractFeatureCall(final int index) {
    CharSequence _testRuleWithFeatureCallsForBinaryOps = this.testFiles.testRuleWithFeatureCallsForBinaryOps();
    XsemanticsSystem _parse = this.parse(_testRuleWithFeatureCallsForBinaryOps);
    List<XAbstractFeatureCall> _xAbstractFeatureCalls = this.getXAbstractFeatureCalls(_parse);
    XAbstractFeatureCall _get = _xAbstractFeatureCalls.get(index);
    return _get;
  }
  
  public List<XAbstractFeatureCall> getXAbstractFeatureCalls(final XsemanticsSystem ts) {
    EList<Rule> _rules = ts.getRules();
    Rule _get = _rules.get(0);
    EList<XExpression> _rulePremises = this.getRulePremises(_get);
    List<XAbstractFeatureCall> _typeSelect = EcoreUtil2.<XAbstractFeatureCall>typeSelect(_rulePremises, XAbstractFeatureCall.class);
    return _typeSelect;
  }
  
  public EnvironmentAccess getEnvironmentAccess(final XsemanticsSystem ts) {
    EList<Rule> _rules = ts.getRules();
    Rule _get = _rules.get(0);
    EList<XExpression> _rulePremises = this.getRulePremises(_get);
    List<EnvironmentAccess> _typeSelect = EcoreUtil2.<EnvironmentAccess>typeSelect(_rulePremises, EnvironmentAccess.class);
    EnvironmentAccess _get_1 = _typeSelect.get(0);
    return _get_1;
  }
  
  public void assertEqualsStrings(final Object expected, final Object actual) {
    String _plus = ("" + expected);
    String _plus_1 = ("" + actual);
    Assert.assertEquals(_plus, _plus_1);
  }
  
  public XsemanticsSystem systemExtendsSystemWithJudgments() {
    CharSequence _testJudgmentDescriptions = this.testFiles.testJudgmentDescriptions();
    CharSequence _testSystemExtendsSystemWithJudgments = this.testFiles.testSystemExtendsSystemWithJudgments();
    XsemanticsSystem _parseWithBaseSystemAndAssertNoError = this.parseWithBaseSystemAndAssertNoError(_testJudgmentDescriptions, _testSystemExtendsSystemWithJudgments);
    return _parseWithBaseSystemAndAssertNoError;
  }
  
  public XsemanticsSystem systemExtendsSystemWithAdditionalJudgment() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    CharSequence _testSystemExtendsSystemWithJudgmentsReferringToEcore = this.testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore();
    XsemanticsSystem _parseWithBaseSystemAndAssertNoError = this.parseWithBaseSystemAndAssertNoError(_testJudgmentDescriptionsWithErrorSpecification, _testSystemExtendsSystemWithJudgmentsReferringToEcore);
    return _parseWithBaseSystemAndAssertNoError;
  }
  
  public XsemanticsSystem systemExtendsExtendedTypeSystem() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    CharSequence _testSystemExtendsSystemWithJudgmentsReferringToEcore = this.testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore();
    CharSequence _testSystemExtendsExtendedTypeSystem = this.testFiles.testSystemExtendsExtendedTypeSystem();
    XsemanticsSystem _parseWithBaseSystemAndAssertNoError = this.parseWithBaseSystemAndAssertNoError(_testJudgmentDescriptionsWithErrorSpecification, _testSystemExtendsSystemWithJudgmentsReferringToEcore, _testSystemExtendsExtendedTypeSystem);
    return _parseWithBaseSystemAndAssertNoError;
  }
  
  public XsemanticsSystem systemExtendsSystemWithRuleOverride() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    CharSequence _testSystemExtendsSystemWithJudgmentsReferringToEcore = this.testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore();
    CharSequence _testSystemExtendsExtendedTypeSystem = this.testFiles.testSystemExtendsExtendedTypeSystem();
    XsemanticsSystem _parseWithBaseSystemAndAssertNoError = this.parseWithBaseSystemAndAssertNoError(_testJudgmentDescriptionsWithErrorSpecification, _testSystemExtendsSystemWithJudgmentsReferringToEcore, _testSystemExtendsExtendedTypeSystem);
    CharSequence _testRuleOverride = this.testFiles.testRuleOverride();
    XsemanticsSystem _parseWithBaseSystemAndAssertNoError_1 = this.parseWithBaseSystemAndAssertNoError(_parseWithBaseSystemAndAssertNoError, _testRuleOverride);
    return _parseWithBaseSystemAndAssertNoError_1;
  }
  
  public XsemanticsSystem systemExtendsSystemWithJudgmentOverride() {
    XsemanticsSystem _loadBaseSystems = this.loadBaseSystems();
    CharSequence _testOverrideJudgment = this.testFiles.testOverrideJudgment();
    XsemanticsSystem _parseWithBaseSystemAndAssertNoError = this.parseWithBaseSystemAndAssertNoError(_loadBaseSystems, _testOverrideJudgment);
    return _parseWithBaseSystemAndAssertNoError;
  }
  
  public XsemanticsSystem loadBaseSystems() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    CharSequence _testSystemExtendsSystemWithJudgmentsReferringToEcore = this.testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore();
    CharSequence _testSystemExtendsExtendedTypeSystem = this.testFiles.testSystemExtendsExtendedTypeSystem();
    XsemanticsSystem _parseWithBaseSystemAndAssertNoError = this.parseWithBaseSystemAndAssertNoError(_testJudgmentDescriptionsWithErrorSpecification, _testSystemExtendsSystemWithJudgmentsReferringToEcore, _testSystemExtendsExtendedTypeSystem);
    return _parseWithBaseSystemAndAssertNoError;
  }
}
