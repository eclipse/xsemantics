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
package it.xsemantics.test.ruleinvocation.ecore;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.Result2;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECT = "it.xsemantics.test.ruleinvocation.ecore.EClassEObject";
  
  public final static String ECLASSECLASS = "it.xsemantics.test.ruleinvocation.ecore.EClassEClass";
  
  public final static String EOBJECTECLASS = "it.xsemantics.test.ruleinvocation.ecore.EObjectEClass";
  
  public final static String EOBJECTECLASS2 = "it.xsemantics.test.ruleinvocation.ecore.EObjectEClass2";
  
  public final static String EOBJECTECLASSESTRUCTURALFEATURE = "it.xsemantics.test.ruleinvocation.ecore.EObjectEClassEStructuralFeature";
  
  public final static String WITHVARDECLASOUTPUTARG = "it.xsemantics.test.ruleinvocation.ecore.WithVarDeclAsOutputArg";
  
  private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<EClass>> etypeDispatcher;
  
  private PolymorphicDispatcher<Result<EClass>> etype2Dispatcher;
  
  private PolymorphicDispatcher<Result2<EClass, EStructuralFeature>> etype3Dispatcher;
  
  private PolymorphicDispatcher<Result<EClass>> etypeWithVarDeclAsOutputArgDispatcher;
  
  public TypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 4, "|-", ":");
    etypeDispatcher = buildPolymorphicDispatcher1(
    	"etypeImpl", 3, "||-", ":");
    etype2Dispatcher = buildPolymorphicDispatcher1(
    	"etype2Impl", 3, "|~", ":");
    etype3Dispatcher = buildPolymorphicDispatcher2(
    	"etype3Impl", 3, "|~", ":", ":");
    etypeWithVarDeclAsOutputArgDispatcher = buildPolymorphicDispatcher1(
    	"etypeWithVarDeclAsOutputArgImpl", 3, "||~", ":");
  }
  
  public Result<Boolean> type(final EClass c1, final EObject o1) {
    return type(new RuleEnvironment(), null, c1, o1);
  }
  
  public Result<Boolean> type(final RuleEnvironment _environment_, final EClass c1, final EObject o1) {
    return type(_environment_, null, c1, o1);
  }
  
  public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c1, final EObject o1) {
    try {
    	return typeInternal(_environment_, _trace_, c1, o1);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Boolean typeSucceeded(final EClass c1, final EObject o1) {
    return typeSucceeded(new RuleEnvironment(), null, c1, o1);
  }
  
  public Boolean typeSucceeded(final RuleEnvironment _environment_, final EClass c1, final EObject o1) {
    return typeSucceeded(_environment_, null, c1, o1);
  }
  
  public Boolean typeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c1, final EObject o1) {
    try {
    	typeInternal(_environment_, _trace_, c1, o1);
    	return true;
    } catch (Exception _e_type) {
    	return false;
    }
  }
  
  public Result<EClass> etype(final EObject o2) {
    return etype(new RuleEnvironment(), null, o2);
  }
  
  public Result<EClass> etype(final RuleEnvironment _environment_, final EObject o2) {
    return etype(_environment_, null, o2);
  }
  
  public Result<EClass> etype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o2) {
    try {
    	return etypeInternal(_environment_, _trace_, o2);
    } catch (Exception _e_etype) {
    	return resultForFailure(_e_etype);
    }
  }
  
  public Result<EClass> etype2(final EObject o3) {
    return etype2(new RuleEnvironment(), null, o3);
  }
  
  public Result<EClass> etype2(final RuleEnvironment _environment_, final EObject o3) {
    return etype2(_environment_, null, o3);
  }
  
  public Result<EClass> etype2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o3) {
    try {
    	return etype2Internal(_environment_, _trace_, o3);
    } catch (Exception _e_etype2) {
    	return resultForFailure(_e_etype2);
    }
  }
  
  public Result2<EClass, EStructuralFeature> etype3(final EObject o4) {
    return etype3(new RuleEnvironment(), null, o4);
  }
  
  public Result2<EClass, EStructuralFeature> etype3(final RuleEnvironment _environment_, final EObject o4) {
    return etype3(_environment_, null, o4);
  }
  
  public Result2<EClass, EStructuralFeature> etype3(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o4) {
    try {
    	return etype3Internal(_environment_, _trace_, o4);
    } catch (Exception _e_etype3) {
    	return resultForFailure2(_e_etype3);
    }
  }
  
  public Result<EClass> etypeWithVarDeclAsOutputArg(final EObject o) {
    return etypeWithVarDeclAsOutputArg(new RuleEnvironment(), null, o);
  }
  
  public Result<EClass> etypeWithVarDeclAsOutputArg(final RuleEnvironment _environment_, final EObject o) {
    return etypeWithVarDeclAsOutputArg(_environment_, null, o);
  }
  
  public Result<EClass> etypeWithVarDeclAsOutputArg(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return etypeWithVarDeclAsOutputArgInternal(_environment_, _trace_, o);
    } catch (Exception _e_etypeWithVarDeclAsOutputArg) {
    	return resultForFailure(_e_etypeWithVarDeclAsOutputArg);
    }
  }
  
  protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c1, final EObject o1) {
    try {
    	checkParamsNotNull(c1, o1);
    	return typeDispatcher.invoke(_environment_, _trace_, c1, o1);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EClass c1, final EObject o1, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<EClass> etypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o2) {
    try {
    	checkParamsNotNull(o2);
    	return etypeDispatcher.invoke(_environment_, _trace_, o2);
    } catch (Exception _e_etype) {
    	sneakyThrowRuleFailedException(_e_etype);
    	return null;
    }
  }
  
  protected void etypeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o2, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<EClass> etype2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o3) {
    try {
    	checkParamsNotNull(o3);
    	return etype2Dispatcher.invoke(_environment_, _trace_, o3);
    } catch (Exception _e_etype2) {
    	sneakyThrowRuleFailedException(_e_etype2);
    	return null;
    }
  }
  
  protected void etype2ThrowException(final String _error, final String _issue, final Exception _ex, final EObject o3, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result2<EClass, EStructuralFeature> etype3Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o4) {
    try {
    	checkParamsNotNull(o4);
    	return etype3Dispatcher.invoke(_environment_, _trace_, o4);
    } catch (Exception _e_etype3) {
    	sneakyThrowRuleFailedException(_e_etype3);
    	return null;
    }
  }
  
  protected void etype3ThrowException(final String _error, final String _issue, final Exception _ex, final EObject o4, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<EClass> etypeWithVarDeclAsOutputArgInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return etypeWithVarDeclAsOutputArgDispatcher.invoke(_environment_, _trace_, o);
    } catch (Exception _e_etypeWithVarDeclAsOutputArg) {
    	sneakyThrowRuleFailedException(_e_etypeWithVarDeclAsOutputArg);
    	return null;
    }
  }
  
  protected void etypeWithVarDeclAsOutputArgThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
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
    EClass eClassResult = null;
    /* G ||- object : eClassResult */
    Result<EClass> result = etypeInternal(G, _trace_, object);
    checkAssignableTo(result.getFirst(), EClass.class);
    eClassResult = (EClass) result.getFirst();
    
    /* G |- eClass : object.eClass */
    EClass _eClass = object.eClass();
    typeInternal(G, _trace_, eClass, _eClass);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass1, final EClass eClass2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleEClassEClass(G, _subtrace_, eClass1, eClass2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EClassEClass") + stringRepForEnv(G) + " |- " + stringRep(eClass1) + " : " + stringRep(eClass2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEClassEClass) {
    	typeThrowException(ruleName("EClassEClass") + stringRepForEnv(G) + " |- " + stringRep(eClass1) + " : " + stringRep(eClass2),
    		ECLASSECLASS,
    		e_applyRuleEClassEClass, eClass1, eClass2, new ErrorInformation[] {new ErrorInformation(eClass1), new ErrorInformation(eClass2)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleEClassEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass1, final EClass eClass2) throws RuleFailedException {
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
    /* eClass1 == eC */
    if (!Objects.equal(eClass1, eC)) {
      sneakyThrowRuleFailedException("eClass1 == eC");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<EClass> etypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject eObject) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, eObject);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " ||- " + stringRep(eObject) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	etypeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " ||- " + stringRep(eObject) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, eObject, new ErrorInformation[] {new ErrorInformation(eObject)});
    	return null;
    }
  }
  
  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject eObject) throws RuleFailedException {
    
    return new Result<EClass>(_applyRuleEObjectEClass_1(G, eObject));
  }
  
  private EClass _applyRuleEObjectEClass_1(final RuleEnvironment G, final EObject eObject) throws RuleFailedException {
    EClass _eClass = eObject.eClass();
    return _eClass;
  }
  
  protected Result<EClass> etype2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject eObject) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass2(G, _subtrace_, eObject);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass2") + stringRepForEnv(G) + " |~ " + stringRep(eObject) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass2) {
    	etype2ThrowException(ruleName("EObjectEClass2") + stringRepForEnv(G) + " |~ " + stringRep(eObject) + " : " + "EClass",
    		EOBJECTECLASS2,
    		e_applyRuleEObjectEClass2, eObject, new ErrorInformation[] {new ErrorInformation(eObject)});
    	return null;
    }
  }
  
  protected Result<EClass> applyRuleEObjectEClass2(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject eObject) throws RuleFailedException {
    EClass eClass = null; // output parameter
    /* G ||- eObject : eClass */
    Result<EClass> result = etypeInternal(G, _trace_, eObject);
    checkAssignableTo(result.getFirst(), EClass.class);
    eClass = (EClass) result.getFirst();
    
    return new Result<EClass>(eClass);
  }
  
  protected Result2<EClass, EStructuralFeature> etype3Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject eObject) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result2<EClass, EStructuralFeature> _result_ = applyRuleEObjectEClassEStructuralFeature(G, _subtrace_, eObject);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClassEStructuralFeature") + stringRepForEnv(G) + " |~ " + stringRep(eObject) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClassEStructuralFeature) {
    	etype3ThrowException(ruleName("EObjectEClassEStructuralFeature") + stringRepForEnv(G) + " |~ " + stringRep(eObject) + " : " + "EClass" + " : " + "EStructuralFeature",
    		EOBJECTECLASSESTRUCTURALFEATURE,
    		e_applyRuleEObjectEClassEStructuralFeature, eObject, new ErrorInformation[] {new ErrorInformation(eObject)});
    	return null;
    }
  }
  
  protected Result2<EClass, EStructuralFeature> applyRuleEObjectEClassEStructuralFeature(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject eObject) throws RuleFailedException {
    EClass eClass = null; // output parameter
    EStructuralFeature feat = null; // output parameter
    /* G |~ eObject : eClass : feat */
    Result2<EClass, EStructuralFeature> result = etype3Internal(G, _trace_, eObject);
    checkAssignableTo(result.getFirst(), EClass.class);
    eClass = (EClass) result.getFirst();
    checkAssignableTo(result.getSecond(), EStructuralFeature.class);
    feat = (EStructuralFeature) result.getSecond();
    
    return new Result2<EClass, EStructuralFeature>(eClass, feat);
  }
  
  protected Result<EClass> etypeWithVarDeclAsOutputArgImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleWithVarDeclAsOutputArg(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("WithVarDeclAsOutputArg") + stringRepForEnv(G) + " ||~ " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleWithVarDeclAsOutputArg) {
    	etypeWithVarDeclAsOutputArgThrowException(ruleName("WithVarDeclAsOutputArg") + stringRepForEnv(G) + " ||~ " + stringRep(o) + " : " + "EClass",
    		WITHVARDECLASOUTPUTARG,
    		e_applyRuleWithVarDeclAsOutputArg, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }
  
  protected Result<EClass> applyRuleWithVarDeclAsOutputArg(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    EClass result = null; // output parameter
    /* G ||- o : var EClass temp */
    EClass temp = null;
    Result<EClass> result_1 = etypeInternal(G, _trace_, o);
    checkAssignableTo(result_1.getFirst(), EClass.class);
    temp = (EClass) result_1.getFirst();
    
    result = temp;
    return new Result<EClass>(result);
  }
}
