package it.xsemantics.example.lambda.xsemantics;

import com.google.common.base.Objects;
import com.google.inject.Inject;
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

@SuppressWarnings("all")
public class LambdaXsemanticsSystem extends XsemanticsRuntimeSystem {
  public final static String NOTOCCUR = "it.xsemantics.example.lambda.xsemantics.Notoccur";
  
  public final static String TYPESUBSTITUTION = "it.xsemantics.example.lambda.xsemantics.Typesubstitution";
  
  public final static String UNIFYTYPE = "it.xsemantics.example.lambda.xsemantics.UnifyType";
  
  public final static String UNIFYSTRINGTYPE = "it.xsemantics.example.lambda.xsemantics.UnifyStringType";
  
  public final static String UNIFYINTTYPE = "it.xsemantics.example.lambda.xsemantics.UnifyIntType";
  
  public final static String UNIFYTYPEVARIABLEBASICTYPE = "it.xsemantics.example.lambda.xsemantics.UnifyTypeVariableBasicType";
  
  public final static String UNIFYBASICTYPETYPEVARIABLE = "it.xsemantics.example.lambda.xsemantics.UnifyBasicTypeTypeVariable";
  
  public final static String UNIFYTYPEVARIABLES = "it.xsemantics.example.lambda.xsemantics.UnifyTypeVariables";
  
  public final static String UNIFYTYPEVARIABLEARROWTYPE = "it.xsemantics.example.lambda.xsemantics.UnifyTypeVariableArrowType";
  
  public final static String UNIFYARROWTYPETYPEVARIABLE = "it.xsemantics.example.lambda.xsemantics.UnifyArrowTypeTypeVariable";
  
  public final static String UNIFYARROWTYPES = "it.xsemantics.example.lambda.xsemantics.UnifyArrowTypes";
  
  public final static String PARAMETERTYPE = "it.xsemantics.example.lambda.xsemantics.ParameterType";
  
  public final static String STRINGCONSTANTTYPE = "it.xsemantics.example.lambda.xsemantics.StringConstantType";
  
  public final static String INTCONSTANTTYPE = "it.xsemantics.example.lambda.xsemantics.IntConstantType";
  
  public final static String VARIABLETYPE = "it.xsemantics.example.lambda.xsemantics.VariableType";
  
  public final static String ARITHMETICSTYPE = "it.xsemantics.example.lambda.xsemantics.ArithmeticsType";
  
  public final static String ABSTRACTIONTYPE = "it.xsemantics.example.lambda.xsemantics.AbstractionType";
  
  public final static String APPLICATIONTYPE = "it.xsemantics.example.lambda.xsemantics.ApplicationType";
  
  @Inject
  private LambdaUtils lambdaUtils;
  
  private PolymorphicDispatcher<Boolean> notoccurDispatcher;
  
  private PolymorphicDispatcher<Type> typesubstitutionDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> paramtypeDispatcher;
  
  private PolymorphicDispatcher<Result2<Type,Type>> unifyDispatcher;
  
  public LambdaXsemanticsSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 4, "|-", "|>", ":");
    paramtypeDispatcher = buildPolymorphicDispatcher1(
    	"paramtypeImpl", 3, "|~", ":");
    unifyDispatcher = buildPolymorphicDispatcher2(
    	"unifyImpl", 5, "|-", "|>", "~~", "~>", "~~");
    notoccurDispatcher = buildPolymorphicDispatcher(
    	"notoccurImpl", 3);
    typesubstitutionDispatcher = buildPolymorphicDispatcher(
    	"typesubstitutionImpl", 3);
  }
  
  public LambdaUtils getLambdaUtils() {
    return this.lambdaUtils;
  }
  
  public void setLambdaUtils(final LambdaUtils lambdaUtils) {
    this.lambdaUtils = lambdaUtils;
  }
  
  public Boolean notoccur(final Type type, final Type other) throws RuleFailedException {
    return notoccur(null, type, other);
  }
  
  public Boolean notoccur(final RuleApplicationTrace _trace_, final Type type, final Type other) throws RuleFailedException {
    try {
    	return notoccurInternal(_trace_, type, other);
    } catch (Exception _e_notoccur) {
    	throw extractRuleFailedException(_e_notoccur);
    }
  }
  
  public Type typesubstitution(final TypeSubstitutions substitutions, final Type original) throws RuleFailedException {
    return typesubstitution(null, substitutions, original);
  }
  
  public Type typesubstitution(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type original) throws RuleFailedException {
    try {
    	return typesubstitutionInternal(_trace_, substitutions, original);
    } catch (Exception _e_typesubstitution) {
    	throw extractRuleFailedException(_e_typesubstitution);
    }
  }
  
  public Result<Type> type(final TypeSubstitutions substitutions, final Term term) {
    return type(new RuleEnvironment(), null, substitutions, term);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final TypeSubstitutions substitutions, final Term term) {
    return type(_environment_, null, substitutions, term);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Term term) {
    try {
    	return typeInternal(_environment_, _trace_, substitutions, term);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Result<Type> paramtype(final Parameter param) {
    return paramtype(new RuleEnvironment(), null, param);
  }
  
  public Result<Type> paramtype(final RuleEnvironment _environment_, final Parameter param) {
    return paramtype(_environment_, null, param);
  }
  
  public Result<Type> paramtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Parameter param) {
    try {
    	return paramtypeInternal(_environment_, _trace_, param);
    } catch (Exception _e_paramtype) {
    	return resultForFailure(_e_paramtype);
    }
  }
  
  public Result2<Type,Type> unify(final TypeSubstitutions substitutions, final Type originalLeft, final Type originalRight) {
    return unify(new RuleEnvironment(), null, substitutions, originalLeft, originalRight);
  }
  
  public Result2<Type,Type> unify(final RuleEnvironment _environment_, final TypeSubstitutions substitutions, final Type originalLeft, final Type originalRight) {
    return unify(_environment_, null, substitutions, originalLeft, originalRight);
  }
  
  public Result2<Type,Type> unify(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type originalLeft, final Type originalRight) {
    try {
    	return unifyInternal(_environment_, _trace_, substitutions, originalLeft, originalRight);
    } catch (Exception _e_unify) {
    	return resultForFailure2(_e_unify);
    }
  }
  
  public Result<Boolean> checkProgram(final Program program) {
    return checkProgram(null, program);
  }
  
  public Result<Boolean> checkProgram(final RuleApplicationTrace _trace_, final Program program) {
    try {
    	return checkProgramInternal(_trace_, program);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkProgramInternal(final RuleApplicationTrace _trace_, final Program program) throws RuleFailedException {
    this.lambdaUtils.resetCounter();
    /* empty |- new TypeSubstitutions() |> program.term : var Type type */
    TypeSubstitutions _typeSubstitutions = new TypeSubstitutions();
    Term _term = program.getTerm();
    Type type = null;
    Result<Type> result = typeInternal(emptyEnvironment(), _trace_, _typeSubstitutions, _term);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Boolean>(true);
  }
  
  protected Boolean notoccurInternal(final RuleApplicationTrace _trace_, final Type type, final Type other) {
    try {
    	checkParamsNotNull(type, other);
    	return notoccurDispatcher.invoke(_trace_, type, other);
    } catch (Exception _e_notoccur) {
    	sneakyThrowRuleFailedException(_e_notoccur);
    	return false;
    }
  }
  
  protected void notoccurThrowException(final String _error, final String _issue, final Exception _ex, final Type type, final Type other, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(type);
    String _plus = (_stringRep + " occurs in ");
    String _stringRep_1 = this.stringRep(other);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
  
  protected Type typesubstitutionInternal(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type original) {
    try {
    	checkParamsNotNull(substitutions, original);
    	return typesubstitutionDispatcher.invoke(_trace_, substitutions, original);
    } catch (Exception _e_typesubstitution) {
    	sneakyThrowRuleFailedException(_e_typesubstitution);
    	return null;
    }
  }
  
  protected void typesubstitutionThrowException(final String _error, final String _issue, final Exception _ex, final TypeSubstitutions substitutions, final Type original, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Term term) {
    try {
    	checkParamsNotNull(substitutions, term);
    	return typeDispatcher.invoke(_environment_, _trace_, substitutions, term);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final TypeSubstitutions substitutions, final Term term, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Type> paramtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Parameter param) {
    try {
    	checkParamsNotNull(param);
    	return paramtypeDispatcher.invoke(_environment_, _trace_, param);
    } catch (Exception _e_paramtype) {
    	sneakyThrowRuleFailedException(_e_paramtype);
    	return null;
    }
  }
  
  protected void paramtypeThrowException(final String _error, final String _issue, final Exception _ex, final Parameter param, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result2<Type,Type> unifyInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type originalLeft, final Type originalRight) {
    try {
    	checkParamsNotNull(substitutions, originalLeft, originalRight);
    	return unifyDispatcher.invoke(_environment_, _trace_, substitutions, originalLeft, originalRight);
    } catch (Exception _e_unify) {
    	sneakyThrowRuleFailedException(_e_unify);
    	return null;
    }
  }
  
  protected void unifyThrowException(final String _error, final String _issue, final Exception _ex, final TypeSubstitutions substitutions, final Type originalLeft, final Type originalRight, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Boolean notoccurImpl(final RuleApplicationTrace _trace_, final Type type, final Type other) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Boolean _result_ = applyAuxFunNotoccur(_subtrace_, type, other);
    	addToTrace(_trace_, auxFunName("notoccur") + "(" + stringRep(type) + ", " + stringRep(other)+ ")" + " = " + stringRep(_result_));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunNotoccur) {
    	notoccurThrowException(auxFunName("notoccur") + "(" + stringRep(type) + ", " + stringRep(other)+ ")",
    		NOTOCCUR,
    		e_applyAuxFunNotoccur, type, other, new ErrorInformation[] {new ErrorInformation(type), new ErrorInformation(other)});
    	return false;
    }
  }
  
  protected Boolean applyAuxFunNotoccur(final RuleApplicationTrace _trace_, final Type type, final Type other) throws RuleFailedException {
    /* true */
    if (!true) {
      sneakyThrowRuleFailedException("true");
    }
    return true;
  }
  
  protected Boolean notoccurImpl(final RuleApplicationTrace _trace_, final TypeVariable variable, final TypeVariable other) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Boolean _result_ = applyAuxFunNotoccur(_subtrace_, variable, other);
    	addToTrace(_trace_, auxFunName("notoccur") + "(" + stringRep(variable) + ", " + stringRep(other)+ ")" + " = " + stringRep(_result_));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunNotoccur) {
    	notoccurThrowException(auxFunName("notoccur") + "(" + stringRep(variable) + ", " + stringRep(other)+ ")",
    		NOTOCCUR,
    		e_applyAuxFunNotoccur, variable, other, new ErrorInformation[] {new ErrorInformation(variable), new ErrorInformation(other)});
    	return false;
    }
  }
  
  protected Boolean applyAuxFunNotoccur(final RuleApplicationTrace _trace_, final TypeVariable variable, final TypeVariable other) throws RuleFailedException {
    String _typevarName = variable.getTypevarName();
    String _typevarName_1 = other.getTypevarName();
    boolean _notEquals = (!Objects.equal(_typevarName, _typevarName_1));
    /* variable.typevarName != other.typevarName */
    if (!_notEquals) {
      sneakyThrowRuleFailedException("variable.typevarName != other.typevarName");
    }
    return true;
  }
  
  protected Boolean notoccurImpl(final RuleApplicationTrace _trace_, final TypeVariable variable, final ArrowType arrowType) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Boolean _result_ = applyAuxFunNotoccur(_subtrace_, variable, arrowType);
    	addToTrace(_trace_, auxFunName("notoccur") + "(" + stringRep(variable) + ", " + stringRep(arrowType)+ ")" + " = " + stringRep(_result_));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunNotoccur) {
    	notoccurThrowException(auxFunName("notoccur") + "(" + stringRep(variable) + ", " + stringRep(arrowType)+ ")",
    		NOTOCCUR,
    		e_applyAuxFunNotoccur, variable, arrowType, new ErrorInformation[] {new ErrorInformation(variable), new ErrorInformation(arrowType)});
    	return false;
    }
  }
  
  protected Boolean applyAuxFunNotoccur(final RuleApplicationTrace _trace_, final TypeVariable variable, final ArrowType arrowType) throws RuleFailedException {
    Type _left = arrowType.getLeft();
    Boolean _notoccur = this.notoccurInternal(_trace_, variable, _left);
    /* notoccur(variable, arrowType.left) */
    if (!_notoccur) {
      sneakyThrowRuleFailedException("notoccur(variable, arrowType.left)");
    }
    Type _right = arrowType.getRight();
    Boolean _notoccur_1 = this.notoccurInternal(_trace_, variable, _right);
    /* notoccur(variable, arrowType.right) */
    if (!_notoccur_1) {
      sneakyThrowRuleFailedException("notoccur(variable, arrowType.right)");
    }
    return true;
  }
  
  protected Type typesubstitutionImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type type) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Type _result_ = applyAuxFunTypesubstitution(_subtrace_, substitutions, type);
    	addToTrace(_trace_, auxFunName("typesubstitution") + "(" + stringRep(substitutions) + ", " + stringRep(type)+ ")" + " = " + stringRep(_result_));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunTypesubstitution) {
    	typesubstitutionThrowException(auxFunName("typesubstitution") + "(" + stringRep(substitutions) + ", " + stringRep(type)+ ")",
    		TYPESUBSTITUTION,
    		e_applyAuxFunTypesubstitution, substitutions, type, new ErrorInformation[] {new ErrorInformation(type)});
    	return null;
    }
  }
  
  protected Type applyAuxFunTypesubstitution(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type type) throws RuleFailedException {
    return type;
  }
  
  protected Type typesubstitutionImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable variable) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Type _result_ = applyAuxFunTypesubstitution(_subtrace_, substitutions, variable);
    	addToTrace(_trace_, auxFunName("typesubstitution") + "(" + stringRep(substitutions) + ", " + stringRep(variable)+ ")" + " = " + stringRep(_result_));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunTypesubstitution) {
    	typesubstitutionThrowException(auxFunName("typesubstitution") + "(" + stringRep(substitutions) + ", " + stringRep(variable)+ ")",
    		TYPESUBSTITUTION,
    		e_applyAuxFunTypesubstitution, substitutions, variable, new ErrorInformation[] {new ErrorInformation(variable)});
    	return null;
    }
  }
  
  protected Type applyAuxFunTypesubstitution(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable variable) throws RuleFailedException {
    Type _xblockexpression = null;
    {
      String _typevarName = variable.getTypevarName();
      Type mapped = substitutions.mapped(_typevarName);
      Type _xifexpression = null;
      boolean _notEquals = (!Objects.equal(mapped, null));
      if (_notEquals) {
        Type _xblockexpression_1 = null;
        {
          final Type result = EcoreUtil.<Type>copy(mapped);
          _xblockexpression_1 = (this.typesubstitutionInternal(_trace_, substitutions, result));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = variable;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected Type typesubstitutionImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrowType) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Type _result_ = applyAuxFunTypesubstitution(_subtrace_, substitutions, arrowType);
    	addToTrace(_trace_, auxFunName("typesubstitution") + "(" + stringRep(substitutions) + ", " + stringRep(arrowType)+ ")" + " = " + stringRep(_result_));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunTypesubstitution) {
    	typesubstitutionThrowException(auxFunName("typesubstitution") + "(" + stringRep(substitutions) + ", " + stringRep(arrowType)+ ")",
    		TYPESUBSTITUTION,
    		e_applyAuxFunTypesubstitution, substitutions, arrowType, new ErrorInformation[] {new ErrorInformation(arrowType)});
    	return null;
    }
  }
  
  protected Type applyAuxFunTypesubstitution(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrowType) throws RuleFailedException {
    ArrowType _xblockexpression = null;
    {
      Type subResult = null;
      final ArrowType result = EcoreUtil.<ArrowType>copy(arrowType);
      Type _left = arrowType.getLeft();
      Type _typesubstitution = this.typesubstitutionInternal(_trace_, substitutions, _left);
      subResult = _typesubstitution;
      result.setLeft(subResult);
      Type _right = arrowType.getRight();
      Type _typesubstitution_1 = this.typesubstitutionInternal(_trace_, substitutions, _right);
      subResult = _typesubstitution_1;
      result.setRight(subResult);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  protected Result2<Type,Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type t1, final Type t2) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<Type, Type> _result_ = applyRuleUnifyType(G, _subtrace_, substitutions, t1, t2);
    	addToTrace(_trace_, ruleName("UnifyType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnifyType) {
    	unifyThrowException(ruleName("UnifyType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + "Type" + " ~~ " + "Type",
    		UNIFYTYPE,
    		e_applyRuleUnifyType, substitutions, t1, t2, new ErrorInformation[] {new ErrorInformation(t1), new ErrorInformation(t2)});
    	return null;
    }
  }
  
  protected Result2<Type,Type> applyRuleUnifyType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type t1, final Type t2) throws RuleFailedException {
    /* fail */
    throwForExplicitFail();
    return new Result2<Type,Type>(_applyRuleUnifyType_3(G, substitutions, t1, t2), _applyRuleUnifyType_4(G, substitutions, t1, t2));
  }
  
  private Type _applyRuleUnifyType_3(final RuleEnvironment G, final TypeSubstitutions substitutions, final Type t1, final Type t2) throws RuleFailedException {
    return t1;
  }
  
  private Type _applyRuleUnifyType_4(final RuleEnvironment G, final TypeSubstitutions substitutions, final Type t1, final Type t2) throws RuleFailedException {
    return t2;
  }
  
  protected Result2<Type,Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final StringType t1, final StringType t2) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<Type, Type> _result_ = applyRuleUnifyStringType(G, _subtrace_, substitutions, t1, t2);
    	addToTrace(_trace_, ruleName("UnifyStringType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnifyStringType) {
    	unifyThrowException(ruleName("UnifyStringType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + "StringType" + " ~~ " + "StringType",
    		UNIFYSTRINGTYPE,
    		e_applyRuleUnifyStringType, substitutions, t1, t2, new ErrorInformation[] {new ErrorInformation(t1), new ErrorInformation(t2)});
    	return null;
    }
  }
  
  protected Result2<Type,Type> applyRuleUnifyStringType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final StringType t1, final StringType t2) throws RuleFailedException {
    
    return new Result2<Type,Type>(_applyRuleUnifyStringType_3(G, substitutions, t1, t2), _applyRuleUnifyStringType_4(G, substitutions, t1, t2));
  }
  
  private StringType _applyRuleUnifyStringType_3(final RuleEnvironment G, final TypeSubstitutions substitutions, final StringType t1, final StringType t2) throws RuleFailedException {
    StringType _copy = EcoreUtil.<StringType>copy(t1);
    return _copy;
  }
  
  private StringType _applyRuleUnifyStringType_4(final RuleEnvironment G, final TypeSubstitutions substitutions, final StringType t1, final StringType t2) throws RuleFailedException {
    StringType _copy = EcoreUtil.<StringType>copy(t2);
    return _copy;
  }
  
  protected Result2<Type,Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final IntType t1, final IntType t2) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<Type, Type> _result_ = applyRuleUnifyIntType(G, _subtrace_, substitutions, t1, t2);
    	addToTrace(_trace_, ruleName("UnifyIntType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnifyIntType) {
    	unifyThrowException(ruleName("UnifyIntType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(t1) + " ~~ " + stringRep(t2) + " ~> " + "IntType" + " ~~ " + "IntType",
    		UNIFYINTTYPE,
    		e_applyRuleUnifyIntType, substitutions, t1, t2, new ErrorInformation[] {new ErrorInformation(t1), new ErrorInformation(t2)});
    	return null;
    }
  }
  
  protected Result2<Type,Type> applyRuleUnifyIntType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final IntType t1, final IntType t2) throws RuleFailedException {
    
    return new Result2<Type,Type>(_applyRuleUnifyIntType_3(G, substitutions, t1, t2), _applyRuleUnifyIntType_4(G, substitutions, t1, t2));
  }
  
  private IntType _applyRuleUnifyIntType_3(final RuleEnvironment G, final TypeSubstitutions substitutions, final IntType t1, final IntType t2) throws RuleFailedException {
    IntType _copy = EcoreUtil.<IntType>copy(t1);
    return _copy;
  }
  
  private IntType _applyRuleUnifyIntType_4(final RuleEnvironment G, final TypeSubstitutions substitutions, final IntType t1, final IntType t2) throws RuleFailedException {
    IntType _copy = EcoreUtil.<IntType>copy(t2);
    return _copy;
  }
  
  protected Result2<Type,Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable typeVar, final BasicType basicType) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<Type, Type> _result_ = applyRuleUnifyTypeVariableBasicType(G, _subtrace_, substitutions, typeVar, basicType);
    	addToTrace(_trace_, ruleName("UnifyTypeVariableBasicType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(typeVar) + " ~~ " + stringRep(basicType) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnifyTypeVariableBasicType) {
    	unifyThrowException(ruleName("UnifyTypeVariableBasicType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(typeVar) + " ~~ " + stringRep(basicType) + " ~> " + "BasicType" + " ~~ " + "BasicType",
    		UNIFYTYPEVARIABLEBASICTYPE,
    		e_applyRuleUnifyTypeVariableBasicType, substitutions, typeVar, basicType, new ErrorInformation[] {new ErrorInformation(typeVar), new ErrorInformation(basicType)});
    	return null;
    }
  }
  
  protected Result2<Type,Type> applyRuleUnifyTypeVariableBasicType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable typeVar, final BasicType basicType) throws RuleFailedException {
    BasicType result = null; // output parameter
    BasicType _copy = EcoreUtil.<BasicType>copy(basicType);
    result = _copy;
    String _typevarName = typeVar.getTypevarName();
    substitutions.add(_typevarName, result);
    return new Result2<Type,Type>(_applyRuleUnifyTypeVariableBasicType_3(G, substitutions, typeVar, basicType), result);
  }
  
  private BasicType _applyRuleUnifyTypeVariableBasicType_3(final RuleEnvironment G, final TypeSubstitutions substitutions, final TypeVariable typeVar, final BasicType basicType) throws RuleFailedException {
    BasicType _copy = EcoreUtil.<BasicType>copy(basicType);
    return _copy;
  }
  
  protected Result2<Type,Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final BasicType basicType, final TypeVariable typeVar) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<Type, Type> _result_ = applyRuleUnifyBasicTypeTypeVariable(G, _subtrace_, substitutions, basicType, typeVar);
    	addToTrace(_trace_, ruleName("UnifyBasicTypeTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(basicType) + " ~~ " + stringRep(typeVar) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnifyBasicTypeTypeVariable) {
    	unifyThrowException(ruleName("UnifyBasicTypeTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(basicType) + " ~~ " + stringRep(typeVar) + " ~> " + "BasicType" + " ~~ " + "BasicType",
    		UNIFYBASICTYPETYPEVARIABLE,
    		e_applyRuleUnifyBasicTypeTypeVariable, substitutions, basicType, typeVar, new ErrorInformation[] {new ErrorInformation(basicType), new ErrorInformation(typeVar)});
    	return null;
    }
  }
  
  protected Result2<Type,Type> applyRuleUnifyBasicTypeTypeVariable(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final BasicType basicType, final TypeVariable typeVar) throws RuleFailedException {
    BasicType resultForVar = null; // output parameter
    BasicType resultForBasic = null; // output parameter
    /* G |- substitutions |> typeVar ~~ basicType ~> resultForVar ~~ resultForBasic */
    Result2<Type,Type> result = unifyInternal(G, _trace_, substitutions, typeVar, basicType);
    checkAssignableTo(result.getFirst(), BasicType.class);
    resultForVar = (BasicType) result.getFirst();
    checkAssignableTo(result.getSecond(), BasicType.class);
    resultForBasic = (BasicType) result.getSecond();
    
    return new Result2<Type,Type>(resultForVar, resultForBasic);
  }
  
  protected Result2<Type,Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable originalLeft, final TypeVariable originalRight) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<Type, Type> _result_ = applyRuleUnifyTypeVariables(G, _subtrace_, substitutions, originalLeft, originalRight);
    	addToTrace(_trace_, ruleName("UnifyTypeVariables") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnifyTypeVariables) {
    	unifyThrowException(ruleName("UnifyTypeVariables") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + "TypeVariable" + " ~~ " + "TypeVariable",
    		UNIFYTYPEVARIABLES,
    		e_applyRuleUnifyTypeVariables, substitutions, originalLeft, originalRight, new ErrorInformation[] {new ErrorInformation(originalLeft), new ErrorInformation(originalRight)});
    	return null;
    }
  }
  
  protected Result2<Type,Type> applyRuleUnifyTypeVariables(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable originalLeft, final TypeVariable originalRight) throws RuleFailedException {
    TypeVariable newLeft = null; // output parameter
    TypeVariable newRight = null; // output parameter
    TypeVariable _createFreshTypeVariable = this.lambdaUtils.createFreshTypeVariable();
    newLeft = _createFreshTypeVariable;
    TypeVariable _copy = EcoreUtil.<TypeVariable>copy(newLeft);
    newRight = _copy;
    String _typevarName = originalLeft.getTypevarName();
    substitutions.add(_typevarName, newLeft);
    String _typevarName_1 = originalRight.getTypevarName();
    substitutions.add(_typevarName_1, newRight);
    return new Result2<Type,Type>(newLeft, newRight);
  }
  
  protected Result2<Type,Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable originalLeft, final ArrowType originalRight) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<Type, Type> _result_ = applyRuleUnifyTypeVariableArrowType(G, _subtrace_, substitutions, originalLeft, originalRight);
    	addToTrace(_trace_, ruleName("UnifyTypeVariableArrowType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnifyTypeVariableArrowType) {
    	unifyThrowException(ruleName("UnifyTypeVariableArrowType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + "ArrowType" + " ~~ " + "ArrowType",
    		UNIFYTYPEVARIABLEARROWTYPE,
    		e_applyRuleUnifyTypeVariableArrowType, substitutions, originalLeft, originalRight, new ErrorInformation[] {new ErrorInformation(originalLeft), new ErrorInformation(originalRight)});
    	return null;
    }
  }
  
  protected Result2<Type,Type> applyRuleUnifyTypeVariableArrowType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable originalLeft, final ArrowType originalRight) throws RuleFailedException {
    ArrowType newLeft = null; // output parameter
    Boolean _notoccur = this.notoccurInternal(_trace_, originalLeft, originalRight);
    /* notoccur(originalLeft, originalRight) */
    if (!_notoccur) {
      sneakyThrowRuleFailedException("notoccur(originalLeft, originalRight)");
    }
    ArrowType _copy = EcoreUtil.<ArrowType>copy(originalRight);
    newLeft = _copy;
    String _typevarName = originalLeft.getTypevarName();
    substitutions.add(_typevarName, newLeft);
    return new Result2<Type,Type>(newLeft, _applyRuleUnifyTypeVariableArrowType_4(G, substitutions, originalLeft, originalRight));
  }
  
  private ArrowType _applyRuleUnifyTypeVariableArrowType_4(final RuleEnvironment G, final TypeSubstitutions substitutions, final TypeVariable originalLeft, final ArrowType originalRight) throws RuleFailedException {
    ArrowType _copy = EcoreUtil.<ArrowType>copy(originalRight);
    return _copy;
  }
  
  protected Result2<Type,Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType originalLeft, final TypeVariable originalRight) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<Type, Type> _result_ = applyRuleUnifyArrowTypeTypeVariable(G, _subtrace_, substitutions, originalLeft, originalRight);
    	addToTrace(_trace_, ruleName("UnifyArrowTypeTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnifyArrowTypeTypeVariable) {
    	unifyThrowException(ruleName("UnifyArrowTypeTypeVariable") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(originalLeft) + " ~~ " + stringRep(originalRight) + " ~> " + "ArrowType" + " ~~ " + "ArrowType",
    		UNIFYARROWTYPETYPEVARIABLE,
    		e_applyRuleUnifyArrowTypeTypeVariable, substitutions, originalLeft, originalRight, new ErrorInformation[] {new ErrorInformation(originalLeft), new ErrorInformation(originalRight)});
    	return null;
    }
  }
  
  protected Result2<Type,Type> applyRuleUnifyArrowTypeTypeVariable(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType originalLeft, final TypeVariable originalRight) throws RuleFailedException {
    ArrowType newLeft = null; // output parameter
    ArrowType newRight = null; // output parameter
    /* G |- substitutions |> originalRight ~~ originalLeft ~> newRight ~~ newLeft */
    Result2<Type,Type> result = unifyInternal(G, _trace_, substitutions, originalRight, originalLeft);
    checkAssignableTo(result.getFirst(), ArrowType.class);
    newRight = (ArrowType) result.getFirst();
    checkAssignableTo(result.getSecond(), ArrowType.class);
    newLeft = (ArrowType) result.getSecond();
    
    return new Result2<Type,Type>(newLeft, newRight);
  }
  
  protected Result2<Type,Type> unifyImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrow1, final ArrowType arrow2) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<Type, Type> _result_ = applyRuleUnifyArrowTypes(G, _subtrace_, substitutions, arrow1, arrow2);
    	addToTrace(_trace_, ruleName("UnifyArrowTypes") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arrow1) + " ~~ " + stringRep(arrow2) + " ~> " + stringRep(_result_.getFirst()) + " ~~ " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnifyArrowTypes) {
    	unifyThrowException(ruleName("UnifyArrowTypes") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arrow1) + " ~~ " + stringRep(arrow2) + " ~> " + "ArrowType" + " ~~ " + "ArrowType",
    		UNIFYARROWTYPES,
    		e_applyRuleUnifyArrowTypes, substitutions, arrow1, arrow2, new ErrorInformation[] {new ErrorInformation(arrow1), new ErrorInformation(arrow2)});
    	return null;
    }
  }
  
  protected Result2<Type,Type> applyRuleUnifyArrowTypes(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrow1, final ArrowType arrow2) throws RuleFailedException {
    ArrowType newArrow1 = null; // output parameter
    ArrowType newArrow2 = null; // output parameter
    ArrowType _copy = EcoreUtil.<ArrowType>copy(arrow1);
    newArrow1 = _copy;
    ArrowType _copy_1 = EcoreUtil.<ArrowType>copy(arrow2);
    newArrow2 = _copy_1;
    Type temp1 = null;
    Type temp2 = null;
    /* G |- substitutions |> arrow1.left ~~ arrow2.left ~> temp1 ~~ temp2 */
    Type _left = arrow1.getLeft();
    Type _left_1 = arrow2.getLeft();
    Result2<Type,Type> result = unifyInternal(G, _trace_, substitutions, _left, _left_1);
    checkAssignableTo(result.getFirst(), Type.class);
    temp1 = (Type) result.getFirst();
    checkAssignableTo(result.getSecond(), Type.class);
    temp2 = (Type) result.getSecond();
    
    newArrow1.setLeft(temp1);
    newArrow2.setLeft(temp2);
    /* G |- substitutions |> arrow1.right ~~ arrow2.right ~> temp1 ~~ temp2 */
    Type _right = arrow1.getRight();
    Type _right_1 = arrow2.getRight();
    Result2<Type,Type> result_1 = unifyInternal(G, _trace_, substitutions, _right, _right_1);
    checkAssignableTo(result_1.getFirst(), Type.class);
    temp1 = (Type) result_1.getFirst();
    checkAssignableTo(result_1.getSecond(), Type.class);
    temp2 = (Type) result_1.getSecond();
    
    newArrow1.setRight(temp1);
    newArrow2.setRight(temp2);
    return new Result2<Type,Type>(newArrow1, newArrow2);
  }
  
  protected Result<Type> paramtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Parameter param) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Type> _result_ = applyRuleParameterType(G, _subtrace_, param);
    	addToTrace(_trace_, ruleName("ParameterType") + stringRepForEnv(G) + " |~ " + stringRep(param) + " : " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleParameterType) {
    	paramtypeThrowException(ruleName("ParameterType") + stringRepForEnv(G) + " |~ " + stringRep(param) + " : " + "Type",
    		PARAMETERTYPE,
    		e_applyRuleParameterType, param, new ErrorInformation[] {new ErrorInformation(param)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleParameterType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Parameter param) throws RuleFailedException {
    Type type = null; // output parameter
    /* { param.type != null type = EcoreUtil::copy(param.type) } or type = lambdaUtils.createFreshTypeVariable */
    try {
      Type _type = param.getType();
      boolean _notEquals = (!Objects.equal(_type, null));
      /* param.type != null */
      if (!_notEquals) {
        sneakyThrowRuleFailedException("param.type != null");
      }
      Type _type_1 = param.getType();
      Type _copy = EcoreUtil.<Type>copy(_type_1);
      type = _copy;
    } catch (Exception e) {
      TypeVariable _createFreshTypeVariable = this.lambdaUtils.createFreshTypeVariable();
      type = _createFreshTypeVariable;
    }
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final StringConstant stringConstant) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Type> _result_ = applyRuleStringConstantType(G, _subtrace_, substitutions, stringConstant);
    	addToTrace(_trace_, ruleName("StringConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(stringConstant) + " : " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleStringConstantType) {
    	typeThrowException(ruleName("StringConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(stringConstant) + " : " + "StringType",
    		STRINGCONSTANTTYPE,
    		e_applyRuleStringConstantType, substitutions, stringConstant, new ErrorInformation[] {new ErrorInformation(stringConstant)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleStringConstantType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final StringConstant stringConstant) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleStringConstantType_2(G, substitutions, stringConstant));
  }
  
  private StringType _applyRuleStringConstantType_2(final RuleEnvironment G, final TypeSubstitutions substitutions, final StringConstant stringConstant) throws RuleFailedException {
    StringType _createStringType = this.lambdaUtils.createStringType();
    return _createStringType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final IntConstant intConstant) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Type> _result_ = applyRuleIntConstantType(G, _subtrace_, substitutions, intConstant);
    	addToTrace(_trace_, ruleName("IntConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(intConstant) + " : " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleIntConstantType) {
    	typeThrowException(ruleName("IntConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(intConstant) + " : " + "IntType",
    		INTCONSTANTTYPE,
    		e_applyRuleIntConstantType, substitutions, intConstant, new ErrorInformation[] {new ErrorInformation(intConstant)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleIntConstantType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final IntConstant intConstant) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleIntConstantType_2(G, substitutions, intConstant));
  }
  
  private IntType _applyRuleIntConstantType_2(final RuleEnvironment G, final TypeSubstitutions substitutions, final IntConstant intConstant) throws RuleFailedException {
    IntType _createIntType = this.lambdaUtils.createIntType();
    return _createIntType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Variable variable) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Type> _result_ = applyRuleVariableType(G, _subtrace_, substitutions, variable);
    	addToTrace(_trace_, ruleName("VariableType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(variable) + " : " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleVariableType) {
    	typeThrowException(ruleName("VariableType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(variable) + " : " + "Type",
    		VARIABLETYPE,
    		e_applyRuleVariableType, substitutions, variable, new ErrorInformation[] {new ErrorInformation(variable)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleVariableType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Variable variable) throws RuleFailedException {
    Type type = null; // output parameter
    /* env(G, variable.ref, Type) */
    Parameter _ref = variable.getRef();
    Type _environmentaccess = environmentAccess(G, _ref, Type.class);
    Type _copy = EcoreUtil.<Type>copy(_environmentaccess);
    Type _typesubstitution = this.typesubstitutionInternal(_trace_, substitutions, _copy);
    type = _typesubstitution;
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Arithmetics arithmetics) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Type> _result_ = applyRuleArithmeticsType(G, _subtrace_, substitutions, arithmetics);
    	addToTrace(_trace_, ruleName("ArithmeticsType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arithmetics) + " : " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleArithmeticsType) {
    	typeThrowException(ruleName("ArithmeticsType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arithmetics) + " : " + "IntType",
    		ARITHMETICSTYPE,
    		e_applyRuleArithmeticsType, substitutions, arithmetics, new ErrorInformation[] {new ErrorInformation(arithmetics)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleArithmeticsType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Arithmetics arithmetics) throws RuleFailedException {
    IntType intType = null; // output parameter
    IntType _createIntType = this.lambdaUtils.createIntType();
    intType = _createIntType;
    /* G |- substitutions |> arithmetics.term : var Type termType */
    Term _term = arithmetics.getTerm();
    Type termType = null;
    Result<Type> result = typeInternal(G, _trace_, substitutions, _term);
    checkAssignableTo(result.getFirst(), Type.class);
    termType = (Type) result.getFirst();
    
    /* G |- substitutions |> termType ~~ intType ~> intType ~~ intType */
    Result2<Type,Type> result_1 = unifyInternal(G, _trace_, substitutions, termType, intType);
    checkAssignableTo(result_1.getFirst(), IntType.class);
    intType = (IntType) result_1.getFirst();
    checkAssignableTo(result_1.getSecond(), IntType.class);
    intType = (IntType) result_1.getSecond();
    
    return new Result<Type>(intType);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Abstraction abstraction) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Type> _result_ = applyRuleAbstractionType(G, _subtrace_, substitutions, abstraction);
    	addToTrace(_trace_, ruleName("AbstractionType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(abstraction) + " : " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAbstractionType) {
    	typeThrowException(ruleName("AbstractionType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(abstraction) + " : " + "ArrowType",
    		ABSTRACTIONTYPE,
    		e_applyRuleAbstractionType, substitutions, abstraction, new ErrorInformation[] {new ErrorInformation(abstraction)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleAbstractionType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Abstraction abstraction) throws RuleFailedException {
    ArrowType type = null; // output parameter
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
    
    Type _typesubstitution = this.typesubstitutionInternal(_trace_, substitutions, paramType);
    paramType = _typesubstitution;
    Type _typesubstitution_1 = this.typesubstitutionInternal(_trace_, substitutions, termType);
    termType = _typesubstitution_1;
    ArrowType _createArrowType = this.lambdaUtils.createArrowType(paramType, termType);
    type = _createArrowType;
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Application application) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Type> _result_ = applyRuleApplicationType(G, _subtrace_, substitutions, application);
    	addToTrace(_trace_, ruleName("ApplicationType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(application) + " : " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleApplicationType) {
    	typeThrowException(ruleName("ApplicationType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(application) + " : " + "Type",
    		APPLICATIONTYPE,
    		e_applyRuleApplicationType, substitutions, application, new ErrorInformation[] {new ErrorInformation(application)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleApplicationType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Application application) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- substitutions |> application.fun : var Type funType */
    Term _fun = application.getFun();
    Type funType = null;
    Result<Type> result = typeInternal(G, _trace_, substitutions, _fun);
    checkAssignableTo(result.getFirst(), Type.class);
    funType = (Type) result.getFirst();
    
    ArrowType arrowType = this.lambdaUtils.createFreshArrowType();
    /* G |- substitutions |> funType ~~ arrowType ~> funType ~~ arrowType */
    Result2<Type,Type> result_1 = unifyInternal(G, _trace_, substitutions, funType, arrowType);
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
    Result2<Type,Type> result_3 = unifyInternal(G, _trace_, substitutions, _left, argType);
    checkAssignableTo(result_3.getFirst(), Type.class);
    funType = (Type) result_3.getFirst();
    checkAssignableTo(result_3.getSecond(), Type.class);
    argType = (Type) result_3.getSecond();
    
    Type _right = arrowType.getRight();
    Type _typesubstitution = this.typesubstitutionInternal(_trace_, substitutions, _right);
    type = _typesubstitution;
    return new Result<Type>(type);
  }
}
