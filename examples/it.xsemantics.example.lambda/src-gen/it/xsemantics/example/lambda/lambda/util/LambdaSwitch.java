/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.lambda.lambda.util;

import it.xsemantics.example.lambda.lambda.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see it.xsemantics.example.lambda.lambda.LambdaPackage
 * @generated
 */
public class LambdaSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LambdaPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LambdaSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = LambdaPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case LambdaPackage.PROGRAM:
      {
        Program program = (Program)theEObject;
        T result = caseProgram(program);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.TERM:
      {
        Term term = (Term)theEObject;
        T result = caseTerm(term);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.CONSTANT:
      {
        Constant constant = (Constant)theEObject;
        T result = caseConstant(constant);
        if (result == null) result = caseTerm(constant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.STRING_CONSTANT:
      {
        StringConstant stringConstant = (StringConstant)theEObject;
        T result = caseStringConstant(stringConstant);
        if (result == null) result = caseConstant(stringConstant);
        if (result == null) result = caseTerm(stringConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.INT_CONSTANT:
      {
        IntConstant intConstant = (IntConstant)theEObject;
        T result = caseIntConstant(intConstant);
        if (result == null) result = caseConstant(intConstant);
        if (result == null) result = caseTerm(intConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.ARITHMETICS:
      {
        Arithmetics arithmetics = (Arithmetics)theEObject;
        T result = caseArithmetics(arithmetics);
        if (result == null) result = caseTerm(arithmetics);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = caseTerm(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.ABSTRACTION:
      {
        Abstraction abstraction = (Abstraction)theEObject;
        T result = caseAbstraction(abstraction);
        if (result == null) result = caseTerm(abstraction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.PARAMETER:
      {
        Parameter parameter = (Parameter)theEObject;
        T result = caseParameter(parameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.TYPE:
      {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.BASIC_TYPE:
      {
        BasicType basicType = (BasicType)theEObject;
        T result = caseBasicType(basicType);
        if (result == null) result = caseType(basicType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.TYPE_VARIABLE:
      {
        TypeVariable typeVariable = (TypeVariable)theEObject;
        T result = caseTypeVariable(typeVariable);
        if (result == null) result = caseType(typeVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.APPLICATION:
      {
        Application application = (Application)theEObject;
        T result = caseApplication(application);
        if (result == null) result = caseTerm(application);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.ARROW_TYPE:
      {
        ArrowType arrowType = (ArrowType)theEObject;
        T result = caseArrowType(arrowType);
        if (result == null) result = caseType(arrowType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.INT_TYPE:
      {
        IntType intType = (IntType)theEObject;
        T result = caseIntType(intType);
        if (result == null) result = caseBasicType(intType);
        if (result == null) result = caseType(intType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LambdaPackage.STRING_TYPE:
      {
        StringType stringType = (StringType)theEObject;
        T result = caseStringType(stringType);
        if (result == null) result = caseBasicType(stringType);
        if (result == null) result = caseType(stringType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Program</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProgram(Program object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTerm(Term object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstant(Constant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringConstant(StringConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntConstant(IntConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arithmetics</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arithmetics</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithmetics(Arithmetics object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstraction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstraction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstraction(Abstraction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameter(Parameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicType(BasicType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeVariable(TypeVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Application</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseApplication(Application object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arrow Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arrow Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrowType(ArrowType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntType(IntType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringType(StringType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //LambdaSwitch
