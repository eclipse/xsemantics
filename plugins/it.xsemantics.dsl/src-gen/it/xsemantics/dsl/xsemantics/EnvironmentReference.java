/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.EnvironmentReference#getEnvironment <em>Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentReference()
 * @model
 * @generated
 */
public interface EnvironmentReference extends EnvironmentSpecification
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
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentReference_Environment()
   * @model
   * @generated
   */
  Environment getEnvironment();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.EnvironmentReference#getEnvironment <em>Environment</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Environment</em>' reference.
   * @see #getEnvironment()
   * @generated
   */
  void setEnvironment(Environment value);

} // EnvironmentReference
