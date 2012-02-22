/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.fj.fj;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see it.xsemantics.example.fj.fj.FjFactory
 * @model kind="package"
 * @generated
 */
public interface FjPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "fj";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://xsemantics.sf.net/example/fj/FJ";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fj";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FjPackage eINSTANCE = it.xsemantics.example.fj.fj.impl.FjPackageImpl.init();

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.ProgramImpl <em>Program</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.ProgramImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getProgram()
   * @generated
   */
  int PROGRAM = 0;

  /**
   * The feature id for the '<em><b>Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM__CLASSES = 0;

  /**
   * The feature id for the '<em><b>Main</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM__MAIN = 1;

  /**
   * The number of structural features of the '<em>Program</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.TypeImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getType()
   * @generated
   */
  int TYPE = 1;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.BasicTypeImpl <em>Basic Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.BasicTypeImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getBasicType()
   * @generated
   */
  int BASIC_TYPE = 2;

  /**
   * The feature id for the '<em><b>Basic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_TYPE__BASIC = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Basic Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.ClassTypeImpl <em>Class Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.ClassTypeImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getClassType()
   * @generated
   */
  int CLASS_TYPE = 3;

  /**
   * The feature id for the '<em><b>Classref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE__CLASSREF = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Class Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.ClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.ClassImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getClass_()
   * @generated
   */
  int CLASS = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__NAME = 0;

  /**
   * The feature id for the '<em><b>Superclass</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__SUPERCLASS = 1;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__MEMBERS = 2;

  /**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.TypedElementImpl <em>Typed Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.TypedElementImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getTypedElement()
   * @generated
   */
  int TYPED_ELEMENT = 9;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_ELEMENT__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_ELEMENT__NAME = 1;

  /**
   * The number of structural features of the '<em>Typed Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.MemberImpl <em>Member</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.MemberImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getMember()
   * @generated
   */
  int MEMBER = 5;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER__TYPE = TYPED_ELEMENT__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER__NAME = TYPED_ELEMENT__NAME;

  /**
   * The number of structural features of the '<em>Member</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.FieldImpl <em>Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.FieldImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getField()
   * @generated
   */
  int FIELD = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__TYPE = MEMBER__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__NAME = MEMBER__NAME;

  /**
   * The number of structural features of the '<em>Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.MethodImpl <em>Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.MethodImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getMethod()
   * @generated
   */
  int METHOD = 7;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__TYPE = MEMBER__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__NAME = MEMBER__NAME;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__PARAMS = MEMBER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__BODY = MEMBER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.ParameterImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 8;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__TYPE = TYPED_ELEMENT__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = TYPED_ELEMENT__NAME;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.MethodBodyImpl <em>Method Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.MethodBodyImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getMethodBody()
   * @generated
   */
  int METHOD_BODY = 10;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_BODY__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Method Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_BODY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.ExpressionImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 11;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.ThisImpl <em>This</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.ThisImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getThis()
   * @generated
   */
  int THIS = 12;

  /**
   * The feature id for the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIS__VARIABLE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>This</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.ParamRefImpl <em>Param Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.ParamRefImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getParamRef()
   * @generated
   */
  int PARAM_REF = 13;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_REF__PARAMETER = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Param Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.NewImpl <em>New</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.NewImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getNew()
   * @generated
   */
  int NEW = 14;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW__TYPE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW__ARGS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>New</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEW_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.CastImpl <em>Cast</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.CastImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getCast()
   * @generated
   */
  int CAST = 15;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST__TYPE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST__EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cast</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.ConstantImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 16;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.StringConstantImpl <em>String Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.StringConstantImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getStringConstant()
   * @generated
   */
  int STRING_CONSTANT = 17;

  /**
   * The feature id for the '<em><b>Constant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_CONSTANT__CONSTANT = CONSTANT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_CONSTANT_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.IntConstantImpl <em>Int Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.IntConstantImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getIntConstant()
   * @generated
   */
  int INT_CONSTANT = 18;

  /**
   * The feature id for the '<em><b>Constant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CONSTANT__CONSTANT = CONSTANT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CONSTANT_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.BoolConstantImpl <em>Bool Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.BoolConstantImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getBoolConstant()
   * @generated
   */
  int BOOL_CONSTANT = 19;

  /**
   * The feature id for the '<em><b>Constant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_CONSTANT__CONSTANT = CONSTANT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bool Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_CONSTANT_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.fj.fj.impl.SelectionImpl <em>Selection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.fj.fj.impl.SelectionImpl
   * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getSelection()
   * @generated
   */
  int SELECTION = 20;

  /**
   * The feature id for the '<em><b>Receiver</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__RECEIVER = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Message</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__MESSAGE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__ARGS = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Selection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program</em>'.
   * @see it.xsemantics.example.fj.fj.Program
   * @generated
   */
  EClass getProgram();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.example.fj.fj.Program#getClasses <em>Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classes</em>'.
   * @see it.xsemantics.example.fj.fj.Program#getClasses()
   * @see #getProgram()
   * @generated
   */
  EReference getProgram_Classes();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.fj.fj.Program#getMain <em>Main</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Main</em>'.
   * @see it.xsemantics.example.fj.fj.Program#getMain()
   * @see #getProgram()
   * @generated
   */
  EReference getProgram_Main();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see it.xsemantics.example.fj.fj.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.BasicType <em>Basic Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Type</em>'.
   * @see it.xsemantics.example.fj.fj.BasicType
   * @generated
   */
  EClass getBasicType();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.fj.fj.BasicType#getBasic <em>Basic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Basic</em>'.
   * @see it.xsemantics.example.fj.fj.BasicType#getBasic()
   * @see #getBasicType()
   * @generated
   */
  EAttribute getBasicType_Basic();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.ClassType <em>Class Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Type</em>'.
   * @see it.xsemantics.example.fj.fj.ClassType
   * @generated
   */
  EClass getClassType();

  /**
   * Returns the meta object for the reference '{@link it.xsemantics.example.fj.fj.ClassType#getClassref <em>Classref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Classref</em>'.
   * @see it.xsemantics.example.fj.fj.ClassType#getClassref()
   * @see #getClassType()
   * @generated
   */
  EReference getClassType_Classref();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class</em>'.
   * @see it.xsemantics.example.fj.fj.Class
   * @generated
   */
  EClass getClass_();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.fj.fj.Class#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.example.fj.fj.Class#getName()
   * @see #getClass_()
   * @generated
   */
  EAttribute getClass_Name();

  /**
   * Returns the meta object for the reference '{@link it.xsemantics.example.fj.fj.Class#getSuperclass <em>Superclass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Superclass</em>'.
   * @see it.xsemantics.example.fj.fj.Class#getSuperclass()
   * @see #getClass_()
   * @generated
   */
  EReference getClass_Superclass();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.example.fj.fj.Class#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see it.xsemantics.example.fj.fj.Class#getMembers()
   * @see #getClass_()
   * @generated
   */
  EReference getClass_Members();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Member <em>Member</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Member</em>'.
   * @see it.xsemantics.example.fj.fj.Member
   * @generated
   */
  EClass getMember();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Field <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field</em>'.
   * @see it.xsemantics.example.fj.fj.Field
   * @generated
   */
  EClass getField();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Method <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method</em>'.
   * @see it.xsemantics.example.fj.fj.Method
   * @generated
   */
  EClass getMethod();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.example.fj.fj.Method#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see it.xsemantics.example.fj.fj.Method#getParams()
   * @see #getMethod()
   * @generated
   */
  EReference getMethod_Params();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.fj.fj.Method#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see it.xsemantics.example.fj.fj.Method#getBody()
   * @see #getMethod()
   * @generated
   */
  EReference getMethod_Body();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see it.xsemantics.example.fj.fj.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.TypedElement <em>Typed Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typed Element</em>'.
   * @see it.xsemantics.example.fj.fj.TypedElement
   * @generated
   */
  EClass getTypedElement();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.fj.fj.TypedElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see it.xsemantics.example.fj.fj.TypedElement#getType()
   * @see #getTypedElement()
   * @generated
   */
  EReference getTypedElement_Type();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.fj.fj.TypedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.example.fj.fj.TypedElement#getName()
   * @see #getTypedElement()
   * @generated
   */
  EAttribute getTypedElement_Name();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.MethodBody <em>Method Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Body</em>'.
   * @see it.xsemantics.example.fj.fj.MethodBody
   * @generated
   */
  EClass getMethodBody();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.fj.fj.MethodBody#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see it.xsemantics.example.fj.fj.MethodBody#getExpression()
   * @see #getMethodBody()
   * @generated
   */
  EReference getMethodBody_Expression();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see it.xsemantics.example.fj.fj.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.This <em>This</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>This</em>'.
   * @see it.xsemantics.example.fj.fj.This
   * @generated
   */
  EClass getThis();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.fj.fj.This#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable</em>'.
   * @see it.xsemantics.example.fj.fj.This#getVariable()
   * @see #getThis()
   * @generated
   */
  EAttribute getThis_Variable();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.ParamRef <em>Param Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param Ref</em>'.
   * @see it.xsemantics.example.fj.fj.ParamRef
   * @generated
   */
  EClass getParamRef();

  /**
   * Returns the meta object for the reference '{@link it.xsemantics.example.fj.fj.ParamRef#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter</em>'.
   * @see it.xsemantics.example.fj.fj.ParamRef#getParameter()
   * @see #getParamRef()
   * @generated
   */
  EReference getParamRef_Parameter();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.New <em>New</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>New</em>'.
   * @see it.xsemantics.example.fj.fj.New
   * @generated
   */
  EClass getNew();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.fj.fj.New#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see it.xsemantics.example.fj.fj.New#getType()
   * @see #getNew()
   * @generated
   */
  EReference getNew_Type();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.example.fj.fj.New#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see it.xsemantics.example.fj.fj.New#getArgs()
   * @see #getNew()
   * @generated
   */
  EReference getNew_Args();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Cast <em>Cast</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cast</em>'.
   * @see it.xsemantics.example.fj.fj.Cast
   * @generated
   */
  EClass getCast();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.fj.fj.Cast#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see it.xsemantics.example.fj.fj.Cast#getType()
   * @see #getCast()
   * @generated
   */
  EReference getCast_Type();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.fj.fj.Cast#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see it.xsemantics.example.fj.fj.Cast#getExpression()
   * @see #getCast()
   * @generated
   */
  EReference getCast_Expression();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see it.xsemantics.example.fj.fj.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.StringConstant <em>String Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Constant</em>'.
   * @see it.xsemantics.example.fj.fj.StringConstant
   * @generated
   */
  EClass getStringConstant();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.fj.fj.StringConstant#getConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constant</em>'.
   * @see it.xsemantics.example.fj.fj.StringConstant#getConstant()
   * @see #getStringConstant()
   * @generated
   */
  EAttribute getStringConstant_Constant();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.IntConstant <em>Int Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Constant</em>'.
   * @see it.xsemantics.example.fj.fj.IntConstant
   * @generated
   */
  EClass getIntConstant();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.fj.fj.IntConstant#getConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constant</em>'.
   * @see it.xsemantics.example.fj.fj.IntConstant#getConstant()
   * @see #getIntConstant()
   * @generated
   */
  EAttribute getIntConstant_Constant();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.BoolConstant <em>Bool Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Constant</em>'.
   * @see it.xsemantics.example.fj.fj.BoolConstant
   * @generated
   */
  EClass getBoolConstant();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.fj.fj.BoolConstant#getConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constant</em>'.
   * @see it.xsemantics.example.fj.fj.BoolConstant#getConstant()
   * @see #getBoolConstant()
   * @generated
   */
  EAttribute getBoolConstant_Constant();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.fj.fj.Selection <em>Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selection</em>'.
   * @see it.xsemantics.example.fj.fj.Selection
   * @generated
   */
  EClass getSelection();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.fj.fj.Selection#getReceiver <em>Receiver</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Receiver</em>'.
   * @see it.xsemantics.example.fj.fj.Selection#getReceiver()
   * @see #getSelection()
   * @generated
   */
  EReference getSelection_Receiver();

  /**
   * Returns the meta object for the reference '{@link it.xsemantics.example.fj.fj.Selection#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Message</em>'.
   * @see it.xsemantics.example.fj.fj.Selection#getMessage()
   * @see #getSelection()
   * @generated
   */
  EReference getSelection_Message();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.example.fj.fj.Selection#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see it.xsemantics.example.fj.fj.Selection#getArgs()
   * @see #getSelection()
   * @generated
   */
  EReference getSelection_Args();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FjFactory getFjFactory();

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
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.ProgramImpl <em>Program</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.ProgramImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getProgram()
     * @generated
     */
    EClass PROGRAM = eINSTANCE.getProgram();

    /**
     * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROGRAM__CLASSES = eINSTANCE.getProgram_Classes();

    /**
     * The meta object literal for the '<em><b>Main</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROGRAM__MAIN = eINSTANCE.getProgram_Main();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.TypeImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.BasicTypeImpl <em>Basic Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.BasicTypeImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getBasicType()
     * @generated
     */
    EClass BASIC_TYPE = eINSTANCE.getBasicType();

    /**
     * The meta object literal for the '<em><b>Basic</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASIC_TYPE__BASIC = eINSTANCE.getBasicType_Basic();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.ClassTypeImpl <em>Class Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.ClassTypeImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getClassType()
     * @generated
     */
    EClass CLASS_TYPE = eINSTANCE.getClassType();

    /**
     * The meta object literal for the '<em><b>Classref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_TYPE__CLASSREF = eINSTANCE.getClassType_Classref();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.ClassImpl <em>Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.ClassImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getClass_()
     * @generated
     */
    EClass CLASS = eINSTANCE.getClass_();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS__NAME = eINSTANCE.getClass_Name();

    /**
     * The meta object literal for the '<em><b>Superclass</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__SUPERCLASS = eINSTANCE.getClass_Superclass();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__MEMBERS = eINSTANCE.getClass_Members();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.MemberImpl <em>Member</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.MemberImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getMember()
     * @generated
     */
    EClass MEMBER = eINSTANCE.getMember();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.FieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.FieldImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getField()
     * @generated
     */
    EClass FIELD = eINSTANCE.getField();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.MethodImpl <em>Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.MethodImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getMethod()
     * @generated
     */
    EClass METHOD = eINSTANCE.getMethod();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD__PARAMS = eINSTANCE.getMethod_Params();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD__BODY = eINSTANCE.getMethod_Body();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.ParameterImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.TypedElementImpl <em>Typed Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.TypedElementImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getTypedElement()
     * @generated
     */
    EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPED_ELEMENT__NAME = eINSTANCE.getTypedElement_Name();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.MethodBodyImpl <em>Method Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.MethodBodyImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getMethodBody()
     * @generated
     */
    EClass METHOD_BODY = eINSTANCE.getMethodBody();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_BODY__EXPRESSION = eINSTANCE.getMethodBody_Expression();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.ExpressionImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.ThisImpl <em>This</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.ThisImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getThis()
     * @generated
     */
    EClass THIS = eINSTANCE.getThis();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THIS__VARIABLE = eINSTANCE.getThis_Variable();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.ParamRefImpl <em>Param Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.ParamRefImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getParamRef()
     * @generated
     */
    EClass PARAM_REF = eINSTANCE.getParamRef();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM_REF__PARAMETER = eINSTANCE.getParamRef_Parameter();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.NewImpl <em>New</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.NewImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getNew()
     * @generated
     */
    EClass NEW = eINSTANCE.getNew();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEW__TYPE = eINSTANCE.getNew_Type();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEW__ARGS = eINSTANCE.getNew_Args();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.CastImpl <em>Cast</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.CastImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getCast()
     * @generated
     */
    EClass CAST = eINSTANCE.getCast();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST__TYPE = eINSTANCE.getCast_Type();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST__EXPRESSION = eINSTANCE.getCast_Expression();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.ConstantImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.StringConstantImpl <em>String Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.StringConstantImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getStringConstant()
     * @generated
     */
    EClass STRING_CONSTANT = eINSTANCE.getStringConstant();

    /**
     * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_CONSTANT__CONSTANT = eINSTANCE.getStringConstant_Constant();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.IntConstantImpl <em>Int Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.IntConstantImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getIntConstant()
     * @generated
     */
    EClass INT_CONSTANT = eINSTANCE.getIntConstant();

    /**
     * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_CONSTANT__CONSTANT = eINSTANCE.getIntConstant_Constant();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.BoolConstantImpl <em>Bool Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.BoolConstantImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getBoolConstant()
     * @generated
     */
    EClass BOOL_CONSTANT = eINSTANCE.getBoolConstant();

    /**
     * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_CONSTANT__CONSTANT = eINSTANCE.getBoolConstant_Constant();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.fj.fj.impl.SelectionImpl <em>Selection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.fj.fj.impl.SelectionImpl
     * @see it.xsemantics.example.fj.fj.impl.FjPackageImpl#getSelection()
     * @generated
     */
    EClass SELECTION = eINSTANCE.getSelection();

    /**
     * The meta object literal for the '<em><b>Receiver</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION__RECEIVER = eINSTANCE.getSelection_Receiver();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION__MESSAGE = eINSTANCE.getSelection_Message();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION__ARGS = eINSTANCE.getSelection_Args();

  }

} //FjPackage
