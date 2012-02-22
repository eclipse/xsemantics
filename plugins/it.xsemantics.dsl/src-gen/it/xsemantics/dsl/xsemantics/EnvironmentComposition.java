/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment Composition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.EnvironmentComposition#getCurrentEnvironment <em>Current Environment</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.EnvironmentComposition#getSubEnvironment <em>Sub Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentComposition()
 * @model
 * @generated
 */
public interface EnvironmentComposition extends EnvironmentSpecification
{
  /**
   * Returns the value of the '<em><b>Current Environment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Current Environment</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Current Environment</em>' containment reference.
   * @see #setCurrentEnvironment(EnvironmentSpecification)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentComposition_CurrentEnvironment()
   * @model containment="true"
   * @generated
   */
  EnvironmentSpecification getCurrentEnvironment();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.EnvironmentComposition#getCurrentEnvironment <em>Current Environment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Current Environment</em>' containment reference.
   * @see #getCurrentEnvironment()
   * @generated
   */
  void setCurrentEnvironment(EnvironmentSpecification value);

  /**
   * Returns the value of the '<em><b>Sub Environment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Environment</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Environment</em>' containment reference.
   * @see #setSubEnvironment(EnvironmentSpecification)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getEnvironmentComposition_SubEnvironment()
   * @model containment="true"
   * @generated
   */
  EnvironmentSpecification getSubEnvironment();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.EnvironmentComposition#getSubEnvironment <em>Sub Environment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Environment</em>' containment reference.
   * @see #getSubEnvironment()
   * @generated
   */
  void setSubEnvironment(EnvironmentSpecification value);

} // EnvironmentComposition
