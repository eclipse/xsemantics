/**
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule With Premises</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.RuleWithPremises#getPremises <em>Premises</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleWithPremises()
 * @model
 * @generated
 */
public interface RuleWithPremises extends Rule
{
  /**
   * Returns the value of the '<em><b>Premises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Premises</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Premises</em>' containment reference.
   * @see #setPremises(XExpression)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getRuleWithPremises_Premises()
   * @model containment="true"
   * @generated
   */
  XExpression getPremises();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.RuleWithPremises#getPremises <em>Premises</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Premises</em>' containment reference.
   * @see #getPremises()
   * @generated
   */
  void setPremises(XExpression value);

} // RuleWithPremises
