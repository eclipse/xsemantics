package it.xsemantics.example.lambda.tests;

import com.google.inject.Inject;
import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.tests.LambdaBaseTest;
import it.xsemantics.example.lambda.tests.LambdaInjectorWithNonBeautifiedTypesProvider;
import it.xsemantics.example.lambda.xsemantics.TypeSubstitutions;
import it.xsemantics.runtime.Result;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
@SuppressWarnings("all")
public class LambdaTypeSubstitutionTest extends LambdaBaseTest {
  @Inject
  private TypeSubstitutions substitutions;
  
  @Before
  public void resetSubstitutions() {
    this.setUp();
    this.substitutions.reset();
  }
  
  @Test
  public void testTypeVariableSubstitution() {
    TypeVariable _createFreshTypeVariable = this.lambdaUtils.createFreshTypeVariable();
    Result<Type> _typesubstitution = this.system.typesubstitution(this.substitutions, _createFreshTypeVariable);
    this.<Type>assertResultAsString(_typesubstitution, 
      "X1");
  }
  
  @Test
  public void testTypeVariableSubstitutionRecursive() {
    final TypeVariable firstVariable = this.lambdaUtils.createFreshTypeVariable();
    final TypeVariable secondVariable = this.lambdaUtils.createFreshTypeVariable();
    final TypeVariable thirdVariable = this.lambdaUtils.createFreshTypeVariable();
    String _typevarName = firstVariable.getTypevarName();
    this.substitutions.add(_typevarName, secondVariable);
    String _typevarName_1 = secondVariable.getTypevarName();
    this.substitutions.add(_typevarName_1, thirdVariable);
    Result<Type> _typesubstitution = this.system.typesubstitution(this.substitutions, firstVariable);
    this.<Type>assertResultAsString(_typesubstitution, 
      "X3");
  }
  
  @Test
  public void testArrowTypeSubstitutionRecursive() {
    final TypeVariable firstVariable = this.lambdaUtils.createFreshTypeVariable();
    final TypeVariable secondVariable = this.lambdaUtils.createFreshTypeVariable();
    final TypeVariable thirdVariable = this.lambdaUtils.createFreshTypeVariable();
    final ArrowType arrowType = this.lambdaUtils.createArrowType(firstVariable, secondVariable);
    String _typevarName = firstVariable.getTypevarName();
    this.substitutions.add(_typevarName, secondVariable);
    String _typevarName_1 = secondVariable.getTypevarName();
    this.substitutions.add(_typevarName_1, thirdVariable);
    Result<Type> _typesubstitution = this.system.typesubstitution(this.substitutions, arrowType);
    this.<Type>assertResultAsString(_typesubstitution, 
      "(X3 -> X3)");
  }
}
