/**
 * <copyright>
 * </copyright>
 *
 */
package it.xsemantics.example.expressions.expressions;

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
 * @see it.xsemantics.example.expressions.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "expressions";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://xsemantics.sf.net/example/expressions/Expressions";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "expressions";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpressionsPackage eINSTANCE = it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl.init();

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.ModelImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__VARIABLES = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.VariableImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.TypeImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getType()
   * @generated
   */
  int TYPE = 3;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.PlusImpl <em>Plus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.PlusImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getPlus()
   * @generated
   */
  int PLUS = 4;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Plus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.MinusImpl <em>Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.MinusImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getMinus()
   * @generated
   */
  int MINUS = 5;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.MultiOrDivImpl <em>Multi Or Div</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.MultiOrDivImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getMultiOrDiv()
   * @generated
   */
  int MULTI_OR_DIV = 6;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_OR_DIV__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_OR_DIV__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_OR_DIV__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Multi Or Div</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_OR_DIV_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.ComparisonImpl <em>Comparison</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.ComparisonImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getComparison()
   * @generated
   */
  int COMPARISON = 7;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Comparison</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.AndOrExpressionImpl <em>And Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.AndOrExpressionImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getAndOrExpression()
   * @generated
   */
  int AND_OR_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_OR_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_OR_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_OR_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>And Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.BooleanNegationImpl <em>Boolean Negation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.BooleanNegationImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getBooleanNegation()
   * @generated
   */
  int BOOLEAN_NEGATION = 9;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_NEGATION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Negation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_NEGATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.ArithmeticSignedImpl <em>Arithmetic Signed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.ArithmeticSignedImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getArithmeticSigned()
   * @generated
   */
  int ARITHMETIC_SIGNED = 10;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARITHMETIC_SIGNED__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Arithmetic Signed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARITHMETIC_SIGNED_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.NumberLiteralImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getNumberLiteral()
   * @generated
   */
  int NUMBER_LITERAL = 11;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Number Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.StringLiteralImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 12;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.BooleanLiteralImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 13;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.VariableReferenceImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getVariableReference()
   * @generated
   */
  int VARIABLE_REFERENCE = 14;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REFERENCE__REF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.IntTypeImpl <em>Int Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.IntTypeImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getIntType()
   * @generated
   */
  int INT_TYPE = 15;

  /**
   * The number of structural features of the '<em>Int Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.StringTypeImpl <em>String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.StringTypeImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getStringType()
   * @generated
   */
  int STRING_TYPE = 16;

  /**
   * The number of structural features of the '<em>String Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link it.xsemantics.example.expressions.expressions.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.xsemantics.example.expressions.expressions.impl.BooleanTypeImpl
   * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getBooleanType()
   * @generated
   */
  int BOOLEAN_TYPE = 17;

  /**
   * The number of structural features of the '<em>Boolean Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see it.xsemantics.example.expressions.expressions.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link it.xsemantics.example.expressions.expressions.Model#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see it.xsemantics.example.expressions.expressions.Model#getVariables()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Variables();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see it.xsemantics.example.expressions.expressions.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.expressions.expressions.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.xsemantics.example.expressions.expressions.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.Variable#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see it.xsemantics.example.expressions.expressions.Variable#getExpression()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Expression();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see it.xsemantics.example.expressions.expressions.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see it.xsemantics.example.expressions.expressions.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.Plus <em>Plus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plus</em>'.
   * @see it.xsemantics.example.expressions.expressions.Plus
   * @generated
   */
  EClass getPlus();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.Plus#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see it.xsemantics.example.expressions.expressions.Plus#getLeft()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Left();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.Plus#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see it.xsemantics.example.expressions.expressions.Plus#getRight()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Right();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.Minus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Minus</em>'.
   * @see it.xsemantics.example.expressions.expressions.Minus
   * @generated
   */
  EClass getMinus();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.Minus#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see it.xsemantics.example.expressions.expressions.Minus#getLeft()
   * @see #getMinus()
   * @generated
   */
  EReference getMinus_Left();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.Minus#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see it.xsemantics.example.expressions.expressions.Minus#getRight()
   * @see #getMinus()
   * @generated
   */
  EReference getMinus_Right();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.MultiOrDiv <em>Multi Or Div</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multi Or Div</em>'.
   * @see it.xsemantics.example.expressions.expressions.MultiOrDiv
   * @generated
   */
  EClass getMultiOrDiv();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.MultiOrDiv#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see it.xsemantics.example.expressions.expressions.MultiOrDiv#getLeft()
   * @see #getMultiOrDiv()
   * @generated
   */
  EReference getMultiOrDiv_Left();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.expressions.expressions.MultiOrDiv#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see it.xsemantics.example.expressions.expressions.MultiOrDiv#getOp()
   * @see #getMultiOrDiv()
   * @generated
   */
  EAttribute getMultiOrDiv_Op();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.MultiOrDiv#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see it.xsemantics.example.expressions.expressions.MultiOrDiv#getRight()
   * @see #getMultiOrDiv()
   * @generated
   */
  EReference getMultiOrDiv_Right();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.Comparison <em>Comparison</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comparison</em>'.
   * @see it.xsemantics.example.expressions.expressions.Comparison
   * @generated
   */
  EClass getComparison();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.Comparison#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see it.xsemantics.example.expressions.expressions.Comparison#getLeft()
   * @see #getComparison()
   * @generated
   */
  EReference getComparison_Left();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.expressions.expressions.Comparison#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see it.xsemantics.example.expressions.expressions.Comparison#getOp()
   * @see #getComparison()
   * @generated
   */
  EAttribute getComparison_Op();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.Comparison#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see it.xsemantics.example.expressions.expressions.Comparison#getRight()
   * @see #getComparison()
   * @generated
   */
  EReference getComparison_Right();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.AndOrExpression <em>And Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Or Expression</em>'.
   * @see it.xsemantics.example.expressions.expressions.AndOrExpression
   * @generated
   */
  EClass getAndOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.AndOrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see it.xsemantics.example.expressions.expressions.AndOrExpression#getLeft()
   * @see #getAndOrExpression()
   * @generated
   */
  EReference getAndOrExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.expressions.expressions.AndOrExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see it.xsemantics.example.expressions.expressions.AndOrExpression#getOp()
   * @see #getAndOrExpression()
   * @generated
   */
  EAttribute getAndOrExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.AndOrExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see it.xsemantics.example.expressions.expressions.AndOrExpression#getRight()
   * @see #getAndOrExpression()
   * @generated
   */
  EReference getAndOrExpression_Right();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.BooleanNegation <em>Boolean Negation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Negation</em>'.
   * @see it.xsemantics.example.expressions.expressions.BooleanNegation
   * @generated
   */
  EClass getBooleanNegation();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.BooleanNegation#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see it.xsemantics.example.expressions.expressions.BooleanNegation#getExpression()
   * @see #getBooleanNegation()
   * @generated
   */
  EReference getBooleanNegation_Expression();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.ArithmeticSigned <em>Arithmetic Signed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arithmetic Signed</em>'.
   * @see it.xsemantics.example.expressions.expressions.ArithmeticSigned
   * @generated
   */
  EClass getArithmeticSigned();

  /**
   * Returns the meta object for the containment reference '{@link it.xsemantics.example.expressions.expressions.ArithmeticSigned#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see it.xsemantics.example.expressions.expressions.ArithmeticSigned#getExpression()
   * @see #getArithmeticSigned()
   * @generated
   */
  EReference getArithmeticSigned_Expression();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.NumberLiteral <em>Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal</em>'.
   * @see it.xsemantics.example.expressions.expressions.NumberLiteral
   * @generated
   */
  EClass getNumberLiteral();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.expressions.expressions.NumberLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see it.xsemantics.example.expressions.expressions.NumberLiteral#getValue()
   * @see #getNumberLiteral()
   * @generated
   */
  EAttribute getNumberLiteral_Value();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see it.xsemantics.example.expressions.expressions.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.expressions.expressions.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see it.xsemantics.example.expressions.expressions.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see it.xsemantics.example.expressions.expressions.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link it.xsemantics.example.expressions.expressions.BooleanLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see it.xsemantics.example.expressions.expressions.BooleanLiteral#getValue()
   * @see #getBooleanLiteral()
   * @generated
   */
  EAttribute getBooleanLiteral_Value();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.VariableReference <em>Variable Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Reference</em>'.
   * @see it.xsemantics.example.expressions.expressions.VariableReference
   * @generated
   */
  EClass getVariableReference();

  /**
   * Returns the meta object for the reference '{@link it.xsemantics.example.expressions.expressions.VariableReference#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see it.xsemantics.example.expressions.expressions.VariableReference#getRef()
   * @see #getVariableReference()
   * @generated
   */
  EReference getVariableReference_Ref();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.IntType <em>Int Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Type</em>'.
   * @see it.xsemantics.example.expressions.expressions.IntType
   * @generated
   */
  EClass getIntType();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Type</em>'.
   * @see it.xsemantics.example.expressions.expressions.StringType
   * @generated
   */
  EClass getStringType();

  /**
   * Returns the meta object for class '{@link it.xsemantics.example.expressions.expressions.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Type</em>'.
   * @see it.xsemantics.example.expressions.expressions.BooleanType
   * @generated
   */
  EClass getBooleanType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ExpressionsFactory getExpressionsFactory();

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
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.ModelImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__VARIABLES = eINSTANCE.getModel_Variables();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.VariableImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__EXPRESSION = eINSTANCE.getVariable_Expression();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.TypeImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.PlusImpl <em>Plus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.PlusImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getPlus()
     * @generated
     */
    EClass PLUS = eINSTANCE.getPlus();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__LEFT = eINSTANCE.getPlus_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__RIGHT = eINSTANCE.getPlus_Right();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.MinusImpl <em>Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.MinusImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getMinus()
     * @generated
     */
    EClass MINUS = eINSTANCE.getMinus();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MINUS__LEFT = eINSTANCE.getMinus_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MINUS__RIGHT = eINSTANCE.getMinus_Right();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.MultiOrDivImpl <em>Multi Or Div</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.MultiOrDivImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getMultiOrDiv()
     * @generated
     */
    EClass MULTI_OR_DIV = eINSTANCE.getMultiOrDiv();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI_OR_DIV__LEFT = eINSTANCE.getMultiOrDiv_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTI_OR_DIV__OP = eINSTANCE.getMultiOrDiv_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI_OR_DIV__RIGHT = eINSTANCE.getMultiOrDiv_Right();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.ComparisonImpl <em>Comparison</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.ComparisonImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getComparison()
     * @generated
     */
    EClass COMPARISON = eINSTANCE.getComparison();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARISON__LEFT = eINSTANCE.getComparison_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPARISON__OP = eINSTANCE.getComparison_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARISON__RIGHT = eINSTANCE.getComparison_Right();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.AndOrExpressionImpl <em>And Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.AndOrExpressionImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getAndOrExpression()
     * @generated
     */
    EClass AND_OR_EXPRESSION = eINSTANCE.getAndOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_OR_EXPRESSION__LEFT = eINSTANCE.getAndOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AND_OR_EXPRESSION__OP = eINSTANCE.getAndOrExpression_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_OR_EXPRESSION__RIGHT = eINSTANCE.getAndOrExpression_Right();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.BooleanNegationImpl <em>Boolean Negation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.BooleanNegationImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getBooleanNegation()
     * @generated
     */
    EClass BOOLEAN_NEGATION = eINSTANCE.getBooleanNegation();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_NEGATION__EXPRESSION = eINSTANCE.getBooleanNegation_Expression();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.ArithmeticSignedImpl <em>Arithmetic Signed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.ArithmeticSignedImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getArithmeticSigned()
     * @generated
     */
    EClass ARITHMETIC_SIGNED = eINSTANCE.getArithmeticSigned();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARITHMETIC_SIGNED__EXPRESSION = eINSTANCE.getArithmeticSigned_Expression();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.NumberLiteralImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getNumberLiteral()
     * @generated
     */
    EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBER_LITERAL__VALUE = eINSTANCE.getNumberLiteral_Value();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.StringLiteralImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getStringLiteral()
     * @generated
     */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.BooleanLiteralImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.VariableReferenceImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getVariableReference()
     * @generated
     */
    EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_REFERENCE__REF = eINSTANCE.getVariableReference_Ref();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.IntTypeImpl <em>Int Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.IntTypeImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getIntType()
     * @generated
     */
    EClass INT_TYPE = eINSTANCE.getIntType();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.StringTypeImpl <em>String Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.StringTypeImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getStringType()
     * @generated
     */
    EClass STRING_TYPE = eINSTANCE.getStringType();

    /**
     * The meta object literal for the '{@link it.xsemantics.example.expressions.expressions.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.xsemantics.example.expressions.expressions.impl.BooleanTypeImpl
     * @see it.xsemantics.example.expressions.expressions.impl.ExpressionsPackageImpl#getBooleanType()
     * @generated
     */
    EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

  }

} //ExpressionsPackage
