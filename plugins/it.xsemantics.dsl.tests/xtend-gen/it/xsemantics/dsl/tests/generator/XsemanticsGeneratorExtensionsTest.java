package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest;
import it.xsemantics.dsl.util.XsemanticsUtils;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
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
  public void testTypeSystemToPackage() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    String _package = this._xsemanticsGeneratorExtensions.toPackage(_parseAndAssertNoError);
    Assert.assertEquals("it.xsemantics.test", _package);
  }
  
  @Test
  public void testTypeSystemToJavaClassFile() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    String _javaClassFile = this._xsemanticsGeneratorExtensions.toJavaClassFile(_parseAndAssertNoError);
    Assert.assertEquals("it/xsemantics/test/TypeSystem.java", _javaClassFile);
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
  public void testTypeSystemToJavaClassNameNoQualified() {
    CharSequence _typeSystemNoQualifiedName = this.testFiles.typeSystemNoQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemNoQualifiedName);
    String _javaClassName = this._xsemanticsGeneratorExtensions.toJavaClassName(_parseAndAssertNoError);
    Assert.assertEquals("TypeSystem", _javaClassName);
    CharSequence _typeSystemNoQualifiedName_1 = this.testFiles.typeSystemNoQualifiedName();
    XsemanticsSystem _parseAndAssertNoError_1 = this.parseAndAssertNoError(_typeSystemNoQualifiedName_1);
    String _javaClassFile = this._xsemanticsGeneratorExtensions.toJavaClassFile(_parseAndAssertNoError_1);
    Assert.assertEquals("TypeSystem.java", _javaClassFile);
  }
  
  @Test
  public void testTypeSystemToValidatorPackage() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    String _validatorPackage = this._xsemanticsGeneratorExtensions.toValidatorPackage(_parseAndAssertNoError);
    Assert.assertEquals("it.xsemantics.test.validation", _validatorPackage);
  }
  
  @Test
  public void testTypeSystemToValidatorJavaClassFile() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    String _validatorJavaClassFile = this._xsemanticsGeneratorExtensions.toValidatorJavaClassFile(_parseAndAssertNoError);
    Assert.assertEquals("it/xsemantics/test/validation/TypeSystemValidator.java", _validatorJavaClassFile);
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
  public void testRuleToJavaClassFile() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    String _javaClassFile = this._xsemanticsGeneratorExtensions.toJavaClassFile(_firstRule);
    Assert.assertEquals("it/xsemantics/test/rules/EClassEObject.java", _javaClassFile);
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
  public void testJvmTypeForTypeSystem() {
    CharSequence _typeSystemQualifiedName = this.testFiles.typeSystemQualifiedName();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_typeSystemQualifiedName);
    final JvmGenericType jvmType = this._xsemanticsGeneratorExtensions.createJvmType(_parseAndAssertNoError);
    String _identifier = jvmType.getIdentifier();
    Assert.assertEquals("it.xsemantics.test.TypeSystem", _identifier);
  }
  
  @Test
  public void testJvmTypeForBaseTypeSystem() {
    String _name = XsemanticsRuntimeSystem.class.getName();
    JvmGenericType _createJvmTypeForTypeSystemBaseClass = this._xsemanticsGeneratorExtensions.createJvmTypeForTypeSystemBaseClass();
    String _identifier = _createJvmTypeForTypeSystemBaseClass.getIdentifier();
    Assert.assertEquals(_name, _identifier);
  }
  
  @Test
  public void testJvmTypeForRule() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    final JvmGenericType jvmType = this._xsemanticsGeneratorExtensions.createJvmType(_firstRule);
    String _identifier = jvmType.getIdentifier();
    Assert.assertEquals("it.xsemantics.test.rules.EClassEObject", _identifier);
  }
  
  @Test
  public void testInjectAnnotation() {
    ImportManager _importManager = new ImportManager(true);
    String _injectAnnotation = this._xsemanticsGeneratorExtensions.injectAnnotation(_importManager);
    Assert.assertEquals("@Inject", _injectAnnotation);
  }
  
  @Test
  public void testCheckAnnotation() {
    ImportManager _importManager = new ImportManager(true);
    String _checkAnnotation = this._xsemanticsGeneratorExtensions.checkAnnotation(_importManager);
    Assert.assertEquals("@Check", _checkAnnotation);
  }
  
  @Test
  public void testRuleInputParameters() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    ImportManager _importManager = new ImportManager(true);
    String _inputParameters = this._xsemanticsGeneratorExtensions.inputParameters(_firstRule, _importManager);
    String _string = _inputParameters.toString();
    Assert.assertEquals("final EClass eClass, final EObject object", _string);
  }
  
  @Test
  public void errorInformationArgs() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    ImportManager _importManager = new ImportManager(true);
    String _errorInformationArgs = this._xsemanticsGeneratorExtensions.errorInformationArgs(_firstRule, _importManager);
    String _string = _errorInformationArgs.toString();
    Assert.assertEquals(", new ErrorInformation(eClass), new ErrorInformation(object)", _string);
  }
  
  @Test
  public void errorInformationArgsEmpty() {
    CharSequence _testRulesWithOnlyNonEObjectParams = this.testFiles.testRulesWithOnlyNonEObjectParams();
    Rule _firstRule = this.getFirstRule(_testRulesWithOnlyNonEObjectParams);
    ImportManager _importManager = new ImportManager(true);
    String _errorInformationArgs = this._xsemanticsGeneratorExtensions.errorInformationArgs(_firstRule, _importManager);
    String _string = _errorInformationArgs.toString();
    Assert.assertEquals("", _string);
  }
  
  @Test
  public void testJudgmentDescriptionInputParameters() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    JudgmentDescription _judgmentDescription = this._xsemanticsUtils.judgmentDescription(_firstRule);
    ImportManager _importManager = new ImportManager(true);
    String _inputParameters = this._xsemanticsGeneratorExtensions.inputParameters(_judgmentDescription, _importManager);
    String _string = _inputParameters.toString();
    Assert.assertEquals("final EClass c, final EObject o", _string);
  }
  
  @Test
  public void testJudgmentDescriptionInputParametersWithParametrizedTypes() {
    CharSequence _testJudgmentDescriptionsRelatedToXsemantics = this.testFiles.testJudgmentDescriptionsRelatedToXsemantics();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsRelatedToXsemantics);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    ImportManager _importManager = new ImportManager(true);
    String _inputParameters = this._xsemanticsGeneratorExtensions.inputParameters(_get, _importManager);
    String _string = _inputParameters.toString();
    Assert.assertEquals("final List<Import> list, final Set<JudgmentDescription> set", _string);
  }
  
  @Test
  public void testInputParametersWithNameClashes() {
    CharSequence _fjJudgmentDescriptions = this.fjTestFiles.fjJudgmentDescriptions();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_fjJudgmentDescriptions);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(1);
    ImportManager _importManager = new ImportManager(true);
    String _inputParameters = this._xsemanticsGeneratorExtensions.inputParameters(_get, _importManager);
    String _string = _inputParameters.toString();
    Assert.assertEquals("final Type left, final Type right", _string);
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
  public void testRuleReturnTypeWithoutOutputParams() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    ImportManager _importManager = new ImportManager(true);
    IAppendable _ruleResultTypeParameters = this._xsemanticsGeneratorExtensions.ruleResultTypeParameters(_firstRule, _importManager);
    String _string = _ruleResultTypeParameters.toString();
    Assert.assertEquals("Boolean", _string);
  }
  
  @Test
  public void testResultTypeForCheckRule() {
    CharSequence _testCheckRule = this.testFiles.testCheckRule();
    CheckRule _firstCheckRule = this.getFirstCheckRule(_testCheckRule);
    ImportManager _importManager = new ImportManager(true);
    CharSequence _resultType = this._xsemanticsGeneratorExtensions.resultType(_firstCheckRule, _importManager);
    String _string = _resultType.toString();
    Assert.assertEquals("Result<Boolean>", _string);
  }
  
  @Test
  public void testInputParameterForCheckRule() {
    CharSequence _testCheckRule = this.testFiles.testCheckRule();
    CheckRule _firstCheckRule = this.getFirstCheckRule(_testCheckRule);
    ImportManager _importManager = new ImportManager(true);
    CharSequence _inputParameter = this._xsemanticsGeneratorExtensions.inputParameter(_firstCheckRule, _importManager);
    String _string = _inputParameter.toString();
    Assert.assertEquals("final EObject obj", _string);
  }
  
  @Test
  public void testRuleReturnWithoutOutputParams() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    ImportManager _importManager = new ImportManager(true);
    String _resultType = this._xsemanticsGeneratorExtensions.resultType(_firstRule, _importManager);
    String _string = _resultType.toString();
    Assert.assertEquals("Result<Boolean>", _string);
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
  public void testJudgmentDescriptionResultType() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testSimpleRule);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    ImportManager _importManager = new ImportManager(true);
    String _resultType = this._xsemanticsGeneratorExtensions.resultType(_get, _importManager);
    String _string = _resultType.toString();
    Assert.assertEquals("Result<Boolean>", _string);
  }
  
  @Test
  public void testJudgmentDescriptionResultType2() {
    CharSequence _testJudgmentDescriptionsWith2OutputParams = this.testFiles.testJudgmentDescriptionsWith2OutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWith2OutputParams);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    ImportManager _importManager = new ImportManager(true);
    String _resultType = this._xsemanticsGeneratorExtensions.resultType(_get, _importManager);
    String _string = _resultType.toString();
    Assert.assertEquals("Result2<EObject, EStructuralFeature>", _string);
  }
  
  @Test
  public void testSuffixStartingFrom2WithTwoOutputs() {
    CharSequence _testJudgmentDescriptionsWith2OutputParams = this.testFiles.testJudgmentDescriptionsWith2OutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWith2OutputParams);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    String _suffixStartingFrom2 = this._xsemanticsGeneratorExtensions.suffixStartingFrom2(_get);
    Assert.assertEquals("2", _suffixStartingFrom2);
  }
  
  @Test
  public void testSuffixStartingFrom2WithOneOutput() {
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
  public void testJudgmentDescriptionResultTypeWithAppendable() {
    final FakeTreeAppendable appendable = this.createAppendable();
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testSimpleRule);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    IAppendable _resultType = this._xsemanticsGeneratorExtensions.resultType(_get, appendable);
    String _string = _resultType.toString();
    Assert.assertEquals("Result<Boolean>", _string);
  }
  
  @Test
  public void testAdditionalParamsDeclaration() {
    ImportManager _importManager = new ImportManager(true);
    CharSequence _additionalParamsDeclaration = this._xsemanticsGeneratorExtensions.additionalParamsDeclaration(_importManager);
    String _string = _additionalParamsDeclaration.toString();
    Assert.assertEquals("final RuleEnvironment _environment_, final RuleApplicationTrace _trace_", _string);
  }
  
  @Test
  public void testAdditionalParamsDeclarationForRule() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    ImportManager _importManager = new ImportManager(true);
    CharSequence _additionalParamsDeclaration = this._xsemanticsGeneratorExtensions.additionalParamsDeclaration(_firstRule, _importManager);
    String _string = _additionalParamsDeclaration.toString();
    Assert.assertEquals("final RuleEnvironment G, final RuleApplicationTrace _trace_", _string);
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
  public void testRuleIssueDeclaration() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    Rule _firstRule = this.getFirstRule(_testSimpleRule);
    ImportManager _importManager = new ImportManager(true);
    CharSequence _ruleIssueDeclaration = this._xsemanticsGeneratorExtensions.ruleIssueDeclaration(_firstRule, _importManager);
    this.assertEqualsStrings("public final static String ECLASSEOBJECT = \"it.xsemantics.test.rules.EClassEObject\";", _ruleIssueDeclaration);
  }
}
