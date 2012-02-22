/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.CheckRule#getName <em>Name</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.CheckRule#getElement <em>Element</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.CheckRule#getPremises <em>Premises</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getCheckRule()
 * @model
 * @generated
 */
public interface CheckRule extends EObject
{
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
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getCheckRule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.CheckRule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(RuleParameter)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getCheckRule_Element()
   * @model containment="true"
   * @generated
   */
  RuleParameter getElement();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.CheckRule#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(RuleParameter value);

  /**
   * Returns the value of the '<em><b>Premises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Premises</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Premises</em>' containment reference.
   * @see #setPremises(XExpression)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getCheckRule_Premises()
   * @model containment="true"
   * @generated
   */
  XExpression getPremises();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.CheckRule#getPremises <em>Premises</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Premises</em>' containment reference.
   * @see #getPremises()
   * @generated
   */
  void setPremises(XExpression value);

} // CheckRule
