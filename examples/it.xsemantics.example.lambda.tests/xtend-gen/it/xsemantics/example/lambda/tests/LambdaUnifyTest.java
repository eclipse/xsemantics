package it.xsemantics.example.lambda.tests;

import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.IntType;
import it.xsemantics.example.lambda.lambda.StringType;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.tests.LambdaBaseTest;
import it.xsemantics.example.lambda.tests.LambdaInjectorWithNonBeautifiedTypesProvider;
import it.xsemantics.example.lambda.xsemantics.LambdaUtils;
import it.xsemantics.runtime.Result2;
import junit.framework.Assert;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(LambdaInjectorWithNonBeautifiedTypesProvider.class)
public class LambdaUnifyTest extends LambdaBaseTest {
  @Test
  public void testUnifyTypeVar() {
    TypeVariable _createFreshTypeVariable = LambdaUtils.createFreshTypeVariable();
    TypeVariable _createFreshTypeVariable_1 = LambdaUtils.createFreshTypeVariable();
    this.assertUnify(_createFreshTypeVariable, _createFreshTypeVariable_1, "X3 -- X3", "X1=X3, X2=X3");
  }
  
  @Test
  public void testUnifyStringType() {
    StringType _createStringType = LambdaUtils.createStringType();
    StringType _createStringType_1 = LambdaUtils.createStringType();
    this.assertUnify(_createStringType, _createStringType_1, "String -- String", "");
  }
  
  @Test
  public void testUnifyIntType() {
    IntType _createIntType = LambdaUtils.createIntType();
    IntType _createIntType_1 = LambdaUtils.createIntType();
    this.assertUnify(_createIntType, _createIntType_1, "int -- int", "");
  }
  
  @Test
  public void testBasicTypeFails() {
    StringType _createStringType = LambdaUtils.createStringType();
    IntType _createIntType = LambdaUtils.createIntType();
    Result2<Type,Type> _unify = this.system.unify(this.substitutions, _createStringType, _createIntType);
    this.<Type>assertFailureTrace(_unify, "failed: UnifyType: [] |- subst{} |> String ~~ int ~> Type ~~ Type");
  }
  
  @Test
  public void testUnifyTypeVarBasicType() {
    TypeVariable _createFreshTypeVariable = LambdaUtils.createFreshTypeVariable();
    StringType _createStringType = LambdaUtils.createStringType();
    this.assertUnify(_createFreshTypeVariable, _createStringType, "String -- String", "X1=String");
  }
  
  @Test
  public void testUnifyBasicTypeTypeVar() {
    IntType _createIntType = LambdaUtils.createIntType();
    TypeVariable _createFreshTypeVariable = LambdaUtils.createFreshTypeVariable();
    this.assertUnify(_createIntType, _createFreshTypeVariable, "int -- int", "X1=int");
  }
  
  @Test
  public void testUnifyTypeVarArrowType() {
    TypeVariable _createFreshTypeVariable = LambdaUtils.createFreshTypeVariable();
    ArrowType _createFreshArrowType = LambdaUtils.createFreshArrowType();
    this.assertUnify(_createFreshTypeVariable, _createFreshArrowType, "(X2 -> X3) -- (X2 -> X3)", "X1=(X2 -> X3)");
  }
  
  @Test
  public void testUnifyArrowTypeTypeVar() {
    ArrowType _createFreshArrowType = LambdaUtils.createFreshArrowType();
    TypeVariable _createFreshTypeVariable = LambdaUtils.createFreshTypeVariable();
    this.assertUnify(_createFreshArrowType, _createFreshTypeVariable, "(X1 -> X2) -- (X1 -> X2)", "X3=(X1 -> X2)");
  }
  
  @Test
  public void testUnifyArrowTypes() {
    ArrowType _createFreshArrowType = LambdaUtils.createFreshArrowType();
    ArrowType _createFreshArrowType_1 = LambdaUtils.createFreshArrowType();
    this.assertUnify(_createFreshArrowType, _createFreshArrowType_1, "(X5 -> X6) -- (X5 -> X6)", "X1=X5, X2=X6, X3=X5, X4=X6");
  }
  
  @Test
  public void testUnifyArrowTypes2() {
    ArrowType _createFreshArrowType = LambdaUtils.createFreshArrowType();
    ArrowType _createFreshArrowType_1 = LambdaUtils.createFreshArrowType();
    ArrowType _createFreshArrowType_2 = LambdaUtils.createFreshArrowType();
    ArrowType _createArrowType = LambdaUtils.createArrowType(_createFreshArrowType_1, _createFreshArrowType_2);
    this.assertUnify(_createFreshArrowType, _createArrowType, "((X3 -> X4) -> (X5 -> X6)) -- ((X3 -> X4) -> (X5 -> X6))", "X1=(X3 -> X4), X2=(X5 -> X6)");
  }
  
  @Test
  public void testUnifyArrowTypesWithBasicTypes() {
    ArrowType _createFreshArrowType = LambdaUtils.createFreshArrowType();
    IntType _createIntType = LambdaUtils.createIntType();
    StringType _createStringType = LambdaUtils.createStringType();
    ArrowType _createArrowType = LambdaUtils.createArrowType(_createIntType, _createStringType);
    ArrowType _createFreshArrowType_1 = LambdaUtils.createFreshArrowType();
    ArrowType _createArrowType_1 = LambdaUtils.createArrowType(_createArrowType, _createFreshArrowType_1);
    this.assertUnify(_createFreshArrowType, _createArrowType_1, "((int -> String) -> (X3 -> X4)) -- ((int -> String) -> (X3 -> X4))", "X1=(int -> String), X2=(X3 -> X4)");
  }
  
  @Test
  public void testUnifyArrowTypesWithBasicTypes2() {
    ArrowType _createFreshArrowType = LambdaUtils.createFreshArrowType();
    StringType _createStringType = LambdaUtils.createStringType();
    IntType _createIntType = LambdaUtils.createIntType();
    ArrowType _createArrowType = LambdaUtils.createArrowType(_createStringType, _createIntType);
    ArrowType _createArrowType_1 = LambdaUtils.createArrowType(_createFreshArrowType, _createArrowType);
    IntType _createIntType_1 = LambdaUtils.createIntType();
    StringType _createStringType_1 = LambdaUtils.createStringType();
    ArrowType _createArrowType_2 = LambdaUtils.createArrowType(_createIntType_1, _createStringType_1);
    ArrowType _createFreshArrowType_1 = LambdaUtils.createFreshArrowType();
    ArrowType _createArrowType_3 = LambdaUtils.createArrowType(_createArrowType_2, _createFreshArrowType_1);
    this.assertUnify(_createArrowType_1, _createArrowType_3, "((int -> String) -> (String -> int)) -- ((int -> String) -> (String -> int))", "X1=int, X2=String, X3=String, X4=int");
  }
  
  @Test
  public void unifyTypeVariableOccursInArrowTypeFails() {
      TypeVariable _createTypeVariable = LambdaUtils.createTypeVariable("a");
      final TypeVariable variable = _createTypeVariable;
      ArrowType _createFreshArrowType = LambdaUtils.createFreshArrowType();
      TypeVariable _createFreshTypeVariable = LambdaUtils.createFreshTypeVariable();
      TypeVariable _createTypeVariable_1 = LambdaUtils.createTypeVariable("a");
      ArrowType _createArrowType = LambdaUtils.createArrowType(_createFreshTypeVariable, _createTypeVariable_1);
      ArrowType _createArrowType_1 = LambdaUtils.createArrowType(_createFreshArrowType, _createArrowType);
      Result2<Type,Type> _unify = this.system.unify(this.substitutions, variable, _createArrowType_1);
      CharSequence _unifyTypeVariableOccursInArrowTypeFails = this.traces.unifyTypeVariableOccursInArrowTypeFails();
      this.<Type>assertFailureTrace(_unify, _unifyTypeVariableOccursInArrowTypeFails);
  }
  
  public void assertUnify(final Type left, final Type right, final String expectedResult, final String expectedSubsts) {
      Result2<Type,Type> _unify = this.system.unify(this.substitutions, left, right);
      final Result2<Type,Type> result = _unify;
      this.<Type, Type>assertResult2AsString(result, expectedResult);
      this.assertTypeSubstitutions(this.substitutions, expectedSubsts);
      Type _first = result.getFirst();
      Assert.assertNotSame(left, _first);
      Type _second = result.getSecond();
      Assert.assertNotSame(right, _second);
  }
}
