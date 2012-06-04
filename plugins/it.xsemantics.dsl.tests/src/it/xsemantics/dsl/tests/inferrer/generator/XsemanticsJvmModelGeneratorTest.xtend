package it.xsemantics.dsl.tests.inferrer.generator

import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderForInferrer
import junit.framework.Assert
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProviderForInferrer))
@RunWith(typeof(XtextRunner))
class XsemanticsJvmModelGeneratorTest extends XsemanticsBaseTest {
	
	@Inject
	protected JvmModelGenerator generator
	
	static String TEST_TYPESYSTEM_NAME = "it.xsemantics.test.TypeSystem"
	
	static String OUTPUT_PREFIX = "DEFAULT_OUTPUT";
	
	@Test
	def testJudgmentDescriptions() {
		val fs = testFiles.testJudgmentDescriptions.runGenerator
		assertGeneratedCode(fs, TEST_TYPESYSTEM_NAME,
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
    throw new UnsupportedOperationException("typeis not implemented");
  }
  
  public Result<Boolean> type(final RuleEnvironment _environment_, final List<String> list, final Set<Integer> set) {
    throw new UnsupportedOperationException("typeis not implemented");
  }
  
  public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final List<String> list, final Set<Integer> set) {
    throw new UnsupportedOperationException("typeis not implemented");
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
		val fs = testFiles.testSimpleRule.runGenerator
		assertGeneratedCode(fs, TEST_TYPESYSTEM_NAME,
'''
package it.xsemantics.test;

import com.google.common.base.Objects;
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
    throw new UnsupportedOperationException("typeis not implemented");
  }
  
  public Result<Boolean> type(final RuleEnvironment _environment_, final EClass c, final EObject o) {
    throw new UnsupportedOperationException("typeis not implemented");
  }
  
  public Result<Boolean> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EObject o) {
    throw new UnsupportedOperationException("typeis not implemented");
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
		val fs = testFiles.testRuleWithTwoOutputParams.runGenerator
		assertGeneratedCode(fs, TEST_TYPESYSTEM_NAME,
'''
package it.xsemantics.test;

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
    throw new UnsupportedOperationException("typeis not implemented");
  }
  
  public Result<EObject> type(final RuleEnvironment _environment_, final EClass c, final EStructuralFeature f) {
    throw new UnsupportedOperationException("typeis not implemented");
  }
  
  public Result<EObject> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {
    throw new UnsupportedOperationException("typeis not implemented");
  }
  
  public Result2<EObject,EStructuralFeature> type2(final EClass c) {
    throw new UnsupportedOperationException("type2is not implemented");
  }
  
  public Result2<EObject,EStructuralFeature> type2(final RuleEnvironment _environment_, final EClass c) {
    throw new UnsupportedOperationException("type2is not implemented");
  }
  
  public Result2<EObject,EStructuralFeature> type2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    throw new UnsupportedOperationException("type2is not implemented");
  }
  
  public Result<EObject> subtype(final EClass c, final EStructuralFeature f) {
    throw new UnsupportedOperationException("subtypeis not implemented");
  }
  
  public Result<EObject> subtype(final RuleEnvironment _environment_, final EClass c, final EStructuralFeature f) {
    throw new UnsupportedOperationException("subtypeis not implemented");
  }
  
  public Result<EObject> subtype(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c, final EStructuralFeature f) {
    throw new UnsupportedOperationException("subtypeis not implemented");
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
  
  protected Result2<EObject,EStructuralFeature> applyRuleEClassEObjectEStructuralFeature(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    EObject object = null; // output parameter
    EStructuralFeature feat = null; // output parameter
    
    /* G ||- eClass : object : feat */
    Result2<EObject, EStructuralFeature> result = type2Internal(G, _trace_, eClass);
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
	
	def runGenerator(CharSequence prog) {
		val fs = new InMemoryFileSystemAccess()
		generator.doGenerate(prog.loadResource, fs)
		fs
	}
	
	def loadResource(CharSequence prog) {
		prog.parseAndAssertNoError.eResource
	}
	
	def assertGeneratedCode(InMemoryFileSystemAccess fs, String tsName, 
			CharSequence expected) {
		val genCode = fs.files.get(OUTPUT_PREFIX + tsName.replace(".", "/") + ".java")
		Assert::assertNotNull(genCode)
		assertEqualsStrings(expected, genCode)
	}
	
}
