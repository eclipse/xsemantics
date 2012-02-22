/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.ErrorSpecification;
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
 * An implementation of the model object '<em><b>Error Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.ErrorSpecificationImpl#getError <em>Error</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.ErrorSpecificationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.ErrorSpecificationImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorSpecificationImpl extends MinimalEObjectImpl.Container implements ErrorSpecification
{
  /**
   * The cached value of the '{@link #getError() <em>Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getError()
   * @generated
   * @ordered
   */
  protected XExpression error;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected XExpression source;

  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected XExpression feature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorSpecificationImpl()
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
    return XsemanticsPackage.Literals.ERROR_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getError()
  {
    return error;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetError(XExpression newError, NotificationChain msgs)
  {
    XExpression oldError = error;
    error = newError;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ERROR_SPECIFICATION__ERROR, oldError, newError);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setError(XExpression newError)
  {
    if (newError != error)
    {
      NotificationChain msgs = null;
      if (error != null)
        msgs = ((InternalEObject)error).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ERROR_SPECIFICATION__ERROR, null, msgs);
      if (newError != null)
        msgs = ((InternalEObject)newError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ERROR_SPECIFICATION__ERROR, null, msgs);
      msgs = basicSetError(newError, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ERROR_SPECIFICATION__ERROR, newError, newError));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSource(XExpression newSource, NotificationChain msgs)
  {
    XExpression oldSource = source;
    source = newSource;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ERROR_SPECIFICATION__SOURCE, oldSource, newSource);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(XExpression newSource)
  {
    if (newSource != source)
    {
      NotificationChain msgs = null;
      if (source != null)
        msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ERROR_SPECIFICATION__SOURCE, null, msgs);
      if (newSource != null)
        msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ERROR_SPECIFICATION__SOURCE, null, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ERROR_SPECIFICATION__SOURCE, newSource, newSource));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XExpression getFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFeature(XExpression newFeature, NotificationChain msgs)
  {
    XExpression oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ERROR_SPECIFICATION__FEATURE, oldFeature, newFeature);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeature(XExpression newFeature)
  {
    if (newFeature != feature)
    {
      NotificationChain msgs = null;
      if (feature != null)
        msgs = ((InternalEObject)feature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ERROR_SPECIFICATION__FEATURE, null, msgs);
      if (newFeature != null)
        msgs = ((InternalEObject)newFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.ERROR_SPECIFICATION__FEATURE, null, msgs);
      msgs = basicSetFeature(newFeature, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.ERROR_SPECIFICATION__FEATURE, newFeature, newFeature));
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
      case XsemanticsPackage.ERROR_SPECIFICATION__ERROR:
        return basicSetError(null, msgs);
      case XsemanticsPackage.ERROR_SPECIFICATION__SOURCE:
        return basicSetSource(null, msgs);
      case XsemanticsPackage.ERROR_SPECIFICATION__FEATURE:
        return basicSetFeature(null, msgs);
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
      case XsemanticsPackage.ERROR_SPECIFICATION__ERROR:
        return getError();
      case XsemanticsPackage.ERROR_SPECIFICATION__SOURCE:
        return getSource();
      case XsemanticsPackage.ERROR_SPECIFICATION__FEATURE:
        return getFeature();
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
      case XsemanticsPackage.ERROR_SPECIFICATION__ERROR:
        setError((XExpression)newValue);
        return;
      case XsemanticsPackage.ERROR_SPECIFICATION__SOURCE:
        setSource((XExpression)newValue);
        return;
      case XsemanticsPackage.ERROR_SPECIFICATION__FEATURE:
        setFeature((XExpression)newValue);
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
      case XsemanticsPackage.ERROR_SPECIFICATION__ERROR:
        setError((XExpression)null);
        return;
      case XsemanticsPackage.ERROR_SPECIFICATION__SOURCE:
        setSource((XExpression)null);
        return;
      case XsemanticsPackage.ERROR_SPECIFICATION__FEATURE:
        setFeature((XExpression)null);
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
      case XsemanticsPackage.ERROR_SPECIFICATION__ERROR:
        return error != null;
      case XsemanticsPackage.ERROR_SPECIFICATION__SOURCE:
        return source != null;
      case XsemanticsPackage.ERROR_SPECIFICATION__FEATURE:
        return feature != null;
    }
    return super.eIsSet(featureID);
  }

} //ErrorSpecificationImpl
