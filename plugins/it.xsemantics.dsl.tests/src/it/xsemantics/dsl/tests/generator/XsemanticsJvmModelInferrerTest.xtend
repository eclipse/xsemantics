package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.jvmmodel.XsemanticsJvmModelInferrer
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.xbase.compiler.ImportManager

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
	
	def createTestAppendable() {
		new FakeTreeAppendable(new ImportManager(true))
	}
	
}
