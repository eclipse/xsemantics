/**
 */
package it.xsemantics.example.lambda.lambda;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstraction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.lambda.lambda.Abstraction#getParam <em>Param</em>}</li>
 *   <li>{@link it.xsemantics.example.lambda.lambda.Abstraction#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getAbstraction()
 * @model
 * @generated
 */
public interface Abstraction extends Term
{
  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference.
   * @see #setParam(Parameter)
   * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getAbstraction_Param()
   * @model containment="true"
   * @generated
   */
  Parameter getParam();

  /**
   * Sets the value of the '{@link it.xsemantics.example.lambda.lambda.Abstraction#getParam <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' containment reference.
   * @see #getParam()
   * @generated
   */
  void setParam(Parameter value);

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
   * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getAbstraction_Term()
   * @model containment="true"
   * @generated
   */
  Term getTerm();

  /**
   * Sets the value of the '{@link it.xsemantics.example.lambda.lambda.Abstraction#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
  void setTerm(Term value);

} // Abstraction
