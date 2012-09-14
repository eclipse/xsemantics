/**
 */
package it.xsemantics.example.fj.fj;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.fj.fj.Selection#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link it.xsemantics.example.fj.fj.Selection#getMessage <em>Message</em>}</li>
 *   <li>{@link it.xsemantics.example.fj.fj.Selection#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.fj.fj.FjPackage#getSelection()
 * @model
 * @generated
 */
public interface Selection extends Expression
{
  /**
   * Returns the value of the '<em><b>Receiver</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Receiver</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Receiver</em>' containment reference.
   * @see #setReceiver(Expression)
   * @see it.xsemantics.example.fj.fj.FjPackage#getSelection_Receiver()
   * @model containment="true"
   * @generated
   */
  Expression getReceiver();

  /**
   * Sets the value of the '{@link it.xsemantics.example.fj.fj.Selection#getReceiver <em>Receiver</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Receiver</em>' containment reference.
   * @see #getReceiver()
   * @generated
   */
  void setReceiver(Expression value);

  /**
   * Returns the value of the '<em><b>Message</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' reference.
   * @see #setMessage(Member)
   * @see it.xsemantics.example.fj.fj.FjPackage#getSelection_Message()
   * @model
   * @generated
   */
  Member getMessage();

  /**
   * Sets the value of the '{@link it.xsemantics.example.fj.fj.Selection#getMessage <em>Message</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' reference.
   * @see #getMessage()
   * @generated
   */
  void setMessage(Member value);

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
   * @see it.xsemantics.example.fj.fj.FjPackage#getSelection_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // Selection
