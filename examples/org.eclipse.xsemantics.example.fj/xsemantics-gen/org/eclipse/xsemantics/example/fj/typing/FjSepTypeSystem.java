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
package org.eclipse.xsemantics.example.fj.typing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.example.fj.fj.Cast;
import org.eclipse.xsemantics.example.fj.fj.ClassType;
import org.eclipse.xsemantics.example.fj.fj.Constant;
import org.eclipse.xsemantics.example.fj.fj.Expression;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.FjPackage;
import org.eclipse.xsemantics.example.fj.fj.Member;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.example.fj.fj.New;
import org.eclipse.xsemantics.example.fj.fj.ParamRef;
import org.eclipse.xsemantics.example.fj.fj.Parameter;
import org.eclipse.xsemantics.example.fj.fj.Program;
import org.eclipse.xsemantics.example.fj.fj.Selection;
import org.eclipse.xsemantics.example.fj.fj.This;
import org.eclipse.xsemantics.example.fj.fj.Type;
import org.eclipse.xsemantics.example.fj.fj.TypedElement;
import org.eclipse.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import org.eclipse.xsemantics.example.fj.typing.FjTypeSystem;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * A version of the FJ system where type computation and
 * checking are separated.
 */
@SuppressWarnings("all")
public class FjSepTypeSystem extends FjTypeSystem {
  public static final String TNEW = "org.eclipse.xsemantics.example.fj.typing.TNew";
  
  public static final String TSELECTION = "org.eclipse.xsemantics.example.fj.typing.TSelection";
  
  public static final String TCAST = "org.eclipse.xsemantics.example.fj.typing.TCast";
  
  public static final String CHECKCONSTANT = "org.eclipse.xsemantics.example.fj.typing.CheckConstant";
  
  public static final String CHECKTYPEDELEMENT = "org.eclipse.xsemantics.example.fj.typing.CheckTypedElement";
  
  public static final String CHECKPARAMREF = "org.eclipse.xsemantics.example.fj.typing.CheckParamRef";
  
  public static final String CHECKTHIS = "org.eclipse.xsemantics.example.fj.typing.CheckThis";
  
  public static final String CHECKMETHOD = "org.eclipse.xsemantics.example.fj.typing.CheckMethod";
  
  public static final String CHECKNEW = "org.eclipse.xsemantics.example.fj.typing.CheckNew";
  
  public static final String CHECKSELECTION = "org.eclipse.xsemantics.example.fj.typing.CheckSelection";
  
  public static final String CHECKCAST = "org.eclipse.xsemantics.example.fj.typing.CheckCast";
  
  public static final String CHECKCLASS = "org.eclipse.xsemantics.example.fj.typing.CheckClass";
  
  @Inject
  private FjAuxiliaryFunctions fjAux;
  
  private PolymorphicDispatcher<Result<Boolean>> checkDispatcher;
  
  public FjSepTypeSystem() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    checkDispatcher = buildPolymorphicDispatcher1(
    	"checkImpl", 3, "|-");
  }
  
  public FjAuxiliaryFunctions getFjAux() {
    return this.fjAux;
  }
  
  public void setFjAux(final FjAuxiliaryFunctions fjAux) {
    this.fjAux = fjAux;
  }
  
  public Result<Boolean> check(final EObject obj) {
    return check(new RuleEnvironment(), null, obj);
  }
  
  public Result<Boolean> check(final RuleEnvironment _environment_, final EObject obj) {
    return check(_environment_, null, obj);
  }
  
  public Result<Boolean> check(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	return checkInternal(_environment_, _trace_, obj);
    } catch (Exception _e_check) {
    	return resultForFailure(_e_check);
    }
  }
  
  public Boolean checkSucceeded(final EObject obj) {
    return checkSucceeded(new RuleEnvironment(), null, obj);
  }
  
  public Boolean checkSucceeded(final RuleEnvironment _environment_, final EObject obj) {
    return checkSucceeded(_environment_, null, obj);
  }
  
  public Boolean checkSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	checkInternal(_environment_, _trace_, obj);
    	return true;
    } catch (Exception _e_check) {
    	return false;
    }
  }
  
  public Result<Boolean> checkClassOk(final org.eclipse.xsemantics.example.fj.fj.Class clazz) {
    return checkClassOk(null, clazz);
  }
  
  public Result<Boolean> checkClassOk(final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class clazz) {
    try {
    	return checkClassOkInternal(_trace_, clazz);
    } catch (Exception _e_CheckClassOk) {
    	return resultForFailure(_e_CheckClassOk);
    }
  }
  
  protected Result<Boolean> checkClassOkInternal(final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class clazz) throws RuleFailedException {
    /* empty |- clazz */
    checkInternal(emptyEnvironment(), _trace_, clazz);
    return new Result<Boolean>(true);
  }
  
  @Override
  public Result<Boolean> checkMain(final Program program) {
    return checkMain(null, program);
  }
  
  @Override
  public Result<Boolean> checkMain(final RuleApplicationTrace _trace_, final Program program) {
    try {
    	return checkMainInternal(_trace_, program);
    } catch (Exception _e_CheckMain) {
    	return resultForFailure(_e_CheckMain);
    }
  }
  
  @Override
  protected Result<Boolean> checkMainInternal(final RuleApplicationTrace _trace_, final Program program) throws RuleFailedException {
    /* program.main === null or empty |- program.main */
    {
      RuleFailedException previousFailure = null;
      try {
        Expression _main = program.getMain();
        boolean _tripleEquals = (_main == null);
        /* program.main === null */
        if (!_tripleEquals) {
          sneakyThrowRuleFailedException("program.main === null");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* empty |- program.main */
        Expression _main_1 = program.getMain();
        checkInternal(emptyEnvironment(), _trace_, _main_1);
      }
    }
    return new Result<Boolean>(true);
  }
  
  @Override
  public Result<Boolean> checkMethodBody(final Method method) {
    return checkMethodBody(null, method);
  }
  
  @Override
  public Result<Boolean> checkMethodBody(final RuleApplicationTrace _trace_, final Method method) {
    try {
    	return checkMethodBodyInternal(_trace_, method);
    } catch (Exception _e_CheckMethodBody) {
    	return resultForFailure(_e_CheckMethodBody);
    }
  }
  
  @Override
  protected Result<Boolean> checkMethodBodyInternal(final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    return new Result<Boolean>(true);
  }
  
  @Override
  public Result<Boolean> checkField(final Field field) {
    return checkField(null, field);
  }
  
  @Override
  public Result<Boolean> checkField(final RuleApplicationTrace _trace_, final Field field) {
    try {
    	return checkFieldInternal(_trace_, field);
    } catch (Exception _e_CheckField) {
    	return resultForFailure(_e_CheckField);
    }
  }
  
  @Override
  protected Result<Boolean> checkFieldInternal(final RuleApplicationTrace _trace_, final Field field) throws RuleFailedException {
    return new Result<Boolean>(true);
  }
  
  @Override
  public Result<Boolean> checkMethodOverride(final Method method) {
    return checkMethodOverride(null, method);
  }
  
  @Override
  public Result<Boolean> checkMethodOverride(final RuleApplicationTrace _trace_, final Method method) {
    try {
    	return checkMethodOverrideInternal(_trace_, method);
    } catch (Exception _e_CheckMethodOverride) {
    	return resultForFailure(_e_CheckMethodOverride);
    }
  }
  
  @Override
  protected Result<Boolean> checkMethodOverrideInternal(final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	checkParamsNotNull(obj);
    	return checkDispatcher.invoke(_environment_, _trace_, obj);
    } catch (Exception _e_check) {
    	sneakyThrowRuleFailedException(_e_check);
    	return null;
    }
  }
  
  protected void checkThrowException(final String _error, final String _issue, final Exception _ex, final EObject obj, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  @Override
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTNew(G, _subtrace_, newExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TNew") + stringRepForEnv(G) + " |- " + stringRep(newExp) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTNew) {
    	typeThrowException(ruleName("TNew") + stringRepForEnv(G) + " |- " + stringRep(newExp) + " : " + "ClassType",
    		TNEW,
    		e_applyRuleTNew, newExp, new ErrorInformation[] {new ErrorInformation(newExp)});
    	return null;
    }
  }
  
  @Override
  protected Result<Type> applyRuleTNew(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTNew_1(G, newExp));
  }
  
  private ClassType _applyRuleTNew_1(final RuleEnvironment G, final New newExp) throws RuleFailedException {
    ClassType _type = newExp.getType();
    return _type;
  }
  
  @Override
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTSelection(G, _subtrace_, selection);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TSelection") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTSelection) {
    	typeThrowException(ruleName("TSelection") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + "Type",
    		TSELECTION,
    		e_applyRuleTSelection, selection, new ErrorInformation[] {new ErrorInformation(selection)});
    	return null;
    }
  }
  
  @Override
  protected Result<Type> applyRuleTSelection(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTSelection_1(G, selection));
  }
  
  private Type _applyRuleTSelection_1(final RuleEnvironment G, final Selection selection) throws RuleFailedException {
    Type _type = selection.getMessage().getType();
    return _type;
  }
  
  @Override
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTCast(G, _subtrace_, cast);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TCast") + stringRepForEnv(G) + " |- " + stringRep(cast) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTCast) {
    	typeThrowException(ruleName("TCast") + stringRepForEnv(G) + " |- " + stringRep(cast) + " : " + "ClassType",
    		TCAST,
    		e_applyRuleTCast, cast, new ErrorInformation[] {new ErrorInformation(cast)});
    	return null;
    }
  }
  
  @Override
  protected Result<Type> applyRuleTCast(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTCast_1(G, cast));
  }
  
  private ClassType _applyRuleTCast_1(final RuleEnvironment G, final Cast cast) throws RuleFailedException {
    ClassType _type = cast.getType();
    return _type;
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Constant _const) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckConstant(G, _subtrace_, _const);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckConstant") + stringRepForEnv(G) + " |- " + stringRep(_const);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckConstant) {
    	checkThrowException(ruleName("CheckConstant") + stringRepForEnv(G) + " |- " + stringRep(_const),
    		CHECKCONSTANT,
    		e_applyRuleCheckConstant, _const, new ErrorInformation[] {new ErrorInformation(_const)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckConstant(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Constant _const) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypedElement typedElement) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckTypedElement(G, _subtrace_, typedElement);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckTypedElement") + stringRepForEnv(G) + " |- " + stringRep(typedElement);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckTypedElement) {
    	checkThrowException(ruleName("CheckTypedElement") + stringRepForEnv(G) + " |- " + stringRep(typedElement),
    		CHECKTYPEDELEMENT,
    		e_applyRuleCheckTypedElement, typedElement, new ErrorInformation[] {new ErrorInformation(typedElement)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckTypedElement(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypedElement typedElement) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckParamRef(G, _subtrace_, paramref);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckParamRef) {
    	checkThrowException(ruleName("CheckParamRef") + stringRepForEnv(G) + " |- " + stringRep(paramref),
    		CHECKPARAMREF,
    		e_applyRuleCheckParamRef, paramref, new ErrorInformation[] {new ErrorInformation(paramref)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckParamRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ParamRef paramref) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckThis(G, _subtrace_, _this);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckThis") + stringRepForEnv(G) + " |- " + stringRep(_this);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckThis) {
    	checkThrowException(ruleName("CheckThis") + stringRepForEnv(G) + " |- " + stringRep(_this),
    		CHECKTHIS,
    		e_applyRuleCheckThis, _this, new ErrorInformation[] {new ErrorInformation(_this)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckThis(final RuleEnvironment G, final RuleApplicationTrace _trace_, final This _this) throws RuleFailedException {
    ClassType _env = this.<ClassType>env(G, "this", ClassType.class);
    /* env(G, 'this', ClassType) !== null */
    if (!(_env != null)) {
      sneakyThrowRuleFailedException("env(G, \'this\', ClassType) !== null");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckMethod(G, _subtrace_, method);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckMethod") + stringRepForEnv(G) + " |- " + stringRep(method);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckMethod) {
    	checkThrowException(ruleName("CheckMethod") + stringRepForEnv(G) + " |- " + stringRep(method),
    		CHECKMETHOD,
    		e_applyRuleCheckMethod, method, new ErrorInformation[] {new ErrorInformation(method)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckMethod(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Method method) throws RuleFailedException {
    final ClassType typeForThis = this.getFjTypeUtils().createClassType(
      EcoreUtil2.<org.eclipse.xsemantics.example.fj.fj.Class>getContainerOfType(method, org.eclipse.xsemantics.example.fj.fj.Class.class));
    Type bodyType = null;
    /* G, 'this' <- typeForThis |- method.body.expression : bodyType */
    Expression _expression = method.getBody().getExpression();
    Result<Type> result = typeInternal(environmentComposition(
      G, environmentEntry("this", typeForThis)
    ), _trace_, _expression);
    checkAssignableTo(result.getFirst(), Type.class);
    bodyType = (Type) result.getFirst();
    
    /* G |- bodyType <: method.type */
    Type _type = method.getType();
    subtypeInternal(G, _trace_, bodyType, _type);
    /* G, 'this' <- typeForThis |- method.body.expression */
    Expression _expression_1 = method.getBody().getExpression();
    checkInternal(environmentComposition(
      G, environmentEntry("this", typeForThis)
    ), _trace_, _expression_1);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckNew(G, _subtrace_, newExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckNew") + stringRepForEnv(G) + " |- " + stringRep(newExp);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckNew) {
    	checkThrowException(ruleName("CheckNew") + stringRepForEnv(G) + " |- " + stringRep(newExp),
    		CHECKNEW,
    		e_applyRuleCheckNew, newExp, new ErrorInformation[] {new ErrorInformation(newExp)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckNew(final RuleEnvironment G, final RuleApplicationTrace _trace_, final New newExp) throws RuleFailedException {
    List<Field> fields = this.fjAux.getFields(newExp.getType().getClassref());
    /* G |- newExp ~> newExp.args << fields */
    EList<Expression> _args = newExp.getArgs();
    subtypesequenceInternal(G, _trace_, newExp, _args, fields);
    final Consumer<Expression> _function = new Consumer<Expression>() {
      public void accept(final Expression it) {
        /* G |- it */
        checkInternal(G, _trace_, it);
      }
    };
    newExp.getArgs().forEach(_function);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckSelection(G, _subtrace_, selection);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckSelection") + stringRepForEnv(G) + " |- " + stringRep(selection);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckSelection) {
    	checkThrowException(ruleName("CheckSelection") + stringRepForEnv(G) + " |- " + stringRep(selection),
    		CHECKSELECTION,
    		e_applyRuleCheckSelection, selection, new ErrorInformation[] {new ErrorInformation(selection)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckSelection(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    /* G |- selection.receiver */
    Expression _receiver = selection.getReceiver();
    checkInternal(G, _trace_, _receiver);
    final Member message = selection.getMessage();
    boolean _matched = false;
    if (message instanceof Method) {
      _matched=true;
      /* G |- selection ~> selection.args << message.params */
      EList<Expression> _args = selection.getArgs();
      EList<Parameter> _params = ((Method)message).getParams();
      subtypesequenceInternal(G, _trace_, selection, _args, _params);
      EList<Expression> _args_1 = selection.getArgs();
      for (final Expression arg : _args_1) {
        /* G |- arg */
        checkInternal(G, _trace_, arg);
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckCast(G, _subtrace_, cast);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckCast") + stringRepForEnv(G) + " |- " + stringRep(cast);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckCast) {
    	checkThrowException(ruleName("CheckCast") + stringRepForEnv(G) + " |- " + stringRep(cast),
    		CHECKCAST,
    		e_applyRuleCheckCast, cast, new ErrorInformation[] {new ErrorInformation(cast)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckCast(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Cast cast) throws RuleFailedException {
    Type expType = null;
    /* G |- cast.expression : expType */
    Expression _expression = cast.getExpression();
    Result<Type> result = typeInternal(G, _trace_, _expression);
    checkAssignableTo(result.getFirst(), Type.class);
    expType = (Type) result.getFirst();
    
    /* G |- cast.type <: expType or G |- expType <: cast.type */
    {
      RuleFailedException previousFailure = null;
      try {
        /* G |- cast.type <: expType */
        ClassType _type = cast.getType();
        subtypeInternal(G, _trace_, _type, expType);
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* G |- expType <: cast.type */
        ClassType _type_1 = cast.getType();
        subtypeInternal(G, _trace_, expType, _type_1);
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> checkImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCheckClass(G, _subtrace_, cl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CheckClass") + stringRepForEnv(G) + " |- " + stringRep(cl);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCheckClass) {
    	checkThrowException(ruleName("CheckClass") + stringRepForEnv(G) + " |- " + stringRep(cl),
    		CHECKCLASS,
    		e_applyRuleCheckClass, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCheckClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    final Consumer<Member> _function = new Consumer<Member>() {
      public void accept(final Member it) {
        /* G |- it */
        checkInternal(G, _trace_, it);
      }
    };
    cl.getMembers().forEach(_function);
    org.eclipse.xsemantics.example.fj.fj.Class _superclass = cl.getSuperclass();
    boolean _tripleNotEquals = (_superclass != null);
    if (_tripleNotEquals) {
      List<Field> inheritedFields = this.<Field>getAll(
        cl.getSuperclass(), 
        FjPackage.eINSTANCE.getClass_Members(), 
        FjPackage.eINSTANCE.getClass_Superclass(), 
        Field.class);
      final Consumer<Field> _function_1 = new Consumer<Field>() {
        public void accept(final Field inheritedField) {
          List<Field> _selectFields = FjSepTypeSystem.this.fjAux.selectFields(cl);
          for (final Field field : _selectFields) {
            String _name = field.getName();
            String _name_1 = inheritedField.getName();
            /* field.name != inheritedField.name */
            if (!(!Objects.equal(_name, _name_1))) {
              sneakyThrowRuleFailedException("field.name != inheritedField.name");
            }
          }
        }
      };
      inheritedFields.forEach(_function_1);
      List<Method> inheritedMethods = this.<Method>getAll(
        cl.getSuperclass(), 
        FjPackage.eINSTANCE.getClass_Members(), 
        FjPackage.eINSTANCE.getClass_Superclass(), 
        Method.class);
      final Consumer<Method> _function_2 = new Consumer<Method>() {
        public void accept(final Method inheritedMethod) {
          final Consumer<Method> _function = new Consumer<Method>() {
            public void accept(final Method it) {
              FjSepTypeSystem.this.overridesInternal(_trace_, it, inheritedMethod);
            }
          };
          FjSepTypeSystem.this.fjAux.selectMethods(cl).forEach(_function);
        }
      };
      inheritedMethods.forEach(_function_2);
    }
    return new Result<Boolean>(true);
  }
}
