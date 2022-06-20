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

package org.eclipse.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import org.eclipse.xsemantics.dsl.tests.XsemanticsBaseTest
import org.eclipse.xsemantics.dsl.tests.XsemanticsInjectorProvider
import java.util.List
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsJvmModelGeneratorTest extends XsemanticsBaseTest {

	@Inject extension CompilationTestHelper

	@Inject FileExtensionProvider extensionProvider

	@Rule
	@Inject public TemporaryFolder temporaryFolder

	@Test
	def testJudgmentDescriptions() {
		testFiles.testJudgmentDescriptions.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import java.util.List;
import java.util.Set;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 4, "|-", ":");
  }

  public Result<Boolean> type(final List<String> list, final Set<Integer> set) {
    return type(new RuleEnvironment(), null, list, set);
  }

  public Result<Boolean> type(final RuleEnvironment _environment_, final List<String> list, final Set<Integer> set) {
    return type(_environment_, null, list, set);
  }

  public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final List<String> list, final Set<Integer> set) {
    try {
    	return typeInternal(_environment_, _trace_, list, set);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  public Boolean typeSucceeded(final List<String> list, final Set<Integer> set) {
    return typeSucceeded(new RuleEnvironment(), null, list, set);
  }

  public Boolean typeSucceeded(final RuleEnvironment _environment_, final List<String> list, final Set<Integer> set) {
    return typeSucceeded(_environment_, null, list, set);
  }

  public Boolean typeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final List<String> list, final Set<Integer> set) {
    try {
    	typeInternal(_environment_, _trace_, list, set);
    	return true;
    } catch (Exception _e_type) {
    	return false;
    }
  }

  protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final List<String> list, final Set<Integer> set) {
    try {
    	checkParamsNotNull(list, set);
    	return typeDispatcher.invoke(_environment_, _trace_, list, set);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final List<String> list, final Set<Integer> set, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
}
'''
		)
	}

	@Test
	def typeSystemWithNoPackage() {
		testFiles.typeSystemWithNoPackage.compile[compiledClass]
	}

	@Test
	def typeNoSystem() {
		'''system'''.compile[compiledClass]
	}

	@Test
	def testSimpleRule() {
		testFiles.testSimpleRule.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String ECLASSEOBJECT = "org.eclipse.xsemantics.test.EClassEObject";

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
    /* 'foo' == new String() + "bar".toFirstUpper */
    if (!_equals) {
      sneakyThrowRuleFailedException("\'foo\' == new String() + \"bar\".toFirstUpper");
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
'''
		)
	}

	@Test
	def testRuleWithTwoOutputParams() {
		testFiles.testRuleWithTwoOutputParams.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.Result2;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String ECLASSEOBJECTESTRUCTURALFEATURE = "org.eclipse.xsemantics.test.EClassEObjectEStructuralFeature";

  private PolymorphicDispatcher<Result<EObject>> typeDispatcher;

  private PolymorphicDispatcher<Result2<EObject, EStructuralFeature>> type2Dispatcher;

  private PolymorphicDispatcher<Result<EObject>> subtypeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 4, "|-", ":", ":");
    type2Dispatcher = buildPolymorphicDispatcher2(
    	"type2Impl", 3, "||-", ":", ":");
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "||-", "<:", ":>");
  }

  public Result<EObject> type(final EClass c, final EStructuralFeature f) {
    return type(new RuleEnvironment(), null, c, f);
  }

  public Result<EObject> type(final RuleEnvironment _environment_, final EClass c, final EStructuralFeature f) {
    return type(_environment_, null, c, f);
  }

  public Result<EObject> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {
    try {
    	return typeInternal(_environment_, _trace_, c, f);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  public Result2<EObject, EStructuralFeature> type2(final EClass c) {
    return type2(new RuleEnvironment(), null, c);
  }

  public Result2<EObject, EStructuralFeature> type2(final RuleEnvironment _environment_, final EClass c) {
    return type2(_environment_, null, c);
  }

  public Result2<EObject, EStructuralFeature> type2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return type2Internal(_environment_, _trace_, c);
    } catch (Exception _e_type2) {
    	return resultForFailure2(_e_type2);
    }
  }

  public Result<EObject> subtype(final EClass c, final EStructuralFeature f) {
    return subtype(new RuleEnvironment(), null, c, f);
  }

  public Result<EObject> subtype(final RuleEnvironment _environment_, final EClass c, final EStructuralFeature f) {
    return subtype(_environment_, null, c, f);
  }

  public Result<EObject> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {
    try {
    	return subtypeInternal(_environment_, _trace_, c, f);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }

  protected Result<EObject> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {
    try {
    	checkParamsNotNull(c, f);
    	return typeDispatcher.invoke(_environment_, _trace_, c, f);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EClass c, final EStructuralFeature f, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result2<EObject, EStructuralFeature> type2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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

  protected Result<EObject> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {
    try {
    	checkParamsNotNull(c, f);
    	return subtypeDispatcher.invoke(_environment_, _trace_, c, f);
    } catch (Exception _e_subtype) {
    	sneakyThrowRuleFailedException(_e_subtype);
    	return null;
    }
  }

  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final EClass c, final EStructuralFeature f, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result2<EObject, EStructuralFeature> type2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result2<EObject, EStructuralFeature> _result_ = applyRuleEClassEObjectEStructuralFeature(G, _subtrace_, eClass);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EClassEObjectEStructuralFeature") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEClassEObjectEStructuralFeature) {
    	type2ThrowException(ruleName("EClassEObjectEStructuralFeature") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + "EObject" + " : " + "EStructuralFeature",
    		ECLASSEOBJECTESTRUCTURALFEATURE,
    		e_applyRuleEClassEObjectEStructuralFeature, eClass, new ErrorInformation[] {new ErrorInformation(eClass)});
    	return null;
    }
  }

  protected Result2<EObject, EStructuralFeature> applyRuleEClassEObjectEStructuralFeature(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    EObject object = null; // output parameter
    EStructuralFeature feat = null; // output parameter
    /* G ||- eClass : object : feat */
    Result2<EObject, EStructuralFeature> result = type2Internal(G, _trace_, eClass);
    checkAssignableTo(result.getFirst(), EObject.class);
    object = (EObject) result.getFirst();
    checkAssignableTo(result.getSecond(), EStructuralFeature.class);
    feat = (EStructuralFeature) result.getSecond();
    
    return new Result2<EObject, EStructuralFeature>(object, feat);
  }
}
'''
		)
	}

	@Test
	def testRuleWith3OutputParams() {
		testFiles.testRuleWith3OutputParams.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result3;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String ECLASSEOBJECTESTRUCTURALFEATURESTRING = "org.eclipse.xsemantics.test.EClassEObjectEStructuralFeatureString";

  private PolymorphicDispatcher<Result3<EObject, EStructuralFeature, String>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher3(
    	"typeImpl", 3, "|-", ":", ":", ":");
  }

  public Result3<EObject, EStructuralFeature, String> type(final EClass c) {
    return type(new RuleEnvironment(), null, c);
  }

  public Result3<EObject, EStructuralFeature, String> type(final RuleEnvironment _environment_, final EClass c) {
    return type(_environment_, null, c);
  }

  public Result3<EObject, EStructuralFeature, String> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure3(_e_type);
    }
  }

  protected Result3<EObject, EStructuralFeature, String> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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

  protected Result3<EObject, EStructuralFeature, String> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result3<EObject, EStructuralFeature, String> _result_ = applyRuleEClassEObjectEStructuralFeatureString(G, _subtrace_, eClass);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EClassEObjectEStructuralFeatureString") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond()) + " : " + stringRep(_result_.getThird());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEClassEObjectEStructuralFeatureString) {
    	typeThrowException(ruleName("EClassEObjectEStructuralFeatureString") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + "EObject" + " : " + "EStructuralFeature" + " : " + "String",
    		ECLASSEOBJECTESTRUCTURALFEATURESTRING,
    		e_applyRuleEClassEObjectEStructuralFeatureString, eClass, new ErrorInformation[] {new ErrorInformation(eClass)});
    	return null;
    }
  }

  protected Result3<EObject, EStructuralFeature, String> applyRuleEClassEObjectEStructuralFeatureString(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    EObject object = null; // output parameter
    EStructuralFeature feat = null; // output parameter
    String s = null; // output parameter
    /* G |- eClass : object : feat : s */
    Result3<EObject, EStructuralFeature, String> result = typeInternal(G, _trace_, eClass);
    checkAssignableTo(result.getFirst(), EObject.class);
    object = (EObject) result.getFirst();
    checkAssignableTo(result.getSecond(), EStructuralFeature.class);
    feat = (EStructuralFeature) result.getSecond();
    checkAssignableTo(result.getThird(), String.class);
    s = (String) result.getThird();
    
    return new Result3<EObject, EStructuralFeature, String>(object, feat, s);
  }
}
'''
		)
	}

	@Test
	def testRuleInvocationWithVariableDeclarationAsOutputParameter() {
		testFiles.testDuplicateVariableDeclarationAsOutputArgument.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String EOBJECTECLASS = "org.eclipse.xsemantics.test.EObjectEClass";

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public Result<EClass> type(final EObject c) {
    return type(new RuleEnvironment(), null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject c) {
    return type(_environment_, null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	checkParamsNotNull(c);
    	return typeDispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	typeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    EClass c = null; // output parameter
    /* var temp = c or { G |- o : var EClass temp } */
    {
      RuleFailedException previousFailure = null;
      try {
        EClass temp = c;
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* G |- o : var EClass temp */
        EClass temp_1 = null;
        Result<EClass> result = typeInternal(G, _trace_, o);
        checkAssignableTo(result.getFirst(), EClass.class);
        temp_1 = (EClass) result.getFirst();
        
      }
    }
    return new Result<EClass>(c);
  }
}
'''
		)
	}

	@Test
	def testJudgmentDescriptionsWithErrorSpecification() {
		testFiles.testJudgmentDescriptionsWithErrorSpecification.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public Result<EClass> type(final EObject c) {
    return type(new RuleEnvironment(), null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject c) {
    return type(_environment_, null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	checkParamsNotNull(c);
    	return typeDispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String error = (("this " + c) + " made an error!");
    EObject source = c;
    EStructuralFeature _eContainingFeature = c.eClass().eContainingFeature();
    EStructuralFeature feature = _eContainingFeature;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, feature));
  }
}
'''
		)
	}

	@Test
	def testCheckRule() {
		testFiles.testCheckRule.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String EOBJECTECLASS = "org.eclipse.xsemantics.test.EObjectEClass";

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public Result<EClass> type(final EObject c) {
    return type(new RuleEnvironment(), null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject c) {
    return type(_environment_, null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  public Result<Boolean> checkEObject(final EObject obj) {
    return checkEObject(null, obj);
  }

  public Result<Boolean> checkEObject(final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	return checkEObjectInternal(_trace_, obj);
    } catch (Exception _e_CheckEObject) {
    	return resultForFailure(_e_CheckEObject);
    }
  }

  protected Result<Boolean> checkEObjectInternal(final RuleApplicationTrace _trace_, final EObject obj) throws RuleFailedException {
    EClass result = null;
    /* empty |- obj : result */
    Result<EClass> result_1 = typeInternal(emptyEnvironment(), _trace_, obj);
    checkAssignableTo(result_1.getFirst(), EClass.class);
    result = (EClass) result_1.getFirst();
    
    return new Result<Boolean>(true);
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	checkParamsNotNull(c);
    	return typeDispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject object) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, object);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(object) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	typeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(object) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, object, new ErrorInformation[] {new ErrorInformation(object)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject object) throws RuleFailedException {
    
    return new Result<EClass>(_applyRuleEObjectEClass_1(G, object));
  }

  private EClass _applyRuleEObjectEClass_1(final RuleEnvironment G, final EObject object) throws RuleFailedException {
    EClass _eClass = object.eClass();
    return _eClass;
  }
}
'''
		)
	}

	@Test
	def testValidator() {
		testFiles.testCheckRule.assertCorrectJavaCodeGeneration(
			null,
			'''
package org.eclipse.xsemantics.test.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xsemantics.test.TypeSystem;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

@SuppressWarnings("all")
public class TypeSystemValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;

  @Inject
  protected TypeSystem xsemanticsSystem;

  protected TypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }

  @Check
  public void checkEObject(final EObject obj) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkEObject(obj),
    		obj);
  }
}
'''
		)
	}

	@Test
	def testAccessToInjectedFields() {
		testFiles.testAccessToInjectedFields.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String EOBJECTECLASS = "org.eclipse.xsemantics.test.EObjectEClass";

  /**
   * a utility field
   */
  @Inject
  private List<String> strings;

  @Inject
  private String myString;

  /**
   * another utility field
   */
  @Inject
  private List<EClass> eClasses;

  @Inject
  private List<EClass> classes;

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public List<String> getStrings() {
    return this.strings;
  }

  public void setStrings(final List<String> strings) {
    this.strings = strings;
  }

  public String getMyString() {
    return this.myString;
  }

  public void setMyString(final String myString) {
    this.myString = myString;
  }

  public List<EClass> getEClasses() {
    return this.eClasses;
  }

  public void setEClasses(final List<EClass> eClasses) {
    this.eClasses = eClasses;
  }

  public List<EClass> getClasses() {
    return this.classes;
  }

  public void setClasses(final List<EClass> classes) {
    this.classes = classes;
  }

  public Result<EClass> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return typeDispatcher.invoke(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	typeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    EClass c = null; // output parameter
    InputOutput.<EObject>println(o);
    InputOutput.<String>println(this.myString);
    boolean _add = this.strings.add(this.myString);
    /* strings.add(myString) */
    if (!_add) {
      sneakyThrowRuleFailedException("strings.add(myString)");
    }
    /* eClasses.add(o.eClass) */
    if (!this.eClasses.add(o.eClass())) {
      sneakyThrowRuleFailedException("eClasses.add(o.eClass)");
    }
    return new Result<EClass>(c);
  }
}
'''
		)
	}

	@Test
	def testAxiomWithTwoExpressionsInConclusion() {
		testFiles.testAxiomWithTwoExpressionsInConclusion.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result2;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String TWOEXPRESSIONSINCONCLUSION = "org.eclipse.xsemantics.test.TwoExpressionsInConclusion";

  private PolymorphicDispatcher<Result2<EObject, EStructuralFeature>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher2(
    	"typeImpl", 3, "|-", ":", ":");
  }

  public Result2<EObject, EStructuralFeature> type(final EClass c) {
    return type(new RuleEnvironment(), null, c);
  }

  public Result2<EObject, EStructuralFeature> type(final RuleEnvironment _environment_, final EClass c) {
    return type(_environment_, null, c);
  }

  public Result2<EObject, EStructuralFeature> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure2(_e_type);
    }
  }

  protected Result2<EObject, EStructuralFeature> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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

  protected Result2<EObject, EStructuralFeature> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result2<EObject, EStructuralFeature> _result_ = applyRuleTwoExpressionsInConclusion(G, _subtrace_, cl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTwoExpressionsInConclusion) {
    	typeThrowException(ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + "EClass" + " : " + "EStructuralFeature",
    		TWOEXPRESSIONSINCONCLUSION,
    		e_applyRuleTwoExpressionsInConclusion, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }

  protected Result2<EObject, EStructuralFeature> applyRuleTwoExpressionsInConclusion(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    
    return new Result2<EObject, EStructuralFeature>(_applyRuleTwoExpressionsInConclusion_1(G, cl), _applyRuleTwoExpressionsInConclusion_2(G, cl));
  }

  private EClass _applyRuleTwoExpressionsInConclusion_1(final RuleEnvironment G, final EClass cl) throws RuleFailedException {
    return cl;
  }

  private EStructuralFeature _applyRuleTwoExpressionsInConclusion_2(final RuleEnvironment G, final EClass cl) throws RuleFailedException {
    EStructuralFeature _head = IterableExtensions.<EStructuralFeature>head(cl.getEAllStructuralFeatures());
    return _head;
  }
}
'''
		)
	}

	@Test
	def testRuleWithTwoExpressionsInConclusion() {
		testFiles.testRuleWithTwoExpressionsInConclusion.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result2;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String TWOEXPRESSIONSINCONCLUSION = "org.eclipse.xsemantics.test.TwoExpressionsInConclusion";

  private PolymorphicDispatcher<Result2<EObject, EStructuralFeature>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher2(
    	"typeImpl", 3, "|-", ":", ":");
  }

  public Result2<EObject, EStructuralFeature> type(final EClass c) {
    return type(new RuleEnvironment(), null, c);
  }

  public Result2<EObject, EStructuralFeature> type(final RuleEnvironment _environment_, final EClass c) {
    return type(_environment_, null, c);
  }

  public Result2<EObject, EStructuralFeature> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure2(_e_type);
    }
  }

  protected Result2<EObject, EStructuralFeature> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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

  protected Result2<EObject, EStructuralFeature> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result2<EObject, EStructuralFeature> _result_ = applyRuleTwoExpressionsInConclusion(G, _subtrace_, cl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTwoExpressionsInConclusion) {
    	typeThrowException(ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + "EClass" + " : " + "EStructuralFeature",
    		TWOEXPRESSIONSINCONCLUSION,
    		e_applyRuleTwoExpressionsInConclusion, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }

  protected Result2<EObject, EStructuralFeature> applyRuleTwoExpressionsInConclusion(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    InputOutput.<String>println(cl.getName());
    return new Result2<EObject, EStructuralFeature>(_applyRuleTwoExpressionsInConclusion_1(G, cl), _applyRuleTwoExpressionsInConclusion_2(G, cl));
  }

  private EClass _applyRuleTwoExpressionsInConclusion_1(final RuleEnvironment G, final EClass cl) throws RuleFailedException {
    return cl;
  }

  private EStructuralFeature _applyRuleTwoExpressionsInConclusion_2(final RuleEnvironment G, final EClass cl) throws RuleFailedException {
    EStructuralFeature _head = IterableExtensions.<EStructuralFeature>head(cl.getEAllStructuralFeatures());
    return _head;
  }
}
'''
		)
	}

	@Test
	def testAccessToThisInExpressionsInConclusion() {
		testFiles.testAccessToThisInExpressionInConclusion.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String EOBJECTECLASS = "org.eclipse.xsemantics.test.EObjectEClass";

  /**
   * a utility field
   */
  @Inject
  private List<String> strings;

  @Inject
  private String myString;

  /**
   * another utility field
   */
  @Inject
  private List<EClass> eClasses;

  @Inject
  private List<EClass> classes;

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public List<String> getStrings() {
    return this.strings;
  }

  public void setStrings(final List<String> strings) {
    this.strings = strings;
  }

  public String getMyString() {
    return this.myString;
  }

  public void setMyString(final String myString) {
    this.myString = myString;
  }

  public List<EClass> getEClasses() {
    return this.eClasses;
  }

  public void setEClasses(final List<EClass> eClasses) {
    this.eClasses = eClasses;
  }

  public List<EClass> getClasses() {
    return this.classes;
  }

  public void setClasses(final List<EClass> classes) {
    this.classes = classes;
  }

  public Result<EClass> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return typeDispatcher.invoke(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	typeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    
    return new Result<EClass>(_applyRuleEObjectEClass_1(G, o));
  }

  private EClass _applyRuleEObjectEClass_1(final RuleEnvironment G, final EObject o) throws RuleFailedException {
    EClass _xblockexpression = null;
    {
      InputOutput.<TypeSystem>println(this);
      _xblockexpression = (this.<EObject>clone(o).eClass());
    }
    return _xblockexpression;
  }
}
'''
		)
	}

	@Test
	def testAccessToInjectedFieldsInExpressionsInConclusion() {
		testFiles.testAccessToInjectedFieldsInExpressionInConclusion.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String EOBJECTECLASS = "org.eclipse.xsemantics.test.EObjectEClass";

  /**
   * a utility field
   */
  @Inject
  private List<String> strings;

  @Inject
  private String myString;

  /**
   * another utility field
   */
  @Inject
  private List<EClass> eClasses;

  @Inject
  private List<EClass> classes;

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public List<String> getStrings() {
    return this.strings;
  }

  public void setStrings(final List<String> strings) {
    this.strings = strings;
  }

  public String getMyString() {
    return this.myString;
  }

  public void setMyString(final String myString) {
    this.myString = myString;
  }

  public List<EClass> getEClasses() {
    return this.eClasses;
  }

  public void setEClasses(final List<EClass> eClasses) {
    this.eClasses = eClasses;
  }

  public List<EClass> getClasses() {
    return this.classes;
  }

  public void setClasses(final List<EClass> classes) {
    this.classes = classes;
  }

  public Result<EClass> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return typeDispatcher.invoke(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	typeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    
    return new Result<EClass>(_applyRuleEObjectEClass_1(G, o));
  }

  private EClass _applyRuleEObjectEClass_1(final RuleEnvironment G, final EObject o) throws RuleFailedException {
    EClass _get = this.classes.get(0);
    return _get;
  }
}
'''
		)
	}

	@Test
	def testOrExpressions() {
		testFiles.testOrExpressionsAccessingPreviousFailure.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.TraceUtils;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String ECLASSEOBJECT = "org.eclipse.xsemantics.test.EClassEObject";

  @Extension
  @Inject
  private TraceUtils traceUtils;

  private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 4, "|-", ":");
  }

  public TraceUtils getTraceUtils() {
    return this.traceUtils;
  }

  public void setTraceUtils(final TraceUtils traceUtils) {
    this.traceUtils = traceUtils;
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
    final String className = eClass.getName();
    boolean _isEmpty = className.isEmpty();
    if (_isEmpty) {
      /* {className == 'foo'} or {className == 'bar'} or { { println(previousFailure) } or {className == 'foobar'} } */
      {
        RuleFailedException previousFailure = null;
        try {
          /* className == 'foo' */
          if (!Objects.equal(className, "foo")) {
            sneakyThrowRuleFailedException("className == \'foo\'");
          }
        } catch (Exception e) {
          previousFailure = extractRuleFailedException(e);
          /* {className == 'bar'} or { { println(previousFailure) } or {className == 'foobar'} } */
          {
            try {
              /* className == 'bar' */
              if (!Objects.equal(className, "bar")) {
                sneakyThrowRuleFailedException("className == \'bar\'");
              }
            } catch (Exception e_1) {
              previousFailure = extractRuleFailedException(e_1);
              /* { println(previousFailure) } or {className == 'foobar'} */
              {
                try {
                  InputOutput.<RuleFailedException>println(previousFailure);
                } catch (Exception e_2) {
                  previousFailure = extractRuleFailedException(e_2);
                  /* className == 'foobar' */
                  if (!Objects.equal(className, "foobar")) {
                    sneakyThrowRuleFailedException("className == \'foobar\'");
                  }
                }
              }
            }
          }
        }
      }
      /* {className == 'foo1'} or {className == 'bar1'} or { println(previousFailure) } or { fail error "this is the previous error: " + previousFailure.message source object } */
      {
        RuleFailedException previousFailure = null;
        try {
          /* className == 'foo1' */
          if (!Objects.equal(className, "foo1")) {
            sneakyThrowRuleFailedException("className == \'foo1\'");
          }
        } catch (Exception e_3) {
          previousFailure = extractRuleFailedException(e_3);
          /* {className == 'bar1'} or { println(previousFailure) } or { fail error "this is the previous error: " + previousFailure.message source object } */
          {
            try {
              /* className == 'bar1' */
              if (!Objects.equal(className, "bar1")) {
                sneakyThrowRuleFailedException("className == \'bar1\'");
              }
            } catch (Exception e_4) {
              previousFailure = extractRuleFailedException(e_4);
              /* { println(previousFailure) } or { fail error "this is the previous error: " + previousFailure.message source object } */
              {
                try {
                  InputOutput.<RuleFailedException>println(previousFailure);
                } catch (Exception e_5) {
                  previousFailure = extractRuleFailedException(e_5);
                  /* fail error "this is the previous error: " + previousFailure.message source object */
                  String _message = previousFailure.getMessage();
                  String _plus = ("this is the previous error: " + _message);
                  String error = _plus;
                  EObject source = object;
                  throwForExplicitFail(error, new ErrorInformation(source, null));
                }
              }
            }
          }
        }
      }
    } else {
      /* {className == 'foo1'} or { fail error "this is the previous error trace: " + previousFailure.failureTraceAsString source object } */
      {
        RuleFailedException previousFailure = null;
        try {
          /* className == 'foo1' */
          if (!Objects.equal(className, "foo1")) {
            sneakyThrowRuleFailedException("className == \'foo1\'");
          }
        } catch (Exception e_6) {
          previousFailure = extractRuleFailedException(e_6);
          /* fail error "this is the previous error trace: " + previousFailure.failureTraceAsString source object */
          String _failureTraceAsString = this.traceUtils.failureTraceAsString(previousFailure);
          String _plus_1 = ("this is the previous error trace: " + _failureTraceAsString);
          String error_1 = _plus_1;
          EObject source_1 = object;
          throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
        }
      }
    }
    return new Result<Boolean>(true);
  }
}
'''
		)
	}

	@Test
	def testOrExpressionInIfThenElse_Issue_46() {
		// https://github.com/LorenzoBettini/xsemantics/issues/46
		'''
import org.eclipse.emf.ecore.EObject

system org.eclipse.xsemantics.test.TypeSystem

judgments {
    type |- EObject it : output String
}

rule typeFoo
    G |- EObject it : "Foo"
from {
	if( eClass == null ){
        empty |- it : var String result
        or true
    } else {
    	println()
        empty |- eClass : var String result
        or true
    }
}
		'''.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String TYPEFOO = "org.eclipse.xsemantics.test.TypeFoo";

  private PolymorphicDispatcher<Result<String>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public Result<String> type(final EObject it) {
    return type(new RuleEnvironment(), null, it);
  }

  public Result<String> type(final RuleEnvironment _environment_, final EObject it) {
    return type(_environment_, null, it);
  }

  public Result<String> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject it) {
    try {
    	return typeInternal(_environment_, _trace_, it);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<String> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject it) {
    try {
    	checkParamsNotNull(it);
    	return typeDispatcher.invoke(_environment_, _trace_, it);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject it, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<String> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject it) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<String> _result_ = applyRuleTypeFoo(G, _subtrace_, it);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("typeFoo") + stringRepForEnv(G) + " |- " + stringRep(it) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTypeFoo) {
    	typeThrowException(ruleName("typeFoo") + stringRepForEnv(G) + " |- " + stringRep(it) + " : " + "String",
    		TYPEFOO,
    		e_applyRuleTypeFoo, it, new ErrorInformation[] {new ErrorInformation(it)});
    	return null;
    }
  }

  protected Result<String> applyRuleTypeFoo(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject it) throws RuleFailedException {
    EClass _eClass = it.eClass();
    boolean _equals = Objects.equal(_eClass, null);
    if (_equals) {
      /* empty |- it : var String result or true */
      {
        RuleFailedException previousFailure = null;
        try {
          /* empty |- it : var String result */
          String result = null;
          Result<String> result_1 = typeInternal(emptyEnvironment(), _trace_, it);
          checkAssignableTo(result_1.getFirst(), String.class);
          result = (String) result_1.getFirst();
          
        } catch (Exception e) {
          previousFailure = extractRuleFailedException(e);
          /* true */
        }
      }
    } else {
      InputOutput.println();
      /* empty |- eClass : var String result or true */
      {
        RuleFailedException previousFailure = null;
        try {
          /* empty |- eClass : var String result */
          EClass _eClass_1 = it.eClass();
          String result_2 = null;
          Result<String> result_3 = typeInternal(emptyEnvironment(), _trace_, _eClass_1);
          checkAssignableTo(result_3.getFirst(), String.class);
          result_2 = (String) result_3.getFirst();
          
        } catch (Exception e_1) {
          previousFailure = extractRuleFailedException(e_1);
          /* true */
        }
      }
    }
    return new Result<String>(_applyRuleTypeFoo_1(G, it));
  }

  private String _applyRuleTypeFoo_1(final RuleEnvironment G, final EObject it) throws RuleFailedException {
    return "Foo";
  }
}
'''
		)
	}

	@Test
	def testOrExpressionInIfThenElse_Issue_46_2() {
		// https://github.com/LorenzoBettini/xsemantics/issues/46
		'''
import org.eclipse.emf.ecore.EObject

system org.eclipse.xsemantics.test.TypeSystem

judgments {
    type |- EObject it : output String
}

rule typeFoo
    G |- EObject it : "Foo"
from {
	if( eClass == null ){
        empty |- it : var String result
        or true
    } else {
        empty |- eClass : var String result
        or true

        empty |- eClass : var String result
        or true
    }
}
		'''.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String TYPEFOO = "org.eclipse.xsemantics.test.TypeFoo";

  private PolymorphicDispatcher<Result<String>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public Result<String> type(final EObject it) {
    return type(new RuleEnvironment(), null, it);
  }

  public Result<String> type(final RuleEnvironment _environment_, final EObject it) {
    return type(_environment_, null, it);
  }

  public Result<String> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject it) {
    try {
    	return typeInternal(_environment_, _trace_, it);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<String> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject it) {
    try {
    	checkParamsNotNull(it);
    	return typeDispatcher.invoke(_environment_, _trace_, it);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject it, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<String> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject it) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<String> _result_ = applyRuleTypeFoo(G, _subtrace_, it);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("typeFoo") + stringRepForEnv(G) + " |- " + stringRep(it) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTypeFoo) {
    	typeThrowException(ruleName("typeFoo") + stringRepForEnv(G) + " |- " + stringRep(it) + " : " + "String",
    		TYPEFOO,
    		e_applyRuleTypeFoo, it, new ErrorInformation[] {new ErrorInformation(it)});
    	return null;
    }
  }

  protected Result<String> applyRuleTypeFoo(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject it) throws RuleFailedException {
    EClass _eClass = it.eClass();
    boolean _equals = Objects.equal(_eClass, null);
    if (_equals) {
      /* empty |- it : var String result or true */
      {
        RuleFailedException previousFailure = null;
        try {
          /* empty |- it : var String result */
          String result = null;
          Result<String> result_1 = typeInternal(emptyEnvironment(), _trace_, it);
          checkAssignableTo(result_1.getFirst(), String.class);
          result = (String) result_1.getFirst();
          
        } catch (Exception e) {
          previousFailure = extractRuleFailedException(e);
          /* true */
        }
      }
    } else {
      /* empty |- eClass : var String result or true */
      {
        RuleFailedException previousFailure = null;
        try {
          /* empty |- eClass : var String result */
          EClass _eClass_1 = it.eClass();
          String result_2 = null;
          Result<String> result_3 = typeInternal(emptyEnvironment(), _trace_, _eClass_1);
          checkAssignableTo(result_3.getFirst(), String.class);
          result_2 = (String) result_3.getFirst();
          
        } catch (Exception e_1) {
          previousFailure = extractRuleFailedException(e_1);
          /* true */
        }
      }
      /* empty |- eClass : var String result or true */
      {
        RuleFailedException previousFailure = null;
        try {
          /* empty |- eClass : var String result */
          EClass _eClass_2 = it.eClass();
          String result_4 = null;
          Result<String> result_5 = typeInternal(emptyEnvironment(), _trace_, _eClass_2);
          checkAssignableTo(result_5.getFirst(), String.class);
          result_4 = (String) result_5.getFirst();
          
        } catch (Exception e_2) {
          previousFailure = extractRuleFailedException(e_2);
          /* true */
        }
      }
    }
    return new Result<String>(_applyRuleTypeFoo_1(G, it));
  }

  private String _applyRuleTypeFoo_1(final RuleEnvironment G, final EObject it) throws RuleFailedException {
    return "Foo";
  }
}
'''
		)
	}

	@Test
	def testOrExpressionInLambda_Issue_46() {
		// https://github.com/LorenzoBettini/xsemantics/issues/46
		'''
import org.eclipse.emf.ecore.EObject

system org.eclipse.xsemantics.test.TypeSystem

judgments {
    type |- EObject it : output String
}

rule typeFoo
    G |- EObject it : "Foo"
from {
	empty |- eClass : var String result
    or 
        newArrayList().forEach[
        	dummy |
	        empty |- eClass : var String result
	        or true
        ]
}
		'''.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String TYPEFOO = "org.eclipse.xsemantics.test.TypeFoo";

  private PolymorphicDispatcher<Result<String>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public Result<String> type(final EObject it) {
    return type(new RuleEnvironment(), null, it);
  }

  public Result<String> type(final RuleEnvironment _environment_, final EObject it) {
    return type(_environment_, null, it);
  }

  public Result<String> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject it) {
    try {
    	return typeInternal(_environment_, _trace_, it);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<String> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject it) {
    try {
    	checkParamsNotNull(it);
    	return typeDispatcher.invoke(_environment_, _trace_, it);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject it, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<String> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject it) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<String> _result_ = applyRuleTypeFoo(G, _subtrace_, it);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("typeFoo") + stringRepForEnv(G) + " |- " + stringRep(it) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTypeFoo) {
    	typeThrowException(ruleName("typeFoo") + stringRepForEnv(G) + " |- " + stringRep(it) + " : " + "String",
    		TYPEFOO,
    		e_applyRuleTypeFoo, it, new ErrorInformation[] {new ErrorInformation(it)});
    	return null;
    }
  }

  protected Result<String> applyRuleTypeFoo(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject it) throws RuleFailedException {
    /* empty |- eClass : var String result or newArrayList().forEach[ dummy | empty |- eClass : var String result or true ] */
    {
      RuleFailedException previousFailure = null;
      try {
        /* empty |- eClass : var String result */
        EClass _eClass = it.eClass();
        String result = null;
        Result<String> result_1 = typeInternal(emptyEnvironment(), _trace_, _eClass);
        checkAssignableTo(result_1.getFirst(), String.class);
        result = (String) result_1.getFirst();
        
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        final Consumer<Object> _function = new Consumer<Object>() {
          @Override
          public void accept(final Object dummy) {
            /* empty |- eClass : var String result or true */
            {
              RuleFailedException previousFailure = null;
              try {
                /* empty |- eClass : var String result */
                EClass _eClass = it.eClass();
                String result = null;
                Result<String> result_1 = typeInternal(emptyEnvironment(), _trace_, _eClass);
                checkAssignableTo(result_1.getFirst(), String.class);
                result = (String) result_1.getFirst();
                
              } catch (Exception e) {
                previousFailure = extractRuleFailedException(e);
                /* true */
              }
            }
          }
        };
        CollectionLiterals.<Object>newArrayList().forEach(_function);
      }
    }
    return new Result<String>(_applyRuleTypeFoo_1(G, it));
  }

  private String _applyRuleTypeFoo_1(final RuleEnvironment G, final EObject it) throws RuleFailedException {
    return "Foo";
  }
}
'''
		)
	}

	@Test
	def testSystemWithValidatorExtends() {
		testFiles.testCheckRuleWithValidatorExtends.assertCorrectJavaCodeGeneration(
			null,
			'''
package org.eclipse.xsemantics.test.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xsemantics.test.TypeSystem;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

@SuppressWarnings("all")
public class TypeSystemValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;

  @Inject
  protected TypeSystem xsemanticsSystem;

  protected TypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }

  @Check
  public void checkEObject(final EObject obj) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkEObject(obj),
    		obj);
  }
}
'''
		)
	}

	@Test
	def testSystemWithExtends() {
		#[
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
			testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore,
			testFiles.testSystemExtendsExtendedTypeSystem
		].assertCorrectJavaCodeGeneration(
			"ExtendedTypeSystem2",
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class ExtendedTypeSystem2 extends ExtendedTypeSystem {
  public static final String FROMTYPESYSTEM = "org.eclipse.xsemantics.test.FromTypeSystem";

  public static final String FROMEXTENDEDTYPESYSTEM = "org.eclipse.xsemantics.test.FromExtendedTypeSystem";

  public static final String FROMTHISTYPESYSTEM = "org.eclipse.xsemantics.test.FromThisTypeSystem";

  private PolymorphicDispatcher<Result<Boolean>> type2Dispatcher;

  public ExtendedTypeSystem2() {
    init();
  }

  @Override
  public void init() {
    super.init();
    type2Dispatcher = buildPolymorphicDispatcher1(
    	"type2Impl", 4, "||-", ":");
  }

  public Result<Boolean> type2(final EClass c1, final EClass c2) {
    return type2(new RuleEnvironment(), null, c1, c2);
  }

  public Result<Boolean> type2(final RuleEnvironment _environment_, final EClass c1, final EClass c2) {
    return type2(_environment_, null, c1, c2);
  }

  public Result<Boolean> type2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) {
    try {
    	return type2Internal(_environment_, _trace_, c1, c2);
    } catch (Exception _e_type2) {
    	return resultForFailure(_e_type2);
    }
  }

  public Boolean type2Succeeded(final EClass c1, final EClass c2) {
    return type2Succeeded(new RuleEnvironment(), null, c1, c2);
  }

  public Boolean type2Succeeded(final RuleEnvironment _environment_, final EClass c1, final EClass c2) {
    return type2Succeeded(_environment_, null, c1, c2);
  }

  public Boolean type2Succeeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) {
    try {
    	type2Internal(_environment_, _trace_, c1, c2);
    	return true;
    } catch (Exception _e_type2) {
    	return false;
    }
  }

  public Result<Boolean> checkEObject(final EObject o) {
    return checkEObject(null, o);
  }

  public Result<Boolean> checkEObject(final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return checkEObjectInternal(_trace_, o);
    } catch (Exception _e_CheckEObject) {
    	return resultForFailure(_e_CheckEObject);
    }
  }

  protected Result<Boolean> checkEObjectInternal(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    /* empty |- o : var EClass c */
    EClass c = null;
    Result<EClass> result = typeInternal(emptyEnvironment(), _trace_, o);
    checkAssignableTo(result.getFirst(), EClass.class);
    c = (EClass) result.getFirst();
    
    /* empty |- o.eClass <: c */
    EClass _eClass = o.eClass();
    subtypeInternal(emptyEnvironment(), _trace_, _eClass, c);
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> type2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) {
    try {
    	checkParamsNotNull(c1, c2);
    	return type2Dispatcher.invoke(_environment_, _trace_, c1, c2);
    } catch (Exception _e_type2) {
    	sneakyThrowRuleFailedException(_e_type2);
    	return null;
    }
  }

  protected void type2ThrowException(final String _error, final String _issue, final Exception _ex, final EClass c1, final EClass c2, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject c) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleFromTypeSystem(G, _subtrace_, c);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FromTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFromTypeSystem) {
    	typeThrowException(ruleName("FromTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + "EClass",
    		FROMTYPESYSTEM,
    		e_applyRuleFromTypeSystem, c, new ErrorInformation[] {new ErrorInformation(c)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleFromTypeSystem(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject c) throws RuleFailedException {
    /* G |- c.eClass <: c.eClass */
    EClass _eClass = c.eClass();
    EClass _eClass_1 = c.eClass();
    subtypeInternal(G, _trace_, _eClass, _eClass_1);
    return new Result<EClass>(_applyRuleFromTypeSystem_1(G, c));
  }

  private EClass _applyRuleFromTypeSystem_1(final RuleEnvironment G, final EObject c) throws RuleFailedException {
    EClass _eClass = c.eClass();
    return _eClass;
  }

  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleFromExtendedTypeSystem(G, _subtrace_, c1, c2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FromExtendedTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c1) + " <: " + stringRep(c2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFromExtendedTypeSystem) {
    	subtypeThrowException(ruleName("FromExtendedTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c1) + " <: " + stringRep(c2),
    		FROMEXTENDEDTYPESYSTEM,
    		e_applyRuleFromExtendedTypeSystem, c1, c2, new ErrorInformation[] {new ErrorInformation(c1), new ErrorInformation(c2)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleFromExtendedTypeSystem(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) throws RuleFailedException {
    /* G ||- c1 : c2 */
    type2Internal(G, _trace_, c1, c2);
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> type2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleFromThisTypeSystem(G, _subtrace_, c1, c2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FromThisTypeSystem") + stringRepForEnv(G) + " ||- " + stringRep(c1) + " : " + stringRep(c2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFromThisTypeSystem) {
    	type2ThrowException(ruleName("FromThisTypeSystem") + stringRepForEnv(G) + " ||- " + stringRep(c1) + " : " + stringRep(c2),
    		FROMTHISTYPESYSTEM,
    		e_applyRuleFromThisTypeSystem, c1, c2, new ErrorInformation[] {new ErrorInformation(c1), new ErrorInformation(c2)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleFromThisTypeSystem(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) throws RuleFailedException {
    /* G |- c1 : var EClass o */
    EClass o = null;
    Result<EClass> result = typeInternal(G, _trace_, c1);
    checkAssignableTo(result.getFirst(), EClass.class);
    o = (EClass) result.getFirst();
    
    return new Result<Boolean>(true);
  }
}
''',
			'''
package org.eclipse.xsemantics.test.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.test.ExtendedTypeSystem2;
import org.eclipse.xtext.validation.Check;

@SuppressWarnings("all")
public class ExtendedTypeSystem2Validator extends ExtendedTypeSystemValidator {
  @Inject
  protected ExtendedTypeSystem2 xsemanticsSystem;

  @Override
  protected ExtendedTypeSystem2 getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }

  @Check
  public void checkEObject(final EObject o) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkEObject(o),
    		o);
  }
}
'''
		)
	}

	@Test
	def testRuleOverride() {
		systemExtendsSystemWithRuleOverride.assertCorrectJavaCodeGeneration(
			"ExtendedTypeSystemWithRuleOverride",
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;

@SuppressWarnings("all")
public class ExtendedTypeSystemWithRuleOverride extends ExtendedTypeSystem2 {
  public static final String FROMTYPESYSTEM = "org.eclipse.xsemantics.test.FromTypeSystem";

  public static final String FROMEXTENDEDTYPESYSTEM = "org.eclipse.xsemantics.test.FromExtendedTypeSystem";

  public static final String FROMTHISTYPESYSTEM = "org.eclipse.xsemantics.test.FromThisTypeSystem";

  public ExtendedTypeSystemWithRuleOverride() {
    init();
  }

  @Override
  public void init() {
    super.init();
    
  }

  @Override
  public Result<Boolean> checkEObject(final EObject o) {
    return checkEObject(null, o);
  }

  @Override
  public Result<Boolean> checkEObject(final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return checkEObjectInternal(_trace_, o);
    } catch (Exception _e_CheckEObject) {
    	return resultForFailure(_e_CheckEObject);
    }
  }

  @Override
  protected Result<Boolean> checkEObjectInternal(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    /* empty |- o : var EClass c */
    EClass c = null;
    Result<EClass> result = typeInternal(emptyEnvironment(), _trace_, o);
    checkAssignableTo(result.getFirst(), EClass.class);
    c = (EClass) result.getFirst();
    
    /* empty |- o.eClass <: c */
    EClass _eClass = o.eClass();
    subtypeInternal(emptyEnvironment(), _trace_, _eClass, c);
    return new Result<Boolean>(true);
  }

  @Override
  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject c) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleFromTypeSystem(G, _subtrace_, c);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FromTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFromTypeSystem) {
    	typeThrowException(ruleName("FromTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + "EClass",
    		FROMTYPESYSTEM,
    		e_applyRuleFromTypeSystem, c, new ErrorInformation[] {new ErrorInformation(c)});
    	return null;
    }
  }

  @Override
  protected Result<EClass> applyRuleFromTypeSystem(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject c) throws RuleFailedException {
    
    return new Result<EClass>(_applyRuleFromTypeSystem_1(G, c));
  }

  private EClass _applyRuleFromTypeSystem_1(final RuleEnvironment G, final EObject c) throws RuleFailedException {
    EClass _eClass = c.eClass();
    return _eClass;
  }

  @Override
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleFromExtendedTypeSystem(G, _subtrace_, c1, c2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FromExtendedTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c1) + " <: " + stringRep(c2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFromExtendedTypeSystem) {
    	subtypeThrowException(ruleName("FromExtendedTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c1) + " <: " + stringRep(c2),
    		FROMEXTENDEDTYPESYSTEM,
    		e_applyRuleFromExtendedTypeSystem, c1, c2, new ErrorInformation[] {new ErrorInformation(c1), new ErrorInformation(c2)});
    	return null;
    }
  }

  @Override
  protected Result<Boolean> applyRuleFromExtendedTypeSystem(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) throws RuleFailedException {
    /* G ||- c1 : c2 */
    type2Internal(G, _trace_, c1, c2);
    return new Result<Boolean>(true);
  }

  @Override
  protected Result<Boolean> type2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleFromThisTypeSystem(G, _subtrace_, c1, c2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FromThisTypeSystem") + stringRepForEnv(G) + " ||- " + stringRep(c1) + " : " + stringRep(c2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFromThisTypeSystem) {
    	type2ThrowException(ruleName("FromThisTypeSystem") + stringRepForEnv(G) + " ||- " + stringRep(c1) + " : " + stringRep(c2),
    		FROMTHISTYPESYSTEM,
    		e_applyRuleFromThisTypeSystem, c1, c2, new ErrorInformation[] {new ErrorInformation(c1), new ErrorInformation(c2)});
    	return null;
    }
  }

  @Override
  protected Result<Boolean> applyRuleFromThisTypeSystem(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) throws RuleFailedException {
    /* G |- c1 : var EClass o */
    EClass o = null;
    Result<EClass> result = typeInternal(G, _trace_, c1);
    checkAssignableTo(result.getFirst(), EClass.class);
    o = (EClass) result.getFirst();
    
    return new Result<Boolean>(true);
  }
}
''',
			'''
package org.eclipse.xsemantics.test.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.test.ExtendedTypeSystemWithRuleOverride;
import org.eclipse.xtext.validation.Check;

@SuppressWarnings("all")
public class ExtendedTypeSystemWithRuleOverrideValidator extends ExtendedTypeSystem2Validator {
  @Inject
  protected ExtendedTypeSystemWithRuleOverride xsemanticsSystem;

  @Override
  protected ExtendedTypeSystemWithRuleOverride getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }

  @Override
  @Check
  public void checkEObject(final EObject o) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkEObject(o),
    		o);
  }
}
'''
		)
	}

	@Test
	def testJudgmentOverride() {
		systemExtendsSystemWithJudgmentOverride.assertCorrectJavaCodeGeneration(
			"ExtendedTypeSystemWithJudgmentOverride",
			'''
package org.eclipse.xsemantics.test;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class ExtendedTypeSystemWithJudgmentOverride extends ExtendedTypeSystem2 {
  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;

  public ExtendedTypeSystemWithJudgmentOverride() {
    init();
  }

  @Override
  public void init() {
    super.init();
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
  }

  @Override
  public Result<EClass> type(final EObject obj) {
    return type(new RuleEnvironment(), null, obj);
  }

  @Override
  public Result<EClass> type(final RuleEnvironment _environment_, final EObject obj) {
    return type(_environment_, null, obj);
  }

  @Override
  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	return typeInternal(_environment_, _trace_, obj);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  @Override
  public Result<Boolean> subtype(final EClass c1, final EClass c2) {
    return subtype(new RuleEnvironment(), null, c1, c2);
  }

  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final EClass c1, final EClass c2) {
    return subtype(_environment_, null, c1, c2);
  }

  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) {
    try {
    	return subtypeInternal(_environment_, _trace_, c1, c2);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }

  @Override
  public Boolean subtypeSucceeded(final EClass c1, final EClass c2) {
    return subtypeSucceeded(new RuleEnvironment(), null, c1, c2);
  }

  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final EClass c1, final EClass c2) {
    return subtypeSucceeded(_environment_, null, c1, c2);
  }

  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) {
    try {
    	subtypeInternal(_environment_, _trace_, c1, c2);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
    }
  }

  @Override
  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	checkParamsNotNull(obj);
    	return typeDispatcher.invoke(_environment_, _trace_, obj);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  @Override
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject obj, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  @Override
  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) {
    try {
    	checkParamsNotNull(c1, c2);
    	return subtypeDispatcher.invoke(_environment_, _trace_, c1, c2);
    } catch (Exception _e_subtype) {
    	sneakyThrowRuleFailedException(_e_subtype);
    	return null;
    }
  }

  @Override
  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final EClass c1, final EClass c2, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(c1);
    String _plus = (_stringRep + " not <: ");
    String _stringRep_1 = this.stringRep(c2);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    EObject source = c1;
    EStructuralFeature _eContainingFeature = c1.eClass().eContainingFeature();
    EStructuralFeature feature = _eContainingFeature;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, feature));
  }
}
''',
			null
		)
	}

	@Test
	def testOverrideJudgmentWithDifferentParamNames() {
		withBaseSystems(testFiles.testOverrideJudgmentWithDifferentParamNames).assertCorrectJavaCodeGeneration(
			"ExtendedTypeSystemWithJudgmentOverride",
			'''
package org.eclipse.xsemantics.test;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class ExtendedTypeSystemWithJudgmentOverride extends ExtendedTypeSystem2 {
  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;

  public ExtendedTypeSystemWithJudgmentOverride() {
    init();
  }

  @Override
  public void init() {
    super.init();
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
  }

  @Override
  public Result<Boolean> subtype(final EClass left, final EClass right) {
    return subtype(new RuleEnvironment(), null, left, right);
  }

  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final EClass left, final EClass right) {
    return subtype(_environment_, null, left, right);
  }

  @Override
  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass left, final EClass right) {
    try {
    	return subtypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }

  @Override
  public Boolean subtypeSucceeded(final EClass left, final EClass right) {
    return subtypeSucceeded(new RuleEnvironment(), null, left, right);
  }

  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final EClass left, final EClass right) {
    return subtypeSucceeded(_environment_, null, left, right);
  }

  @Override
  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass left, final EClass right) {
    try {
    	subtypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
    }
  }

  @Override
  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass left, final EClass right) {
    try {
    	checkParamsNotNull(left, right);
    	return subtypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	sneakyThrowRuleFailedException(_e_subtype);
    	return null;
    }
  }

  @Override
  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final EClass left, final EClass right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
}
''',
			null
		)
	}

	@Test
	def testErrorSpecifications() {
		testFiles.testErrorSpecifications.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import java.util.Collections;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String TYPEEOBJECT = "org.eclipse.xsemantics.test.TypeEObject";

  public static final String TYPEECLASS = "org.eclipse.xsemantics.test.TypeEClass";

  public static final String SUBTYPEEOBJECT = "org.eclipse.xsemantics.test.SubtypeEObject";

  public static final String SUBTYPEESTRUCTURALFEATURE = "org.eclipse.xsemantics.test.SubtypeEStructuralFeature";

  public static final String SUBTYPEECLASS = "org.eclipse.xsemantics.test.SubtypeEClass";

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
  }

  public Result<EClass> type(final EObject c) {
    return type(new RuleEnvironment(), null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject c) {
    return type(_environment_, null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  public Result<Boolean> subtype(final EObject left, final EObject right) {
    return subtype(new RuleEnvironment(), null, left, right);
  }

  public Result<Boolean> subtype(final RuleEnvironment _environment_, final EObject left, final EObject right) {
    return subtype(_environment_, null, left, right);
  }

  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject left, final EObject right) {
    try {
    	return subtypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }

  public Boolean subtypeSucceeded(final EObject left, final EObject right) {
    return subtypeSucceeded(new RuleEnvironment(), null, left, right);
  }

  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final EObject left, final EObject right) {
    return subtypeSucceeded(_environment_, null, left, right);
  }

  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject left, final EObject right) {
    try {
    	subtypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
    }
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	checkParamsNotNull(c);
    	return typeDispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String error = (("this " + c) + " made an error!");
    EObject source = c;
    EStructuralFeature _eContainingFeature = c.eClass().eContainingFeature();
    EStructuralFeature feature = _eContainingFeature;
    Object data = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("some", "additional", "data", c));
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, feature, data));
  }

  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject left, final EObject right) {
    try {
    	checkParamsNotNull(left, right);
    	return subtypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_subtype) {
    	sneakyThrowRuleFailedException(_e_subtype);
    	return null;
    }
  }

  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final EObject left, final EObject right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleTypeEObject(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TypeEObject") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTypeEObject) {
    	typeThrowException(ruleName("TypeEObject") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
    		TYPEEOBJECT,
    		e_applyRuleTypeEObject, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleTypeEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    
    return new Result<EClass>(_applyRuleTypeEObject_1(G, o));
  }

  private EClass _applyRuleTypeEObject_1(final RuleEnvironment G, final EObject o) throws RuleFailedException {
    EClass _eClass = o.eClass();
    return _eClass;
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleTypeEClass(G, _subtrace_, c);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TypeEClass") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTypeEClass) {
    	typeEClassThrowException(e_applyRuleTypeEClass, c);
    	return null;
    }
  }

  protected Result<EClass> applyRuleTypeEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c) throws RuleFailedException {
    
    return new Result<EClass>(_applyRuleTypeEClass_1(G, c));
  }

  private EClass _applyRuleTypeEClass_1(final RuleEnvironment G, final EClass c) throws RuleFailedException {
    return c;
  }

  private void typeEClassThrowException(final Exception e_applyRuleTypeEClass, final EClass c) throws RuleFailedException {
    String error = "unexpected error!";
    EObject source = c;
    EStructuralFeature _eContainingFeature = c.eClass().eContainingFeature();
    EStructuralFeature feature = _eContainingFeature;
    Object data = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("some", "additional", "data", c));
    throwRuleFailedException(error,
    	TYPEECLASS, e_applyRuleTypeEClass, new ErrorInformation(source, feature, data));
  }

  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject left, final EObject right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSubtypeEObject(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SubtypeEObject") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubtypeEObject) {
    	subtypeEObjectThrowException(e_applyRuleSubtypeEObject, left, right);
    	return null;
    }
  }

  protected Result<Boolean> applyRuleSubtypeEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject left, final EObject right) throws RuleFailedException {
    /* fail */
    throwForExplicitFail();
    return new Result<Boolean>(true);
  }

  private void subtypeEObjectThrowException(final Exception e_applyRuleSubtypeEObject, final EObject left, final EObject right) throws RuleFailedException {
    String error = "Unhandled case";
    EObject source = left;
    throwRuleFailedException(error,
    	SUBTYPEEOBJECT, e_applyRuleSubtypeEObject, new ErrorInformation(source, null));
  }

  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EStructuralFeature left, final EObject right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSubtypeEStructuralFeature(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SubtypeEStructuralFeature") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubtypeEStructuralFeature) {
    	subtypeThrowException(ruleName("SubtypeEStructuralFeature") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		SUBTYPEESTRUCTURALFEATURE,
    		e_applyRuleSubtypeEStructuralFeature, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleSubtypeEStructuralFeature(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EStructuralFeature left, final EObject right) throws RuleFailedException {
    /* fail error "Unhandled case" source left data #["some", "additional", "data", left, right] */
    String error = "Unhandled case";
    EObject source = left;
    Object data = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("some", "additional", "data", left, right));
    throwForExplicitFail(error, new ErrorInformation(source, null, data));
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass left, final EClass right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSubtypeEClass(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SubtypeEClass") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubtypeEClass) {
    	subtypeThrowException(ruleName("SubtypeEClass") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		SUBTYPEECLASS,
    		e_applyRuleSubtypeEClass, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleSubtypeEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass left, final EClass right) throws RuleFailedException {
    /* right.isSuperTypeOf(left) */
    if (!right.isSuperTypeOf(left)) {
      sneakyThrowRuleFailedException("right.isSuperTypeOf(left)");
    }
    return new Result<Boolean>(true);
  }
}
''',
			null
		)
	}

	@Test
	def testErrorInformationWithNoEObjectArg() {
		testFiles.testRulesOfTheSameKind.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String TYPE1 = "org.eclipse.xsemantics.test.Type1";

  public static final String TYPE2 = "org.eclipse.xsemantics.test.Type2";

  public static final String SUBTYPE1 = "org.eclipse.xsemantics.test.SubType1";

  public static final String SUBTYPE2 = "org.eclipse.xsemantics.test.SubType2";

  private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> subtypeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 4, "|-", ":");
    subtypeDispatcher = buildPolymorphicDispatcher1(
    	"subtypeImpl", 4, "|-", "<:");
  }

  public Result<Boolean> type(final Object o1, final Object o2) {
    return type(new RuleEnvironment(), null, o1, o2);
  }

  public Result<Boolean> type(final RuleEnvironment _environment_, final Object o1, final Object o2) {
    return type(_environment_, null, o1, o2);
  }

  public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Object o1, final Object o2) {
    try {
    	return typeInternal(_environment_, _trace_, o1, o2);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  public Boolean typeSucceeded(final Object o1, final Object o2) {
    return typeSucceeded(new RuleEnvironment(), null, o1, o2);
  }

  public Boolean typeSucceeded(final RuleEnvironment _environment_, final Object o1, final Object o2) {
    return typeSucceeded(_environment_, null, o1, o2);
  }

  public Boolean typeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Object o1, final Object o2) {
    try {
    	typeInternal(_environment_, _trace_, o1, o2);
    	return true;
    } catch (Exception _e_type) {
    	return false;
    }
  }

  public Result<Boolean> subtype(final Object o1, final Object o2) {
    return subtype(new RuleEnvironment(), null, o1, o2);
  }

  public Result<Boolean> subtype(final RuleEnvironment _environment_, final Object o1, final Object o2) {
    return subtype(_environment_, null, o1, o2);
  }

  public Result<Boolean> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Object o1, final Object o2) {
    try {
    	return subtypeInternal(_environment_, _trace_, o1, o2);
    } catch (Exception _e_subtype) {
    	return resultForFailure(_e_subtype);
    }
  }

  public Boolean subtypeSucceeded(final Object o1, final Object o2) {
    return subtypeSucceeded(new RuleEnvironment(), null, o1, o2);
  }

  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final Object o1, final Object o2) {
    return subtypeSucceeded(_environment_, null, o1, o2);
  }

  public Boolean subtypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Object o1, final Object o2) {
    try {
    	subtypeInternal(_environment_, _trace_, o1, o2);
    	return true;
    } catch (Exception _e_subtype) {
    	return false;
    }
  }

  protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Object o1, final Object o2) {
    try {
    	checkParamsNotNull(o1, o2);
    	return typeDispatcher.invoke(_environment_, _trace_, o1, o2);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final Object o1, final Object o2, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> subtypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Object o1, final Object o2) {
    try {
    	checkParamsNotNull(o1, o2);
    	return subtypeDispatcher.invoke(_environment_, _trace_, o1, o2);
    } catch (Exception _e_subtype) {
    	sneakyThrowRuleFailedException(_e_subtype);
    	return null;
    }
  }

  protected void subtypeThrowException(final String _error, final String _issue, final Exception _ex, final Object o1, final Object o2, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final String s1, final Integer i2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleType1(G, _subtrace_, s1, i2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Type1") + stringRepForEnv(G) + " |- " + stringRep(s1) + " : " + stringRep(i2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleType1) {
    	typeThrowException(ruleName("Type1") + stringRepForEnv(G) + " |- " + stringRep(s1) + " : " + stringRep(i2),
    		TYPE1,
    		e_applyRuleType1, s1, i2, new ErrorInformation[] {});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleType1(final RuleEnvironment G, final RuleApplicationTrace _trace_, final String s1, final Integer i2) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Boolean b1, final Integer i2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleType2(G, _subtrace_, b1, i2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Type2") + stringRepForEnv(G) + " |- " + stringRep(b1) + " : " + stringRep(i2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleType2) {
    	typeThrowException(ruleName("Type2") + stringRepForEnv(G) + " |- " + stringRep(b1) + " : " + stringRep(i2),
    		TYPE2,
    		e_applyRuleType2, b1, i2, new ErrorInformation[] {});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleType2(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Boolean b1, final Integer i2) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final String s1, final Integer i2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSubType1(G, _subtrace_, s1, i2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SubType1") + stringRepForEnv(G) + " |- " + stringRep(s1) + " <: " + stringRep(i2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubType1) {
    	subtypeThrowException(ruleName("SubType1") + stringRepForEnv(G) + " |- " + stringRep(s1) + " <: " + stringRep(i2),
    		SUBTYPE1,
    		e_applyRuleSubType1, s1, i2, new ErrorInformation[] {});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleSubType1(final RuleEnvironment G, final RuleApplicationTrace _trace_, final String s1, final Integer i2) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Boolean b1, final Integer i2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSubType2(G, _subtrace_, b1, i2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SubType2") + stringRepForEnv(G) + " |- " + stringRep(b1) + " <: " + stringRep(i2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubType2) {
    	subtypeThrowException(ruleName("SubType2") + stringRepForEnv(G) + " |- " + stringRep(b1) + " <: " + stringRep(i2),
    		SUBTYPE2,
    		e_applyRuleSubType2, b1, i2, new ErrorInformation[] {});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleSubType2(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Boolean b1, final Integer i2) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
}
''',
			null
		)
	}

	@Test
	def testEnvironmentCompositions() {
		testFiles.testEnvironmentCompositions.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String ECLASSEOBJECT = "org.eclipse.xsemantics.test.EClassEObject";

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
    /* empty |- object.eClass : eClass */
    EClass _eClass = object.eClass();
    typeInternal(emptyEnvironment(), _trace_, _eClass, eClass);
    /* empty, G |- object.eClass : eClass */
    EClass _eClass_1 = object.eClass();
    typeInternal(environmentComposition(
      emptyEnvironment(), G
    ), _trace_, _eClass_1, eClass);
    /* empty, G, empty, G |- object.eClass : eClass */
    EClass _eClass_2 = object.eClass();
    typeInternal(environmentComposition(
      emptyEnvironment(), environmentComposition(
        G, environmentComposition(
          emptyEnvironment(), G
        )
      )
    ), _trace_, _eClass_2, eClass);
    /* 'this' <- object |- object.eClass : eClass */
    EClass _eClass_3 = object.eClass();
    typeInternal(environmentEntry("this", object), _trace_, _eClass_3, eClass);
    /* G, 'this' <- object |- object.eClass : eClass */
    EClass _eClass_4 = object.eClass();
    typeInternal(environmentComposition(
      G, environmentEntry("this", object)
    ), _trace_, _eClass_4, eClass);
    /* G, 'this' <- object, object <- EcoreFactory::eINSTANCE.createEClass() |- object.eClass : eClass */
    EClass _eClass_5 = object.eClass();
    EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
    typeInternal(environmentComposition(
      G, environmentComposition(
        environmentEntry("this", object), environmentEntry(object, _createEClass)
      )
    ), _trace_, _eClass_5, eClass);
    return new Result<Boolean>(true);
  }
}
''',
			null
		)
	}

	@Test
	def testEnvironmentXExpression() {
		testFiles.testEnvironmentXExpression.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String ECLASSEOBJECT = "org.eclipse.xsemantics.test.EClassEObject";

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
    /* new org.eclipse.xsemantics.runtime.RuleEnvironment |- eClass : object */
    RuleEnvironment _ruleEnvironment = new RuleEnvironment();
    typeInternal(_ruleEnvironment, _trace_, eClass, object);
    /* new org.eclipse.xsemantics.runtime.RuleEnvironment(G) |- eClass : object */
    RuleEnvironment _ruleEnvironment_1 = new RuleEnvironment(G);
    typeInternal(_ruleEnvironment_1, _trace_, eClass, object);
    /* environmentComposition( emptyEnvironment(), environmentComposition( G, environmentComposition( emptyEnvironment(), G ) ) ) |- eClass : object */
    RuleEnvironment _environmentComposition = this.environmentComposition(
      this.emptyEnvironment(), this.environmentComposition(G, this.environmentComposition(
      this.emptyEnvironment(), G)));
    typeInternal(_environmentComposition, _trace_, eClass, object);
    /* emptyEnvironment, 'a' <- object, new org.eclipse.xsemantics.runtime.RuleEnvironment |- eClass : object */
    RuleEnvironment _emptyEnvironment = this.emptyEnvironment();
    RuleEnvironment _ruleEnvironment_2 = new RuleEnvironment();
    typeInternal(environmentComposition(
      _emptyEnvironment, environmentComposition(
        environmentEntry("a", object), _ruleEnvironment_2
      )
    ), _trace_, eClass, object);
    return new Result<Boolean>(true);
  }
}
''',
			null
		)
	}

	@Test
	def testSystemExtendsSystemWithValidatorExtends() {
		#[
			testFiles.testBaseSystemWithValidatorExtends,
			testFiles.testSystemExtendsSystemWithValidatorExtends
		].assertCorrectJavaCodeGeneration(
			"ExtendedTypeSystem",
			null,
			'''
package org.eclipse.xsemantics.test.validation;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.test.ExtendedTypeSystem;
import org.eclipse.xtext.validation.Check;

@SuppressWarnings("all")
public class ExtendedTypeSystemValidator extends TypeSystemValidator {
  @Inject
  protected ExtendedTypeSystem xsemanticsSystem;

  @Override
  protected ExtendedTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }

  @Override
  @Check
  public void checkEObject(final EObject o) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkEObject(o),
    		o);
  }

  @Check
  public void checkEClass(final EClass o) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkEClass(o),
    		o);
  }
}
'''
		)
	}

	@Test
	def testAuxiliaryFunctions() {
		testFiles.testAuxiliaryFunctions.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String ISVALUE = "org.eclipse.xsemantics.test.IsValue";

  public static final String VOIDFUN = "org.eclipse.xsemantics.test.VoidFun";

  public static final String OBJECTCLASS = "org.eclipse.xsemantics.test.ObjectClass";

  private PolymorphicDispatcher<Boolean> isValueDispatcher;

  private PolymorphicDispatcher<Boolean> voidFunDispatcher;

  private PolymorphicDispatcher<EClass> objectClassDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    isValueDispatcher = buildPolymorphicDispatcher(
    	"isValueImpl", 3);
    voidFunDispatcher = buildPolymorphicDispatcher(
    	"voidFunImpl", 2);
    objectClassDispatcher = buildPolymorphicDispatcher(
    	"objectClassImpl", 2);
  }

  public Boolean isValue(final EObject o, final EClass c) throws RuleFailedException {
    return isValue(null, o, c);
  }

  public Boolean isValue(final RuleApplicationTrace _trace_, final EObject o, final EClass c) throws RuleFailedException {
    try {
    	return isValueInternal(_trace_, o, c);
    } catch (Exception _e_isValue) {
    	throw extractRuleFailedException(_e_isValue);
    }
  }

  public Boolean voidFun(final EObject o) throws RuleFailedException {
    return voidFun(null, o);
  }

  public Boolean voidFun(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	return voidFunInternal(_trace_, o);
    } catch (Exception _e_voidFun) {
    	throw extractRuleFailedException(_e_voidFun);
    }
  }

  public EClass objectClass(final EObject o) throws RuleFailedException {
    return objectClass(null, o);
  }

  public EClass objectClass(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	return objectClassInternal(_trace_, o);
    } catch (Exception _e_objectClass) {
    	throw extractRuleFailedException(_e_objectClass);
    }
  }

  protected Boolean isValueInternal(final RuleApplicationTrace _trace_, final EObject o, final EClass c) {
    try {
    	checkParamsNotNull(o, c);
    	return isValueDispatcher.invoke(_trace_, o, c);
    } catch (Exception _e_isValue) {
    	return false;
    }
  }

  protected void isValueThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final EClass c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Boolean voidFunInternal(final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return voidFunDispatcher.invoke(_trace_, o);
    } catch (Exception _e_voidFun) {
    	sneakyThrowRuleFailedException(_e_voidFun);
    	return false;
    }
  }

  protected void voidFunThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected EClass objectClassInternal(final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return objectClassDispatcher.invoke(_trace_, o);
    } catch (Exception _e_objectClass) {
    	sneakyThrowRuleFailedException(_e_objectClass);
    	return null;
    }
  }

  protected void objectClassThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String error = "error in objectClass";
    EObject source = o;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }

  protected Boolean isValueImpl(final RuleApplicationTrace _trace_, final EObject eO, final EClass eC) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunIsValue(_subtrace_, eO, eC);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("isValue") + "(" + stringRep(eO) + ", " + stringRep(eC)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunIsValue) {
    	isValueThrowException(auxFunName("isValue") + "(" + stringRep(eO) + ", " + stringRep(eC)+ ")",
    		ISVALUE,
    		e_applyAuxFunIsValue, eO, eC, new ErrorInformation[] {new ErrorInformation(eO), new ErrorInformation(eC)});
    	return false;
    }
  }

  protected Boolean applyAuxFunIsValue(final RuleApplicationTrace _trace_, final EObject eO, final EClass eC) throws RuleFailedException {
    EClass _eClass = eO.eClass();
    boolean _equals = Objects.equal(_eClass, eC);
    /* eO.eClass == eC */
    if (!Boolean.valueOf(_equals)) {
      sneakyThrowRuleFailedException("eO.eClass == eC");
    }
    return Boolean.valueOf(_equals);
  }

  protected EClass objectClassImpl(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final EClass _result_ = applyAuxFunObjectClass(_subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("objectClass") + "(" + stringRep(o)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunObjectClass) {
    	objectClassThrowException(auxFunName("objectClass") + "(" + stringRep(o)+ ")",
    		OBJECTCLASS,
    		e_applyAuxFunObjectClass, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected EClass applyAuxFunObjectClass(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    return o.eClass();
  }

  protected Boolean voidFunImpl(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunVoidFun(_subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("voidFun") + "(" + stringRep(o)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunVoidFun) {
    	voidFunThrowException(auxFunName("voidFun") + "(" + stringRep(o)+ ")",
    		VOIDFUN,
    		e_applyAuxFunVoidFun, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return false;
    }
  }

  protected Boolean applyAuxFunVoidFun(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    InputOutput.<EObject>println(o);
    /* true */
    if (!true) {
      sneakyThrowRuleFailedException("true");
    }
    return true;
  }

  protected Boolean voidFunImpl(final RuleApplicationTrace _trace_, final EStructuralFeature o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunVoidFun(_subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("voidFun") + "(" + stringRep(o)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunVoidFun) {
    	voidFunThrowException(auxFunName("voidFun") + "(" + stringRep(o)+ ")",
    		VOIDFUN,
    		e_applyAuxFunVoidFun, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return false;
    }
  }

  protected Boolean applyAuxFunVoidFun(final RuleApplicationTrace _trace_, final EStructuralFeature o) throws RuleFailedException {
    InputOutput.<EStructuralFeature>println(o);
    return true;
  }
}
'''
		)
	}

	@Test
	def testAuxiliaryFunctionsInvocation() {
		testFiles.testAuxiliaryFunctionsInvocation.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String OBJECTCLASS = "org.eclipse.xsemantics.test.ObjectClass";

  public static final String EOBJECTECLASS = "org.eclipse.xsemantics.test.EObjectEClass";

  private PolymorphicDispatcher<EClass> objectClassDispatcher;

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    objectClassDispatcher = buildPolymorphicDispatcher(
    	"objectClassImpl", 2);
  }

  public EClass objectClass(final EObject o) throws RuleFailedException {
    return objectClass(null, o);
  }

  public EClass objectClass(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	return objectClassInternal(_trace_, o);
    } catch (Exception _e_objectClass) {
    	throw extractRuleFailedException(_e_objectClass);
    }
  }

  public Result<EClass> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  public Result<Boolean> checkEObject(final EObject o) {
    return checkEObject(null, o);
  }

  public Result<Boolean> checkEObject(final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return checkEObjectInternal(_trace_, o);
    } catch (Exception _e_CheckEObject) {
    	return resultForFailure(_e_CheckEObject);
    }
  }

  protected Result<Boolean> checkEObjectInternal(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    EClass _objectClass = this.objectClassInternal(_trace_, o);
    /* objectClass(o) != null */
    if (!(!Objects.equal(_objectClass, null))) {
      sneakyThrowRuleFailedException("objectClass(o) != null");
    }
    return new Result<Boolean>(true);
  }

  protected EClass objectClassInternal(final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return objectClassDispatcher.invoke(_trace_, o);
    } catch (Exception _e_objectClass) {
    	sneakyThrowRuleFailedException(_e_objectClass);
    	return null;
    }
  }

  protected void objectClassThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String error = "error in objectClass()";
    EObject source = o;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return typeDispatcher.invoke(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected EClass objectClassImpl(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final EClass _result_ = applyAuxFunObjectClass(_subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("objectClass") + "(" + stringRep(o)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunObjectClass) {
    	objectClassThrowException(auxFunName("objectClass") + "(" + stringRep(o)+ ")",
    		OBJECTCLASS,
    		e_applyAuxFunObjectClass, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected EClass applyAuxFunObjectClass(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    return o.eClass();
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	typeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    EClass c = null; // output parameter
    this.objectClassInternal(_trace_, o);
    c = this.objectClassInternal(_trace_, o);
    return new Result<EClass>(c);
  }
}
'''
		)
	}

	@Test
	def testInstanceOfAsPremise_Issue_1() {
		testFiles.testInstanceOfAsPremise_Issue_1.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String TESTRULE = "org.eclipse.xsemantics.test.TestRule";

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public Result<EClass> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return typeDispatcher.invoke(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleTestRule(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TestRule") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTestRule) {
    	typeThrowException(ruleName("TestRule") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
    		TESTRULE,
    		e_applyRuleTestRule, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleTestRule(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    EClass c = null; // output parameter
    /* o instanceof EClass */
    if (!(o instanceof EClass)) {
      sneakyThrowRuleFailedException("o instanceof EClass");
    }
    return new Result<EClass>(c);
  }
}
'''
		)
	}

	@Test
	def testOperatorsWithSlashes_Issue_6() {
		testFiles.testOperatorsWithSlashes_Issue_6.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String UNIONRULE = "org.eclipse.xsemantics.test.UnionRule";

  public static final String INTERSECTIONRULE = "org.eclipse.xsemantics.test.IntersectionRule";

  private PolymorphicDispatcher<Result<Boolean>> typeUnionDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> typeIntersectionDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeUnionDispatcher = buildPolymorphicDispatcher1(
    	"typeUnionImpl", 4, "||-", "\\/");
    typeIntersectionDispatcher = buildPolymorphicDispatcher1(
    	"typeIntersectionImpl", 4, "||-", "/\\");
  }

  public Result<Boolean> typeUnion(final EClass c, final EObject o) {
    return typeUnion(new RuleEnvironment(), null, c, o);
  }

  public Result<Boolean> typeUnion(final RuleEnvironment _environment_, final EClass c, final EObject o) {
    return typeUnion(_environment_, null, c, o);
  }

  public Result<Boolean> typeUnion(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	return typeUnionInternal(_environment_, _trace_, c, o);
    } catch (Exception _e_typeUnion) {
    	return resultForFailure(_e_typeUnion);
    }
  }

  public Boolean typeUnionSucceeded(final EClass c, final EObject o) {
    return typeUnionSucceeded(new RuleEnvironment(), null, c, o);
  }

  public Boolean typeUnionSucceeded(final RuleEnvironment _environment_, final EClass c, final EObject o) {
    return typeUnionSucceeded(_environment_, null, c, o);
  }

  public Boolean typeUnionSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	typeUnionInternal(_environment_, _trace_, c, o);
    	return true;
    } catch (Exception _e_typeUnion) {
    	return false;
    }
  }

  public Result<Boolean> typeIntersection(final EClass c, final EObject o) {
    return typeIntersection(new RuleEnvironment(), null, c, o);
  }

  public Result<Boolean> typeIntersection(final RuleEnvironment _environment_, final EClass c, final EObject o) {
    return typeIntersection(_environment_, null, c, o);
  }

  public Result<Boolean> typeIntersection(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	return typeIntersectionInternal(_environment_, _trace_, c, o);
    } catch (Exception _e_typeIntersection) {
    	return resultForFailure(_e_typeIntersection);
    }
  }

  public Boolean typeIntersectionSucceeded(final EClass c, final EObject o) {
    return typeIntersectionSucceeded(new RuleEnvironment(), null, c, o);
  }

  public Boolean typeIntersectionSucceeded(final RuleEnvironment _environment_, final EClass c, final EObject o) {
    return typeIntersectionSucceeded(_environment_, null, c, o);
  }

  public Boolean typeIntersectionSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	typeIntersectionInternal(_environment_, _trace_, c, o);
    	return true;
    } catch (Exception _e_typeIntersection) {
    	return false;
    }
  }

  protected Result<Boolean> typeUnionInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	checkParamsNotNull(c, o);
    	return typeUnionDispatcher.invoke(_environment_, _trace_, c, o);
    } catch (Exception _e_typeUnion) {
    	sneakyThrowRuleFailedException(_e_typeUnion);
    	return null;
    }
  }

  protected void typeUnionThrowException(final String _error, final String _issue, final Exception _ex, final EClass c, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> typeIntersectionInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	checkParamsNotNull(c, o);
    	return typeIntersectionDispatcher.invoke(_environment_, _trace_, c, o);
    } catch (Exception _e_typeIntersection) {
    	sneakyThrowRuleFailedException(_e_typeIntersection);
    	return null;
    }
  }

  protected void typeIntersectionThrowException(final String _error, final String _issue, final Exception _ex, final EClass c, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> typeUnionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleUnionRule(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("UnionRule") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " \\/ " + stringRep(object);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnionRule) {
    	typeUnionThrowException(ruleName("UnionRule") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " \\/ " + stringRep(object),
    		UNIONRULE,
    		e_applyRuleUnionRule, eClass, object, new ErrorInformation[] {new ErrorInformation(eClass), new ErrorInformation(object)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleUnionRule(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {
    /* G ||- object.eClass /\ eClass */
    EClass _eClass = object.eClass();
    typeIntersectionInternal(G, _trace_, _eClass, eClass);
    /* G ||- object.eClass \/ eClass */
    EClass _eClass_1 = object.eClass();
    typeUnionInternal(G, _trace_, _eClass_1, eClass);
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> typeIntersectionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleIntersectionRule(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("IntersectionRule") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " /\\ " + stringRep(object);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleIntersectionRule) {
    	typeIntersectionThrowException(ruleName("IntersectionRule") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " /\\ " + stringRep(object),
    		INTERSECTIONRULE,
    		e_applyRuleIntersectionRule, eClass, object, new ErrorInformation[] {new ErrorInformation(eClass), new ErrorInformation(object)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleIntersectionRule(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {
    /* G ||- object.eClass /\ eClass */
    EClass _eClass = object.eClass();
    typeIntersectionInternal(G, _trace_, _eClass, eClass);
    /* G ||- object.eClass \/ eClass */
    EClass _eClass_1 = object.eClass();
    typeUnionInternal(G, _trace_, _eClass_1, eClass);
    return new Result<Boolean>(true);
  }
}
'''
		)
	}

	@Test
	def testForLambdaWithAuxiliaryFunctionWithNoSideEffect() {
		testFiles.testForLambdaWithAuxiliaryFunctionWithNoSideEffect.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String OVERRIDES = "org.eclipse.xsemantics.test.Overrides";

  public static final String ISVALUE = "org.eclipse.xsemantics.test.IsValue";

  public static final String TESTFORCLOSURES = "org.eclipse.xsemantics.test.TestForClosures";

  private PolymorphicDispatcher<Boolean> overridesDispatcher;

  private PolymorphicDispatcher<Boolean> isValueDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-");
    overridesDispatcher = buildPolymorphicDispatcher(
    	"overridesImpl", 2);
    isValueDispatcher = buildPolymorphicDispatcher(
    	"isValueImpl", 2);
  }

  public Boolean overrides(final EObject c) throws RuleFailedException {
    return overrides(null, c);
  }

  public Boolean overrides(final RuleApplicationTrace _trace_, final EObject c) throws RuleFailedException {
    try {
    	return overridesInternal(_trace_, c);
    } catch (Exception _e_overrides) {
    	throw extractRuleFailedException(_e_overrides);
    }
  }

  public Boolean isValue(final EObject c) throws RuleFailedException {
    return isValue(null, c);
  }

  public Boolean isValue(final RuleApplicationTrace _trace_, final EObject c) throws RuleFailedException {
    try {
    	return isValueInternal(_trace_, c);
    } catch (Exception _e_isValue) {
    	throw extractRuleFailedException(_e_isValue);
    }
  }

  public Result<Boolean> type(final EClass c) {
    return type(new RuleEnvironment(), null, c);
  }

  public Result<Boolean> type(final RuleEnvironment _environment_, final EClass c) {
    return type(_environment_, null, c);
  }

  public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  public Boolean typeSucceeded(final EClass c) {
    return typeSucceeded(new RuleEnvironment(), null, c);
  }

  public Boolean typeSucceeded(final RuleEnvironment _environment_, final EClass c) {
    return typeSucceeded(_environment_, null, c);
  }

  public Boolean typeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	typeInternal(_environment_, _trace_, c);
    	return true;
    } catch (Exception _e_type) {
    	return false;
    }
  }

  protected Boolean overridesInternal(final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	checkParamsNotNull(c);
    	return overridesDispatcher.invoke(_trace_, c);
    } catch (Exception _e_overrides) {
    	sneakyThrowRuleFailedException(_e_overrides);
    	return false;
    }
  }

  protected void overridesThrowException(final String _error, final String _issue, final Exception _ex, final EObject c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Boolean isValueInternal(final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	checkParamsNotNull(c);
    	return isValueDispatcher.invoke(_trace_, c);
    } catch (Exception _e_isValue) {
    	return false;
    }
  }

  protected void isValueThrowException(final String _error, final String _issue, final Exception _ex, final EObject c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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

  protected Boolean overridesImpl(final RuleApplicationTrace _trace_, final EClass c) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunOverrides(_subtrace_, c);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("overrides") + "(" + stringRep(c)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunOverrides) {
    	overridesThrowException(auxFunName("overrides") + "(" + stringRep(c)+ ")",
    		OVERRIDES,
    		e_applyAuxFunOverrides, c, new ErrorInformation[] {new ErrorInformation(c)});
    	return false;
    }
  }

  protected Boolean applyAuxFunOverrides(final RuleApplicationTrace _trace_, final EClass c) throws RuleFailedException {
    /* true */
    if (!true) {
      sneakyThrowRuleFailedException("true");
    }
    return true;
  }

  protected Boolean isValueImpl(final RuleApplicationTrace _trace_, final EClass c) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Boolean _result_ = applyAuxFunIsValue(_subtrace_, c);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("isValue") + "(" + stringRep(c)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunIsValue) {
    	isValueThrowException(auxFunName("isValue") + "(" + stringRep(c)+ ")",
    		ISVALUE,
    		e_applyAuxFunIsValue, c, new ErrorInformation[] {new ErrorInformation(c)});
    	return false;
    }
  }

  protected Boolean applyAuxFunIsValue(final RuleApplicationTrace _trace_, final EClass c) throws RuleFailedException {
    /* true */
    if (!Boolean.valueOf(true)) {
      sneakyThrowRuleFailedException("true");
    }
    return Boolean.valueOf(true);
  }

  protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleTestForClosures(G, _subtrace_, eClass);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TestForClosures") + stringRepForEnv(G) + " |- " + stringRep(eClass);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTestForClosures) {
    	typeThrowException(ruleName("TestForClosures") + stringRepForEnv(G) + " |- " + stringRep(eClass),
    		TESTFORCLOSURES,
    		e_applyRuleTestForClosures, eClass, new ErrorInformation[] {new ErrorInformation(eClass)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleTestForClosures(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    final Consumer<EStructuralFeature> _function = new Consumer<EStructuralFeature>() {
      @Override
      public void accept(final EStructuralFeature it) {
        TypeSystem.this.overridesInternal(_trace_, it);
      }
    };
    eClass.getEStructuralFeatures().forEach(_function);
    final Consumer<EStructuralFeature> _function_1 = new Consumer<EStructuralFeature>() {
      @Override
      public void accept(final EStructuralFeature it) {
        final Consumer<EStructuralFeature> _function = new Consumer<EStructuralFeature>() {
          @Override
          public void accept(final EStructuralFeature it_1) {
            TypeSystem.this.isValueInternal(_trace_, it_1);
          }
        };
        eClass.getEStructuralFeatures().forEach(_function);
      }
    };
    eClass.getEStructuralFeatures().forEach(_function_1);
    return new Result<Boolean>(true);
  }
}
'''
		)
	}

	@Test
	def testForScopeOfThis() {
		testFiles.testForScopeOfThis.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Provider;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String EOBJECTECLASS = "org.eclipse.xsemantics.test.EObjectEClass";

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public Result<EClass> type(final EObject c) {
    return type(new RuleEnvironment(), null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject c) {
    return type(_environment_, null, c);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  public Result<Boolean> eObjectEClassCheck(final EObject obj) {
    return eObjectEClassCheck(null, obj);
  }

  public Result<Boolean> eObjectEClassCheck(final RuleApplicationTrace _trace_, final EObject obj) {
    try {
    	return eObjectEClassCheckInternal(_trace_, obj);
    } catch (Exception _e_EObjectEClassCheck) {
    	return resultForFailure(_e_EObjectEClassCheck);
    }
  }

  protected Result<Boolean> eObjectEClassCheckInternal(final RuleApplicationTrace _trace_, final EObject obj) throws RuleFailedException {
    final EClass eClass = this.<EClass>clone(obj.eClass());
    return new Result<Boolean>(true);
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject c) {
    try {
    	checkParamsNotNull(c);
    	return typeDispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    EClass _clone = this.<EClass>clone(c.eClass());
    String _plus = ("this " + _clone);
    String _plus_1 = (_plus + " made an error!");
    String error = _plus_1;
    EObject _clone_1 = this.<EObject>clone(c);
    EObject source = _clone_1;
    EStructuralFeature _eContainingFeature = this.<EClass>clone(c.eClass()).eContainingFeature();
    EStructuralFeature feature = _eContainingFeature;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, feature));
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject obj) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, obj);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(obj) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	typeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(obj) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, obj, new ErrorInformation[] {new ErrorInformation(obj)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject obj) throws RuleFailedException {
    EClass eClass = null; // output parameter
    eClass = this.<EClass>clone(obj.eClass());
    final Consumer<EStructuralFeature> _function = new Consumer<EStructuralFeature>() {
      @Override
      public void accept(final EStructuralFeature it) {
        final EClass e = TypeSystem.this.<EClass>clone(obj.eClass());
        InputOutput.<EClass>println(e);
      }
    };
    eClass.getEAllStructuralFeatures().forEach(_function);
    return new Result<EClass>(eClass);
  }
}
'''
		)
	}

	@Test
	def testCaching() {
		testFiles.cachedDescriptions.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsProvider;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String ECLASSES = "org.eclipse.xsemantics.test.Eclasses";

  public static final String AUXNOCACHEENTRYPOINTS = "org.eclipse.xsemantics.test.AuxnocacheentryPoints";

  private PolymorphicDispatcher<List<EClass>> eclassesDispatcher;

  private PolymorphicDispatcher<Boolean> auxnocacheentryPointsDispatcher;

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  private PolymorphicDispatcher<Result<EClass>> nocacheentryPointsDispatcher;

  private PolymorphicDispatcher<Result<EClass>> withCacheConditionDispatcher;

  private PolymorphicDispatcher<Result<EClass>> withCacheConditionBlockDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    nocacheentryPointsDispatcher = buildPolymorphicDispatcher1(
    	"nocacheentryPointsImpl", 3, "||-", ":");
    withCacheConditionDispatcher = buildPolymorphicDispatcher1(
    	"withCacheConditionImpl", 3, "|=", ":");
    withCacheConditionBlockDispatcher = buildPolymorphicDispatcher1(
    	"withCacheConditionBlockImpl", 3, "|=", ":>");
    eclassesDispatcher = buildPolymorphicDispatcher(
    	"eclassesImpl", 2);
    auxnocacheentryPointsDispatcher = buildPolymorphicDispatcher(
    	"auxnocacheentryPointsImpl", 2);
  }

  public List<EClass> eclasses(final EObject o) throws RuleFailedException {
    return eclasses(null, o);
  }

  public List<EClass> eclasses(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	return eclassesInternal(_trace_, o);
    } catch (Exception _e_eclasses) {
    	throw extractRuleFailedException(_e_eclasses);
    }
  }

  public Boolean auxnocacheentryPoints(final EObject o) throws RuleFailedException {
    return auxnocacheentryPoints(null, o);
  }

  public Boolean auxnocacheentryPoints(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	return auxnocacheentryPointsInternal(_trace_, o);
    } catch (Exception _e_auxnocacheentryPoints) {
    	throw extractRuleFailedException(_e_auxnocacheentryPoints);
    }
  }

  public Result<EClass> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    return getFromCache("type", _environment_, _trace_,
    	new XsemanticsProvider<Result<EClass>>(_environment_, _trace_) {
    		public Result<EClass> doGet() {
    			try {
    				return typeInternal(_environment_, _trace_, o);
    			} catch (Exception _e_type) {
    				return resultForFailure(_e_type);
    			}
    		}
    	}, o);
  }

  public Result<EClass> nocacheentryPoints(final EObject o) {
    return nocacheentryPoints(new RuleEnvironment(), null, o);
  }

  public Result<EClass> nocacheentryPoints(final RuleEnvironment _environment_, final EObject o) {
    return nocacheentryPoints(_environment_, null, o);
  }

  public Result<EClass> nocacheentryPoints(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return nocacheentryPointsInternal(_environment_, _trace_, o);
    } catch (Exception _e_nocacheentryPoints) {
    	return resultForFailure(_e_nocacheentryPoints);
    }
  }

  public Result<EClass> withCacheCondition(final EObject o) {
    return withCacheCondition(new RuleEnvironment(), null, o);
  }

  public Result<EClass> withCacheCondition(final RuleEnvironment _environment_, final EObject o) {
    return withCacheCondition(_environment_, null, o);
  }

  public Result<EClass> withCacheCondition(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    if (!withCacheConditionCacheCondition(_environment_, o))
    	try {
    		return withCacheConditionInternal(_environment_, _trace_, o);
    	} catch (Exception _e_withCacheCondition) {
    		return resultForFailure(_e_withCacheCondition);
    	}
    return getFromCache("withCacheCondition", _environment_, _trace_,
    	new XsemanticsProvider<Result<EClass>>(_environment_, _trace_) {
    		public Result<EClass> doGet() {
    			try {
    				return withCacheConditionInternal(_environment_, _trace_, o);
    			} catch (Exception _e_withCacheCondition) {
    				return resultForFailure(_e_withCacheCondition);
    			}
    		}
    	}, o);
  }

  public Result<EClass> withCacheConditionBlock(final EObject o) {
    return withCacheConditionBlock(new RuleEnvironment(), null, o);
  }

  public Result<EClass> withCacheConditionBlock(final RuleEnvironment _environment_, final EObject o) {
    return withCacheConditionBlock(_environment_, null, o);
  }

  public Result<EClass> withCacheConditionBlock(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    if (!withCacheConditionBlockCacheCondition(_environment_, o))
    	try {
    		return withCacheConditionBlockInternal(_environment_, _trace_, o);
    	} catch (Exception _e_withCacheConditionBlock) {
    		return resultForFailure(_e_withCacheConditionBlock);
    	}
    return getFromCache("withCacheConditionBlock", _environment_, _trace_,
    	new XsemanticsProvider<Result<EClass>>(_environment_, _trace_) {
    		public Result<EClass> doGet() {
    			try {
    				return withCacheConditionBlockInternal(_environment_, _trace_, o);
    			} catch (Exception _e_withCacheConditionBlock) {
    				return resultForFailure(_e_withCacheConditionBlock);
    			}
    		}
    	}, o);
  }

  protected List<EClass> eclassesInternal(final RuleApplicationTrace _trace_, final EObject o) {
    return getFromCache("eclassesInternal", (RuleEnvironment)null, _trace_,
    	new XsemanticsProvider<List<EClass>>(null, _trace_) {
    		public List<EClass> doGet() {
    			try {
    				checkParamsNotNull(o);
    				return eclassesDispatcher.invoke(_trace_, o);
    			} catch (Exception _e_eclasses) {
    				sneakyThrowRuleFailedException(_e_eclasses);
    				return null;
    			}
    		}
    	}, o);
  }

  protected void eclassesThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Boolean auxnocacheentryPointsInternal(final RuleApplicationTrace _trace_, final EObject o) {
    if (!auxnocacheentryPointsCacheCondition(o))
    	try {
    		checkParamsNotNull(o);
    		return auxnocacheentryPointsDispatcher.invoke(_trace_, o);
    	} catch (Exception _e_auxnocacheentryPoints) {
    		return false;
    	}
    return getFromCache("auxnocacheentryPointsInternal", (RuleEnvironment)null, _trace_,
    	new XsemanticsProvider<Boolean>(null, _trace_) {
    		public Boolean doGet() {
    			try {
    				checkParamsNotNull(o);
    				return auxnocacheentryPointsDispatcher.invoke(_trace_, o);
    			} catch (Exception _e_auxnocacheentryPoints) {
    				return false;
    			}
    		}
    	}, o);
  }

  protected void auxnocacheentryPointsThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Boolean auxnocacheentryPointsCacheCondition(final EObject o) {
    return Boolean.valueOf((!(o instanceof EClass)));
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    return getFromCache("typeInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<EClass>>(_environment_, _trace_) {
    		public Result<EClass> doGet() {
    			try {
    				checkParamsNotNull(o);
    				return typeDispatcher.invoke(_environment_, _trace_, o);
    			} catch (Exception _e_type) {
    				sneakyThrowRuleFailedException(_e_type);
    				return null;
    			}
    		}
    	}, o);
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> nocacheentryPointsInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    return getFromCache("nocacheentryPointsInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<EClass>>(_environment_, _trace_) {
    		public Result<EClass> doGet() {
    			try {
    				checkParamsNotNull(o);
    				return nocacheentryPointsDispatcher.invoke(_environment_, _trace_, o);
    			} catch (Exception _e_nocacheentryPoints) {
    				sneakyThrowRuleFailedException(_e_nocacheentryPoints);
    				return null;
    			}
    		}
    	}, o);
  }

  protected void nocacheentryPointsThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> withCacheConditionInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    if (!withCacheConditionCacheCondition(_environment_, o))
    	try {
    		checkParamsNotNull(o);
    		return withCacheConditionDispatcher.invoke(_environment_, _trace_, o);
    	} catch (Exception _e_withCacheCondition) {
    		sneakyThrowRuleFailedException(_e_withCacheCondition);
    		return null;
    	}
    return getFromCache("withCacheConditionInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<EClass>>(_environment_, _trace_) {
    		public Result<EClass> doGet() {
    			try {
    				checkParamsNotNull(o);
    				return withCacheConditionDispatcher.invoke(_environment_, _trace_, o);
    			} catch (Exception _e_withCacheCondition) {
    				sneakyThrowRuleFailedException(_e_withCacheCondition);
    				return null;
    			}
    		}
    	}, o);
  }

  protected void withCacheConditionThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Boolean withCacheConditionCacheCondition(final RuleEnvironment environment, final EObject o) {
    return Boolean.valueOf(((!environment.isEmpty()) && (!(o instanceof EClass))));
  }

  protected Result<EClass> withCacheConditionBlockInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    if (!withCacheConditionBlockCacheCondition(_environment_, o))
    	try {
    		checkParamsNotNull(o);
    		return withCacheConditionBlockDispatcher.invoke(_environment_, _trace_, o);
    	} catch (Exception _e_withCacheConditionBlock) {
    		sneakyThrowRuleFailedException(_e_withCacheConditionBlock);
    		return null;
    	}
    return getFromCache("withCacheConditionBlockInternal", _environment_, _trace_,
    	new XsemanticsProvider<Result<EClass>>(_environment_, _trace_) {
    		public Result<EClass> doGet() {
    			try {
    				checkParamsNotNull(o);
    				return withCacheConditionBlockDispatcher.invoke(_environment_, _trace_, o);
    			} catch (Exception _e_withCacheConditionBlock) {
    				sneakyThrowRuleFailedException(_e_withCacheConditionBlock);
    				return null;
    			}
    		}
    	}, o);
  }

  protected void withCacheConditionBlockThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Boolean withCacheConditionBlockCacheCondition(final RuleEnvironment environment, final EObject o) {
    return Boolean.valueOf(((!environment.isEmpty()) && (!(o instanceof EClass))));
  }
}
'''
		)
	}

	@Test
	def testInjectedExtensions() {
		testFiles.testInjectedExtensionFields.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.dsl.tests.input.MyTestExtensions;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String EOBJECTECLASS = "org.eclipse.xsemantics.test.EObjectEClass";

  /**
   * a utility field
   */
  @Extension
  @Inject
  private MyTestExtensions myextensions;

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public MyTestExtensions getMyextensions() {
    return this.myextensions;
  }

  public void setMyextensions(final MyTestExtensions myextensions) {
    this.myextensions = myextensions;
  }

  public Result<EClass> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return typeDispatcher.invoke(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	typeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    EClass c = null; // output parameter
    final ArrayList<Object> list = CollectionLiterals.<Object>newArrayList();
    this.myextensions.printList(list);
    return new Result<EClass>(c);
  }
}
'''
		)
	}

	@Test
	def testFields() {
		testFiles.testFields.assertCorrectJavaCodeGeneration(
			'''
package org.eclipse.xsemantics.test;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.dsl.tests.input.MyTestExtensions;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public static final String EOBJECTECLASS = "org.eclipse.xsemantics.test.EObjectEClass";

  /**
   * a utility field with annotation
   */
  @Extension
  @Inject
  private MyTestExtensions myextensions;

  /**
   * final field
   */
  private final MyTestExtensions finalField = new MyTestExtensions();

  /**
   * non final field
   */
  private MyTestExtensions nonFinalField = new MyTestExtensions();

  /**
   * inferred type for field
   */
  private MyTestExtensions inferredTypeField = new MyTestExtensions();

  private PolymorphicDispatcher<Result<EClass>> typeDispatcher;

  public TypeSystem() {
    init();
  }

  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }

  public MyTestExtensions getMyextensions() {
    return this.myextensions;
  }

  public void setMyextensions(final MyTestExtensions myextensions) {
    this.myextensions = myextensions;
  }

  public MyTestExtensions getFinalField() {
    return this.finalField;
  }

  public MyTestExtensions getNonFinalField() {
    return this.nonFinalField;
  }

  public void setNonFinalField(final MyTestExtensions nonFinalField) {
    this.nonFinalField = nonFinalField;
  }

  public MyTestExtensions getInferredTypeField() {
    return this.inferredTypeField;
  }

  public void setInferredTypeField(final MyTestExtensions inferredTypeField) {
    this.inferredTypeField = inferredTypeField;
  }

  public Result<EClass> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }

  public Result<EClass> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }

  protected Result<EClass> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return typeDispatcher.invoke(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }

  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
    	typeThrowException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
    		EOBJECTECLASS,
    		e_applyRuleEObjectEClass, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }

  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    EClass c = null; // output parameter
    final ArrayList<Object> list = CollectionLiterals.<Object>newArrayList();
    this.myextensions.printList(list);
    return new Result<EClass>(c);
  }
}
'''
		)
	}

	def private assertCorrectJavaCodeGeneration(CharSequence input, CharSequence expected) {
		assertCorrectJavaCodeGeneration(input, expected, null)
	}

	def private assertCorrectJavaCodeGeneration(CharSequence input, CharSequence expected,
		CharSequence expectedValidator) {
		input.compile [
			assertNoValidationErrors

			for (e : allGeneratedResources.entrySet) {
				if (e.key.endsWith("Validator.java") && expectedValidator !== null) {
					// check the expected Java code for the validator
					assertEqualsStrings(expectedValidator, e.value)
				} else if (!e.key.endsWith("Validator.java") && expected !== null) {
					// check the expected Java code for the system
					assertEqualsStrings(expected, e.value)
				}
			}

			// this will issue Java generation
			compiledClass
		]
	}

	def private assertCorrectJavaCodeGeneration(
		List<CharSequence> inputs,
		String prefix,
		CharSequence expected,
		CharSequence expectedValidator
	) {
		inputs.createResourceSet.compile [
			assertNoValidationErrors

			for (e : allGeneratedResources.entrySet) {
				if (prefix === null || e.key.contains(prefix)) {
					if (e.key.endsWith("Validator.java") && expectedValidator !== null) {
						// check the expected Java code for the validator
						assertEqualsStrings(expectedValidator, e.value)
					} else if (!e.key.endsWith("Validator.java") && expected !== null) {
						// check the expected Java code for the system
						assertEqualsStrings(expected, e.value)
					}
				}
			}

			// this will issue Java generation
			compiledClass
		]
	}

	def private createResourceSet(List<CharSequence> inputs) {
		val pairs = newArrayList() => [ list |
			inputs.forEach [ e, i |
				list += "MyFile" + i + "." + extensionProvider.getPrimaryFileExtension() -> e
			]
		]
		resourceSet(pairs)
	}

}
