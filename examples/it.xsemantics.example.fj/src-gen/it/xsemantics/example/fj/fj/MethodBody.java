/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.fj.fj;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.fj.fj.MethodBody#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.fj.fj.FjPackage#getMethodBody()
 * @model
 * @generated
 */
public interface MethodBody extends EObject
{
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
   * @see it.xsemantics.example.fj.fj.FjPackage#getMethodBody_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link it.xsemantics.example.fj.fj.MethodBody#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // MethodBody
