package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.jvmmodel.XsemanticsJvmModelInferrer;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.xsemantics.Rule;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
public class XsemanticsJvmModelInferrerTest extends XsemanticsBaseTest {
  @Inject
  protected JvmModelGenerator generator;
  
  @Inject
  protected XsemanticsJvmModelInferrer inferrer;
  
  @Test
  public void testSimpleRule() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public final static String ECLASSEOBJECT = \"it.xsemantics.test.rules.EClassEObject\";");
    this.assertRuleInference(_testSimpleRule, _builder);
  }
  
  public void assertRuleInference(final CharSequence prog, final CharSequence expected) {
    Rule _firstRule = this.getFirstRule(prog);
    final JvmField field = this.inferrer.genIssueField(_firstRule);
    FakeTreeAppendable _fakeTreeAppendable = new FakeTreeAppendable();
    final FakeTreeAppendable a = _fakeTreeAppendable;
    this.generator.generateMember(field, a, true);
    String _string = a.toString();
    String _trim = _string.trim();
    this.assertEqualsStrings(expected, _trim);
  }
}
