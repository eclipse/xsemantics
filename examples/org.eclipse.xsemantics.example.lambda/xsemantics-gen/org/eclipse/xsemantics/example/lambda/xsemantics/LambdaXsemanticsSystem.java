/**
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 */
package org.eclipse.xsemantics.example.lambda.xsemantics;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xsemantics.example.lambda.lambda.Abstraction;
import org.eclipse.xsemantics.example.lambda.lambda.Application;
import org.eclipse.xsemantics.example.lambda.lambda.Arithmetics;
import org.eclipse.xsemantics.example.lambda.lambda.ArrowType;
import org.eclipse.xsemantics.example.lambda.lambda.BasicType;
import org.eclipse.xsemantics.example.lambda.lambda.IntConstant;
import org.eclipse.xsemantics.example.lambda.lambda.IntType;
import org.eclipse.xsemantics.example.lambda.lambda.Parameter;
import org.eclipse.xsemantics.example.lambda.lambda.Program;
import org.eclipse.xsemantics.example.lambda.lambda.StringConstant;
import org.eclipse.xsemantics.example.lambda.lambda.StringType;
import org.eclipse.xsemantics.example.lambda.lambda.Term;
import org.eclipse.xsemantics.example.lambda.lambda.Type;
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable;
import org.eclipse.xsemantics.example.lambda.lambda.Variable;
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaUtils;
import org.eclipse.xsemantics.example.lambda.xsemantics.TypeSubstitutions;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class LambdaXsemanticsSystem extends XsemanticsRuntimeSystem {
  public static final String NOTOCCUR = "org.eclipse.xsemantics.example.lambda.xsemantics.Notoccur";
  
  public static final String TYPESUBSTITUTION = "org.eclipse.xsemantics.example.lambda.xsemantics.Typesubstitution";
  
  public static final String UNIFY = "org.eclipse.xsemantics.example.lambda.xsemantics.Unify";
  
  public static final String PARAMETERTYPE = "org.eclipse.xsemantics.example.lambda.xsemantics.ParameterType";
  
  public static final String STRINGCONSTANTTYPE = "org.eclipse.xsemantics.example.lambda.xsemantics.StringConstantType";
  
  public static final String INTCONSTANTTYPE = "org.eclipse.xsemantics.example.lambda.xsemantics.IntConstantType";
  
  public static final String VARIABLETYPE = "org.eclipse.xsemantics.example.lambda.xsemantics.VariableType";
  
  public static final String ARITHMETICSTYPE = "org.eclipse.xsemantics.example.lambda.xsemantics.ArithmeticsType";
  
  public static final String ABSTRACTIONTYPE = "org.eclipse.xsemantics.example.lambda.xsemantics.AbstractionType";
  
  public static final String APPLICATIONTYPE = "org.eclipse.xsemantics.example.lambda.xsemantics.ApplicationType";
  
  @Inject
  private LambdaUtils lambdaUtils;
  
  private PolymorphicDispatcher<Boolean> notoccurDispatcher;
  
  private PolymorphicDispatcher<Type> typesubstitutionDispatcher;
  
  private PolymorphicDispatcher<Type> unifyDispatcher;
  
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
  
  public Type unify(final TypeSubstitutions substitutions, final Type left, final Type right) throws RuleFailedException {
    return unify(null, substitutions, left, right);
  }
  
  public Type unify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type left, final Type right) throws RuleFailedException {
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
    } catch (Exception _e_CheckProgram) {
    	return resultForFailure(_e_CheckProgram);
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
  
  protected Type unifyInternal(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type left, final Type right) {
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
    Boolean _notoccur = this.notoccurInternal(_trace_, variable, arrowType.getLeft());
    /* notoccur(variable, arrowType.left) */
    if (!_notoccur) {
      sneakyThrowRuleFailedException("notoccur(variable, arrowType.left)");
    }
    Boolean _notoccur_1 = this.notoccurInternal(_trace_, variable, arrowType.getRight());
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
      Type mapped = substitutions.mapped(variable.getTypevarName());
      Type _xifexpression = null;
      if ((mapped != null)) {
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
      subResult = this.typesubstitutionInternal(_trace_, substitutions, arrowType.getLeft());
      result.setLeft(subResult);
      subResult = this.typesubstitutionInternal(_trace_, substitutions, arrowType.getRight());
      result.setRight(subResult);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  protected Type unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type t1, final Type t2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunUnify(_subtrace_, substitutions, t1, t2);
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
  
  protected Type applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final Type t1, final Type t2) throws RuleFailedException {
    Object _xblockexpression = null;
    {
      /* fail */
      throwForExplicitFail();
      _xblockexpression = (null);
    }
    return ((Type)_xblockexpression);
  }
  
  protected Type unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final StringType t1, final StringType t2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunUnify(_subtrace_, substitutions, t1, t2);
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
  
  protected Type applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final StringType t1, final StringType t2) throws RuleFailedException {
    return EcoreUtil.<StringType>copy(t1);
  }
  
  protected Type unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final IntType t1, final IntType t2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunUnify(_subtrace_, substitutions, t1, t2);
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
  
  protected Type applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final IntType t1, final IntType t2) throws RuleFailedException {
    return EcoreUtil.<IntType>copy(t1);
  }
  
  protected Type unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable typeVar, final BasicType basicType) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunUnify(_subtrace_, substitutions, typeVar, basicType);
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
  
  protected Type applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable typeVar, final BasicType basicType) throws RuleFailedException {
    BasicType _xblockexpression = null;
    {
      substitutions.add(typeVar.getTypevarName(), basicType);
      _xblockexpression = (EcoreUtil.<BasicType>copy(basicType));
    }
    return _xblockexpression;
  }
  
  protected Type unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final BasicType basicType, final TypeVariable typeVar) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunUnify(_subtrace_, substitutions, basicType, typeVar);
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
  
  protected Type applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final BasicType basicType, final TypeVariable typeVar) throws RuleFailedException {
    return this.unifyInternal(_trace_, substitutions, typeVar, basicType);
  }
  
  protected Type unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable left, final TypeVariable right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunUnify(_subtrace_, substitutions, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(left) + ", " + stringRep(right)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(left) + ", " + stringRep(right)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Type applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable left, final TypeVariable right) throws RuleFailedException {
    TypeVariable _xblockexpression = null;
    {
      final TypeVariable fresh = this.lambdaUtils.createFreshTypeVariable();
      substitutions.add(left.getTypevarName(), fresh);
      substitutions.add(right.getTypevarName(), fresh);
      _xblockexpression = (fresh);
    }
    return _xblockexpression;
  }
  
  protected Type unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable v, final ArrowType arrow) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunUnify(_subtrace_, substitutions, v, arrow);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(v) + ", " + stringRep(arrow)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(v) + ", " + stringRep(arrow)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, v, arrow, new ErrorInformation[] {new ErrorInformation(v), new ErrorInformation(arrow)});
    	return null;
    }
  }
  
  protected Type applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final TypeVariable v, final ArrowType arrow) throws RuleFailedException {
    ArrowType _xblockexpression = null;
    {
      Boolean _notoccur = this.notoccurInternal(_trace_, v, arrow);
      /* notoccur(v, arrow) */
      if (!_notoccur) {
        sneakyThrowRuleFailedException("notoccur(v, arrow)");
      }
      substitutions.add(v.getTypevarName(), arrow);
      _xblockexpression = (EcoreUtil.<ArrowType>copy(arrow));
    }
    return _xblockexpression;
  }
  
  protected Type unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrow, final TypeVariable v) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunUnify(_subtrace_, substitutions, arrow, v);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(arrow) + ", " + stringRep(v)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunUnify) {
    	unifyThrowException(auxFunName("unify") + "(" + stringRep(substitutions) + ", " + stringRep(arrow) + ", " + stringRep(v)+ ")",
    		UNIFY,
    		e_applyAuxFunUnify, substitutions, arrow, v, new ErrorInformation[] {new ErrorInformation(arrow), new ErrorInformation(v)});
    	return null;
    }
  }
  
  protected Type applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrow, final TypeVariable v) throws RuleFailedException {
    return this.unifyInternal(_trace_, substitutions, v, arrow);
  }
  
  protected Type unifyImpl(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrow1, final ArrowType arrow2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Type _result_ = applyAuxFunUnify(_subtrace_, substitutions, arrow1, arrow2);
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
  
  protected Type applyAuxFunUnify(final RuleApplicationTrace _trace_, final TypeSubstitutions substitutions, final ArrowType arrow1, final ArrowType arrow2) throws RuleFailedException {
    ArrowType _xblockexpression = null;
    {
      final ArrowType newArrow1 = EcoreUtil.<ArrowType>copy(arrow1);
      final ArrowType newArrow2 = EcoreUtil.<ArrowType>copy(arrow2);
      Type result = this.unifyInternal(_trace_, substitutions, arrow1.getLeft(), arrow2.getLeft());
      newArrow1.setLeft(EcoreUtil.<Type>copy(result));
      newArrow2.setLeft(EcoreUtil.<Type>copy(result));
      result = this.unifyInternal(_trace_, substitutions, arrow1.getRight(), arrow2.getRight());
      newArrow1.setRight(EcoreUtil.<Type>copy(result));
      newArrow2.setRight(EcoreUtil.<Type>copy(result));
      _xblockexpression = (newArrow1);
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
    /* { param.type !== null type = EcoreUtil.copy(param.type) } or type = lambdaUtils.createFreshTypeVariable */
    {
      RuleFailedException previousFailure = null;
      try {
        Type _type = param.getType();
        boolean _tripleNotEquals = (_type != null);
        /* param.type !== null */
        if (!_tripleNotEquals) {
          sneakyThrowRuleFailedException("param.type !== null");
        }
        type = EcoreUtil.<Type>copy(param.getType());
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        type = this.lambdaUtils.createFreshTypeVariable();
      }
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
    type = this.typesubstitutionInternal(_trace_, substitutions, 
      EcoreUtil.<Type>copy(this.<Type>env(G, variable.getRef(), Type.class)));
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
    intType = this.lambdaUtils.createIntType();
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
    
    paramType = this.typesubstitutionInternal(_trace_, substitutions, paramType);
    termType = this.typesubstitutionInternal(_trace_, substitutions, termType);
    type = this.lambdaUtils.createArrowType(paramType, termType);
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
    Type _unify = this.unifyInternal(_trace_, substitutions, funType, arrowType);
    arrowType = ((ArrowType) _unify);
    /* G |- substitutions |> application.arg : var Type argType */
    Term _arg = application.getArg();
    Type argType = null;
    Result<Type> result_1 = typeInternal(G, _trace_, substitutions, _arg);
    checkAssignableTo(result_1.getFirst(), Type.class);
    argType = (Type) result_1.getFirst();
    
    this.unifyInternal(_trace_, substitutions, arrowType.getLeft(), argType);
    type = this.typesubstitutionInternal(_trace_, substitutions, arrowType.getRight());
    return new Result<Type>(type);
  }
}
