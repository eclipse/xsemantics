/**
 * 
 */
package it.xsemantics.dsl.tests.runtime;

import it.xsemantics.runtime.RuleApplicationTrace
import it.xsemantics.runtime.TraceUtils
import org.junit.Assert
import org.junit.Test

/**
 * @author Lorenzo Bettini
 * 
 */
public class RuleApplicationTraceTests extends XsemanticsRuntimeAbstractTests {
	
	extension TraceUtils = new TraceUtils
	
	static class TestRuleApplicationTraceSubclass extends RuleApplicationTrace {
		
	}

	/**
	 * throws an InstantionException after the first instance is created: this
	 * is used to test snapshot: in the presence of exceptions snapshot simply returns
	 * the same trace
	 */
	static class TestRuleApplicationTraceWithInstantiationException extends RuleApplicationTrace {
		static var first = false
		new () {
			if (first) {
				throw new InstantiationException
			} else {
				first = true
			}
		}
	}

	/**
	 * throws an IllegalAccessException after the first instance is created: this
	 * is used to test snapshot: in the presence of exceptions snapshot simply returns
	 * the same trace
	 */
	static class TestRuleApplicationTraceWithIllegalAccessException extends RuleApplicationTrace {
		static var first = false
		new () {
			if (first) {
				throw new IllegalAccessException
			} else {
				first = true
			}
		}
	}

	@Test
	def void testAddAsSubtraceNull() {
		val t1 = new RuleApplicationTrace();
		t1.addAsSubtrace(null as RuleApplicationTrace);
		Assert.assertTrue(t1.isEmpty());
		t1.addObjectAsSubtrace(null as Object);
		Assert.assertTrue(t1.isEmpty());
	}

	@Test
	def void testAddNull() {
		val t1 = new RuleApplicationTrace();
		t1.addToTrace(null);
		Assert.assertTrue(t1.isEmpty());
	}

	@Test
	def void testAddObjectAsSubtraceNull() {
		val t1 = new RuleApplicationTrace();
		t1.addToTrace("first");
		t1.addObjectAsSubtrace("nested");
		'''
		first
		 nested'''.assertEqualsStrings(t1.traceAsString);
	}

	@Test
	def void testSnapshot() {
		val t1 = new RuleApplicationTrace();
		Assert.assertTrue(t1.snapshot().isEmpty());
		
		val s1 = "first";
		t1.addToTrace(s1);
		val t2 = t1.snapshot();
		assertEquals("first", t2.traceAsString);
		// modify the string in the first trace
		t1.getTrace().set(0, "modified");
		assertEquals("first", t2.traceAsString);
		
		val subTrace = new RuleApplicationTrace
		subTrace.addToTrace("second")
		t1.addAsSubtrace(subTrace)
'''modified
 second'''.assertEqualsStrings(t1.traceAsString);
 		assertEquals("first", t2.traceAsString);
 		
 		val t3 = t1.snapshot
'''modified
 second'''.assertEqualsStrings(t3.traceAsString);
 
 		subTrace.getTrace().set(0, "modified2");
'''modified
 modified2'''.assertEqualsStrings(t1.traceAsString);
'''modified
 second'''.assertEqualsStrings(t3.traceAsString);
	}

	@Test
	def void testSnapshotWithSubclass() {
		val t1 = new TestRuleApplicationTraceSubclass
		assertEquals(TestRuleApplicationTraceSubclass, t1.snapshot.class)
	}

	@Test
	def void testSnapshotWithInstantionExceptionReturnsThis() {
		val t1 = new TestRuleApplicationTraceWithInstantiationException
		assertSame(t1, t1.snapshot)
	}

	@Test
	def void testSnapshotWithIllegalAccessExceptionReturnsThis() {
		val t1 = new TestRuleApplicationTraceWithIllegalAccessException
		assertSame(t1, t1.snapshot)
	}
}
