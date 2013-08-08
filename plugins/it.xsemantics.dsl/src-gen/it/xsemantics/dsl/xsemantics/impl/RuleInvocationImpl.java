/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XExpression;

import org.eclipse.xtext.xbase.impl.XExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleInvocationImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleInvocationImpl#getJudgmentSymbol <em>Judgment Symbol</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleInvocationImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.impl.RuleInvocationImpl#getRelationSymbols <em>Relation Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleInvocationImpl extends XExpressionImpl implements RuleInvocation
{
  /**
   * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnvironment()
   * @generated
   * @ordered
   */
  protected EnvironmentSpecification environment;

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
   * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressions()
   * @generated
   * @ordered
   */
  protected EList<XExpression> expressions;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleInvocationImpl()
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
    return XsemanticsPackage.Literals.RULE_INVOCATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnvironmentSpecification getEnvironment()
  {
    return environment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnvironment(EnvironmentSpecification newEnvironment, NotificationChain msgs)
  {
    EnvironmentSpecification oldEnvironment = environment;
    environment = newEnvironment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_INVOCATION__ENVIRONMENT, oldEnvironment, newEnvironment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnvironment(EnvironmentSpecification newEnvironment)
  {
    if (newEnvironment != environment)
    {
      NotificationChain msgs = null;
      if (environment != null)
        msgs = ((InternalEObject)environment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE_INVOCATION__ENVIRONMENT, null, msgs);
      if (newEnvironment != null)
        msgs = ((InternalEObject)newEnvironment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XsemanticsPackage.RULE_INVOCATION__ENVIRONMENT, null, msgs);
      msgs = basicSetEnvironment(newEnvironment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_INVOCATION__ENVIRONMENT, newEnvironment, newEnvironment));
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
      eNotify(new ENotificationImpl(this, Notification.SET, XsemanticsPackage.RULE_INVOCATION__JUDGMENT_SYMBOL, oldJudgmentSymbol, judgmentSymbol));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XExpression> getExpressions()
  {
    if (expressions == null)
    {
      expressions = new EObjectContainmentEList<XExpression>(XExpression.class, this, XsemanticsPackage.RULE_INVOCATION__EXPRESSIONS);
    }
    return expressions;
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
      relationSymbols = new EDataTypeEList<String>(String.class, this, XsemanticsPackage.RULE_INVOCATION__RELATION_SYMBOLS);
    }
    return relationSymbols;
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
      case XsemanticsPackage.RULE_INVOCATION__ENVIRONMENT:
        return basicSetEnvironment(null, msgs);
      case XsemanticsPackage.RULE_INVOCATION__EXPRESSIONS:
        return ((InternalEList<?>)getExpressions()).basicRemove(otherEnd, msgs);
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
      case XsemanticsPackage.RULE_INVOCATION__ENVIRONMENT:
        return getEnvironment();
      case XsemanticsPackage.RULE_INVOCATION__JUDGMENT_SYMBOL:
        return getJudgmentSymbol();
      case XsemanticsPackage.RULE_INVOCATION__EXPRESSIONS:
        return getExpressions();
      case XsemanticsPackage.RULE_INVOCATION__RELATION_SYMBOLS:
        return getRelationSymbols();
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
      case XsemanticsPackage.RULE_INVOCATION__ENVIRONMENT:
        setEnvironment((EnvironmentSpecification)newValue);
        return;
      case XsemanticsPackage.RULE_INVOCATION__JUDGMENT_SYMBOL:
        setJudgmentSymbol((String)newValue);
        return;
      case XsemanticsPackage.RULE_INVOCATION__EXPRESSIONS:
        getExpressions().clear();
        getExpressions().addAll((Collection<? extends XExpression>)newValue);
        return;
      case XsemanticsPackage.RULE_INVOCATION__RELATION_SYMBOLS:
        getRelationSymbols().clear();
        getRelationSymbols().addAll((Collection<? extends String>)newValue);
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
      case XsemanticsPackage.RULE_INVOCATION__ENVIRONMENT:
        setEnvironment((EnvironmentSpecification)null);
        return;
      case XsemanticsPackage.RULE_INVOCATION__JUDGMENT_SYMBOL:
        setJudgmentSymbol(JUDGMENT_SYMBOL_EDEFAULT);
        return;
      case XsemanticsPackage.RULE_INVOCATION__EXPRESSIONS:
        getExpressions().clear();
        return;
      case XsemanticsPackage.RULE_INVOCATION__RELATION_SYMBOLS:
        getRelationSymbols().clear();
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
      case XsemanticsPackage.RULE_INVOCATION__ENVIRONMENT:
        return environment != null;
      case XsemanticsPackage.RULE_INVOCATION__JUDGMENT_SYMBOL:
        return JUDGMENT_SYMBOL_EDEFAULT == null ? judgmentSymbol != null : !JUDGMENT_SYMBOL_EDEFAULT.equals(judgmentSymbol);
      case XsemanticsPackage.RULE_INVOCATION__EXPRESSIONS:
        return expressions != null && !expressions.isEmpty();
      case XsemanticsPackage.RULE_INVOCATION__RELATION_SYMBOLS:
        return relationSymbols != null && !relationSymbols.isEmpty();
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

} //RuleInvocationImpl
