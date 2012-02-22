/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.expressions.expressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.expressions.expressions.Variable#getName <em>Name</em>}</li>
 *   <li>{@link it.xsemantics.example.expressions.expressions.Variable#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.expressions.expressions.ExpressionsPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends EObject
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
   * @see it.xsemantics.example.expressions.expressions.ExpressionsPackage#getVariable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link it.xsemantics.example.expressions.expressions.Variable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see it.xsemantics.example.expressions.expressions.ExpressionsPackage#getVariable_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link it.xsemantics.example.expressions.expressions.Variable#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // Variable
