package it.xsemantics.example.expressions.tests;

import com.google.inject.Inject;
import it.xsemantics.example.expressions.expressions.ExpressionsPackage;
import it.xsemantics.example.expressions.expressions.Model;
import it.xsemantics.example.expressions.tests.ExpressionsBaseTests;
import it.xsemantics.example.expressions.tests.ExtendedExpressionsInjectorProviderCustom;
import it.xsemantics.example.expressions.typing.ExpressionsSemantics;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ExtendedExpressionsInjectorProviderCustom.class)
@SuppressWarnings("all")
public class ExpressionsValidatorTests extends ExpressionsBaseTests {
  @Inject
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testInt() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("i = 10 - 5 - 1");
      Model _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testArithmeticSignedWithString() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("i = -(\'zzz\')");
      Model _parse = this._parseHelper.parse(_builder);
      EClass _arithmeticSigned = ExpressionsPackage.eINSTANCE.getArithmeticSigned();
      this._validationTestHelper.assertError(_parse, _arithmeticSigned, 
        ExpressionsSemantics.ARITHMETICSIGNED);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
