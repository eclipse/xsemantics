/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package org.eclipse.xsemantics.example.expressions.typing;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import org.eclipse.xsemantics.example.expressions.expressions.AndOrExpression;
import org.eclipse.xsemantics.example.expressions.expressions.ArithmeticSigned;
import org.eclipse.xsemantics.example.expressions.expressions.BooleanLiteral;
import org.eclipse.xsemantics.example.expressions.expressions.BooleanNegation;
import org.eclipse.xsemantics.example.expressions.expressions.BooleanType;
import org.eclipse.xsemantics.example.expressions.expressions.Comparison;
import org.eclipse.xsemantics.example.expressions.expressions.Equals;
import org.eclipse.xsemantics.example.expressions.expressions.Expression;
import org.eclipse.xsemantics.example.expressions.expressions.ExpressionsFactory;
import org.eclipse.xsemantics.example.expressions.expressions.ExpressionsPackage;
import org.eclipse.xsemantics.example.expressions.expressions.IntType;
import org.eclipse.xsemantics.example.expressions.expressions.Minus;
import org.eclipse.xsemantics.example.expressions.expressions.MultiOrDiv;
import org.eclipse.xsemantics.example.expressions.expressions.NumberLiteral;
import org.eclipse.xsemantics.example.expressions.expressions.Plus;
import org.eclipse.xsemantics.example.expressions.expressions.StringLiteral;
import org.eclipse.xsemantics.example.expressions.expressions.StringType;
import org.eclipse.xsemantics.example.expressions.expressions.Type;
import org.eclipse.xsemantics.example.expressions.expressions.Variable;
import org.eclipse.xsemantics.example.expressions.expressions.VariableReference;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * This system allows to convert implicitly
 * integers and booleans to strings, and '+' can
 * be used also for string concatenations
 */
@SuppressWarnings("all")
public class ExpressionsSemantics extends XsemanticsRuntimeSystem {
  public final static String NUMERALLITERAL = "org.eclipse.xsemantics.example.expressions.typing.NumeralLiteral";
  
  public final static String BOOLEANLITERAL = "org.eclipse.xsemantics.example.expressions.typing.BooleanLiteral";
  
  public final static String STRINGLITERAL = "org.eclipse.xsemantics.example.expressions.typing.StringLiteral";
  
  public final static String MULTIORDIV = "org.eclipse.xsemantics.example.expressions.typing.MultiOrDiv";
  
  public final static String MINUS = "org.eclipse.xsemantics.example.expressions.typing.Minus";
  
  public final static String PLUS = "org.eclipse.xsemantics.example.expressions.typing.Plus";
  
  public final static String COMPARISON = "org.eclipse.xsemantics.example.expressions.typing.Comparison";
  
  public final static String EQUALS = "org.eclipse.xsemantics.example.expressions.typing.Equals";
  
  public final static String BOOLEANNEGATION = "org.eclipse.xsemantics.example.expressions.typing.BooleanNegation";
  
  public final static String ANDOR = "org.eclipse.xsemantics.example.expressions.typing.AndOr";
  
  public final static String ARITHMETICSIGNED = "org.eclipse.xsemantics.example.expressions.typing.ArithmeticSigned";
  
  public final static String VARIABLEREFERENCE = "org.eclipse.xsemantics.example.expressions.typing.VariableReference";
  
  public final static String VARIABLE = "org.eclipse.xsemantics.example.expressions.typing.Variable";
  
  public final static String INTERPRETNUMBERLITERAL = "org.eclipse.xsemantics.example.expressions.typing.InterpretNumberLiteral";
  
  public final static String INTERPRETSTRINGLITERAL = "org.eclipse.xsemantics.example.expressions.typing.InterpretStringLiteral";
  
  public final static String INTERPRETBOOLEANLITERAL = "org.eclipse.xsemantics.example.expressions.typing.InterpretBooleanLiteral";
  
  public final static String INTERPRETMINUS = "org.eclipse.xsemantics.example.expressions.typing.InterpretMinus";
  
  public final static String INTERPRETMULTIORDIV = "org.eclipse.xsemantics.example.expressions.typing.InterpretMultiOrDiv";
  
  public final static String INTERPRETARITHMETICSIGNED = "org.eclipse.xsemantics.example.expressions.typing.InterpretArithmeticSigned";
  
  public final static String INTERPRETANDOR = "org.eclipse.xsemantics.example.expressions.typing.InterpretAndOr";
  
  public final static String INTERPRETBOOLEANNEGATION = "org.eclipse.xsemantics.example.expressions.typing.InterpretBooleanNegation";
  
  public final static String INTERPRETCOMPARISON = "org.eclipse.xsemantics.example.expressions.typing.InterpretComparison";
  
  public final static String INTERPRETEQUALS = "org.eclipse.xsemantics.example.expressions.typing.InterpretEquals";
  
  public final static String INTERPRETPLUS = "org.eclipse.xsemantics.example.expressions.typing.InterpretPlus";
  
  public final static String INTERPRETVARIABLEREFENRENCE = "org.eclipse.xsemantics.example.expressions.typing.InterpretVariableRefenrence";
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> vartypeDispatcher;
  
  private PolymorphicDispatcher<Result<Object>> interpretDispatcher;
  
  public ExpressionsSemantics() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    vartypeDispatcher = buildPolymorphicDispatcher1(
    	"vartypeImpl", 3, "||-", ":");
    interpretDispatcher = buildPolymorphicDispatcher1(
    	"interpretImpl", 3, "|-", "~>");
  }
  
  public Result<Type> type(final Expression expression) {
    return type(new RuleEnvironment(), null, expression);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final Expression expression) {
    return type(_environment_, null, expression);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return typeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Result<Type> vartype(final Variable variable) {
    return vartype(new RuleEnvironment(), null, variable);
  }
  
  public Result<Type> vartype(final RuleEnvironment _environment_, final Variable variable) {
    return vartype(_environment_, null, variable);
  }
  
  public Result<Type> vartype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Variable variable) {
    try {
    	return vartypeInternal(_environment_, _trace_, variable);
    } catch (Exception _e_vartype) {
    	return resultForFailure(_e_vartype);
    }
  }
  
  public Result<Object> interpret(final Expression expression) {
    return interpret(new RuleEnvironment(), null, expression);
  }
  
  public Result<Object> interpret(final RuleEnvironment _environment_, final Expression expression) {
    return interpret(_environment_, null, expression);
  }
  
  public Result<Object> interpret(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return interpretInternal(_environment_, _trace_, expression);
    } catch (Exception _e_interpret) {
    	return resultForFailure(_e_interpret);
    }
  }
  
  public Result<Boolean> checkVariable(final Variable variable) {
    return checkVariable(null, variable);
  }
  
  public Result<Boolean> checkVariable(final RuleApplicationTrace _trace_, final Variable variable) {
    try {
    	return checkVariableInternal(_trace_, variable);
    } catch (Exception _e_CheckVariable) {
    	return resultForFailure(_e_CheckVariable);
    }
  }
  
  protected Result<Boolean> checkVariableInternal(final RuleApplicationTrace _trace_, final Variable variable) throws RuleFailedException {
    /* empty ||- variable : var Type type */
    Type type = null;
    Result<Type> result = vartypeInternal(emptyEnvironment(), _trace_, variable);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return typeDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(expression);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    EObject source = expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<Type> vartypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Variable variable) {
    try {
    	checkParamsNotNull(variable);
    	return vartypeDispatcher.invoke(_environment_, _trace_, variable);
    } catch (Exception _e_vartype) {
    	sneakyThrowRuleFailedException(_e_vartype);
    	return null;
    }
  }
  
  protected void vartypeThrowException(final String _error, final String _issue, final Exception _ex, final Variable variable, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(variable);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    EObject source = variable;
    EReference _variable_Expression = ExpressionsPackage.eINSTANCE.getVariable_Expression();
    EStructuralFeature feature = _variable_Expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, feature));
  }
  
  protected Result<Object> interpretInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return interpretDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_interpret) {
    	sneakyThrowRuleFailedException(_e_interpret);
    	return null;
    }
  }
  
  protected void interpretThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral num) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleNumeralLiteral(G, _subtrace_, num);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("NumeralLiteral") + stringRepForEnv(G) + " |- " + stringRep(num) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleNumeralLiteral) {
    	typeThrowException(ruleName("NumeralLiteral") + stringRepForEnv(G) + " |- " + stringRep(num) + " : " + "IntType",
    		NUMERALLITERAL,
    		e_applyRuleNumeralLiteral, num, new ErrorInformation[] {new ErrorInformation(num)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleNumeralLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral num) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleNumeralLiteral_1(G, num));
  }
  
  private IntType _applyRuleNumeralLiteral_1(final RuleEnvironment G, final NumberLiteral num) throws RuleFailedException {
    IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
    return _createIntType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral bool) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleBooleanLiteral(G, _subtrace_, bool);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(bool) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBooleanLiteral) {
    	typeThrowException(ruleName("BooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(bool) + " : " + "BooleanType",
    		BOOLEANLITERAL,
    		e_applyRuleBooleanLiteral, bool, new ErrorInformation[] {new ErrorInformation(bool)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleBooleanLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral bool) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleBooleanLiteral_1(G, bool));
  }
  
  private BooleanType _applyRuleBooleanLiteral_1(final RuleEnvironment G, final BooleanLiteral bool) throws RuleFailedException {
    BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
    return _createBooleanType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral str) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleStringLiteral(G, _subtrace_, str);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("StringLiteral") + stringRepForEnv(G) + " |- " + stringRep(str) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleStringLiteral) {
    	typeThrowException(ruleName("StringLiteral") + stringRepForEnv(G) + " |- " + stringRep(str) + " : " + "StringType",
    		STRINGLITERAL,
    		e_applyRuleStringLiteral, str, new ErrorInformation[] {new ErrorInformation(str)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleStringLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral str) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleStringLiteral_1(G, str));
  }
  
  private StringType _applyRuleStringLiteral_1(final RuleEnvironment G, final StringLiteral str) throws RuleFailedException {
    StringType _createStringType = ExpressionsFactory.eINSTANCE.createStringType();
    return _createStringType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MultiOrDiv multiOrDiv) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleMultiOrDiv(G, _subtrace_, multiOrDiv);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("MultiOrDiv") + stringRepForEnv(G) + " |- " + stringRep(multiOrDiv) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleMultiOrDiv) {
    	typeThrowException(ruleName("MultiOrDiv") + stringRepForEnv(G) + " |- " + stringRep(multiOrDiv) + " : " + "IntType",
    		MULTIORDIV,
    		e_applyRuleMultiOrDiv, multiOrDiv, new ErrorInformation[] {new ErrorInformation(multiOrDiv)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleMultiOrDiv(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MultiOrDiv multiOrDiv) throws RuleFailedException {
    IntType intType = null; // output parameter
    /* G |- multiOrDiv.left : intType */
    Expression _left = multiOrDiv.getLeft();
    Result<Type> result = typeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), IntType.class);
    intType = (IntType) result.getFirst();
    
    /* G |- multiOrDiv.right : intType */
    Expression _right = multiOrDiv.getRight();
    Result<Type> result_1 = typeInternal(G, _trace_, _right);
    checkAssignableTo(result_1.getFirst(), IntType.class);
    intType = (IntType) result_1.getFirst();
    
    return new Result<Type>(intType);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Minus minus) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleMinus(G, _subtrace_, minus);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Minus") + stringRepForEnv(G) + " |- " + stringRep(minus) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleMinus) {
    	typeThrowException(ruleName("Minus") + stringRepForEnv(G) + " |- " + stringRep(minus) + " : " + "IntType",
    		MINUS,
    		e_applyRuleMinus, minus, new ErrorInformation[] {new ErrorInformation(minus)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleMinus(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Minus minus) throws RuleFailedException {
    IntType intType = null;
    /* G |- minus.left : intType */
    Expression _left = minus.getLeft();
    Result<Type> result = typeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), IntType.class);
    intType = (IntType) result.getFirst();
    
    /* G |- minus.right : intType */
    Expression _right = minus.getRight();
    Result<Type> result_1 = typeInternal(G, _trace_, _right);
    checkAssignableTo(result_1.getFirst(), IntType.class);
    intType = (IntType) result_1.getFirst();
    
    return new Result<Type>(_applyRuleMinus_1(G, minus));
  }
  
  private IntType _applyRuleMinus_1(final RuleEnvironment G, final Minus minus) throws RuleFailedException {
    IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
    return _createIntType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Plus plus) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRulePlus(G, _subtrace_, plus);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Plus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePlus) {
    	typeThrowException(ruleName("Plus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " : " + "Type",
    		PLUS,
    		e_applyRulePlus, plus, new ErrorInformation[] {new ErrorInformation(plus)});
    	return null;
    }
  }
  
  protected Result<Type> applyRulePlus(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Plus plus) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- plus.left : var Type leftType */
    Expression _left = plus.getLeft();
    Type leftType = null;
    Result<Type> result = typeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    /* G |- plus.right : var Type rightType */
    Expression _right = plus.getRight();
    Type rightType = null;
    Result<Type> result_1 = typeInternal(G, _trace_, _right);
    checkAssignableTo(result_1.getFirst(), Type.class);
    rightType = (Type) result_1.getFirst();
    
    /* { (leftType instanceof StringType || rightType instanceof StringType) type = ExpressionsFactory::eINSTANCE.createStringType } or { (leftType instanceof IntType && rightType instanceof IntType) type = leftType } */
    {
      RuleFailedException previousFailure = null;
      try {
        /* leftType instanceof StringType || rightType instanceof StringType */
        if (!((leftType instanceof StringType) || (rightType instanceof StringType))) {
          sneakyThrowRuleFailedException("leftType instanceof StringType || rightType instanceof StringType");
        }
        type = ExpressionsFactory.eINSTANCE.createStringType();
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* leftType instanceof IntType && rightType instanceof IntType */
        if (!((leftType instanceof IntType) && (rightType instanceof IntType))) {
          sneakyThrowRuleFailedException("leftType instanceof IntType && rightType instanceof IntType");
        }
        type = leftType;
      }
    }
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Comparison comparison) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleComparison(G, _subtrace_, comparison);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Comparison") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleComparison) {
    	typeThrowException(ruleName("Comparison") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " : " + "BooleanType",
    		COMPARISON,
    		e_applyRuleComparison, comparison, new ErrorInformation[] {new ErrorInformation(comparison)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleComparison(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Comparison comparison) throws RuleFailedException {
    /* empty |- comparison.left : var Type leftType */
    Expression _left = comparison.getLeft();
    Type leftType = null;
    Result<Type> result = typeInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    /* empty |- comparison.right : var Type rightType */
    Expression _right = comparison.getRight();
    Type rightType = null;
    Result<Type> result_1 = typeInternal(emptyEnvironment(), _trace_, _right);
    checkAssignableTo(result_1.getFirst(), Type.class);
    rightType = (Type) result_1.getFirst();
    
    /* (leftType instanceof IntType && rightType instanceof IntType) || (leftType instanceof StringType && rightType instanceof StringType) */
    if (!(((leftType instanceof IntType) && (rightType instanceof IntType)) || ((leftType instanceof StringType) && (rightType instanceof StringType)))) {
      sneakyThrowRuleFailedException("(leftType instanceof IntType && rightType instanceof IntType) || (leftType instanceof StringType && rightType instanceof StringType)");
    }
    return new Result<Type>(_applyRuleComparison_1(G, comparison));
  }
  
  private BooleanType _applyRuleComparison_1(final RuleEnvironment G, final Comparison comparison) throws RuleFailedException {
    BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
    return _createBooleanType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Equals comparison) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleEquals(G, _subtrace_, comparison);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Equals") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEquals) {
    	typeThrowException(ruleName("Equals") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " : " + "BooleanType",
    		EQUALS,
    		e_applyRuleEquals, comparison, new ErrorInformation[] {new ErrorInformation(comparison)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Equals comparison) throws RuleFailedException {
    /* G |- comparison.left : var Type leftType */
    Expression _left = comparison.getLeft();
    Type leftType = null;
    Result<Type> result = typeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    /* G |- comparison.right : var Type rightType */
    Expression _right = comparison.getRight();
    Type rightType = null;
    Result<Type> result_1 = typeInternal(G, _trace_, _right);
    checkAssignableTo(result_1.getFirst(), Type.class);
    rightType = (Type) result_1.getFirst();
    
    EClass _eClass = leftType.eClass();
    EClass _eClass_1 = rightType.eClass();
    /* leftType.eClass == rightType.eClass */
    if (!Objects.equal(_eClass, _eClass_1)) {
      sneakyThrowRuleFailedException("leftType.eClass == rightType.eClass");
    }
    return new Result<Type>(_applyRuleEquals_1(G, comparison));
  }
  
  private BooleanType _applyRuleEquals_1(final RuleEnvironment G, final Equals comparison) throws RuleFailedException {
    BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
    return _createBooleanType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanNegation negation) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleBooleanNegation(G, _subtrace_, negation);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BooleanNegation") + stringRepForEnv(G) + " |- " + stringRep(negation) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBooleanNegation) {
    	typeThrowException(ruleName("BooleanNegation") + stringRepForEnv(G) + " |- " + stringRep(negation) + " : " + "BooleanType",
    		BOOLEANNEGATION,
    		e_applyRuleBooleanNegation, negation, new ErrorInformation[] {new ErrorInformation(negation)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleBooleanNegation(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanNegation negation) throws RuleFailedException {
    BooleanType boolType = null; // output parameter
    /* G |- negation.expression : boolType */
    Expression _expression = negation.getExpression();
    Result<Type> result = typeInternal(G, _trace_, _expression);
    checkAssignableTo(result.getFirst(), BooleanType.class);
    boolType = (BooleanType) result.getFirst();
    
    return new Result<Type>(boolType);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AndOrExpression andOr) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAndOr(G, _subtrace_, andOr);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AndOr") + stringRepForEnv(G) + " |- " + stringRep(andOr) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAndOr) {
    	typeThrowException(ruleName("AndOr") + stringRepForEnv(G) + " |- " + stringRep(andOr) + " : " + "BooleanType",
    		ANDOR,
    		e_applyRuleAndOr, andOr, new ErrorInformation[] {new ErrorInformation(andOr)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleAndOr(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AndOrExpression andOr) throws RuleFailedException {
    BooleanType boolType = null; // output parameter
    /* G |- andOr.left : boolType */
    Expression _left = andOr.getLeft();
    Result<Type> result = typeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), BooleanType.class);
    boolType = (BooleanType) result.getFirst();
    
    /* G |- andOr.right : boolType */
    Expression _right = andOr.getRight();
    Result<Type> result_1 = typeInternal(G, _trace_, _right);
    checkAssignableTo(result_1.getFirst(), BooleanType.class);
    boolType = (BooleanType) result_1.getFirst();
    
    return new Result<Type>(boolType);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ArithmeticSigned signed) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleArithmeticSigned(G, _subtrace_, signed);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ArithmeticSigned") + stringRepForEnv(G) + " |- " + stringRep(signed) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleArithmeticSigned) {
    	typeThrowException(ruleName("ArithmeticSigned") + stringRepForEnv(G) + " |- " + stringRep(signed) + " : " + "IntType",
    		ARITHMETICSIGNED,
    		e_applyRuleArithmeticSigned, signed, new ErrorInformation[] {new ErrorInformation(signed)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleArithmeticSigned(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ArithmeticSigned signed) throws RuleFailedException {
    /* G |- signed.expression : var IntType intType */
    Expression _expression = signed.getExpression();
    IntType intType = null;
    Result<Type> result = typeInternal(G, _trace_, _expression);
    checkAssignableTo(result.getFirst(), IntType.class);
    intType = (IntType) result.getFirst();
    
    return new Result<Type>(_applyRuleArithmeticSigned_1(G, signed));
  }
  
  private IntType _applyRuleArithmeticSigned_1(final RuleEnvironment G, final ArithmeticSigned signed) throws RuleFailedException {
    IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
    return _createIntType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VariableReference varRef) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleVariableReference(G, _subtrace_, varRef);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("VariableReference") + stringRepForEnv(G) + " |- " + stringRep(varRef) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleVariableReference) {
    	typeThrowException(ruleName("VariableReference") + stringRepForEnv(G) + " |- " + stringRep(varRef) + " : " + "Type",
    		VARIABLEREFERENCE,
    		e_applyRuleVariableReference, varRef, new ErrorInformation[] {new ErrorInformation(varRef)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleVariableReference(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VariableReference varRef) throws RuleFailedException {
    Type type = null; // output parameter
    /* G ||- varRef.ref : type */
    Variable _ref = varRef.getRef();
    Result<Type> result = vartypeInternal(G, _trace_, _ref);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Type> vartypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Variable variable) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleVariable(G, _subtrace_, variable);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Variable") + stringRepForEnv(G) + " ||- " + stringRep(variable) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleVariable) {
    	vartypeThrowException(ruleName("Variable") + stringRepForEnv(G) + " ||- " + stringRep(variable) + " : " + "Type",
    		VARIABLE,
    		e_applyRuleVariable, variable, new ErrorInformation[] {new ErrorInformation(variable)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleVariable(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Variable variable) throws RuleFailedException {
    Type type = null; // output parameter
    Expression _expression = variable.getExpression();
    boolean _tripleNotEquals = (_expression != null);
    /* variable.expression !== null */
    if (!_tripleNotEquals) {
      sneakyThrowRuleFailedException("variable.expression !== null");
    }
    /* G |- variable.expression : type */
    Expression _expression_1 = variable.getExpression();
    Result<Type> result = typeInternal(G, _trace_, _expression_1);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral number) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretNumberLiteral(G, _subtrace_, number);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretNumberLiteral") + stringRepForEnv(G) + " |- " + stringRep(number) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretNumberLiteral) {
    	interpretThrowException(ruleName("InterpretNumberLiteral") + stringRepForEnv(G) + " |- " + stringRep(number) + " ~> " + "int",
    		INTERPRETNUMBERLITERAL,
    		e_applyRuleInterpretNumberLiteral, number, new ErrorInformation[] {new ErrorInformation(number)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretNumberLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral number) throws RuleFailedException {
    
    return new Result<Object>(_applyRuleInterpretNumberLiteral_1(G, number));
  }
  
  private int _applyRuleInterpretNumberLiteral_1(final RuleEnvironment G, final NumberLiteral number) throws RuleFailedException {
    int _value = number.getValue();
    return _value;
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral string) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretStringLiteral(G, _subtrace_, string);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretStringLiteral") + stringRepForEnv(G) + " |- " + stringRep(string) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretStringLiteral) {
    	interpretThrowException(ruleName("InterpretStringLiteral") + stringRepForEnv(G) + " |- " + stringRep(string) + " ~> " + "String",
    		INTERPRETSTRINGLITERAL,
    		e_applyRuleInterpretStringLiteral, string, new ErrorInformation[] {new ErrorInformation(string)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretStringLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral string) throws RuleFailedException {
    
    return new Result<Object>(_applyRuleInterpretStringLiteral_1(G, string));
  }
  
  private String _applyRuleInterpretStringLiteral_1(final RuleEnvironment G, final StringLiteral string) throws RuleFailedException {
    String _value = string.getValue();
    return _value;
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral bool) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretBooleanLiteral(G, _subtrace_, bool);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretBooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(bool) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretBooleanLiteral) {
    	interpretThrowException(ruleName("InterpretBooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(bool) + " ~> " + "Boolean",
    		INTERPRETBOOLEANLITERAL,
    		e_applyRuleInterpretBooleanLiteral, bool, new ErrorInformation[] {new ErrorInformation(bool)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretBooleanLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral bool) throws RuleFailedException {
    
    return new Result<Object>(_applyRuleInterpretBooleanLiteral_1(G, bool));
  }
  
  private Boolean _applyRuleInterpretBooleanLiteral_1(final RuleEnvironment G, final BooleanLiteral bool) throws RuleFailedException {
    Boolean _valueOf = Boolean.valueOf(bool.getValue());
    return _valueOf;
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Minus plus) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretMinus(G, _subtrace_, plus);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretMinus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretMinus) {
    	interpretThrowException(ruleName("InterpretMinus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " ~> " + "Integer",
    		INTERPRETMINUS,
    		e_applyRuleInterpretMinus, plus, new ErrorInformation[] {new ErrorInformation(plus)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretMinus(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Minus plus) throws RuleFailedException {
    Integer result = null; // output parameter
    /* G |- plus.left ~> var Integer leftResult */
    Expression _left = plus.getLeft();
    Integer leftResult = null;
    Result<Object> result_1 = interpretInternal(G, _trace_, _left);
    checkAssignableTo(result_1.getFirst(), Integer.class);
    leftResult = (Integer) result_1.getFirst();
    
    /* G |- plus.right ~> var Integer rightResult */
    Expression _right = plus.getRight();
    Integer rightResult = null;
    Result<Object> result_2 = interpretInternal(G, _trace_, _right);
    checkAssignableTo(result_2.getFirst(), Integer.class);
    rightResult = (Integer) result_2.getFirst();
    
    int _intValue = leftResult.intValue();
    int _intValue_1 = rightResult.intValue();
    int _minus = (_intValue - _intValue_1);
    result = Integer.valueOf(_minus);
    return new Result<Object>(result);
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MultiOrDiv multiOrDiv) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretMultiOrDiv(G, _subtrace_, multiOrDiv);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretMultiOrDiv") + stringRepForEnv(G) + " |- " + stringRep(multiOrDiv) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretMultiOrDiv) {
    	interpretThrowException(ruleName("InterpretMultiOrDiv") + stringRepForEnv(G) + " |- " + stringRep(multiOrDiv) + " ~> " + "Integer",
    		INTERPRETMULTIORDIV,
    		e_applyRuleInterpretMultiOrDiv, multiOrDiv, new ErrorInformation[] {new ErrorInformation(multiOrDiv)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretMultiOrDiv(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MultiOrDiv multiOrDiv) throws RuleFailedException {
    Integer result = null; // output parameter
    /* G |- multiOrDiv.left ~> var Integer leftResult */
    Expression _left = multiOrDiv.getLeft();
    Integer leftResult = null;
    Result<Object> result_1 = interpretInternal(G, _trace_, _left);
    checkAssignableTo(result_1.getFirst(), Integer.class);
    leftResult = (Integer) result_1.getFirst();
    
    /* G |- multiOrDiv.right ~> var Integer rightResult */
    Expression _right = multiOrDiv.getRight();
    Integer rightResult = null;
    Result<Object> result_2 = interpretInternal(G, _trace_, _right);
    checkAssignableTo(result_2.getFirst(), Integer.class);
    rightResult = (Integer) result_2.getFirst();
    
    String _op = multiOrDiv.getOp();
    boolean _equals = Objects.equal(_op, "*");
    if (_equals) {
      int _intValue = leftResult.intValue();
      int _intValue_1 = rightResult.intValue();
      int _multiply = (_intValue * _intValue_1);
      result = Integer.valueOf(_multiply);
    } else {
      int _intValue_2 = leftResult.intValue();
      int _intValue_3 = rightResult.intValue();
      int _divide = (_intValue_2 / _intValue_3);
      result = Integer.valueOf(_divide);
    }
    return new Result<Object>(result);
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ArithmeticSigned signed) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretArithmeticSigned(G, _subtrace_, signed);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretArithmeticSigned") + stringRepForEnv(G) + " |- " + stringRep(signed) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretArithmeticSigned) {
    	interpretThrowException(ruleName("InterpretArithmeticSigned") + stringRepForEnv(G) + " |- " + stringRep(signed) + " ~> " + "Integer",
    		INTERPRETARITHMETICSIGNED,
    		e_applyRuleInterpretArithmeticSigned, signed, new ErrorInformation[] {new ErrorInformation(signed)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretArithmeticSigned(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ArithmeticSigned signed) throws RuleFailedException {
    Integer result = null; // output parameter
    /* G |- signed.expression ~> var Integer expResult */
    Expression _expression = signed.getExpression();
    Integer expResult = null;
    Result<Object> result_1 = interpretInternal(G, _trace_, _expression);
    checkAssignableTo(result_1.getFirst(), Integer.class);
    expResult = (Integer) result_1.getFirst();
    
    result = Integer.valueOf((-(expResult).intValue()));
    return new Result<Object>(result);
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AndOrExpression andOr) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretAndOr(G, _subtrace_, andOr);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretAndOr") + stringRepForEnv(G) + " |- " + stringRep(andOr) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretAndOr) {
    	interpretThrowException(ruleName("InterpretAndOr") + stringRepForEnv(G) + " |- " + stringRep(andOr) + " ~> " + "Boolean",
    		INTERPRETANDOR,
    		e_applyRuleInterpretAndOr, andOr, new ErrorInformation[] {new ErrorInformation(andOr)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretAndOr(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AndOrExpression andOr) throws RuleFailedException {
    Boolean result = null; // output parameter
    /* G |- andOr.left ~> var Boolean leftResult */
    Expression _left = andOr.getLeft();
    Boolean leftResult = null;
    Result<Object> result_1 = interpretInternal(G, _trace_, _left);
    checkAssignableTo(result_1.getFirst(), Boolean.class);
    leftResult = (Boolean) result_1.getFirst();
    
    /* G |- andOr.right ~> var Boolean rightResult */
    Expression _right = andOr.getRight();
    Boolean rightResult = null;
    Result<Object> result_2 = interpretInternal(G, _trace_, _right);
    checkAssignableTo(result_2.getFirst(), Boolean.class);
    rightResult = (Boolean) result_2.getFirst();
    
    String _op = andOr.getOp();
    boolean _equals = Objects.equal(_op, "&&");
    if (_equals) {
      result = Boolean.valueOf((leftResult.booleanValue() && rightResult.booleanValue()));
    } else {
      result = Boolean.valueOf((leftResult.booleanValue() || rightResult.booleanValue()));
    }
    return new Result<Object>(result);
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanNegation neg) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretBooleanNegation(G, _subtrace_, neg);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretBooleanNegation") + stringRepForEnv(G) + " |- " + stringRep(neg) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretBooleanNegation) {
    	interpretThrowException(ruleName("InterpretBooleanNegation") + stringRepForEnv(G) + " |- " + stringRep(neg) + " ~> " + "Boolean",
    		INTERPRETBOOLEANNEGATION,
    		e_applyRuleInterpretBooleanNegation, neg, new ErrorInformation[] {new ErrorInformation(neg)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretBooleanNegation(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanNegation neg) throws RuleFailedException {
    Boolean result = null; // output parameter
    /* G |- neg.expression ~> var Boolean expResult */
    Expression _expression = neg.getExpression();
    Boolean expResult = null;
    Result<Object> result_1 = interpretInternal(G, _trace_, _expression);
    checkAssignableTo(result_1.getFirst(), Boolean.class);
    expResult = (Boolean) result_1.getFirst();
    
    result = Boolean.valueOf((!(expResult).booleanValue()));
    return new Result<Object>(result);
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Comparison comparison) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretComparison(G, _subtrace_, comparison);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretComparison") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretComparison) {
    	interpretThrowException(ruleName("InterpretComparison") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " ~> " + "Boolean",
    		INTERPRETCOMPARISON,
    		e_applyRuleInterpretComparison, comparison, new ErrorInformation[] {new ErrorInformation(comparison)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretComparison(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Comparison comparison) throws RuleFailedException {
    Boolean result = null; // output parameter
    /* empty |- comparison.left ~> var Object leftResult */
    Expression _left = comparison.getLeft();
    Object leftResult = null;
    Result<Object> result_1 = interpretInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result_1.getFirst(), Object.class);
    leftResult = (Object) result_1.getFirst();
    
    /* empty |- comparison.right ~> var Object rightResult */
    Expression _right = comparison.getRight();
    Object rightResult = null;
    Result<Object> result_2 = interpretInternal(emptyEnvironment(), _trace_, _right);
    checkAssignableTo(result_2.getFirst(), Object.class);
    rightResult = (Object) result_2.getFirst();
    
    if (((leftResult instanceof String) && (rightResult instanceof String))) {
      String _string = leftResult.toString();
      String _string_1 = rightResult.toString();
      boolean _lessThan = (_string.compareTo(_string_1) < 0);
      result = Boolean.valueOf(_lessThan);
    } else {
      boolean _lessThan_1 = (((Integer) leftResult).compareTo(((Integer) rightResult)) < 0);
      result = Boolean.valueOf(_lessThan_1);
    }
    return new Result<Object>(result);
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Equals comparison) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretEquals(G, _subtrace_, comparison);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretEquals") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretEquals) {
    	interpretThrowException(ruleName("InterpretEquals") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " ~> " + "Boolean",
    		INTERPRETEQUALS,
    		e_applyRuleInterpretEquals, comparison, new ErrorInformation[] {new ErrorInformation(comparison)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Equals comparison) throws RuleFailedException {
    Boolean result = null; // output parameter
    /* empty |- comparison.left ~> var Object leftResult */
    Expression _left = comparison.getLeft();
    Object leftResult = null;
    Result<Object> result_1 = interpretInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result_1.getFirst(), Object.class);
    leftResult = (Object) result_1.getFirst();
    
    /* empty |- comparison.right ~> var Object rightResult */
    Expression _right = comparison.getRight();
    Object rightResult = null;
    Result<Object> result_2 = interpretInternal(emptyEnvironment(), _trace_, _right);
    checkAssignableTo(result_2.getFirst(), Object.class);
    rightResult = (Object) result_2.getFirst();
    
    String _string = leftResult.toString();
    String _string_1 = rightResult.toString();
    boolean _equals = Objects.equal(_string, _string_1);
    result = Boolean.valueOf(_equals);
    return new Result<Object>(result);
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Plus plus) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretPlus(G, _subtrace_, plus);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretPlus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretPlus) {
    	interpretThrowException(ruleName("InterpretPlus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " ~> " + "Object",
    		INTERPRETPLUS,
    		e_applyRuleInterpretPlus, plus, new ErrorInformation[] {new ErrorInformation(plus)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretPlus(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Plus plus) throws RuleFailedException {
    Object result = null; // output parameter
    /* G |- plus.left ~> var Object leftResult */
    Expression _left = plus.getLeft();
    Object leftResult = null;
    Result<Object> result_1 = interpretInternal(G, _trace_, _left);
    checkAssignableTo(result_1.getFirst(), Object.class);
    leftResult = (Object) result_1.getFirst();
    
    /* G |- plus.right ~> var Object rightResult */
    Expression _right = plus.getRight();
    Object rightResult = null;
    Result<Object> result_2 = interpretInternal(G, _trace_, _right);
    checkAssignableTo(result_2.getFirst(), Object.class);
    rightResult = (Object) result_2.getFirst();
    
    if (((leftResult instanceof String) || (rightResult instanceof String))) {
      String leftString = leftResult.toString();
      String rightString = rightResult.toString();
      result = (leftString + rightString);
    } else {
      Integer leftInt = ((Integer) leftResult);
      Integer rightInt = ((Integer) rightResult);
      result = Integer.valueOf(((leftInt).intValue() + (rightInt).intValue()));
    }
    return new Result<Object>(result);
  }
  
  protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VariableReference varRef) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleInterpretVariableRefenrence(G, _subtrace_, varRef);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretVariableRefenrence") + stringRepForEnv(G) + " |- " + stringRep(varRef) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretVariableRefenrence) {
    	interpretThrowException(ruleName("InterpretVariableRefenrence") + stringRepForEnv(G) + " |- " + stringRep(varRef) + " ~> " + "Object",
    		INTERPRETVARIABLEREFENRENCE,
    		e_applyRuleInterpretVariableRefenrence, varRef, new ErrorInformation[] {new ErrorInformation(varRef)});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleInterpretVariableRefenrence(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VariableReference varRef) throws RuleFailedException {
    Object result = null; // output parameter
    /* G |- varRef.ref.expression ~> result */
    Expression _expression = varRef.getRef().getExpression();
    Result<Object> result_1 = interpretInternal(G, _trace_, _expression);
    checkAssignableTo(result_1.getFirst(), Object.class);
    result = (Object) result_1.getFirst();
    
    return new Result<Object>(result);
  }
}
