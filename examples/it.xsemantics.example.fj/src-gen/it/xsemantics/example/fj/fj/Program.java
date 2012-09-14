/**
 */
package it.xsemantics.example.fj.fj;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.fj.fj.Program#getClasses <em>Classes</em>}</li>
 *   <li>{@link it.xsemantics.example.fj.fj.Program#getMain <em>Main</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.fj.fj.FjPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject
{
  /**
   * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.example.fj.fj.Class}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classes</em>' containment reference list.
   * @see it.xsemantics.example.fj.fj.FjPackage#getProgram_Classes()
   * @model containment="true"
   * @generated
   */
  EList<it.xsemantics.example.fj.fj.Class> getClasses();

  /**
   * Returns the value of the '<em><b>Main</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Main</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Main</em>' containment reference.
   * @see #setMain(Expression)
   * @see it.xsemantics.example.fj.fj.FjPackage#getProgram_Main()
   * @model containment="true"
   * @generated
   */
  Expression getMain();

  /**
   * Sets the value of the '{@link it.xsemantics.example.fj.fj.Program#getMain <em>Main</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Main</em>' containment reference.
   * @see #getMain()
   * @generated
   */
  void setMain(Expression value);

} // Program
