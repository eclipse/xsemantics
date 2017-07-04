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

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.RuleFailedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * @author bettini
 * 
 */
public class RuleFailedExceptionTests extends XsemanticsRuntimeAbstractTests {

	@Test
	public void testMessage() {
		RuleFailedException ex = new RuleFailedException("message");
		assertMessage(ex, "message");
	}

	@Test
	public void testIssue() {
		RuleFailedException ex = new RuleFailedException("message", "issue",
				null);
		assertMessage(ex, "message");
		assertEquals("issue", ex.getIssue());
	}

	@Test
	public void testErrorInformationsNotNull() {
		assertTrue(new RuleFailedException("foo").getErrorInformations() != null);
	}

	@Test
	public void testMessageAndErrorInformation() {
		RuleFailedException ex = new RuleFailedException("message");
		ex.addErrorInformation(new ErrorInformation(emfUtils.createEObject()));
		assertMessage(ex, "message");
		assertTrue(ex.getErrorInformations().get(0).getSource() != null);
	}

	@Test
	public void testMessageAndErrorInformations() {
		RuleFailedException ex = new RuleFailedException("message");
		ex.addErrorInformations(new ErrorInformation(emfUtils.createEObject()),
				new ErrorInformation(emfUtils.createEObject()));
		assertMessage(ex, "message");
		assertTrue(ex.getErrorInformations().get(0).getSource() != null);
		assertTrue(ex.getErrorInformations().get(1).getSource() != null);
	}

	@Test
	public void testMessageAndEmptyErrorInformations() {
		RuleFailedException ex = new RuleFailedException("message");
		ex.addErrorInformations();
		assertMessage(ex, "message");
		assertTrue(ex.getErrorInformations().isEmpty());
	}

	@Test
	public void testSerialization() throws IOException {
		RuleFailedException ex = new RuleFailedException("message");
		ex.addErrorInformations(new ErrorInformation(emfUtils.createEObject()),
				new ErrorInformation(emfUtils.createEObject()));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(ex);
        out.close();
	}

	protected void assertMessage(RuleFailedException ex, String message) {
		assertEquals(message, ex.getMessage());
	}
}
