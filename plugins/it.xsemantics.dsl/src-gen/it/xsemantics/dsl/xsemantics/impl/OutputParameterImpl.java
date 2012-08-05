/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.OutputParameterImpl#getJvmTypeReference <em>Jvm Type Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputParameterImpl extends JudgmentParameterImpl implements OutputParameter
{
  /**
   * The cached value of the '{@link #getJvmTypeReference() <em>Jvm Type Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJvmTypeReference()
   * @generated
   * @ordered
   */
  protected JvmTypeReference jvmTypeReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OutputParameterImpl()
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
    return XsemanticsPackage.Literals.OUTPUT_PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getJvmTypeReference()
  {
    return jvmTypeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetJvmTypeReference(JvmTypeReference newJvmTypeReference, NotificationChain msgs)
  {
    JvmTypeReference oldJvmTypeReference = jvmTypeReference;
    jvmTypeReference = newJvmTypeReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.OUTPUT_PARAMETER__JVM_TYPE_REFERENCE, oldJvmTypeReference, newJvmTypeReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJvmTypeReference(JvmTypeReference newJvmTypeReference)
  {
    if (newJvmTypeReference != jvmTypeReference)
    {
      NotificationChain msgs = null;
      if (jvmTypeReference != null)
        msgs = ((InternalEObject)jvmTypeReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.OUTPUT_PARAMETER__JVM_TYPE_REFERENCE, null, msgs);
      if (newJvmTypeReference != null)
        msgs = ((InternalEObject)newJvmTypeReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.OUTPUT_PARAMETER__JVM_TYPE_REFERENCE, null, msgs);
      msgs = basicSetJvmTypeReference(newJvmTypeReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.OUTPUT_PARAMETER__JVM_TYPE_REFERENCE, newJvmTypeReference, newJvmTypeReference));
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
      case XsemanticsPackage.OUTPUT_PARAMETER__JVM_TYPE_REFERENCE:
        return basicSetJvmTypeReference(null, msgs);
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
      case XsemanticsPackage.OUTPUT_PARAMETER__JVM_TYPE_REFERENCE:
        return getJvmTypeReference();
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
      case XsemanticsPackage.OUTPUT_PARAMETER__JVM_TYPE_REFERENCE:
        setJvmTypeReference((JvmTypeReference)newValue);
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
      case XsemanticsPackage.OUTPUT_PARAMETER__JVM_TYPE_REFERENCE:
        setJvmTypeReference((JvmTypeReference)null);
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
      case XsemanticsPackage.OUTPUT_PARAMETER__JVM_TYPE_REFERENCE:
        return jvmTypeReference != null;
    }
    return super.eIsSet(featureID);
  }

} //OutputParameterImpl
