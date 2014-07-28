/**
 * 
 */
package it.xsemantics.tests.swtbot.wizards;

import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.cleanWorkspace;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.waitForAutoBuild;
import static org.junit.Assert.assertTrue;
import it.xsemantics.tests.swtbot.XsemanticsSwtbotTestBase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author bettini
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class XsemanticsCreateExamplesProjectWizardTests extends
		XsemanticsSwtbotTestBase {

	@After
	public void runAfterEveryTest() throws CoreException {
		cleanWorkspace();
		waitForAutoBuild();
	}

	@Test
	public void canCreateANewLambdaProject() throws Exception {
		createProjectAndAssertNoErrorMarker("Lambda Project");
	}

	@Test
	public void canCreateANewFJProject() throws Exception {
		createProjectAndAssertNoErrorMarker("FJ Project");
	}

	@Test
	public void canCreateANewFJCachedProject() throws Exception {
		createProjectAndAssertNoErrorMarker("FJ (cached type system) Project");
	}

	@Test
	public void canCreateANewExpressionsProject() throws Exception {
		createProjectAndAssertNoErrorMarker("Expressions Project");

		// check that the Example.output is generated
		getProjectTreeItem(TEST_PROJECT).expand().getNode("src-gen").expand()
				.getNode("Example.output");
	}

	protected void createProjectAndAssertNoErrorMarker(String projectType)
			throws CoreException {
		SWTBotMenu fileMenu = bot.menu("File");
		SWTBotMenu newMenu = fileMenu.menu("New");
		SWTBotMenu projectMenu = newMenu.menu("Project...");
		projectMenu.click();

		SWTBotShell shell = bot.shell("New Project");
		shell.activate();
		SWTBotTreeItem xsemanticsNode = bot.tree().expandNode("Xsemantics");
		waitForTreeItems(xsemanticsNode);
		xsemanticsNode.expandNode(projectType).select();
		bot.button("Next >").click();

		bot.textWithLabel("Project name:").setText(TEST_PROJECT);

		bot.button("Finish").click();

		// creation of a project might require some time
		bot.waitUntil(shellCloses(shell), SHELL_TIMEOUT);
		assertTrue("Project doesn't exist", isProjectCreated(TEST_PROJECT));

		waitForAutoBuild();
		assertNoErrorsInProject();
	}

}
