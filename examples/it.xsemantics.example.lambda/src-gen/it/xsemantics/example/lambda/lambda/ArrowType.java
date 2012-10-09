/**
 */
package it.xsemantics.example.lambda.lambda;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrow Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.lambda.lambda.ArrowType#getLeft <em>Left</em>}</li>
 *   <li>{@link it.xsemantics.example.lambda.lambda.ArrowType#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getArrowType()
 * @model
 * @generated
 */
public interface ArrowType extends Type
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Type)
   * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getArrowType_Left()
   * @model containment="true"
   * @generated
   */
  Type getLeft();

  /**
   * Sets the value of the '{@link it.xsemantics.example.lambda.lambda.ArrowType#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Type value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Type)
   * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getArrowType_Right()
   * @model containment="true"
   * @generated
   */
  Type getRight();

  /**
   * Sets the value of the '{@link it.xsemantics.example.lambda.lambda.ArrowType#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Type value);

} // ArrowType
