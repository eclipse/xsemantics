/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.Import;
import it.xsemantics.dsl.xsemantics.Injected;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;

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

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl#getValidatorExtends <em>Validator Extends</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl#getInjections <em>Injections</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl#getJudgmentDescriptions <em>Judgment Descriptions</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl#getCheckrules <em>Checkrules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XsemanticsSystemImpl extends MinimalEObjectImpl.Container implements XsemanticsSystem
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
   * The cached value of the '{@link #getValidatorExtends() <em>Validator Extends</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValidatorExtends()
   * @generated
   * @ordered
   */
  protected JvmParameterizedTypeReference validatorExtends;

  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getInjections() <em>Injections</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInjections()
   * @generated
   * @ordered
   */
  protected EList<Injected> injections;

  /**
   * The cached value of the '{@link #getJudgmentDescriptions() <em>Judgment Descriptions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJudgmentDescriptions()
   * @generated
   * @ordered
   */
  protected EList<JudgmentDescription> judgmentDescriptions;

  /**
   * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRules()
   * @generated
   * @ordered
   */
  protected EList<Rule> rules;

  /**
   * The cached value of the '{@link #getCheckrules() <em>Checkrules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCheckrules()
   * @generated
   * @ordered
   */
  protected EList<CheckRule> checkrules;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XsemanticsSystemImpl()
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
    return XsemanticsPackage.Literals.XSEMANTICS_SYSTEM;
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
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.XSEMANTICS_SYSTEM__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmParameterizedTypeReference getValidatorExtends()
  {
    return validatorExtends;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValidatorExtends(JvmParameterizedTypeReference newValidatorExtends, NotificationChain msgs)
  {
    JvmParameterizedTypeReference oldValidatorExtends = validatorExtends;
    validatorExtends = newValidatorExtends;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS, oldValidatorExtends, newValidatorExtends);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValidatorExtends(JvmParameterizedTypeReference newValidatorExtends)
  {
    if (newValidatorExtends != validatorExtends)
    {
      NotificationChain msgs = null;
      if (validatorExtends != null)
        msgs = ((InternalEObject)validatorExtends).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS, null, msgs);
      if (newValidatorExtends != null)
        msgs = ((InternalEObject)newValidatorExtends).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS, null, msgs);
      msgs = basicSetValidatorExtends(newValidatorExtends, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS, newValidatorExtends, newValidatorExtends));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, XsemanticsPackage.XSEMANTICS_SYSTEM__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Injected> getInjections()
  {
    if (injections == null)
    {
      injections = new EObjectContainmentEList<Injected>(Injected.class, this, XsemanticsPackage.XSEMANTICS_SYSTEM__INJECTIONS);
    }
    return injections;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JudgmentDescription> getJudgmentDescriptions()
  {
    if (judgmentDescriptions == null)
    {
      judgmentDescriptions = new EObjectContainmentEList<JudgmentDescription>(JudgmentDescription.class, this, XsemanticsPackage.XSEMANTICS_SYSTEM__JUDGMENT_DESCRIPTIONS);
    }
    return judgmentDescriptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Rule> getRules()
  {
    if (rules == null)
    {
      rules = new EObjectContainmentEList<Rule>(Rule.class, this, XsemanticsPackage.XSEMANTICS_SYSTEM__RULES);
    }
    return rules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CheckRule> getCheckrules()
  {
    if (checkrules == null)
    {
      checkrules = new EObjectContainmentEList<CheckRule>(CheckRule.class, this, XsemanticsPackage.XSEMANTICS_SYSTEM__CHECKRULES);
    }
    return checkrules;
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
      case XsemanticsPackage.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS:
        return basicSetValidatorExtends(null, msgs);
      case XsemanticsPackage.XSEMANTICS_SYSTEM__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case XsemanticsPackage.XSEMANTICS_SYSTEM__INJECTIONS:
        return ((InternalEList<?>)getInjections()).basicRemove(otherEnd, msgs);
      case XsemanticsPackage.XSEMANTICS_SYSTEM__JUDGMENT_DESCRIPTIONS:
        return ((InternalEList<?>)getJudgmentDescriptions()).basicRemove(otherEnd, msgs);
      case XsemanticsPackage.XSEMANTICS_SYSTEM__RULES:
        return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
      case XsemanticsPackage.XSEMANTICS_SYSTEM__CHECKRULES:
        return ((InternalEList<?>)getCheckrules()).basicRemove(otherEnd, msgs);
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
      case XsemanticsPackage.XSEMANTICS_SYSTEM__NAME:
        return getName();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS:
        return getValidatorExtends();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__IMPORTS:
        return getImports();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__INJECTIONS:
        return getInjections();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__JUDGMENT_DESCRIPTIONS:
        return getJudgmentDescriptions();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__RULES:
        return getRules();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__CHECKRULES:
        return getCheckrules();
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
      case XsemanticsPackage.XSEMANTICS_SYSTEM__NAME:
        setName((String)newValue);
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS:
        setValidatorExtends((JvmParameterizedTypeReference)newValue);
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__INJECTIONS:
        getInjections().clear();
        getInjections().addAll((Collection<? extends Injected>)newValue);
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__JUDGMENT_DESCRIPTIONS:
        getJudgmentDescriptions().clear();
        getJudgmentDescriptions().addAll((Collection<? extends JudgmentDescription>)newValue);
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__RULES:
        getRules().clear();
        getRules().addAll((Collection<? extends Rule>)newValue);
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__CHECKRULES:
        getCheckrules().clear();
        getCheckrules().addAll((Collection<? extends CheckRule>)newValue);
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
      case XsemanticsPackage.XSEMANTICS_SYSTEM__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS:
        setValidatorExtends((JvmParameterizedTypeReference)null);
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__IMPORTS:
        getImports().clear();
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__INJECTIONS:
        getInjections().clear();
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__JUDGMENT_DESCRIPTIONS:
        getJudgmentDescriptions().clear();
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__RULES:
        getRules().clear();
        return;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__CHECKRULES:
        getCheckrules().clear();
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
      case XsemanticsPackage.XSEMANTICS_SYSTEM__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XsemanticsPackage.XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS:
        return validatorExtends != null;
      case XsemanticsPackage.XSEMANTICS_SYSTEM__IMPORTS:
        return imports != null && !imports.isEmpty();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__INJECTIONS:
        return injections != null && !injections.isEmpty();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__JUDGMENT_DESCRIPTIONS:
        return judgmentDescriptions != null && !judgmentDescriptions.isEmpty();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__RULES:
        return rules != null && !rules.isEmpty();
      case XsemanticsPackage.XSEMANTICS_SYSTEM__CHECKRULES:
        return checkrules != null && !checkrules.isEmpty();
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

} //XsemanticsSystemImpl
