/**
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.ErrorSpecification#getError <em>Error</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.ErrorSpecification#getSource <em>Source</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.ErrorSpecification#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getErrorSpecification()
 * @model
 * @generated
 */
public interface ErrorSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error</em>' containment reference.
   * @see #setError(XExpression)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getErrorSpecification_Error()
   * @model containment="true"
   * @generated
   */
  XExpression getError();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.ErrorSpecification#getError <em>Error</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error</em>' containment reference.
   * @see #getError()
   * @generated
   */
  void setError(XExpression value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference.
   * @see #setSource(XExpression)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getErrorSpecification_Source()
   * @model containment="true"
   * @generated
   */
  XExpression getSource();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.ErrorSpecification#getSource <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' containment reference.
   * @see #getSource()
   * @generated
   */
  void setSource(XExpression value);

  /**
   * Returns the value of the '<em><b>Feature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' containment reference.
   * @see #setFeature(XExpression)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getErrorSpecification_Feature()
   * @model containment="true"
   * @generated
   */
  XExpression getFeature();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.ErrorSpecification#getFeature <em>Feature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' containment reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(XExpression value);

} // ErrorSpecification
