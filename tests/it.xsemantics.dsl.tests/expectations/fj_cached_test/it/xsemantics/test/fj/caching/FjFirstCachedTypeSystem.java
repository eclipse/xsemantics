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
package it.xsemantics.test.fj.caching;

import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsProvider;
import it.xsemantics.test.fj.first.FjFirstTypeSystem;
import java.util.List;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class FjFirstCachedTypeSystem extends FjFirstTypeSystem {
  public final static String SUPERCLASSES = "it.xsemantics.test.fj.caching.Superclasses";
  
  private PolymorphicDispatcher<List<it.xsemantics.example.fj.fj.Class>> superclassesDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> subclassDispatcher;
  
  private PolymorphicDispatcher<Result<List<Field>>> fieldsDispatcher;
  
  private PolymorphicDispatcher<Result<List<Method>>> methodsDispatcher;
  
  public FjFirstCachedTypeSystem() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    subclassDispatcher = buildPolymorphicDispatcher1(
    	"subclassImpl", 4, "|-", "<|");
    fieldsDispatcher = buildPolymorphicDispatcher1(
    	"fieldsImpl", 3, "||-", ">>");
    methodsDispatcher = buildPolymorphicDispatcher1(
    	"methodsImpl", 3, "||~", ">>");
    superclassesDispatcher = buildPolymorphicDispatcher(
    	"superclassesImpl", 2);
  }
  
  @Override
  public List<it.xsemantics.example.fj.fj.Class> superclasses(final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    return superclasses(null, cl);
  }
  
  @Override
  public List<it.xsemantics.example.fj.fj.Class> superclasses(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) throws RuleFailedException {
    try {
    	return superclassesInternal(_trace_, cl);
    } catch (Exception _e_superclasses) {
    	throw extractRuleFailedException(_e_superclasses);
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
  public Result<Boolean> subclass(final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclass(new RuleEnvironment(), null, candidate, superclass);
  }
  
  @Override
  public Result<Boolean> subclass(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclass(_environment_, null, candidate, superclass);
  }
  
  @Override
  public Result<Boolean> subclass(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return getFromCache("subclass", _environment_, _trace_,
    	new XsemanticsProvider<Result<Boolean>>(_environment_, _trace_) {
    		public Result<Boolean> doGet() {
    			try {
    				return subclassInternal(_environment_, _trace_, candidate, superclass);
    			} catch (Exception _e_subclass) {
    				return resultForFailure(_e_subclass);
    			}
    		}
    	}, candidate, superclass);
  }
  
  @Override
  public Boolean subclassSucceeded(final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclassSucceeded(new RuleEnvironment(), null, candidate, superclass);
  }
  
  @Override
  public Boolean subclassSucceeded(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return subclassSucceeded(_environment_, null, candidate, superclass);
  }
  
  @Override
  public Boolean subclassSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    try {
    	subclassInternal(_environment_, _trace_, candidate, superclass);
    	return true;
    } catch (Exception _e_subclass) {
    	return false;
    }
  }
  
  @Override
  public Result<List<Field>> fields(final it.xsemantics.example.fj.fj.Class cl) {
    return fields(new RuleEnvironment(), null, cl);
  }
  
  @Override
  public Result<List<Field>> fields(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class cl) {
    return fields(_environment_, null, cl);
  }
  
  @Override
  public Result<List<Field>> fields(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("fields", _environment_, _trace_,
    	new XsemanticsProvider<Result<List<Field>>>(_environment_, _trace_) {
    		public Result<List<Field>> doGet() {
    			try {
    				return fieldsInternal(_environment_, _trace_, cl);
    			} catch (Exception _e_fields) {
    				return resultForFailure(_e_fields);
    			}
    		}
    	}, cl);
  }
  
  @Override
  public Result<List<Method>> methods(final it.xsemantics.example.fj.fj.Class cl) {
    return methods(new RuleEnvironment(), null, cl);
  }
  
  @Override
  public Result<List<Method>> methods(final RuleEnvironment _environment_, final it.xsemantics.example.fj.fj.Class cl) {
    return methods(_environment_, null, cl);
  }
  
  @Override
  public Result<List<Method>> methods(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("methods", _environment_, _trace_,
    	new XsemanticsProvider<Result<List<Method>>>(_environment_, _trace_) {
    		public Result<List<Method>> doGet() {
    			try {
    				return methodsInternal(_environment_, _trace_, cl);
    			} catch (Exception _e_methods) {
    				return resultForFailure(_e_methods);
    			}
    		}
    	}, cl);
  }
  
  @Override
  protected List<it.xsemantics.example.fj.fj.Class> superclassesInternal(final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("superclassesInternal", (RuleEnvironment)null, _trace_,
    	new XsemanticsProvider<List<it.xsemantics.example.fj.fj.Class>>(null, _trace_) {
    		public List<it.xsemantics.example.fj.fj.Class> doGet() {
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
  
  protected void superclassesThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
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
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  @Override
  protected Result<Boolean> subclassInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass) {
    return getFromCache("subclassInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<Boolean>>(_environment_, _trace_) {
    		public Result<Boolean> doGet() {
    			try {
    				checkParamsNotNull(candidate, superclass);
    				return subclassDispatcher.invoke(_environment_, _trace_, candidate, superclass);
    			} catch (Exception _e_subclass) {
    				sneakyThrowRuleFailedException(_e_subclass);
    				return null;
    			}
    		}
    	}, candidate, superclass);
  }
  
  @Override
  protected void subclassThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class candidate, final it.xsemantics.example.fj.fj.Class superclass, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  @Override
  protected Result<List<Field>> fieldsInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("fieldsInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<List<Field>>>(_environment_, _trace_) {
    		public Result<List<Field>> doGet() {
    			try {
    				checkParamsNotNull(cl);
    				return fieldsDispatcher.invoke(_environment_, _trace_, cl);
    			} catch (Exception _e_fields) {
    				sneakyThrowRuleFailedException(_e_fields);
    				return null;
    			}
    		}
    	}, cl);
  }
  
  @Override
  protected void fieldsThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  @Override
  protected Result<List<Method>> methodsInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final it.xsemantics.example.fj.fj.Class cl) {
    return getFromCache("methodsInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<List<Method>>>(_environment_, _trace_) {
    		public Result<List<Method>> doGet() {
    			try {
    				checkParamsNotNull(cl);
    				return methodsDispatcher.invoke(_environment_, _trace_, cl);
    			} catch (Exception _e_methods) {
    				sneakyThrowRuleFailedException(_e_methods);
    				return null;
    			}
    		}
    	}, cl);
  }
  
  @Override
  protected void methodsThrowException(final String _error, final String _issue, final Exception _ex, final it.xsemantics.example.fj.fj.Class cl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
}
