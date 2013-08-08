/**
 */
package it.xsemantics.dsl.xsemantics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see it.xsemantics.dsl.xsemantics.XsemanticsFactory
 * @model kind="package"
 * @generated
 */
public interface XsemanticsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xsemantics";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://xsemantics.sf.net/Xsemantics";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xsemantics";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XsemanticsPackage eINSTANCE = it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl.init();

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl <em>System</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getXsemanticsSystem()
   * @generated
   */
  int XSEMANTICS_SYSTEM = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__NAME = 0;

  /**
   * The feature id for the '<em><b>Super System</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__SUPER_SYSTEM = 1;

  /**
   * The feature id for the '<em><b>Validator Extends</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS = 2;

  /**
   * The feature id for the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__IMPORT_SECTION = 3;

  /**
   * The feature id for the '<em><b>Injections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__INJECTIONS = 4;

  /**
   * The feature id for the '<em><b>Auxiliary Descriptions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__AUXILIARY_DESCRIPTIONS = 5;

  /**
   * The feature id for the '<em><b>Judgment Descriptions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__JUDGMENT_DESCRIPTIONS = 6;

  /**
   * The feature id for the '<em><b>Auxiliary Functions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__AUXILIARY_FUNCTIONS = 7;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__RULES = 8;

  /**
   * The feature id for the '<em><b>Checkrules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM__CHECKRULES = 9;

  /**
   * The number of structural features of the '<em>System</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSEMANTICS_SYSTEM_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.InjectedImpl <em>Injected</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.InjectedImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getInjected()
   * @generated
   */
  int INJECTED = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INJECTED__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INJECTED__NAME = 1;

  /**
   * The number of structural features of the '<em>Injected</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INJECTED_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.AuxiliaryDescriptionImpl <em>Auxiliary Description</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.AuxiliaryDescriptionImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getAuxiliaryDescription()
   * @generated
   */
  int AUXILIARY_DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUXILIARY_DESCRIPTION__NAME = 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUXILIARY_DESCRIPTION__PARAMETERS = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUXILIARY_DESCRIPTION__TYPE = 2;

  /**
   * The feature id for the '<em><b>Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUXILIARY_DESCRIPTION__ERROR = 3;

  /**
   * The number of structural features of the '<em>Auxiliary Description</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUXILIARY_DESCRIPTION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl <em>Judgment Description</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getJudgmentDescription()
   * @generated
   */
  int JUDGMENT_DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUDGMENT_DESCRIPTION__OVERRIDE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUDGMENT_DESCRIPTION__NAME = 1;

  /**
   * The feature id for the '<em><b>Judgment Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUDGMENT_DESCRIPTION__JUDGMENT_SYMBOL = 2;

  /**
   * The feature id for the '<em><b>Judgment Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS = 3;

  /**
   * The feature id for the '<em><b>Relation Symbols</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUDGMENT_DESCRIPTION__RELATION_SYMBOLS = 4;

  /**
   * The feature id for the '<em><b>Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUDGMENT_DESCRIPTION__ERROR = 5;

  /**
   * The number of structural features of the '<em>Judgment Description</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUDGMENT_DESCRIPTION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.JudgmentParameterImpl <em>Judgment Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.JudgmentParameterImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getJudgmentParameter()
   * @generated
   */
  int JUDGMENT_PARAMETER = 4;

  /**
   * The number of structural features of the '<em>Judgment Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JUDGMENT_PARAMETER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.AuxiliaryFunctionImpl <em>Auxiliary Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.AuxiliaryFunctionImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getAuxiliaryFunction()
   * @generated
   */
  int AUXILIARY_FUNCTION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUXILIARY_FUNCTION__NAME = 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUXILIARY_FUNCTION__PARAMETERS = 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUXILIARY_FUNCTION__BODY = 2;

  /**
   * The number of structural features of the '<em>Auxiliary Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUXILIARY_FUNCTION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleImpl <em>Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.RuleImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRule()
   * @generated
   */
  int RULE = 6;

  /**
   * The feature id for the '<em><b>Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__OVERRIDE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__NAME = 1;

  /**
   * The feature id for the '<em><b>Conclusion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__CONCLUSION = 2;

  /**
   * The number of structural features of the '<em>Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.AxiomImpl <em>Axiom</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.AxiomImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getAxiom()
   * @generated
   */
  int AXIOM = 7;

  /**
   * The feature id for the '<em><b>Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AXIOM__OVERRIDE = RULE__OVERRIDE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AXIOM__NAME = RULE__NAME;

  /**
   * The feature id for the '<em><b>Conclusion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AXIOM__CONCLUSION = RULE__CONCLUSION;

  /**
   * The number of structural features of the '<em>Axiom</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AXIOM_FEATURE_COUNT = RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleWithPremisesImpl <em>Rule With Premises</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.RuleWithPremisesImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleWithPremises()
   * @generated
   */
  int RULE_WITH_PREMISES = 8;

  /**
   * The feature id for the '<em><b>Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_WITH_PREMISES__OVERRIDE = RULE__OVERRIDE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_WITH_PREMISES__NAME = RULE__NAME;

  /**
   * The feature id for the '<em><b>Conclusion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_WITH_PREMISES__CONCLUSION = RULE__CONCLUSION;

  /**
   * The feature id for the '<em><b>Premises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_WITH_PREMISES__PREMISES = RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rule With Premises</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_WITH_PREMISES_FEATURE_COUNT = RULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.CheckRuleImpl <em>Check Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.CheckRuleImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getCheckRule()
   * @generated
   */
  int CHECK_RULE = 9;

  /**
   * The feature id for the '<em><b>Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RULE__OVERRIDE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RULE__NAME = 1;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RULE__ELEMENT = 2;

  /**
   * The feature id for the '<em><b>Premises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RULE__PREMISES = 3;

  /**
   * The number of structural features of the '<em>Check Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RULE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleConclusionImpl <em>Rule Conclusion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.RuleConclusionImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleConclusion()
   * @generated
   */
  int RULE_CONCLUSION = 10;

  /**
   * The feature id for the '<em><b>Environment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONCLUSION__ENVIRONMENT = 0;

  /**
   * The feature id for the '<em><b>Judgment Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONCLUSION__JUDGMENT_SYMBOL = 1;

  /**
   * The feature id for the '<em><b>Conclusion Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONCLUSION__CONCLUSION_ELEMENTS = 2;

  /**
   * The feature id for the '<em><b>Relation Symbols</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONCLUSION__RELATION_SYMBOLS = 3;

  /**
   * The feature id for the '<em><b>Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONCLUSION__ERROR = 4;

  /**
   * The number of structural features of the '<em>Rule Conclusion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONCLUSION_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleInvocationImpl <em>Rule Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.RuleInvocationImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleInvocation()
   * @generated
   */
  int RULE_INVOCATION = 11;

  /**
   * The feature id for the '<em><b>Environment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_INVOCATION__ENVIRONMENT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Judgment Symbol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_INVOCATION__JUDGMENT_SYMBOL = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_INVOCATION__EXPRESSIONS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Relation Symbols</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_INVOCATION__RELATION_SYMBOLS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Rule Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_INVOCATION_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentSpecificationImpl <em>Environment Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentSpecificationImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentSpecification()
   * @generated
   */
  int ENVIRONMENT_SPECIFICATION = 12;

  /**
   * The number of structural features of the '<em>Environment Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_SPECIFICATION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentReferenceImpl <em>Environment Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentReferenceImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentReference()
   * @generated
   */
  int ENVIRONMENT_REFERENCE = 13;

  /**
   * The feature id for the '<em><b>Environment</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_REFERENCE__ENVIRONMENT = ENVIRONMENT_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Environment Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_REFERENCE_FEATURE_COUNT = ENVIRONMENT_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentImpl <em>Environment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironment()
   * @generated
   */
  int ENVIRONMENT = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Environment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.ErrorSpecificationImpl <em>Error Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.ErrorSpecificationImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getErrorSpecification()
   * @generated
   */
  int ERROR_SPECIFICATION = 15;

  /**
   * The feature id for the '<em><b>Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_SPECIFICATION__ERROR = 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_SPECIFICATION__SOURCE = 1;

  /**
   * The feature id for the '<em><b>Feature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_SPECIFICATION__FEATURE = 2;

  /**
   * The number of structural features of the '<em>Error Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_SPECIFICATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleConclusionElementImpl <em>Rule Conclusion Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.RuleConclusionElementImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleConclusionElement()
   * @generated
   */
  int RULE_CONCLUSION_ELEMENT = 16;

  /**
   * The number of structural features of the '<em>Rule Conclusion Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONCLUSION_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleParameterImpl <em>Rule Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.RuleParameterImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleParameter()
   * @generated
   */
  int RULE_PARAMETER = 17;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_PARAMETER__PARAMETER = RULE_CONCLUSION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rule Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_PARAMETER_FEATURE_COUNT = RULE_CONCLUSION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.ExpressionInConclusionImpl <em>Expression In Conclusion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.ExpressionInConclusionImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getExpressionInConclusion()
   * @generated
   */
  int EXPRESSION_IN_CONCLUSION = 18;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_IN_CONCLUSION__EXPRESSION = RULE_CONCLUSION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression In Conclusion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_IN_CONCLUSION_FEATURE_COUNT = RULE_CONCLUSION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.OutputParameterImpl <em>Output Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.OutputParameterImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getOutputParameter()
   * @generated
   */
  int OUTPUT_PARAMETER = 19;

  /**
   * The feature id for the '<em><b>Jvm Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PARAMETER__JVM_TYPE_REFERENCE = JUDGMENT_PARAMETER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Output Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PARAMETER_FEATURE_COUNT = JUDGMENT_PARAMETER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.InputParameterImpl <em>Input Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.InputParameterImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getInputParameter()
   * @generated
   */
  int INPUT_PARAMETER = 20;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PARAMETER__PARAMETER = JUDGMENT_PARAMETER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Input Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PARAMETER_FEATURE_COUNT = JUDGMENT_PARAMETER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.OrExpressionImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 21;

  /**
   * The feature id for the '<em><b>Branches</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__BRANCHES = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.FailImpl <em>Fail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.FailImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getFail()
   * @generated
   */
  int FAIL = 22;

  /**
   * The feature id for the '<em><b>Error</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL__ERROR = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentAccessImpl <em>Environment Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentAccessImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentAccess()
   * @generated
   */
  int ENVIRONMENT_ACCESS = 23;

  /**
   * The feature id for the '<em><b>Environment</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_ACCESS__ENVIRONMENT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_ACCESS__ARGUMENT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_ACCESS__TYPE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Environment Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_ACCESS_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentCompositionImpl <em>Environment Composition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentCompositionImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentComposition()
   * @generated
   */
  int ENVIRONMENT_COMPOSITION = 24;

  /**
   * The feature id for the '<em><b>Current Environment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT = ENVIRONMENT_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sub Environment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT = ENVIRONMENT_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Environment Composition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_COMPOSITION_FEATURE_COUNT = ENVIRONMENT_SPECIFICATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.EmptyEnvironmentImpl <em>Empty Environment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.EmptyEnvironmentImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEmptyEnvironment()
   * @generated
   */
  int EMPTY_ENVIRONMENT = 25;

  /**
   * The number of structural features of the '<em>Empty Environment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMPTY_ENVIRONMENT_FEATURE_COUNT = ENVIRONMENT_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentMappingImpl <em>Environment Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentMappingImpl
   * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentMapping()
   * @generated
   */
  int ENVIRONMENT_MAPPING = 26;

  /**
   * The feature id for the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_MAPPING__KEY = ENVIRONMENT_SPECIFICATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_MAPPING__VALUE = ENVIRONMENT_SPECIFICATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Environment Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENVIRONMENT_MAPPING_FEATURE_COUNT = ENVIRONMENT_SPECIFICATION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem <em>System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>System</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem
   * @generated
   */
  EClass getXsemanticsSystem();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getName()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EAttribute getXsemanticsSystem_Name();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getSuperSystem <em>Super System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Super System</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getSuperSystem()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EReference getXsemanticsSystem_SuperSystem();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getValidatorExtends <em>Validator Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Validator Extends</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getValidatorExtends()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EReference getXsemanticsSystem_ValidatorExtends();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getImportSection <em>Import Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Import Section</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getImportSection()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EReference getXsemanticsSystem_ImportSection();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getInjections <em>Injections</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Injections</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getInjections()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EReference getXsemanticsSystem_Injections();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getAuxiliaryDescriptions <em>Auxiliary Descriptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Auxiliary Descriptions</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getAuxiliaryDescriptions()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EReference getXsemanticsSystem_AuxiliaryDescriptions();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getJudgmentDescriptions <em>Judgment Descriptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Judgment Descriptions</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getJudgmentDescriptions()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EReference getXsemanticsSystem_JudgmentDescriptions();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getAuxiliaryFunctions <em>Auxiliary Functions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Auxiliary Functions</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getAuxiliaryFunctions()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EReference getXsemanticsSystem_AuxiliaryFunctions();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getRules()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EReference getXsemanticsSystem_Rules();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.XsemanticsSystem#getCheckrules <em>Checkrules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Checkrules</em>'.
   * @see it.xsemantics.dsl.xsemantics.XsemanticsSystem#getCheckrules()
   * @see #getXsemanticsSystem()
   * @generated
   */
  EReference getXsemanticsSystem_Checkrules();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.Injected <em>Injected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Injected</em>'.
   * @see it.xsemantics.dsl.xsemantics.Injected
   * @generated
   */
  EClass getInjected();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.Injected#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see it.xsemantics.dsl.xsemantics.Injected#getType()
   * @see #getInjected()
   * @generated
   */
  EReference getInjected_Type();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.Injected#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.dsl.xsemantics.Injected#getName()
   * @see #getInjected()
   * @generated
   */
  EAttribute getInjected_Name();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.AuxiliaryDescription <em>Auxiliary Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Auxiliary Description</em>'.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryDescription
   * @generated
   */
  EClass getAuxiliaryDescription();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.AuxiliaryDescription#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryDescription#getName()
   * @see #getAuxiliaryDescription()
   * @generated
   */
  EAttribute getAuxiliaryDescription_Name();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.AuxiliaryDescription#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryDescription#getParameters()
   * @see #getAuxiliaryDescription()
   * @generated
   */
  EReference getAuxiliaryDescription_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.AuxiliaryDescription#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryDescription#getType()
   * @see #getAuxiliaryDescription()
   * @generated
   */
  EReference getAuxiliaryDescription_Type();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.AuxiliaryDescription#getError <em>Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Error</em>'.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryDescription#getError()
   * @see #getAuxiliaryDescription()
   * @generated
   */
  EReference getAuxiliaryDescription_Error();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription <em>Judgment Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Judgment Description</em>'.
   * @see it.xsemantics.dsl.xsemantics.JudgmentDescription
   * @generated
   */
  EClass getJudgmentDescription();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#isOverride <em>Override</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Override</em>'.
   * @see it.xsemantics.dsl.xsemantics.JudgmentDescription#isOverride()
   * @see #getJudgmentDescription()
   * @generated
   */
  EAttribute getJudgmentDescription_Override();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.dsl.xsemantics.JudgmentDescription#getName()
   * @see #getJudgmentDescription()
   * @generated
   */
  EAttribute getJudgmentDescription_Name();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getJudgmentSymbol <em>Judgment Symbol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Judgment Symbol</em>'.
   * @see it.xsemantics.dsl.xsemantics.JudgmentDescription#getJudgmentSymbol()
   * @see #getJudgmentDescription()
   * @generated
   */
  EAttribute getJudgmentDescription_JudgmentSymbol();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getJudgmentParameters <em>Judgment Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Judgment Parameters</em>'.
   * @see it.xsemantics.dsl.xsemantics.JudgmentDescription#getJudgmentParameters()
   * @see #getJudgmentDescription()
   * @generated
   */
  EReference getJudgmentDescription_JudgmentParameters();

  /**
   * Returns the meta object for the attribute list '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getRelationSymbols <em>Relation Symbols</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Relation Symbols</em>'.
   * @see it.xsemantics.dsl.xsemantics.JudgmentDescription#getRelationSymbols()
   * @see #getJudgmentDescription()
   * @generated
   */
  EAttribute getJudgmentDescription_RelationSymbols();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.JudgmentDescription#getError <em>Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Error</em>'.
   * @see it.xsemantics.dsl.xsemantics.JudgmentDescription#getError()
   * @see #getJudgmentDescription()
   * @generated
   */
  EReference getJudgmentDescription_Error();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.JudgmentParameter <em>Judgment Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Judgment Parameter</em>'.
   * @see it.xsemantics.dsl.xsemantics.JudgmentParameter
   * @generated
   */
  EClass getJudgmentParameter();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.AuxiliaryFunction <em>Auxiliary Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Auxiliary Function</em>'.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryFunction
   * @generated
   */
  EClass getAuxiliaryFunction();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.AuxiliaryFunction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryFunction#getName()
   * @see #getAuxiliaryFunction()
   * @generated
   */
  EAttribute getAuxiliaryFunction_Name();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.AuxiliaryFunction#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryFunction#getParameters()
   * @see #getAuxiliaryFunction()
   * @generated
   */
  EReference getAuxiliaryFunction_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.AuxiliaryFunction#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see it.xsemantics.dsl.xsemantics.AuxiliaryFunction#getBody()
   * @see #getAuxiliaryFunction()
   * @generated
   */
  EReference getAuxiliaryFunction_Body();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule</em>'.
   * @see it.xsemantics.dsl.xsemantics.Rule
   * @generated
   */
  EClass getRule();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.Rule#isOverride <em>Override</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Override</em>'.
   * @see it.xsemantics.dsl.xsemantics.Rule#isOverride()
   * @see #getRule()
   * @generated
   */
  EAttribute getRule_Override();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.Rule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.dsl.xsemantics.Rule#getName()
   * @see #getRule()
   * @generated
   */
  EAttribute getRule_Name();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.Rule#getConclusion <em>Conclusion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Conclusion</em>'.
   * @see it.xsemantics.dsl.xsemantics.Rule#getConclusion()
   * @see #getRule()
   * @generated
   */
  EReference getRule_Conclusion();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.Axiom <em>Axiom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Axiom</em>'.
   * @see it.xsemantics.dsl.xsemantics.Axiom
   * @generated
   */
  EClass getAxiom();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.RuleWithPremises <em>Rule With Premises</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule With Premises</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleWithPremises
   * @generated
   */
  EClass getRuleWithPremises();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.RuleWithPremises#getPremises <em>Premises</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Premises</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleWithPremises#getPremises()
   * @see #getRuleWithPremises()
   * @generated
   */
  EReference getRuleWithPremises_Premises();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.CheckRule <em>Check Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Check Rule</em>'.
   * @see it.xsemantics.dsl.xsemantics.CheckRule
   * @generated
   */
  EClass getCheckRule();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.CheckRule#isOverride <em>Override</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Override</em>'.
   * @see it.xsemantics.dsl.xsemantics.CheckRule#isOverride()
   * @see #getCheckRule()
   * @generated
   */
  EAttribute getCheckRule_Override();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.CheckRule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.dsl.xsemantics.CheckRule#getName()
   * @see #getCheckRule()
   * @generated
   */
  EAttribute getCheckRule_Name();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.CheckRule#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see it.xsemantics.dsl.xsemantics.CheckRule#getElement()
   * @see #getCheckRule()
   * @generated
   */
  EReference getCheckRule_Element();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.CheckRule#getPremises <em>Premises</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Premises</em>'.
   * @see it.xsemantics.dsl.xsemantics.CheckRule#getPremises()
   * @see #getCheckRule()
   * @generated
   */
  EReference getCheckRule_Premises();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.RuleConclusion <em>Rule Conclusion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Conclusion</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleConclusion
   * @generated
   */
  EClass getRuleConclusion();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getEnvironment <em>Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Environment</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleConclusion#getEnvironment()
   * @see #getRuleConclusion()
   * @generated
   */
  EReference getRuleConclusion_Environment();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getJudgmentSymbol <em>Judgment Symbol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Judgment Symbol</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleConclusion#getJudgmentSymbol()
   * @see #getRuleConclusion()
   * @generated
   */
  EAttribute getRuleConclusion_JudgmentSymbol();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getConclusionElements <em>Conclusion Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Conclusion Elements</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleConclusion#getConclusionElements()
   * @see #getRuleConclusion()
   * @generated
   */
  EReference getRuleConclusion_ConclusionElements();

  /**
   * Returns the meta object for the attribute list '{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getRelationSymbols <em>Relation Symbols</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Relation Symbols</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleConclusion#getRelationSymbols()
   * @see #getRuleConclusion()
   * @generated
   */
  EAttribute getRuleConclusion_RelationSymbols();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.RuleConclusion#getError <em>Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Error</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleConclusion#getError()
   * @see #getRuleConclusion()
   * @generated
   */
  EReference getRuleConclusion_Error();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.RuleInvocation <em>Rule Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Invocation</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleInvocation
   * @generated
   */
  EClass getRuleInvocation();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getEnvironment <em>Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Environment</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleInvocation#getEnvironment()
   * @see #getRuleInvocation()
   * @generated
   */
  EReference getRuleInvocation_Environment();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getJudgmentSymbol <em>Judgment Symbol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Judgment Symbol</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleInvocation#getJudgmentSymbol()
   * @see #getRuleInvocation()
   * @generated
   */
  EAttribute getRuleInvocation_JudgmentSymbol();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleInvocation#getExpressions()
   * @see #getRuleInvocation()
   * @generated
   */
  EReference getRuleInvocation_Expressions();

  /**
   * Returns the meta object for the attribute list '{@link it.xsemantics.dsl.xsemantics.RuleInvocation#getRelationSymbols <em>Relation Symbols</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Relation Symbols</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleInvocation#getRelationSymbols()
   * @see #getRuleInvocation()
   * @generated
   */
  EAttribute getRuleInvocation_RelationSymbols();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.EnvironmentSpecification <em>Environment Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Environment Specification</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentSpecification
   * @generated
   */
  EClass getEnvironmentSpecification();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.EnvironmentReference <em>Environment Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Environment Reference</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentReference
   * @generated
   */
  EClass getEnvironmentReference();

  /**
   * Returns the meta object for the reference '{@link it.xsemantics.dsl.xsemantics.EnvironmentReference#getEnvironment <em>Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Environment</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentReference#getEnvironment()
   * @see #getEnvironmentReference()
   * @generated
   */
  EReference getEnvironmentReference_Environment();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.Environment <em>Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Environment</em>'.
   * @see it.xsemantics.dsl.xsemantics.Environment
   * @generated
   */
  EClass getEnvironment();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.dsl.xsemantics.Environment#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.dsl.xsemantics.Environment#getName()
   * @see #getEnvironment()
   * @generated
   */
  EAttribute getEnvironment_Name();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.ErrorSpecification <em>Error Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Specification</em>'.
   * @see it.xsemantics.dsl.xsemantics.ErrorSpecification
   * @generated
   */
  EClass getErrorSpecification();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.ErrorSpecification#getError <em>Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Error</em>'.
   * @see it.xsemantics.dsl.xsemantics.ErrorSpecification#getError()
   * @see #getErrorSpecification()
   * @generated
   */
  EReference getErrorSpecification_Error();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.ErrorSpecification#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see it.xsemantics.dsl.xsemantics.ErrorSpecification#getSource()
   * @see #getErrorSpecification()
   * @generated
   */
  EReference getErrorSpecification_Source();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.ErrorSpecification#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Feature</em>'.
   * @see it.xsemantics.dsl.xsemantics.ErrorSpecification#getFeature()
   * @see #getErrorSpecification()
   * @generated
   */
  EReference getErrorSpecification_Feature();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.RuleConclusionElement <em>Rule Conclusion Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Conclusion Element</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleConclusionElement
   * @generated
   */
  EClass getRuleConclusionElement();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.RuleParameter <em>Rule Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Parameter</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleParameter
   * @generated
   */
  EClass getRuleParameter();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.RuleParameter#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameter</em>'.
   * @see it.xsemantics.dsl.xsemantics.RuleParameter#getParameter()
   * @see #getRuleParameter()
   * @generated
   */
  EReference getRuleParameter_Parameter();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.ExpressionInConclusion <em>Expression In Conclusion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression In Conclusion</em>'.
   * @see it.xsemantics.dsl.xsemantics.ExpressionInConclusion
   * @generated
   */
  EClass getExpressionInConclusion();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.ExpressionInConclusion#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see it.xsemantics.dsl.xsemantics.ExpressionInConclusion#getExpression()
   * @see #getExpressionInConclusion()
   * @generated
   */
  EReference getExpressionInConclusion_Expression();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.OutputParameter <em>Output Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output Parameter</em>'.
   * @see it.xsemantics.dsl.xsemantics.OutputParameter
   * @generated
   */
  EClass getOutputParameter();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.OutputParameter#getJvmTypeReference <em>Jvm Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Jvm Type Reference</em>'.
   * @see it.xsemantics.dsl.xsemantics.OutputParameter#getJvmTypeReference()
   * @see #getOutputParameter()
   * @generated
   */
  EReference getOutputParameter_JvmTypeReference();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.InputParameter <em>Input Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Parameter</em>'.
   * @see it.xsemantics.dsl.xsemantics.InputParameter
   * @generated
   */
  EClass getInputParameter();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.InputParameter#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameter</em>'.
   * @see it.xsemantics.dsl.xsemantics.InputParameter#getParameter()
   * @see #getInputParameter()
   * @generated
   */
  EReference getInputParameter_Parameter();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see it.xsemantics.dsl.xsemantics.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.dsl.xsemantics.OrExpression#getBranches <em>Branches</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Branches</em>'.
   * @see it.xsemantics.dsl.xsemantics.OrExpression#getBranches()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Branches();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.Fail <em>Fail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fail</em>'.
   * @see it.xsemantics.dsl.xsemantics.Fail
   * @generated
   */
  EClass getFail();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.Fail#getError <em>Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Error</em>'.
   * @see it.xsemantics.dsl.xsemantics.Fail#getError()
   * @see #getFail()
   * @generated
   */
  EReference getFail_Error();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess <em>Environment Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Environment Access</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentAccess
   * @generated
   */
  EClass getEnvironmentAccess();

  /**
   * Returns the meta object for the reference '{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess#getEnvironment <em>Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Environment</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentAccess#getEnvironment()
   * @see #getEnvironmentAccess()
   * @generated
   */
  EReference getEnvironmentAccess_Environment();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentAccess#getArgument()
   * @see #getEnvironmentAccess()
   * @generated
   */
  EReference getEnvironmentAccess_Argument();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.EnvironmentAccess#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentAccess#getType()
   * @see #getEnvironmentAccess()
   * @generated
   */
  EReference getEnvironmentAccess_Type();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.EnvironmentComposition <em>Environment Composition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Environment Composition</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentComposition
   * @generated
   */
  EClass getEnvironmentComposition();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.EnvironmentComposition#getCurrentEnvironment <em>Current Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Current Environment</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentComposition#getCurrentEnvironment()
   * @see #getEnvironmentComposition()
   * @generated
   */
  EReference getEnvironmentComposition_CurrentEnvironment();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.EnvironmentComposition#getSubEnvironment <em>Sub Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Environment</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentComposition#getSubEnvironment()
   * @see #getEnvironmentComposition()
   * @generated
   */
  EReference getEnvironmentComposition_SubEnvironment();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.EmptyEnvironment <em>Empty Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Empty Environment</em>'.
   * @see it.xsemantics.dsl.xsemantics.EmptyEnvironment
   * @generated
   */
  EClass getEmptyEnvironment();

  /**
   * Returns the meta object for class '{@link it.xsemantics.dsl.xsemantics.EnvironmentMapping <em>Environment Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Environment Mapping</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentMapping
   * @generated
   */
  EClass getEnvironmentMapping();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.EnvironmentMapping#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Key</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentMapping#getKey()
   * @see #getEnvironmentMapping()
   * @generated
   */
  EReference getEnvironmentMapping_Key();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.dsl.xsemantics.EnvironmentMapping#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see it.xsemantics.dsl.xsemantics.EnvironmentMapping#getValue()
   * @see #getEnvironmentMapping()
   * @generated
   */
  EReference getEnvironmentMapping_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XsemanticsFactory getXsemanticsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl <em>System</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsSystemImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getXsemanticsSystem()
     * @generated
     */
    EClass XSEMANTICS_SYSTEM = eINSTANCE.getXsemanticsSystem();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XSEMANTICS_SYSTEM__NAME = eINSTANCE.getXsemanticsSystem_Name();

    /**
     * The meta object literal for the '<em><b>Super System</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSEMANTICS_SYSTEM__SUPER_SYSTEM = eINSTANCE.getXsemanticsSystem_SuperSystem();

    /**
     * The meta object literal for the '<em><b>Validator Extends</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSEMANTICS_SYSTEM__VALIDATOR_EXTENDS = eINSTANCE.getXsemanticsSystem_ValidatorExtends();

    /**
     * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSEMANTICS_SYSTEM__IMPORT_SECTION = eINSTANCE.getXsemanticsSystem_ImportSection();

    /**
     * The meta object literal for the '<em><b>Injections</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSEMANTICS_SYSTEM__INJECTIONS = eINSTANCE.getXsemanticsSystem_Injections();

    /**
     * The meta object literal for the '<em><b>Auxiliary Descriptions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSEMANTICS_SYSTEM__AUXILIARY_DESCRIPTIONS = eINSTANCE.getXsemanticsSystem_AuxiliaryDescriptions();

    /**
     * The meta object literal for the '<em><b>Judgment Descriptions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSEMANTICS_SYSTEM__JUDGMENT_DESCRIPTIONS = eINSTANCE.getXsemanticsSystem_JudgmentDescriptions();

    /**
     * The meta object literal for the '<em><b>Auxiliary Functions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSEMANTICS_SYSTEM__AUXILIARY_FUNCTIONS = eINSTANCE.getXsemanticsSystem_AuxiliaryFunctions();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSEMANTICS_SYSTEM__RULES = eINSTANCE.getXsemanticsSystem_Rules();

    /**
     * The meta object literal for the '<em><b>Checkrules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSEMANTICS_SYSTEM__CHECKRULES = eINSTANCE.getXsemanticsSystem_Checkrules();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.InjectedImpl <em>Injected</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.InjectedImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getInjected()
     * @generated
     */
    EClass INJECTED = eINSTANCE.getInjected();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INJECTED__TYPE = eINSTANCE.getInjected_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INJECTED__NAME = eINSTANCE.getInjected_Name();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.AuxiliaryDescriptionImpl <em>Auxiliary Description</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.AuxiliaryDescriptionImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getAuxiliaryDescription()
     * @generated
     */
    EClass AUXILIARY_DESCRIPTION = eINSTANCE.getAuxiliaryDescription();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUXILIARY_DESCRIPTION__NAME = eINSTANCE.getAuxiliaryDescription_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUXILIARY_DESCRIPTION__PARAMETERS = eINSTANCE.getAuxiliaryDescription_Parameters();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUXILIARY_DESCRIPTION__TYPE = eINSTANCE.getAuxiliaryDescription_Type();

    /**
     * The meta object literal for the '<em><b>Error</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUXILIARY_DESCRIPTION__ERROR = eINSTANCE.getAuxiliaryDescription_Error();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl <em>Judgment Description</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.JudgmentDescriptionImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getJudgmentDescription()
     * @generated
     */
    EClass JUDGMENT_DESCRIPTION = eINSTANCE.getJudgmentDescription();

    /**
     * The meta object literal for the '<em><b>Override</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUDGMENT_DESCRIPTION__OVERRIDE = eINSTANCE.getJudgmentDescription_Override();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUDGMENT_DESCRIPTION__NAME = eINSTANCE.getJudgmentDescription_Name();

    /**
     * The meta object literal for the '<em><b>Judgment Symbol</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUDGMENT_DESCRIPTION__JUDGMENT_SYMBOL = eINSTANCE.getJudgmentDescription_JudgmentSymbol();

    /**
     * The meta object literal for the '<em><b>Judgment Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JUDGMENT_DESCRIPTION__JUDGMENT_PARAMETERS = eINSTANCE.getJudgmentDescription_JudgmentParameters();

    /**
     * The meta object literal for the '<em><b>Relation Symbols</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JUDGMENT_DESCRIPTION__RELATION_SYMBOLS = eINSTANCE.getJudgmentDescription_RelationSymbols();

    /**
     * The meta object literal for the '<em><b>Error</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JUDGMENT_DESCRIPTION__ERROR = eINSTANCE.getJudgmentDescription_Error();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.JudgmentParameterImpl <em>Judgment Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.JudgmentParameterImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getJudgmentParameter()
     * @generated
     */
    EClass JUDGMENT_PARAMETER = eINSTANCE.getJudgmentParameter();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.AuxiliaryFunctionImpl <em>Auxiliary Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.AuxiliaryFunctionImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getAuxiliaryFunction()
     * @generated
     */
    EClass AUXILIARY_FUNCTION = eINSTANCE.getAuxiliaryFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUXILIARY_FUNCTION__NAME = eINSTANCE.getAuxiliaryFunction_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUXILIARY_FUNCTION__PARAMETERS = eINSTANCE.getAuxiliaryFunction_Parameters();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUXILIARY_FUNCTION__BODY = eINSTANCE.getAuxiliaryFunction_Body();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.RuleImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRule()
     * @generated
     */
    EClass RULE = eINSTANCE.getRule();

    /**
     * The meta object literal for the '<em><b>Override</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE__OVERRIDE = eINSTANCE.getRule_Override();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE__NAME = eINSTANCE.getRule_Name();

    /**
     * The meta object literal for the '<em><b>Conclusion</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__CONCLUSION = eINSTANCE.getRule_Conclusion();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.AxiomImpl <em>Axiom</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.AxiomImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getAxiom()
     * @generated
     */
    EClass AXIOM = eINSTANCE.getAxiom();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleWithPremisesImpl <em>Rule With Premises</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.RuleWithPremisesImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleWithPremises()
     * @generated
     */
    EClass RULE_WITH_PREMISES = eINSTANCE.getRuleWithPremises();

    /**
     * The meta object literal for the '<em><b>Premises</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_WITH_PREMISES__PREMISES = eINSTANCE.getRuleWithPremises_Premises();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.CheckRuleImpl <em>Check Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.CheckRuleImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getCheckRule()
     * @generated
     */
    EClass CHECK_RULE = eINSTANCE.getCheckRule();

    /**
     * The meta object literal for the '<em><b>Override</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHECK_RULE__OVERRIDE = eINSTANCE.getCheckRule_Override();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHECK_RULE__NAME = eINSTANCE.getCheckRule_Name();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHECK_RULE__ELEMENT = eINSTANCE.getCheckRule_Element();

    /**
     * The meta object literal for the '<em><b>Premises</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHECK_RULE__PREMISES = eINSTANCE.getCheckRule_Premises();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleConclusionImpl <em>Rule Conclusion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.RuleConclusionImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleConclusion()
     * @generated
     */
    EClass RULE_CONCLUSION = eINSTANCE.getRuleConclusion();

    /**
     * The meta object literal for the '<em><b>Environment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CONCLUSION__ENVIRONMENT = eINSTANCE.getRuleConclusion_Environment();

    /**
     * The meta object literal for the '<em><b>Judgment Symbol</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_CONCLUSION__JUDGMENT_SYMBOL = eINSTANCE.getRuleConclusion_JudgmentSymbol();

    /**
     * The meta object literal for the '<em><b>Conclusion Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CONCLUSION__CONCLUSION_ELEMENTS = eINSTANCE.getRuleConclusion_ConclusionElements();

    /**
     * The meta object literal for the '<em><b>Relation Symbols</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_CONCLUSION__RELATION_SYMBOLS = eINSTANCE.getRuleConclusion_RelationSymbols();

    /**
     * The meta object literal for the '<em><b>Error</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CONCLUSION__ERROR = eINSTANCE.getRuleConclusion_Error();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleInvocationImpl <em>Rule Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.RuleInvocationImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleInvocation()
     * @generated
     */
    EClass RULE_INVOCATION = eINSTANCE.getRuleInvocation();

    /**
     * The meta object literal for the '<em><b>Environment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_INVOCATION__ENVIRONMENT = eINSTANCE.getRuleInvocation_Environment();

    /**
     * The meta object literal for the '<em><b>Judgment Symbol</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_INVOCATION__JUDGMENT_SYMBOL = eINSTANCE.getRuleInvocation_JudgmentSymbol();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_INVOCATION__EXPRESSIONS = eINSTANCE.getRuleInvocation_Expressions();

    /**
     * The meta object literal for the '<em><b>Relation Symbols</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_INVOCATION__RELATION_SYMBOLS = eINSTANCE.getRuleInvocation_RelationSymbols();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentSpecificationImpl <em>Environment Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentSpecificationImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentSpecification()
     * @generated
     */
    EClass ENVIRONMENT_SPECIFICATION = eINSTANCE.getEnvironmentSpecification();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentReferenceImpl <em>Environment Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentReferenceImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentReference()
     * @generated
     */
    EClass ENVIRONMENT_REFERENCE = eINSTANCE.getEnvironmentReference();

    /**
     * The meta object literal for the '<em><b>Environment</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENVIRONMENT_REFERENCE__ENVIRONMENT = eINSTANCE.getEnvironmentReference_Environment();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentImpl <em>Environment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironment()
     * @generated
     */
    EClass ENVIRONMENT = eINSTANCE.getEnvironment();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENVIRONMENT__NAME = eINSTANCE.getEnvironment_Name();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.ErrorSpecificationImpl <em>Error Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.ErrorSpecificationImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getErrorSpecification()
     * @generated
     */
    EClass ERROR_SPECIFICATION = eINSTANCE.getErrorSpecification();

    /**
     * The meta object literal for the '<em><b>Error</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_SPECIFICATION__ERROR = eINSTANCE.getErrorSpecification_Error();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_SPECIFICATION__SOURCE = eINSTANCE.getErrorSpecification_Source();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_SPECIFICATION__FEATURE = eINSTANCE.getErrorSpecification_Feature();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleConclusionElementImpl <em>Rule Conclusion Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.RuleConclusionElementImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleConclusionElement()
     * @generated
     */
    EClass RULE_CONCLUSION_ELEMENT = eINSTANCE.getRuleConclusionElement();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.RuleParameterImpl <em>Rule Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.RuleParameterImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getRuleParameter()
     * @generated
     */
    EClass RULE_PARAMETER = eINSTANCE.getRuleParameter();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_PARAMETER__PARAMETER = eINSTANCE.getRuleParameter_Parameter();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.ExpressionInConclusionImpl <em>Expression In Conclusion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.ExpressionInConclusionImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getExpressionInConclusion()
     * @generated
     */
    EClass EXPRESSION_IN_CONCLUSION = eINSTANCE.getExpressionInConclusion();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_IN_CONCLUSION__EXPRESSION = eINSTANCE.getExpressionInConclusion_Expression();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.OutputParameterImpl <em>Output Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.OutputParameterImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getOutputParameter()
     * @generated
     */
    EClass OUTPUT_PARAMETER = eINSTANCE.getOutputParameter();

    /**
     * The meta object literal for the '<em><b>Jvm Type Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_PARAMETER__JVM_TYPE_REFERENCE = eINSTANCE.getOutputParameter_JvmTypeReference();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.InputParameterImpl <em>Input Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.InputParameterImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getInputParameter()
     * @generated
     */
    EClass INPUT_PARAMETER = eINSTANCE.getInputParameter();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_PARAMETER__PARAMETER = eINSTANCE.getInputParameter_Parameter();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.OrExpressionImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Branches</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__BRANCHES = eINSTANCE.getOrExpression_Branches();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.FailImpl <em>Fail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.FailImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getFail()
     * @generated
     */
    EClass FAIL = eINSTANCE.getFail();

    /**
     * The meta object literal for the '<em><b>Error</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAIL__ERROR = eINSTANCE.getFail_Error();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentAccessImpl <em>Environment Access</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentAccessImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentAccess()
     * @generated
     */
    EClass ENVIRONMENT_ACCESS = eINSTANCE.getEnvironmentAccess();

    /**
     * The meta object literal for the '<em><b>Environment</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENVIRONMENT_ACCESS__ENVIRONMENT = eINSTANCE.getEnvironmentAccess_Environment();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENVIRONMENT_ACCESS__ARGUMENT = eINSTANCE.getEnvironmentAccess_Argument();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENVIRONMENT_ACCESS__TYPE = eINSTANCE.getEnvironmentAccess_Type();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentCompositionImpl <em>Environment Composition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentCompositionImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentComposition()
     * @generated
     */
    EClass ENVIRONMENT_COMPOSITION = eINSTANCE.getEnvironmentComposition();

    /**
     * The meta object literal for the '<em><b>Current Environment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENVIRONMENT_COMPOSITION__CURRENT_ENVIRONMENT = eINSTANCE.getEnvironmentComposition_CurrentEnvironment();

    /**
     * The meta object literal for the '<em><b>Sub Environment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENVIRONMENT_COMPOSITION__SUB_ENVIRONMENT = eINSTANCE.getEnvironmentComposition_SubEnvironment();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.EmptyEnvironmentImpl <em>Empty Environment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.EmptyEnvironmentImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEmptyEnvironment()
     * @generated
     */
    EClass EMPTY_ENVIRONMENT = eINSTANCE.getEmptyEnvironment();

    /**
     * The meta object literal for the '{@link it.xsemantics.dsl.xsemantics.impl.EnvironmentMappingImpl <em>Environment Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.dsl.xsemantics.impl.EnvironmentMappingImpl
     * @see it.xsemantics.dsl.xsemantics.impl.XsemanticsPackageImpl#getEnvironmentMapping()
     * @generated
     */
    EClass ENVIRONMENT_MAPPING = eINSTANCE.getEnvironmentMapping();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENVIRONMENT_MAPPING__KEY = eINSTANCE.getEnvironmentMapping_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENVIRONMENT_MAPPING__VALUE = eINSTANCE.getEnvironmentMapping_Value();

  }

} //XsemanticsPackage
