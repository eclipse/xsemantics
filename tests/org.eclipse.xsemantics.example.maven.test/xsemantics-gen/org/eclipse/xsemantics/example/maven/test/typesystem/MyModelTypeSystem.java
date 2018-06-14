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
package org.eclipse.xsemantics.example.maven.test.typesystem;

import com.google.inject.Provider;
import org.eclipse.xsemantics.example.maven.test.model.MyModel;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class MyModelTypeSystem extends XsemanticsRuntimeSystem {
  public final static String MYMODELTYPE = "org.eclipse.xsemantics.example.maven.test.typesystem.MyModelType";
  
  private PolymorphicDispatcher<Result<Object>> typeDispatcher;
  
  public MyModelTypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }
  
  public Result<Object> type(final Object expression) {
    return type(new RuleEnvironment(), null, expression);
  }
  
  public Result<Object> type(final RuleEnvironment _environment_, final Object expression) {
    return type(_environment_, null, expression);
  }
  
  public Result<Object> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Object expression) {
    try {
    	return typeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  protected Result<Object> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Object expression) {
    try {
    	checkParamsNotNull(expression);
    	return typeDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final Object expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(expression);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
  
  protected Result<Object> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MyModel model) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleMyModelType(G, _subtrace_, model);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("MyModelType") + stringRepForEnv(G) + " |- " + stringRep(model) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleMyModelType) {
    	typeThrowException(ruleName("MyModelType") + stringRepForEnv(G) + " |- " + stringRep(model) + " : " + "String",
    		MYMODELTYPE,
    		e_applyRuleMyModelType, model, new ErrorInformation[] {});
    	return null;
    }
  }
  
  protected Result<Object> applyRuleMyModelType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MyModel model) throws RuleFailedException {
    
    return new Result<Object>(_applyRuleMyModelType_1(G, model));
  }
  
  private String _applyRuleMyModelType_1(final RuleEnvironment G, final MyModel model) throws RuleFailedException {
    String _type = model.getType();
    return _type;
  }
}
