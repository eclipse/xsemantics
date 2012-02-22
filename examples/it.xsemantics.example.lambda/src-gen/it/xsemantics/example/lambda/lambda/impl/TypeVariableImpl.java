/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.lambda.lambda.impl;

import it.xsemantics.example.lambda.lambda.LambdaPackage;
import it.xsemantics.example.lambda.lambda.TypeVariable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.example.lambda.lambda.impl.TypeVariableImpl#getTypevarName <em>Typevar Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeVariableImpl extends TypeImpl implements TypeVariable
{
  /**
   * The default value of the '{@link #getTypevarName() <em>Typevar Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypevarName()
   * @generated
   * @ordered
   */
  protected static final String TYPEVAR_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypevarName() <em>Typevar Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypevarName()
   * @generated
   * @ordered
   */
  protected String typevarName = TYPEVAR_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeVariableImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return LambdaPackage.Literals.TYPE_VARIABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypevarName()
  {
    return typevarName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypevarName(String newTypevarName)
  {
    String oldTypevarName = typevarName;
    typevarName = newTypevarName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LambdaPackage.TYPE_VARIABLE__TYPEVAR_NAME, oldTypevarName, typevarName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case LambdaPackage.TYPE_VARIABLE__TYPEVAR_NAME:
        return getTypevarName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LambdaPackage.TYPE_VARIABLE__TYPEVAR_NAME:
        setTypevarName((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case LambdaPackage.TYPE_VARIABLE__TYPEVAR_NAME:
        setTypevarName(TYPEVAR_NAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case LambdaPackage.TYPE_VARIABLE__TYPEVAR_NAME:
        return TYPEVAR_NAME_EDEFAULT == null ? typevarName != null : !TYPEVAR_NAME_EDEFAULT.equals(typevarName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (typevarName: ");
    result.append(typevarName);
    result.append(')');
    return result.toString();
  }

} //TypeVariableImpl
