package it.xsemantics.dsl.tests.inferrer;

import com.google.inject.Inject;
import it.xsemantics.dsl.jvmmodel.TempJvmModelInferrer;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderForInferrer;
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
    _builder.append("throw new UnsupportedOperationException(\"typeis not implemented\");");
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
    _builder.append("throw new UnsupportedOperationException(\"typeis not implemented\");");
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
    _builder.append("throw new UnsupportedOperationException(\"typeis not implemented\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    this.assertGeneratedMembers(_genEntryPointMethods, _builder);
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
