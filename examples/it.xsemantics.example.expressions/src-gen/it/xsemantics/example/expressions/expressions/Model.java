/**
 */
package it.xsemantics.example.expressions.expressions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.example.expressions.expressions.Model#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.example.expressions.expressions.ExpressionsPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.example.expressions.expressions.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see it.xsemantics.example.expressions.expressions.ExpressionsPackage#getModel_Variables()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getVariables();

} // Model
