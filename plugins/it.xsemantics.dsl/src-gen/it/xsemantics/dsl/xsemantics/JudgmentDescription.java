/**
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Judgment Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#isOverride <em>Override</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getName <em>Name</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getJudgmentSymbol <em>Judgment Symbol</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getJudgmentParameters <em>Judgment Parameters</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getRelationSymbols <em>Relation Symbols</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getError <em>Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getJudgmentDescription()
 * @model
 * @generated
 */
public interface JudgmentDescription extends EObject
{
  /**
   * Returns the value of the '<em><b>Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Override</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Override</em>' attribute.
   * @see #setOverride(boolean)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getJudgmentDescription_Override()
   * @model
   * @generated
   */
  boolean isOverride();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#isOverride <em>Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Override</em>' attribute.
   * @see #isOverride()
   * @generated
   */
  void setOverride(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getJudgmentDescription_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getJudgmentDescription_JudgmentSymbol()
   * @model
   * @generated
   */
  String getJudgmentSymbol();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getJudgmentSymbol <em>Judgment Symbol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Judgment Symbol</em>' attribute.
   * @see #getJudgmentSymbol()
   * @generated
   */
  void setJudgmentSymbol(String value);

  /**
   * Returns the value of the '<em><b>Judgment Parameters</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.JudgmentParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Judgment Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Judgment Parameters</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getJudgmentDescription_JudgmentParameters()
   * @model containment="true"
   * @generated
   */
  EList<JudgmentParameter> getJudgmentParameters();

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
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getJudgmentDescription_RelationSymbols()
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
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getJudgmentDescription_Error()
   * @model containment="true"
   * @generated
   */
  ErrorSpecification getError();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getError <em>Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error</em>' containment reference.
   * @see #getError()
   * @generated
   */
  void setError(ErrorSpecification value);

} // JudgmentDescription
