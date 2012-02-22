package it.xsemantics.dsl.tests.generator

import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.generator.UniqueNames
import junit.framework.Assert
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class UniqueNamesTest extends XsemanticsGeneratorBaseTest {

	@Test
	def void testUnique() {
		val UniqueNames names = new UniqueNames()
		Assert::assertEquals("first", names.createName("first"));
		Assert::assertEquals("first_1", names.createName("first"));
	}
	
}