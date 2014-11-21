/**
 * 
 */
package it.xsemantics.tests.swtbot;

import it.xsemantics.tests.swtbot.wizards.XsemanticsCreateExamplesProjectWizardTests;
import it.xsemantics.tests.swtbot.wizards.XsemanticsImportExamplesProjectWizardTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author bettini
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	XsemanticsCreateExamplesProjectWizardTests.class,
	XsemanticsImportExamplesProjectWizardTests.class
})
public class XsemanticsSwtbotTests {

}
