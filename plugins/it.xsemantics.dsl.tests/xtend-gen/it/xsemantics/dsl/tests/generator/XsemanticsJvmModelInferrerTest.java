package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.jvmmodel.XsemanticsJvmModelInferrer;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsJvmModelInferrerTest extends XsemanticsGeneratorBaseTest {
  @Inject
  protected JvmModelGenerator generator;
  
  @Inject
  @Extension
  protected XsemanticsJvmModelInferrer inferrer;
  
  @Test
  public void testIssueField() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public final static String ECLASSEOBJECT = \"it.xsemantics.test.rules.EClassEObject\";");
    this.assertIssueField(_testSimpleRule, _builder);
  }
  
  public void testConstructor() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ConstructorName() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("init();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertConstructor(_testSimpleRule, _builder);
  }
  
  public void testInit() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void init() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("typeDispatcher = buildPolymorphicDispatcher1(");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("\"typeImpl\", 4, \"|-\", \":\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertInit(_testSimpleRule, _builder);
  }
  
  @Test
  public void testPolymorphicDispatcherField() {
    CharSequence _testJudgmentDescriptionsWith3OutputParams = this.testFiles.testJudgmentDescriptionsWith3OutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWith3OutputParams);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    JvmField _genPolymorphicDispatcherField = this.inferrer.genPolymorphicDispatcherField(_get);
    this.assertGeneratedMember(_genPolymorphicDispatcherField, "private PolymorphicDispatcher<Result3<EObject,EStructuralFeature,String>> typeDispatcher;");
  }
  
  public void testEntryPointMethods() {
    CharSequence _testJudgmentDescriptionsWith3OutputParams = this.testFiles.testJudgmentDescriptionsWith3OutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWith3OutputParams);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    ArrayList<JvmOperation> _genEntryPointMethods = this.inferrer.genEntryPointMethods(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public Result3<EObject,EStructuralFeature,String> type(final EClass c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(new RuleEnvironment(), null, c);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result3<EObject,EStructuralFeature,String> type(final RuleEnvironment _environment_, final EClass c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return type(_environment_, null, c);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result3<EObject,EStructuralFeature,String> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeInternal(_environment_, _trace_, c);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return resultForFailure3(_e_type);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMembers(_genEntryPointMethods, _builder);
  }
  
  @Test
  public void testThrowExceptionMethodNull() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testSimpleRule);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    JvmOperation _compileThrowExceptionMethod = this.inferrer.compileThrowExceptionMethod(_get);
    Assert.assertNotNull(_compileThrowExceptionMethod);
  }
  
  public void testThrowExceptionMethod() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWithErrorSpecification);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    JvmOperation _compileThrowExceptionMethod = this.inferrer.compileThrowExceptionMethod(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject c, final ErrorInformation[] _errorInformations) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _plus = (\"this \" + c);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _plus_1 = (_plus + \" made an error!\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String error = _plus_1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EObject source = c;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EClass _eClass = c.eClass();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EStructuralFeature feature = _eContainingFeature;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("throwRuleFailedException(error,");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("_issue, _ex, new ErrorInformation(source, feature));");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMember(_compileThrowExceptionMethod, _builder);
  }
  
  public void testInternalMethod() {
    CharSequence _testJudgmentDescriptionsWith2OutputParams = this.testFiles.testJudgmentDescriptionsWith2OutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWith2OutputParams);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    JvmOperation _compileInternalMethod = this.inferrer.compileInternalMethod(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected Result2<EObject,EStructuralFeature> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("checkParamsNotNull(c);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return typeDispatcher.invoke(_environment_, _trace_, c);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception _e_type) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("sneakyThrowRuleFailedException(_e_type);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMember(_compileInternalMethod, _builder);
  }
  
  public void testCheckRuleInternalMethod() {
    CharSequence _testCheckRule = this.testFiles.testCheckRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testCheckRule);
    EList<CheckRule> _checkrules = _parseAndAssertNoError.getCheckrules();
    CheckRule _get = _checkrules.get(0);
    JvmOperation _compileInternalMethod = this.inferrer.compileInternalMethod(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected Result<Boolean> checkEObjectInternal(final RuleApplicationTrace _trace_, final EObject obj) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("EClass result = null;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("/* empty |- obj : result */");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("Result<EClass> result_1 = typeInternal(emptyEnvironment(), _trace_, obj);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("checkAssignableTo(result_1.getFirst(), EClass.class);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("result = (EClass) result_1.getFirst();");
    _builder.newLine();
    _builder.append("      ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return new Result<Boolean>(true);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMember(_compileInternalMethod, _builder);
  }
  
  public void testCheckRuleMethod() {
    CharSequence _testCheckRule = this.testFiles.testCheckRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testCheckRule);
    EList<CheckRule> _checkrules = _parseAndAssertNoError.getCheckrules();
    CheckRule _get = _checkrules.get(0);
    ArrayList<JvmOperation> _compileCheckRuleMethods = this.inferrer.compileCheckRuleMethods(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public Result<Boolean> checkEObject(final EObject obj) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return checkEObject(null, obj);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public Result<Boolean> checkEObject(final RuleApplicationTrace _trace_, final EObject obj) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return checkEObjectInternal(_trace_, obj);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return resultForFailure(e);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMembers(_compileCheckRuleMethods, _builder);
  }
  
  public void testApplyMethodForAxiom() {
    CharSequence _testSimpleAxiom = this.testFiles.testSimpleAxiom();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testSimpleAxiom);
    EList<Rule> _rules = _parseAndAssertNoError.getRules();
    Rule _get = _rules.get(0);
    JvmOperation _compileApplyMethod = this.inferrer.compileApplyMethod(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected Result<Boolean> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return new Result<Boolean>(true);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMember(_compileApplyMethod, _builder);
  }
  
  public void testApplyMethodForAxiomWithExpressionInConclusion() {
    CharSequence _testAxiomWithExpressionInConclusion = this.testFiles.testAxiomWithExpressionInConclusion();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testAxiomWithExpressionInConclusion);
    EList<Rule> _rules = _parseAndAssertNoError.getRules();
    Rule _get = _rules.get(0);
    JvmOperation _compileApplyMethod = this.inferrer.compileApplyMethod(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject object) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EClass _eClass = object.eClass();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return new Result<EClass>(_eClass);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMember(_compileApplyMethod, _builder);
  }
  
  public void testApplyMethodForRuleWithPremise() {
    CharSequence _testRuleWithTwoOutputParams = this.testFiles.testRuleWithTwoOutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testRuleWithTwoOutputParams);
    EList<Rule> _rules = _parseAndAssertNoError.getRules();
    Rule _get = _rules.get(0);
    JvmOperation _compileApplyMethod = this.inferrer.compileApplyMethod(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected Result2<EObject,EStructuralFeature> applyRuleEClassEObjectEStructuralFeature(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EObject object = null; // output parameter");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("EStructuralFeature feat = null; // output parameter");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* G ||- eClass : object : feat */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Result2<EObject,EStructuralFeature> result = type2Internal(G, _trace_, eClass);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("checkAssignableTo(result.getFirst(), EObject.class);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("object = (EObject) result.getFirst();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("checkAssignableTo(result.getSecond(), EStructuralFeature.class);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("feat = (EStructuralFeature) result.getSecond();");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return new Result2<EObject,EStructuralFeature>(object, feat);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMember(_compileApplyMethod, _builder);
  }
  
  @Test
  public void testErrorInformationArgsWithOneEObjectArg() {
    CharSequence _testRuleWithTwoOutputParams = this.testFiles.testRuleWithTwoOutputParams();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ErrorInformation(eClass)");
    this.assertErrorInformationArgs(_testRuleWithTwoOutputParams, _builder);
  }
  
  @Test
  public void testErrorInformationArgsWithTwoEObjectArg() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ErrorInformation(eClass), new ErrorInformation(object)");
    this.assertErrorInformationArgs(_testSimpleRule, _builder);
  }
  
  @Test
  public void testErrorInformationWithNoEObjectArg() {
    CharSequence _testRulesOfTheSameKind = this.testFiles.testRulesOfTheSameKind();
    StringConcatenation _builder = new StringConcatenation();
    this.assertErrorInformationArgs(_testRulesOfTheSameKind, _builder);
  }
  
  @Test
  public void testFinalThrowWithNoErrorInformation() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typeThrowException(ruleName(\"EClassEObject\") + stringRepForEnv(G) + \" |- \" + stringRep(eClass) + \" : \" + stringRep(object),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ECLASSEOBJECT,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("e_applyRuleEClassEObject, eClass, object, new ErrorInformation[] {new ErrorInformation(eClass), new ErrorInformation(object)})");
    this.assertFinalThrow(_testSimpleRule, _builder);
  }
  
  @Test
  public void testFinalThrowRuleJudgmentErrorInformation() {
    CharSequence _testRuleJudgmentDescriptionsWithErrorSpecification = this.testFiles.testRuleJudgmentDescriptionsWithErrorSpecification();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typeThrowException(ruleName(\"TestRule\") + stringRepForEnv(G) + \" |- \" + stringRep(o) + \" : \" + \"EClass\",");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("TESTRULE,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("e_applyRuleTestRule, o, new ErrorInformation[] {new ErrorInformation(o)})");
    this.assertFinalThrow(_testRuleJudgmentDescriptionsWithErrorSpecification, _builder);
  }
  
  @Test
  public void testFinalThrowRuleErrorInformation() {
    CharSequence _testRuleWithErrorSpecifications = this.testFiles.testRuleWithErrorSpecifications();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("eClassEObjectThrowException(e_applyRuleEClassEObject, eClass, object)");
    this.assertFinalThrow(_testRuleWithErrorSpecifications, _builder);
  }
  
  public void testCompileImplMethod() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testSimpleRule);
    EList<Rule> _rules = _parseAndAssertNoError.getRules();
    Rule _get = _rules.get(0);
    JvmOperation _compileImplMethod = this.inferrer.compileImplMethod(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("RuleApplicationTrace _subtrace_ = newTrace(_trace_);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("addToTrace(_trace_, ruleName(\"EClassEObject\") + stringRepForEnv(G) + \" |- \" + stringRep(eClass) + \" : \" + stringRep(object));");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("addAsSubtrace(_trace_, _subtrace_);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return _result_;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} catch (Exception e_applyRuleEClassEObject) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("typeThrowException(ruleName(\"EClassEObject\") + stringRepForEnv(G) + \" |- \" + stringRep(eClass) + \" : \" + stringRep(object),");
    _builder.newLine();
    _builder.append("      \t");
    _builder.append("ECLASSEOBJECT,");
    _builder.newLine();
    _builder.append("      \t");
    _builder.append("e_applyRuleEClassEObject, eClass, object, new ErrorInformation[] {new ErrorInformation(eClass), new ErrorInformation(object)});");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMember(_compileImplMethod, _builder);
  }
  
  public void testCompileValidatorCheckRuleMethod() {
    CharSequence _testCheckRule = this.testFiles.testCheckRule();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testCheckRule);
    EList<CheckRule> _checkrules = _parseAndAssertNoError.getCheckrules();
    CheckRule _get = _checkrules.get(0);
    JvmOperation _compileValidatorCheckRuleMethod = this.inferrer.compileValidatorCheckRuleMethod(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Check");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void checkEObject(final EObject obj) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("errorGenerator.generateErrors(this,");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("getXsemanticsSystem().checkEObject(obj),");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("obj);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMember(_compileValidatorCheckRuleMethod, _builder);
  }
  
  public void assertIssueField(final CharSequence prog, final CharSequence expected) {
    Rule _firstRule = this.getFirstRule(prog);
    final JvmField field = this.inferrer.genIssueField(_firstRule);
    this.assertGeneratedMember(field, expected);
  }
  
  public void assertConstructor(final CharSequence prog, final CharSequence expected) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    final JvmConstructor cons = this.inferrer.genConstructor(_parseAndAssertNoError);
    cons.setSimpleName("ConstructorName");
    this.assertGeneratedMember(cons, expected);
  }
  
  public void assertInit(final CharSequence prog, final CharSequence expected) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    final JvmOperation m = this.inferrer.genInit(_parseAndAssertNoError);
    this.assertGeneratedMember(m, expected);
  }
  
  public void assertErrorInformationArgs(final CharSequence prog, final CharSequence expected) {
    final FakeTreeAppendable a = this.createTestAppendable();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    EList<Rule> _rules = _parseAndAssertNoError.getRules();
    Rule _get = _rules.get(0);
    this.inferrer.errorInformationArgs(_get, a);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(", new ErrorInformation[] {");
    _builder.append(expected, "");
    _builder.append("}");
    String _string = a.toString();
    String _trim = _string.trim();
    this.assertEqualsStrings(_builder, _trim);
  }
  
  public void assertFinalThrow(final CharSequence prog, final CharSequence expected) {
    final FakeTreeAppendable a = this.createTestAppendable();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    EList<Rule> _rules = _parseAndAssertNoError.getRules();
    Rule _get = _rules.get(0);
    this.inferrer.compileFinalThrow(_get, a);
    String _string = a.toString();
    String _trim = _string.trim();
    this.assertEqualsStrings(expected, _trim);
  }
  
  public void assertGeneratedMember(final JvmMember member, final CharSequence expected) {
    final FakeTreeAppendable a = this.createTestAppendable();
    GeneratorConfig _generatorConfig = this.generatorConfig();
    this.generator.generateMember(member, a, _generatorConfig);
    String _string = a.toString();
    String _trim = _string.trim();
    this.assertEqualsStrings(expected, _trim);
  }
  
  public void assertGeneratedMembers(final Iterable<? extends JvmMember> members, final CharSequence expected) {
    final FakeTreeAppendable a = this.createTestAppendable();
    final Procedure1<JvmMember> _function = new Procedure1<JvmMember>() {
        public void apply(final JvmMember it) {
          GeneratorConfig _generatorConfig = XsemanticsJvmModelInferrerTest.this.generatorConfig();
          XsemanticsJvmModelInferrerTest.this.generator.generateMember(it, a, _generatorConfig);
        }
      };
    IterableExtensions.forEach(members, _function);
    String _string = a.toString();
    String _trim = _string.trim();
    this.assertEqualsStrings(expected, _trim);
  }
  
  public FakeTreeAppendable createTestAppendable() {
    ImportManager _importManager = new ImportManager(true);
    FakeTreeAppendable _fakeTreeAppendable = new FakeTreeAppendable(_importManager);
    return _fakeTreeAppendable;
  }
}
