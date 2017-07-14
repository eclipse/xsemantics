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
package it.xsemantics.test.orexpressions.ecore;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * some particular cases
 */
@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECT = "it.xsemantics.test.orexpressions.ecore.EClassEObject";
  
  public final static String ECLASSEOBJECT2 = "it.xsemantics.test.orexpressions.ecore.EClassEObject2";
  
  private PolymorphicDispatcher<Result<EObject>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<EObject>> type2Dispatcher;
  
  public TypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    type2Dispatcher = buildPolymorphicDispatcher1(
    	"type2Impl", 3, "||-", ":");
  }
  
  public Result<EObject> type(final EClass c) {
    return type(new RuleEnvironment(), null, c);
  }
  
  public Result<EObject> type(final RuleEnvironment _environment_, final EClass c) {
    return type(_environment_, null, c);
  }
  
  public Result<EObject> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Result<EObject> type2(final EClass c) {
    return type2(new RuleEnvironment(), null, c);
  }
  
  public Result<EObject> type2(final RuleEnvironment _environment_, final EClass c) {
    return type2(_environment_, null, c);
  }
  
  public Result<EObject> type2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return type2Internal(_environment_, _trace_, c);
    } catch (Exception _e_type2) {
    	return resultForFailure(_e_type2);
    }
  }
  
  protected Result<EObject> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	checkParamsNotNull(c);
    	return typeDispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EClass c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<EObject> type2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	checkParamsNotNull(c);
    	return type2Dispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type2) {
    	sneakyThrowRuleFailedException(_e_type2);
    	return null;
    }
  }
  
  protected void type2ThrowException(final String _error, final String _issue, final Exception _ex, final EClass c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<EObject> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EObject> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEClassEObject) {
    	typeThrowException(ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + "EObject",
    		ECLASSEOBJECT,
    		e_applyRuleEClassEObject, eClass, new ErrorInformation[] {new ErrorInformation(eClass)});
    	return null;
    }
  }
  
  protected Result<EObject> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    EObject object = null; // output parameter
    /* eClass.name == 'foo' or object.eClass.name == 'bar' */
    {
      RuleFailedException previousFailure = null;
      try {
        String _name = eClass.getName();
        boolean _equals = Objects.equal(_name, "foo");
        /* eClass.name == 'foo' */
        if (!_equals) {
          sneakyThrowRuleFailedException("eClass.name == \'foo\'");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        String _name_1 = object.eClass().getName();
        boolean _equals_1 = Objects.equal(_name_1, "bar");
        /* object.eClass.name == 'bar' */
        if (!_equals_1) {
          sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
        }
      }
    }
    return new Result<EObject>(object);
  }
  
  protected Result<EObject> type2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EObject> _result_ = applyRuleEClassEObject2(G, _subtrace_, eClass);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EClassEObject2") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEClassEObject2) {
    	type2ThrowException(ruleName("EClassEObject2") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + "EObject",
    		ECLASSEOBJECT2,
    		e_applyRuleEClassEObject2, eClass, new ErrorInformation[] {new ErrorInformation(eClass)});
    	return null;
    }
  }
  
  protected Result<EObject> applyRuleEClassEObject2(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    EObject object = null; // output parameter
    /* eClass.name == 'foo' or object.eClass.name == 'bar' or { val foo = 'foo' object.eClass.name == 'bar2' eClass.name == foo } */
    {
      RuleFailedException previousFailure = null;
      try {
        String _name = eClass.getName();
        boolean _equals = Objects.equal(_name, "foo");
        /* eClass.name == 'foo' */
        if (!_equals) {
          sneakyThrowRuleFailedException("eClass.name == \'foo\'");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* object.eClass.name == 'bar' or { val foo = 'foo' object.eClass.name == 'bar2' eClass.name == foo } */
        {
          try {
            String _name_1 = object.eClass().getName();
            boolean _equals_1 = Objects.equal(_name_1, "bar");
            /* object.eClass.name == 'bar' */
            if (!_equals_1) {
              sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
            }
          } catch (Exception e_1) {
            previousFailure = extractRuleFailedException(e_1);
            final String foo = "foo";
            String _name_2 = object.eClass().getName();
            boolean _equals_2 = Objects.equal(_name_2, "bar2");
            /* object.eClass.name == 'bar2' */
            if (!_equals_2) {
              sneakyThrowRuleFailedException("object.eClass.name == \'bar2\'");
            }
            String _name_3 = eClass.getName();
            /* eClass.name == foo */
            if (!Objects.equal(_name_3, foo)) {
              sneakyThrowRuleFailedException("eClass.name == foo");
            }
          }
        }
      }
    }
    return new Result<EObject>(object);
  }
}
