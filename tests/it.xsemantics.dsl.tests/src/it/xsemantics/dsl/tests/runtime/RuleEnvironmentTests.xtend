package it.xsemantics.dsl.tests.runtime

import it.xsemantics.dsl.XsemanticsInjectorProvider
import it.xsemantics.dsl.tests.XsemanticsBaseTest
import it.xsemantics.runtime.RuleEnvironment
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*
import it.xsemantics.runtime.RuleEnvironmentEntry

/**
 * These are tests for situation not covered in the entire Xsemantics test suite.
 * 
 * @author Lorenzo Bettini
 */
@InjectWith(typeof(XsemanticsInjectorProvider))
@RunWith(typeof(XtextRunner))
class RuleEnvironmentTests extends XsemanticsBaseTest {
	
	@Test
	def void testPassNullToConstructor() {
		new RuleEnvironment(null as RuleEnvironment).environment.assertNotNull
	}

	@Test
	def void testRuleEnvironmentToString() {
		"".assertEquals(new RuleEnvironment().toString)
		
		val ruleEnvironment = new RuleEnvironment() => [
						add("foo", 1)
						add("bar", 2)
					]
		val ruleEnvironment1 = new RuleEnvironment() => [
						add("foo1", 1)
						add("bar1", 2)
					]
		"foo -> 1, bar -> 2".assertEquals(
			(ruleEnvironment).toString)
		
		ruleEnvironment.setNext(ruleEnvironment1)
		"foo -> 1, bar -> 2 :: [foo1 -> 1, bar1 -> 2]".assertEquals(
			ruleEnvironment.toString)
		
		ruleEnvironment1.setNext(new RuleEnvironmentEntry("foo2", 1))
		
		"foo -> 1, bar -> 2 :: [foo1 -> 1, bar1 -> 2 :: [foo2 -> 1]]".assertEquals(
			ruleEnvironment.toString)
	}

	@Test
	def void testCheckExists() {
		val ruleEnvironment = new RuleEnvironment() => [
			add("foo", 1)
		]
		ruleEnvironment.add("foo", 2, true).assertFalse
		ruleEnvironment.add("bar", 2, true).assertTrue
	}

	@Test
	def void testGetWithNext() {
		val ruleEnvironment = new RuleEnvironment() => [
			add("foo", 1)
		]
		val ruleEnvironment1 = new RuleEnvironment() => [
			add("foo1", 1)
		]
		ruleEnvironment.setNext(ruleEnvironment1)
		ruleEnvironment.get("foo1").assertEquals(1)
	}

	@Test
	def void testIncrement() {
		val ruleEnvironment = new RuleEnvironment() => [
			add("foo", 1)
			add("bar", 1)
		]
		val ruleEnvironment1 = new RuleEnvironment() => [
			add("foo1", 1)
			add("foo", 2)
		]
		
		ruleEnvironment.increment(null as RuleEnvironment)
		// nothing changes
		"foo -> 1, bar -> 1".assertEquals(ruleEnvironment.toString)
		
		ruleEnvironment.increment(ruleEnvironment1)
		2.assertEquals(ruleEnvironment.get("foo")) // overwritten mapping
		1.assertEquals(ruleEnvironment.get("bar"))
		1.assertEquals(ruleEnvironment.get("foo1"))
		
		ruleEnvironment.increment(new RuleEnvironmentEntry("foo1", 2))
		2.assertEquals(ruleEnvironment.get("foo")) 
		1.assertEquals(ruleEnvironment.get("bar"))
		2.assertEquals(ruleEnvironment.get("foo1")) // overwritten mapping
	}

	@Test
	def void testDecrement() {
		val ruleEnvironment = new RuleEnvironment() => [
			add("foo", 1)
			add("bar", 1)
		]
		val ruleEnvironment1 = new RuleEnvironment() => [
			add("foo1", 1)
			add("foo", 2)
		]
		
		ruleEnvironment.decrement(null as RuleEnvironment)
		// nothing changes
		"foo -> 1, bar -> 1".assertEquals(ruleEnvironment.toString)
		
		ruleEnvironment.decrement(ruleEnvironment1)
		assertNull(ruleEnvironment.get("foo")) // removed mapping
		1.assertEquals(ruleEnvironment.get("bar"))
		assertNull(ruleEnvironment.get("foo1"))
		
		ruleEnvironment.decrement("bar")
		ruleEnvironment.empty.assertTrue
	}

	@Test
	def void testUnion() {
		val ruleEnvironment = new RuleEnvironment() => [
			add("foo", 1)
			add("bar", 1)
		]
		val ruleEnvironment1 = new RuleEnvironment() => [
			add("foo1", 1)
		]
		val ruleEnvironment2 = new RuleEnvironment() => [
			add("foo1", 1)
			add("foo", 2)
		]
		
		ruleEnvironment.union(null as RuleEnvironment).assertTrue
		
		ruleEnvironment.union(ruleEnvironment1).assertTrue
		1.assertEquals(ruleEnvironment.get("foo")) // overwritten mapping
		1.assertEquals(ruleEnvironment.get("bar"))
		1.assertEquals(ruleEnvironment.get("foo1"))
		
		ruleEnvironment.union(new RuleEnvironmentEntry("foo", 2)).assertFalse
		
		ruleEnvironment.union(ruleEnvironment2).assertFalse
	}
	
}