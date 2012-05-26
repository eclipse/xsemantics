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

import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

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
