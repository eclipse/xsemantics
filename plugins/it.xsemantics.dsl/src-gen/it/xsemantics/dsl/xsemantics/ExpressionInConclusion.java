/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression In Conclusion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.ExpressionInConclusion#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getExpressionInConclusion()
 * @model
 * @generated
 */
public interface ExpressionInConclusion extends RuleConclusionElement
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(XExpression)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getExpressionInConclusion_Expression()
   * @model containment="true"
   * @generated
   */
  XExpression getExpression();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.ExpressionInConclusion#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(XExpression value);

} // ExpressionInConclusion
