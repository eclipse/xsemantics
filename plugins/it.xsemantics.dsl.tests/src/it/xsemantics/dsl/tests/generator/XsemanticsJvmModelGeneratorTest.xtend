package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsCompilationTestHelper
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static junit.framework.Assert.*
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

import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.util.PolymorphicDispatcher;

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
  
  protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final List<String> list, final Set<Integer> set) {
    try {
    	checkParamsNotNull(list, set);
    	return typeDispatcher.invoke(_environment_, _trace_, list, set);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
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
  
  protected Result<Boolean> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    try {
    	checkParamsNotNull(c, o);
    	return typeDispatcher.invoke(_environment_, _trace_, c, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected Result<Boolean> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass, object);
      addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleEClassEObject) {
      throwRuleFailedException(ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object),
      	ECLASSEOBJECT,
      	e_applyRuleEClassEObject, new ErrorInformation(eClass), new ErrorInformation(object));
      return null;
    }
  }
  
  protected Result<Boolean> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {
    
    {
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
      boolean _equals_1 = Objects.equal(eClass, eC);
      /* eClass == eC */
      if (!Boolean.valueOf(_equals_1)) {
        sneakyThrowRuleFailedException("eClass == eC");
      }
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
  
  protected Result2<EObject,EStructuralFeature> type2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	checkParamsNotNull(c);
    	return type2Dispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type2) {
    	sneakyThrowRuleFailedException(_e_type2);
    	return null;
    }
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
  
  protected Result2<EObject,EStructuralFeature> type2Impl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result2<EObject,EStructuralFeature> _result_ = applyRuleEClassEObjectEStructuralFeature(G, _subtrace_, eClass);
      addToTrace(_trace_, ruleName("EClassEObjectEStructuralFeature") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleEClassEObjectEStructuralFeature) {
      throwRuleFailedException(ruleName("EClassEObjectEStructuralFeature") + stringRepForEnv(G) + " ||- " + stringRep(eClass) + " : " + "EObject" + " : " + "EStructuralFeature",
      	ECLASSEOBJECTESTRUCTURALFEATURE,
      	e_applyRuleEClassEObjectEStructuralFeature, new ErrorInformation(eClass));
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
  
  protected void typeThrowException(final String _issue, final Exception _ex, final EObject c) throws RuleFailedException {
    
    String _plus = ("this " + c);
    String _plus_1 = (_plus + " made an error!");
    String error = _plus_1;
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
    try {
    	return checkEObjectInternal(null, obj);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkEObjectInternal(final RuleApplicationTrace _trace_, final EObject obj) throws RuleFailedException {
    
    {
      EClass result = null;
      /* empty |- obj : result */
      Result<EClass> result_1 = typeInternal(emptyEnvironment(), _trace_, obj);
      checkAssignableTo(result_1.getFirst(), EClass.class);
      result = (EClass) result_1.getFirst();
      
    }
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
  
  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject object) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, object);
      addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(object) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
      throwRuleFailedException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(object) + " : " + "EClass",
      	EOBJECTECLASS,
      	e_applyRuleEObjectEClass, new ErrorInformation(object));
      return null;
    }
  }
  
  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject object) throws RuleFailedException {
    
    EClass _eClass = object.eClass();
    return new Result<EClass>(_eClass);
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
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import it.xsemantics.test.TypeSystem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;

public class TypeSystemValidator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected TypeSystem xsemanticsSystem;
  
  @Check
  public void checkEObject(final EObject obj) {
    generateErrors(
    	xsemanticsSystem.checkEObject(obj),
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
  
  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
      addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
      throwRuleFailedException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
      	EOBJECTECLASS,
      	e_applyRuleEObjectEClass, new ErrorInformation(o));
      return null;
    }
  }
  
  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    EClass c = null; // output parameter
    
    {
      InputOutput.<EObject>println(o);
      InputOutput.<String>println(this.myString);
      boolean _add = this.strings.add(this.myString);
      /* strings.add(myString) */
      if (!_add) {
        sneakyThrowRuleFailedException("strings.add(myString)");
      }
      EClass _eClass = o.eClass();
      boolean _add_1 = this.eClasses.add(_eClass);
      /* eClasses.add(o.eClass) */
      if (!Boolean.valueOf(_add_1)) {
        sneakyThrowRuleFailedException("eClasses.add(o.eClass)");
      }
    }
    return new Result<EClass>(c);
  }
}
'''
		)
	}

	@Test
	def testExpressionsInConclusion() {
		testFiles.testTwoExpressionsInConclusion.assertCorrectJavaCodeGeneration(
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
  
  protected Result2<EObject,EStructuralFeature> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result2<EObject,EStructuralFeature> _result_ = applyRuleTwoExpressionsInConclusion(G, _subtrace_, cl);
      addToTrace(_trace_, ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + stringRep(_result_.getFirst()) + " : " + stringRep(_result_.getSecond()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleTwoExpressionsInConclusion) {
      throwRuleFailedException(ruleName("TwoExpressionsInConclusion") + stringRepForEnv(G) + " |- " + stringRep(cl) + " : " + "EClass" + " : " + "EStructuralFeature",
      	TWOEXPRESSIONSINCONCLUSION,
      	e_applyRuleTwoExpressionsInConclusion, new ErrorInformation(cl));
      return null;
    }
  }
  
  protected Result2<EObject,EStructuralFeature> applyRuleTwoExpressionsInConclusion(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass cl) throws RuleFailedException {
    
    EList<EStructuralFeature> _eAllStructuralFeatures = cl.getEAllStructuralFeatures();
    EStructuralFeature _head = IterableExtensions.<EStructuralFeature>head(_eAllStructuralFeatures);
    return new Result2<EObject,EStructuralFeature>(cl, _head);
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
  
  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
      addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
      throwRuleFailedException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
      	EOBJECTECLASS,
      	e_applyRuleEObjectEClass, new ErrorInformation(o));
      return null;
    }
  }
  
  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    
    EClass _xblockexpression = null;
    {
      InputOutput.<TypeSystem>println(this);
      EObject _clone = this.<EObject>clone(o);
      EClass _eClass = _clone.eClass();
      _xblockexpression = (_eClass);
    }
    return new Result<EClass>(_xblockexpression);
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
  
  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<EClass> _result_ = applyRuleEObjectEClass(G, _subtrace_, o);
      addToTrace(_trace_, ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleEObjectEClass) {
      throwRuleFailedException(ruleName("EObjectEClass") + stringRepForEnv(G) + " |- " + stringRep(o) + " : " + "EClass",
      	EOBJECTECLASS,
      	e_applyRuleEObjectEClass, new ErrorInformation(o));
      return null;
    }
  }
  
  protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    
    EClass _get = this.classes.get(0);
    return new Result<EClass>(_get);
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

public class TypeSystemValidator extends AbstractDeclarativeValidator {
  @Inject
  protected TypeSystem xsemanticsSystem;
  
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Check
  public void checkEObject(final EObject obj) {
    errorGenerator.generateErrors(this, 
    	xsemanticsSystem.checkEObject(obj),
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

public class ExtendedTypeSystem2 extends ExtendedTypeSystem {
  public final static String FROMTYPESYSTEM = "it.xsemantics.test.rules.FromTypeSystem";
  
  public final static String FROMEXTENDEDTYPESYSTEM = "it.xsemantics.test.rules.FromExtendedTypeSystem";
  
  public final static String FROMTHISTYPESYSTEM = "it.xsemantics.test.rules.FromThisTypeSystem";
  
  private PolymorphicDispatcher<Result<Boolean>> type2Dispatcher;
  
  public ExtendedTypeSystem2() {
    init();
  }
  
  public void init() {
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
  
  public Result<Boolean> checkEObject(final EObject o) {
    try {
    	return checkEObjectInternal(null, o);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkEObjectInternal(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    
    {
      /* empty |- o : var EClass c */
      EClass c = null;
      Result<EClass> result = typeInternal(emptyEnvironment(), _trace_, o);
      checkAssignableTo(result.getFirst(), EClass.class);
      c = (EClass) result.getFirst();
      
      /* empty |- o.eClass <: c */
      EClass _eClass = o.eClass();
      subtypeInternal(emptyEnvironment(), _trace_, _eClass, c);
    }
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
  
  protected Result<EClass> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject c) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<EClass> _result_ = applyRuleFromTypeSystem(G, _subtrace_, c);
      addToTrace(_trace_, ruleName("FromTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + stringRep(_result_.getFirst()));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleFromTypeSystem) {
      typeThrowException(FROMTYPESYSTEM,
      	e_applyRuleFromTypeSystem, c);
      return null;
    }
  }
  
  protected Result<EClass> applyRuleFromTypeSystem(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject c) throws RuleFailedException {
    
    /* G |- c.eClass <: c.eClass */
    EClass _eClass = c.eClass();
    EClass _eClass_1 = c.eClass();
    subtypeInternal(G, _trace_, _eClass, _eClass_1);
    EClass _eClass_2 = c.eClass();
    return new Result<EClass>(_eClass_2);
  }
  
  protected Result<Boolean> subtypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass c1, final EClass c2) throws RuleFailedException {
    try {
      RuleApplicationTrace _subtrace_ = newTrace(_trace_);
      Result<Boolean> _result_ = applyRuleFromExtendedTypeSystem(G, _subtrace_, c1, c2);
      addToTrace(_trace_, ruleName("FromExtendedTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c1) + " <: " + stringRep(c2));
      addAsSubtrace(_trace_, _subtrace_);
      return _result_;
    } catch (Exception e_applyRuleFromExtendedTypeSystem) {
      throwRuleFailedException(ruleName("FromExtendedTypeSystem") + stringRepForEnv(G) + " |- " + stringRep(c1) + " <: " + stringRep(c2),
      	FROMEXTENDEDTYPESYSTEM,
      	e_applyRuleFromExtendedTypeSystem, new ErrorInformation(c1), new ErrorInformation(c2));
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
      throwRuleFailedException(ruleName("FromThisTypeSystem") + stringRepForEnv(G) + " ||- " + stringRep(c1) + " : " + stringRep(c2),
      	FROMTHISTYPESYSTEM,
      	e_applyRuleFromThisTypeSystem, new ErrorInformation(c1), new ErrorInformation(c2));
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
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import it.xsemantics.test.ExtendedTypeSystem2;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;

public class ExtendedTypeSystem2Validator extends XsemanticsBasedDeclarativeValidator {
  @Inject
  protected ExtendedTypeSystem2 xsemanticsSystem;
  
  @Check
  public void checkEObject(final EObject o) {
    generateErrors(
    	xsemanticsSystem.checkEObject(o),
    		o);
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
