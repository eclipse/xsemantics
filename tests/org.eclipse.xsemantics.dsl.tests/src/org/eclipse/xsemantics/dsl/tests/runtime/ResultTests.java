/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

/**
 * 
 */
package org.eclipse.xsemantics.dsl.tests.runtime;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.Result3;
import org.eclipse.xsemantics.runtime.RuleFailedException;

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
		result = new Result<Object>(new RuleFailedException());
		Assert.assertTrue(result.failed());
	}

	@Test
	public void testResult3() {
		Result3<Object,Object,Object> result3 = new Result3<Object, Object, Object>("foo");
		Assert.assertEquals("foo", result3.getFirst());
		Assert.assertNull(result3.getSecond());
		Assert.assertNull(result3.getThird());
	}

}
