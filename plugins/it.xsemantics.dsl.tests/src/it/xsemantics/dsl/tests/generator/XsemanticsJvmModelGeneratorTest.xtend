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

import it.xsemantics.runtime.XsemanticsRuntimeSystem;

public class TypeSystem extends XsemanticsRuntimeSystem {
  public TypeSystem() {
    init();
  }
  
  public void init() {
    /* TODO */
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

import it.xsemantics.runtime.XsemanticsRuntimeSystem;

public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECT = "it.xsemantics.test.rules.EClassEObject";
  
  public TypeSystem() {
    init();
  }
  
  public void init() {
    /* TODO */
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
