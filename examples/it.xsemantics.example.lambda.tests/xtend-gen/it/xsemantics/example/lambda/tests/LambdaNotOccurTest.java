package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.IntType;
import it.xsemantics.example.lambda.lambda.StringType;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.tests.LambdaBaseTest;
import it.xsemantics.example.lambda.tests.LambdaInjectorWithNonBeautifiedTypesProvider;
import it.xsemantics.runtime.Result;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
@SuppressWarnings("all")
public class LambdaNotOccurTest extends LambdaBaseTest {
  @Test
  public void NotOccurConstantTypes() {
    StringType _createStringType = this.lambdaUtils.createStringType();
    IntType _createIntType = this.lambdaUtils.createIntType();
    Result<Boolean> _notoccur = this.system.notoccur(_createStringType, _createIntType);
    this.assertResultTrue(_notoccur);
  }
  
  @Test
  public void NotOccurDifferentTypeVariables() {
    TypeVariable _createFreshTypeVariable = this.lambdaUtils.createFreshTypeVariable();
    TypeVariable _createFreshTypeVariable_1 = this.lambdaUtils.createFreshTypeVariable();
    Result<Boolean> _notoccur = this.system.notoccur(_createFreshTypeVariable, _createFreshTypeVariable_1);
    this.assertResultTrue(_notoccur);
  }
  
  @Test
  public void NotOccurTypeVariablesFails() {
    final TypeVariable variable = this.lambdaUtils.createFreshTypeVariable();
    TypeVariable _createTypeVariable = this.lambdaUtils.createTypeVariable("X1");
    Result<Boolean> _notoccur = this.system.notoccur(variable, _createTypeVariable);
    this.<Boolean>assertFailure(_notoccur);
  }
  
  @Test
  public void NotOccurTypeVariablesInArrowType() {
    TypeVariable _createFreshTypeVariable = this.lambdaUtils.createFreshTypeVariable();
    ArrowType _createFreshArrowType = this.lambdaUtils.createFreshArrowType();
    Result<Boolean> _notoccur = this.system.notoccur(_createFreshTypeVariable, _createFreshArrowType);
    this.assertResultTrue(_notoccur);
  }
  
  @Test
  public void notOccurTypeVariablesInArrowTypeFails() {
    final TypeVariable variable = this.lambdaUtils.createTypeVariable("a");
    ArrowType _createFreshArrowType = this.lambdaUtils.createFreshArrowType();
    TypeVariable _createFreshTypeVariable = this.lambdaUtils.createFreshTypeVariable();
    TypeVariable _createTypeVariable = this.lambdaUtils.createTypeVariable("a");
    ArrowType _createArrowType = this.lambdaUtils.createArrowType(_createFreshTypeVariable, _createTypeVariable);
    ArrowType _createArrowType_1 = this.lambdaUtils.createArrowType(_createFreshArrowType, _createArrowType);
    Result<Boolean> _notoccur = this.system.notoccur(variable, _createArrowType_1);
    CharSequence _notOccurTypeVariablesInArrowTypeFails = this.traces.notOccurTypeVariablesInArrowTypeFails();
    this.<Boolean>assertFailureTrace(_notoccur, _notOccurTypeVariablesInArrowTypeFails);
  }
}
