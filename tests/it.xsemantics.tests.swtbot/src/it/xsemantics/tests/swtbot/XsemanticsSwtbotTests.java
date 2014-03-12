/**
 * 
 */
package it.xsemantics.tests.swtbot;

import it.xsemantics.tests.swtbot.imports.XsemanticsXImportTests;
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
	XsemanticsXImportTests.class,
	XsemanticsCreateExamplesProjectWizardTests.class,
	XsemanticsImportExamplesProjectWizardTests.class
})
public class XsemanticsSwtbotTests {

}
