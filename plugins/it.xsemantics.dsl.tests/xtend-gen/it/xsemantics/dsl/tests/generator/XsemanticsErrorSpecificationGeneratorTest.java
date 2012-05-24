package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.generator.XsemanticsErrorSpecificationGenerator;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsErrorSpecificationGeneratorTest extends XsemanticsGeneratorBaseTest {
  @Inject
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  @Inject
  private XsemanticsErrorSpecificationGenerator errSpecGenerator;
  
  @Test
  public void testCompileErrorOfErrorSpecification() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("String _plus = (\"this \" + c);");
    _builder.newLine();
    _builder.append("String _plus_1 = (_plus + \" made an error!\");");
    _builder.newLine();
    _builder.append("String error = _plus_1;");
    this.checkErrorOfErrorSpecification(_testJudgmentDescriptionsWithErrorSpecification, _builder, "error");
  }
  
  @Test
  public void testCompileSourceOfErrorSpecification() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EObject source = c;");
    this.checkSourceOfErrorSpecification(_testJudgmentDescriptionsWithErrorSpecification, _builder, "source");
  }
  
  @Test
  public void testCompileFeatureOfErrorSpecification() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("EClass _eClass = c.eClass();");
    _builder.newLine();
    _builder.append("EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();");
    _builder.newLine();
    _builder.append("EStructuralFeature feature = _eContainingFeature;");
    this.checkFeatureOfErrorSpecification(_testJudgmentDescriptionsWithErrorSpecification, _builder, "feature");
  }
  
  @Test
  public void testCompileEmptySourceOfErrorSpecification() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature = this.testFiles.testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature();
    this.checkSourceOfErrorSpecification(_testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature, 
      "", "null");
  }
  
  @Test
  public void testCompileEmptyFeatureOfErrorSpecification() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature = this.testFiles.testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature();
    this.checkFeatureOfErrorSpecification(_testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature, 
      "", "null");
  }
  
  public void checkErrorOfErrorSpecification(final CharSequence inputProgram, final CharSequence expected, final CharSequence expectedVar) {
    final Function2<ErrorSpecification,ITreeAppendable,String> _function = new Function2<ErrorSpecification,ITreeAppendable,String>() {
        public String apply(final ErrorSpecification errSpec, final ITreeAppendable b) {
          String _compileErrorOfErrorSpecification = XsemanticsErrorSpecificationGeneratorTest.this.errSpecGenerator.compileErrorOfErrorSpecification(errSpec, b);
          return _compileErrorOfErrorSpecification;
        }
      };
    this.checkCompilationOfErrorSpecification(inputProgram, _function, expected, expectedVar);
  }
  
  public void checkSourceOfErrorSpecification(final CharSequence inputProgram, final CharSequence expected, final CharSequence expectedVar) {
    final Function2<ErrorSpecification,ITreeAppendable,String> _function = new Function2<ErrorSpecification,ITreeAppendable,String>() {
        public String apply(final ErrorSpecification errSpec, final ITreeAppendable b) {
          String _compileSourceOfErrorSpecification = XsemanticsErrorSpecificationGeneratorTest.this.errSpecGenerator.compileSourceOfErrorSpecification(errSpec, b);
          return _compileSourceOfErrorSpecification;
        }
      };
    this.checkCompilationOfErrorSpecification(inputProgram, _function, expected, expectedVar);
  }
  
  public void checkFeatureOfErrorSpecification(final CharSequence inputProgram, final CharSequence expected, final CharSequence expectedVar) {
    final Function2<ErrorSpecification,ITreeAppendable,String> _function = new Function2<ErrorSpecification,ITreeAppendable,String>() {
        public String apply(final ErrorSpecification errSpec, final ITreeAppendable b) {
          String _compileFeatureOfErrorSpecification = XsemanticsErrorSpecificationGeneratorTest.this.errSpecGenerator.compileFeatureOfErrorSpecification(errSpec, b);
          return _compileFeatureOfErrorSpecification;
        }
      };
    this.checkCompilationOfErrorSpecification(inputProgram, _function, expected, expectedVar);
  }
  
  public void checkCompilationOfErrorSpecification(final CharSequence inputProgram, final Function2<? super ErrorSpecification,? super ITreeAppendable,? extends String> compilation, final CharSequence expected, final CharSequence expectedVar) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(inputProgram);
    final JudgmentDescription jDesc = this.firstJudgmentDescription(_parseAndAssertNoError);
    final ErrorSpecification errSpec = this.firstErrorSpecification(jDesc);
    ImportManager _importManager = new ImportManager(true);
    final TreeAppendable appendable = this._xsemanticsGeneratorExtensions.createAndConfigureAppendable(jDesc, _importManager);
    final String variable = compilation.apply(errSpec, appendable);
    this.assertEqualsStrings(expected, appendable);
    this.assertEqualsStrings(expectedVar, variable);
  }
}
