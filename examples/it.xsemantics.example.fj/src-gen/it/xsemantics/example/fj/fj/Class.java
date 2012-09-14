/**
 */
package it.xsemantics.example.fj.fj;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.fj.fj.Class#getName <em>Name</em>}</li>
 *   <li>{@link it.xsemantics.example.fj.fj.Class#getSuperclass <em>Superclass</em>}</li>
 *   <li>{@link it.xsemantics.example.fj.fj.Class#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.fj.fj.FjPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see it.xsemantics.example.fj.fj.FjPackage#getClass_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link it.xsemantics.example.fj.fj.Class#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Superclass</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Superclass</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Superclass</em>' reference.
   * @see #setSuperclass(Class)
   * @see it.xsemantics.example.fj.fj.FjPackage#getClass_Superclass()
   * @model
   * @generated
   */
  Class getSuperclass();

  /**
   * Sets the value of the '{@link it.xsemantics.example.fj.fj.Class#getSuperclass <em>Superclass</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Superclass</em>' reference.
   * @see #getSuperclass()
   * @generated
   */
  void setSuperclass(Class value);

  /**
   * Returns the value of the '<em><b>Members</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.example.fj.fj.Member}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Members</em>' containment reference list.
   * @see it.xsemantics.example.fj.fj.FjPackage#getClass_Members()
   * @model containment="true"
   * @generated
   */
  EList<Member> getMembers();

} // Class
