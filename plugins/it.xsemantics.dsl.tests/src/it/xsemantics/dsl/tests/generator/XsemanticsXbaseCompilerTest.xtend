package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.generator.XsemanticsXbaseCompiler
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class XsemanticsXbaseCompilerTest extends XsemanticsGeneratorBaseTest {

	@Inject XsemanticsXbaseCompiler xbaseCompiler

	@Test
	def void testXbaseCompilationOfXBlock() {
		checkCompilationOfRightExpression(
			testFiles.testRuleWithBlockExpressionInConclusion,
			"_xblockexpression",
'''

EClass _xblockexpression = null;
{
  EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
  final EClass result = _createEClass;
  result.setName("MyEClass");
  _xblockexpression = (result);
}'''			
			)
	}
	
	@Test
	def void testXbaseCompilationOfXExpression() {
		checkCompilationOfRightExpression(
			testFiles.testRuleWithExpressionInConclusion,
			"_createEObject",
'''

EObject _createEObject = EcoreFactory.eINSTANCE.createEObject();'''
			)
	}
	
	@Test
	def void testRuleWithExpressionInConclusionWithParamNameAsXbaseGeneratedVariable() {
		checkCompilationOfRightExpression(
			testFiles.testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable,
			"_createEObject",
'''

EObject _createEObject = EcoreFactory.eINSTANCE.createEObject();'''
			)
	}
	
	@Test
	def void testWithConfiguredAppendable() {
		val appendable = createAppendable()
		// we simulate the declaration of a variable representing
		// the parameter of the rule (which would end up clashing with
		// a local variable generated by the Xbase compiler)
		appendable.declareVariable(new String(), "_createEObject")
		checkCompilationOfRightExpression(
			testFiles.testRuleWithExpressionInConclusionWithInputParamNameAsXbaseGeneratedVariable,
			"_createEObject_1",
'''

EObject _createEObject_1 = EcoreFactory.eINSTANCE.createEObject();''',
			appendable
			)
	}
	
	@Test
	def void testRuleInvokingAnotherRule() {
		checkCompilationOfPremises(
			testFiles.testRuleInvokingAnotherRule,
'''

{
  String _string = new String();
  String _firstUpper = StringExtensions.toFirstUpper("bar");
  String _operator_plus = StringExtensions.operator_plus(_string, _firstUpper);
  boolean _operator_equals = ObjectExtensions.operator_equals("foo", _operator_plus);
  /* 'foo' == new String() + "bar".toFirstUpper */
  if (!_operator_equals) {
    sneakyThrowRuleFailedException("\'foo\' == new String() + \"bar\".toFirstUpper");
  }
  /* G |- object.eClass : eClass */
  EClass _eClass = object.eClass();
  typeInternal(G, _trace_, _eClass, eClass);
  /* G |- eClass : object.eClass */
  EClass _eClass_1 = object.eClass();
  typeInternal(G, _trace_, eClass, _eClass_1);
  EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
  final EClass eC = _createEClass;
  eC.setName("MyEClass");
  String _name = eC.getName();
  boolean _operator_equals_1 = ObjectExtensions.operator_equals(_name, "MyEClass2");
  boolean _operator_not = BooleanExtensions.operator_not(_operator_equals_1);
  /* !(eC.name == 'MyEClass2') */
  if (!_operator_not) {
    sneakyThrowRuleFailedException("!(eC.name == \'MyEClass2\')");
  }
  String _name_1 = eC.getName();
  int _length = _name_1.length();
  boolean _operator_lessThan = IntegerExtensions.operator_lessThan(_length, 10);
  /* eC.name.length < 10 */
  if (!_operator_lessThan) {
    sneakyThrowRuleFailedException("eC.name.length < 10");
  }
  boolean _operator_equals_2 = ObjectExtensions.operator_equals(eClass, eC);
  /* eClass == eC */
  if (!_operator_equals_2) {
    sneakyThrowRuleFailedException("eClass == eC");
  }
}'''
			)
	}
	
	@Test
	def void testRuleInvokingAnotherRuleWithOutputParams() {
		checkCompilationOfPremises(
			testFiles.testRuleWithOutputParams,
'''

/* G |- eClass : object : feat */
Result<EObject> result = typeInternal(G, _trace_, eClass, feat);
checkAssignableTo(result.getFirst(), EObject.class);
object = (EObject) result.getFirst();
'''
			)
	}
	
	@Test
	def void testRuleInvokingAnotherRuleWithCollectionOutputParam() {
		checkCompilationOfPremises(
			testFiles.testRuleWithCollectionOutputParam,
'''

/* G |- eClass : features */
Result<List<EStructuralFeature>> result = typeInternal(G, _trace_, eClass);
checkAssignableTo(result.getFirst(), List.class);
features = (List<EStructuralFeature>) result.getFirst();
'''
			)
	}
	
	@Test
	def void testRuleInvokingAnotherRuleWithTwoOutputParams() {
		checkCompilationOfPremises(
			testFiles.testRuleWithTwoOutputParams,
'''

/* G ||- eClass : object : feat */
Result2<EObject, EStructuralFeature> result = type2Internal(G, _trace_, eClass);
checkAssignableTo(result.getFirst(), EObject.class);
object = (EObject) result.getFirst();
checkAssignableTo(result.getSecond(), EStructuralFeature.class);
feat = (EStructuralFeature) result.getSecond();
'''
			)
	}
	
	@Test
	def void testRuleWithOutputParamAsLocalVariable() {
		checkCompilationOfPremises(
			testFiles.testRuleWithOutputArgAsLocalVariable,
'''

{
  EObject objectResult = null;
  /* G |- eClass : objectResult : feat */
  Result<EObject> result = typeInternal(G, _trace_, eClass, feat);
  checkAssignableTo(result.getFirst(), EObject.class);
  objectResult = (EObject) result.getFirst();
  
  EObject myObject = null;
  myObject = objectResult;
}'''
			)
	}
	
	@Test
	def void testRuleWithOutputParamsAndExplicitAssignment() {
		checkCompilationOfPremises(
			testFiles.testRuleWithOutputParamsAndExplicitAssignment,
'''

{
  EObject objectResult = null;
  /* G |- eClass : object : feat */
  Result<EObject> result = typeInternal(G, _trace_, eClass, feat);
  checkAssignableTo(result.getFirst(), EObject.class);
  object = (EObject) result.getFirst();
  
  object = objectResult;
}'''
			)
	}
	
	@Test
	def void testRuleOnlyInvokingOtherRules() {
		checkCompilationOfPremises(
			testFiles.testRuleOnlyInvokingRules,
'''

{
  /* G |- object.eClass : eClass */
  EClass _eClass = object.eClass();
  typeInternal(G, _trace_, _eClass, eClass);
  /* G |- eClass : object.eClass */
  EClass _eClass_1 = object.eClass();
  typeInternal(G, _trace_, eClass, _eClass_1);
}'''
			)
	}

	@Test
	def void testCheckRule() {
		checkCompilationOfPremisesOfCheckRule(
			testFiles.testCheckRule,
'''

{
  EClass result = null;
  /* empty |- obj : result */
  Result<EClass> result_1 = typeInternal(emptyEnvironment(), _trace_, obj);
  checkAssignableTo(result_1.getFirst(), EClass.class);
  result = (EClass) result_1.getFirst();
  
}'''
			)
	}
	
	def void checkCompilationOfRightExpression(CharSequence inputCode, 
		String expectedExpName, CharSequence expected) {
		checkCompilationOfRightExpression(inputCode, expectedExpName, expected,
			createAppendable())
	}
	
	def void checkCompilationOfPremises(CharSequence inputCode, 
		CharSequence expected) {
		checkCompilationOfPremises(inputCode, expected, createAppendable)
	}
	
	def void checkCompilationOfRightExpression(CharSequence inputCode, 
		String expectedExpName, CharSequence expected, ITreeAppendable appendable) {
		val xexp = inputCode.
			firstRule.conclusion.conclusionElements.get(1).ruleExpression.expression
		val result = 
			xbaseCompiler.compile(xexp, appendable, true)
		Assert::assertEquals(expected.toString, result.toString)
		val expName = result.getName(xexp)
		Assert::assertEquals(expectedExpName, expName)
	}
	
	def void checkCompilationOfPremises(CharSequence inputCode, 
		CharSequence expected, ITreeAppendable appendable) {
		val xexp = inputCode.
			firstRule.rulePremisesAsBlock
		val result = 
			xbaseCompiler.compile(xexp, appendable, false)
		Assert::assertEquals(expected.toString, result.toString)
	}
	
	def void checkCompilationOfPremisesOfCheckRule(CharSequence inputCode, 
		CharSequence expected) {
		val xexp = inputCode.
			firstCheckRule.rulePremisesAsBlock
		val result = 
			xbaseCompiler.compile(xexp, createAppendable, false)
		Assert::assertEquals(expected.toString, result.toString)
	}

}