/**
 * 
 */
package it.xsemantics.dsl.tests.runtime;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleFailedException;

/**
 * @author bettini
 * 
 */
public class ResultTests {

	protected Result<Object> result;

	@Before
	public void setUp() {
		result = new Result<Object>(null);
	}

	@Test
	public void testNoFailure() {
		Assert.assertFalse(result.failed());
	}
	
	@Test
	public void testFailure() {
		result.setRuleFailedException(new RuleFailedException());
		Assert.assertTrue(result.failed());
	}
	
	@Test
	public void testFailure2() {
		result = new Result<Object>(new RuleFailedException());
		Assert.assertTrue(result.failed());
	}
}
