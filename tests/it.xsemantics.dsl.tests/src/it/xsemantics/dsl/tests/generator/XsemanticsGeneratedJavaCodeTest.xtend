package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import com.google.inject.Provider
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsCompilationTestHelper
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsGeneratedJavaCodeTest extends XsemanticsBaseTest {
	
	@Inject extension XsemanticsCompilationTestHelper
	
	@Inject extension ValidationTestHelper
	
	@Inject Provider<XtextResourceSet> resourceSetProvider
	
	var XtextResourceSet resourceSet
	
	@Before
	def void setUp() {
		resourceSet = resourceSetProvider.get
	}
	
	val TESTS_INPUT_FILES = "./tests_input_files/"

	@Test
	def testRuleInvocation() {
		assertCorrectJavaCodeGeneration("ecore_ruleinvocation_test.xsemantics");
	}

	@Test
	def testFjFirst() {
		assertCorrectJavaCodeGeneration("fj_first_test.xsemantics");
	}

	@Test
	def testFjAlt() {
		// fj_alt_test depends on fj_first_test so we must load it first
		assertCorrectJavaCodeGeneration("fj_first_test.xsemantics");
		assertCorrectJavaCodeGeneration("fj_alt_test.xsemantics");
	}

	@Test
	def testFjCached() {
		// cached tests depend on fj_first_test so we must load it first
		assertCorrectJavaCodeGeneration("fj_first_test.xsemantics");
		assertCorrectJavaCodeGeneration("fj_cached_test.xsemantics");
		assertCorrectJavaCodeGeneration("fj_cached_options_test.xsemantics");
	}

	@Test
	def testEcore() {
		assertCorrectJavaCodeGeneration("ecore_test.xsemantics");
	}

	@Test
	def testParticularCases() {
		assertCorrectJavaCodeGeneration("ecore_particular_test.xsemantics");
	}

	@Test
	def testOrExpressions() {
		assertCorrectJavaCodeGeneration("ecore_or_test.xsemantics");
	}

	@Test
	def testExpressions() {
		assertCorrectJavaCodeGeneration("ecore_expressions_test.xsemantics");
	}

	@Test
	def testValidationEcore() {
		assertCorrectJavaCodeGeneration("ecore_validation_test.xsemantics");
	}

	def private assertCorrectJavaCodeGeneration(CharSequence file) {
		val fullPathInputFile = TESTS_INPUT_FILES + file
		val resource = resourceSet.getResource(URI::createURI(fullPathInputFile), true);
		val system = resource.contents.get(0)
		system.assertNoErrors
		
		system.compileAll [
			// this will issue Java compilation on generated Java code
			compileToJava
		]
	}
	
}
