/**
 */
package it.xsemantics.example.lambda.lambda;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.lambda.lambda.TypeVariable#getTypevarName <em>Typevar Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getTypeVariable()
 * @model
 * @generated
 */
public interface TypeVariable extends Type
{
  /**
   * Returns the value of the '<em><b>Typevar Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Typevar Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Typevar Name</em>' attribute.
   * @see #setTypevarName(String)
   * @see it.xsemantics.example.lambda.lambda.LambdaPackage#getTypeVariable_TypevarName()
   * @model
   * @generated
   */
  String getTypevarName();

  /**
   * Sets the value of the '{@link it.xsemantics.example.lambda.lambda.TypeVariable#getTypevarName <em>Typevar Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Typevar Name</em>' attribute.
   * @see #getTypevarName()
   * @generated
   */
  void setTypevarName(String value);

} // TypeVariable
