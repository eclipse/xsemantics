/**
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage
 * @generated
 */
public interface XsemanticsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XsemanticsFactory eINSTANCE = it.xsemantics.dsl.xsemantics.impl.XsemanticsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>System</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>System</em>'.
   * @generated
   */
  XsemanticsSystem createXsemanticsSystem();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Injected</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Injected</em>'.
   * @generated
   */
  Injected createInjected();

  /**
   * Returns a new object of class '<em>Judgment Description</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Judgment Description</em>'.
   * @generated
   */
  JudgmentDescription createJudgmentDescription();

  /**
   * Returns a new object of class '<em>Judgment Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Judgment Parameter</em>'.
   * @generated
   */
  JudgmentParameter createJudgmentParameter();

  /**
   * Returns a new object of class '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule</em>'.
   * @generated
   */
  Rule createRule();

  /**
   * Returns a new object of class '<em>Axiom</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Axiom</em>'.
   * @generated
   */
  Axiom createAxiom();

  /**
   * Returns a new object of class '<em>Rule With Premises</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule With Premises</em>'.
   * @generated
   */
  RuleWithPremises createRuleWithPremises();

  /**
   * Returns a new object of class '<em>Check Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Check Rule</em>'.
   * @generated
   */
  CheckRule createCheckRule();

  /**
   * Returns a new object of class '<em>Rule Conclusion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Conclusion</em>'.
   * @generated
   */
  RuleConclusion createRuleConclusion();

  /**
   * Returns a new object of class '<em>Rule Invocation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Invocation</em>'.
   * @generated
   */
  RuleInvocation createRuleInvocation();

  /**
   * Returns a new object of class '<em>Rule Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Invocation Expression</em>'.
   * @generated
   */
  RuleInvocationExpression createRuleInvocationExpression();

  /**
   * Returns a new object of class '<em>Environment Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Environment Specification</em>'.
   * @generated
   */
  EnvironmentSpecification createEnvironmentSpecification();

  /**
   * Returns a new object of class '<em>Environment Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Environment Reference</em>'.
   * @generated
   */
  EnvironmentReference createEnvironmentReference();

  /**
   * Returns a new object of class '<em>Environment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Environment</em>'.
   * @generated
   */
  Environment createEnvironment();

  /**
   * Returns a new object of class '<em>Error Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Specification</em>'.
   * @generated
   */
  ErrorSpecification createErrorSpecification();

  /**
   * Returns a new object of class '<em>Rule Conclusion Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Conclusion Element</em>'.
   * @generated
   */
  RuleConclusionElement createRuleConclusionElement();

  /**
   * Returns a new object of class '<em>Rule Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Parameter</em>'.
   * @generated
   */
  RuleParameter createRuleParameter();

  /**
   * Returns a new object of class '<em>Expression In Conclusion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression In Conclusion</em>'.
   * @generated
   */
  ExpressionInConclusion createExpressionInConclusion();

  /**
   * Returns a new object of class '<em>Output Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output Parameter</em>'.
   * @generated
   */
  OutputParameter createOutputParameter();

  /**
   * Returns a new object of class '<em>Input Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Parameter</em>'.
   * @generated
   */
  InputParameter createInputParameter();

  /**
   * Returns a new object of class '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expression</em>'.
   * @generated
   */
  OrExpression createOrExpression();

  /**
   * Returns a new object of class '<em>Fail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fail</em>'.
   * @generated
   */
  Fail createFail();

  /**
   * Returns a new object of class '<em>Environment Access</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Environment Access</em>'.
   * @generated
   */
  EnvironmentAccess createEnvironmentAccess();

  /**
   * Returns a new object of class '<em>Environment Composition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Environment Composition</em>'.
   * @generated
   */
  EnvironmentComposition createEnvironmentComposition();

  /**
   * Returns a new object of class '<em>Empty Environment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Empty Environment</em>'.
   * @generated
   */
  EmptyEnvironment createEmptyEnvironment();

  /**
   * Returns a new object of class '<em>Environment Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Environment Mapping</em>'.
   * @generated
   */
  EnvironmentMapping createEnvironmentMapping();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  XsemanticsPackage getXsemanticsPackage();

} //XsemanticsFactory
