/**
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getName <em>Name</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getSuperSystem <em>Super System</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getValidatorExtends <em>Validator Extends</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getImports <em>Imports</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getInjections <em>Injections</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getAuxiliaryDescriptions <em>Auxiliary Descriptions</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getJudgmentDescriptions <em>Judgment Descriptions</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getAuxiliaryFunctions <em>Auxiliary Functions</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getRules <em>Rules</em>}</li>
 *   <li>{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getCheckrules <em>Checkrules</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem()
 * @model
 * @generated
 */
public interface XsemanticsSystem extends EObject
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
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Super System</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super System</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super System</em>' containment reference.
   * @see #setSuperSystem(JvmParameterizedTypeReference)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_SuperSystem()
   * @model containment="true"
   * @generated
   */
  JvmParameterizedTypeReference getSuperSystem();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getSuperSystem <em>Super System</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super System</em>' containment reference.
   * @see #getSuperSystem()
   * @generated
   */
  void setSuperSystem(JvmParameterizedTypeReference value);

  /**
   * Returns the value of the '<em><b>Validator Extends</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Validator Extends</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Validator Extends</em>' containment reference.
   * @see #setValidatorExtends(JvmParameterizedTypeReference)
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_ValidatorExtends()
   * @model containment="true"
   * @generated
   */
  JvmParameterizedTypeReference getValidatorExtends();

  /**
   * Sets the value of the '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getValidatorExtends <em>Validator Extends</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Validator Extends</em>' containment reference.
   * @see #getValidatorExtends()
   * @generated
   */
  void setValidatorExtends(JvmParameterizedTypeReference value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Injections</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.Injected}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Injections</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Injections</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_Injections()
   * @model containment="true"
   * @generated
   */
  EList<Injected> getInjections();

  /**
   * Returns the value of the '<em><b>Auxiliary Descriptions</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.AuxiliaryDescription}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Auxiliary Descriptions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Auxiliary Descriptions</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_AuxiliaryDescriptions()
   * @model containment="true"
   * @generated
   */
  EList<AuxiliaryDescription> getAuxiliaryDescriptions();

  /**
   * Returns the value of the '<em><b>Judgment Descriptions</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.JudgmentDescription}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Judgment Descriptions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Judgment Descriptions</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_JudgmentDescriptions()
   * @model containment="true"
   * @generated
   */
  EList<JudgmentDescription> getJudgmentDescriptions();

  /**
   * Returns the value of the '<em><b>Auxiliary Functions</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.AuxiliaryFunction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Auxiliary Functions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Auxiliary Functions</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_AuxiliaryFunctions()
   * @model containment="true"
   * @generated
   */
  EList<AuxiliaryFunction> getAuxiliaryFunctions();

  /**
   * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.Rule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rules</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_Rules()
   * @model containment="true"
   * @generated
   */
  EList<Rule> getRules();

  /**
   * Returns the value of the '<em><b>Checkrules</b></em>' containment reference list.
   * The list contents are of type {@link it.xsemantics.dsl.xsemantics.CheckRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Checkrules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Checkrules</em>' containment reference list.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#getXsemanticsSystem_Checkrules()
   * @model containment="true"
   * @generated
   */
  EList<CheckRule> getCheckrules();

} // XsemanticsSystem
