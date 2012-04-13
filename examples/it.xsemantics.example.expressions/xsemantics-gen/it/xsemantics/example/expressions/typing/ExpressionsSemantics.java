package it.xsemantics.example.expressions.typing;

import it.xsemantics.example.expressions.expressions.AndOrExpression;
import it.xsemantics.example.expressions.expressions.ArithmeticSigned;
import it.xsemantics.example.expressions.expressions.BooleanLiteral;
import it.xsemantics.example.expressions.expressions.BooleanNegation;
import it.xsemantics.example.expressions.expressions.BooleanType;
import it.xsemantics.example.expressions.expressions.Comparison;
import it.xsemantics.example.expressions.expressions.Equals;
import it.xsemantics.example.expressions.expressions.Expression;
import it.xsemantics.example.expressions.expressions.ExpressionsFactory;
import it.xsemantics.example.expressions.expressions.ExpressionsPackage;
import it.xsemantics.example.expressions.expressions.IntType;
import it.xsemantics.example.expressions.expressions.Minus;
import it.xsemantics.example.expressions.expressions.MultiOrDiv;
import it.xsemantics.example.expressions.expressions.NumberLiteral;
import it.xsemantics.example.expressions.expressions.Plus;
import it.xsemantics.example.expressions.expressions.StringLiteral;
import it.xsemantics.example.expressions.expressions.StringType;
import it.xsemantics.example.expressions.expressions.Type;
import it.xsemantics.example.expressions.expressions.Variable;
import it.xsemantics.example.expressions.expressions.VariableReference;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

public class ExpressionsSemantics extends XsemanticsRuntimeSystem {
	public final static String NUMERALLITERAL = "it.xsemantics.example.expressions.typing.rules.NumeralLiteral";
	public final static String BOOLEANLITERAL = "it.xsemantics.example.expressions.typing.rules.BooleanLiteral";
	public final static String STRINGLITERAL = "it.xsemantics.example.expressions.typing.rules.StringLiteral";
	public final static String MULTIORDIV = "it.xsemantics.example.expressions.typing.rules.MultiOrDiv";
	public final static String MINUS = "it.xsemantics.example.expressions.typing.rules.Minus";
	public final static String PLUS = "it.xsemantics.example.expressions.typing.rules.Plus";
	public final static String COMPARISON = "it.xsemantics.example.expressions.typing.rules.Comparison";
	public final static String EQUALS = "it.xsemantics.example.expressions.typing.rules.Equals";
	public final static String BOOLEANNEGATION = "it.xsemantics.example.expressions.typing.rules.BooleanNegation";
	public final static String ANDOR = "it.xsemantics.example.expressions.typing.rules.AndOr";
	public final static String ARITHMETICSIGNED = "it.xsemantics.example.expressions.typing.rules.ArithmeticSigned";
	public final static String STRINGTOINT = "it.xsemantics.example.expressions.typing.rules.StringToInt";
	public final static String STRINGTOBOOL = "it.xsemantics.example.expressions.typing.rules.StringToBool";
	public final static String INTTOINT = "it.xsemantics.example.expressions.typing.rules.IntToInt";
	public final static String BOOLTOBOOL = "it.xsemantics.example.expressions.typing.rules.BoolToBool";
	public final static String VARIABLEREFERENCE = "it.xsemantics.example.expressions.typing.rules.VariableReference";
	public final static String VARIABLE = "it.xsemantics.example.expressions.typing.rules.Variable";
	public final static String INTERPRETNUMBERLITERAL = "it.xsemantics.example.expressions.typing.rules.InterpretNumberLiteral";
	public final static String INTERPRETSTRINGLITERAL = "it.xsemantics.example.expressions.typing.rules.InterpretStringLiteral";
	public final static String INTERPRETBOOLEANLITERAL = "it.xsemantics.example.expressions.typing.rules.InterpretBooleanLiteral";
	public final static String INTERPRETMINUS = "it.xsemantics.example.expressions.typing.rules.InterpretMinus";
	public final static String INTERPRETMULTIORDIV = "it.xsemantics.example.expressions.typing.rules.InterpretMultiOrDiv";
	public final static String INTERPRETARITHMETICSIGNED = "it.xsemantics.example.expressions.typing.rules.InterpretArithmeticSigned";
	public final static String INTERPRETANDOR = "it.xsemantics.example.expressions.typing.rules.InterpretAndOr";
	public final static String INTERPRETBOOLEANNEGATION = "it.xsemantics.example.expressions.typing.rules.InterpretBooleanNegation";
	public final static String INTERPRETCOMPARISON = "it.xsemantics.example.expressions.typing.rules.InterpretComparison";
	public final static String INTERPRETEQUALS = "it.xsemantics.example.expressions.typing.rules.InterpretEquals";
	public final static String INTERPRETPLUS = "it.xsemantics.example.expressions.typing.rules.InterpretPlus";
	public final static String INTERPRETVARIABLEREFENRENCE = "it.xsemantics.example.expressions.typing.rules.InterpretVariableRefenrence";

	protected PolymorphicDispatcher<Result<Type>> typeDispatcher;
	
	protected PolymorphicDispatcher<Result<Type>> vartypeDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> coerceDispatcher;
	
	protected PolymorphicDispatcher<Result<Object>> interpretDispatcher;

	public ExpressionsSemantics() {
		init();
	}

	public void init() {
		typeDispatcher = buildPolymorphicDispatcher1(
			"typeImpl", 3, "|-", ":");
		vartypeDispatcher = buildPolymorphicDispatcher1(
			"vartypeImpl", 3, "||-", ":");
		coerceDispatcher = buildPolymorphicDispatcher1(
			"coerceImpl", 4, "|~", "|>");
		interpretDispatcher = buildPolymorphicDispatcher1(
			"interpretImpl", 3, "|-", "~>");
	}

	public Result<Type> type(final Expression expression) {
		return type(new RuleEnvironment(),
			null, expression);
	}
	
	public Result<Type> type(final RuleEnvironment _environment_,
			final Expression expression) {
		return type(_environment_,
			null, expression);
	}
	
	public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression) {
		try {
			return typeInternal(_environment_, _trace_, expression);
		} catch (Exception _e_type) {
			return resultForFailure(_e_type);
		}
	}
	
	public Result<Type> vartype(final Variable variable) {
		return vartype(new RuleEnvironment(),
			null, variable);
	}
	
	public Result<Type> vartype(final RuleEnvironment _environment_,
			final Variable variable) {
		return vartype(_environment_,
			null, variable);
	}
	
	public Result<Type> vartype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Variable variable) {
		try {
			return vartypeInternal(_environment_, _trace_, variable);
		} catch (Exception _e_vartype) {
			return resultForFailure(_e_vartype);
		}
	}
	
	public Result<Boolean> coerce(final Expression expression, final Type expectedType) {
		return coerce(new RuleEnvironment(),
			null, expression, expectedType);
	}
	
	public Result<Boolean> coerce(final RuleEnvironment _environment_,
			final Expression expression, final Type expectedType) {
		return coerce(_environment_,
			null, expression, expectedType);
	}
	
	public Result<Boolean> coerce(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression, final Type expectedType) {
		try {
			return coerceInternal(_environment_, _trace_, expression, expectedType);
		} catch (Exception _e_coerce) {
			return resultForFailure(_e_coerce);
		}
	}
	
	public Result<Object> interpret(final Expression expression) {
		return interpret(new RuleEnvironment(),
			null, expression);
	}
	
	public Result<Object> interpret(final RuleEnvironment _environment_,
			final Expression expression) {
		return interpret(_environment_,
			null, expression);
	}
	
	public Result<Object> interpret(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression) {
		try {
			return interpretInternal(_environment_, _trace_, expression);
		} catch (Exception _e_interpret) {
			return resultForFailure(_e_interpret);
		}
	}

	public Result<Boolean> checkVariable(final Variable variable) {
		try {
			return checkVariableInternal(null, variable);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> checkVariableInternal(final RuleApplicationTrace _trace_, final Variable variable) 
			throws RuleFailedException {
		
		/* empty ||- variable : var Type type */
		Type type = null;
		Result<Type> result = vartypeInternal(emptyEnvironment(), _trace_, variable);
		checkAssignableTo(result.getFirst(), Type.class);
		type = (Type) result.getFirst();
		return new Result<Boolean>(true);
	}

	protected void typeThrowException(String _issue, Exception _ex, final Expression expression) 
			throws RuleFailedException {
		
		String _stringRep = this.stringRep(expression);
		String _operator_plus = StringExtensions.operator_plus("cannot type ", _stringRep);
		String error = _operator_plus;
		EObject source = expression;
		throwRuleFailedException(error,
				_issue, _ex,
				new ErrorInformation(source, null));
	}
	
	protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression) {
		try {
			checkParamsNotNull(expression);
			return typeDispatcher.invoke(_environment_, _trace_, expression);
		} catch (Exception _e_type) {
			sneakyThrowRuleFailedException(_e_type);
			return null;
		}
	}
	
	protected void vartypeThrowException(String _issue, Exception _ex, final Variable variable) 
			throws RuleFailedException {
		
		String _stringRep = this.stringRep(variable);
		String _operator_plus = StringExtensions.operator_plus("cannot type ", _stringRep);
		String error = _operator_plus;
		EObject source = variable;
		EReference _variable_Expression = ExpressionsPackage.eINSTANCE.getVariable_Expression();
		EStructuralFeature feature = _variable_Expression;
		throwRuleFailedException(error,
				_issue, _ex,
				new ErrorInformation(source, feature));
	}
	
	protected Result<Type> vartypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Variable variable) {
		try {
			checkParamsNotNull(variable);
			return vartypeDispatcher.invoke(_environment_, _trace_, variable);
		} catch (Exception _e_vartype) {
			sneakyThrowRuleFailedException(_e_vartype);
			return null;
		}
	}
	
	protected void coerceThrowException(String _issue, Exception _ex, final Expression expression, final Type expectedType) 
			throws RuleFailedException {
		
		String _stringRep = this.stringRep(expression);
		String _operator_plus = StringExtensions.operator_plus("cannot convert ", _stringRep);
		String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " to type ");
		String _stringRep_1 = this.stringRep(expectedType);
		String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _stringRep_1);
		String error = _operator_plus_2;
		EObject source = expression;
		throwRuleFailedException(error,
				_issue, _ex,
				new ErrorInformation(source, null));
	}
	
	protected Result<Boolean> coerceInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression, final Type expectedType) {
		try {
			checkParamsNotNull(expression, expectedType);
			return coerceDispatcher.invoke(_environment_, _trace_, expression, expectedType);
		} catch (Exception _e_coerce) {
			sneakyThrowRuleFailedException(_e_coerce);
			return null;
		}
	}
	
	protected Result<Object> interpretInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Expression expression) {
		try {
			checkParamsNotNull(expression);
			return interpretDispatcher.invoke(_environment_, _trace_, expression);
		} catch (Exception _e_interpret) {
			sneakyThrowRuleFailedException(_e_interpret);
			return null;
		}
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final NumberLiteral num) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleNumeralLiteral(G, _subtrace_, num);
			addToTrace(_trace_, ruleName("NumeralLiteral") + stringRepForEnv(G) + " |- " + stringRep(num) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleNumeralLiteral) {
			typeThrowException(NUMERALLITERAL,
				e_applyRuleNumeralLiteral, num);
			return null;
		}
	}
	
	protected Result<Type> applyRuleNumeralLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final NumberLiteral num) 
			throws RuleFailedException {
		
		IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
		return new Result<Type>(_createIntType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanLiteral bool) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleBooleanLiteral(G, _subtrace_, bool);
			addToTrace(_trace_, ruleName("BooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(bool) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleBooleanLiteral) {
			typeThrowException(BOOLEANLITERAL,
				e_applyRuleBooleanLiteral, bool);
			return null;
		}
	}
	
	protected Result<Type> applyRuleBooleanLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanLiteral bool) 
			throws RuleFailedException {
		
		BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
		return new Result<Type>(_createBooleanType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringLiteral str) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleStringLiteral(G, _subtrace_, str);
			addToTrace(_trace_, ruleName("StringLiteral") + stringRepForEnv(G) + " |- " + stringRep(str) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleStringLiteral) {
			typeThrowException(STRINGLITERAL,
				e_applyRuleStringLiteral, str);
			return null;
		}
	}
	
	protected Result<Type> applyRuleStringLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringLiteral str) 
			throws RuleFailedException {
		Type resultType = null;
		
		/* { val expected = env(G, 'expected', Type) G |~ str |> expected resultType = expected } or resultType = ExpressionsFactory::eINSTANCE.createStringType */
		try {
		  Type _xblockexpression = null;
		  {
		    /* env(G, 'expected', Type) */
		    Type _environmentaccess = environmentAccess(G, "expected", Type.class);
		    final Type expected = _environmentaccess;
		    /* G |~ str |> expected */
		    coerceInternal(G, _trace_, str, expected);
		    Type _resultType = resultType = expected;
		    _xblockexpression = (_resultType);
		  }
		} catch (Exception e) {
		  StringType _createStringType = ExpressionsFactory.eINSTANCE.createStringType();
		  resultType = _createStringType;
		}
		return new Result<Type>(resultType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final MultiOrDiv multiOrDiv) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleMultiOrDiv(G, _subtrace_, multiOrDiv);
			addToTrace(_trace_, ruleName("MultiOrDiv") + stringRepForEnv(G) + " |- " + stringRep(multiOrDiv) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleMultiOrDiv) {
			typeThrowException(MULTIORDIV,
				e_applyRuleMultiOrDiv, multiOrDiv);
			return null;
		}
	}
	
	protected Result<Type> applyRuleMultiOrDiv(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final MultiOrDiv multiOrDiv) 
			throws RuleFailedException {
		
		{
		  IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
		  IntType intType = _createIntType;
		  /* G, 'expected' <- intType |- multiOrDiv.left : intType */
		  Expression _left = multiOrDiv.getLeft();
		  Result<Type> result = typeInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _left);
		  checkAssignableTo(result.getFirst(), IntType.class);
		  intType = (IntType) result.getFirst();
		  
		  /* G, 'expected' <- intType |- multiOrDiv.right : intType */
		  Expression _right = multiOrDiv.getRight();
		  Result<Type> result_1 = typeInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _right);
		  checkAssignableTo(result_1.getFirst(), IntType.class);
		  intType = (IntType) result_1.getFirst();
		  
		}
		IntType _createIntType_1 = ExpressionsFactory.eINSTANCE.createIntType();
		return new Result<Type>(_createIntType_1);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Minus minus) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleMinus(G, _subtrace_, minus);
			addToTrace(_trace_, ruleName("Minus") + stringRepForEnv(G) + " |- " + stringRep(minus) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleMinus) {
			typeThrowException(MINUS,
				e_applyRuleMinus, minus);
			return null;
		}
	}
	
	protected Result<Type> applyRuleMinus(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Minus minus) 
			throws RuleFailedException {
		
		{
		  IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
		  IntType intType = _createIntType;
		  /* G, 'expected' <- intType |- minus.left : intType */
		  Expression _left = minus.getLeft();
		  Result<Type> result = typeInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _left);
		  checkAssignableTo(result.getFirst(), IntType.class);
		  intType = (IntType) result.getFirst();
		  
		  /* G, 'expected' <- intType |- minus.right : intType */
		  Expression _right = minus.getRight();
		  Result<Type> result_1 = typeInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _right);
		  checkAssignableTo(result_1.getFirst(), IntType.class);
		  intType = (IntType) result_1.getFirst();
		  
		}
		IntType _createIntType_1 = ExpressionsFactory.eINSTANCE.createIntType();
		return new Result<Type>(_createIntType_1);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Plus plus) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRulePlus(G, _subtrace_, plus);
			addToTrace(_trace_, ruleName("Plus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRulePlus) {
			typeThrowException(PLUS,
				e_applyRulePlus, plus);
			return null;
		}
	}
	
	protected Result<Type> applyRulePlus(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Plus plus) 
			throws RuleFailedException {
		Type type = null;
		
		{
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
		  
		  /* { val expected = env(G, 'expected', Type) G |~ plus.left |> expected G |~ plus.right |> expected type = expected } or { (leftType instanceof StringType || rightType instanceof StringType) type = ExpressionsFactory::eINSTANCE.createStringType } or { (leftType instanceof IntType && rightType instanceof IntType) type = leftType } */
		  try {
		    Type _xblockexpression = null;
		    {
		      /* env(G, 'expected', Type) */
		      Type _environmentaccess = environmentAccess(G, "expected", Type.class);
		      final Type expected = _environmentaccess;
		      /* G |~ plus.left |> expected */
		      Expression _left_1 = plus.getLeft();
		      coerceInternal(G, _trace_, _left_1, expected);
		      /* G |~ plus.right |> expected */
		      Expression _right_1 = plus.getRight();
		      coerceInternal(G, _trace_, _right_1, expected);
		      Type _type = type = expected;
		      _xblockexpression = (_type);
		    }
		  } catch (Exception e) {
		    /* { (leftType instanceof StringType || rightType instanceof StringType) type = ExpressionsFactory::eINSTANCE.createStringType } or { (leftType instanceof IntType && rightType instanceof IntType) type = leftType } */
		    try {
		      Type _xblockexpression_1 = null;
		      {
		        boolean _operator_or = false;
		        if ((leftType instanceof StringType)) {
		          _operator_or = true;
		        } else {
		          _operator_or = BooleanExtensions.operator_or((leftType instanceof StringType), (rightType instanceof StringType));
		        }
		        /* leftType instanceof StringType || rightType instanceof StringType */
		        if (!_operator_or) {
		          sneakyThrowRuleFailedException("leftType instanceof StringType || rightType instanceof StringType");
		        }
		        StringType _createStringType = ExpressionsFactory.eINSTANCE.createStringType();
		        Type _type_1 = type = _createStringType;
		        _xblockexpression_1 = (_type_1);
		      }
		    } catch (Exception e_1) {
		      {
		        boolean _operator_and = false;
		        if (!(leftType instanceof IntType)) {
		          _operator_and = false;
		        } else {
		          _operator_and = BooleanExtensions.operator_and((leftType instanceof IntType), (rightType instanceof IntType));
		        }
		        /* leftType instanceof IntType && rightType instanceof IntType */
		        if (!_operator_and) {
		          sneakyThrowRuleFailedException("leftType instanceof IntType && rightType instanceof IntType");
		        }
		        type = leftType;
		      }
		    }
		  }
		}
		return new Result<Type>(type);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Comparison comparison) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleComparison(G, _subtrace_, comparison);
			addToTrace(_trace_, ruleName("Comparison") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleComparison) {
			typeThrowException(COMPARISON,
				e_applyRuleComparison, comparison);
			return null;
		}
	}
	
	protected Result<Type> applyRuleComparison(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Comparison comparison) 
			throws RuleFailedException {
		
		{
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
		  
		  boolean _operator_or = false;
		  boolean _operator_and = false;
		  if (!(leftType instanceof IntType)) {
		    _operator_and = false;
		  } else {
		    _operator_and = BooleanExtensions.operator_and((leftType instanceof IntType), (rightType instanceof IntType));
		  }
		  if (_operator_and) {
		    _operator_or = true;
		  } else {
		    boolean _operator_and_1 = false;
		    if (!(leftType instanceof StringType)) {
		      _operator_and_1 = false;
		    } else {
		      _operator_and_1 = BooleanExtensions.operator_and((leftType instanceof StringType), (rightType instanceof StringType));
		    }
		    _operator_or = BooleanExtensions.operator_or(_operator_and, _operator_and_1);
		  }
		  /* (leftType instanceof IntType && rightType instanceof IntType) || (leftType instanceof StringType && rightType instanceof StringType) */
		  if (!_operator_or) {
		    sneakyThrowRuleFailedException("(leftType instanceof IntType && rightType instanceof IntType) || (leftType instanceof StringType && rightType instanceof StringType)");
		  }
		}
		BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
		return new Result<Type>(_createBooleanType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Equals comparison) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleEquals(G, _subtrace_, comparison);
			addToTrace(_trace_, ruleName("Equals") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleEquals) {
			typeThrowException(EQUALS,
				e_applyRuleEquals, comparison);
			return null;
		}
	}
	
	protected Result<Type> applyRuleEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Equals comparison) 
			throws RuleFailedException {
		
		{
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
		  boolean _operator_equals = ObjectExtensions.operator_equals(_eClass, _eClass_1);
		  /* leftType.eClass == rightType.eClass */
		  if (!_operator_equals) {
		    sneakyThrowRuleFailedException("leftType.eClass == rightType.eClass");
		  }
		}
		BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
		return new Result<Type>(_createBooleanType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanNegation negation) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleBooleanNegation(G, _subtrace_, negation);
			addToTrace(_trace_, ruleName("BooleanNegation") + stringRepForEnv(G) + " |- " + stringRep(negation) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleBooleanNegation) {
			typeThrowException(BOOLEANNEGATION,
				e_applyRuleBooleanNegation, negation);
			return null;
		}
	}
	
	protected Result<Type> applyRuleBooleanNegation(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanNegation negation) 
			throws RuleFailedException {
		BooleanType boolType = null;
		
		{
		  BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
		  boolType = _createBooleanType;
		  /* G, 'expected' <- boolType |- negation.expression : boolType */
		  Expression _expression = negation.getExpression();
		  Result<Type> result = typeInternal(environmentComposition(
		    G, environmentEntry("expected", boolType)
		  ), _trace_, _expression);
		  checkAssignableTo(result.getFirst(), BooleanType.class);
		  boolType = (BooleanType) result.getFirst();
		  
		}
		return new Result<Type>(boolType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final AndOrExpression andOr) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleAndOr(G, _subtrace_, andOr);
			addToTrace(_trace_, ruleName("AndOr") + stringRepForEnv(G) + " |- " + stringRep(andOr) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleAndOr) {
			typeThrowException(ANDOR,
				e_applyRuleAndOr, andOr);
			return null;
		}
	}
	
	protected Result<Type> applyRuleAndOr(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final AndOrExpression andOr) 
			throws RuleFailedException {
		BooleanType boolType = null;
		
		{
		  BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
		  boolType = _createBooleanType;
		  /* G, 'expected' <- boolType |- andOr.left : boolType */
		  Expression _left = andOr.getLeft();
		  Result<Type> result = typeInternal(environmentComposition(
		    G, environmentEntry("expected", boolType)
		  ), _trace_, _left);
		  checkAssignableTo(result.getFirst(), BooleanType.class);
		  boolType = (BooleanType) result.getFirst();
		  
		  /* G, 'expected' <- boolType |- andOr.right : boolType */
		  Expression _right = andOr.getRight();
		  Result<Type> result_1 = typeInternal(environmentComposition(
		    G, environmentEntry("expected", boolType)
		  ), _trace_, _right);
		  checkAssignableTo(result_1.getFirst(), BooleanType.class);
		  boolType = (BooleanType) result_1.getFirst();
		  
		}
		return new Result<Type>(boolType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ArithmeticSigned signed) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleArithmeticSigned(G, _subtrace_, signed);
			addToTrace(_trace_, ruleName("ArithmeticSigned") + stringRepForEnv(G) + " |- " + stringRep(signed) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleArithmeticSigned) {
			typeThrowException(ARITHMETICSIGNED,
				e_applyRuleArithmeticSigned, signed);
			return null;
		}
	}
	
	protected Result<Type> applyRuleArithmeticSigned(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ArithmeticSigned signed) 
			throws RuleFailedException {
		
		{
		  IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
		  IntType intType = _createIntType;
		  /* G, 'expected' <- intType |- signed.expression : intType */
		  Expression _expression = signed.getExpression();
		  Result<Type> result = typeInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _expression);
		  checkAssignableTo(result.getFirst(), IntType.class);
		  intType = (IntType) result.getFirst();
		  
		}
		IntType _createIntType_1 = ExpressionsFactory.eINSTANCE.createIntType();
		return new Result<Type>(_createIntType_1);
	}
	
	protected Result<Boolean> coerceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringLiteral string, final IntType type) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleStringToInt(G, _subtrace_, string, type);
			addToTrace(_trace_, ruleName("StringToInt") + stringRepForEnv(G) + " |~ " + stringRep(string) + " |> " + stringRep(type));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleStringToInt) {
			coerceThrowException(STRINGTOINT,
				e_applyRuleStringToInt, string, type);
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleStringToInt(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringLiteral string, final IntType type) 
			throws RuleFailedException {
		
		String _value = string.getValue();
		Integer.parseInt(_value);
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> coerceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringLiteral string, final BooleanType type) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleStringToBool(G, _subtrace_, string, type);
			addToTrace(_trace_, ruleName("StringToBool") + stringRepForEnv(G) + " |~ " + stringRep(string) + " |> " + stringRep(type));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleStringToBool) {
			coerceThrowException(STRINGTOBOOL,
				e_applyRuleStringToBool, string, type);
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleStringToBool(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringLiteral string, final BooleanType type) 
			throws RuleFailedException {
		
		boolean _operator_or = false;
		String _value = string.getValue();
		boolean _equalsIgnoreCase = _value.equalsIgnoreCase("true");
		if (_equalsIgnoreCase) {
		  _operator_or = true;
		} else {
		  String _value_1 = string.getValue();
		  boolean _equalsIgnoreCase_1 = _value_1.equalsIgnoreCase("false");
		  _operator_or = BooleanExtensions.operator_or(_equalsIgnoreCase, _equalsIgnoreCase_1);
		}
		/* string.value.equalsIgnoreCase("true") || string.value.equalsIgnoreCase("false") */
		if (!_operator_or) {
		  sneakyThrowRuleFailedException("string.value.equalsIgnoreCase(\"true\") || string.value.equalsIgnoreCase(\"false\")");
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> coerceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final NumberLiteral number, final IntType type) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleIntToInt(G, _subtrace_, number, type);
			addToTrace(_trace_, ruleName("IntToInt") + stringRepForEnv(G) + " |~ " + stringRep(number) + " |> " + stringRep(type));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleIntToInt) {
			coerceThrowException(INTTOINT,
				e_applyRuleIntToInt, number, type);
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleIntToInt(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final NumberLiteral number, final IntType type) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> coerceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanLiteral bool, final BooleanType type) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleBoolToBool(G, _subtrace_, bool, type);
			addToTrace(_trace_, ruleName("BoolToBool") + stringRepForEnv(G) + " |~ " + stringRep(bool) + " |> " + stringRep(type));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleBoolToBool) {
			coerceThrowException(BOOLTOBOOL,
				e_applyRuleBoolToBool, bool, type);
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleBoolToBool(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanLiteral bool, final BooleanType type) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final VariableReference varRef) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleVariableReference(G, _subtrace_, varRef);
			addToTrace(_trace_, ruleName("VariableReference") + stringRepForEnv(G) + " |- " + stringRep(varRef) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleVariableReference) {
			typeThrowException(VARIABLEREFERENCE,
				e_applyRuleVariableReference, varRef);
			return null;
		}
	}
	
	protected Result<Type> applyRuleVariableReference(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final VariableReference varRef) 
			throws RuleFailedException {
		Type type = null;
		
		/* G ||- varRef.ref : type */
		Variable _ref = varRef.getRef();
		Result<Type> result = vartypeInternal(G, _trace_, _ref);
		checkAssignableTo(result.getFirst(), Type.class);
		type = (Type) result.getFirst();
		
		return new Result<Type>(type);
	}
	
	protected Result<Type> vartypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Variable variable) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleVariable(G, _subtrace_, variable);
			addToTrace(_trace_, ruleName("Variable") + stringRepForEnv(G) + " ||- " + stringRep(variable) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleVariable) {
			vartypeThrowException(VARIABLE,
				e_applyRuleVariable, variable);
			return null;
		}
	}
	
	protected Result<Type> applyRuleVariable(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Variable variable) 
			throws RuleFailedException {
		Type type = null;
		
		{
		  Expression _expression = variable.getExpression();
		  boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_expression, null);
		  /* variable.expression != null */
		  if (!_operator_notEquals) {
		    sneakyThrowRuleFailedException("variable.expression != null");
		  }
		  /* G |- variable.expression : type */
		  Expression _expression_1 = variable.getExpression();
		  Result<Type> result = typeInternal(G, _trace_, _expression_1);
		  checkAssignableTo(result.getFirst(), Type.class);
		  type = (Type) result.getFirst();
		  
		}
		return new Result<Type>(type);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final NumberLiteral number) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretNumberLiteral(G, _subtrace_, number);
			addToTrace(_trace_, ruleName("InterpretNumberLiteral") + stringRepForEnv(G) + " |- " + stringRep(number) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretNumberLiteral) {
			throwRuleFailedException(ruleName("InterpretNumberLiteral") + stringRepForEnv(G) + " |- " + stringRep(number) + " ~> " + "int",
				INTERPRETNUMBERLITERAL,
				e_applyRuleInterpretNumberLiteral, new ErrorInformation(number));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretNumberLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final NumberLiteral number) 
			throws RuleFailedException {
		
		int _value = number.getValue();
		return new Result<Object>(_value);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringLiteral string) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretStringLiteral(G, _subtrace_, string);
			addToTrace(_trace_, ruleName("InterpretStringLiteral") + stringRepForEnv(G) + " |- " + stringRep(string) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretStringLiteral) {
			throwRuleFailedException(ruleName("InterpretStringLiteral") + stringRepForEnv(G) + " |- " + stringRep(string) + " ~> " + "Object",
				INTERPRETSTRINGLITERAL,
				e_applyRuleInterpretStringLiteral, new ErrorInformation(string));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretStringLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final StringLiteral string) 
			throws RuleFailedException {
		Object result = null;
		
		{
		  Type expected = null;
		  /* { expected = env(G, 'expected', IntType) result = Integer::parseInt(string.value) } or { expected = env(G, 'expected', BooleanType) result = Boolean::parseBoolean(string.value) } or result = string.value */
		  try {
		    Object _xblockexpression = null;
		    {
		      /* env(G, 'expected', IntType) */
		      IntType _environmentaccess = environmentAccess(G, "expected", IntType.class);
		      expected = _environmentaccess;
		      String _value = string.getValue();
		      int _parseInt = Integer.parseInt(_value);
		      Object _result = result = Integer.valueOf(_parseInt);
		      _xblockexpression = (_result);
		    }
		  } catch (Exception e) {
		    /* { expected = env(G, 'expected', BooleanType) result = Boolean::parseBoolean(string.value) } or result = string.value */
		    try {
		      Object _xblockexpression_1 = null;
		      {
		        /* env(G, 'expected', BooleanType) */
		        BooleanType _environmentaccess_1 = environmentAccess(G, "expected", BooleanType.class);
		        expected = _environmentaccess_1;
		        String _value_1 = string.getValue();
		        boolean _parseBoolean = Boolean.parseBoolean(_value_1);
		        Object _result_1 = result = Boolean.valueOf(_parseBoolean);
		        _xblockexpression_1 = (_result_1);
		      }
		    } catch (Exception e_1) {
		      String _value_2 = string.getValue();
		      result = _value_2;
		    }
		  }
		}
		return new Result<Object>(result);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanLiteral bool) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretBooleanLiteral(G, _subtrace_, bool);
			addToTrace(_trace_, ruleName("InterpretBooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(bool) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretBooleanLiteral) {
			throwRuleFailedException(ruleName("InterpretBooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(bool) + " ~> " + "Boolean",
				INTERPRETBOOLEANLITERAL,
				e_applyRuleInterpretBooleanLiteral, new ErrorInformation(bool));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretBooleanLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanLiteral bool) 
			throws RuleFailedException {
		
		String _value = bool.getValue();
		Boolean _valueOf = Boolean.valueOf(_value);
		return new Result<Object>(_valueOf);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Minus plus) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretMinus(G, _subtrace_, plus);
			addToTrace(_trace_, ruleName("InterpretMinus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretMinus) {
			throwRuleFailedException(ruleName("InterpretMinus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " ~> " + "Integer",
				INTERPRETMINUS,
				e_applyRuleInterpretMinus, new ErrorInformation(plus));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretMinus(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Minus plus) 
			throws RuleFailedException {
		Integer result = null;
		
		{
		  IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
		  IntType intType = _createIntType;
		  /* G, 'expected' <- intType |- plus.left ~> var Integer leftResult */
		  Expression _left = plus.getLeft();
		  Integer leftResult = null;
		  Result<Object> result_1 = interpretInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _left);
		  checkAssignableTo(result_1.getFirst(), Integer.class);
		  leftResult = (Integer) result_1.getFirst();
		  
		  /* G, 'expected' <- intType |- plus.right ~> var Integer rightResult */
		  Expression _right = plus.getRight();
		  Integer rightResult = null;
		  Result<Object> result_2 = interpretInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _right);
		  checkAssignableTo(result_2.getFirst(), Integer.class);
		  rightResult = (Integer) result_2.getFirst();
		  
		  int _intValue = leftResult.intValue();
		  int _intValue_1 = rightResult.intValue();
		  int _operator_minus = IntegerExtensions.operator_minus(_intValue, _intValue_1);
		  result = Integer.valueOf(_operator_minus);
		}
		return new Result<Object>(result);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final MultiOrDiv multiOrDiv) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretMultiOrDiv(G, _subtrace_, multiOrDiv);
			addToTrace(_trace_, ruleName("InterpretMultiOrDiv") + stringRepForEnv(G) + " |- " + stringRep(multiOrDiv) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretMultiOrDiv) {
			throwRuleFailedException(ruleName("InterpretMultiOrDiv") + stringRepForEnv(G) + " |- " + stringRep(multiOrDiv) + " ~> " + "Integer",
				INTERPRETMULTIORDIV,
				e_applyRuleInterpretMultiOrDiv, new ErrorInformation(multiOrDiv));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretMultiOrDiv(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final MultiOrDiv multiOrDiv) 
			throws RuleFailedException {
		Integer result = null;
		
		{
		  IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
		  IntType intType = _createIntType;
		  /* G, 'expected' <- intType |- multiOrDiv.left ~> var Integer leftResult */
		  Expression _left = multiOrDiv.getLeft();
		  Integer leftResult = null;
		  Result<Object> result_1 = interpretInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _left);
		  checkAssignableTo(result_1.getFirst(), Integer.class);
		  leftResult = (Integer) result_1.getFirst();
		  
		  /* G, 'expected' <- intType |- multiOrDiv.right ~> var Integer rightResult */
		  Expression _right = multiOrDiv.getRight();
		  Integer rightResult = null;
		  Result<Object> result_2 = interpretInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _right);
		  checkAssignableTo(result_2.getFirst(), Integer.class);
		  rightResult = (Integer) result_2.getFirst();
		  
		  String _op = multiOrDiv.getOp();
		  boolean _operator_equals = ObjectExtensions.operator_equals(_op, "*");
		  if (_operator_equals) {
		    int _intValue = leftResult.intValue();
		    int _intValue_1 = rightResult.intValue();
		    int _operator_multiply = IntegerExtensions.operator_multiply(_intValue, _intValue_1);
		    result = Integer.valueOf(_operator_multiply);
		  } else {
		    int _intValue_2 = leftResult.intValue();
		    int _intValue_3 = rightResult.intValue();
		    int _operator_divide = IntegerExtensions.operator_divide(_intValue_2, _intValue_3);
		    result = Integer.valueOf(_operator_divide);
		  }
		}
		return new Result<Object>(result);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ArithmeticSigned signed) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretArithmeticSigned(G, _subtrace_, signed);
			addToTrace(_trace_, ruleName("InterpretArithmeticSigned") + stringRepForEnv(G) + " |- " + stringRep(signed) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretArithmeticSigned) {
			throwRuleFailedException(ruleName("InterpretArithmeticSigned") + stringRepForEnv(G) + " |- " + stringRep(signed) + " ~> " + "Integer",
				INTERPRETARITHMETICSIGNED,
				e_applyRuleInterpretArithmeticSigned, new ErrorInformation(signed));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretArithmeticSigned(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final ArithmeticSigned signed) 
			throws RuleFailedException {
		Integer result = null;
		
		{
		  IntType _createIntType = ExpressionsFactory.eINSTANCE.createIntType();
		  IntType intType = _createIntType;
		  /* G, 'expected' <- intType |- signed.expression ~> var Integer expResult */
		  Expression _expression = signed.getExpression();
		  Integer expResult = null;
		  Result<Object> result_1 = interpretInternal(environmentComposition(
		    G, environmentEntry("expected", intType)
		  ), _trace_, _expression);
		  checkAssignableTo(result_1.getFirst(), Integer.class);
		  expResult = (Integer) result_1.getFirst();
		  
		  int _operator_minus = IntegerExtensions.operator_minus(expResult);
		  result = Integer.valueOf(_operator_minus);
		}
		return new Result<Object>(result);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final AndOrExpression andOr) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretAndOr(G, _subtrace_, andOr);
			addToTrace(_trace_, ruleName("InterpretAndOr") + stringRepForEnv(G) + " |- " + stringRep(andOr) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretAndOr) {
			throwRuleFailedException(ruleName("InterpretAndOr") + stringRepForEnv(G) + " |- " + stringRep(andOr) + " ~> " + "Boolean",
				INTERPRETANDOR,
				e_applyRuleInterpretAndOr, new ErrorInformation(andOr));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretAndOr(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final AndOrExpression andOr) 
			throws RuleFailedException {
		Boolean result = null;
		
		{
		  BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
		  BooleanType boolType = _createBooleanType;
		  /* G, 'expected' <- boolType |- andOr.left ~> var Boolean leftResult */
		  Expression _left = andOr.getLeft();
		  Boolean leftResult = null;
		  Result<Object> result_1 = interpretInternal(environmentComposition(
		    G, environmentEntry("expected", boolType)
		  ), _trace_, _left);
		  checkAssignableTo(result_1.getFirst(), Boolean.class);
		  leftResult = (Boolean) result_1.getFirst();
		  
		  /* G, 'expected' <- boolType |- andOr.right ~> var Boolean rightResult */
		  Expression _right = andOr.getRight();
		  Boolean rightResult = null;
		  Result<Object> result_2 = interpretInternal(environmentComposition(
		    G, environmentEntry("expected", boolType)
		  ), _trace_, _right);
		  checkAssignableTo(result_2.getFirst(), Boolean.class);
		  rightResult = (Boolean) result_2.getFirst();
		  
		  String _op = andOr.getOp();
		  boolean _operator_equals = ObjectExtensions.operator_equals(_op, "&&");
		  if (_operator_equals) {
		    boolean _operator_and = false;
		    boolean _booleanValue = leftResult.booleanValue();
		    if (!_booleanValue) {
		      _operator_and = false;
		    } else {
		      boolean _booleanValue_1 = rightResult.booleanValue();
		      _operator_and = BooleanExtensions.operator_and(_booleanValue, _booleanValue_1);
		    }
		    result = Boolean.valueOf(_operator_and);
		  } else {
		    boolean _operator_or = false;
		    boolean _booleanValue_2 = leftResult.booleanValue();
		    if (_booleanValue_2) {
		      _operator_or = true;
		    } else {
		      boolean _booleanValue_3 = rightResult.booleanValue();
		      _operator_or = BooleanExtensions.operator_or(_booleanValue_2, _booleanValue_3);
		    }
		    result = Boolean.valueOf(_operator_or);
		  }
		}
		return new Result<Object>(result);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanNegation neg) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretBooleanNegation(G, _subtrace_, neg);
			addToTrace(_trace_, ruleName("InterpretBooleanNegation") + stringRepForEnv(G) + " |- " + stringRep(neg) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretBooleanNegation) {
			throwRuleFailedException(ruleName("InterpretBooleanNegation") + stringRepForEnv(G) + " |- " + stringRep(neg) + " ~> " + "Boolean",
				INTERPRETBOOLEANNEGATION,
				e_applyRuleInterpretBooleanNegation, new ErrorInformation(neg));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretBooleanNegation(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final BooleanNegation neg) 
			throws RuleFailedException {
		Boolean result = null;
		
		{
		  BooleanType _createBooleanType = ExpressionsFactory.eINSTANCE.createBooleanType();
		  BooleanType boolType = _createBooleanType;
		  /* G, 'expected' <- boolType |- neg.expression ~> var Boolean expResult */
		  Expression _expression = neg.getExpression();
		  Boolean expResult = null;
		  Result<Object> result_1 = interpretInternal(environmentComposition(
		    G, environmentEntry("expected", boolType)
		  ), _trace_, _expression);
		  checkAssignableTo(result_1.getFirst(), Boolean.class);
		  expResult = (Boolean) result_1.getFirst();
		  
		  boolean _operator_not = BooleanExtensions.operator_not(expResult);
		  result = Boolean.valueOf(_operator_not);
		}
		return new Result<Object>(result);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Comparison comparison) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretComparison(G, _subtrace_, comparison);
			addToTrace(_trace_, ruleName("InterpretComparison") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretComparison) {
			throwRuleFailedException(ruleName("InterpretComparison") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " ~> " + "Boolean",
				INTERPRETCOMPARISON,
				e_applyRuleInterpretComparison, new ErrorInformation(comparison));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretComparison(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Comparison comparison) 
			throws RuleFailedException {
		Boolean result = null;
		
		{
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
		  
		  boolean _operator_and = false;
		  if (!(leftResult instanceof String)) {
		    _operator_and = false;
		  } else {
		    _operator_and = BooleanExtensions.operator_and((leftResult instanceof String), (rightResult instanceof String));
		  }
		  if (_operator_and) {
		    String _string = leftResult.toString();
		    String _string_1 = rightResult.toString();
		    boolean _operator_lessThan = ComparableExtensions.<String>operator_lessThan(_string, _string_1);
		    result = Boolean.valueOf(_operator_lessThan);
		  } else {
		    boolean _operator_lessThan_1 = ComparableExtensions.<Integer>operator_lessThan(((Integer) leftResult), ((Integer) rightResult));
		    result = Boolean.valueOf(_operator_lessThan_1);
		  }
		}
		return new Result<Object>(result);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Equals comparison) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretEquals(G, _subtrace_, comparison);
			addToTrace(_trace_, ruleName("InterpretEquals") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretEquals) {
			throwRuleFailedException(ruleName("InterpretEquals") + stringRepForEnv(G) + " |- " + stringRep(comparison) + " ~> " + "Boolean",
				INTERPRETEQUALS,
				e_applyRuleInterpretEquals, new ErrorInformation(comparison));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretEquals(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Equals comparison) 
			throws RuleFailedException {
		Boolean result = null;
		
		{
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
		  boolean _operator_equals = ObjectExtensions.operator_equals(_string, _string_1);
		  result = Boolean.valueOf(_operator_equals);
		}
		return new Result<Object>(result);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Plus plus) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretPlus(G, _subtrace_, plus);
			addToTrace(_trace_, ruleName("InterpretPlus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretPlus) {
			throwRuleFailedException(ruleName("InterpretPlus") + stringRepForEnv(G) + " |- " + stringRep(plus) + " ~> " + "Object",
				INTERPRETPLUS,
				e_applyRuleInterpretPlus, new ErrorInformation(plus));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretPlus(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Plus plus) 
			throws RuleFailedException {
		Object result = null;
		
		{
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
		  
		  boolean _operator_or = false;
		  if ((leftResult instanceof String)) {
		    _operator_or = true;
		  } else {
		    _operator_or = BooleanExtensions.operator_or((leftResult instanceof String), (rightResult instanceof String));
		  }
		  if (_operator_or) {
		    {
		      String _string = leftResult.toString();
		      String leftString = _string;
		      String _string_1 = rightResult.toString();
		      String rightString = _string_1;
		      String _operator_plus = StringExtensions.operator_plus(leftString, rightString);
		      result = _operator_plus;
		    }
		  } else {
		    {
		      Integer leftInt = ((Integer) leftResult);
		      Integer rightInt = ((Integer) rightResult);
		      int _operator_plus_1 = IntegerExtensions.operator_plus(leftInt, rightInt);
		      result = Integer.valueOf(_operator_plus_1);
		    }
		  }
		}
		return new Result<Object>(result);
	}
	
	protected Result<Object> interpretImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final VariableReference varRef) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Object> _result_ = applyRuleInterpretVariableRefenrence(G, _subtrace_, varRef);
			addToTrace(_trace_, ruleName("InterpretVariableRefenrence") + stringRepForEnv(G) + " |- " + stringRep(varRef) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleInterpretVariableRefenrence) {
			throwRuleFailedException(ruleName("InterpretVariableRefenrence") + stringRepForEnv(G) + " |- " + stringRep(varRef) + " ~> " + "Object",
				INTERPRETVARIABLEREFENRENCE,
				e_applyRuleInterpretVariableRefenrence, new ErrorInformation(varRef));
			return null;
		}
	}
	
	protected Result<Object> applyRuleInterpretVariableRefenrence(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final VariableReference varRef) 
			throws RuleFailedException {
		Object result = null;
		
		/* G |- varRef.ref.expression ~> result */
		Variable _ref = varRef.getRef();
		Expression _expression = _ref.getExpression();
		Result<Object> result_1 = interpretInternal(G, _trace_, _expression);
		checkAssignableTo(result_1.getFirst(), Object.class);
		result = (Object) result_1.getFirst();
		
		return new Result<Object>(result);
	}
}
