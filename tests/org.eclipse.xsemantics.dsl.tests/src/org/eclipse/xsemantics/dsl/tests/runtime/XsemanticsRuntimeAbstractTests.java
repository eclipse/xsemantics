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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xsemantics.dsl.tests.EmfFactoryUtils;
import org.eclipse.xsemantics.runtime.Result2;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.junit.Assert;

/**
 * @author bettini
 * 
 */
public class XsemanticsRuntimeAbstractTests {

	protected EmfFactoryUtils emfUtils = new EmfFactoryUtils();

	protected <LeftT, RightT> void assertLeftRightPair(
			Result2<LeftT, RightT> result, LeftT expectedLeft,
			RightT expectedRight) {
		assertEquals(expectedLeft, result.getFirst());
		assertEquals(expectedRight, result.getSecond());
	}

	protected <LeftT, RightT> void assertLeftRightPairAsStrings(
			Result2<LeftT, RightT> result, String expectedLeft,
			String expectedRight) {
		assertEquals(expectedLeft, result.getFirst().toString());
		assertEquals(expectedRight, result.getSecond().toString());
	}

	protected void assertWrappedRuleFailedException(Exception e,
			String expectedMessage) {
		assertTrue("should be a WrappedException, instead of "
				+ e.getClass().getName(), e instanceof WrappedException);
		WrappedException wrappedException = (WrappedException) e;
		Exception exception = wrappedException.exception();
		assertRuleFailedException(exception, expectedMessage, null);
	}

	protected RuleFailedException assertRuleFailedException(Exception exception,
			String expectedMessage, String expectedIssue) {
		assertTrue("should be a RuleFailedException, instead of " + exception,
				exception instanceof RuleFailedException);
		assertEquals(expectedMessage, exception.getMessage());
		assertEquals(expectedIssue, ((RuleFailedException)exception).getIssue());
		return (RuleFailedException) exception;
	}

	protected void assertEqualsStrings(Object expected, Object actual) {
		Assert.assertEquals(
			("" + expected).replace("\r", ""), 
			("" + actual).replace("\r", "")
		);
	}
}
