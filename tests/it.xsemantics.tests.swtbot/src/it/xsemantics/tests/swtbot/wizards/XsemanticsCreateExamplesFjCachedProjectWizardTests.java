/**
 * 
 */
package it.xsemantics.tests.swtbot.wizards;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.cleanWorkspace;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.waitForBuild;

import it.xsemantics.tests.swtbot.XsemanticsSwtbotTestBase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author bettini
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class XsemanticsCreateExamplesFjCachedProjectWizardTests extends XsemanticsSwtbotTestBase {

	@After
	public void runAfterEveryTest() throws CoreException {
		cleanWorkspace();
		waitForBuild();
	}

	@Test
	public void canCreateANewFJCachedProject() throws Exception {
		createProjectAndAssertNoErrorMarker("FJ (cached type system) Project");
	}

}
