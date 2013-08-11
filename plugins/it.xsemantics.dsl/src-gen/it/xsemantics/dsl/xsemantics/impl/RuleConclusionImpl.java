/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.Environment;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
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

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Conclusion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleConclusionImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleConclusionImpl#getJudgmentSymbol <em>Judgment Symbol</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleConclusionImpl#getConclusionElements <em>Conclusion Elements</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleConclusionImpl#getRelationSymbols <em>Relation Symbols</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleConclusionImpl#getError <em>Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleConclusionImpl extends MinimalEObjectImpl.Container implements RuleConclusion
{
  /**
   * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnvironment()
   * @generated
   * @ordered
   */
  protected Environment environment;

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
   * The cached value of the '{@link #getConclusionElements() <em>Conclusion Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConclusionElements()
   * @generated
   * @ordered
   */
  protected EList<RuleConclusionElement> conclusionElements;

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
  protected XExpression error;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleConclusionImpl()
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
    return XsemanticsPackage.Literals.RULE_CONCLUSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment getEnvironment()
  {
    return environment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnvironment(Environment newEnvironment, NotificationChain msgs)
  {
    Environment oldEnvironment = environment;
    environment = newEnvironment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_CONCLUSION__ENVIRONMENT, oldEnvironment, newEnvironment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnvironment(Environment newEnvironment)
  {
    if (newEnvironment != environment)
    {
      NotificationChain msgs = null;
      if (environment != null)
        msgs = ((InternalEObject)environment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE_CONCLUSION__ENVIRONMENT, null, msgs);
      if (newEnvironment != null)
        msgs = ((InternalEObject)newEnvironment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE_CONCLUSION__ENVIRONMENT, null, msgs);
      msgs = basicSetEnvironment(newEnvironment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_CONCLUSION__ENVIRONMENT, newEnvironment, newEnvironment));
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
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_CONCLUSION__JUDGMENT_SYMBOL, oldJudgmentSymbol, judgmentSymbol));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RuleConclusionElement> getConclusionElements()
  {
    if (conclusionElements == null)
    {
      conclusionElements = new EObjectContainmentEList<RuleConclusionElement>(RuleConclusionElement.class, this, XsemanticsPackage.RULE_CONCLUSION__CONCLUSION_ELEMENTS);
    }
    return conclusionElements;
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
      relationSymbols = new EDataTypeEList<String>(String.class, this, XsemanticsPackage.RULE_CONCLUSION__RELATION_SYMBOLS);
    }
    return relationSymbols;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_CONCLUSION__ERROR, oldError, newError);
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
        msgs = ((InternalEObject)error).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE_CONCLUSION__ERROR, null, msgs);
      if (newError != null)
        msgs = ((InternalEObject)newError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE_CONCLUSION__ERROR, null, msgs);
      msgs = basicSetError(newError, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_CONCLUSION__ERROR, newError, newError));
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
      case XsemanticsPackage.RULE_CONCLUSION__ENVIRONMENT:
        return basicSetEnvironment(null, msgs);
      case XsemanticsPackage.RULE_CONCLUSION__CONCLUSION_ELEMENTS:
        return ((InternalEList<?>)getConclusionElements()).basicRemove(otherEnd, msgs);
      case XsemanticsPackage.RULE_CONCLUSION__ERROR:
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
      case XsemanticsPackage.RULE_CONCLUSION__ENVIRONMENT:
        return getEnvironment();
      case XsemanticsPackage.RULE_CONCLUSION__JUDGMENT_SYMBOL:
        return getJudgmentSymbol();
      case XsemanticsPackage.RULE_CONCLUSION__CONCLUSION_ELEMENTS:
        return getConclusionElements();
      case XsemanticsPackage.RULE_CONCLUSION__RELATION_SYMBOLS:
        return getRelationSymbols();
      case XsemanticsPackage.RULE_CONCLUSION__ERROR:
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
      case XsemanticsPackage.RULE_CONCLUSION__ENVIRONMENT:
        setEnvironment((Environment)newValue);
        return;
      case XsemanticsPackage.RULE_CONCLUSION__JUDGMENT_SYMBOL:
        setJudgmentSymbol((String)newValue);
        return;
      case XsemanticsPackage.RULE_CONCLUSION__CONCLUSION_ELEMENTS:
        getConclusionElements().clear();
        getConclusionElements().addAll((Collection<? extends RuleConclusionElement>)newValue);
        return;
      case XsemanticsPackage.RULE_CONCLUSION__RELATION_SYMBOLS:
        getRelationSymbols().clear();
        getRelationSymbols().addAll((Collection<? extends String>)newValue);
        return;
      case XsemanticsPackage.RULE_CONCLUSION__ERROR:
        setError((XExpression)newValue);
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
      case XsemanticsPackage.RULE_CONCLUSION__ENVIRONMENT:
        setEnvironment((Environment)null);
        return;
      case XsemanticsPackage.RULE_CONCLUSION__JUDGMENT_SYMBOL:
        setJudgmentSymbol(JUDGMENT_SYMBOL_EDEFAULT);
        return;
      case XsemanticsPackage.RULE_CONCLUSION__CONCLUSION_ELEMENTS:
        getConclusionElements().clear();
        return;
      case XsemanticsPackage.RULE_CONCLUSION__RELATION_SYMBOLS:
        getRelationSymbols().clear();
        return;
      case XsemanticsPackage.RULE_CONCLUSION__ERROR:
        setError((XExpression)null);
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
      case XsemanticsPackage.RULE_CONCLUSION__ENVIRONMENT:
        return environment != null;
      case XsemanticsPackage.RULE_CONCLUSION__JUDGMENT_SYMBOL:
        return JUDGMENT_SYMBOL_EDEFAULT == null ? judgmentSymbol != null : !JUDGMENT_SYMBOL_EDEFAULT.equals(judgmentSymbol);
      case XsemanticsPackage.RULE_CONCLUSION__CONCLUSION_ELEMENTS:
        return conclusionElements != null && !conclusionElements.isEmpty();
      case XsemanticsPackage.RULE_CONCLUSION__RELATION_SYMBOLS:
        return relationSymbols != null && !relationSymbols.isEmpty();
      case XsemanticsPackage.RULE_CONCLUSION__ERROR:
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
    result.append(" (judgmentSymbol: ");
    result.append(judgmentSymbol);
    result.append(", relationSymbols: ");
    result.append(relationSymbols);
    result.append(')');
    return result.toString();
  }

} //RuleConclusionImpl
