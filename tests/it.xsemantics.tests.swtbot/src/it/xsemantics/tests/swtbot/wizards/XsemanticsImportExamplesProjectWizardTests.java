/**
 * 
 */
package it.xsemantics.tests.swtbot.wizards;

import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.cleanWorkspace;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.waitForAutoBuild;
import static org.junit.Assert.assertTrue;
import it.xsemantics.tests.swtbot.XsemanticsSwtbotTestBase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.ListResult;
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
public class XsemanticsImportExamplesProjectWizardTests extends
		XsemanticsSwtbotTestBase {

	@After
	public void runAfterEveryTest() throws CoreException {
		// bot.sleep(2000);
		disableBuildAutomatically();
		cleanWorkspace();
		enableBuildAutomatically();
		waitForAutoBuild();
	}

	@Test
	public void canCreateExampleFJProjects() throws Exception {
		createExampleProjectsAndAssertNoErrorMarker("Xsemantics FJ Example",
				"it.xsemantics.example.fj");
		createExampleProjects("Xsemantics FJ (with cached type system) Example",
				"it.xsemantics.example.fjcached");
		waitForAutoBuild();
		
		// if we don't clean this project the fjcached project
		// presents an error in the xsemantics file...
		cleanProject("it.xsemantics.example.fj");
		
		waitForAutoBuildAndAssertNoErrors();
	}

	@Test
	public void canCreateExampleExpressionsProjects() throws Exception {
		createExampleProjectsAndAssertNoErrorMarker(
				"Xsemantics Expressions Example",
				"it.xsemantics.example.expressions");
	}

	@Test
	public void canCreateExampleLambdaProjects() throws Exception {
		createExampleProjectsAndAssertNoErrorMarker(
				"Xsemantics Lambda Example", "it.xsemantics.example.lambda");
	}

	protected void createExampleProjectsAndAssertNoErrorMarker(
			String projectType, String mainProjectId) throws CoreException {
		createExampleProjects(projectType, mainProjectId);

		waitForAutoBuildAndAssertNoErrors();
	}

	protected void createExampleProjects(String projectType,
			String mainProjectId) {
		SWTBotMenu fileMenu = bot.menu("File");
		SWTBotMenu newMenu = fileMenu.menu("New");
		SWTBotMenu otherMenu = newMenu.menu("Other...");
		otherMenu.click();

		SWTBotShell shell = bot.shell("New");
		shell.activate();
		SWTBotTreeItem xsemanticsNode = bot.tree().expandNode("Xsemantics");
		waitForNodes(xsemanticsNode);
		SWTBotTreeItem examplesNode = xsemanticsNode.expandNode("Examples");
		waitForNodes(examplesNode);
		examplesNode.expandNode(projectType).select();
		bot.button("Next >").click();

		bot.button("Finish").click();

		// creation of a project might require some time
		bot.waitUntil(shellCloses(shell), SHELL_TIMEOUT);
		assertTrue("Project doesn't exist", isProjectCreated(mainProjectId));
		assertTrue("Project doesn't exist", isProjectCreated(mainProjectId
				+ ".tests"));
		assertTrue("Project doesn't exist", isProjectCreated(mainProjectId
				+ ".ui"));
	}
	
	public void waitForNodes(final SWTBotTreeItem treeItem) {
		int retries = 3;
		int msecs = 2000;
		int count = 0;
		while (count < retries) {
			System.out.println("Checking that tree item " + treeItem.getText() + " has children...");
			List<SWTBotTreeItem> foundItems = UIThreadRunnable.syncExec(new ListResult<SWTBotTreeItem>() {
				public List<SWTBotTreeItem> run() {
					TreeItem[] items = treeItem.widget.getItems();
					List<SWTBotTreeItem> results = new ArrayList<SWTBotTreeItem>();
					for (TreeItem treeItem : items) {
						results.add(new SWTBotTreeItem(treeItem));
					}
					return results;
				}
			});
			if (foundItems.isEmpty()) {
				treeItem.collapse();
				System.out.println("No chilren... retrying in " + msecs + " milliseconds..."); //$NON-NLS-1$
				try {
					Thread.sleep(msecs);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				treeItem.expand();
			} else {
				System.out.println("Found " + foundItems.size() + " items. OK!");
				return;
			}
			
			count++;
		}
	}
}
