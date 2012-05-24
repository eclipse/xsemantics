package it.xsemantics.dsl.tests.generator

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
    throw new UnsupportedOperationException("typeis not implemented");
  }
  
  public Result2<EObject,EStructuralFeature> type(final RuleEnvironment _environment_, final EClass c) {
    throw new UnsupportedOperationException("typeis not implemented");
  }
  
  public Result2<EObject,EStructuralFeature> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    throw new UnsupportedOperationException("typeis not implemented");
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
