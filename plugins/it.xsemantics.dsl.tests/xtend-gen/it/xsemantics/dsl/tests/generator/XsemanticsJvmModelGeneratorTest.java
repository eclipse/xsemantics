package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import java.util.Map;
import junit.framework.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
public class XsemanticsJvmModelGeneratorTest extends XsemanticsBaseTest {
  @Inject
  protected JvmModelGenerator generator;
  
  private static String TEST_TYPESYSTEM_NAME = "it.xsemantics.test.TypeSystem";
  
  private static String OUTPUT_PREFIX = "DEFAULT_OUTPUT";
  
  @Test
  public void testJudgmentDescriptions() {
    CharSequence _testJudgmentDescriptions = this.testFiles.testJudgmentDescriptions();
    final InMemoryFileSystemAccess fs = this.runGenerator(_testJudgmentDescriptions);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package it.xsemantics.test;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.Result;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.XsemanticsRuntimeSystem;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.util.PolymorphicDispatcher;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class TypeSystem extends XsemanticsRuntimeSystem {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public TypeSystem() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("init();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void init() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* TODO */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertGeneratedCode(fs, XsemanticsJvmModelGeneratorTest.TEST_TYPESYSTEM_NAME, _builder);
  }
  
  @Test
  public void testSimpleRule() {
    CharSequence _testSimpleRule = this.testFiles.testSimpleRule();
    final InMemoryFileSystemAccess fs = this.runGenerator(_testSimpleRule);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package it.xsemantics.test;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.Result;");
    _builder.newLine();
    _builder.append("import it.xsemantics.runtime.XsemanticsRuntimeSystem;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.util.PolymorphicDispatcher;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class TypeSystem extends XsemanticsRuntimeSystem {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public final static String ECLASSEOBJECT = \"it.xsemantics.test.rules.EClassEObject\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public TypeSystem() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("init();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void init() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* TODO */");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertGeneratedCode(fs, XsemanticsJvmModelGeneratorTest.TEST_TYPESYSTEM_NAME, _builder);
  }
  
  public InMemoryFileSystemAccess runGenerator(final CharSequence prog) {
    InMemoryFileSystemAccess _xblockexpression = null;
    {
      InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
      final InMemoryFileSystemAccess fs = _inMemoryFileSystemAccess;
      Resource _loadResource = this.loadResource(prog);
      this.generator.doGenerate(_loadResource, fs);
      _xblockexpression = (fs);
    }
    return _xblockexpression;
  }
  
  public Resource loadResource(final CharSequence prog) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(prog);
    Resource _eResource = _parseAndAssertNoError.eResource();
    return _eResource;
  }
  
  public void assertGeneratedCode(final InMemoryFileSystemAccess fs, final String tsName, final CharSequence expected) {
    Map<String,CharSequence> _files = fs.getFiles();
    String _replace = tsName.replace(".", "/");
    String _plus = (XsemanticsJvmModelGeneratorTest.OUTPUT_PREFIX + _replace);
    String _plus_1 = (_plus + ".java");
    final CharSequence genCode = _files.get(_plus_1);
    Assert.assertNotNull(genCode);
    this.assertEqualsStrings(expected, genCode);
  }
}
