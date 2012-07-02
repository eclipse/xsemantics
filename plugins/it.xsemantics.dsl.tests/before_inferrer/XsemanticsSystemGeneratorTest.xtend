package it.xsemantics.dsl.tests.generator

import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.xsemantics.ErrorSpecification
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.junit.Test
import org.junit.runner.RunWith
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions
import com.google.inject.Inject

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsSystemGeneratorTest extends XsemanticsGeneratorBaseTest {

	@Inject extension XsemanticsGeneratorExtensions
	
	@Test
	def void testCompileOfErrorSpecification() {
		checkErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecification,
'''
protected void typeThrowException(String _issue, Exception _ex, final EObject c) 
		throws RuleFailedException {
	
	String _plus = ("this " + c);
	String _plus_1 = (_plus + " made an error!");
	String error = _plus_1;
	EObject source = c;
	EClass _eClass = c.eClass();
	EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();
	EStructuralFeature feature = _eContainingFeature;
	throwRuleFailedException(error,
			_issue, _ex,
			new ErrorInformation(source, feature));
}

''')
	}
	
	@Test
	def void testCompileOfErrorSpecificationWithoutSourceAndFeature() {
		checkErrorSpecification(
			testFiles.testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature,
'''
protected void typeThrowException(String _issue, Exception _ex, final EObject c) 
		throws RuleFailedException {
	
	String _plus = ("this " + c);
	String _plus_1 = (_plus + " made an error!");
	String error = _plus_1;
	throwRuleFailedException(error,
			_issue, _ex,
			new ErrorInformation(null, null));
}

''')
	}
	
	@Test
	def void testCompileOfErrorSpecificationWithStringRep() {
		checkErrorSpecification(
			testFiles.testStringRep,
'''
protected void typeThrowException(String _issue, Exception _ex, final EObject c) 
		throws RuleFailedException {
	
	String _stringRep = this.stringRep(c);
	String _plus = ("this " + _stringRep);
	String _plus_1 = (_plus + " made an error!");
	String error = _plus_1;
	EObject source = c;
	EClass _eClass = c.eClass();
	EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();
	EStructuralFeature feature = _eContainingFeature;
	throwRuleFailedException(error,
			_issue, _ex,
			new ErrorInformation(source, feature));
}

''')
	}

	@Test
	def void testCompileOfErrorWithReferenceToThis() {
		checkErrorSpecification(
			testFiles.testForScopeOfThisInJudgmentDescription,
'''
protected void typeThrowException(String _issue, Exception _ex, final EObject c) 
		throws RuleFailedException {
	
	EClass _eClass = c.eClass();
	EClass _clone = this.<EClass>clone(_eClass);
	String _plus = ("this " + _clone);
	String _plus_1 = (_plus + " made an error!");
	String error = _plus_1;
	EObject _clone_1 = this.<EObject>clone(c);
	EObject source = _clone_1;
	EClass _eClass_1 = c.eClass();
	EClass _clone_2 = this.<EClass>clone(_eClass_1);
	EStructuralFeature _eContainingFeature = _clone_2.eContainingFeature();
	EStructuralFeature feature = _eContainingFeature;
	throwRuleFailedException(error,
			_issue, _ex,
			new ErrorInformation(source, feature));
}

''')
	}

	def void checkErrorSpecification(CharSequence inputProgram, CharSequence expected) {
		val jDesc = inputProgram.parseAndAssertNoError.firstJudgmentDescription
		val result = tsGenerator.compileErrorSpecification(jDesc, new ImportManager(true))
		assertEqualsStrings(expected, result)
	}
	
	def void checkCompilationOfErrorSpecification(CharSequence inputProgram,
		(ErrorSpecification, IAppendable)=>String compilation,
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