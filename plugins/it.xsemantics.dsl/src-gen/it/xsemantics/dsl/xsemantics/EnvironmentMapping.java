/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.EnvironmentMapping#getKey <em>Key</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.EnvironmentMapping#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentMapping()
 * @model
 * @generated
 */
public interface EnvironmentMapping extends EnvironmentSpecification
{
  /**
   * Returns the value of the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' containment reference.
   * @see #setKey(XExpression)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentMapping_Key()
   * @model containment="true"
   * @generated
   */
  XExpression getKey();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.EnvironmentMapping#getKey <em>Key</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' containment reference.
   * @see #getKey()
   * @generated
   */
  void setKey(XExpression value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(XExpression)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentMapping_Value()
   * @model containment="true"
   * @generated
   */
  XExpression getValue();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.EnvironmentMapping#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(XExpression value);

} // EnvironmentMapping
