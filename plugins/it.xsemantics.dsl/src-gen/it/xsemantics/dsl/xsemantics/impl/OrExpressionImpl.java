/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xbase.impl.XExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.OrExpressionImpl#getBranches <em>Branches</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrExpressionImpl extends XExpressionImpl implements OrExpression
{
  /**
   * The cached value of the '{@link #getBranches() <em>Branches</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBranches()
   * @generated
   * @ordered
   */
  protected EList<XExpression> branches;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OrExpressionImpl()
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
    return XsemanticsPackage.Literals.OR_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XExpression> getBranches()
  {
    if (branches == null)
    {
      branches = new EObjectContainmentEList<XExpression>(XExpression.class, this, XsemanticsPackage.OR_EXPRESSION__BRANCHES);
    }
    return branches;
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
      case XsemanticsPackage.OR_EXPRESSION__BRANCHES:
        return ((InternalEList<?>)getBranches()).basicRemove(otherEnd, msgs);
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
      case XsemanticsPackage.OR_EXPRESSION__BRANCHES:
        return getBranches();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case XsemanticsPackage.OR_EXPRESSION__BRANCHES:
        getBranches().clear();
        getBranches().addAll((Collection<? extends XExpression>)newValue);
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
      case XsemanticsPackage.OR_EXPRESSION__BRANCHES:
        getBranches().clear();
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
      case XsemanticsPackage.OR_EXPRESSION__BRANCHES:
        return branches != null && !branches.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OrExpressionImpl
