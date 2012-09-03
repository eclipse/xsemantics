/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleImpl#isOverride <em>Override</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleImpl#getConclusion <em>Conclusion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleImpl extends MinimalEObjectImpl.Container implements Rule
{
  /**
   * The default value of the '{@link #isOverride() <em>Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOverride()
   * @generated
   * @ordered
   */
  protected static final boolean OVERRIDE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOverride() <em>Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOverride()
   * @generated
   * @ordered
   */
  protected boolean override = OVERRIDE_EDEFAULT;

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
   * The cached value of the '{@link #getConclusion() <em>Conclusion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConclusion()
   * @generated
   * @ordered
   */
  protected RuleConclusion conclusion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleImpl()
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
    return XsemanticsPackage.Literals.RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOverride()
  {
    return override;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOverride(boolean newOverride)
  {
    boolean oldOverride = override;
    override = newOverride;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE__OVERRIDE, oldOverride, override));
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
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleConclusion getConclusion()
  {
    return conclusion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConclusion(RuleConclusion newConclusion, NotificationChain msgs)
  {
    RuleConclusion oldConclusion = conclusion;
    conclusion = newConclusion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE__CONCLUSION, oldConclusion, newConclusion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConclusion(RuleConclusion newConclusion)
  {
    if (newConclusion != conclusion)
    {
      NotificationChain msgs = null;
      if (conclusion != null)
        msgs = ((InternalEObject)conclusion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE__CONCLUSION, null, msgs);
      if (newConclusion != null)
        msgs = ((InternalEObject)newConclusion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE__CONCLUSION, null, msgs);
      msgs = basicSetConclusion(newConclusion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE__CONCLUSION, newConclusion, newConclusion));
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
      case XsemanticsPackage.RULE__CONCLUSION:
        return basicSetConclusion(null, msgs);
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
      case XsemanticsPackage.RULE__OVERRIDE:
        return isOverride();
      case XsemanticsPackage.RULE__NAME:
        return getName();
      case XsemanticsPackage.RULE__CONCLUSION:
        return getConclusion();
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
      case XsemanticsPackage.RULE__OVERRIDE:
        setOverride((Boolean)newValue);
        return;
      case XsemanticsPackage.RULE__NAME:
        setName((String)newValue);
        return;
      case XsemanticsPackage.RULE__CONCLUSION:
        setConclusion((RuleConclusion)newValue);
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
      case XsemanticsPackage.RULE__OVERRIDE:
        setOverride(OVERRIDE_EDEFAULT);
        return;
      case XsemanticsPackage.RULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XsemanticsPackage.RULE__CONCLUSION:
        setConclusion((RuleConclusion)null);
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
      case XsemanticsPackage.RULE__OVERRIDE:
        return override != OVERRIDE_EDEFAULT;
      case XsemanticsPackage.RULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XsemanticsPackage.RULE__CONCLUSION:
        return conclusion != null;
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
    result.append(" (override: ");
    result.append(override);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //RuleImpl
