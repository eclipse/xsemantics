/**
 * 
 */
package it.xsemantics.dsl.tests.runtime;

import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.RuleFailedException;

/**
 * @author bettini
 * 
 */
public class RuleFailedExceptionTests extends XsemanticsRuntimeAbstractTests {

	public void testMessage() {
		RuleFailedException ex = new RuleFailedException("message");
		assertMessage(ex, "message");
	}

	public void testIssue() {
		RuleFailedException ex = new RuleFailedException("message", "issue",
				null);
		assertMessage(ex, "message");
		assertEquals("issue", ex.getIssue());
	}

	public void testErrorInformationsNotNull() {
		assertTrue(new RuleFailedException("foo").getErrorInformations() != null);
	}

	public void testMessageAndErrorInformation() {
		RuleFailedException ex = new RuleFailedException("message");
		ex.addErrorInformation(new ErrorInformation(emfUtils.createEObject()));
		assertMessage(ex, "message");
		assertTrue(ex.getErrorInformations().get(0).getSource() != null);
	}

	public void testMessageAndErrorInformations() {
		RuleFailedException ex = new RuleFailedException("message");
		ex.addErrorInformations(new ErrorInformation(emfUtils.createEObject()),
				new ErrorInformation(emfUtils.createEObject()));
		assertMessage(ex, "message");
		assertTrue(ex.getErrorInformations().get(0).getSource() != null);
		assertTrue(ex.getErrorInformations().get(1).getSource() != null);
	}

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
