package it.xsemantics.dsl.tests.generator

import it.xsemantics.dsl.generator.UniqueNames
import static org.junit.Assert.*
import org.junit.Test

class UniqueNamesTest {
	
	static class TestUniqueNames extends UniqueNames {
		new () {
			max = 2
		}
	}

	@Test
	def void testUnique() {
		val UniqueNames names = new UniqueNames()
		assertEquals("first", names.createName("first"));
		assertEquals("first_1", names.createName("first"));
		assertEquals("first_2", names.createName("first"));
	}

	@Test
	def void testUniqueMax() {
		val UniqueNames names = new TestUniqueNames() 
		assertEquals("first", names.createName("first"));
		assertEquals("first_1", names.createName("first"));
		// the max has been reached
		assertEquals("first", names.createName("first"));
	}
	
}