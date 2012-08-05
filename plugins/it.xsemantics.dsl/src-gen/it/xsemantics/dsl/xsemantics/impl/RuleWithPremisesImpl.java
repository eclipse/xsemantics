/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule With Premises</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleWithPremisesImpl#getPremises <em>Premises</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleWithPremisesImpl extends RuleImpl implements RuleWithPremises
{
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
  protected RuleWithPremisesImpl()
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
    return XsemanticsPackage.Literals.RULE_WITH_PREMISES;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_WITH_PREMISES__PREMISES, oldPremises, newPremises);
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
        msgs = ((InternalEObject)premises).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE_WITH_PREMISES__PREMISES, null, msgs);
      if (newPremises != null)
        msgs = ((InternalEObject)newPremises).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE_WITH_PREMISES__PREMISES, null, msgs);
      msgs = basicSetPremises(newPremises, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_WITH_PREMISES__PREMISES, newPremises, newPremises));
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
      case XsemanticsPackage.RULE_WITH_PREMISES__PREMISES:
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
      case XsemanticsPackage.RULE_WITH_PREMISES__PREMISES:
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
      case XsemanticsPackage.RULE_WITH_PREMISES__PREMISES:
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
      case XsemanticsPackage.RULE_WITH_PREMISES__PREMISES:
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
      case XsemanticsPackage.RULE_WITH_PREMISES__PREMISES:
        return premises != null;
    }
    return super.eIsSet(featureID);
  }

} //RuleWithPremisesImpl
