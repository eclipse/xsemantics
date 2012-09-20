/**
 */
package it.xsemantics.dsl.xsemantics.util;

import it.xsemantics.dsl.xsemantics.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage
 * @generated
 */
public class XsemanticsSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XsemanticsPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XsemanticsSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = XsemanticsPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case XsemanticsPackage.XSEMANTICS_SYSTEM:
      {
        XsemanticsSystem xsemanticsSystem = (XsemanticsSystem)theEObject;
        T result = caseXsemanticsSystem(xsemanticsSystem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.INJECTED:
      {
        Injected injected = (Injected)theEObject;
        T result = caseInjected(injected);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.AUXILIARY_DESCRIPTION:
      {
        AuxiliaryDescription auxiliaryDescription = (AuxiliaryDescription)theEObject;
        T result = caseAuxiliaryDescription(auxiliaryDescription);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.JUDGMENT_DESCRIPTION:
      {
        JudgmentDescription judgmentDescription = (JudgmentDescription)theEObject;
        T result = caseJudgmentDescription(judgmentDescription);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.JUDGMENT_PARAMETER:
      {
        JudgmentParameter judgmentParameter = (JudgmentParameter)theEObject;
        T result = caseJudgmentParameter(judgmentParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.RULE:
      {
        Rule rule = (Rule)theEObject;
        T result = caseRule(rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.AXIOM:
      {
        Axiom axiom = (Axiom)theEObject;
        T result = caseAxiom(axiom);
        if (result == null) result = caseRule(axiom);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.RULE_WITH_PREMISES:
      {
        RuleWithPremises ruleWithPremises = (RuleWithPremises)theEObject;
        T result = caseRuleWithPremises(ruleWithPremises);
        if (result == null) result = caseRule(ruleWithPremises);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.CHECK_RULE:
      {
        CheckRule checkRule = (CheckRule)theEObject;
        T result = caseCheckRule(checkRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.RULE_CONCLUSION:
      {
        RuleConclusion ruleConclusion = (RuleConclusion)theEObject;
        T result = caseRuleConclusion(ruleConclusion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.RULE_INVOCATION:
      {
        RuleInvocation ruleInvocation = (RuleInvocation)theEObject;
        T result = caseRuleInvocation(ruleInvocation);
        if (result == null) result = caseXExpression(ruleInvocation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.RULE_INVOCATION_EXPRESSION:
      {
        RuleInvocationExpression ruleInvocationExpression = (RuleInvocationExpression)theEObject;
        T result = caseRuleInvocationExpression(ruleInvocationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.ENVIRONMENT_SPECIFICATION:
      {
        EnvironmentSpecification environmentSpecification = (EnvironmentSpecification)theEObject;
        T result = caseEnvironmentSpecification(environmentSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.ENVIRONMENT_REFERENCE:
      {
        EnvironmentReference environmentReference = (EnvironmentReference)theEObject;
        T result = caseEnvironmentReference(environmentReference);
        if (result == null) result = caseEnvironmentSpecification(environmentReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.ENVIRONMENT:
      {
        Environment environment = (Environment)theEObject;
        T result = caseEnvironment(environment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.ERROR_SPECIFICATION:
      {
        ErrorSpecification errorSpecification = (ErrorSpecification)theEObject;
        T result = caseErrorSpecification(errorSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.RULE_CONCLUSION_ELEMENT:
      {
        RuleConclusionElement ruleConclusionElement = (RuleConclusionElement)theEObject;
        T result = caseRuleConclusionElement(ruleConclusionElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.RULE_PARAMETER:
      {
        RuleParameter ruleParameter = (RuleParameter)theEObject;
        T result = caseRuleParameter(ruleParameter);
        if (result == null) result = caseRuleConclusionElement(ruleParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.EXPRESSION_IN_CONCLUSION:
      {
        ExpressionInConclusion expressionInConclusion = (ExpressionInConclusion)theEObject;
        T result = caseExpressionInConclusion(expressionInConclusion);
        if (result == null) result = caseRuleConclusionElement(expressionInConclusion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.OUTPUT_PARAMETER:
      {
        OutputParameter outputParameter = (OutputParameter)theEObject;
        T result = caseOutputParameter(outputParameter);
        if (result == null) result = caseJudgmentParameter(outputParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.INPUT_PARAMETER:
      {
        InputParameter inputParameter = (InputParameter)theEObject;
        T result = caseInputParameter(inputParameter);
        if (result == null) result = caseJudgmentParameter(inputParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.OR_EXPRESSION:
      {
        OrExpression orExpression = (OrExpression)theEObject;
        T result = caseOrExpression(orExpression);
        if (result == null) result = caseXExpression(orExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.FAIL:
      {
        Fail fail = (Fail)theEObject;
        T result = caseFail(fail);
        if (result == null) result = caseXExpression(fail);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.ENVIRONMENT_ACCESS:
      {
        EnvironmentAccess environmentAccess = (EnvironmentAccess)theEObject;
        T result = caseEnvironmentAccess(environmentAccess);
        if (result == null) result = caseXExpression(environmentAccess);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION:
      {
        EnvironmentComposition environmentComposition = (EnvironmentComposition)theEObject;
        T result = caseEnvironmentComposition(environmentComposition);
        if (result == null) result = caseEnvironmentSpecification(environmentComposition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.EMPTY_ENVIRONMENT:
      {
        EmptyEnvironment emptyEnvironment = (EmptyEnvironment)theEObject;
        T result = caseEmptyEnvironment(emptyEnvironment);
        if (result == null) result = caseEnvironmentSpecification(emptyEnvironment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XsemanticsPackage.ENVIRONMENT_MAPPING:
      {
        EnvironmentMapping environmentMapping = (EnvironmentMapping)theEObject;
        T result = caseEnvironmentMapping(environmentMapping);
        if (result == null) result = caseEnvironmentSpecification(environmentMapping);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>System</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>System</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXsemanticsSystem(XsemanticsSystem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Injected</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Injected</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInjected(Injected object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Auxiliary Description</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Auxiliary Description</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAuxiliaryDescription(AuxiliaryDescription object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Judgment Description</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Judgment Description</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJudgmentDescription(JudgmentDescription object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Judgment Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Judgment Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJudgmentParameter(JudgmentParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule(Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Axiom</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Axiom</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAxiom(Axiom object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule With Premises</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule With Premises</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleWithPremises(RuleWithPremises object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Check Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Check Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCheckRule(CheckRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Conclusion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Conclusion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleConclusion(RuleConclusion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleInvocation(RuleInvocation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Invocation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleInvocationExpression(RuleInvocationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Environment Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Environment Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnvironmentSpecification(EnvironmentSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Environment Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Environment Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnvironmentReference(EnvironmentReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Environment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Environment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnvironment(Environment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorSpecification(ErrorSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Conclusion Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Conclusion Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleConclusionElement(RuleConclusionElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleParameter(RuleParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression In Conclusion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression In Conclusion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionInConclusion(ExpressionInConclusion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Output Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Output Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutputParameter(OutputParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInputParameter(InputParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrExpression(OrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fail</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fail</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFail(Fail object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Environment Access</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Environment Access</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnvironmentAccess(EnvironmentAccess object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Environment Composition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Environment Composition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnvironmentComposition(EnvironmentComposition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Empty Environment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Empty Environment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmptyEnvironment(EmptyEnvironment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Environment Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Environment Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnvironmentMapping(EnvironmentMapping object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XExpression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XExpression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXExpression(XExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //XsemanticsSwitch
