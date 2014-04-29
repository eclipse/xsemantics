/**
 * 
 */
package it.xsemantics.dsl.tests.runtime;

import it.xsemantics.runtime.RuleApplicationTrace;

import org.junit.Assert;
import org.junit.Test;
import it.xsemantics.runtime.util.TraceUtils

/**
 * @author Lorenzo Bettini
 * 
 */
public class RuleApplicationTraceTests extends XsemanticsRuntimeAbstractTests {
	
	extension TraceUtils = new TraceUtils

	@Test
	def void testAddAsSubtraceNull() {
		val t1 = new RuleApplicationTrace();
		t1.addAsSubtrace(null);
		Assert.assertTrue(t1.isEmpty());
	}

	@Test
	def void testAddNull() {
		val t1 = new RuleApplicationTrace();
		t1.addToTrace(null);
		Assert.assertTrue(t1.isEmpty());
	}

	@Test
	def void testSnapshot() throws CloneNotSupportedException {
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
		assertEquals(
'''modified
 second'''.toString, t1.traceAsString);
 		assertEquals("first", t2.traceAsString);
 		
 		val t3 = t1.snapshot
 		assertEquals(
'''modified
 second'''.toString, t3.traceAsString);
 
 		subTrace.getTrace().set(0, "modified2");
 		assertEquals(
'''modified
 modified2'''.toString, t1.traceAsString);
 		assertEquals(
'''modified
 second'''.toString, t3.traceAsString);
	}
}
