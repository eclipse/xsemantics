/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.OutputParameter#getJvmTypeReference <em>Jvm Type Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getOutputParameter()
 * @model
 * @generated
 */
public interface OutputParameter extends JudgmentParameter
{
  /**
   * Returns the value of the '<em><b>Jvm Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jvm Type Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jvm Type Reference</em>' containment reference.
   * @see #setJvmTypeReference(JvmTypeReference)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getOutputParameter_JvmTypeReference()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getJvmTypeReference();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.OutputParameter#getJvmTypeReference <em>Jvm Type Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Jvm Type Reference</em>' containment reference.
   * @see #getJvmTypeReference()
   * @generated
   */
  void setJvmTypeReference(JvmTypeReference value);

} // OutputParameter
