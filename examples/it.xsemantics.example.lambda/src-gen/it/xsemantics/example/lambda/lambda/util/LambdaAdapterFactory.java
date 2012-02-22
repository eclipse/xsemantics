/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.lambda.lambda.util;

import it.xsemantics.example.lambda.lambda.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see it.xsemantics.example.lambda.lambda.LambdaPackage
 * @generated
 */
public class LambdaAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LambdaPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LambdaAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = LambdaPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LambdaSwitch<Adapter> modelSwitch =
    new LambdaSwitch<Adapter>()
    {
      @Override
      public Adapter caseProgram(Program object)
      {
        return createProgramAdapter();
      }
      @Override
      public Adapter caseTerm(Term object)
      {
        return createTermAdapter();
      }
      @Override
      public Adapter caseConstant(Constant object)
      {
        return createConstantAdapter();
      }
      @Override
      public Adapter caseStringConstant(StringConstant object)
      {
        return createStringConstantAdapter();
      }
      @Override
      public Adapter caseIntConstant(IntConstant object)
      {
        return createIntConstantAdapter();
      }
      @Override
      public Adapter caseArithmetics(Arithmetics object)
      {
        return createArithmeticsAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseAbstraction(Abstraction object)
      {
        return createAbstractionAdapter();
      }
      @Override
      public Adapter caseParameter(Parameter object)
      {
        return createParameterAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseBasicType(BasicType object)
      {
        return createBasicTypeAdapter();
      }
      @Override
      public Adapter caseTypeVariable(TypeVariable object)
      {
        return createTypeVariableAdapter();
      }
      @Override
      public Adapter caseApplication(Application object)
      {
        return createApplicationAdapter();
      }
      @Override
      public Adapter caseArrowType(ArrowType object)
      {
        return createArrowTypeAdapter();
      }
      @Override
      public Adapter caseIntType(IntType object)
      {
        return createIntTypeAdapter();
      }
      @Override
      public Adapter caseStringType(StringType object)
      {
        return createStringTypeAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.Program
   * @generated
   */
  public Adapter createProgramAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.Term
   * @generated
   */
  public Adapter createTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.Constant
   * @generated
   */
  public Adapter createConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.StringConstant <em>String Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.StringConstant
   * @generated
   */
  public Adapter createStringConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.IntConstant <em>Int Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.IntConstant
   * @generated
   */
  public Adapter createIntConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.Arithmetics <em>Arithmetics</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.Arithmetics
   * @generated
   */
  public Adapter createArithmeticsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.Abstraction <em>Abstraction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.Abstraction
   * @generated
   */
  public Adapter createAbstractionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.Parameter
   * @generated
   */
  public Adapter createParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.BasicType <em>Basic Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.BasicType
   * @generated
   */
  public Adapter createBasicTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.TypeVariable <em>Type Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.TypeVariable
   * @generated
   */
  public Adapter createTypeVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.Application <em>Application</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.Application
   * @generated
   */
  public Adapter createApplicationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.ArrowType <em>Arrow Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.ArrowType
   * @generated
   */
  public Adapter createArrowTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.IntType <em>Int Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.IntType
   * @generated
   */
  public Adapter createIntTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.example.lambda.lambda.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.example.lambda.lambda.StringType
   * @generated
   */
  public Adapter createStringTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //LambdaAdapterFactory
