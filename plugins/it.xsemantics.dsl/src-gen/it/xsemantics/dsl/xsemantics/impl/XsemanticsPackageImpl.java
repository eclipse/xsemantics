/**
 */
package it.xsemantics.dsl.xsemantics.impl;

import it.xsemantics.dsl.xsemantics.AuxiliaryDescription;
import it.xsemantics.dsl.xsemantics.AuxiliaryFunction;
import it.xsemantics.dsl.xsemantics.Axiom;
import it.xsemantics.dsl.xsemantics.CheckRule;
import it.xsemantics.dsl.xsemantics.EmptyEnvironment;
import it.xsemantics.dsl.xsemantics.Environment;
import it.xsemantics.dsl.xsemantics.EnvironmentAccess;
import it.xsemantics.dsl.xsemantics.EnvironmentComposition;
import it.xsemantics.dsl.xsemantics.EnvironmentMapping;
import it.xsemantics.dsl.xsemantics.EnvironmentReference;
import it.xsemantics.dsl.xsemantics.EnvironmentSpecification;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.ExpressionInConclusion;
import it.xsemantics.dsl.xsemantics.Fail;
import it.xsemantics.dsl.xsemantics.Import;
import it.xsemantics.dsl.xsemantics.Injected;
import it.xsemantics.dsl.xsemantics.InputParameter;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.JudgmentParameter;
import it.xsemantics.dsl.xsemantics.OrExpression;
import it.xsemantics.dsl.xsemantics.OutputParameter;
import it.xsemantics.dsl.xsemantics.Rule;
import it.xsemantics.dsl.xsemantics.RuleConclusion;
import it.xsemantics.dsl.xsemantics.RuleConclusionElement;
import it.xsemantics.dsl.xsemantics.RuleInvocation;
import it.xsemantics.dsl.xsemantics.RuleInvocationExpression;
import it.xsemantics.dsl.xsemantics.RuleParameter;
import it.xsemantics.dsl.xsemantics.RuleWithPremises;
import it.xsemantics.dsl.xsemantics.XsemanticsFactory;
import it.xsemantics.dsl.xsemantics.XsemanticsPackage;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XsemanticsPackageImpl extends EPackageImpl implements XsemanticsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xsemanticsSystemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass injectedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass auxiliaryDescriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass judgmentDescriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass judgmentParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass auxiliaryFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass axiomEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleWithPremisesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass checkRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleConclusionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleInvocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleInvocationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass environmentSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass environmentReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass environmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleConclusionElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionInConclusionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outputParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inputParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass failEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass environmentAccessEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass environmentCompositionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emptyEnvironmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass environmentMappingEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see it.xsemantics.dsl.xsemantics.XsemanticsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private XsemanticsPackageImpl()
  {
    super(eNS_URI, XsemanticsFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link XsemanticsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static XsemanticsPackage init()
  {
    if (isInited) return (XsemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(XsemanticsPackage.eNS_URI);

    // Obtain or create and register package
    XsemanticsPackageImpl theXsemanticsPackage = (XsemanticsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XsemanticsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XsemanticsPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XbasePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theXsemanticsPackage.createPackageContents();

    // Initialize created meta-data
    theXsemanticsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theXsemanticsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(XsemanticsPackage.eNS_URI, theXsemanticsPackage);
    return theXsemanticsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXsemanticsSystem()
  {
    return xsemanticsSystemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXsemanticsSystem_Name()
  {
    return (EAttribute)xsemanticsSystemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXsemanticsSystem_SuperSystem()
  {
    return (EReference)xsemanticsSystemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXsemanticsSystem_ValidatorExtends()
  {
    return (EReference)xsemanticsSystemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXsemanticsSystem_Imports()
  {
    return (EReference)xsemanticsSystemEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXsemanticsSystem_Injections()
  {
    return (EReference)xsemanticsSystemEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXsemanticsSystem_AuxiliaryDescriptions()
  {
    return (EReference)xsemanticsSystemEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXsemanticsSystem_JudgmentDescriptions()
  {
    return (EReference)xsemanticsSystemEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXsemanticsSystem_AuxiliaryFunctions()
  {
    return (EReference)xsemanticsSystemEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXsemanticsSystem_Rules()
  {
    return (EReference)xsemanticsSystemEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXsemanticsSystem_Checkrules()
  {
    return (EReference)xsemanticsSystemEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportedNamespace()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInjected()
  {
    return injectedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInjected_Type()
  {
    return (EReference)injectedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInjected_Name()
  {
    return (EAttribute)injectedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAuxiliaryDescription()
  {
    return auxiliaryDescriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAuxiliaryDescription_Name()
  {
    return (EAttribute)auxiliaryDescriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAuxiliaryDescription_Parameters()
  {
    return (EReference)auxiliaryDescriptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAuxiliaryDescription_Type()
  {
    return (EReference)auxiliaryDescriptionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAuxiliaryDescription_Error()
  {
    return (EReference)auxiliaryDescriptionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJudgmentDescription()
  {
    return judgmentDescriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJudgmentDescription_Override()
  {
    return (EAttribute)judgmentDescriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJudgmentDescription_Name()
  {
    return (EAttribute)judgmentDescriptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJudgmentDescription_JudgmentSymbol()
  {
    return (EAttribute)judgmentDescriptionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJudgmentDescription_JudgmentParameters()
  {
    return (EReference)judgmentDescriptionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJudgmentDescription_RelationSymbols()
  {
    return (EAttribute)judgmentDescriptionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJudgmentDescription_Error()
  {
    return (EReference)judgmentDescriptionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJudgmentParameter()
  {
    return judgmentParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAuxiliaryFunction()
  {
    return auxiliaryFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAuxiliaryFunction_Name()
  {
    return (EAttribute)auxiliaryFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAuxiliaryFunction_Parameters()
  {
    return (EReference)auxiliaryFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAuxiliaryFunction_Body()
  {
    return (EReference)auxiliaryFunctionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRule()
  {
    return ruleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule_Override()
  {
    return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule_Name()
  {
    return (EAttribute)ruleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRule_Conclusion()
  {
    return (EReference)ruleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAxiom()
  {
    return axiomEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleWithPremises()
  {
    return ruleWithPremisesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleWithPremises_Premises()
  {
    return (EReference)ruleWithPremisesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCheckRule()
  {
    return checkRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCheckRule_Override()
  {
    return (EAttribute)checkRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCheckRule_Name()
  {
    return (EAttribute)checkRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCheckRule_Element()
  {
    return (EReference)checkRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCheckRule_Premises()
  {
    return (EReference)checkRuleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleConclusion()
  {
    return ruleConclusionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleConclusion_Environment()
  {
    return (EReference)ruleConclusionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleConclusion_JudgmentSymbol()
  {
    return (EAttribute)ruleConclusionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleConclusion_ConclusionElements()
  {
    return (EReference)ruleConclusionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleConclusion_RelationSymbols()
  {
    return (EAttribute)ruleConclusionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleConclusion_Error()
  {
    return (EReference)ruleConclusionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleInvocation()
  {
    return ruleInvocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleInvocation_Environment()
  {
    return (EReference)ruleInvocationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleInvocation_JudgmentSymbol()
  {
    return (EAttribute)ruleInvocationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleInvocation_Expressions()
  {
    return (EReference)ruleInvocationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleInvocation_RelationSymbols()
  {
    return (EAttribute)ruleInvocationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleInvocationExpression()
  {
    return ruleInvocationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleInvocationExpression_Expression()
  {
    return (EReference)ruleInvocationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnvironmentSpecification()
  {
    return environmentSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnvironmentReference()
  {
    return environmentReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnvironmentReference_Environment()
  {
    return (EReference)environmentReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnvironment()
  {
    return environmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnvironment_Name()
  {
    return (EAttribute)environmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorSpecification()
  {
    return errorSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorSpecification_Error()
  {
    return (EReference)errorSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorSpecification_Source()
  {
    return (EReference)errorSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorSpecification_Feature()
  {
    return (EReference)errorSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleConclusionElement()
  {
    return ruleConclusionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleParameter()
  {
    return ruleParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleParameter_Parameter()
  {
    return (EReference)ruleParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionInConclusion()
  {
    return expressionInConclusionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionInConclusion_Expression()
  {
    return (EReference)expressionInConclusionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutputParameter()
  {
    return outputParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutputParameter_JvmTypeReference()
  {
    return (EReference)outputParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInputParameter()
  {
    return inputParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInputParameter_Parameter()
  {
    return (EReference)inputParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrExpression()
  {
    return orExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Branches()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFail()
  {
    return failEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFail_Error()
  {
    return (EReference)failEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnvironmentAccess()
  {
    return environmentAccessEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnvironmentAccess_Environment()
  {
    return (EReference)environmentAccessEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnvironmentAccess_Argument()
  {
    return (EReference)environmentAccessEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnvironmentAccess_Type()
  {
    return (EReference)environmentAccessEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnvironmentComposition()
  {
    return environmentCompositionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnvironmentComposition_CurrentEnvironment()
  {
    return (EReference)environmentCompositionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnvironmentComposition_SubEnvironment()
  {
    return (EReference)environmentCompositionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmptyEnvironment()
  {
    return emptyEnvironmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnvironmentMapping()
  {
    return environmentMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnvironmentMapping_Key()
  {
    return (EReference)environmentMappingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnvironmentMapping_Value()
  {
    return (EReference)environmentMappingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XsemanticsFactory getXsemanticsFactory()
  {
    return (XsemanticsFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    xsemanticsSystemEClass = createEClass(XSEMANTICS_SYSTEM);
    createEAttribute(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__NAME);
    createEReference(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__SUPER_SYSTEM);
    createEReference(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS);
    createEReference(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__IMPORTS);
    createEReference(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__INJECTIONS);
    createEReference(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__AUXILIARY_DESCRIPTIONS);
    createEReference(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__JUDGMENT_DESCRIPTIONS);
    createEReference(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__AUXILIARY_FUNCTIONS);
    createEReference(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__RULES);
    createEReference(xsemanticsSystemEClass, XSEMANTICS_SYSTEM__CHECKRULES);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);

    injectedEClass = createEClass(INJECTED);
    createEReference(injectedEClass, INJECTED__TYPE);
    createEAttribute(injectedEClass, INJECTED__NAME);

    auxiliaryDescriptionEClass = createEClass(AUXILIARY_DESCRIPTION);
    createEAttribute(auxiliaryDescriptionEClass, AUXILIARY_DESCRIPTION__NAME);
    createEReference(auxiliaryDescriptionEClass, AUXILIARY_DESCRIPTION__PARAMETERS);
    createEReference(auxiliaryDescriptionEClass, AUXILIARY_DESCRIPTION__TYPE);
    createEReference(auxiliaryDescriptionEClass, AUXILIARY_DESCRIPTION__ERROR);

    judgmentDescriptionEClass = createEClass(JUDGMENT_DESCRIPTION);
    createEAttribute(judgmentDescriptionEClass, JUDGMENT_DESCRIPTION__OVERRIDE);
    createEAttribute(judgmentDescriptionEClass, JUDGMENT_DESCRIPTION__NAME);
    createEAttribute(judgmentDescriptionEClass, JUDGMENT_DESCRIPTION__JUDGMENT_SYMBOL);
    createEReference(judgmentDescriptionEClass, JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS);
    createEAttribute(judgmentDescriptionEClass, JUDGMENT_DESCRIPTION__RELATION_SYMBOLS);
    createEReference(judgmentDescriptionEClass, JUDGMENT_DESCRIPTION__ERROR);

    judgmentParameterEClass = createEClass(JUDGMENT_PARAMETER);

    auxiliaryFunctionEClass = createEClass(AUXILIARY_FUNCTION);
    createEAttribute(auxiliaryFunctionEClass, AUXILIARY_FUNCTION__NAME);
    createEReference(auxiliaryFunctionEClass, AUXILIARY_FUNCTION__PARAMETERS);
    createEReference(auxiliaryFunctionEClass, AUXILIARY_FUNCTION__BODY);

    ruleEClass = createEClass(RULE);
    createEAttribute(ruleEClass, RULE__OVERRIDE);
    createEAttribute(ruleEClass, RULE__NAME);
    createEReference(ruleEClass, RULE__CONCLUSION);

    axiomEClass = createEClass(AXIOM);

    ruleWithPremisesEClass = createEClass(RULE_WITH_PREMISES);
    createEReference(ruleWithPremisesEClass, RULE_WITH_PREMISES__PREMISES);

    checkRuleEClass = createEClass(CHECK_RULE);
    createEAttribute(checkRuleEClass, CHECK_RULE__OVERRIDE);
    createEAttribute(checkRuleEClass, CHECK_RULE__NAME);
    createEReference(checkRuleEClass, CHECK_RULE__ELEMENT);
    createEReference(checkRuleEClass, CHECK_RULE__PREMISES);

    ruleConclusionEClass = createEClass(RULE_CONCLUSION);
    createEReference(ruleConclusionEClass, RULE_CONCLUSION__ENVIRONMENT);
    createEAttribute(ruleConclusionEClass, RULE_CONCLUSION__JUDGMENT_SYMBOL);
    createEReference(ruleConclusionEClass, RULE_CONCLUSION__CONCLUSION_ELEMENTS);
    createEAttribute(ruleConclusionEClass, RULE_CONCLUSION__RELATION_SYMBOLS);
    createEReference(ruleConclusionEClass, RULE_CONCLUSION__ERROR);

    ruleInvocationEClass = createEClass(RULE_INVOCATION);
    createEReference(ruleInvocationEClass, RULE_INVOCATION__ENVIRONMENT);
    createEAttribute(ruleInvocationEClass, RULE_INVOCATION__JUDGMENT_SYMBOL);
    createEReference(ruleInvocationEClass, RULE_INVOCATION__EXPRESSIONS);
    createEAttribute(ruleInvocationEClass, RULE_INVOCATION__RELATION_SYMBOLS);

    ruleInvocationExpressionEClass = createEClass(RULE_INVOCATION_EXPRESSION);
    createEReference(ruleInvocationExpressionEClass, RULE_INVOCATION_EXPRESSION__EXPRESSION);

    environmentSpecificationEClass = createEClass(ENVIRONMENT_SPECIFICATION);

    environmentReferenceEClass = createEClass(ENVIRONMENT_REFERENCE);
    createEReference(environmentReferenceEClass, ENVIRONMENT_REFERENCE__ENVIRONMENT);

    environmentEClass = createEClass(ENVIRONMENT);
    createEAttribute(environmentEClass, ENVIRONMENT__NAME);

    errorSpecificationEClass = createEClass(ERROR_SPECIFICATION);
    createEReference(errorSpecificationEClass, ERROR_SPECIFICATION__ERROR);
    createEReference(errorSpecificationEClass, ERROR_SPECIFICATION__SOURCE);
    createEReference(errorSpecificationEClass, ERROR_SPECIFICATION__FEATURE);

    ruleConclusionElementEClass = createEClass(RULE_CONCLUSION_ELEMENT);

    ruleParameterEClass = createEClass(RULE_PARAMETER);
    createEReference(ruleParameterEClass, RULE_PARAMETER__PARAMETER);

    expressionInConclusionEClass = createEClass(EXPRESSION_IN_CONCLUSION);
    createEReference(expressionInConclusionEClass, EXPRESSION_IN_CONCLUSION__EXPRESSION);

    outputParameterEClass = createEClass(OUTPUT_PARAMETER);
    createEReference(outputParameterEClass, OUTPUT_PARAMETER__JVM_TYPE_REFERENCE);

    inputParameterEClass = createEClass(INPUT_PARAMETER);
    createEReference(inputParameterEClass, INPUT_PARAMETER__PARAMETER);

    orExpressionEClass = createEClass(OR_EXPRESSION);
    createEReference(orExpressionEClass, OR_EXPRESSION__BRANCHES);

    failEClass = createEClass(FAIL);
    createEReference(failEClass, FAIL__ERROR);

    environmentAccessEClass = createEClass(ENVIRONMENT_ACCESS);
    createEReference(environmentAccessEClass, ENVIRONMENT_ACCESS__ENVIRONMENT);
    createEReference(environmentAccessEClass, ENVIRONMENT_ACCESS__ARGUMENT);
    createEReference(environmentAccessEClass, ENVIRONMENT_ACCESS__TYPE);

    environmentCompositionEClass = createEClass(ENVIRONMENT_COMPOSITION);
    createEReference(environmentCompositionEClass, ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT);
    createEReference(environmentCompositionEClass, ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT);

    emptyEnvironmentEClass = createEClass(EMPTY_ENVIRONMENT);

    environmentMappingEClass = createEClass(ENVIRONMENT_MAPPING);
    createEReference(environmentMappingEClass, ENVIRONMENT_MAPPING__KEY);
    createEReference(environmentMappingEClass, ENVIRONMENT_MAPPING__VALUE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    axiomEClass.getESuperTypes().add(this.getRule());
    ruleWithPremisesEClass.getESuperTypes().add(this.getRule());
    ruleInvocationEClass.getESuperTypes().add(theXbasePackage.getXExpression());
    environmentReferenceEClass.getESuperTypes().add(this.getEnvironmentSpecification());
    ruleParameterEClass.getESuperTypes().add(this.getRuleConclusionElement());
    expressionInConclusionEClass.getESuperTypes().add(this.getRuleConclusionElement());
    outputParameterEClass.getESuperTypes().add(this.getJudgmentParameter());
    inputParameterEClass.getESuperTypes().add(this.getJudgmentParameter());
    orExpressionEClass.getESuperTypes().add(theXbasePackage.getXExpression());
    failEClass.getESuperTypes().add(theXbasePackage.getXExpression());
    environmentAccessEClass.getESuperTypes().add(theXbasePackage.getXExpression());
    environmentCompositionEClass.getESuperTypes().add(this.getEnvironmentSpecification());
    emptyEnvironmentEClass.getESuperTypes().add(this.getEnvironmentSpecification());
    environmentMappingEClass.getESuperTypes().add(this.getEnvironmentSpecification());

    // Initialize classes and features; add operations and parameters
    initEClass(xsemanticsSystemEClass, XsemanticsSystem.class, "XsemanticsSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getXsemanticsSystem_Name(), ecorePackage.getEString(), "name", null, 0, 1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXsemanticsSystem_SuperSystem(), theTypesPackage.getJvmParameterizedTypeReference(), null, "superSystem", null, 0, 1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXsemanticsSystem_ValidatorExtends(), theTypesPackage.getJvmParameterizedTypeReference(), null, "validatorExtends", null, 0, 1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXsemanticsSystem_Imports(), this.getImport(), null, "imports", null, 0, -1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXsemanticsSystem_Injections(), this.getInjected(), null, "injections", null, 0, -1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXsemanticsSystem_AuxiliaryDescriptions(), this.getAuxiliaryDescription(), null, "auxiliaryDescriptions", null, 0, -1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXsemanticsSystem_JudgmentDescriptions(), this.getJudgmentDescription(), null, "judgmentDescriptions", null, 0, -1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXsemanticsSystem_AuxiliaryFunctions(), this.getAuxiliaryFunction(), null, "auxiliaryFunctions", null, 0, -1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXsemanticsSystem_Rules(), this.getRule(), null, "rules", null, 0, -1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXsemanticsSystem_Checkrules(), this.getCheckRule(), null, "checkrules", null, 0, -1, XsemanticsSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(injectedEClass, Injected.class, "Injected", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInjected_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, Injected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInjected_Name(), ecorePackage.getEString(), "name", null, 0, 1, Injected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(auxiliaryDescriptionEClass, AuxiliaryDescription.class, "AuxiliaryDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAuxiliaryDescription_Name(), ecorePackage.getEString(), "name", null, 0, 1, AuxiliaryDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAuxiliaryDescription_Parameters(), theTypesPackage.getJvmFormalParameter(), null, "parameters", null, 0, -1, AuxiliaryDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAuxiliaryDescription_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, AuxiliaryDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAuxiliaryDescription_Error(), this.getErrorSpecification(), null, "error", null, 0, 1, AuxiliaryDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(judgmentDescriptionEClass, JudgmentDescription.class, "JudgmentDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJudgmentDescription_Override(), ecorePackage.getEBoolean(), "override", null, 0, 1, JudgmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJudgmentDescription_Name(), ecorePackage.getEString(), "name", null, 0, 1, JudgmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJudgmentDescription_JudgmentSymbol(), ecorePackage.getEString(), "judgmentSymbol", null, 0, 1, JudgmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJudgmentDescription_JudgmentParameters(), this.getJudgmentParameter(), null, "judgmentParameters", null, 0, -1, JudgmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJudgmentDescription_RelationSymbols(), ecorePackage.getEString(), "relationSymbols", null, 0, -1, JudgmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJudgmentDescription_Error(), this.getErrorSpecification(), null, "error", null, 0, 1, JudgmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(judgmentParameterEClass, JudgmentParameter.class, "JudgmentParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(auxiliaryFunctionEClass, AuxiliaryFunction.class, "AuxiliaryFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAuxiliaryFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, AuxiliaryFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAuxiliaryFunction_Parameters(), theTypesPackage.getJvmFormalParameter(), null, "parameters", null, 0, -1, AuxiliaryFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAuxiliaryFunction_Body(), theXbasePackage.getXExpression(), null, "body", null, 0, 1, AuxiliaryFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRule_Override(), ecorePackage.getEBoolean(), "override", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRule_Name(), ecorePackage.getEString(), "name", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRule_Conclusion(), this.getRuleConclusion(), null, "conclusion", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(axiomEClass, Axiom.class, "Axiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ruleWithPremisesEClass, RuleWithPremises.class, "RuleWithPremises", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleWithPremises_Premises(), theXbasePackage.getXExpression(), null, "premises", null, 0, 1, RuleWithPremises.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(checkRuleEClass, CheckRule.class, "CheckRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCheckRule_Override(), ecorePackage.getEBoolean(), "override", null, 0, 1, CheckRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCheckRule_Name(), ecorePackage.getEString(), "name", null, 0, 1, CheckRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCheckRule_Element(), this.getRuleParameter(), null, "element", null, 0, 1, CheckRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCheckRule_Premises(), theXbasePackage.getXExpression(), null, "premises", null, 0, 1, CheckRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleConclusionEClass, RuleConclusion.class, "RuleConclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleConclusion_Environment(), this.getEnvironment(), null, "environment", null, 0, 1, RuleConclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleConclusion_JudgmentSymbol(), ecorePackage.getEString(), "judgmentSymbol", null, 0, 1, RuleConclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleConclusion_ConclusionElements(), this.getRuleConclusionElement(), null, "conclusionElements", null, 0, -1, RuleConclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleConclusion_RelationSymbols(), ecorePackage.getEString(), "relationSymbols", null, 0, -1, RuleConclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleConclusion_Error(), this.getErrorSpecification(), null, "error", null, 0, 1, RuleConclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleInvocationEClass, RuleInvocation.class, "RuleInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleInvocation_Environment(), this.getEnvironmentSpecification(), null, "environment", null, 0, 1, RuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleInvocation_JudgmentSymbol(), ecorePackage.getEString(), "judgmentSymbol", null, 0, 1, RuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleInvocation_Expressions(), this.getRuleInvocationExpression(), null, "expressions", null, 0, -1, RuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleInvocation_RelationSymbols(), ecorePackage.getEString(), "relationSymbols", null, 0, -1, RuleInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleInvocationExpressionEClass, RuleInvocationExpression.class, "RuleInvocationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleInvocationExpression_Expression(), theXbasePackage.getXExpression(), null, "expression", null, 0, 1, RuleInvocationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(environmentSpecificationEClass, EnvironmentSpecification.class, "EnvironmentSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(environmentReferenceEClass, EnvironmentReference.class, "EnvironmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnvironmentReference_Environment(), this.getEnvironment(), null, "environment", null, 0, 1, EnvironmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(environmentEClass, Environment.class, "Environment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnvironment_Name(), ecorePackage.getEString(), "name", null, 0, 1, Environment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorSpecificationEClass, ErrorSpecification.class, "ErrorSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorSpecification_Error(), theXbasePackage.getXExpression(), null, "error", null, 0, 1, ErrorSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorSpecification_Source(), theXbasePackage.getXExpression(), null, "source", null, 0, 1, ErrorSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorSpecification_Feature(), theXbasePackage.getXExpression(), null, "feature", null, 0, 1, ErrorSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleConclusionElementEClass, RuleConclusionElement.class, "RuleConclusionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ruleParameterEClass, RuleParameter.class, "RuleParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleParameter_Parameter(), theTypesPackage.getJvmFormalParameter(), null, "parameter", null, 0, 1, RuleParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionInConclusionEClass, ExpressionInConclusion.class, "ExpressionInConclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionInConclusion_Expression(), theXbasePackage.getXExpression(), null, "expression", null, 0, 1, ExpressionInConclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outputParameterEClass, OutputParameter.class, "OutputParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutputParameter_JvmTypeReference(), theTypesPackage.getJvmTypeReference(), null, "jvmTypeReference", null, 0, 1, OutputParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inputParameterEClass, InputParameter.class, "InputParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInputParameter_Parameter(), theTypesPackage.getJvmFormalParameter(), null, "parameter", null, 0, 1, InputParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrExpression_Branches(), theXbasePackage.getXExpression(), null, "branches", null, 0, -1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(failEClass, Fail.class, "Fail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFail_Error(), this.getErrorSpecification(), null, "error", null, 0, 1, Fail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(environmentAccessEClass, EnvironmentAccess.class, "EnvironmentAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnvironmentAccess_Environment(), this.getEnvironment(), null, "environment", null, 0, 1, EnvironmentAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnvironmentAccess_Argument(), theXbasePackage.getXExpression(), null, "argument", null, 0, 1, EnvironmentAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnvironmentAccess_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, EnvironmentAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(environmentCompositionEClass, EnvironmentComposition.class, "EnvironmentComposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnvironmentComposition_CurrentEnvironment(), this.getEnvironmentSpecification(), null, "currentEnvironment", null, 0, 1, EnvironmentComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnvironmentComposition_SubEnvironment(), this.getEnvironmentSpecification(), null, "subEnvironment", null, 0, 1, EnvironmentComposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(emptyEnvironmentEClass, EmptyEnvironment.class, "EmptyEnvironment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(environmentMappingEClass, EnvironmentMapping.class, "EnvironmentMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnvironmentMapping_Key(), theXbasePackage.getXExpression(), null, "key", null, 0, 1, EnvironmentMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnvironmentMapping_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, EnvironmentMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //XsemanticsPackageImpl
