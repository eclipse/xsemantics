package it.xsemantics.dsl.tests.inferrer;

import com.google.inject.Inject;
import it.xsemantics.dsl.jvmmodel.TempJvmModelInferrer;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderForInferrer;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.ArrayList;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProviderForInferrer.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsJvmModelInferrerTest extends XsemanticsBaseTest {
  @Inject
  protected JvmModelGenerator generator;
  
  @Inject
  protected TempJvmModelInferrer inferrer;
  
  @Test
  public void testIssueField() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public final static String ECLASSEOBJECT = \"it.xsemantics.test.rules.EClassEObject\";");
    this.assertIssueField(_testSimpleRule, _builder);
  }
  
  @Test
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
  
  @Test
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
    CharSequence _testJudgmentDescriptionsWith2OutputParams = this.testFiles.testJudgmentDescriptionsWith2OutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWith2OutputParams);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    JvmField _genPolymorphicDispatcherField = this.inferrer.genPolymorphicDispatcherField(_get);
    this.assertGeneratedMember(_genPolymorphicDispatcherField, "private PolymorphicDispatcher<Result2<EObject,EStructuralFeature>> typeDispatcher;");
  }
  
  @Test
  public void testEntryPointMethods() {
    CharSequence _testJudgmentDescriptionsWith2OutputParams = this.testFiles.testJudgmentDescriptionsWith2OutputParams();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWith2OutputParams);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    ArrayList<JvmOperation> _genEntryPointMethods = this.inferrer.genEntryPointMethods(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public Result2<EObject,EStructuralFeature> type(final EClass c) {");
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
    _builder.append("public Result2<EObject,EStructuralFeature> type(final RuleEnvironment _environment_, final EClass c) {");
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
    _builder.append("public Result2<EObject,EStructuralFeature> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {");
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
    _builder.append("return resultForFailure2(_e_type);");
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
    Assert.assertNull(_compileThrowExceptionMethod);
  }
  
  @Test
  public void testThrowExceptionMethod() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(_testJudgmentDescriptionsWithErrorSpecification);
    EList<JudgmentDescription> _judgmentDescriptions = _parseAndAssertNoError.getJudgmentDescriptions();
    JudgmentDescription _get = _judgmentDescriptions.get(0);
    JvmOperation _compileThrowExceptionMethod = this.inferrer.compileThrowExceptionMethod(_get);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void typeThrowException(final String _issue, final Exception _ex, final EObject c) throws RuleFailedException {");
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
  
  @Test
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
  
  @Test
  public void testApplyMethods() {
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
    _builder.append("Result2<EObject, EStructuralFeature> result = type2Internal(G, _trace_, eClass);");
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
  
  public void assertGeneratedMember(final JvmMember member, final CharSequence expected) {
    final FakeTreeAppendable a = this.createTestAppendable();
    this.generator.generateMember(member, a, true);
    String _string = a.toString();
    String _trim = _string.trim();
    this.assertEqualsStrings(expected, _trim);
  }
  
  public void assertGeneratedMembers(final Iterable<? extends JvmMember> members, final CharSequence expected) {
    final FakeTreeAppendable a = this.createTestAppendable();
    final Procedure1<JvmMember> _function = new Procedure1<JvmMember>() {
        public void apply(final JvmMember it) {
          XsemanticsJvmModelInferrerTest.this.generator.generateMember(it, a, false);
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
