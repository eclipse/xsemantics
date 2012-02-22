/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.fj.fj;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.fj.fj.Method#getParams <em>Params</em>}</li>
 *   <li>{@link it.xsemantics.example.fj.fj.Method#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.fj.fj.FjPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Member
{
  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.example.fj.fj.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see it.xsemantics.example.fj.fj.FjPackage#getMethod_Params()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParams();

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(MethodBody)
   * @see it.xsemantics.example.fj.fj.FjPackage#getMethod_Body()
   * @model containment="true"
   * @generated
   */
  MethodBody getBody();

  /**
   * Sets the value of the '{@link it.xsemantics.example.fj.fj.Method#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(MethodBody value);

} // Method
