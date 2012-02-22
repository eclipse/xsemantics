/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.lambda.lambda;

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
 * @see it.xsemantics.example.lambda.lambda.LambdaFactory
 * @model kind="package"
 * @generated
 */
public interface LambdaPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "lambda";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://xsemantics.sf.net/example/lambda/Lambda";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "lambda";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LambdaPackage eINSTANCE = it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl.init();

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.ProgramImpl <em>Program</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.ProgramImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getProgram()
   * @generated
   */
  int PROGRAM = 0;

  /**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM__TERM = 0;

  /**
   * The number of structural features of the '<em>Program</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.TermImpl <em>Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.TermImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getTerm()
   * @generated
   */
  int TERM = 1;

  /**
   * The number of structural features of the '<em>Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.ConstantImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 2;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.StringConstantImpl <em>String Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.StringConstantImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getStringConstant()
   * @generated
   */
  int STRING_CONSTANT = 3;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_CONSTANT__STRING = CONSTANT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_CONSTANT_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.IntConstantImpl <em>Int Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.IntConstantImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getIntConstant()
   * @generated
   */
  int INT_CONSTANT = 4;

  /**
   * The feature id for the '<em><b>Int</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CONSTANT__INT = CONSTANT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CONSTANT_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.ArithmeticsImpl <em>Arithmetics</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.ArithmeticsImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getArithmetics()
   * @generated
   */
  int ARITHMETICS = 5;

  /**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARITHMETICS__TERM = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Arithmetics</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARITHMETICS_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.VariableImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 6;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__REF = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.AbstractionImpl <em>Abstraction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.AbstractionImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getAbstraction()
   * @generated
   */
  int ABSTRACTION = 7;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACTION__PARAM = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACTION__TERM = TERM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Abstraction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACTION_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.ParameterImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__TYPE = 1;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.TypeImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getType()
   * @generated
   */
  int TYPE = 9;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.BasicTypeImpl <em>Basic Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.BasicTypeImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getBasicType()
   * @generated
   */
  int BASIC_TYPE = 10;

  /**
   * The number of structural features of the '<em>Basic Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.TypeVariableImpl <em>Type Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.TypeVariableImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getTypeVariable()
   * @generated
   */
  int TYPE_VARIABLE = 11;

  /**
   * The feature id for the '<em><b>Typevar Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_VARIABLE__TYPEVAR_NAME = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_VARIABLE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.ApplicationImpl <em>Application</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.ApplicationImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getApplication()
   * @generated
   */
  int APPLICATION = 12;

  /**
   * The feature id for the '<em><b>Fun</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION__FUN = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION__ARG = TERM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Application</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APPLICATION_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.ArrowTypeImpl <em>Arrow Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.ArrowTypeImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getArrowType()
   * @generated
   */
  int ARROW_TYPE = 13;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW_TYPE__LEFT = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW_TYPE__RIGHT = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Arrow Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.IntTypeImpl <em>Int Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.IntTypeImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getIntType()
   * @generated
   */
  int INT_TYPE = 14;

  /**
   * The number of structural features of the '<em>Int Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_TYPE_FEATURE_COUNT = BASIC_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.lambda.lambda.impl.StringTypeImpl <em>String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.lambda.lambda.impl.StringTypeImpl
   * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getStringType()
   * @generated
   */
  int STRING_TYPE = 15;

  /**
   * The number of structural features of the '<em>String Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_FEATURE_COUNT = BASIC_TYPE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program</em>'.
   * @see it.xsemantics.example.lambda.lambda.Program
   * @generated
   */
  EClass getProgram();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.lambda.lambda.Program#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see it.xsemantics.example.lambda.lambda.Program#getTerm()
   * @see #getProgram()
   * @generated
   */
  EReference getProgram_Term();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term</em>'.
   * @see it.xsemantics.example.lambda.lambda.Term
   * @generated
   */
  EClass getTerm();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see it.xsemantics.example.lambda.lambda.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.StringConstant <em>String Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Constant</em>'.
   * @see it.xsemantics.example.lambda.lambda.StringConstant
   * @generated
   */
  EClass getStringConstant();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.lambda.lambda.StringConstant#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see it.xsemantics.example.lambda.lambda.StringConstant#getString()
   * @see #getStringConstant()
   * @generated
   */
  EAttribute getStringConstant_String();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.IntConstant <em>Int Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Constant</em>'.
   * @see it.xsemantics.example.lambda.lambda.IntConstant
   * @generated
   */
  EClass getIntConstant();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.lambda.lambda.IntConstant#getInt <em>Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Int</em>'.
   * @see it.xsemantics.example.lambda.lambda.IntConstant#getInt()
   * @see #getIntConstant()
   * @generated
   */
  EAttribute getIntConstant_Int();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.Arithmetics <em>Arithmetics</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arithmetics</em>'.
   * @see it.xsemantics.example.lambda.lambda.Arithmetics
   * @generated
   */
  EClass getArithmetics();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.lambda.lambda.Arithmetics#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see it.xsemantics.example.lambda.lambda.Arithmetics#getTerm()
   * @see #getArithmetics()
   * @generated
   */
  EReference getArithmetics_Term();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see it.xsemantics.example.lambda.lambda.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the reference '{@link it.xsemantics.example.lambda.lambda.Variable#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see it.xsemantics.example.lambda.lambda.Variable#getRef()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Ref();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.Abstraction <em>Abstraction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstraction</em>'.
   * @see it.xsemantics.example.lambda.lambda.Abstraction
   * @generated
   */
  EClass getAbstraction();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.lambda.lambda.Abstraction#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see it.xsemantics.example.lambda.lambda.Abstraction#getParam()
   * @see #getAbstraction()
   * @generated
   */
  EReference getAbstraction_Param();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.lambda.lambda.Abstraction#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see it.xsemantics.example.lambda.lambda.Abstraction#getTerm()
   * @see #getAbstraction()
   * @generated
   */
  EReference getAbstraction_Term();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see it.xsemantics.example.lambda.lambda.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.lambda.lambda.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.example.lambda.lambda.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.lambda.lambda.Parameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see it.xsemantics.example.lambda.lambda.Parameter#getType()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Type();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see it.xsemantics.example.lambda.lambda.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.BasicType <em>Basic Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Type</em>'.
   * @see it.xsemantics.example.lambda.lambda.BasicType
   * @generated
   */
  EClass getBasicType();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.TypeVariable <em>Type Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Variable</em>'.
   * @see it.xsemantics.example.lambda.lambda.TypeVariable
   * @generated
   */
  EClass getTypeVariable();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.lambda.lambda.TypeVariable#getTypevarName <em>Typevar Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Typevar Name</em>'.
   * @see it.xsemantics.example.lambda.lambda.TypeVariable#getTypevarName()
   * @see #getTypeVariable()
   * @generated
   */
  EAttribute getTypeVariable_TypevarName();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.Application <em>Application</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Application</em>'.
   * @see it.xsemantics.example.lambda.lambda.Application
   * @generated
   */
  EClass getApplication();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.lambda.lambda.Application#getFun <em>Fun</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fun</em>'.
   * @see it.xsemantics.example.lambda.lambda.Application#getFun()
   * @see #getApplication()
   * @generated
   */
  EReference getApplication_Fun();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.lambda.lambda.Application#getArg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg</em>'.
   * @see it.xsemantics.example.lambda.lambda.Application#getArg()
   * @see #getApplication()
   * @generated
   */
  EReference getApplication_Arg();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.ArrowType <em>Arrow Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arrow Type</em>'.
   * @see it.xsemantics.example.lambda.lambda.ArrowType
   * @generated
   */
  EClass getArrowType();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.lambda.lambda.ArrowType#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see it.xsemantics.example.lambda.lambda.ArrowType#getLeft()
   * @see #getArrowType()
   * @generated
   */
  EReference getArrowType_Left();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.lambda.lambda.ArrowType#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see it.xsemantics.example.lambda.lambda.ArrowType#getRight()
   * @see #getArrowType()
   * @generated
   */
  EReference getArrowType_Right();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.IntType <em>Int Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Type</em>'.
   * @see it.xsemantics.example.lambda.lambda.IntType
   * @generated
   */
  EClass getIntType();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.lambda.lambda.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Type</em>'.
   * @see it.xsemantics.example.lambda.lambda.StringType
   * @generated
   */
  EClass getStringType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LambdaFactory getLambdaFactory();

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
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.ProgramImpl <em>Program</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.ProgramImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getProgram()
     * @generated
     */
    EClass PROGRAM = eINSTANCE.getProgram();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROGRAM__TERM = eINSTANCE.getProgram_Term();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.TermImpl <em>Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.TermImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getTerm()
     * @generated
     */
    EClass TERM = eINSTANCE.getTerm();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.ConstantImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.StringConstantImpl <em>String Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.StringConstantImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getStringConstant()
     * @generated
     */
    EClass STRING_CONSTANT = eINSTANCE.getStringConstant();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_CONSTANT__STRING = eINSTANCE.getStringConstant_String();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.IntConstantImpl <em>Int Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.IntConstantImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getIntConstant()
     * @generated
     */
    EClass INT_CONSTANT = eINSTANCE.getIntConstant();

    /**
     * The meta object literal for the '<em><b>Int</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_CONSTANT__INT = eINSTANCE.getIntConstant_Int();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.ArithmeticsImpl <em>Arithmetics</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.ArithmeticsImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getArithmetics()
     * @generated
     */
    EClass ARITHMETICS = eINSTANCE.getArithmetics();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARITHMETICS__TERM = eINSTANCE.getArithmetics_Term();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.VariableImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__REF = eINSTANCE.getVariable_Ref();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.AbstractionImpl <em>Abstraction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.AbstractionImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getAbstraction()
     * @generated
     */
    EClass ABSTRACTION = eINSTANCE.getAbstraction();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACTION__PARAM = eINSTANCE.getAbstraction_Param();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACTION__TERM = eINSTANCE.getAbstraction_Term();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.ParameterImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.TypeImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.BasicTypeImpl <em>Basic Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.BasicTypeImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getBasicType()
     * @generated
     */
    EClass BASIC_TYPE = eINSTANCE.getBasicType();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.TypeVariableImpl <em>Type Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.TypeVariableImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getTypeVariable()
     * @generated
     */
    EClass TYPE_VARIABLE = eINSTANCE.getTypeVariable();

    /**
     * The meta object literal for the '<em><b>Typevar Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_VARIABLE__TYPEVAR_NAME = eINSTANCE.getTypeVariable_TypevarName();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.ApplicationImpl <em>Application</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.ApplicationImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getApplication()
     * @generated
     */
    EClass APPLICATION = eINSTANCE.getApplication();

    /**
     * The meta object literal for the '<em><b>Fun</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLICATION__FUN = eINSTANCE.getApplication_Fun();

    /**
     * The meta object literal for the '<em><b>Arg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APPLICATION__ARG = eINSTANCE.getApplication_Arg();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.ArrowTypeImpl <em>Arrow Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.ArrowTypeImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getArrowType()
     * @generated
     */
    EClass ARROW_TYPE = eINSTANCE.getArrowType();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARROW_TYPE__LEFT = eINSTANCE.getArrowType_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARROW_TYPE__RIGHT = eINSTANCE.getArrowType_Right();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.IntTypeImpl <em>Int Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.IntTypeImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getIntType()
     * @generated
     */
    EClass INT_TYPE = eINSTANCE.getIntType();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.lambda.lambda.impl.StringTypeImpl <em>String Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.lambda.lambda.impl.StringTypeImpl
     * @see it.xsemantics.example.lambda.lambda.impl.LambdaPackageImpl#getStringType()
     * @generated
     */
    EClass STRING_TYPE = eINSTANCE.getStringType();

  }

} //LambdaPackage
