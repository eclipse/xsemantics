package it.xsemantics.example.lambda.xsemantics;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
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
import it.xsemantics.example.lambda.xsemantics.UnifyResult;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
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
  
  public final static String UNIFY = "it.xsemantics.example.lambda.xsemantics.Unify";
  
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
  
  private PolymorphicDispatcher<UnifyResult> unifyDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> paramtypeDispatcher;
  
  public LambdaXsemanticsSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 4, "|-", "|>", ":");
    paramtypeDispatcher = buildPolymorphicDispatcher1(
    	"paramtypeImpl", 3, "|~", ":");
    notoccurDispatcher = buildPolymorphicDispatcher(
    	"notoccurImpl", 3);
    typesubstitutionDispatcher = buildPolymorphicDispatcher(
    	"typesubstitutionImpl", 3);
    unifyDispatcher = buildPolymorphicDispatcher(
    	"unifyImpl", 4);
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
  
  public UnifyResult unify(final TypeSubstitutions substitutions, final Type left, final Type right) throws RuleFailedException {
    return unify(null, substitutions, left, right);
  }
  
  public UnifyResult unify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type left, final Type right) throws RuleFailedException {
    try {
    	return unifyInternal(_trace_, substitutions, left, right);
    } catch (Exception _e_unify) {
    	throw extractRuleFailedException(_e_unify);
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
  
  protected UnifyResult unifyInternal(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type left, final Type right) {
    try {
    	checkParamsNotNull(substitutions, left, right);
    	return unifyDispatcher.invoke(_trace_, substitutions, left, right);
    } catch (Exception _e_unify) {
    	sneakyThrowRuleFailedException(_e_unify);
    	return null;
    }
  }
  
  protected void unifyThrowException(final String _error, final String _issue, final Exception _ex, final TypeSubstitutions substitutions, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = ("cannot unify " + _stringRep);
    String _plus_1 = (_plus + 
      " with ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_2 = (_plus_1 + _stringRep_1);
    String error = _plus_2;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
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
  
  protected Boolean notoccurImpl(final RuleApplicationTrace _trace_, final Type type, final Type other) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunNotoccur(_subtrace_, type, other);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("notoccur") + "(" + stringRep(type) + ", " + stringRep(other)+ ")" + " = " + stringRep(_result_);
    		}
    	});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunNotoccur(_subtrace_, variable, other);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("notoccur") + "(" + stringRep(variable) + ", " + stringRep(other)+ ")" + " = " + stringRep(_result_);
    		}
    	});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunNotoccur(_subtrace_, variable, arrowType);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("notoccur") + "(" + stringRep(variable) + ", " + stringRep(arrowType)+ ")" + " = " + stringRep(_result_);
    		}
    	});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunTypesubstitution(_subtrace_, substitutions, type);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("typesubstitution") + "(" + stringRep(substitutions) + ", " + stringRep(type)+ ")" + " = " + stringRep(_result_);
    		}
    	});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunTypesubstitution(_subtrace_, substitutions, variable);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("typesubstitution") + "(" + stringRep(substitutions) + ", " + stringRep(variable)+ ")" + " = " + stringRep(_result_);
    		}
    	});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunTypesubstitution(_subtrace_, substitutions, arrowType);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("typesubstitution") + "(" + stringRep(substitutions) + ", " + stringRep(arrowType)+ ")" + " = " + stringRep(_result_);
    		}
    	});
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
  
  protected UnifyResult unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type t1, final Type t2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final UnifyResult _result_ = applyAuxFunUnify(_subtrace_, substitutions, t1, t2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(t1) + ", " + stringRep(t2)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(t1) + ", " + stringRep(t2)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, t1, t2, new ErrorInformation[] {new ErrorInformation(t1), new ErrorInformation(t2)});
    	return null;
    }
  }
  
  protected UnifyResult applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type t1, final Type t2) throws RuleFailedException {
    Object _xblockexpression = null;
    {
      /* fail */
      throwForExplicitFail();
      _xblockexpression = (null);
    }
    return ((UnifyResult)_xblockexpression);
  }
  
  protected UnifyResult unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final StringType t1, final StringType t2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final UnifyResult _result_ = applyAuxFunUnify(_subtrace_, substitutions, t1, t2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(t1) + ", " + stringRep(t2)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(t1) + ", " + stringRep(t2)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, t1, t2, new ErrorInformation[] {new ErrorInformation(t1), new ErrorInformation(t2)});
    	return null;
    }
  }
  
  protected UnifyResult applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final StringType t1, final StringType t2) throws RuleFailedException {
    StringType _copy = EcoreUtil.<StringType>copy(t1);
    StringType _copy_1 = EcoreUtil.<StringType>copy(t2);
    return new UnifyResult(_copy, _copy_1);
  }
  
  protected UnifyResult unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final IntType t1, final IntType t2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final UnifyResult _result_ = applyAuxFunUnify(_subtrace_, substitutions, t1, t2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(t1) + ", " + stringRep(t2)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(t1) + ", " + stringRep(t2)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, t1, t2, new ErrorInformation[] {new ErrorInformation(t1), new ErrorInformation(t2)});
    	return null;
    }
  }
  
  protected UnifyResult applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final IntType t1, final IntType t2) throws RuleFailedException {
    IntType _copy = EcoreUtil.<IntType>copy(t1);
    IntType _copy_1 = EcoreUtil.<IntType>copy(t2);
    return new UnifyResult(_copy, _copy_1);
  }
  
  protected UnifyResult unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable typeVar, final BasicType basicType) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final UnifyResult _result_ = applyAuxFunUnify(_subtrace_, substitutions, typeVar, basicType);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(typeVar) + ", " + stringRep(basicType)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(typeVar) + ", " + stringRep(basicType)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, typeVar, basicType, new ErrorInformation[] {new ErrorInformation(typeVar), new ErrorInformation(basicType)});
    	return null;
    }
  }
  
  protected UnifyResult applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable typeVar, final BasicType basicType) throws RuleFailedException {
    UnifyResult _xblockexpression = null;
    {
      final BasicType result = EcoreUtil.<BasicType>copy(basicType);
      String _typevarName = typeVar.getTypevarName();
      substitutions.add(_typevarName, result);
      BasicType _copy = EcoreUtil.<BasicType>copy(basicType);
      _xblockexpression = (new UnifyResult(_copy, result));
    }
    return _xblockexpression;
  }
  
  protected UnifyResult unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final BasicType basicType, final TypeVariable typeVar) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final UnifyResult _result_ = applyAuxFunUnify(_subtrace_, substitutions, basicType, typeVar);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(basicType) + ", " + stringRep(typeVar)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(basicType) + ", " + stringRep(typeVar)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, basicType, typeVar, new ErrorInformation[] {new ErrorInformation(basicType), new ErrorInformation(typeVar)});
    	return null;
    }
  }
  
  protected UnifyResult applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final BasicType basicType, final TypeVariable typeVar) throws RuleFailedException {
    return this.unifyInternal(_trace_, substitutions, typeVar, basicType);
  }
  
  protected UnifyResult unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable originalLeft, final TypeVariable originalRight) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final UnifyResult _result_ = applyAuxFunUnify(_subtrace_, substitutions, originalLeft, originalRight);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(originalLeft) + ", " + stringRep(originalRight)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(originalLeft) + ", " + stringRep(originalRight)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, originalLeft, originalRight, new ErrorInformation[] {new ErrorInformation(originalLeft), new ErrorInformation(originalRight)});
    	return null;
    }
  }
  
  protected UnifyResult applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable originalLeft, final TypeVariable originalRight) throws RuleFailedException {
    UnifyResult _xblockexpression = null;
    {
      final TypeVariable newLeft = this.lambdaUtils.createFreshTypeVariable();
      final TypeVariable newRight = EcoreUtil.<TypeVariable>copy(newLeft);
      String _typevarName = originalLeft.getTypevarName();
      substitutions.add(_typevarName, newLeft);
      String _typevarName_1 = originalRight.getTypevarName();
      substitutions.add(_typevarName_1, newRight);
      _xblockexpression = (new UnifyResult(newLeft, newRight));
    }
    return _xblockexpression;
  }
  
  protected UnifyResult unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable originalLeft, final ArrowType originalRight) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final UnifyResult _result_ = applyAuxFunUnify(_subtrace_, substitutions, originalLeft, originalRight);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(originalLeft) + ", " + stringRep(originalRight)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(originalLeft) + ", " + stringRep(originalRight)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, originalLeft, originalRight, new ErrorInformation[] {new ErrorInformation(originalLeft), new ErrorInformation(originalRight)});
    	return null;
    }
  }
  
  protected UnifyResult applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable originalLeft, final ArrowType originalRight) throws RuleFailedException {
    UnifyResult _xblockexpression = null;
    {
      Boolean _notoccur = this.notoccurInternal(_trace_, originalLeft, originalRight);
      /* notoccur(originalLeft, originalRight) */
      if (!_notoccur) {
        sneakyThrowRuleFailedException("notoccur(originalLeft, originalRight)");
      }
      final ArrowType newLeft = EcoreUtil.<ArrowType>copy(originalRight);
      String _typevarName = originalLeft.getTypevarName();
      substitutions.add(_typevarName, newLeft);
      ArrowType _copy = EcoreUtil.<ArrowType>copy(originalRight);
      _xblockexpression = (new UnifyResult(newLeft, _copy));
    }
    return _xblockexpression;
  }
  
  protected UnifyResult unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType originalLeft, final TypeVariable originalRight) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final UnifyResult _result_ = applyAuxFunUnify(_subtrace_, substitutions, originalLeft, originalRight);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(originalLeft) + ", " + stringRep(originalRight)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(originalLeft) + ", " + stringRep(originalRight)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, originalLeft, originalRight, new ErrorInformation[] {new ErrorInformation(originalLeft), new ErrorInformation(originalRight)});
    	return null;
    }
  }
  
  protected UnifyResult applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType originalLeft, final TypeVariable originalRight) throws RuleFailedException {
    return this.unifyInternal(_trace_, substitutions, originalRight, originalLeft);
  }
  
  protected UnifyResult unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrow1, final ArrowType arrow2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final UnifyResult _result_ = applyAuxFunUnify(_subtrace_, substitutions, arrow1, arrow2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(arrow1) + ", " + stringRep(arrow2)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(arrow1) + ", " + stringRep(arrow2)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, arrow1, arrow2, new ErrorInformation[] {new ErrorInformation(arrow1), new ErrorInformation(arrow2)});
    	return null;
    }
  }
  
  protected UnifyResult applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrow1, final ArrowType arrow2) throws RuleFailedException {
    UnifyResult _xblockexpression = null;
    {
      final ArrowType newArrow1 = EcoreUtil.<ArrowType>copy(arrow1);
      final ArrowType newArrow2 = EcoreUtil.<ArrowType>copy(arrow2);
      Type _left = arrow1.getLeft();
      Type _left_1 = arrow2.getLeft();
      UnifyResult result = this.unifyInternal(_trace_, substitutions, _left, _left_1);
      Type _first = result.getFirst();
      newArrow1.setLeft(_first);
      Type _second = result.getSecond();
      newArrow2.setLeft(_second);
      Type _right = arrow1.getRight();
      Type _right_1 = arrow2.getRight();
      UnifyResult _unify = this.unifyInternal(_trace_, substitutions, _right, _right_1);
      result = _unify;
      Type _first_1 = result.getFirst();
      newArrow1.setRight(_first_1);
      Type _second_1 = result.getSecond();
      newArrow2.setRight(_second_1);
      _xblockexpression = (new UnifyResult(newArrow1, newArrow2));
    }
    return _xblockexpression;
  }
  
  protected Result<Type> paramtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Parameter param) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleParameterType(G, _subtrace_, param);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ParameterType") + stringRepForEnv(G) + " |~ " + stringRep(param) + " : " + stringRep(_result_.getFirst());
    		}
    	});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleStringConstantType(G, _subtrace_, substitutions, stringConstant);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("StringConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(stringConstant) + " : " + stringRep(_result_.getFirst());
    		}
    	});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleIntConstantType(G, _subtrace_, substitutions, intConstant);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("IntConstantType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(intConstant) + " : " + stringRep(_result_.getFirst());
    		}
    	});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleVariableType(G, _subtrace_, substitutions, variable);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("VariableType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(variable) + " : " + stringRep(_result_.getFirst());
    		}
    	});
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
    Parameter _ref = variable.getRef();
    Type _env = this.<Type>env(G, _ref, Type.class);
    Type _copy = EcoreUtil.<Type>copy(_env);
    Type _typesubstitution = this.typesubstitutionInternal(_trace_, substitutions, _copy);
    type = _typesubstitution;
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Arithmetics arithmetics) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleArithmeticsType(G, _subtrace_, substitutions, arithmetics);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ArithmeticsType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(arithmetics) + " : " + stringRep(_result_.getFirst());
    		}
    	});
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
    
    this.unifyInternal(_trace_, substitutions, termType, intType);
    return new Result<Type>(intType);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Abstraction abstraction) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAbstractionType(G, _subtrace_, substitutions, abstraction);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AbstractionType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(abstraction) + " : " + stringRep(_result_.getFirst());
    		}
    	});
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
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleApplicationType(G, _subtrace_, substitutions, application);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ApplicationType") + stringRepForEnv(G) + " |- " + stringRep(substitutions) + " |> " + stringRep(application) + " : " + stringRep(_result_.getFirst());
    		}
    	});
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
    UnifyResult _unify = this.unifyInternal(_trace_, substitutions, funType, arrowType);
    Type _second = _unify.getSecond();
    arrowType = ((ArrowType) _second);
    /* G |- substitutions |> application.arg : var Type argType */
    Term _arg = application.getArg();
    Type argType = null;
    Result<Type> result_1 = typeInternal(G, _trace_, substitutions, _arg);
    checkAssignableTo(result_1.getFirst(), Type.class);
    argType = (Type) result_1.getFirst();
    
    Type _left = arrowType.getLeft();
    this.unifyInternal(_trace_, substitutions, _left, argType);
    Type _right = arrowType.getRight();
    Type _typesubstitution = this.typesubstitutionInternal(_trace_, substitutions, _right);
    type = _typesubstitution;
    return new Result<Type>(type);
  }
}
