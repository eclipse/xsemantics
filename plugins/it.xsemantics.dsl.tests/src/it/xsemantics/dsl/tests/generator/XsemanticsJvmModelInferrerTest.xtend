package it.xsemantics.dsl.tests.generator

import com.google.inject.Inject
import it.xsemantics.dsl.jvmmodel.XsemanticsJvmModelInferrer
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.XsemanticsInjectorProviderCustom
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProviderCustom))
@RunWith(typeof(XtextRunner))
class XsemanticsJvmModelInferrerTest extends XsemanticsBaseTest {
	
	@Inject
	protected JvmModelGenerator generator
	
	@Inject
	protected XsemanticsJvmModelInferrer inferrer
	
	@Test
	def testSimpleRule() {
		assertRuleInference(testFiles.testSimpleRule,
'''public final static String ECLASSEOBJECT = "it.xsemantics.test.rules.EClassEObject";'''
		)
	}
	
	def assertRuleInference(CharSequence prog, CharSequence expected) {
		val field = inferrer.genIssueField(prog.firstRule)
		val a = new FakeTreeAppendable()
		generator.generateMember(field, a, true)
		assertEqualsStrings(expected, a.toString.trim)
	}
	
}
