package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.AuxiliaryDescription;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProviderCustom.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsGeneratorExtensionsTest extends XsemanticsGeneratorBaseTest {
  @Inject
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  @Inject
  private XsemanticsUtils _xsemanticsUtils;
  
  @Test
  public void testTypeSystemToPackageWithNullName() {
    XsemanticsSystem _parse = this.parse("system ");
    String _package = this._xsemanticsGeneratorExtensions.toPackage(_parse);
    Assert.assertEquals(null, _package);
  }
  
  @Test
  public void testTypeSystemToPackage() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    String _package = this._xsemanticsGeneratorExtensions.toPackage(_parseAndAssertNoError);
    Assert.assertEquals("it.xsemantics.test", _package);
  }
  
  @Test
  public void testTypeSystemToJavaFullyQualifiedName() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    String _javaFullyQualifiedName = this._xsemanticsGeneratorExtensions.toJavaFullyQualifiedName(_parseAndAssertNoError);
    Assert.assertEquals("it.xsemantics.test.TypeSystem", _javaFullyQualifiedName);
  }
  
  @Test
  public void testTypeSystemToJavaClassName() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    String _javaClassName = this._xsemanticsGeneratorExtensions.toJavaClassName(_parseAndAssertNoError);
    Assert.assertEquals("TypeSystem", _javaClassName);
  }
  
  @Test
  public void testTypeSystemToValidatorPackage() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    String _validatorPackage = this._xsemanticsGeneratorExtensions.toValidatorPackage(_parseAndAssertNoError);
    Assert.assertEquals("it.xsemantics.test.validation", _validatorPackage);
  }
  
  @Test
  public void testTypeSystemToValidatorJavaFullyQualifiedName() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    String _validatorJavaFullyQualifiedName = this._xsemanticsGeneratorExtensions.toValidatorJavaFullyQualifiedName(_parseAndAssertNoError);
    Assert.assertEquals("it.xsemantics.test.validation.TypeSystemValidator", _validatorJavaFullyQualifiedName);
  }
  
  @Test
  public void testRuleToPackage() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    String _package = this._xsemanticsGeneratorExtensions.toPackage(_firstRule);
    Assert.assertEquals("it.xsemantics.test.rules", _package);
  }
  
  @Test
  public void testRuleToFullyQualifiedName() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    String _javaFullyQualifiedName = this._xsemanticsGeneratorExtensions.toJavaFullyQualifiedName(_firstRule);
    Assert.assertEquals("it.xsemantics.test.rules.EClassEObject", _javaFullyQualifiedName);
  }
  
  @Test
  public void testRuleToJavaName() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    String _javaClassName = this._xsemanticsGeneratorExtensions.toJavaClassName(_firstRule);
    Assert.assertEquals("EClassEObject", _javaClassName);
  }
  
  @Test
  public void testRuleToJavaNameFirstToUpper() {
    CharSequence _testSimpleAxiom = this.testFiles.testSimpleAxiom();
    Rule _firstRule = this.getFirstRule(_testSimpleAxiom);
    String _javaClassName = this._xsemanticsGeneratorExtensions.toJavaClassName(_firstRule);
    Assert.assertEquals("EClassEObject", _javaClassName);
  }
  
  @Test
  public void testJudgmentDescriptionInputArgs() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_firstRule);
    String _inputArgs = this._xsemanticsGeneratorExtensions.inputArgs(_judgmentDescription);
    String _string = _inputArgs.toString();
    Assert.assertEquals("c, o", _string);
  }
  
  @Test
  public void testRuleInputParameterNames() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    String _inputParameterNames = this._xsemanticsGeneratorExtensions.inputParameterNames(_firstRule);
    String _string = _inputParameterNames.toString();
    Assert.assertEquals("eClass, object", _string);
  }
  
  @Test
  public void testPolymorphicDispatcherNumOfArgs() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_firstRule);
    CharSequence _polymorphicDispatcherNumOfArgs = this._xsemanticsGeneratorExtensions.polymorphicDispatcherNumOfArgs(_judgmentDescription);
    String _string = _polymorphicDispatcherNumOfArgs.toString();
    Assert.assertEquals("4", _string);
  }
  
  @Test
  public void testPolymorphicDispatcherNumOfArgs2() {
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_firstRule);
    CharSequence _polymorphicDispatcherNumOfArgs = this._xsemanticsGeneratorExtensions.polymorphicDispatcherNumOfArgs(_judgmentDescription);
    String _string = _polymorphicDispatcherNumOfArgs.toString();
    Assert.assertEquals("4", _string);
  }
  
  @Test
  public void testSuffixStartingFrom2With3Outputs() {
    CharSequence _testJudgmentDescriptionsWith3OutputParams = this.testFiles.testJudgmentDescriptionsWith3OutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWith3OutputParams);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    String _suffixStartingFrom2 = this._xsemanticsGeneratorExtensions.suffixStartingFrom2(_get);
    Assert.assertEquals("3", _suffixStartingFrom2);
  }
  
  @Test
  public void testSuffixStartingFrom2With2Outputs() {
    CharSequence _testJudgmentDescriptionsWith2OutputParams = this.testFiles.testJudgmentDescriptionsWith2OutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWith2OutputParams);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    String _suffixStartingFrom2 = this._xsemanticsGeneratorExtensions.suffixStartingFrom2(_get);
    Assert.assertEquals("2", _suffixStartingFrom2);
  }
  
  @Test
  public void testSuffixStartingFrom2With1Output() {
    CharSequence _testJudgmentDescriptionsEObjectEClass = this.testFiles.testJudgmentDescriptionsEObjectEClass();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsEObjectEClass);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    String _suffixStartingFrom2 = this._xsemanticsGeneratorExtensions.suffixStartingFrom2(_get);
    Assert.assertEquals("", _suffixStartingFrom2);
  }
  
  @Test
  public void testSuffixStartingFrom2WithoutOutput() {
    CharSequence _testJudgmentDescriptionsReferringToEcore = this.testFiles.testJudgmentDescriptionsReferringToEcore();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsReferringToEcore);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    String _suffixStartingFrom2 = this._xsemanticsGeneratorExtensions.suffixStartingFrom2(_get);
    Assert.assertEquals("", _suffixStartingFrom2);
  }
  
  @Test
  public void testAdditionalArgs() {
    CharSequence _additionalArgs = this._xsemanticsGeneratorExtensions.additionalArgs();
    String _string = _additionalArgs.toString();
    Assert.assertEquals("_environment_, _trace_", _string);
  }
  
  @Test
  public void testAdditionalArgsForRule() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    CharSequence _additionalArgsForRule = this._xsemanticsGeneratorExtensions.additionalArgsForRule(_firstRule);
    String _string = _additionalArgsForRule.toString();
    Assert.assertEquals("G, _subtrace_", _string);
  }
  
  @Test
  public void testAdditionalArgsForRuleInvocation() {
    CharSequence _testRuleOnlyInvokingRules = this.testFiles.testRuleOnlyInvokingRules();
    Rule _firstRule = this.getFirstRule(_testRuleOnlyInvokingRules);
    RuleInvocation _ruleInvocationFromPremises = this.getRuleInvocationFromPremises(_firstRule);
    CharSequence _additionalArgsForRuleInvocation = this._xsemanticsGeneratorExtensions.additionalArgsForRuleInvocation(_ruleInvocationFromPremises);
    String _string = _additionalArgsForRuleInvocation.toString();
    Assert.assertEquals("_trace_", _string);
  }
  
  @Test
  public void testJavaString() {
    String _javaString = this._xsemanticsGeneratorExtensions.javaString("foo");
    Assert.assertEquals("foo", _javaString);
    String _javaString_1 = this._xsemanticsGeneratorExtensions.javaString("\'foo\'");
    Assert.assertEquals("\\\'foo\\\'", _javaString_1);
    String _javaString_2 = this._xsemanticsGeneratorExtensions.javaString("\"foo\"");
    Assert.assertEquals("\\\"foo\\\"", _javaString_2);
  }
  
  @Test
  public void testErrorForRuleWithoutOutput() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ruleName(\"EClassEObject\") + stringRepForEnv(G) + \" |- \" + stringRep(eClass) + \" : \" + stringRep(object)");
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    String _errorForRule = this._xsemanticsGeneratorExtensions.errorForRule(_firstRule);
    this.assertEqualsStrings(_builder, _errorForRule);
  }
  
  @Test
  public void testErrorForRuleWithOutput() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ruleName(\"EClassEObjectEStructuralFeature\") + stringRepForEnv(G) + \" |- \" + stringRep(eClass) + \" : \" + \"EObject\" + \" : \" + stringRep(feat)");
    CharSequence _testRuleWithOutputParams = this.testFiles.testRuleWithOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithOutputParams);
    String _errorForRule = this._xsemanticsGeneratorExtensions.errorForRule(_firstRule);
    this.assertEqualsStrings(_builder, _errorForRule);
  }
  
  @Test
  public void testTraceStringForRuleWithoutOutput() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ruleName(\"EClassEObject\") + stringRepForEnv(G) + \" |- \" + stringRep(eClass) + \" : \" + stringRep(object)");
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    String _traceStringForRule = this._xsemanticsGeneratorExtensions.traceStringForRule(_firstRule);
    this.assertEqualsStrings(_builder, _traceStringForRule);
  }
  
  @Test
  public void testTraceStringForRuleWithOutput() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ruleName(\"EClassEObjectEStructuralFeature\") + stringRepForEnv(G) + \" ||- \" + stringRep(eClass) + \" : \" + stringRep(_result_.getFirst()) + \" : \" + stringRep(_result_.getSecond())");
    CharSequence _testRuleWithTwoOutputParams = this.testFiles.testRuleWithTwoOutputParams();
    Rule _firstRule = this.getFirstRule(_testRuleWithTwoOutputParams);
    String _traceStringForRule = this._xsemanticsGeneratorExtensions.traceStringForRule(_firstRule);
    this.assertEqualsStrings(_builder, _traceStringForRule);
  }
  
  @Test
  public void testRuleIssueString() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    String _ruleIssueString = this._xsemanticsGeneratorExtensions.ruleIssueString(_firstRule);
    this.assertEqualsStrings("ECLASSEOBJECT", _ruleIssueString);
  }
  
  @Test
  public void testResultTypeWithNoOutputParameter() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    this.assertResultType(_testSimpleRule, "Result<Boolean>");
  }
  
  @Test
  public void testResultTypeWithOneOutputParameter() {
    CharSequence _testJudgmentDescriptionsReferringToEcoreWithOutput = this.testFiles.testJudgmentDescriptionsReferringToEcoreWithOutput();
    this.assertResultType(_testJudgmentDescriptionsReferringToEcoreWithOutput, "Result<EObject>");
  }
  
  @Test
  public void testResultTypeWith2OutputParameters() {
    CharSequence _testJudgmentDescriptionsWith2OutputParams = this.testFiles.testJudgmentDescriptionsWith2OutputParams();
    this.assertResultType(_testJudgmentDescriptionsWith2OutputParams, "Result2<EObject,EStructuralFeature>");
  }
  
  @Test
  public void testResultTypeWith3OutputParameters() {
    CharSequence _testJudgmentDescriptionsWith3OutputParams = this.testFiles.testJudgmentDescriptionsWith3OutputParams();
    this.assertResultType(_testJudgmentDescriptionsWith3OutputParams, "Result3<EObject,EStructuralFeature,String>");
  }
  
  @Test
  public void testResultForCheckRule() {
    final FakeTreeAppendable a = this.createAppendable();
    CharSequence _testCheckRule = this.testFiles.testCheckRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testCheckRule);
    EList<CheckRule> _checkrules = _parseAndAssertNoError.getCheckrules();
    CheckRule _get = _checkrules.get(0);
    this._xsemanticsGeneratorExtensions.resultType(_get, a);
    this.assertEqualsStrings("Result<Boolean>", a);
  }
  
  @Test
  public void testAssociatedToAuxiliaryFunction() {
    CharSequence _testAuxiliaryFunctionsInvocation = this.testFiles.testAuxiliaryFunctionsInvocation();
    final XsemanticsSystem system = this.parseAndAssertNoError(_testAuxiliaryFunctionsInvocation);
    Rule _rule = this.getRule(system, 0);
    EList<XExpression> _rulePremises = this.getRulePremises(_rule);
    XExpression _get = _rulePremises.get(0);
    final XAbstractFeatureCall featureCall = ((XAbstractFeatureCall) _get);
    EList<AuxiliaryDescription> _auxiliaryDescriptions = system.getAuxiliaryDescriptions();
    AuxiliaryDescription _get_1 = _auxiliaryDescriptions.get(0);
    JvmIdentifiableElement _feature = featureCall.getFeature();
    AuxiliaryDescription _associatedAuxiliaryDescription = this._xsemanticsGeneratorExtensions.associatedAuxiliaryDescription(_feature);
    Assert.assertEquals(_get_1, _associatedAuxiliaryDescription);
  }
  
  public void assertResultType(final CharSequence prog, final CharSequence expected) {
    final FakeTreeAppendable a = this.createAppendable();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    this._xsemanticsGeneratorExtensions.resultType(_get, a);
    this.assertEqualsStrings(expected, a);
  }
}
