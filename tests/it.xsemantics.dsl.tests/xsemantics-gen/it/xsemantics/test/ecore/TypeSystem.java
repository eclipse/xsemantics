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
package it.xsemantics.test.ecore;

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
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECT = "it.xsemantics.test.ecore.EClassEObject";
  
  private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;
  
  public TypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 4, "|-", ":");
  }
  
  public Result<Boolean> type(final EClass c, final EObject o) {
    return type(new RuleEnvironment(), null, c, o);
  }
  
  public Result<Boolean> type(final RuleEnvironment _environment_, final EClass c, final EObject o) {
    return type(_environment_, null, c, o);
  }
  
  public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, c, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Boolean typeSucceeded(final EClass c, final EObject o) {
    return typeSucceeded(new RuleEnvironment(), null, c, o);
  }
  
  public Boolean typeSucceeded(final RuleEnvironment _environment_, final EClass c, final EObject o) {
    return typeSucceeded(_environment_, null, c, o);
  }
  
  public Boolean typeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	typeInternal(_environment_, _trace_, c, o);
    	return true;
    } catch (Exception _e_type) {
    	return false;
    }
  }
  
  protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	checkParamsNotNull(c, o);
    	return typeDispatcher.invoke(_environment_, _trace_, c, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EClass c, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEClassEObject) {
    	typeThrowException(ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object),
    		ECLASSEOBJECT,
    		e_applyRuleEClassEObject, eClass, object, new ErrorInformation[] {new ErrorInformation(eClass), new ErrorInformation(object)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {
    String _string = new String();
    String _firstUpper = StringExtensions.toFirstUpper("bar");
    String _plus = (_string + _firstUpper);
    boolean _equals = Objects.equal("foo", _plus);
    /* 'foo' == new String() + 'bar'.toFirstUpper */
    if (!_equals) {
      sneakyThrowRuleFailedException("\'foo\' == new String() + \'bar\'.toFirstUpper");
    }
    final EClass eC = EcoreFactory.eINSTANCE.createEClass();
    eC.setName("MyEClass");
    /* eClass == eC */
    if (!Objects.equal(eClass, eC)) {
      sneakyThrowRuleFailedException("eClass == eC");
    }
    return new Result<Boolean>(true);
  }
}
