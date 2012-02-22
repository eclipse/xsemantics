/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.fj.fj.impl;

import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.FjPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.example.fj.fj.impl.ClassTypeImpl#getClassref <em>Classref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassTypeImpl extends TypeImpl implements ClassType
{
  /**
   * The cached value of the '{@link #getClassref() <em>Classref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassref()
   * @generated
   * @ordered
   */
  protected it.xsemantics.example.fj.fj.Class classref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassTypeImpl()
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
    return FjPackage.Literals.CLASS_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public it.xsemantics.example.fj.fj.Class getClassref()
  {
    if (classref != null && classref.eIsProxy())
    {
      InternalEObject oldClassref = (InternalEObject)classref;
      classref = (it.xsemantics.example.fj.fj.Class)eResolveProxy(oldClassref);
      if (classref != oldClassref)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FjPackage.CLASS_TYPE__CLASSREF, oldClassref, classref));
      }
    }
    return classref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public it.xsemantics.example.fj.fj.Class basicGetClassref()
  {
    return classref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassref(it.xsemantics.example.fj.fj.Class newClassref)
  {
    it.xsemantics.example.fj.fj.Class oldClassref = classref;
    classref = newClassref;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FjPackage.CLASS_TYPE__CLASSREF, oldClassref, classref));
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
      case FjPackage.CLASS_TYPE__CLASSREF:
        if (resolve) return getClassref();
        return basicGetClassref();
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
      case FjPackage.CLASS_TYPE__CLASSREF:
        setClassref((it.xsemantics.example.fj.fj.Class)newValue);
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
      case FjPackage.CLASS_TYPE__CLASSREF:
        setClassref((it.xsemantics.example.fj.fj.Class)null);
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
      case FjPackage.CLASS_TYPE__CLASSREF:
        return classref != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassTypeImpl
