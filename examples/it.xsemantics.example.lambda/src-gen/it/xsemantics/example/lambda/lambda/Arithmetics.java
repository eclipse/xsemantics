/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.lambda.lambda;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arithmetics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.lambda.lambda.Arithmetics#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getArithmetics()
 * @model
 * @generated
 */
public interface Arithmetics extends Term
{
  /**
   * Returns the value of the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Term</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Term</em>' containment reference.
   * @see #setTerm(Term)
   * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getArithmetics_Term()
   * @model containment="true"
   * @generated
   */
  Term getTerm();

  /**
   * Sets the value of the '{@link it.xsemantics.example.lambda.lambda.Arithmetics#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
  void setTerm(Term value);

} // Arithmetics
