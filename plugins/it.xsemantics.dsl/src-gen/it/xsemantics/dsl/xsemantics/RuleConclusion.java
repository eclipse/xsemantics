/**
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Conclusion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getJudgmentSymbol <em>Judgment Symbol</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getConclusionElements <em>Conclusion Elements</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getRelationSymbols <em>Relation Symbols</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getError <em>Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleConclusion()
 * @model
 * @generated
 */
public interface RuleConclusion extends EObject
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
   * @see #setEnvironment(Environment)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleConclusion_Environment()
   * @model containment="true"
   * @generated
   */
  Environment getEnvironment();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getEnvironment <em>Environment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Environment</em>' containment reference.
   * @see #getEnvironment()
   * @generated
   */
  void setEnvironment(Environment value);

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
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleConclusion_JudgmentSymbol()
   * @model
   * @generated
   */
  String getJudgmentSymbol();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getJudgmentSymbol <em>Judgment Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Judgment Symbol</em>' attribute.
   * @see #getJudgmentSymbol()
   * @generated
   */
  void setJudgmentSymbol(String value);

  /**
   * Returns the value of the '<em><b>Conclusion Elements</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.RuleConclusionElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conclusion Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conclusion Elements</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleConclusion_ConclusionElements()
   * @model containment="true"
   * @generated
   */
  EList<RuleConclusionElement> getConclusionElements();

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
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleConclusion_RelationSymbols()
   * @model unique="false"
   * @generated
   */
  EList<String> getRelationSymbols();

  /**
   * Returns the value of the '<em><b>Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error</em>' containment reference.
   * @see #setError(ErrorSpecification)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleConclusion_Error()
   * @model containment="true"
   * @generated
   */
  ErrorSpecification getError();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getError <em>Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error</em>' containment reference.
   * @see #getError()
   * @generated
   */
  void setError(ErrorSpecification value);

} // RuleConclusion
