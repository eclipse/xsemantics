/**
 */
package it.xsemantics.example.fj.fj.impl;

import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.FjPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.example.fj.fj.impl.BasicTypeImpl#getBasic <em>Basic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicTypeImpl extends TypeImpl implements BasicType
{
  /**
   * The default value of the '{@link #getBasic() <em>Basic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBasic()
   * @generated
   * @ordered
   */
  protected static final String BASIC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBasic() <em>Basic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBasic()
   * @generated
   * @ordered
   */
  protected String basic = BASIC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BasicTypeImpl()
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
    return FjPackage.Literals.BASIC_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBasic()
  {
    return basic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBasic(String newBasic)
  {
    String oldBasic = basic;
    basic = newBasic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FjPackage.BASIC_TYPE__BASIC, oldBasic, basic));
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
      case FjPackage.BASIC_TYPE__BASIC:
        return getBasic();
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
      case FjPackage.BASIC_TYPE__BASIC:
        setBasic((String)newValue);
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
      case FjPackage.BASIC_TYPE__BASIC:
        setBasic(BASIC_EDEFAULT);
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
      case FjPackage.BASIC_TYPE__BASIC:
        return BASIC_EDEFAULT == null ? basic != null : !BASIC_EDEFAULT.equals(basic);
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
    result.append(" (basic: ");
    result.append(basic);
    result.append(')');
    return result.toString();
  }

} //BasicTypeImpl
