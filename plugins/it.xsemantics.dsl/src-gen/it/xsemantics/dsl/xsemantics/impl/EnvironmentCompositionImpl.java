/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.EnvironmentComposition;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Composition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentCompositionImpl#getCurrentEnvironment <em>Current Environment</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentCompositionImpl#getSubEnvironment <em>Sub Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentCompositionImpl extends EnvironmentSpecificationImpl implements EnvironmentComposition
{
  /**
   * The cached value of the '{@link #getCurrentEnvironment() <em>Current Environment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCurrentEnvironment()
   * @generated
   * @ordered
   */
  protected EnvironmentSpecification currentEnvironment;

  /**
   * The cached value of the '{@link #getSubEnvironment() <em>Sub Environment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubEnvironment()
   * @generated
   * @ordered
   */
  protected EnvironmentSpecification subEnvironment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnvironmentCompositionImpl()
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
    return XsemanticsPackage.Literals.ENVIRONMENT_COMPOSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnvironmentSpecification getCurrentEnvironment()
  {
    return currentEnvironment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCurrentEnvironment(EnvironmentSpecification newCurrentEnvironment, NotificationChain msgs)
  {
    EnvironmentSpecification oldCurrentEnvironment = currentEnvironment;
    currentEnvironment = newCurrentEnvironment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT, oldCurrentEnvironment, newCurrentEnvironment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCurrentEnvironment(EnvironmentSpecification newCurrentEnvironment)
  {
    if (newCurrentEnvironment != currentEnvironment)
    {
      NotificationChain msgs = null;
      if (currentEnvironment != null)
        msgs = ((InternalEObject)currentEnvironment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT, null, msgs);
      if (newCurrentEnvironment != null)
        msgs = ((InternalEObject)newCurrentEnvironment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT, null, msgs);
      msgs = basicSetCurrentEnvironment(newCurrentEnvironment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT, newCurrentEnvironment, newCurrentEnvironment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnvironmentSpecification getSubEnvironment()
  {
    return subEnvironment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubEnvironment(EnvironmentSpecification newSubEnvironment, NotificationChain msgs)
  {
    EnvironmentSpecification oldSubEnvironment = subEnvironment;
    subEnvironment = newSubEnvironment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT, oldSubEnvironment, newSubEnvironment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubEnvironment(EnvironmentSpecification newSubEnvironment)
  {
    if (newSubEnvironment != subEnvironment)
    {
      NotificationChain msgs = null;
      if (subEnvironment != null)
        msgs = ((InternalEObject)subEnvironment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT, null, msgs);
      if (newSubEnvironment != null)
        msgs = ((InternalEObject)newSubEnvironment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT, null, msgs);
      msgs = basicSetSubEnvironment(newSubEnvironment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT, newSubEnvironment, newSubEnvironment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT:
        return basicSetCurrentEnvironment(null, msgs);
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT:
        return basicSetSubEnvironment(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT:
        return getCurrentEnvironment();
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT:
        return getSubEnvironment();
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
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT:
        setCurrentEnvironment((EnvironmentSpecification)newValue);
        return;
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT:
        setSubEnvironment((EnvironmentSpecification)newValue);
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
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT:
        setCurrentEnvironment((EnvironmentSpecification)null);
        return;
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT:
        setSubEnvironment((EnvironmentSpecification)null);
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
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT:
        return currentEnvironment != null;
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT:
        return subEnvironment != null;
    }
    return super.eIsSet(featureID);
  }

} //EnvironmentCompositionImpl
