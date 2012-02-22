/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.fj.fj;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.fj.fj.New#getType <em>Type</em>}</li>
 *   <li>{@link it.xsemantics.example.fj.fj.New#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.fj.fj.FjPackage#getNew()
 * @model
 * @generated
 */
public interface New extends Expression
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(ClassType)
   * @see it.xsemantics.example.fj.fj.FjPackage#getNew_Type()
   * @model containment="true"
   * @generated
   */
  ClassType getType();

  /**
   * Sets the value of the '{@link it.xsemantics.example.fj.fj.New#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(ClassType value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.example.fj.fj.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see it.xsemantics.example.fj.fj.FjPackage#getNew_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // New
