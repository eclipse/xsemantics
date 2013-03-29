/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XsemanticsFactoryImpl extends EFactoryImpl implements XsemanticsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XsemanticsFactory init()
  {
    try
    {
      XsemanticsFactory theXsemanticsFactory = (XsemanticsFactory)EPackage.Registry.INSTANCE.getEFactory("http://xsemantics.sf.net/Xsemantics"); 
      if (theXsemanticsFactory != null)
      {
        return theXsemanticsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XsemanticsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XsemanticsFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case XsemanticsPackage.XSEMANTICS_SYSTEM: return createXsemanticsSystem();
      case XsemanticsPackage.INJECTED: return createInjected();
      case XsemanticsPackage.AUXILIARY_DESCRIPTION: return createAuxiliaryDescription();
      case XsemanticsPackage.JUDGMENT_DESCRIPTION: return createJudgmentDescription();
      case XsemanticsPackage.JUDGMENT_PARAMETER: return createJudgmentParameter();
      case XsemanticsPackage.AUXILIARY_FUNCTION: return createAuxiliaryFunction();
      case XsemanticsPackage.RULE: return createRule();
      case XsemanticsPackage.AXIOM: return createAxiom();
      case XsemanticsPackage.RULE_WITH_PREMISES: return createRuleWithPremises();
      case XsemanticsPackage.CHECK_RULE: return createCheckRule();
      case XsemanticsPackage.RULE_CONCLUSION: return createRuleConclusion();
      case XsemanticsPackage.RULE_INVOCATION: return createRuleInvocation();
      case XsemanticsPackage.RULE_INVOCATION_EXPRESSION: return createRuleInvocationExpression();
      case XsemanticsPackage.ENVIRONMENT_SPECIFICATION: return createEnvironmentSpecification();
      case XsemanticsPackage.ENVIRONMENT_REFERENCE: return createEnvironmentReference();
      case XsemanticsPackage.ENVIRONMENT: return createEnvironment();
      case XsemanticsPackage.ERROR_SPECIFICATION: return createErrorSpecification();
      case XsemanticsPackage.RULE_CONCLUSION_ELEMENT: return createRuleConclusionElement();
      case XsemanticsPackage.RULE_PARAMETER: return createRuleParameter();
      case XsemanticsPackage.EXPRESSION_IN_CONCLUSION: return createExpressionInConclusion();
      case XsemanticsPackage.OUTPUT_PARAMETER: return createOutputParameter();
      case XsemanticsPackage.INPUT_PARAMETER: return createInputParameter();
      case XsemanticsPackage.OR_EXPRESSION: return createOrExpression();
      case XsemanticsPackage.FAIL: return createFail();
      case XsemanticsPackage.ENVIRONMENT_ACCESS: return createEnvironmentAccess();
      case XsemanticsPackage.ENVIRONMENT_COMPOSITION: return createEnvironmentComposition();
      case XsemanticsPackage.EMPTY_ENVIRONMENT: return createEmptyEnvironment();
      case XsemanticsPackage.ENVIRONMENT_MAPPING: return createEnvironmentMapping();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XsemanticsSystem createXsemanticsSystem()
  {
    XsemanticsSystemImpl xsemanticsSystem = new XsemanticsSystemImpl();
    return xsemanticsSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Injected createInjected()
  {
    InjectedImpl injected = new InjectedImpl();
    return injected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AuxiliaryDescription createAuxiliaryDescription()
  {
    AuxiliaryDescriptionImpl auxiliaryDescription = new AuxiliaryDescriptionImpl();
    return auxiliaryDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JudgmentDescription createJudgmentDescription()
  {
    JudgmentDescriptionImpl judgmentDescription = new JudgmentDescriptionImpl();
    return judgmentDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JudgmentParameter createJudgmentParameter()
  {
    JudgmentParameterImpl judgmentParameter = new JudgmentParameterImpl();
    return judgmentParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AuxiliaryFunction createAuxiliaryFunction()
  {
    AuxiliaryFunctionImpl auxiliaryFunction = new AuxiliaryFunctionImpl();
    return auxiliaryFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule createRule()
  {
    RuleImpl rule = new RuleImpl();
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Axiom createAxiom()
  {
    AxiomImpl axiom = new AxiomImpl();
    return axiom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleWithPremises createRuleWithPremises()
  {
    RuleWithPremisesImpl ruleWithPremises = new RuleWithPremisesImpl();
    return ruleWithPremises;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CheckRule createCheckRule()
  {
    CheckRuleImpl checkRule = new CheckRuleImpl();
    return checkRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleConclusion createRuleConclusion()
  {
    RuleConclusionImpl ruleConclusion = new RuleConclusionImpl();
    return ruleConclusion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleInvocation createRuleInvocation()
  {
    RuleInvocationImpl ruleInvocation = new RuleInvocationImpl();
    return ruleInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleInvocationExpression createRuleInvocationExpression()
  {
    RuleInvocationExpressionImpl ruleInvocationExpression = new RuleInvocationExpressionImpl();
    return ruleInvocationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnvironmentSpecification createEnvironmentSpecification()
  {
    EnvironmentSpecificationImpl environmentSpecification = new EnvironmentSpecificationImpl();
    return environmentSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnvironmentReference createEnvironmentReference()
  {
    EnvironmentReferenceImpl environmentReference = new EnvironmentReferenceImpl();
    return environmentReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Environment createEnvironment()
  {
    EnvironmentImpl environment = new EnvironmentImpl();
    return environment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorSpecification createErrorSpecification()
  {
    ErrorSpecificationImpl errorSpecification = new ErrorSpecificationImpl();
    return errorSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleConclusionElement createRuleConclusionElement()
  {
    RuleConclusionElementImpl ruleConclusionElement = new RuleConclusionElementImpl();
    return ruleConclusionElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleParameter createRuleParameter()
  {
    RuleParameterImpl ruleParameter = new RuleParameterImpl();
    return ruleParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionInConclusion createExpressionInConclusion()
  {
    ExpressionInConclusionImpl expressionInConclusion = new ExpressionInConclusionImpl();
    return expressionInConclusion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputParameter createOutputParameter()
  {
    OutputParameterImpl outputParameter = new OutputParameterImpl();
    return outputParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputParameter createInputParameter()
  {
    InputParameterImpl inputParameter = new InputParameterImpl();
    return inputParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrExpression createOrExpression()
  {
    OrExpressionImpl orExpression = new OrExpressionImpl();
    return orExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Fail createFail()
  {
    FailImpl fail = new FailImpl();
    return fail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnvironmentAccess createEnvironmentAccess()
  {
    EnvironmentAccessImpl environmentAccess = new EnvironmentAccessImpl();
    return environmentAccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnvironmentComposition createEnvironmentComposition()
  {
    EnvironmentCompositionImpl environmentComposition = new EnvironmentCompositionImpl();
    return environmentComposition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmptyEnvironment createEmptyEnvironment()
  {
    EmptyEnvironmentImpl emptyEnvironment = new EmptyEnvironmentImpl();
    return emptyEnvironment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnvironmentMapping createEnvironmentMapping()
  {
    EnvironmentMappingImpl environmentMapping = new EnvironmentMappingImpl();
    return environmentMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XsemanticsPackage getXsemanticsPackage()
  {
    return (XsemanticsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XsemanticsPackage getPackage()
  {
    return XsemanticsPackage.eINSTANCE;
  }

} //XsemanticsFactoryImpl
