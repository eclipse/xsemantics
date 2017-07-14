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
package it.xsemantics.test.fj.lambda;

import com.google.inject.Inject;
import com.google.inject.Provider;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.test.fj.first.FjFirstTypeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Uses rule invocations as boolean expressions
 */
@SuppressWarnings("all")
public class FjTestsForLambdas extends FjFirstTypeSystem {
  public final static String EXISTSSUBTYPEWITHLAMBDA = "it.xsemantics.test.fj.lambda.ExistsSubtypeWithLambda";
  
  @Inject
  private FjAuxiliaryFunctions fjAux;
  
  private PolymorphicDispatcher<Result<Boolean>> existsSubtypeDispatcher;
  
  public FjTestsForLambdas() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    existsSubtypeDispatcher = buildPolymorphicDispatcher1(
    	"existsSubtypeImpl", 4, "||-", "<<!");
  }
  
  public FjAuxiliaryFunctions getFjAux() {
    return this.fjAux;
  }
  
  public void setFjAux(final FjAuxiliaryFunctions fjAux) {
    this.fjAux = fjAux;
  }
  
  public Result<Boolean> existsSubtype(final Type left, final Type right) {
    return existsSubtype(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> existsSubtype(final RuleEnvironment _environment_, final Type left, final Type right) {
    return existsSubtype(_environment_, null, left, right);
  }
  
  public Result<Boolean> existsSubtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return existsSubtypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_existsSubtype) {
    	return resultForFailure(_e_existsSubtype);
    }
  }
  
  public Boolean existsSubtypeSucceeded(final Type left, final Type right) {
    return existsSubtypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean existsSubtypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return existsSubtypeSucceeded(_environment_, null, left, right);
  }
  
  public Boolean existsSubtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	existsSubtypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_existsSubtype) {
    	return false;
    }
  }
  
  protected Result<Boolean> existsSubtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	checkParamsNotNull(left, right);
    	return existsSubtypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_existsSubtype) {
    	sneakyThrowRuleFailedException(_e_existsSubtype);
    	return null;
    }
  }
  
  protected void existsSubtypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> existsSubtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleExistsSubtypeWithLambda(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ExistsSubtypeWithLambda") + stringRepForEnv(G) + " ||- " + stringRep(left) + " <<! " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleExistsSubtypeWithLambda) {
    	existsSubtypeThrowException(ruleName("ExistsSubtypeWithLambda") + stringRepForEnv(G) + " ||- " + stringRep(left) + " <<! " + stringRep(right),
    		EXISTSSUBTYPEWITHLAMBDA,
    		e_applyRuleExistsSubtypeWithLambda, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleExistsSubtypeWithLambda(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ClassType left, final ClassType right) throws RuleFailedException {
    final Function1<it.xsemantics.example.fj.fj.Class, Boolean> _function = new Function1<it.xsemantics.example.fj.fj.Class, Boolean>() {
      public Boolean apply(final it.xsemantics.example.fj.fj.Class it) {
        /* G |- it <| right.classref */
        it.xsemantics.example.fj.fj.Class _classref = right.getClassref();
        boolean _ruleinvocation = subclassSucceeded(G, _trace_, it, _classref);
        return Boolean.valueOf(_ruleinvocation);
      }
    };
    /* left.classref.superclasses.reverseView.exists[ G |- it <| right.classref ] */
    if (!IterableExtensions.<it.xsemantics.example.fj.fj.Class>exists(ListExtensions.<it.xsemantics.example.fj.fj.Class>reverseView(this.superclassesInternal(_trace_, left.getClassref())), _function)) {
      sneakyThrowRuleFailedException("left.classref.superclasses.reverseView.exists[ G |- it <| right.classref ]");
    }
    return new Result<Boolean>(true);
  }
}
