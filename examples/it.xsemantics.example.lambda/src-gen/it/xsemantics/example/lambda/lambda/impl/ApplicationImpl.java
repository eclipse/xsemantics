/**
 */
package it.xsemantics.example.lambda.lambda.impl;

import it.xsemantics.example.lambda.lambda.Application;
import it.xsemantics.example.lambda.lambda.LambdaPackage;
import it.xsemantics.example.lambda.lambda.Term;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.example.lambda.lambda.impl.ApplicationImpl#getFun <em>Fun</em>}</li>
 *   <li>{@link it.xsemantics.example.lambda.lambda.impl.ApplicationImpl#getArg <em>Arg</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationImpl extends TermImpl implements Application
{
  /**
   * The cached value of the '{@link #getFun() <em>Fun</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFun()
   * @generated
   * @ordered
   */
  protected Term fun;

  /**
   * The cached value of the '{@link #getArg() <em>Arg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg()
   * @generated
   * @ordered
   */
  protected Term arg;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ApplicationImpl()
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
    return LambdaPackage.Literals.APPLICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Term getFun()
  {
    return fun;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFun(Term newFun, NotificationChain msgs)
  {
    Term oldFun = fun;
    fun = newFun;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LambdaPackage.APPLICATION__FUN, oldFun, newFun);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFun(Term newFun)
  {
    if (newFun != fun)
    {
      NotificationChain msgs = null;
      if (fun != null)
        msgs = ((InternalEObject)fun).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LambdaPackage.APPLICATION__FUN, null, msgs);
      if (newFun != null)
        msgs = ((InternalEObject)newFun).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LambdaPackage.APPLICATION__FUN, null, msgs);
      msgs = basicSetFun(newFun, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LambdaPackage.APPLICATION__FUN, newFun, newFun));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Term getArg()
  {
    return arg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArg(Term newArg, NotificationChain msgs)
  {
    Term oldArg = arg;
    arg = newArg;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LambdaPackage.APPLICATION__ARG, oldArg, newArg);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArg(Term newArg)
  {
    if (newArg != arg)
    {
      NotificationChain msgs = null;
      if (arg != null)
        msgs = ((InternalEObject)arg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LambdaPackage.APPLICATION__ARG, null, msgs);
      if (newArg != null)
        msgs = ((InternalEObject)newArg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LambdaPackage.APPLICATION__ARG, null, msgs);
      msgs = basicSetArg(newArg, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LambdaPackage.APPLICATION__ARG, newArg, newArg));
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
      case LambdaPackage.APPLICATION__FUN:
        return basicSetFun(null, msgs);
      case LambdaPackage.APPLICATION__ARG:
        return basicSetArg(null, msgs);
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
      case LambdaPackage.APPLICATION__FUN:
        return getFun();
      case LambdaPackage.APPLICATION__ARG:
        return getArg();
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
      case LambdaPackage.APPLICATION__FUN:
        setFun((Term)newValue);
        return;
      case LambdaPackage.APPLICATION__ARG:
        setArg((Term)newValue);
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
      case LambdaPackage.APPLICATION__FUN:
        setFun((Term)null);
        return;
      case LambdaPackage.APPLICATION__ARG:
        setArg((Term)null);
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
      case LambdaPackage.APPLICATION__FUN:
        return fun != null;
      case LambdaPackage.APPLICATION__ARG:
        return arg != null;
    }
    return super.eIsSet(featureID);
  }

} //ApplicationImpl
