/**
 */
package it.xsemantics.dsl.xsemantics.util;

import it.xsemantics.dsl.xsemantics.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage
 * @generated
 */
public class XsemanticsAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XsemanticsPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XsemanticsAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = XsemanticsPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XsemanticsSwitch<Adapter> modelSwitch =
    new XsemanticsSwitch<Adapter>()
    {
      @Override
      public Adapter caseXsemanticsSystem(XsemanticsSystem object)
      {
        return createXsemanticsSystemAdapter();
      }
      @Override
      public Adapter caseInjected(Injected object)
      {
        return createInjectedAdapter();
      }
      @Override
      public Adapter caseAuxiliaryDescription(AuxiliaryDescription object)
      {
        return createAuxiliaryDescriptionAdapter();
      }
      @Override
      public Adapter caseJudgmentDescription(JudgmentDescription object)
      {
        return createJudgmentDescriptionAdapter();
      }
      @Override
      public Adapter caseJudgmentParameter(JudgmentParameter object)
      {
        return createJudgmentParameterAdapter();
      }
      @Override
      public Adapter caseAuxiliaryFunction(AuxiliaryFunction object)
      {
        return createAuxiliaryFunctionAdapter();
      }
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseAxiom(Axiom object)
      {
        return createAxiomAdapter();
      }
      @Override
      public Adapter caseRuleWithPremises(RuleWithPremises object)
      {
        return createRuleWithPremisesAdapter();
      }
      @Override
      public Adapter caseCheckRule(CheckRule object)
      {
        return createCheckRuleAdapter();
      }
      @Override
      public Adapter caseRuleConclusion(RuleConclusion object)
      {
        return createRuleConclusionAdapter();
      }
      @Override
      public Adapter caseRuleInvocation(RuleInvocation object)
      {
        return createRuleInvocationAdapter();
      }
      @Override
      public Adapter caseEnvironmentSpecification(EnvironmentSpecification object)
      {
        return createEnvironmentSpecificationAdapter();
      }
      @Override
      public Adapter caseEnvironmentReference(EnvironmentReference object)
      {
        return createEnvironmentReferenceAdapter();
      }
      @Override
      public Adapter caseEnvironment(Environment object)
      {
        return createEnvironmentAdapter();
      }
      @Override
      public Adapter caseErrorSpecification(ErrorSpecification object)
      {
        return createErrorSpecificationAdapter();
      }
      @Override
      public Adapter caseRuleConclusionElement(RuleConclusionElement object)
      {
        return createRuleConclusionElementAdapter();
      }
      @Override
      public Adapter caseRuleParameter(RuleParameter object)
      {
        return createRuleParameterAdapter();
      }
      @Override
      public Adapter caseExpressionInConclusion(ExpressionInConclusion object)
      {
        return createExpressionInConclusionAdapter();
      }
      @Override
      public Adapter caseOutputParameter(OutputParameter object)
      {
        return createOutputParameterAdapter();
      }
      @Override
      public Adapter caseInputParameter(InputParameter object)
      {
        return createInputParameterAdapter();
      }
      @Override
      public Adapter caseOrExpression(OrExpression object)
      {
        return createOrExpressionAdapter();
      }
      @Override
      public Adapter caseFail(Fail object)
      {
        return createFailAdapter();
      }
      @Override
      public Adapter caseEnvironmentAccess(EnvironmentAccess object)
      {
        return createEnvironmentAccessAdapter();
      }
      @Override
      public Adapter caseEnvironmentComposition(EnvironmentComposition object)
      {
        return createEnvironmentCompositionAdapter();
      }
      @Override
      public Adapter caseEmptyEnvironment(EmptyEnvironment object)
      {
        return createEmptyEnvironmentAdapter();
      }
      @Override
      public Adapter caseEnvironmentMapping(EnvironmentMapping object)
      {
        return createEnvironmentMappingAdapter();
      }
      @Override
      public Adapter caseXExpression(XExpression object)
      {
        return createXExpressionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem <em>System</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem
   * @generated
   */
  public Adapter createXsemanticsSystemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.Injected <em>Injected</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.Injected
   * @generated
   */
  public Adapter createInjectedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.AuxiliaryDescription <em>Auxiliary Description</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryDescription
   * @generated
   */
  public Adapter createAuxiliaryDescriptionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription <em>Judgment Description</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.JudgmentDescription
   * @generated
   */
  public Adapter createJudgmentDescriptionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.JudgmentParameter <em>Judgment Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.JudgmentParameter
   * @generated
   */
  public Adapter createJudgmentParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.AuxiliaryFunction <em>Auxiliary Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryFunction
   * @generated
   */
  public Adapter createAuxiliaryFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.Rule
   * @generated
   */
  public Adapter createRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.Axiom <em>Axiom</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.Axiom
   * @generated
   */
  public Adapter createAxiomAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.RuleWithPremises <em>Rule With Premises</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.RuleWithPremises
   * @generated
   */
  public Adapter createRuleWithPremisesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.CheckRule <em>Check Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.CheckRule
   * @generated
   */
  public Adapter createCheckRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.RuleConclusion <em>Rule Conclusion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.RuleConclusion
   * @generated
   */
  public Adapter createRuleConclusionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.RuleInvocation <em>Rule Invocation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.RuleInvocation
   * @generated
   */
  public Adapter createRuleInvocationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.EnvironmentSpecification <em>Environment Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentSpecification
   * @generated
   */
  public Adapter createEnvironmentSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.EnvironmentReference <em>Environment Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentReference
   * @generated
   */
  public Adapter createEnvironmentReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.Environment <em>Environment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.Environment
   * @generated
   */
  public Adapter createEnvironmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.ErrorSpecification <em>Error Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.ErrorSpecification
   * @generated
   */
  public Adapter createErrorSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.RuleConclusionElement <em>Rule Conclusion Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.RuleConclusionElement
   * @generated
   */
  public Adapter createRuleConclusionElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.RuleParameter <em>Rule Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.RuleParameter
   * @generated
   */
  public Adapter createRuleParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.ExpressionInConclusion <em>Expression In Conclusion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.ExpressionInConclusion
   * @generated
   */
  public Adapter createExpressionInConclusionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.OutputParameter <em>Output Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.OutputParameter
   * @generated
   */
  public Adapter createOutputParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.InputParameter <em>Input Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.InputParameter
   * @generated
   */
  public Adapter createInputParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.OrExpression
   * @generated
   */
  public Adapter createOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.Fail <em>Fail</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.Fail
   * @generated
   */
  public Adapter createFailAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess <em>Environment Access</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentAccess
   * @generated
   */
  public Adapter createEnvironmentAccessAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.EnvironmentComposition <em>Environment Composition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentComposition
   * @generated
   */
  public Adapter createEnvironmentCompositionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.EmptyEnvironment <em>Empty Environment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.EmptyEnvironment
   * @generated
   */
  public Adapter createEmptyEnvironmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.xsemantics.dsl.xsemantics.EnvironmentMapping <em>Environment Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentMapping
   * @generated
   */
  public Adapter createEnvironmentMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XExpression <em>XExpression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xbase.XExpression
   * @generated
   */
  public Adapter createXExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //XsemanticsAdapterFactory
