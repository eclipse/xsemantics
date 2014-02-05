package it.xsemantics.dsl.tests

import com.google.inject.Inject
import it.xsemantics.dsl.XsemanticsInjectorProvider
import org.junit.Assert
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class QualifiedNameTest extends XsemanticsBaseTest {

	@Inject extension IQualifiedNameProvider
	
	@Test
	def void testParsingOfName() {
		val rule = parse(testFiles.testSimpleRule).getRules.get(0)
		Assert::assertEquals("it.xsemantics.test.TypeSystem.EClassEObject",
			rule.fullyQualifiedName.toString
		)
	}
	
}