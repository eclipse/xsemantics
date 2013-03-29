package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import com.google.inject.Provider;
import it.xsemantics.dsl.tests.XsemanticsBaseTest;
import it.xsemantics.dsl.tests.XsemanticsCompilationTestHelper;
import it.xsemantics.dsl.tests.XsemanticsCompilationTestHelper.Result;
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(XsemanticsInjectorProviderCustom.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsGeneratedJavaCodeTest extends XsemanticsBaseTest {
  @Inject
  @Extension
  private XsemanticsCompilationTestHelper _xsemanticsCompilationTestHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  private XtextResourceSet resourceSet;
  
  @Before
  public void setUp() {
    XtextResourceSet _get = this.resourceSetProvider.get();
    this.resourceSet = _get;
  }
  
  private final String TESTS_INPUT_FILES = "./tests_input_files/";
  
  @Test
  public void testRuleInvocation() {
    this.assertCorrectJavaCodeGeneration("ecore_ruleinvocation_test.xsemantics");
  }
  
  @Test
  public void testFjFirst() {
    this.assertCorrectJavaCodeGeneration("fj_first_test.xsemantics");
  }
  
  @Test
  public void testFjAlt() {
    this.assertCorrectJavaCodeGeneration("fj_first_test.xsemantics");
    this.assertCorrectJavaCodeGeneration("fj_alt_test.xsemantics");
  }
  
  @Test
  public void testEcore() {
    this.assertCorrectJavaCodeGeneration("ecore_test.xsemantics");
  }
  
  @Test
  public void testParticularCases() {
    this.assertCorrectJavaCodeGeneration("ecore_particular_test.xsemantics");
  }
  
  @Test
  public void testOrExpressions() {
    this.assertCorrectJavaCodeGeneration("ecore_or_test.xsemantics");
  }
  
  @Test
  public void testExpressions() {
    this.assertCorrectJavaCodeGeneration("ecore_expressions_test.xsemantics");
  }
  
  @Test
  public void testValidationEcore() {
    this.assertCorrectJavaCodeGeneration("ecore_validation_test.xsemantics");
  }
  
  private void assertCorrectJavaCodeGeneration(final CharSequence file) {
    final String fullPathInputFile = (this.TESTS_INPUT_FILES + file);
    URI _createURI = URI.createURI(fullPathInputFile);
    final Resource resource = this.resourceSet.getResource(_createURI, true);
    EList<EObject> _contents = resource.getContents();
    final EObject system = _contents.get(0);
    this._validationTestHelper.assertNoErrors(system);
    final IAcceptor<Result> _function = new IAcceptor<Result>() {
        public void accept(final Result it) {
          it.compileToJava();
        }
      };
    this._xsemanticsCompilationTestHelper.compileAll(system, _function);
  }
}
