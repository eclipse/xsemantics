/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.OrExpression#getBranches <em>Branches</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getOrExpression()
 * @model
 * @generated
 */
public interface OrExpression extends XExpression
{
  /**
   * Returns the value of the '<em><b>Branches</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Branches</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Branches</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getOrExpression_Branches()
   * @model containment="true"
   * @generated
   */
  EList<XExpression> getBranches();

} // OrExpression
