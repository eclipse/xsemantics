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
package org.eclipse.xsemantics.example.fjcached.typing;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.example.fj.fj.BasicType;
import org.eclipse.xsemantics.example.fj.fj.ClassType;
import org.eclipse.xsemantics.example.fj.fj.Expression;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.example.fj.fj.Type;
import org.eclipse.xsemantics.example.fj.typing.FjTypeSystem;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * A version of the FJ system where caching is used.
 */
@SuppressWarnings("all")
public class FjCachedTypeSystem extends FjTypeSystem {
  public static final String SUPERCLASSES = "org.eclipse.xsemantics.example.fjcached.typing.Superclasses";
  
  public static final String FIELDS = "org.eclipse.xsemantics.example.fjcached.typing.Fields";
  
  public static final String METHODS = "org.eclipse.xsemantics.example.fjcached.typing.Methods";
  
  public static final String CLASSSUBTYPING = "org.eclipse.xsemantics.example.fjcached.typing.ClassSubtyping";
  
  public static final String SUBCLASSING = "org.eclipse.xsemantics.example.fjcached.typing.Subclassing";
  
  private PolymorphicDispatcher<List<org.eclipse.xsemantics.example.fj.fj.Class>> superclassesDispatcher;
  
  private PolymorphicDispatcher<List<Field>> fieldsDispatcher;
  
  private PolymorphicDispatcher<List<Method>> methodsDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subclassDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;
  
  public FjCachedTypeSystem() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    subclassDispatcher = buildPolymorphicDispatcher1(
    	"subclassImpl", 4, "||-", "<:");
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
    superclassesDispatcher = buildPolymorphicDispatcher(
    	"superclassesImpl", 2);
    fieldsDispatcher = buildPolymorphicDispatcher(
    	"fieldsImpl", 2);
    methodsDispatcher = buildPolymorphicDispatcher(
    	"methodsImpl", 2);
  }
  
  @Override
  public List<org.eclipse.xsemantics.example.fj.fj.Class> superclasses(final org.eclipse.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return superclasses(null, cl);
  }
  
  @Override
  public List<org.eclipse.xsemantics.example.fj.fj.Class> superclasses(final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return superclassesInternal(_trace_, cl);
    } catch (Exception _e_superclasses) {
    	throw extractRuleFailedException(_e_superclasses);
    }
  }
  
  @Override
  public List<Field> fields(final org.eclipse.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return fields(null, cl);
  }
  
  @Override
  public List<Field> fields(final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return fieldsInternal(_trace_, cl);
    } catch (Exception _e_fields) {
    	throw extractRuleFailedException(_e_fields);
    }
  }
  
  @Override
  public List<Method> methods(final org.eclipse.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return methods(null, cl);
  }
  
  @Override
  public List<Method> methods(final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return methodsInternal(_trace_, cl);
    } catch (Exception _e_methods) {
    	throw extractRuleFailedException(_e_methods);
    }
  }
  
  public Result<Boolean> subclass(final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right) {
    return subclass(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> subclass(final RuleEnvironment _environment_, final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right) {
    return subclass(_environment_, null, left, right);
  }
  
  public Result<Boolean> subclass(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right) {
    return getFromCache("subclass", _environment_, _trace_,
    	new XsemanticsProvider<Result<Boolean>>(_environment_, _trace_) {
    		public Result<Boolean> doGet() {
    			try {
    				return subclassInternal(_environment_, _trace_, left, right);
    			} catch (Exception _e_subclass) {
    				return resultForFailure(_e_subclass);
    			}
    		}
    	}, left, right);
  }
  
  public Boolean subclassSucceeded(final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right) {
    return subclassSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean subclassSucceeded(final RuleEnvironment _environment_, final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right) {
    return subclassSucceeded(_environment_, null, left, right);
  }
  
  public Boolean subclassSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right) {
    try {
    	subclassInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_subclass) {
    	return false;
    }
  }
  
  @Override
  public Result<Type> type(final Expression expression) {
    return type(new RuleEnvironment(), null, expression);
  }
  
  @Override
  public Result<Type> type(final RuleEnvironment _environment_, final Expression expression) {
    return type(_environment_, null, expression);
  }
  
  @Override
  public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    return getFromCache("type", _environment_, _trace_,
    	new XsemanticsProvider<Result<Type>>(_environment_, _trace_) {
    		public Result<Type> doGet() {
    			try {
    				return typeInternal(_environment_, _trace_, expression);
    			} catch (Exception _e_type) {
    				return resultForFailure(_e_type);
    			}
    		}
    	}, expression);
  }
  
  @Override
  public Result<Boolean> subtype(final Type left, final Type right) {
    return subtype(new RuleEnvironment(), null, left, right);
  }
  
  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtype(_environment_, null, left, right);
  }
  
  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    if (!subtypeCacheCondition(_environment_, left, right))
    	try {
    		return subtypeInternal(_environment_, _trace_, left, right);
    	} catch (Exception _e_subtype) {
    		return resultForFailure(_e_subtype);
    	}
    return getFromCache("subtype", _environment_, _trace_,
    	new XsemanticsProvider<Result<Boolean>>(_environment_, _trace_) {
    		public Result<Boolean> doGet() {
    			try {
    				return subtypeInternal(_environment_, _trace_, left, right);
    			} catch (Exception _e_subtype) {
    				return resultForFailure(_e_subtype);
    			}
    		}
    	}, left, right);
  }
  
  @Override
  public Boolean subtypeSucceeded(final Type left, final Type right) {
    return subtypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return subtypeSucceeded(_environment_, null, left, right);
  }
  
  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	subtypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
    }
  }
  
  @Override
  protected List<org.eclipse.xsemantics.example.fj.fj.Class> superclassesInternal(final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("superclassesInternal", (RuleEnvironment)null, _trace_,
    	new XsemanticsProvider<List<org.eclipse.xsemantics.example.fj.fj.Class>>(null, _trace_) {
    		public List<org.eclipse.xsemantics.example.fj.fj.Class> doGet() {
    			try {
    				checkParamsNotNull(cl);
    				return superclassesDispatcher.invoke(_trace_, cl);
    			} catch (Exception _e_superclasses) {
    				sneakyThrowRuleFailedException(_e_superclasses);
    				return null;
    			}
    		}
    	}, cl);
  }
  
  protected void superclassesThrowException(final String _error, final String _issue, final Exception _ex, final org.eclipse.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  @Override
  protected List<Field> fieldsInternal(final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("fieldsInternal", (RuleEnvironment)null, _trace_,
    	new XsemanticsProvider<List<Field>>(null, _trace_) {
    		public List<Field> doGet() {
    			try {
    				checkParamsNotNull(cl);
    				return fieldsDispatcher.invoke(_trace_, cl);
    			} catch (Exception _e_fields) {
    				sneakyThrowRuleFailedException(_e_fields);
    				return null;
    			}
    		}
    	}, cl);
  }
  
  protected void fieldsThrowException(final String _error, final String _issue, final Exception _ex, final org.eclipse.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  @Override
  protected List<Method> methodsInternal(final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("methodsInternal", (RuleEnvironment)null, _trace_,
    	new XsemanticsProvider<List<Method>>(null, _trace_) {
    		public List<Method> doGet() {
    			try {
    				checkParamsNotNull(cl);
    				return methodsDispatcher.invoke(_trace_, cl);
    			} catch (Exception _e_methods) {
    				sneakyThrowRuleFailedException(_e_methods);
    				return null;
    			}
    		}
    	}, cl);
  }
  
  protected void methodsThrowException(final String _error, final String _issue, final Exception _ex, final org.eclipse.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> subclassInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right) {
    return getFromCache("subclassInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<Boolean>>(_environment_, _trace_) {
    		public Result<Boolean> doGet() {
    			try {
    				checkParamsNotNull(left, right);
    				return subclassDispatcher.invoke(_environment_, _trace_, left, right);
    			} catch (Exception _e_subclass) {
    				sneakyThrowRuleFailedException(_e_subclass);
    				return null;
    			}
    		}
    	}, left, right);
  }
  
  protected void subclassThrowException(final String _error, final String _issue, final Exception _ex, final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " is not a subclass of ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
  
  @Override
  protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    return getFromCache("typeInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<Type>>(_environment_, _trace_) {
    		public Result<Type> doGet() {
    			try {
    				checkParamsNotNull(expression);
    				return typeDispatcher.invoke(_environment_, _trace_, expression);
    			} catch (Exception _e_type) {
    				sneakyThrowRuleFailedException(_e_type);
    				return null;
    			}
    		}
    	}, expression);
  }
  
  @Override
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(expression);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    EObject source = expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  @Override
  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    if (!subtypeCacheCondition(_environment_, left, right))
    	try {
    		checkParamsNotNull(left, right);
    		return subtypeDispatcher.invoke(_environment_, _trace_, left, right);
    	} catch (Exception _e_subtype) {
    		sneakyThrowRuleFailedException(_e_subtype);
    		return null;
    	}
    return getFromCache("subtypeInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<Boolean>>(_environment_, _trace_) {
    		public Result<Boolean> doGet() {
    			try {
    				checkParamsNotNull(left, right);
    				return subtypeDispatcher.invoke(_environment_, _trace_, left, right);
    			} catch (Exception _e_subtype) {
    				sneakyThrowRuleFailedException(_e_subtype);
    				return null;
    			}
    		}
    	}, left, right);
  }
  
  @Override
  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " is not a subtype of ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
  
  protected Boolean subtypeCacheCondition(final RuleEnvironment environment, final Type left, final Type right) {
    return Boolean.valueOf(((left instanceof BasicType) && (right instanceof BasicType)));
  }
  
  @Override
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleClassSubtyping(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ClassSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleClassSubtyping) {
    	subtypeThrowException(ruleName("ClassSubtyping") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		CLASSSUBTYPING,
    		e_applyRuleClassSubtyping, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  @Override
  protected Result<Boolean> applyRuleClassSubtyping(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    /* G ||- left.classref <: right.classref */
    org.eclipse.xsemantics.example.fj.fj.Class _classref = left.getClassref();
    org.eclipse.xsemantics.example.fj.fj.Class _classref_1 = right.getClassref();
    subclassInternal(G, _trace_, _classref, _classref_1);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subclassImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSubclassing(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Subclassing") + stringRepForEnv(G) + " ||- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubclassing) {
    	subclassThrowException(ruleName("Subclassing") + stringRepForEnv(G) + " ||- " + stringRep(left) + " <: " + stringRep(right),
    		SUBCLASSING,
    		e_applyRuleSubclassing, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSubclassing(final RuleEnvironment G, final RuleApplicationTrace _trace_, final org.eclipse.xsemantics.example.fj.fj.Class left, final org.eclipse.xsemantics.example.fj.fj.Class right) throws RuleFailedException {
    /* left == right or right.name == "Object" or { superclasses(left).contains(right) } */
    {
      RuleFailedException previousFailure = null;
      try {
        boolean _equals = Objects.equal(left, right);
        /* left == right */
        if (!_equals) {
          sneakyThrowRuleFailedException("left == right");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* right.name == "Object" or { superclasses(left).contains(right) } */
        {
          try {
            String _name = right.getName();
            boolean _equals_1 = Objects.equal(_name, "Object");
            /* right.name == "Object" */
            if (!_equals_1) {
              sneakyThrowRuleFailedException("right.name == \"Object\"");
            }
          } catch (Exception e_1) {
            previousFailure = extractRuleFailedException(e_1);
            /* superclasses(left).contains(right) */
            if (!this.superclassesInternal(_trace_, left).contains(right)) {
              sneakyThrowRuleFailedException("superclasses(left).contains(right)");
            }
          }
        }
      }
    }
    return new Result<Boolean>(true);
  }
}
