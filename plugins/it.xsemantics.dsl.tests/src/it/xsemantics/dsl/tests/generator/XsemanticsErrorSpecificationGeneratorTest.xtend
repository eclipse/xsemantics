package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.generator.XsemanticsErrorSpecificationGenerator
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsErrorSpecificationGeneratorTest extends XsemanticsGeneratorBaseTest {

	@Inject extension XsemanticsGeneratorExtensions
	
	@Inject XsemanticsErrorSpecificationGenerator errSpecGenerator
	
	@Test
	def void testCompileErrorOfErrorSpecification() {
		checkErrorOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
'''

String _operator_plus = StringExtensions.operator_plus("this ", c);
String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " made an error!");
String error = _operator_plus_1;''', "error")
	}
	
	@Test
	def void testCompileSourceOfErrorSpecification() {
		checkSourceOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
'''

EObject source = c;''', "source")
	}
	
	@Test
	def void testCompileFeatureOfErrorSpecification() {
		checkFeatureOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
'''

EClass _eClass = c.eClass();
EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();
EStructuralFeature feature = _eContainingFeature;''', "feature")
	}
	
	@Test
	def void testCompileEmptySourceOfErrorSpecification() {
		checkSourceOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature,
			"", "null")
	}
	
	@Test
	def void testCompileEmptyFeatureOfErrorSpecification() {
		checkFeatureOfErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature,
			"", "null")
	}

	def void checkErrorOfErrorSpecification(CharSequence inputProgram, CharSequence expected, CharSequence expectedVar) {
		checkCompilationOfErrorSpecification(inputProgram,
			[ errSpec, b | errSpecGenerator.compileErrorOfErrorSpecification(errSpec, b) ],
			expected, expectedVar
		)
	}
	
	def void checkSourceOfErrorSpecification(CharSequence inputProgram, CharSequence expected, CharSequence expectedVar) {
		checkCompilationOfErrorSpecification(inputProgram,
			[ errSpec, b | errSpecGenerator.compileSourceOfErrorSpecification(errSpec, b) ],
			expected, expectedVar
		)
	}
	
	def void checkFeatureOfErrorSpecification(CharSequence inputProgram, CharSequence expected, CharSequence expectedVar) {
		checkCompilationOfErrorSpecification(inputProgram,
			[ errSpec, b | errSpecGenerator.compileFeatureOfErrorSpecification(errSpec, b) ],
			expected, expectedVar
		)
	}
	
	def void checkCompilationOfErrorSpecification(CharSequence inputProgram,
		(ErrorSpecification, ITreeAppendable)=>String compilation,
		CharSequence expected, CharSequence expectedVar
	) {
		val jDesc = inputProgram.parseAndAssertNoError.firstJudgmentDescription
		val errSpec = jDesc.firstErrorSpecification
		val appendable = 
			jDesc.createAndConfigureAppendable(new ImportManager(true))
		val variable = compilation.apply(errSpec, appendable)
		assertEqualsStrings(expected, appendable)
		assertEqualsStrings(expectedVar, variable)
	}
	
}