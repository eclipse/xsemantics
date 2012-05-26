package it.xsemantics.example.lambda.tests;

import com.google.inject.Inject;
import it.xsemantics.example.lambda.LambdaInjectorProvider;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.tests.LambdaBaseTest;
import it.xsemantics.example.lambda.validation.LambdaJavaValidator;
import java.util.List;
import junit.framework.Assert;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = LambdaInjectorProvider.class)
@SuppressWarnings("all")
public class LambdaValidatorTest extends LambdaBaseTest {
  private ValidatorTester<LambdaJavaValidator> tester;
  
  @Inject
  private ParseHelper<Program> _parseHelper;
  
  @Before
  public void setUp() {
    super.setUp();
    ValidatorTester<LambdaJavaValidator> _validatorTester = new ValidatorTester<LambdaJavaValidator>(this.validator, this.injector);
    this.tester = _validatorTester;
  }
  
  @Test
  public void testValidateOk() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("lambda x . lambda y . x y");
    this.assertOk(_builder);
  }
  
  @Test
  public void testNonOptimalTypeVariables() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("lambda x : a. lambda y : b . x y");
    this.assertOk(_builder);
  }
  
  @Test
  public void testOmega() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("lambda x . x x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Diagnostic ERROR code=it.xsemantics.example.lambda.xsemantics.rules.ApplicationType \"failed: ApplicationType: [x <- X1] |- subst{X1=a -> b} |> (x x) : Type\" at Program.term->Abstraction.term->Application");
    _builder_1.newLine();
    _builder_1.append("Diagnostic ERROR code=it.xsemantics.example.lambda.xsemantics.rules.UnifyTypeVariableArrowType \"failed: UnifyTypeVariableArrowType: [x <- X1] |- subst{X1=a -> b} |> X2 ~~ a -> b ~> ArrowType ~~ ArrowType\" at Program.term->Abstraction.term->Application");
    _builder_1.newLine();
    _builder_1.append("Diagnostic ERROR code=it.xsemantics.example.lambda.xsemantics.rules.NotOccurVarInArrow \"failed: X2 occurs in a -> b\" at Program.term->Abstraction.term->Application");
    _builder_1.newLine();
    _builder_1.append("Diagnostic ERROR code=it.xsemantics.example.lambda.xsemantics.rules.NotOccurVar \"failed: X2 occurs in X2\" at Program.term->Abstraction.term->Application");
    _builder_1.newLine();
    _builder_1.append("Diagnostic ERROR \"failed: variable.typevarName != other.typevarName\" at Program.term->Abstraction.term->Application");
    this.assertAll(_builder, _builder_1);
  }
  
  public void assertOk(final CharSequence program) {
    try {
      Program _parse = this._parseHelper.parse(program);
      AssertableDiagnostics _validate = this.tester.validate(_parse);
      this.assertOk(_validate);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertOk(final AssertableDiagnostics validate) {
    List<Diagnostic> _listOfDiagnostics = this.listOfDiagnostics(validate);
    int _size = _listOfDiagnostics.size();
    boolean _notEquals = (_size != 0);
    if (_notEquals) {
      List<Diagnostic> _listOfDiagnostics_1 = this.listOfDiagnostics(validate);
      for (final Diagnostic diag : _listOfDiagnostics_1) {
        String _string = diag.toString();
        System.err.println(_string);
      }
      String _diagnosticsToString = this.diagnosticsToString(validate);
      String _plus = ("There are expected to be no diagnostics.: " + _diagnosticsToString);
      Assert.fail(_plus);
    }
  }
  
  public void assertAll(final CharSequence program, final CharSequence expectedErrors) {
    try {
      Program _parse = this._parseHelper.parse(program);
      AssertableDiagnostics _validate = this.tester.validate(_parse);
      this.assertAll(_validate, expectedErrors);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertAll(final AssertableDiagnostics validate, final CharSequence expectedErrors) {
    String _string = expectedErrors.toString();
    String _removeObjectIdentifiers = this.removeObjectIdentifiers(_string);
    String _trim = _removeObjectIdentifiers.trim();
    String _diagnosticsToString = this.diagnosticsToString(validate);
    String _removeObjectIdentifiers_1 = this.removeObjectIdentifiers(_diagnosticsToString);
    Assert.assertEquals(_trim, _removeObjectIdentifiers_1);
  }
  
  public List<Diagnostic> listOfDiagnostics(final AssertableDiagnostics validate) {
    Diagnostic _diagnostic = validate.getDiagnostic();
    return _diagnostic.getChildren();
  }
  
  public String diagnosticsToString(final AssertableDiagnostics validate) {
    Diagnostic _diagnostic = validate.getDiagnostic();
    List<Diagnostic> _children = _diagnostic.getChildren();
    String _join = IterableExtensions.join(_children, "\n");
    return _join;
  }
  
  public String removeObjectIdentifiers(final String s) {
    String _replaceAll = s.replaceAll("@(\\w)+", "");
    return _replaceAll;
  }
}
