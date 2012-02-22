package it.xsemantics.dsl.tests.runtime

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.dsl.tests.classes.CustomStringRepresentation
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class StringRepresentationTests extends XsemanticsBaseTest {
	
	@Inject extension CustomStringRepresentation
	
	@Test
	def testRule() {
		assertEqualsStrings("rule EClassEObject derives G |- EClass e...",
			testFiles.testSimpleRule.firstRule.string
		)
	}
	
	@Test
	def testSimpleJavaObject() {
		assertEqualsStrings("foo", "foo".string)
	}
	
	@Test
	def testList() {
		assertEqualsStrings("[foo, 10, true]", newArrayList("foo", 10, true).string)
	}
	
	@Test
	def testEmptyEnvironment() {
		testFiles.testSimpleRule.firstRule
		assertEqualsStrings("", new RuleEnvironment().string)
	}
	
	@Test
	def testEnvironmentWithMappings() {
		val env = new RuleEnvironment()
		env.add("foo", 1)
		val e = EcoreFactory::eINSTANCE.createEDataType
		e.name = "myEDataType"
		env.add(e, true)
		assertEqualsStrings("[foo <- 1, myEDataType <- true]", env.string)
	}
	
	@Test
	def testForCustom() {
		val eClass = EcoreFactory::eINSTANCE.createEClass
		eClass.name = "myEClass"
		assertEqualsStrings("EClass(name=myEClass)", eClass.string)
	}
	
	@Test
	def void testProcessOnString() {
		val testString = '''
		no new line
		some new
		lines
		'''
		assertEqualsStrings(testString, testString.toString.string)
	}
	
	@Test
	def testForLongEClassifierRep() {
		val e = EcoreFactory::eINSTANCE.createEDataType
		e.name = "myEDataType with very very very very very long desc"
		assertEqualsStrings(e.name, e.string)
	}
}