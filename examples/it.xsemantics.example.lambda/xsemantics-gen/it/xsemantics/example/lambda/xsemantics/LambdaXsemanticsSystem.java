package it.xsemantics.example.lambda.xsemantics;

import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.Application;
import it.xsemantics.example.lambda.lambda.Arithmetics;
import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.BasicType;
import it.xsemantics.example.lambda.lambda.IntConstant;
import it.xsemantics.example.lambda.lambda.IntType;
import it.xsemantics.example.lambda.lambda.Parameter;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.lambda.StringConstant;
import it.xsemantics.example.lambda.lambda.StringType;
import it.xsemantics.example.lambda.lambda.Term;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.lambda.TypeVariable;
import it.xsemantics.example.lambda.lambda.Variable;
import it.xsemantics.example.lambda.xsemantics.LambdaUtils;
import it.xsemantics.example.lambda.xsemantics.TypeSubstitutions;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.Result2;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

public class LambdaXsemanticsSystem extends XsemanticsRuntimeSystem {
	public final static String SUBSTITUTETYPE = "it.xsemantics.example.lambda.xsemantics.rules.SubstituteType";
	public final static String SUBSTITUTETYPEVARIABLE = "it.xsemantics.example.lambda.xsemantics.rules.SubstituteTypeVariable";
	public final static String SUBSTITUTEARROWTYPE = "it.xsemantics.example.lambda.xsemantics.rules.SubstituteArrowType";
	public final static String NOTOCCURBASE = "it.xsemantics.example.lambda.xsemantics.rules.NotOccurBase";
	public final static String NOTOCCURVAR = "it.xsemantics.example.lambda.xsemantics.rules.NotOccurVar";
	public final static String NOTOCCURVARINARROW = "it.xsemantics.example.lambda.xsemantics.rules.NotOccurVarInArrow";
	public final static String UNIFYTYPE = "it.xsemantics.example.lambda.xsemantics.rules.UnifyType";
	public final static String UNIFYSTRINGTYPE = "it.xsemantics.example.lambda.xsemantics.rules.UnifyStringType";
	public final static String UNIFYINTTYPE = "it.xsemantics.example.lambda.xsemantics.rules.UnifyIntType";
	public final static String UNIFYTYPEVARIABLEBASICTYPE = "it.xsemantics.example.lambda.xsemantics.rules.UnifyTypeVariableBasicType";
	public final static String UNIFYBASICTYPETYPEVARIABLE = "it.xsemantics.example.lambda.xsemantics.rules.UnifyBasicTypeTypeVariable";
	public final static String UNIFYTYPEVARIABLES = "it.xsemantics.example.lambda.xsemantics.rules.UnifyTypeVariables";
	public final static String UNIFYTYPEVARIABLEARROWTYPE = "it.xsemantics.example.lambda.xsemantics.rules.UnifyTypeVariableArrowType";
	public final static String UNIFYARROWTYPETYPEVARIABLE = "it.xsemantics.example.lambda.xsemantics.rules.UnifyArrowTypeTypeVariable";
	public final static String UNIFYARROWTYPES = "it.xsemantics.example.lambda.xsemantics.rules.UnifyArrowTypes";
	public final static String PARAMETERTYPE = "it.xsemantics.example.lambda.xsemantics.rules.ParameterType";
	public final static String STRINGCONSTANTTYPE = "it.xsemantics.example.lambda.xsemantics.rules.StringConstantType";
	public final static String INTCONSTANTTYPE = "it.xsemantics.example.lambda.xsemantics.rules.IntConstantType";
	public final static String VARIABLETYPE = "it.xsemantics.example.lambda.xsemantics.rules.VariableType";
	public final static String ARITHMETICSTYPE = "it.xsemantics.example.lambda.xsemantics.rules.ArithmeticsType";
	public final static String ABSTRACTIONTYPE = "it.xsemantics.example.lambda.xsemantics.rules.AbstractionType";
	public final static String APPLICATIONTYPE = "it.xsemantics.example.lambda.xsemantics.rules.ApplicationType";

	protected PolymorphicDispatcher<Result<Type>> typeDispatcher;
	
	protected PolymorphicDispatcher<Result<Type>> paramtypeDispatcher;
	
	protected PolymorphicDispatcher<Result<Type>> typesubstitutionDispatcher;
	
	protected PolymorphicDispatcher<Result<Boolean>> notoccurDispatcher;
	
	protected PolymorphicDispatcher<Result2<Type, Type>> unifyDispatcher;

	public LambdaXsemanticsSystem() {
		init();
	}

	public void init() {
		typeDispatcher = buildPolymorphicDispatcher1(
			"typeImpl", 4, "|-", "|>", ":");
		paramtypeDispatcher = buildPolymorphicDispatcher1(
			"paramtypeImpl", 3, "|~", ":");
		typesubstitutionDispatcher = buildPolymorphicDispatcher1(
			"typesubstitutionImpl", 4, "|-", "|>", "~>");
		notoccurDispatcher = buildPolymorphicDispatcher1(
			"notoccurImpl", 4, "|-", ":>");
		unifyDispatcher = buildPolymorphicDispatcher2(
			"unifyImpl", 5, "|-", "|>", "~~", "~>", "~~");
	}

	public Result<Type> type(final TypeSubstitutions substitutions, final Term term) {
		return type(new RuleEnvironment(),
			null, substitutions, term);
	}
	
	public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Term term) {
		try {
			return typeInternal(_environment_, _trace_, substitutions, term);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Type> paramtype(final Parameter param) {
		return paramtype(new RuleEnvironment(),
			null, param);
	}
	
	public Result<Type> paramtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Parameter param) {
		try {
			return paramtypeInternal(_environment_, _trace_, param);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Type> typesubstitution(final TypeSubstitutions substitutions, final Type original) {
		return typesubstitution(new RuleEnvironment(),
			null, substitutions, original);
	}
	
	public Result<Type> typesubstitution(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Type original) {
		try {
			return typesubstitutionInternal(_environment_, _trace_, substitutions, original);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> notoccur(final Type type, final Type other) {
		return notoccur(new RuleEnvironment(),
			null, type, other);
	}
	
	public Result<Boolean> notoccur(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Type type, final Type other) {
		try {
			return notoccurInternal(_environment_, _trace_, type, other);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result2<Type, Type> unify(final TypeSubstitutions substitutions, final Type originalLeft, final Type originalRight) {
		return unify(new RuleEnvironment(),
			null, substitutions, originalLeft, originalRight);
	}
	
	public Result2<Type, Type> unify(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Type originalLeft, final Type originalRight) {
		try {
			return unifyInternal(_environment_, _trace_, substitutions, originalLeft, originalRight);
		} catch (Exception e) {
			return resultForFailure2(e);
		}
	}

	public Result<Boolean> checkProgram(final Program program) {
		try {
			return checkProgramInternal(null, program);
		} catch (Exception e) {
			return resultForFailure(e);
		}
	}
	
	public Result<Boolean> checkProgramInternal(final RuleApplicationTrace _trace_, final Program program) 
			throws RuleFailedException {
		
		{
		  LambdaUtils.resetCounter();
		  /* empty |- new TypeSubstitutions() |> program.term : var Type type */
		  TypeSubstitutions _typeSubstitutions = new TypeSubstitutions();
		  Term _term = program.getTerm();
		  Type type = null;
		  Result<Type> result = typeInternal(emptyEnvironment(), _trace_, _typeSubstitutions, _term);
		  checkAssignableTo(result.getFirst(), Type.class);
		  type = (Type) result.getFirst();
		  
		}
		return new Result<Boolean>(true);
	}

	protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Term term) {
		try {
			checkParamsNotNull(substitutions, term);
			return typeDispatcher.invoke(_environment_, _trace_, substitutions, term);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Type> paramtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Parameter param) {
		try {
			checkParamsNotNull(param);
			return paramtypeDispatcher.invoke(_environment_, _trace_, param);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Type> typesubstitutionInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Type original) {
		try {
			checkParamsNotNull(substitutions, original);
			return typesubstitutionDispatcher.invoke(_environment_, _trace_, substitutions, original);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected void notoccurThrowException(String _issue, Exception _ex, final Type type, final Type other) 
			throws RuleFailedException {
		
		String _stringRep = this.stringRep(type);
		String _operator_plus = StringExtensions.operator_plus(_stringRep, " occurs in ");
		String _stringRep_1 = this.stringRep(other);
		String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _stringRep_1);
		String error = _operator_plus_1;
		throwRuleFailedException(error,
				_issue, _ex,
				new ErrorInformation(null, null));
	}
	
	protected Result<Boolean> notoccurInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final Type type, final Type other) {
		try {
			checkParamsNotNull(type, other);
			return notoccurDispatcher.invoke(_environment_, _trace_, type, other);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result2<Type, Type> unifyInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Type originalLeft, final Type originalRight) {
		try {
			checkParamsNotNull(substitutions, originalLeft, originalRight);
			return unifyDispatcher.invoke(_environment_, _trace_, substitutions, originalLeft, originalRight);
		} catch (Exception e) {
			sneakyThrowRuleFailedException(e);
			return null;
		}
	}
	
	protected Result<Type> typesubstitutionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Type type) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleSubstituteType(G, _subtrace_, substitutions, type);
			addToTrace(_trace_, ruleName("SubstituteType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(type) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleSubstituteType) {
			throwRuleFailedException(ruleName("SubstituteType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(type) + " ~> " + "Type",
				SUBSTITUTETYPE,
				e_applyRuleSubstituteType, new ErrorInformation(type));
			return null;
		}
	}
	
	protected Result<Type> applyRuleSubstituteType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Type type) 
			throws RuleFailedException {
		Type result = null;
		
		result = type;
		return new Result<Type>(result);
	}
	
	protected Result<Type> typesubstitutionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final TypeVariable variable) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleSubstituteTypeVariable(G, _subtrace_, substitutions, variable);
			addToTrace(_trace_, ruleName("SubstituteTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(variable) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleSubstituteTypeVariable) {
			throwRuleFailedException(ruleName("SubstituteTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(variable) + " ~> " + "Type",
				SUBSTITUTETYPEVARIABLE,
				e_applyRuleSubstituteTypeVariable, new ErrorInformation(variable));
			return null;
		}
	}
	
	protected Result<Type> applyRuleSubstituteTypeVariable(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final TypeVariable variable) 
			throws RuleFailedException {
		Type result = null;
		
		/* { var mapped = substitutions.mapped(variable.typevarName) mapped != null result = EcoreUtil::copy(mapped) G |- substitutions |> result ~> result } or result = variable */
		try {
		  Object _xblockexpression = null;
		  {
		    String _typevarName = variable.getTypevarName();
		    Type _mapped = substitutions.mapped(_typevarName);
		    Type mapped = _mapped;
		    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(mapped, null);
		    /* mapped != null */
		    if (!_operator_notEquals) {
		      sneakyThrowRuleFailedException("mapped != null");
		    }
		    Type _copy = EcoreUtil.<Type>copy(mapped);
		    result = _copy;
		    /* G |- substitutions |> result ~> result */
		    Result<Type> result_1 = typesubstitutionInternal(G, _trace_, substitutions, result);
		    checkAssignableTo(result_1.getFirst(), Type.class);
		    result = (Type) result_1.getFirst();
		    
		    _xblockexpression = (null);
		  }
		} catch (Exception e) {
		  result = variable;
		}
		return new Result<Type>(result);
	}
	
	protected Result<Type> typesubstitutionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final ArrowType arrowType) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleSubstituteArrowType(G, _subtrace_, substitutions, arrowType);
			addToTrace(_trace_, ruleName("SubstituteArrowType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arrowType) + " ~> " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleSubstituteArrowType) {
			throwRuleFailedException(ruleName("SubstituteArrowType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arrowType) + " ~> " + "ArrowType",
				SUBSTITUTEARROWTYPE,
				e_applyRuleSubstituteArrowType, new ErrorInformation(arrowType));
			return null;
		}
	}
	
	protected Result<Type> applyRuleSubstituteArrowType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final ArrowType arrowType) 
			throws RuleFailedException {
		ArrowType result = null;
		
		{
		  Type subResult = null;
		  ArrowType _copy = EcoreUtil.<ArrowType>copy(arrowType);
		  result = _copy;
		  /* G |- substitutions |> arrowType.left ~> subResult */
		  Type _left = arrowType.getLeft();
		  Result<Type> result_1 = typesubstitutionInternal(G, _trace_, substitutions, _left);
		  checkAssignableTo(result_1.getFirst(), Type.class);
		  subResult = (Type) result_1.getFirst();
		  
		  result.setLeft(subResult);
		  /* G |- substitutions |> arrowType.right ~> subResult */
		  Type _right = arrowType.getRight();
		  Result<Type> result_2 = typesubstitutionInternal(G, _trace_, substitutions, _right);
		  checkAssignableTo(result_2.getFirst(), Type.class);
		  subResult = (Type) result_2.getFirst();
		  
		  result.setRight(subResult);
		}
		return new Result<Type>(result);
	}
	
	protected Result<Boolean> notoccurImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Type type, final Type other) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleNotOccurBase(G, _subtrace_, type, other);
			addToTrace(_trace_, ruleName("NotOccurBase") + stringRepForEnv(G) + " |- " + stringRep(type) + " :> " + stringRep(other));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleNotOccurBase) {
			notoccurThrowException(NOTOCCURBASE,
				e_applyRuleNotOccurBase, type, other);
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleNotOccurBase(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Type type, final Type other) 
			throws RuleFailedException {
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> notoccurImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeVariable variable, final TypeVariable other) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleNotOccurVar(G, _subtrace_, variable, other);
			addToTrace(_trace_, ruleName("NotOccurVar") + stringRepForEnv(G) + " |- " + stringRep(variable) + " :> " + stringRep(other));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleNotOccurVar) {
			notoccurThrowException(NOTOCCURVAR,
				e_applyRuleNotOccurVar, variable, other);
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleNotOccurVar(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeVariable variable, final TypeVariable other) 
			throws RuleFailedException {
		
		String _typevarName = variable.getTypevarName();
		String _typevarName_1 = other.getTypevarName();
		boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_typevarName, _typevarName_1);
		/* variable.typevarName != other.typevarName */
		if (!_operator_notEquals) {
		  sneakyThrowRuleFailedException("variable.typevarName != other.typevarName");
		}
		return new Result<Boolean>(true);
	}
	
	protected Result<Boolean> notoccurImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeVariable variable, final ArrowType arrowType) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Boolean> _result_ = applyRuleNotOccurVarInArrow(G, _subtrace_, variable, arrowType);
			addToTrace(_trace_, ruleName("NotOccurVarInArrow") + stringRepForEnv(G) + " |- " + stringRep(variable) + " :> " + stringRep(arrowType));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleNotOccurVarInArrow) {
			notoccurThrowException(NOTOCCURVARINARROW,
				e_applyRuleNotOccurVarInArrow, variable, arrowType);
			return null;
		}
	}
	
	protected Result<Boolean> applyRuleNotOccurVarInArrow(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeVariable variable, final ArrowType arrowType) 
			throws RuleFailedException {
		
		{
		  /* G |- variable :> arrowType.left */
		  Type _left = arrowType.getLeft();
		  notoccurInternal(G, _trace_, variable, _left);
		  /* G |- variable :> arrowType.right */
		  Type _right = arrowType.getRight();
		  notoccurInternal(G, _trace_, variable, _right);
		}
		return new Result<Boolean>(true);
	}
	
	protected Result2<Type, Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Type t1, final Type t2) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<Type, Type> _result_ = applyRuleUnifyType(G, _subtrace_, substitutions, t1, t2);
			addToTrace(_trace_, ruleName("UnifyType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleUnifyType) {
			throwRuleFailedException(ruleName("UnifyType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + "Type" + " ~~ " + "Type",
				UNIFYTYPE,
				e_applyRuleUnifyType, new ErrorInformation(t1), new ErrorInformation(t2));
			return null;
		}
	}
	
	protected Result2<Type, Type> applyRuleUnifyType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Type t1, final Type t2) 
			throws RuleFailedException {
		
		/* fail */
		throwForExplicitFail();
		return new Result2<Type, Type>(t1, t2);
	}
	
	protected Result2<Type, Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final StringType t1, final StringType t2) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<Type, Type> _result_ = applyRuleUnifyStringType(G, _subtrace_, substitutions, t1, t2);
			addToTrace(_trace_, ruleName("UnifyStringType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleUnifyStringType) {
			throwRuleFailedException(ruleName("UnifyStringType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + "StringType" + " ~~ " + "StringType",
				UNIFYSTRINGTYPE,
				e_applyRuleUnifyStringType, new ErrorInformation(t1), new ErrorInformation(t2));
			return null;
		}
	}
	
	protected Result2<Type, Type> applyRuleUnifyStringType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final StringType t1, final StringType t2) 
			throws RuleFailedException {
		
		StringType _copy = EcoreUtil.<StringType>copy(t1);
		StringType _copy_1 = EcoreUtil.<StringType>copy(t2);
		return new Result2<Type, Type>(_copy, _copy_1);
	}
	
	protected Result2<Type, Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final IntType t1, final IntType t2) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<Type, Type> _result_ = applyRuleUnifyIntType(G, _subtrace_, substitutions, t1, t2);
			addToTrace(_trace_, ruleName("UnifyIntType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleUnifyIntType) {
			throwRuleFailedException(ruleName("UnifyIntType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + "IntType" + " ~~ " + "IntType",
				UNIFYINTTYPE,
				e_applyRuleUnifyIntType, new ErrorInformation(t1), new ErrorInformation(t2));
			return null;
		}
	}
	
	protected Result2<Type, Type> applyRuleUnifyIntType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final IntType t1, final IntType t2) 
			throws RuleFailedException {
		
		IntType _copy = EcoreUtil.<IntType>copy(t1);
		IntType _copy_1 = EcoreUtil.<IntType>copy(t2);
		return new Result2<Type, Type>(_copy, _copy_1);
	}
	
	protected Result2<Type, Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final TypeVariable typeVar, final BasicType basicType) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<Type, Type> _result_ = applyRuleUnifyTypeVariableBasicType(G, _subtrace_, substitutions, typeVar, basicType);
			addToTrace(_trace_, ruleName("UnifyTypeVariableBasicType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(typeVar) + " ~~ " + stringRep(basicType) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleUnifyTypeVariableBasicType) {
			throwRuleFailedException(ruleName("UnifyTypeVariableBasicType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(typeVar) + " ~~ " + stringRep(basicType) + " ~> " + "BasicType" + " ~~ " + "BasicType",
				UNIFYTYPEVARIABLEBASICTYPE,
				e_applyRuleUnifyTypeVariableBasicType, new ErrorInformation(typeVar), new ErrorInformation(basicType));
			return null;
		}
	}
	
	protected Result2<Type, Type> applyRuleUnifyTypeVariableBasicType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final TypeVariable typeVar, final BasicType basicType) 
			throws RuleFailedException {
		BasicType result = null;
		
		{
		  BasicType _copy = EcoreUtil.<BasicType>copy(basicType);
		  result = _copy;
		  String _typevarName = typeVar.getTypevarName();
		  substitutions.add(_typevarName, result);
		}
		BasicType _copy_1 = EcoreUtil.<BasicType>copy(basicType);
		return new Result2<Type, Type>(_copy_1, result);
	}
	
	protected Result2<Type, Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final BasicType basicType, final TypeVariable typeVar) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<Type, Type> _result_ = applyRuleUnifyBasicTypeTypeVariable(G, _subtrace_, substitutions, basicType, typeVar);
			addToTrace(_trace_, ruleName("UnifyBasicTypeTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(basicType) + " ~~ " + stringRep(typeVar) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleUnifyBasicTypeTypeVariable) {
			throwRuleFailedException(ruleName("UnifyBasicTypeTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(basicType) + " ~~ " + stringRep(typeVar) + " ~> " + "BasicType" + " ~~ " + "BasicType",
				UNIFYBASICTYPETYPEVARIABLE,
				e_applyRuleUnifyBasicTypeTypeVariable, new ErrorInformation(basicType), new ErrorInformation(typeVar));
			return null;
		}
	}
	
	protected Result2<Type, Type> applyRuleUnifyBasicTypeTypeVariable(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final BasicType basicType, final TypeVariable typeVar) 
			throws RuleFailedException {
		BasicType resultForVar = null;
		BasicType resultForBasic = null;
		
		/* G |- substitutions |> typeVar ~~ basicType ~> resultForVar ~~ resultForBasic */
		Result2<Type, Type> result = unifyInternal(G, _trace_, substitutions, typeVar, basicType);
		checkAssignableTo(result.getFirst(), BasicType.class);
		resultForVar = (BasicType) result.getFirst();
		checkAssignableTo(result.getSecond(), BasicType.class);
		resultForBasic = (BasicType) result.getSecond();
		
		return new Result2<Type, Type>(resultForVar, resultForBasic);
	}
	
	protected Result2<Type, Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final TypeVariable originalLeft, final TypeVariable originalRight) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<Type, Type> _result_ = applyRuleUnifyTypeVariables(G, _subtrace_, substitutions, originalLeft, originalRight);
			addToTrace(_trace_, ruleName("UnifyTypeVariables") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleUnifyTypeVariables) {
			throwRuleFailedException(ruleName("UnifyTypeVariables") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + "TypeVariable" + " ~~ " + "TypeVariable",
				UNIFYTYPEVARIABLES,
				e_applyRuleUnifyTypeVariables, new ErrorInformation(originalLeft), new ErrorInformation(originalRight));
			return null;
		}
	}
	
	protected Result2<Type, Type> applyRuleUnifyTypeVariables(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final TypeVariable originalLeft, final TypeVariable originalRight) 
			throws RuleFailedException {
		TypeVariable newLeft = null;
		TypeVariable newRight = null;
		
		{
		  TypeVariable _createFreshTypeVariable = LambdaUtils.createFreshTypeVariable();
		  newLeft = _createFreshTypeVariable;
		  TypeVariable _copy = EcoreUtil.<TypeVariable>copy(newLeft);
		  newRight = _copy;
		  String _typevarName = originalLeft.getTypevarName();
		  substitutions.add(_typevarName, newLeft);
		  String _typevarName_1 = originalRight.getTypevarName();
		  substitutions.add(_typevarName_1, newRight);
		}
		return new Result2<Type, Type>(newLeft, newRight);
	}
	
	protected Result2<Type, Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final TypeVariable originalLeft, final ArrowType originalRight) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<Type, Type> _result_ = applyRuleUnifyTypeVariableArrowType(G, _subtrace_, substitutions, originalLeft, originalRight);
			addToTrace(_trace_, ruleName("UnifyTypeVariableArrowType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleUnifyTypeVariableArrowType) {
			throwRuleFailedException(ruleName("UnifyTypeVariableArrowType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + "ArrowType" + " ~~ " + "ArrowType",
				UNIFYTYPEVARIABLEARROWTYPE,
				e_applyRuleUnifyTypeVariableArrowType, new ErrorInformation(originalLeft), new ErrorInformation(originalRight));
			return null;
		}
	}
	
	protected Result2<Type, Type> applyRuleUnifyTypeVariableArrowType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final TypeVariable originalLeft, final ArrowType originalRight) 
			throws RuleFailedException {
		ArrowType newLeft = null;
		
		{
		  /* G |- originalLeft :> originalRight */
		  notoccurInternal(G, _trace_, originalLeft, originalRight);
		  ArrowType _copy = EcoreUtil.<ArrowType>copy(originalRight);
		  newLeft = _copy;
		  String _typevarName = originalLeft.getTypevarName();
		  substitutions.add(_typevarName, newLeft);
		}
		ArrowType _copy_1 = EcoreUtil.<ArrowType>copy(originalRight);
		return new Result2<Type, Type>(newLeft, _copy_1);
	}
	
	protected Result2<Type, Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final ArrowType originalLeft, final TypeVariable originalRight) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<Type, Type> _result_ = applyRuleUnifyArrowTypeTypeVariable(G, _subtrace_, substitutions, originalLeft, originalRight);
			addToTrace(_trace_, ruleName("UnifyArrowTypeTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleUnifyArrowTypeTypeVariable) {
			throwRuleFailedException(ruleName("UnifyArrowTypeTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + "ArrowType" + " ~~ " + "ArrowType",
				UNIFYARROWTYPETYPEVARIABLE,
				e_applyRuleUnifyArrowTypeTypeVariable, new ErrorInformation(originalLeft), new ErrorInformation(originalRight));
			return null;
		}
	}
	
	protected Result2<Type, Type> applyRuleUnifyArrowTypeTypeVariable(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final ArrowType originalLeft, final TypeVariable originalRight) 
			throws RuleFailedException {
		ArrowType newLeft = null;
		ArrowType newRight = null;
		
		/* G |- substitutions |> originalRight ~~ originalLeft ~> newRight ~~ newLeft */
		Result2<Type, Type> result = unifyInternal(G, _trace_, substitutions, originalRight, originalLeft);
		checkAssignableTo(result.getFirst(), ArrowType.class);
		newRight = (ArrowType) result.getFirst();
		checkAssignableTo(result.getSecond(), ArrowType.class);
		newLeft = (ArrowType) result.getSecond();
		
		return new Result2<Type, Type>(newLeft, newRight);
	}
	
	protected Result2<Type, Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final ArrowType arrow1, final ArrowType arrow2) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result2<Type, Type> _result_ = applyRuleUnifyArrowTypes(G, _subtrace_, substitutions, arrow1, arrow2);
			addToTrace(_trace_, ruleName("UnifyArrowTypes") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arrow1) + " ~~ " + stringRep(arrow2) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleUnifyArrowTypes) {
			throwRuleFailedException(ruleName("UnifyArrowTypes") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arrow1) + " ~~ " + stringRep(arrow2) + " ~> " + "ArrowType" + " ~~ " + "ArrowType",
				UNIFYARROWTYPES,
				e_applyRuleUnifyArrowTypes, new ErrorInformation(arrow1), new ErrorInformation(arrow2));
			return null;
		}
	}
	
	protected Result2<Type, Type> applyRuleUnifyArrowTypes(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final ArrowType arrow1, final ArrowType arrow2) 
			throws RuleFailedException {
		ArrowType newArrow1 = null;
		ArrowType newArrow2 = null;
		
		{
		  ArrowType _copy = EcoreUtil.<ArrowType>copy(arrow1);
		  newArrow1 = _copy;
		  ArrowType _copy_1 = EcoreUtil.<ArrowType>copy(arrow2);
		  newArrow2 = _copy_1;
		  Type temp1 = null;
		  Type temp2 = null;
		  /* G |- substitutions |> arrow1.left ~~ arrow2.left ~> temp1 ~~ temp2 */
		  Type _left = arrow1.getLeft();
		  Type _left_1 = arrow2.getLeft();
		  Result2<Type, Type> result = unifyInternal(G, _trace_, substitutions, _left, _left_1);
		  checkAssignableTo(result.getFirst(), Type.class);
		  temp1 = (Type) result.getFirst();
		  checkAssignableTo(result.getSecond(), Type.class);
		  temp2 = (Type) result.getSecond();
		  
		  newArrow1.setLeft(temp1);
		  newArrow2.setLeft(temp2);
		  /* G |- substitutions |> arrow1.right ~~ arrow2.right ~> temp1 ~~ temp2 */
		  Type _right = arrow1.getRight();
		  Type _right_1 = arrow2.getRight();
		  Result2<Type, Type> result_1 = unifyInternal(G, _trace_, substitutions, _right, _right_1);
		  checkAssignableTo(result_1.getFirst(), Type.class);
		  temp1 = (Type) result_1.getFirst();
		  checkAssignableTo(result_1.getSecond(), Type.class);
		  temp2 = (Type) result_1.getSecond();
		  
		  newArrow1.setRight(temp1);
		  newArrow2.setRight(temp2);
		}
		return new Result2<Type, Type>(newArrow1, newArrow2);
	}
	
	protected Result<Type> paramtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Parameter param) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleParameterType(G, _subtrace_, param);
			addToTrace(_trace_, ruleName("ParameterType") + stringRepForEnv(G) + " |~ " + stringRep(param) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleParameterType) {
			throwRuleFailedException(ruleName("ParameterType") + stringRepForEnv(G) + " |~ " + stringRep(param) + " : " + "Type",
				PARAMETERTYPE,
				e_applyRuleParameterType, new ErrorInformation(param));
			return null;
		}
	}
	
	protected Result<Type> applyRuleParameterType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final Parameter param) 
			throws RuleFailedException {
		Type type = null;
		
		/* { param.type != null type = EcoreUtil::copy(param.type) } or type = LambdaUtils::createFreshTypeVariable */
		try {
		  Type _xblockexpression = null;
		  {
		    Type _type = param.getType();
		    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_type, null);
		    /* param.type != null */
		    if (!_operator_notEquals) {
		      sneakyThrowRuleFailedException("param.type != null");
		    }
		    Type _type_1 = param.getType();
		    Type _copy = EcoreUtil.<Type>copy(_type_1);
		    Type _type_2 = type = _copy;
		    _xblockexpression = (_type_2);
		  }
		} catch (Exception e) {
		  TypeVariable _createFreshTypeVariable = LambdaUtils.createFreshTypeVariable();
		  type = _createFreshTypeVariable;
		}
		return new Result<Type>(type);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final StringConstant stringConstant) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleStringConstantType(G, _subtrace_, substitutions, stringConstant);
			addToTrace(_trace_, ruleName("StringConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(stringConstant) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleStringConstantType) {
			throwRuleFailedException(ruleName("StringConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(stringConstant) + " : " + "StringType",
				STRINGCONSTANTTYPE,
				e_applyRuleStringConstantType, new ErrorInformation(stringConstant));
			return null;
		}
	}
	
	protected Result<Type> applyRuleStringConstantType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final StringConstant stringConstant) 
			throws RuleFailedException {
		
		StringType _createStringType = LambdaUtils.createStringType();
		return new Result<Type>(_createStringType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final IntConstant intConstant) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleIntConstantType(G, _subtrace_, substitutions, intConstant);
			addToTrace(_trace_, ruleName("IntConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(intConstant) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleIntConstantType) {
			throwRuleFailedException(ruleName("IntConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(intConstant) + " : " + "IntType",
				INTCONSTANTTYPE,
				e_applyRuleIntConstantType, new ErrorInformation(intConstant));
			return null;
		}
	}
	
	protected Result<Type> applyRuleIntConstantType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final IntConstant intConstant) 
			throws RuleFailedException {
		
		IntType _createIntType = LambdaUtils.createIntType();
		return new Result<Type>(_createIntType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Variable variable) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleVariableType(G, _subtrace_, substitutions, variable);
			addToTrace(_trace_, ruleName("VariableType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(variable) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleVariableType) {
			throwRuleFailedException(ruleName("VariableType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(variable) + " : " + "Type",
				VARIABLETYPE,
				e_applyRuleVariableType, new ErrorInformation(variable));
			return null;
		}
	}
	
	protected Result<Type> applyRuleVariableType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Variable variable) 
			throws RuleFailedException {
		Type type = null;
		
		/* G |- substitutions |> EcoreUtil::copy(env(G, variable.ref, Type)) ~> type */
		/* env(G, variable.ref, Type) */
		Parameter _ref = variable.getRef();
		Type _environmentaccess = environmentAccess(G, _ref, Type.class);
		Type _copy = EcoreUtil.<Type>copy(_environmentaccess);
		Result<Type> result = typesubstitutionInternal(G, _trace_, substitutions, _copy);
		checkAssignableTo(result.getFirst(), Type.class);
		type = (Type) result.getFirst();
		
		return new Result<Type>(type);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Arithmetics arithmetics) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleArithmeticsType(G, _subtrace_, substitutions, arithmetics);
			addToTrace(_trace_, ruleName("ArithmeticsType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arithmetics) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleArithmeticsType) {
			throwRuleFailedException(ruleName("ArithmeticsType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arithmetics) + " : " + "IntType",
				ARITHMETICSTYPE,
				e_applyRuleArithmeticsType, new ErrorInformation(arithmetics));
			return null;
		}
	}
	
	protected Result<Type> applyRuleArithmeticsType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Arithmetics arithmetics) 
			throws RuleFailedException {
		IntType intType = null;
		
		{
		  IntType _createIntType = LambdaUtils.createIntType();
		  intType = _createIntType;
		  /* G |- substitutions |> arithmetics.term : var Type termType */
		  Term _term = arithmetics.getTerm();
		  Type termType = null;
		  Result<Type> result = typeInternal(G, _trace_, substitutions, _term);
		  checkAssignableTo(result.getFirst(), Type.class);
		  termType = (Type) result.getFirst();
		  
		  /* G |- substitutions |> termType ~~ intType ~> intType ~~ intType */
		  Result2<Type, Type> result_1 = unifyInternal(G, _trace_, substitutions, termType, intType);
		  checkAssignableTo(result_1.getFirst(), IntType.class);
		  intType = (IntType) result_1.getFirst();
		  checkAssignableTo(result_1.getSecond(), IntType.class);
		  intType = (IntType) result_1.getSecond();
		  
		}
		return new Result<Type>(intType);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Abstraction abstraction) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleAbstractionType(G, _subtrace_, substitutions, abstraction);
			addToTrace(_trace_, ruleName("AbstractionType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(abstraction) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleAbstractionType) {
			throwRuleFailedException(ruleName("AbstractionType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(abstraction) + " : " + "ArrowType",
				ABSTRACTIONTYPE,
				e_applyRuleAbstractionType, new ErrorInformation(abstraction));
			return null;
		}
	}
	
	protected Result<Type> applyRuleAbstractionType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Abstraction abstraction) 
			throws RuleFailedException {
		ArrowType type = null;
		
		{
		  /* G |~ abstraction.param : var Type paramType */
		  Parameter _param = abstraction.getParam();
		  Type paramType = null;
		  Result<Type> result = paramtypeInternal(G, _trace_, _param);
		  checkAssignableTo(result.getFirst(), Type.class);
		  paramType = (Type) result.getFirst();
		  
		  /* G, abstraction.param <- paramType |- substitutions |> abstraction.term : var Type termType */
		  Term _term = abstraction.getTerm();
		  Type termType = null;
		  Parameter _param_1 = abstraction.getParam();
		  Result<Type> result_1 = typeInternal(environmentComposition(
		    G, environmentEntry(_param_1, paramType)
		  ), _trace_, substitutions, _term);
		  checkAssignableTo(result_1.getFirst(), Type.class);
		  termType = (Type) result_1.getFirst();
		  
		  /* G |- substitutions |> paramType ~> paramType */
		  Result<Type> result_2 = typesubstitutionInternal(G, _trace_, substitutions, paramType);
		  checkAssignableTo(result_2.getFirst(), Type.class);
		  paramType = (Type) result_2.getFirst();
		  
		  /* G |- substitutions |> termType ~> termType */
		  Result<Type> result_3 = typesubstitutionInternal(G, _trace_, substitutions, termType);
		  checkAssignableTo(result_3.getFirst(), Type.class);
		  termType = (Type) result_3.getFirst();
		  
		  ArrowType _createArrowType = LambdaUtils.createArrowType(paramType, termType);
		  type = _createArrowType;
		}
		return new Result<Type>(type);
	}
	
	protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Application application) 
			throws RuleFailedException {
		try {
			RuleApplicationTrace _subtrace_ = newTrace(_trace_);
			Result<Type> _result_ = applyRuleApplicationType(G, _subtrace_, substitutions, application);
			addToTrace(_trace_, ruleName("ApplicationType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(application) + " : " + stringRep(_result_.getFirst()));
			addAsSubtrace(_trace_, _subtrace_);
			return _result_;
		} catch (Exception e_applyRuleApplicationType) {
			throwRuleFailedException(ruleName("ApplicationType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(application) + " : " + "Type",
				APPLICATIONTYPE,
				e_applyRuleApplicationType, new ErrorInformation(application));
			return null;
		}
	}
	
	protected Result<Type> applyRuleApplicationType(final RuleEnvironment G, final RuleApplicationTrace _trace_,
			final TypeSubstitutions substitutions, final Application application) 
			throws RuleFailedException {
		Type type = null;
		
		{
		  /* G |- substitutions |> application.fun : var Type funType */
		  Term _fun = application.getFun();
		  Type funType = null;
		  Result<Type> result = typeInternal(G, _trace_, substitutions, _fun);
		  checkAssignableTo(result.getFirst(), Type.class);
		  funType = (Type) result.getFirst();
		  
		  ArrowType _createFreshArrowType = LambdaUtils.createFreshArrowType();
		  ArrowType arrowType = _createFreshArrowType;
		  /* G |- substitutions |> funType ~~ arrowType ~> funType ~~ arrowType */
		  Result2<Type, Type> result_1 = unifyInternal(G, _trace_, substitutions, funType, arrowType);
		  checkAssignableTo(result_1.getFirst(), Type.class);
		  funType = (Type) result_1.getFirst();
		  checkAssignableTo(result_1.getSecond(), ArrowType.class);
		  arrowType = (ArrowType) result_1.getSecond();
		  
		  /* G |- substitutions |> application.arg : var Type argType */
		  Term _arg = application.getArg();
		  Type argType = null;
		  Result<Type> result_2 = typeInternal(G, _trace_, substitutions, _arg);
		  checkAssignableTo(result_2.getFirst(), Type.class);
		  argType = (Type) result_2.getFirst();
		  
		  /* G |- substitutions |> arrowType.left ~~ argType ~> funType ~~ argType */
		  Type _left = arrowType.getLeft();
		  Result2<Type, Type> result_3 = unifyInternal(G, _trace_, substitutions, _left, argType);
		  checkAssignableTo(result_3.getFirst(), Type.class);
		  funType = (Type) result_3.getFirst();
		  checkAssignableTo(result_3.getSecond(), Type.class);
		  argType = (Type) result_3.getSecond();
		  
		  /* G |- substitutions |> arrowType.right ~> type */
		  Type _right = arrowType.getRight();
		  Result<Type> result_4 = typesubstitutionInternal(G, _trace_, substitutions, _right);
		  checkAssignableTo(result_4.getFirst(), Type.class);
		  type = (Type) result_4.getFirst();
		  
		}
		return new Result<Type>(type);
	}
}
