/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.xtext.common.types.JvmFormalParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.InputParameter#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getInputParameter()
 * @model
 * @generated
 */
public interface InputParameter extends JudgmentParameter
{
  /**
   * Returns the value of the '<em><b>Parameter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' containment reference.
   * @see #setParameter(JvmFormalParameter)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getInputParameter_Parameter()
   * @model containment="true"
   * @generated
   */
  JvmFormalParameter getParameter();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.InputParameter#getParameter <em>Parameter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' containment reference.
   * @see #getParameter()
   * @generated
   */
  void setParameter(JvmFormalParameter value);

} // InputParameter
