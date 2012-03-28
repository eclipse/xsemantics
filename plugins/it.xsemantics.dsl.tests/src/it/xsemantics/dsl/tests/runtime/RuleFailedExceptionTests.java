/**
 * 
 */
package it.xsemantics.dsl.tests.runtime;

import org.junit.Test;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.RuleFailedException;

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

	protected void assertMessage(RuleFailedException ex, String message) {
		assertEquals(message, ex.getMessage());
	}
}
