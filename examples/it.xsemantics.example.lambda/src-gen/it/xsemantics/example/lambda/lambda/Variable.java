/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.lambda.lambda;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.lambda.lambda.Variable#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Term
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Parameter)
   * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getVariable_Ref()
   * @model
   * @generated
   */
  Parameter getRef();

  /**
   * Sets the value of the '{@link it.xsemantics.example.lambda.lambda.Variable#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Parameter value);

} // Variable
