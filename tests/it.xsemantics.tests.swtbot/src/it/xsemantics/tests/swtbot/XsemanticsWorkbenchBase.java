/**
 * 
 */
package it.xsemantics.tests.swtbot;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.cleanWorkspace;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.waitForAutoBuild;
import it.xsemantics.dsl.tests.utils.ui.PluginProjectHelper;
import it.xsemantics.dsl.ui.internal.XsemanticsActivator;

import java.util.Arrays;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.google.inject.Injector;

/**
 * @author Lorenzo Bettini
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class XsemanticsWorkbenchBase extends XsemanticsSwtbotTestBase {

	protected static final String TEST_FILE = "mytest.xsemantics";

	@BeforeClass
	public static void setupProjectForTesting() throws Exception {
		Injector injector = XsemanticsActivator.getInstance().getInjector(XsemanticsActivator.IT_XSEMANTICS_DSL_XSEMANTICS);
		
		PluginProjectHelper projectHelper = injector.getInstance(PluginProjectHelper.class);
		
		projectHelper.createJavaPluginProject
			(TEST_PROJECT, Arrays.asList("it.xsemantics.runtime"));
		
//		SWTBotMenu fileMenu = bot.menu("File");
//		SWTBotMenu newMenu = fileMenu.menu("New");
//		SWTBotMenu pluginProjectMenu = newMenu.menu("Plug-in Project");
//		pluginProjectMenu.click();
//		bot.text().setText(TEST_PROJECT);
//		bot.button("Next >").click();
//		bot.button("Finish").click();
//
//		bot.tree().getTreeItem(TEST_PROJECT).contextMenu("Configure")
//				.menu("Add Xtext Nature").click();

		bot.tree().getTreeItem(TEST_PROJECT).expand().getNode("src").contextMenu("New").menu("File").click();
		bot.textWithLabel("File name:").setText(TEST_FILE);
		bot.button("Finish").click();
		// bot.tree().getTreeItem("MyTestProject").getNode("src").getNode("mytestproject").getNode("MyTest.xsemantics").select();
		// bot.tree().getTreeItem("MyTestProject").getNode("src").getNode("mytestproject").getNode("MyTest.xsemantics").select();

		waitForAutoBuild();
	}

	@AfterClass
	public static void cleanWorkbench() throws CoreException {
		// bot.sleep(2000);
		cleanWorkspace();
		waitForAutoBuild();
	}

	protected SWTBotEditor setEditorContents(CharSequence text) {
		testEditor().toTextEditor().setText(text.toString());
		testEditor().save();
		return testEditor();
	}

	protected void assertEditorText(CharSequence expected) {
		Assert.assertEquals(expected.toString().replace("\r", ""), testEditor()
				.toTextEditor().getText().replace("\r", ""));
	}

	protected SWTBotEditor testEditor() {
		return bot.editorByTitle(TEST_FILE);
	}

}
