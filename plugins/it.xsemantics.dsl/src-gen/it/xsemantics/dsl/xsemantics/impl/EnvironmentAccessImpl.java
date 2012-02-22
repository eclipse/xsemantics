/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.Environment;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xbase.impl.XExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentAccessImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentAccessImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentAccessImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentAccessImpl extends XExpressionImpl implements EnvironmentAccess
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
   * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgument()
   * @generated
   * @ordered
   */
  protected XExpression argument;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected JvmTypeReference type;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnvironmentAccessImpl()
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
    return XsemanticsPackage.Literals.ENVIRONMENT_ACCESS;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XsemanticsPackage.ENVIRONMENT_ACCESS__ENVIRONMENT, oldEnvironment, environment));
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
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_ACCESS__ENVIRONMENT, oldEnvironment, environment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getArgument()
  {
    return argument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArgument(XExpression newArgument, NotificationChain msgs)
  {
    XExpression oldArgument = argument;
    argument = newArgument;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_ACCESS__ARGUMENT, oldArgument, newArgument);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArgument(XExpression newArgument)
  {
    if (newArgument != argument)
    {
      NotificationChain msgs = null;
      if (argument != null)
        msgs = ((InternalEObject)argument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ENVIRONMENT_ACCESS__ARGUMENT, null, msgs);
      if (newArgument != null)
        msgs = ((InternalEObject)newArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ENVIRONMENT_ACCESS__ARGUMENT, null, msgs);
      msgs = basicSetArgument(newArgument, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_ACCESS__ARGUMENT, newArgument, newArgument));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(JvmTypeReference newType, NotificationChain msgs)
  {
    JvmTypeReference oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_ACCESS__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(JvmTypeReference newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ENVIRONMENT_ACCESS__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ENVIRONMENT_ACCESS__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ENVIRONMENT_ACCESS__TYPE, newType, newType));
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
      case XsemanticsPackage.ENVIRONMENT_ACCESS__ARGUMENT:
        return basicSetArgument(null, msgs);
      case XsemanticsPackage.ENVIRONMENT_ACCESS__TYPE:
        return basicSetType(null, msgs);
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
      case XsemanticsPackage.ENVIRONMENT_ACCESS__ENVIRONMENT:
        if (resolve) return getEnvironment();
        return basicGetEnvironment();
      case XsemanticsPackage.ENVIRONMENT_ACCESS__ARGUMENT:
        return getArgument();
      case XsemanticsPackage.ENVIRONMENT_ACCESS__TYPE:
        return getType();
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
      case XsemanticsPackage.ENVIRONMENT_ACCESS__ENVIRONMENT:
        setEnvironment((Environment)newValue);
        return;
      case XsemanticsPackage.ENVIRONMENT_ACCESS__ARGUMENT:
        setArgument((XExpression)newValue);
        return;
      case XsemanticsPackage.ENVIRONMENT_ACCESS__TYPE:
        setType((JvmTypeReference)newValue);
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
      case XsemanticsPackage.ENVIRONMENT_ACCESS__ENVIRONMENT:
        setEnvironment((Environment)null);
        return;
      case XsemanticsPackage.ENVIRONMENT_ACCESS__ARGUMENT:
        setArgument((XExpression)null);
        return;
      case XsemanticsPackage.ENVIRONMENT_ACCESS__TYPE:
        setType((JvmTypeReference)null);
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
      case XsemanticsPackage.ENVIRONMENT_ACCESS__ENVIRONMENT:
        return environment != null;
      case XsemanticsPackage.ENVIRONMENT_ACCESS__ARGUMENT:
        return argument != null;
      case XsemanticsPackage.ENVIRONMENT_ACCESS__TYPE:
        return type != null;
    }
    return super.eIsSet(featureID);
  }

} //EnvironmentAccessImpl
