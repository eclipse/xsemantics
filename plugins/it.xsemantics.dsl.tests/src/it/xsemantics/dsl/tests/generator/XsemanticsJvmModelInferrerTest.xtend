package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.jvmmodel.XsemanticsJvmModelInferrer
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable
import org.junit.Test
import org.junit.runner.RunWith

import static extension junit.framework.Assert.*

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsJvmModelInferrerTest extends XsemanticsBaseTest {
	
	@Inject
	protected JvmModelGenerator generator
	
	@Inject
	protected extension XsemanticsJvmModelInferrer inferrer
	
	@Test
	def testIssueField() {
		assertIssueField(testFiles.testSimpleRule,
'''public final static String ECLASSEOBJECT = "it.xsemantics.test.rules.EClassEObject";'''
		)
	}
	
	@Test
	def testConstructor() {
		assertConstructor(testFiles.testSimpleRule,
'''public ConstructorName() {
    init();
  }'''
		)
	}
	
	@Test
	def testInit() {
		assertInit(testFiles.testSimpleRule,
'''public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 4, "|-", ":");
  }'''
		)
	}
	
	@Test
	def testPolymorphicDispatcherField() {
		testFiles.testJudgmentDescriptionsWith2OutputParams.
			parseAndAssertNoError.judgmentDescriptions.get(0).
				genPolymorphicDispatcherField.
				assertGeneratedMember
("private PolymorphicDispatcher<Result2<EObject,EStructuralFeature>> typeDispatcher;")
	}
	
	@Test
	def testEntryPointMethods() {
		testFiles.testJudgmentDescriptionsWith2OutputParams.
			parseAndAssertNoError.judgmentDescriptions.get(0).
				genEntryPointMethods.
				assertGeneratedMembers
(
'''
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
  }'''
)
	}

	@Test
	def testThrowExceptionMethodNull() {
		testFiles.testSimpleRule.
			parseAndAssertNoError.judgmentDescriptions.get(0).
				compileThrowExceptionMethod.assertNull
	}

	@Test
	def testThrowExceptionMethod() {
		testFiles.testJudgmentDescriptionsWithErrorSpecification.
			parseAndAssertNoError.judgmentDescriptions.get(0).
				compileThrowExceptionMethod.
				assertGeneratedMember
(
'''
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
  }'''
)
	}

	@Test
	def testInternalMethod() {
		testFiles.testJudgmentDescriptionsWith2OutputParams.
			parseAndAssertNoError.judgmentDescriptions.get(0).
				compileInternalMethod.
				assertGeneratedMember
(
'''
protected Result2<EObject,EStructuralFeature> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	checkParamsNotNull(c);
    	return typeDispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }'''
)
	}
	
	@Test
	def testCheckRuleInternalMethod() {
		testFiles.testCheckRule.
			parseAndAssertNoError.checkrules.get(0).
				compileInternalMethod.
				assertGeneratedMember
(
'''
protected Result<Boolean> checkEObjectInternal(final RuleApplicationTrace _trace_, final EObject obj) throws RuleFailedException {
    
    {
      EClass result = null;
      /* empty |- obj : result */
      Result<EClass> result_1 = typeInternal(emptyEnvironment(), _trace_, obj);
      checkAssignableTo(result_1.getFirst(), EClass.class);
      result = (EClass) result_1.getFirst();
      
    }
    return new Result<Boolean>(true);
  }'''
)
	}

	@Test
	def testCheckRuleMethod() {
		testFiles.testCheckRule.
			parseAndAssertNoError.checkrules.get(0).
				compileCheckRuleMethod.
				assertGeneratedMember
(
'''
public Result<Boolean> checkEObject(final EObject obj) {
    try {
    	return checkEObjectInternal(null, obj);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }'''
)
	}

	@Test
	def testApplyMethodForAxiom() {
		testFiles.testSimpleAxiom.
			parseAndAssertNoError.rules.get(0).
				compileApplyMethod.
				assertGeneratedMember
(
'''
protected Result<Boolean> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass, final EObject object) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }'''
)
	}
	
	@Test
	def testApplyMethodForAxiomWithExpressionInConclusion() {
		testFiles.testAxiomWithExpressionInConclusion.
			parseAndAssertNoError.rules.get(0).
				compileApplyMethod.
				assertGeneratedMember
(
'''
protected Result<EClass> applyRuleEObjectEClass(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EObject object) throws RuleFailedException {
    
    return new Result<EClass>(EObjectEClass_exp_1(G, _trace_, object));
  }'''
)
	}

	@Test
	def testApplyMethodForRuleWithPremise() {
		testFiles.testRuleWithTwoOutputParams.
			parseAndAssertNoError.rules.get(0).
				compileApplyMethod.
				assertGeneratedMember
(
'''
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
  }'''
)
	}
	
	@Test
	def testErrorInformationArgsWithOneEObjectArg() {
		testFiles.testRuleWithTwoOutputParams.assertErrorInformationArgs
(
''', new ErrorInformation(eClass)'''
)
	}
	
	@Test
	def testErrorInformationArgsWithTwoEObjectArg() {
		testFiles.testSimpleRule.assertErrorInformationArgs
(
''', new ErrorInformation(eClass), new ErrorInformation(object)'''
)
	}

	@Test
	def testErrorInformationWithNoEObjectArg() {
		testFiles.testRulesOfTheSameKind.assertErrorInformationArgs
(
''''''
)
	}
	
	@Test
	def testFinalThrowWithNoErrorInformation() {
		testFiles.testSimpleRule.assertFinalThrow
(
'''
throwRuleFailedException(ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(object),
	ECLASSEOBJECT,
	e_applyRuleEClassEObject, new ErrorInformation(eClass), new ErrorInformation(object))'''
)
	}
	
	@Test
	def testFinalThrowRuleJudgmentErrorInformation() {
		testFiles.testRuleJudgmentDescriptionsWithErrorSpecification.assertFinalThrow
(
'''
typeThrowException(TESTRULE,
	e_applyRuleTestRule, o)'''
)
	}
	
	@Test
	def testFinalThrowRuleErrorInformation() {
		testFiles.testRuleWithErrorSpecifications.assertFinalThrow
(
'''
TypeSystem _TypeSystem = TypeSystem;
String _stringRep = _TypeSystem.stringRep(object);
String _plus = ("this " + _stringRep);
String _plus_1 = (_plus + " made an error!");
String error = _plus_1;
EClass _eClass = object.eClass();
EObject source = _eClass;
EClass _eClass_1 = object.eClass();
EStructuralFeature _eContainingFeature = _eClass_1.eContainingFeature();
EStructuralFeature feature = _eContainingFeature;
throwRuleFailedException(error,
	ECLASSEOBJECT, e_applyRuleEClassEObject, new ErrorInformation(source, feature));'''
)
	}
	
	@Test
	def testCompileImplMethod() {
		testFiles.testSimpleRule.
			parseAndAssertNoError.rules.get(0).
				compileImplMethod.
				assertGeneratedMember
(
'''
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
  }'''
)
	}

	@Test
	def testCompileValidatorCheckRuleMethod() {
		testFiles.testCheckRule.
			parseAndAssertNoError.checkrules.get(0).
				compileValidatorCheckRuleMethod.
				assertGeneratedMember
(
'''
@Check
  public void checkEObject(final EObject obj) {
    generateErrors(
    	xsemanticsSystem.checkEObject(obj),
    		obj);
  }'''
)
	}

	@Test
	def testNameOfExpressionInConclusion() {
		val rule = testFiles.testTwoExpressionsInConclusion.firstRule
		assertEqualsStrings("TwoExpressionsInConclusion_exp_1", 
			rule.expressionInConclusion(0).nameOfExpressionInConclusion
		)
		assertEqualsStrings("TwoExpressionsInConclusion_exp_2", 
			rule.expressionInConclusion(1).nameOfExpressionInConclusion
		)
	}
	
	def assertIssueField(CharSequence prog, CharSequence expected) {
		val field = inferrer.genIssueField(prog.firstRule)
		field.assertGeneratedMember(expected)
	}
	
	def assertConstructor(CharSequence prog, CharSequence expected) {
		val cons = inferrer.genConstructor(prog.parseAndAssertNoError)
		cons.simpleName = "ConstructorName"
		cons.assertGeneratedMember(expected)
	}
	
	def assertInit(CharSequence prog, CharSequence expected) {
		val m = inferrer.genInit(prog.parseAndAssertNoError)
		m.assertGeneratedMember(expected)
	}
	
	def assertErrorInformationArgs(CharSequence prog, CharSequence expected) {
		val a = createTestAppendable
		inferrer.errorInformationArgs(prog.parseAndAssertNoError.rules.get(0), a)
		assertEqualsStrings(expected, a.toString.trim)
	}
	
	def assertFinalThrow(CharSequence prog, CharSequence expected) {
		val a = createTestAppendable
		inferrer.compileFinalThrow(prog.parseAndAssertNoError.rules.get(0), a)
		assertEqualsStrings(expected, a.toString.trim)
	}
	
	def assertGeneratedMember(JvmMember member, CharSequence expected) {
		val a = createTestAppendable
		generator.generateMember(member, a, true)
		assertEqualsStrings(expected, a.toString.trim)
	}
	
	def assertGeneratedMembers(Iterable<? extends JvmMember> members, CharSequence expected) {
		val a = createTestAppendable
		members.forEach [
			generator.generateMember(it, a, false)
		]
		assertEqualsStrings(expected, a.toString.trim)
	}
	
	def createTestAppendable() {
		new FakeTreeAppendable(new ImportManager(true))
	}
	
}
