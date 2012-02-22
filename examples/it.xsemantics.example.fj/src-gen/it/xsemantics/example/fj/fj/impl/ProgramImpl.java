/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.fj.fj.impl;

import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.FjPackage;
import it.xsemantics.example.fj.fj.Program;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.example.fj.fj.impl.ProgramImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link it.xsemantics.example.fj.fj.impl.ProgramImpl#getMain <em>Main</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgramImpl extends MinimalEObjectImpl.Container implements Program
{
  /**
   * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClasses()
   * @generated
   * @ordered
   */
  protected EList<it.xsemantics.example.fj.fj.Class> classes;

  /**
   * The cached value of the '{@link #getMain() <em>Main</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMain()
   * @generated
   * @ordered
   */
  protected Expression main;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProgramImpl()
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
    return FjPackage.Literals.PROGRAM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<it.xsemantics.example.fj.fj.Class> getClasses()
  {
    if (classes == null)
    {
      classes = new EObjectContainmentEList<it.xsemantics.example.fj.fj.Class>(it.xsemantics.example.fj.fj.Class.class, this, FjPackage.PROGRAM__CLASSES);
    }
    return classes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getMain()
  {
    return main;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMain(Expression newMain, NotificationChain msgs)
  {
    Expression oldMain = main;
    main = newMain;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FjPackage.PROGRAM__MAIN, oldMain, newMain);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMain(Expression newMain)
  {
    if (newMain != main)
    {
      NotificationChain msgs = null;
      if (main != null)
        msgs = ((InternalEObject)main).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FjPackage.PROGRAM__MAIN, null, msgs);
      if (newMain != null)
        msgs = ((InternalEObject)newMain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FjPackage.PROGRAM__MAIN, null, msgs);
      msgs = basicSetMain(newMain, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FjPackage.PROGRAM__MAIN, newMain, newMain));
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
      case FjPackage.PROGRAM__CLASSES:
        return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
      case FjPackage.PROGRAM__MAIN:
        return basicSetMain(null, msgs);
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
      case FjPackage.PROGRAM__CLASSES:
        return getClasses();
      case FjPackage.PROGRAM__MAIN:
        return getMain();
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
      case FjPackage.PROGRAM__CLASSES:
        getClasses().clear();
        getClasses().addAll((Collection<? extends it.xsemantics.example.fj.fj.Class>)newValue);
        return;
      case FjPackage.PROGRAM__MAIN:
        setMain((Expression)newValue);
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
      case FjPackage.PROGRAM__CLASSES:
        getClasses().clear();
        return;
      case FjPackage.PROGRAM__MAIN:
        setMain((Expression)null);
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
      case FjPackage.PROGRAM__CLASSES:
        return classes != null && !classes.isEmpty();
      case FjPackage.PROGRAM__MAIN:
        return main != null;
    }
    return super.eIsSet(featureID);
  }

} //ProgramImpl
