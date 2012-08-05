/**
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess#getArgument <em>Argument</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentAccess()
 * @model
 * @generated
 */
public interface EnvironmentAccess extends XExpression
{
  /**
   * Returns the value of the '<em><b>Environment</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Environment</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Environment</em>' reference.
   * @see #setEnvironment(Environment)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentAccess_Environment()
   * @model
   * @generated
   */
  Environment getEnvironment();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess#getEnvironment <em>Environment</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Environment</em>' reference.
   * @see #getEnvironment()
   * @generated
   */
  void setEnvironment(Environment value);

  /**
   * Returns the value of the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Argument</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Argument</em>' containment reference.
   * @see #setArgument(XExpression)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentAccess_Argument()
   * @model containment="true"
   * @generated
   */
  XExpression getArgument();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess#getArgument <em>Argument</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument</em>' containment reference.
   * @see #getArgument()
   * @generated
   */
  void setArgument(XExpression value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(JvmTypeReference)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentAccess_Type()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getType();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmTypeReference value);

} // EnvironmentAccess
