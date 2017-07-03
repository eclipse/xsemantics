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
package it.xsemantics.dsl.tests.runtime;

import it.xsemantics.dsl.tests.XsemanticsAbstractTests;
import it.xsemantics.runtime.Result2;
import it.xsemantics.runtime.RuleFailedException;

import org.eclipse.emf.common.util.WrappedException;

/**
 * @author bettini
 * 
 */
public class XsemanticsRuntimeAbstractTests extends XsemanticsAbstractTests {

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
}
