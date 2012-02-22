/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getJudgmentSymbol <em>Judgment Symbol</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getRelationSymbols <em>Relation Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleInvocation()
 * @model
 * @generated
 */
public interface RuleInvocation extends XExpression
{
  /**
   * Returns the value of the '<em><b>Environment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Environment</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Environment</em>' containment reference.
   * @see #setEnvironment(EnvironmentSpecification)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleInvocation_Environment()
   * @model containment="true"
   * @generated
   */
  EnvironmentSpecification getEnvironment();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getEnvironment <em>Environment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Environment</em>' containment reference.
   * @see #getEnvironment()
   * @generated
   */
  void setEnvironment(EnvironmentSpecification value);

  /**
   * Returns the value of the '<em><b>Judgment Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Judgment Symbol</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Judgment Symbol</em>' attribute.
   * @see #setJudgmentSymbol(String)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleInvocation_JudgmentSymbol()
   * @model
   * @generated
   */
  String getJudgmentSymbol();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getJudgmentSymbol <em>Judgment Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Judgment Symbol</em>' attribute.
   * @see #getJudgmentSymbol()
   * @generated
   */
  void setJudgmentSymbol(String value);

  /**
   * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.RuleInvocationExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expressions</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleInvocation_Expressions()
   * @model containment="true"
   * @generated
   */
  EList<RuleInvocationExpression> getExpressions();

  /**
   * Returns the value of the '<em><b>Relation Symbols</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relation Symbols</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relation Symbols</em>' attribute list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleInvocation_RelationSymbols()
   * @model unique="false"
   * @generated
   */
  EList<String> getRelationSymbols();

} // RuleInvocation
