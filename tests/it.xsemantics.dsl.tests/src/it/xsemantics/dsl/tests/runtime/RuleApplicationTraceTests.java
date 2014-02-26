/**
 * 
 */
package it.xsemantics.dsl.tests.runtime;

import it.xsemantics.runtime.RuleApplicationTrace;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Lorenzo Bettini
 * 
 */
public class RuleApplicationTraceTests extends XsemanticsRuntimeAbstractTests {

	@Test
	public void testAddAsSubtraceNull() {
		RuleApplicationTrace t1 = new RuleApplicationTrace();
		t1.addAsSubtrace(null);
		Assert.assertTrue(t1.getTrace().isEmpty());
	}

	@Test
	public void testAddNull() {
		RuleApplicationTrace t1 = new RuleApplicationTrace();
		t1.addToTrace(null);
		Assert.assertTrue(t1.getTrace().isEmpty());
	}
}
