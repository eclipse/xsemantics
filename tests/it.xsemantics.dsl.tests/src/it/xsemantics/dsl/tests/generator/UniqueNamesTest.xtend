package it.xsemantics.dsl.tests.generator

import it.xsemantics.dsl.generator.UniqueNames
import static org.junit.Assert.*
import org.junit.Test

class UniqueNamesTest {

	@Test
	def void testUnique() {
		val UniqueNames names = new UniqueNames()
		assertEquals("first", names.createName("first"));
		assertEquals("first_1", names.createName("first"));
	}
	
}