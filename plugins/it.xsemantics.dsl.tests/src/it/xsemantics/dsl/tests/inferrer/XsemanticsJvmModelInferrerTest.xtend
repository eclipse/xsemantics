package it.xsemantics.dsl.tests.inferrer

import com.google.inject.Inject
import it.xsemantics.dsl.jvmmodel.TempJvmModelInferrer
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderForInferrer
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable
import org.junit.Test
import org.junit.runner.RunWith

import static extension junit.framework.Assert.*

@InjectWith(typeof(XsemanticsInjectorProviderForInferrer))
@RunWith(typeof(XtextRunner))
class XsemanticsJvmModelInferrerTest extends XsemanticsBaseTest {
	
	@Inject
	protected JvmModelGenerator generator
	
	@Inject
	protected extension TempJvmModelInferrer inferrer
	
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
	def testApplyMethods() {
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
    Result2<EObject, EStructuralFeature> result = type2Internal(G, _trace_, eClass);
    checkAssignableTo(result.getFirst(), EObject.class);
    object = (EObject) result.getFirst();
    checkAssignableTo(result.getSecond(), EStructuralFeature.class);
    feat = (EStructuralFeature) result.getSecond();
    
    return new Result2<EObject,EStructuralFeature>(object, feat);
  }'''
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
