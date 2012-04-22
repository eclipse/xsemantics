package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import junit.framework.Assert
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.junit.Test
import org.junit.runner.RunWith

import static it.xsemantics.dsl.tests.generator.XsemanticsJvmModelGeneratorTest.*

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
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
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
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
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
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
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
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
