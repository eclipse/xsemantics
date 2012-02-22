/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.Environment;
import it.xsemantics.dsl.xsemantics.EnvironmentReference;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentReferenceImpl#getEnvironment <em>Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentReferenceImpl extends EnvironmentSpecificationImpl implements EnvironmentReference
{
  /**
   * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnvironment()
   * @generated
   * @ordered
   */
  protected Environment environment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnvironmentReferenceImpl()
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
    return XsemanticsPackage.Literals.ENVIRONMENT_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment getEnvironment()
  {
    if (environment != null && environment.eIsProxy())
    {
      InternalEObject oldEnvironment = (InternalEObject)environment;
      environment = (Environment)eResolveProxy(oldEnvironment);
      if (environment != oldEnvironment)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XsemanticsPackage.ENVIRONMENT_REFERENCE__ENVIRONMENT, oldEnvironment, environment));
      }
    }
    return environment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment basicGetEnvironment()
  {
    return environment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnvironment(Environment newEnvironment)
  {
    Environment oldEnvironment = environment;
    environment = newEnvironment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_REFERENCE__ENVIRONMENT, oldEnvironment, environment));
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
      case XsemanticsPackage.ENVIRONMENT_REFERENCE__ENVIRONMENT:
        if (resolve) return getEnvironment();
        return basicGetEnvironment();
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
      case XsemanticsPackage.ENVIRONMENT_REFERENCE__ENVIRONMENT:
        setEnvironment((Environment)newValue);
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
      case XsemanticsPackage.ENVIRONMENT_REFERENCE__ENVIRONMENT:
        setEnvironment((Environment)null);
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
      case XsemanticsPackage.ENVIRONMENT_REFERENCE__ENVIRONMENT:
        return environment != null;
    }
    return super.eIsSet(featureID);
  }

} //EnvironmentReferenceImpl
