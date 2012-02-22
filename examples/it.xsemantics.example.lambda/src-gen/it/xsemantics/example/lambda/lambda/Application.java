/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.lambda.lambda;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.lambda.lambda.Application#getFun <em>Fun</em>}</li>
 *   <li>{@link it.xsemantics.example.lambda.lambda.Application#getArg <em>Arg</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends Term
{
  /**
   * Returns the value of the '<em><b>Fun</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fun</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fun</em>' containment reference.
   * @see #setFun(Term)
   * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getApplication_Fun()
   * @model containment="true"
   * @generated
   */
  Term getFun();

  /**
   * Sets the value of the '{@link it.xsemantics.example.lambda.lambda.Application#getFun <em>Fun</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fun</em>' containment reference.
   * @see #getFun()
   * @generated
   */
  void setFun(Term value);

  /**
   * Returns the value of the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg</em>' containment reference.
   * @see #setArg(Term)
   * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getApplication_Arg()
   * @model containment="true"
   * @generated
   */
  Term getArg();

  /**
   * Sets the value of the '{@link it.xsemantics.example.lambda.lambda.Application#getArg <em>Arg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg</em>' containment reference.
   * @see #getArg()
   * @generated
   */
  void setArg(Term value);

} // Application
