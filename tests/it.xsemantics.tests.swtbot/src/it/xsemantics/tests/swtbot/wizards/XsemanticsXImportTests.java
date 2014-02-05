/**
 * 
 */
package it.xsemantics.tests.swtbot.wizards;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.cleanWorkspace;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.waitForAutoBuild;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Lorenzo Bettini
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class XsemanticsXImportTests extends
		XsemanticsWizardBase {

	@After
	public void runAfterEveryTest() throws CoreException {
		// bot.sleep(2000);
		//disableBuildAutomatically();
		cleanWorkspace();
		//enableBuildAutomatically();
		waitForAutoBuild();
	}

	@Test
	public void createTestProject() throws CoreException {
		createExampleProjectsAndAssertNoErrorMarker();
	}

	protected void createExampleProjectsAndAssertNoErrorMarker() throws CoreException {
		bot.menu("File").menu("New").menu("Plug-in Project").click();
		bot.text().setText("MyTestProject");
		bot.button("Next >").click();
		bot.button("Finish").click();
		
		bot.tree().getTreeItem("MyTestProject").
			contextMenu("Configure").menu("Add Xtext Nature").click();
		
//		bot.tree().getTreeItem("MyTestProject").getNode("src").expand();
//		bot.tree().getTreeItem("MyTestProject").getNode("src").getNode("mytestproject").expand();
//		bot.tree().getTreeItem("MyTestProject").getNode("src").getNode("mytestproject").select();
//		bot.text().setText("MyTest.xsemantics");
//		bot.button("Finish").click();
//		bot.button("Yes").click();
//		bot.tree().getTreeItem("MyTestProject").getNode("src").getNode("mytestproject").getNode("MyTest.xsemantics").select();
//		bot.tree().getTreeItem("MyTestProject").getNode("src").getNode("mytestproject").getNode("MyTest.xsemantics").select();
		

		waitForAutoBuild();
		assertNoErrorsInProject();
	}
}
