/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Judgment Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl#isOverride <em>Override</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl#getJudgmentSymbol <em>Judgment Symbol</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl#getJudgmentParameters <em>Judgment Parameters</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl#getRelationSymbols <em>Relation Symbols</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl#getError <em>Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JudgmentDescriptionImpl extends MinimalEObjectImpl.Container implements JudgmentDescription
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
   * The default value of the '{@link #getJudgmentSymbol() <em>Judgment Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJudgmentSymbol()
   * @generated
   * @ordered
   */
  protected static final String JUDGMENT_SYMBOL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJudgmentSymbol() <em>Judgment Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJudgmentSymbol()
   * @generated
   * @ordered
   */
  protected String judgmentSymbol = JUDGMENT_SYMBOL_EDEFAULT;

  /**
   * The cached value of the '{@link #getJudgmentParameters() <em>Judgment Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJudgmentParameters()
   * @generated
   * @ordered
   */
  protected EList<JudgmentParameter> judgmentParameters;

  /**
   * The cached value of the '{@link #getRelationSymbols() <em>Relation Symbols</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelationSymbols()
   * @generated
   * @ordered
   */
  protected EList<String> relationSymbols;

  /**
   * The cached value of the '{@link #getError() <em>Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getError()
   * @generated
   * @ordered
   */
  protected ErrorSpecification error;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JudgmentDescriptionImpl()
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
    return XsemanticsPackage.Literals.JUDGMENT_DESCRIPTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.JUDGMENT_DESCRIPTION__OVERRIDE, oldOverride, override));
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
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.JUDGMENT_DESCRIPTION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getJudgmentSymbol()
  {
    return judgmentSymbol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJudgmentSymbol(String newJudgmentSymbol)
  {
    String oldJudgmentSymbol = judgmentSymbol;
    judgmentSymbol = newJudgmentSymbol;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_SYMBOL, oldJudgmentSymbol, judgmentSymbol));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JudgmentParameter> getJudgmentParameters()
  {
    if (judgmentParameters == null)
    {
      judgmentParameters = new EObjectContainmentEList<JudgmentParameter>(JudgmentParameter.class, this, XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS);
    }
    return judgmentParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getRelationSymbols()
  {
    if (relationSymbols == null)
    {
      relationSymbols = new EDataTypeEList<String>(String.class, this, XsemanticsPackage.JUDGMENT_DESCRIPTION__RELATION_SYMBOLS);
    }
    return relationSymbols;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorSpecification getError()
  {
    return error;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetError(ErrorSpecification newError, NotificationChain msgs)
  {
    ErrorSpecification oldError = error;
    error = newError;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.JUDGMENT_DESCRIPTION__ERROR, oldError, newError);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setError(ErrorSpecification newError)
  {
    if (newError != error)
    {
      NotificationChain msgs = null;
      if (error != null)
        msgs = ((InternalEObject)error).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.JUDGMENT_DESCRIPTION__ERROR, null, msgs);
      if (newError != null)
        msgs = ((InternalEObject)newError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.JUDGMENT_DESCRIPTION__ERROR, null, msgs);
      msgs = basicSetError(newError, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.JUDGMENT_DESCRIPTION__ERROR, newError, newError));
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
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS:
        return ((InternalEList<?>)getJudgmentParameters()).basicRemove(otherEnd, msgs);
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__ERROR:
        return basicSetError(null, msgs);
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
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__OVERRIDE:
        return isOverride();
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__NAME:
        return getName();
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_SYMBOL:
        return getJudgmentSymbol();
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS:
        return getJudgmentParameters();
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__RELATION_SYMBOLS:
        return getRelationSymbols();
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__ERROR:
        return getError();
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
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__OVERRIDE:
        setOverride((Boolean)newValue);
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__NAME:
        setName((String)newValue);
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_SYMBOL:
        setJudgmentSymbol((String)newValue);
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS:
        getJudgmentParameters().clear();
        getJudgmentParameters().addAll((Collection<? extends JudgmentParameter>)newValue);
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__RELATION_SYMBOLS:
        getRelationSymbols().clear();
        getRelationSymbols().addAll((Collection<? extends String>)newValue);
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__ERROR:
        setError((ErrorSpecification)newValue);
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
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__OVERRIDE:
        setOverride(OVERRIDE_EDEFAULT);
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_SYMBOL:
        setJudgmentSymbol(JUDGMENT_SYMBOL_EDEFAULT);
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS:
        getJudgmentParameters().clear();
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__RELATION_SYMBOLS:
        getRelationSymbols().clear();
        return;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__ERROR:
        setError((ErrorSpecification)null);
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
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__OVERRIDE:
        return override != OVERRIDE_EDEFAULT;
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_SYMBOL:
        return JUDGMENT_SYMBOL_EDEFAULT == null ? judgmentSymbol != null : !JUDGMENT_SYMBOL_EDEFAULT.equals(judgmentSymbol);
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS:
        return judgmentParameters != null && !judgmentParameters.isEmpty();
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__RELATION_SYMBOLS:
        return relationSymbols != null && !relationSymbols.isEmpty();
      case XsemanticsPackage.JUDGMENT_DESCRIPTION__ERROR:
        return error != null;
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
    result.append(", judgmentSymbol: ");
    result.append(judgmentSymbol);
    result.append(", relationSymbols: ");
    result.append(relationSymbols);
    result.append(')');
    return result.toString();
  }

} //JudgmentDescriptionImpl
