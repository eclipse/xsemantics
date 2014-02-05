package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsCompilationTestHelper
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import it.xsemantics.dsl.xsemantics.XsemanticsSystem

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsJvmModelGeneratorTest extends XsemanticsBaseTest {
	
	@Inject extension XsemanticsCompilationTestHelper
	
	@Test
	def testJudgmentDescriptions() {
		testFiles.testJudgmentDescriptions.assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.List;
import java.util.Set;
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
	def testSimpleRule() {
		testFiles.testSimpleRule.assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import com.google.common.base.Objects;
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
  public final static String ECLASSEOBJECT = "it.xsemantics.test.rules.EClassEObject";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object));
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
package it.xsemantics.test;

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
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECTESTRUCTURALFEATURE = "it.xsemantics.test.rules.EClassEObjectEStructuralFeature";
  
  private PolymorphicDispatcher<Result<EObject>> typeDispatcher;
  
  private PolymorphicDispatcher<Result2<EObject,EStructuralFeature>> type2Dispatcher;
  
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
  
  public Result2<EObject,EStructuralFeature> type2(final EClass c) {
    return type2(new RuleEnvironment(), null, c);
  }
  
  public Result2<EObject,EStructuralFeature> type2(final RuleEnvironment _environment_, final EClass c) {
    return type2(_environment_, null, c);
  }
  
  public Result2<EObject,EStructuralFeature> type2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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
  
  protected Result2<EObject,EStructuralFeature> type2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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
  
  protected Result2<EObject,EStructuralFeature> type2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<EObject, EStructuralFeature> _result_ = applyRuleEClassEObjectEStructuralFeature(G, _subtrace_, eClass);
    	addToTrace(_trace_, ruleName("EClassEObjectEStructuralFeature") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEClassEObjectEStructuralFeature) {
    	type2ThrowException(ruleName("EClassEObjectEStructuralFeature") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + "EObject" + " : " + "EStructuralFeature",
    		ECLASSEOBJECTESTRUCTURALFEATURE,
    		e_applyRuleEClassEObjectEStructuralFeature, eClass, new ErrorInformation[] {new ErrorInformation(eClass)});
    	return null;
    }
  }
  
  protected Result2<EObject,EStructuralFeature> applyRuleEClassEObjectEStructuralFeature(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    EObject object = null; // output parameter
    EStructuralFeature feat = null; // output parameter
    /* G ||- eClass : object : feat */
    Result2<EObject,EStructuralFeature> result = type2Internal(G, _trace_, eClass);
    checkAssignableTo(result.getFirst(), EObject.class);
    object = (EObject) result.getFirst();
    checkAssignableTo(result.getSecond(), EStructuralFeature.class);
    feat = (EStructuralFeature) result.getSecond();
    
    return new Result2<EObject,EStructuralFeature>(object, feat);
  }
}
'''
		)
	}

	@Test
	def testRuleWith3OutputParams() {
		testFiles.testRuleWith3OutputParams.assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result3;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECTESTRUCTURALFEATURESTRING = "it.xsemantics.test.rules.EClassEObjectEStructuralFeatureString";
  
  private PolymorphicDispatcher<Result3<EObject,EStructuralFeature,String>> typeDispatcher;
  
  public TypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher3(
    	"typeImpl", 3, "|-", ":", ":", ":");
  }
  
  public Result3<EObject,EStructuralFeature,String> type(final EClass c) {
    return type(new RuleEnvironment(), null, c);
  }
  
  public Result3<EObject,EStructuralFeature,String> type(final RuleEnvironment _environment_, final EClass c) {
    return type(_environment_, null, c);
  }
  
  public Result3<EObject,EStructuralFeature,String> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure3(_e_type);
    }
  }
  
  protected Result3<EObject,EStructuralFeature,String> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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
  
  protected Result3<EObject,EStructuralFeature,String> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result3<EObject, EStructuralFeature, String> _result_ = applyRuleEClassEObjectEStructuralFeatureString(G, _subtrace_, eClass);
    	addToTrace(_trace_, ruleName("EClassEObjectEStructuralFeatureString") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond()) + " : " + stringRep(_result_.getThird()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEClassEObjectEStructuralFeatureString) {
    	typeThrowException(ruleName("EClassEObjectEStructuralFeatureString") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + "EObject" + " : " + "EStructuralFeature" + " : " + "String",
    		ECLASSEOBJECTESTRUCTURALFEATURESTRING,
    		e_applyRuleEClassEObjectEStructuralFeatureString, eClass, new ErrorInformation[] {new ErrorInformation(eClass)});
    	return null;
    }
  }
  
  protected Result3<EObject,EStructuralFeature,String> applyRuleEClassEObjectEStructuralFeatureString(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    EObject object = null; // output parameter
    EStructuralFeature feat = null; // output parameter
    String s = null; // output parameter
    /* G |- eClass : object : feat : s */
    Result3<EObject,EStructuralFeature,String> result = typeInternal(G, _trace_, eClass);
    checkAssignableTo(result.getFirst(), EObject.class);
    object = (EObject) result.getFirst();
    checkAssignableTo(result.getSecond(), EStructuralFeature.class);
    feat = (EStructuralFeature) result.getSecond();
    checkAssignableTo(result.getThird(), String.class);
    s = (String) result.getThird();
    
    return new Result3<EObject,EStructuralFeature,String>(object, feat, s);
  }
}
'''
		)
	}

	@Test
	def testRuleInvocationWithVariableDeclarationAsOutputParameter() {
		testFiles.testDuplicateVariableDeclarationAsOutputArgument.assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String EOBJECTECLASS = "it.xsemantics.test.rules.EObjectEClass";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
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
    try {
      EClass temp = c;
    } catch (Exception e) {
      /* G |- o : var EClass temp */
      EClass temp_1 = null;
      Result<EClass> result = typeInternal(G, _trace_, o);
      checkAssignableTo(result.getFirst(), EClass.class);
      temp_1 = (EClass) result.getFirst();
      
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
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
    EClass _eClass = c.eClass();
    EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();
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
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String EOBJECTECLASS = "it.xsemantics.test.rules.EObjectEClass";
  
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
    } catch (Exception e) {
    	return resultForFailure(e);
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, object);
    	addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(object) + " : " + stringRep(_result_.getFirst()));
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
package it.xsemantics.test.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import it.xsemantics.test.TypeSystem;
import org.eclipse.emf.ecore.EObject;
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
package it.xsemantics.test;

import com.google.inject.Inject;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String EOBJECTECLASS = "it.xsemantics.test.rules.EObjectEClass";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
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
    EClass _eClass = o.eClass();
    /* eClasses.add(o.eClass) */
    if (!this.eClasses.add(_eClass)) {
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
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result2;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String TWOEXPRESSIONSINCONCLUSION = "it.xsemantics.test.rules.TwoExpressionsInConclusion";
  
  private PolymorphicDispatcher<Result2<EObject,EStructuralFeature>> typeDispatcher;
  
  public TypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher2(
    	"typeImpl", 3, "|-", ":", ":");
  }
  
  public Result2<EObject,EStructuralFeature> type(final EClass c) {
    return type(new RuleEnvironment(), null, c);
  }
  
  public Result2<EObject,EStructuralFeature> type(final RuleEnvironment _environment_, final EClass c) {
    return type(_environment_, null, c);
  }
  
  public Result2<EObject,EStructuralFeature> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure2(_e_type);
    }
  }
  
  protected Result2<EObject,EStructuralFeature> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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
  
  protected Result2<EObject,EStructuralFeature> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<EObject, EStructuralFeature> _result_ = applyRuleTwoExpressionsInConclusion(G, _subtrace_, cl);
    	addToTrace(_trace_, ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTwoExpressionsInConclusion) {
    	typeThrowException(ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + "EClass" + " : " + "EStructuralFeature",
    		TWOEXPRESSIONSINCONCLUSION,
    		e_applyRuleTwoExpressionsInConclusion, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }
  
  protected Result2<EObject,EStructuralFeature> applyRuleTwoExpressionsInConclusion(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    
    return new Result2<EObject,EStructuralFeature>(_applyRuleTwoExpressionsInConclusion_1(G, cl), _applyRuleTwoExpressionsInConclusion_2(G, cl));
  }
  
  private EClass _applyRuleTwoExpressionsInConclusion_1(final RuleEnvironment G, final EClass cl) throws RuleFailedException {
    return cl;
  }
  
  private EStructuralFeature _applyRuleTwoExpressionsInConclusion_2(final RuleEnvironment G, final EClass cl) throws RuleFailedException {
    EList<EStructuralFeature> _eAllStructuralFeatures = cl.getEAllStructuralFeatures();
    EStructuralFeature _head = IterableExtensions.<EStructuralFeature>head(_eAllStructuralFeatures);
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
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result2;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String TWOEXPRESSIONSINCONCLUSION = "it.xsemantics.test.rules.TwoExpressionsInConclusion";
  
  private PolymorphicDispatcher<Result2<EObject,EStructuralFeature>> typeDispatcher;
  
  public TypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher2(
    	"typeImpl", 3, "|-", ":", ":");
  }
  
  public Result2<EObject,EStructuralFeature> type(final EClass c) {
    return type(new RuleEnvironment(), null, c);
  }
  
  public Result2<EObject,EStructuralFeature> type(final RuleEnvironment _environment_, final EClass c) {
    return type(_environment_, null, c);
  }
  
  public Result2<EObject,EStructuralFeature> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure2(_e_type);
    }
  }
  
  protected Result2<EObject,EStructuralFeature> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
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
  
  protected Result2<EObject,EStructuralFeature> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result2<EObject, EStructuralFeature> _result_ = applyRuleTwoExpressionsInConclusion(G, _subtrace_, cl);
    	addToTrace(_trace_, ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTwoExpressionsInConclusion) {
    	typeThrowException(ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + "EClass" + " : " + "EStructuralFeature",
    		TWOEXPRESSIONSINCONCLUSION,
    		e_applyRuleTwoExpressionsInConclusion, cl, new ErrorInformation[] {new ErrorInformation(cl)});
    	return null;
    }
  }
  
  protected Result2<EObject,EStructuralFeature> applyRuleTwoExpressionsInConclusion(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    String _name = cl.getName();
    InputOutput.<String>println(_name);
    return new Result2<EObject,EStructuralFeature>(_applyRuleTwoExpressionsInConclusion_1(G, cl), _applyRuleTwoExpressionsInConclusion_2(G, cl));
  }
  
  private EClass _applyRuleTwoExpressionsInConclusion_1(final RuleEnvironment G, final EClass cl) throws RuleFailedException {
    return cl;
  }
  
  private EStructuralFeature _applyRuleTwoExpressionsInConclusion_2(final RuleEnvironment G, final EClass cl) throws RuleFailedException {
    EList<EStructuralFeature> _eAllStructuralFeatures = cl.getEAllStructuralFeatures();
    EStructuralFeature _head = IterableExtensions.<EStructuralFeature>head(_eAllStructuralFeatures);
    return _head;
  }
}
'''
		)
	}

	@Test
	def testAccessToEnvInExpressionsInConclusion() {
		testFiles.testEnvInExpressionInConclusion.assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String EOBJECTECLASS = "it.xsemantics.test.rules.EObjectEClass";
  
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
  
  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject object) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, object);
    	addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(object) + " : " + stringRep(_result_.getFirst()));
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
    /* env(G, "this", EClass) */
    EClass _environmentaccess = environmentAccess(G, "this", EClass.class);
    return _environmentaccess;
  }
}
'''
		)
	}
	
	@Test
	def testAccessToThisInExpressionsInConclusion() {
		testFiles.testAccessToThisInExpressionInConclusion.assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import com.google.inject.Inject;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String EOBJECTECLASS = "it.xsemantics.test.rules.EObjectEClass";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
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
      EObject _clone = this.<EObject>clone(o);
      _xblockexpression = (_clone.eClass());
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
package it.xsemantics.test;

import com.google.inject.Inject;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String EOBJECTECLASS = "it.xsemantics.test.rules.EObjectEClass";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
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
		testFiles.testOrExpressionWithBlocks.assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import com.google.common.base.Objects;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECT = "it.xsemantics.test.rules.EClassEObject";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object));
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
    /* {eClass.name == 'foo' eClass.name == 'foo'} or {object.eClass.name == 'bar' object.eClass.name == 'bar'} */
    try {
      String _name = eClass.getName();
      boolean _equals = Objects.equal(_name, "foo");
      /* eClass.name == 'foo' */
      if (!_equals) {
        sneakyThrowRuleFailedException("eClass.name == \'foo\'");
      }
      String _name_1 = eClass.getName();
      /* eClass.name == 'foo' */
      if (!Objects.equal(_name_1, "foo")) {
        sneakyThrowRuleFailedException("eClass.name == \'foo\'");
      }
    } catch (Exception e) {
      EClass _eClass = object.eClass();
      String _name_2 = _eClass.getName();
      boolean _equals_1 = Objects.equal(_name_2, "bar");
      /* object.eClass.name == 'bar' */
      if (!_equals_1) {
        sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
      }
      EClass _eClass_1 = object.eClass();
      String _name_3 = _eClass_1.getName();
      /* object.eClass.name == 'bar' */
      if (!Objects.equal(_name_3, "bar")) {
        sneakyThrowRuleFailedException("object.eClass.name == \'bar\'");
      }
    }
    return new Result<Boolean>(true);
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
package it.xsemantics.test.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import it.xsemantics.test.TypeSystem;
import org.eclipse.emf.ecore.EObject;
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
		testFiles.testJudgmentDescriptionsWithErrorSpecification.
			parseWithBaseSystemAndAssertNoError
			(
				testFiles.testSystemExtendsSystemWithJudgmentsReferringToEcore,
				testFiles.testSystemExtendsExtendedTypeSystem
			).assertCorrectJavaCodeGeneration(
"ExtendedTypeSystem2",
'''
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.test.ExtendedTypeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class ExtendedTypeSystem2 extends ExtendedTypeSystem {
  public final static String FROMTYPESYSTEM = "it.xsemantics.test.rules.FromTypeSystem";
  
  public final static String FROMEXTENDEDTYPESYSTEM = "it.xsemantics.test.rules.FromExtendedTypeSystem";
  
  public final static String FROMTHISTYPESYSTEM = "it.xsemantics.test.rules.FromThisTypeSystem";
  
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
    } catch (Exception e) {
    	return resultForFailure(e);
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleFromTypeSystem(G, _subtrace_, c);
    	addToTrace(_trace_, ruleName("FromTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + stringRep(_result_.getFirst()));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleFromExtendedTypeSystem(G, _subtrace_, c1, c2);
    	addToTrace(_trace_, ruleName("FromExtendedTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c1) + " <: " + stringRep(c2));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleFromThisTypeSystem(G, _subtrace_, c1, c2);
    	addToTrace(_trace_, ruleName("FromThisTypeSystem") + stringRepForEnv(G) + " ||- " + stringRep(c1) + " : " + stringRep(c2));
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
package it.xsemantics.test.validation;

import com.google.inject.Inject;
import it.xsemantics.test.ExtendedTypeSystem2;
import it.xsemantics.test.validation.ExtendedTypeSystemValidator;
import org.eclipse.emf.ecore.EObject;
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
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.test.ExtendedTypeSystem2;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class ExtendedTypeSystemWithRuleOverride extends ExtendedTypeSystem2 {
  public final static String FROMTYPESYSTEM = "it.xsemantics.test.rules.FromTypeSystem";
  
  public final static String FROMEXTENDEDTYPESYSTEM = "it.xsemantics.test.rules.FromExtendedTypeSystem";
  
  public final static String FROMTHISTYPESYSTEM = "it.xsemantics.test.rules.FromThisTypeSystem";
  
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
    } catch (Exception e) {
    	return resultForFailure(e);
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleFromTypeSystem(G, _subtrace_, c);
    	addToTrace(_trace_, ruleName("FromTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + stringRep(_result_.getFirst()));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleFromExtendedTypeSystem(G, _subtrace_, c1, c2);
    	addToTrace(_trace_, ruleName("FromExtendedTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c1) + " <: " + stringRep(c2));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleFromThisTypeSystem(G, _subtrace_, c1, c2);
    	addToTrace(_trace_, ruleName("FromThisTypeSystem") + stringRepForEnv(G) + " ||- " + stringRep(c1) + " : " + stringRep(c2));
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
package it.xsemantics.test.validation;

import com.google.inject.Inject;
import it.xsemantics.test.ExtendedTypeSystemWithRuleOverride;
import it.xsemantics.test.validation.ExtendedTypeSystem2Validator;
import org.eclipse.emf.ecore.EObject;
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
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.test.ExtendedTypeSystem2;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
    EClass _eClass = c1.eClass();
    EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();
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
		loadBaseSystems.
			parseWithBaseSystemAndAssertNoError(
				testFiles.testOverrideJudgmentWithDifferentParamNames
			).
		assertCorrectJavaCodeGeneration(
"ExtendedTypeSystemWithJudgmentOverride",
'''
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.test.ExtendedTypeSystem2;
import org.eclipse.emf.ecore.EClass;
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
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String TYPEEOBJECT = "it.xsemantics.test.rules.TypeEObject";
  
  public final static String TYPEECLASS = "it.xsemantics.test.rules.TypeEClass";
  
  public final static String SUBTYPEEOBJECT = "it.xsemantics.test.rules.SubtypeEObject";
  
  public final static String SUBTYPEESTRUCTURALFEATURE = "it.xsemantics.test.rules.SubtypeEStructuralFeature";
  
  public final static String SUBTYPEECLASS = "it.xsemantics.test.rules.SubtypeEClass";
  
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
    EClass _eClass = c.eClass();
    EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();
    EStructuralFeature feature = _eContainingFeature;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, feature));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleTypeEObject(G, _subtrace_, o);
    	addToTrace(_trace_, ruleName("TypeEObject") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleTypeEClass(G, _subtrace_, c);
    	addToTrace(_trace_, ruleName("TypeEClass") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + stringRep(_result_.getFirst()));
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
    EClass _eClass = c.eClass();
    EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();
    EStructuralFeature feature = _eContainingFeature;
    throwRuleFailedException(error,
    	TYPEECLASS, e_applyRuleTypeEClass, new ErrorInformation(source, feature));
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject left, final EObject right) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleSubtypeEObject(G, _subtrace_, left, right);
    	addToTrace(_trace_, ruleName("SubtypeEObject") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleSubtypeEStructuralFeature(G, _subtrace_, left, right);
    	addToTrace(_trace_, ruleName("SubtypeEStructuralFeature") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right));
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
    /* fail error "Unhandled case" source left */
    String error = "Unhandled case";
    EObject source = left;
    throwForExplicitFail(error, new ErrorInformation(source, null));
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass left, final EClass right) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleSubtypeEClass(G, _subtrace_, left, right);
    	addToTrace(_trace_, ruleName("SubtypeEClass") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right));
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
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String TYPE1 = "it.xsemantics.test.rules.Type1";
  
  public final static String TYPE2 = "it.xsemantics.test.rules.Type2";
  
  public final static String SUBTYPE1 = "it.xsemantics.test.rules.SubType1";
  
  public final static String SUBTYPE2 = "it.xsemantics.test.rules.SubType2";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleType1(G, _subtrace_, s1, i2);
    	addToTrace(_trace_, ruleName("Type1") + stringRepForEnv(G) + " |- " + stringRep(s1) + " : " + stringRep(i2));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleType2(G, _subtrace_, b1, i2);
    	addToTrace(_trace_, ruleName("Type2") + stringRepForEnv(G) + " |- " + stringRep(b1) + " : " + stringRep(i2));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleSubType1(G, _subtrace_, s1, i2);
    	addToTrace(_trace_, ruleName("SubType1") + stringRepForEnv(G) + " |- " + stringRep(s1) + " <: " + stringRep(i2));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleSubType2(G, _subtrace_, b1, i2);
    	addToTrace(_trace_, ruleName("SubType2") + stringRepForEnv(G) + " |- " + stringRep(b1) + " <: " + stringRep(i2));
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
package it.xsemantics.test;

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

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECT = "it.xsemantics.test.rules.EClassEObject";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object));
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
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECT = "it.xsemantics.test.rules.EClassEObject";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object));
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
    /* new it.xsemantics.runtime.RuleEnvironment |- eClass : object */
    RuleEnvironment _ruleEnvironment = new RuleEnvironment();
    typeInternal(_ruleEnvironment, _trace_, eClass, object);
    /* new it.xsemantics.runtime.RuleEnvironment(G) |- eClass : object */
    RuleEnvironment _ruleEnvironment_1 = new RuleEnvironment(G);
    typeInternal(_ruleEnvironment_1, _trace_, eClass, object);
    /* environmentComposition( emptyEnvironment(), environmentComposition( G, environmentComposition( emptyEnvironment(), G ) ) ) |- eClass : object */
    RuleEnvironment _emptyEnvironment = this.emptyEnvironment();
    RuleEnvironment _emptyEnvironment_1 = this.emptyEnvironment();
    RuleEnvironment _environmentComposition = this.environmentComposition(_emptyEnvironment_1, G);
    RuleEnvironment _environmentComposition_1 = this.environmentComposition(G, _environmentComposition);
    RuleEnvironment _environmentComposition_2 = this.environmentComposition(_emptyEnvironment, _environmentComposition_1);
    typeInternal(_environmentComposition_2, _trace_, eClass, object);
    /* emptyEnvironment, 'a' <- object, new it.xsemantics.runtime.RuleEnvironment |- eClass : object */
    RuleEnvironment _emptyEnvironment_2 = this.emptyEnvironment();
    RuleEnvironment _ruleEnvironment_2 = new RuleEnvironment();
    typeInternal(environmentComposition(
      _emptyEnvironment_2, environmentComposition(
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
	def testEnvironmentAccess() {
		testFiles.testWithEnvironmentAccess.assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import com.google.common.base.Objects;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECT = "it.xsemantics.test.rules.EClassEObject";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object));
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
    /* G |- object.eClass : eClass */
    EClass _eClass = object.eClass();
    typeInternal(G, _trace_, _eClass, eClass);
    /* env(G, 'this', EClass) */
    environmentAccess(G, "this", EClass.class);
    /* G |- object.eClass : eClass */
    EClass _eClass_1 = object.eClass();
    typeInternal(G, _trace_, _eClass_1, eClass);
    /* env(G, eClass.name, EClass) */
    String _name = eClass.getName();
    environmentAccess(G, _name, EClass.class);
    /* env(G, eClass.name, EClass) */
    String _name_1 = eClass.getName();
    EClass _environmentaccess = environmentAccess(G, _name_1, EClass.class);
    String _instanceClassName = _environmentaccess.getInstanceClassName();
    /* 'foo' == env(G, eClass.name, EClass).getInstanceClassName() */
    if (!Objects.equal("foo", _instanceClassName)) {
      sneakyThrowRuleFailedException("\'foo\' == env(G, eClass.name, EClass).getInstanceClassName()");
    }
    return new Result<Boolean>(true);
  }
}
''',
null
		)
	}

	@Test
	def testSystemExtendsSystemWithValidatorExtends() {
		testFiles.testBaseSystemWithValidatorExtends.
			parseWithBaseSystemAndAssertNoError
			(
				testFiles.testSystemExtendsSystemWithValidatorExtends
			).
		assertCorrectJavaCodeGeneration(
"ExtendedTypeSystem",
null,
'''
package it.xsemantics.test.validation;

import com.google.inject.Inject;
import it.xsemantics.test.ExtendedTypeSystem;
import it.xsemantics.test.validation.TypeSystemValidator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
		testFiles.testAuxiliaryFunctions.
		assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import com.google.common.base.Objects;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ISVALUE = "it.xsemantics.test.auxiliary.IsValue";
  
  public final static String VOIDFUN = "it.xsemantics.test.auxiliary.VoidFun";
  
  public final static String OBJECTCLASS = "it.xsemantics.test.auxiliary.ObjectClass";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Boolean _result_ = applyAuxFunIsValue(_subtrace_, eO, eC);
    	addToTrace(_trace_, auxFunName("isValue") + "(" + stringRep(eO) + ", " + stringRep(eC)+ ")" + " = " + stringRep(_result_));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	EClass _result_ = applyAuxFunObjectClass(_subtrace_, o);
    	addToTrace(_trace_, auxFunName("objectClass") + "(" + stringRep(o)+ ")" + " = " + stringRep(_result_));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Boolean _result_ = applyAuxFunVoidFun(_subtrace_, o);
    	addToTrace(_trace_, auxFunName("voidFun") + "(" + stringRep(o)+ ")" + " = " + stringRep(_result_));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Boolean _result_ = applyAuxFunVoidFun(_subtrace_, o);
    	addToTrace(_trace_, auxFunName("voidFun") + "(" + stringRep(o)+ ")" + " = " + stringRep(_result_));
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
		testFiles.testAuxiliaryFunctionsInvocation.
		assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import com.google.common.base.Objects;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String OBJECTCLASS = "it.xsemantics.test.auxiliary.ObjectClass";
  
  public final static String EOBJECTECLASS = "it.xsemantics.test.rules.EObjectEClass";
  
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
    } catch (Exception e) {
    	return resultForFailure(e);
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	EClass _result_ = applyAuxFunObjectClass(_subtrace_, o);
    	addToTrace(_trace_, auxFunName("objectClass") + "(" + stringRep(o)+ ")" + " = " + stringRep(_result_));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
    	addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
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
    EClass _objectClass = this.objectClassInternal(_trace_, o);
    c = _objectClass;
    return new Result<EClass>(c);
  }
}
'''
		)
	}

	@Test
	def testInstanceOfAsPremise_Issue_1() {
		testFiles.testInstanceOfAsPremise_Issue_1.
		assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String TESTRULE = "it.xsemantics.test.rules.TestRule";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EClass> _result_ = applyRuleTestRule(G, _subtrace_, o);
    	addToTrace(_trace_, ruleName("TestRule") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
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
		testFiles.testOperatorsWithSlashes_Issue_6.
		assertCorrectJavaCodeGeneration(
'''
package it.xsemantics.test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String UNIONRULE = "it.xsemantics.test.rules.UnionRule";
  
  public final static String INTERSECTIONRULE = "it.xsemantics.test.rules.IntersectionRule";
  
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleUnionRule(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, ruleName("UnionRule") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " \\/ " + stringRep(object));
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
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<Boolean> _result_ = applyRuleIntersectionRule(G, _subtrace_, eClass, object);
    	addToTrace(_trace_, ruleName("IntersectionRule") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " /\\ " + stringRep(object));
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

	def private assertCorrectJavaCodeGeneration(CharSequence input, CharSequence expected) {
		assertCorrectJavaCodeGeneration(input, expected, null)		
	}

	def private assertCorrectJavaCodeGeneration(CharSequence input, CharSequence expected, CharSequence expectedValidator) {
		parse(input).assertCorrectJavaCodeGeneration(null, expected, expectedValidator)
	}

	def private assertCorrectJavaCodeGeneration(XsemanticsSystem system, 
		String prefix, CharSequence expected, CharSequence expectedValidator
	) {
		system.compileAll [
			for (e : allGeneratedResources.entrySet) {
				if (prefix == null || e.key.contains(prefix)) {
					if (e.key.endsWith("Validator.java") && expectedValidator != null) {
						// check the expected Java code for the validator
						assertEquals(expectedValidator.toString, e.value.toString)
					} else if (!e.key.endsWith("Validator.java") && expected != null) {
						// check the expected Java code for the system
						assertEquals(expected.toString, e.value.toString)
					}
				}
			}
			
			
			// this will issue Java generation
			compileToJava
		]
	}
	
}
