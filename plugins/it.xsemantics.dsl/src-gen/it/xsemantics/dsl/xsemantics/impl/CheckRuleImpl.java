/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Check Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.CheckRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.CheckRuleImpl#getElement <em>Element</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.CheckRuleImpl#getPremises <em>Premises</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckRuleImpl extends MinimalEObjectImpl.Container implements CheckRule
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected RuleParameter element;

  /**
   * The cached value of the '{@link #getPremises() <em>Premises</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPremises()
   * @generated
   * @ordered
   */
  protected XExpression premises;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CheckRuleImpl()
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
    return XsemanticsPackage.Literals.CHECK_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.CHECK_RULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleParameter getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElement(RuleParameter newElement, NotificationChain msgs)
  {
    RuleParameter oldElement = element;
    element = newElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.CHECK_RULE__ELEMENT, oldElement, newElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(RuleParameter newElement)
  {
    if (newElement != element)
    {
      NotificationChain msgs = null;
      if (element != null)
        msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.CHECK_RULE__ELEMENT, null, msgs);
      if (newElement != null)
        msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.CHECK_RULE__ELEMENT, null, msgs);
      msgs = basicSetElement(newElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.CHECK_RULE__ELEMENT, newElement, newElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getPremises()
  {
    return premises;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPremises(XExpression newPremises, NotificationChain msgs)
  {
    XExpression oldPremises = premises;
    premises = newPremises;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.CHECK_RULE__PREMISES, oldPremises, newPremises);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPremises(XExpression newPremises)
  {
    if (newPremises != premises)
    {
      NotificationChain msgs = null;
      if (premises != null)
        msgs = ((InternalEObject)premises).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.CHECK_RULE__PREMISES, null, msgs);
      if (newPremises != null)
        msgs = ((InternalEObject)newPremises).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.CHECK_RULE__PREMISES, null, msgs);
      msgs = basicSetPremises(newPremises, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.CHECK_RULE__PREMISES, newPremises, newPremises));
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
      case XsemanticsPackage.CHECK_RULE__ELEMENT:
        return basicSetElement(null, msgs);
      case XsemanticsPackage.CHECK_RULE__PREMISES:
        return basicSetPremises(null, msgs);
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
      case XsemanticsPackage.CHECK_RULE__NAME:
        return getName();
      case XsemanticsPackage.CHECK_RULE__ELEMENT:
        return getElement();
      case XsemanticsPackage.CHECK_RULE__PREMISES:
        return getPremises();
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
      case XsemanticsPackage.CHECK_RULE__NAME:
        setName((String)newValue);
        return;
      case XsemanticsPackage.CHECK_RULE__ELEMENT:
        setElement((RuleParameter)newValue);
        return;
      case XsemanticsPackage.CHECK_RULE__PREMISES:
        setPremises((XExpression)newValue);
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
      case XsemanticsPackage.CHECK_RULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XsemanticsPackage.CHECK_RULE__ELEMENT:
        setElement((RuleParameter)null);
        return;
      case XsemanticsPackage.CHECK_RULE__PREMISES:
        setPremises((XExpression)null);
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
      case XsemanticsPackage.CHECK_RULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XsemanticsPackage.CHECK_RULE__ELEMENT:
        return element != null;
      case XsemanticsPackage.CHECK_RULE__PREMISES:
        return premises != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //CheckRuleImpl
