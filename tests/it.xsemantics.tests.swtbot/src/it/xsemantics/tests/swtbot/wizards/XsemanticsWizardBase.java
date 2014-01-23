/**
 * 
 */
package it.xsemantics.tests.swtbot.wizards;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.root;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.PlatformUI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * @author bettini
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class XsemanticsWizardBase {

	protected static final String TEST_PROJECT = "MyTestProject";
	protected static SWTWorkbenchBot bot;
	protected static int SHELL_TIMEOUT = 150000;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
		
		closeWelcomePage();

//		// Change the perspective via the Open Perspective dialog
//		bot.menu("Window").menu("Open Perspective").menu("Other...").click();
//		SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
//		openPerspectiveShell.activate();
//
//		// select the dialog
//		bot.table().select("Plug-in Development");
//		bot.button("OK").click();
//
//		// the following two lines tend to fail with SwtBot 2.2.0
//		bot.viewByTitle("Error Log").close();
//		bot.viewByTitle("Problems").show();
	}
	
	@AfterClass
	public static void afterClass() {
		bot.resetWorkbench();
	}

	protected static void closeWelcomePage() throws InterruptedException {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				if (PlatformUI.getWorkbench().getIntroManager().getIntro() != null) {
					PlatformUI.getWorkbench().getIntroManager()
							.closeIntro(PlatformUI.getWorkbench().getIntroManager().getIntro());
				}
			}
		});
	}

	protected void disableBuildAutomatically() {
		clickOnBuildAutomatically(false);
	}

	protected void enableBuildAutomatically() {
		clickOnBuildAutomatically(true);
	}

	private void clickOnBuildAutomatically(boolean shouldBeEnabled) {
		if (buildAutomaticallyMenu().isChecked() == shouldBeEnabled)
			return;
		// see http://www.eclipse.org/forums/index.php/mv/msg/165852/#msg_525521
		// for the reason why we need to specify 1
		buildAutomaticallyMenu().click();
		assertEquals(shouldBeEnabled, buildAutomaticallyMenu().isChecked());
	}

	private SWTBotMenu buildAutomaticallyMenu() {
		return bot.menu("Project", 1).menu("Build Automatically");
	}

	protected boolean isProjectCreated(String name) {
		try {
			getProjectTreeItem(name);
			return true;
		} catch (WidgetNotFoundException e) {
			return false;
		}
	}

	protected static SWTBotTree getProjectTree() {
		SWTBotView projectExplorer = getProjectExplorer();
		SWTBotTree tree = projectExplorer.bot().tree();
		return tree;
	}

	protected static SWTBotView getProjectExplorer() {
		SWTBotView view = bot.viewByTitle("Project Explorer");
		return view;
	}

	protected SWTBotTreeItem getProjectTreeItem(String myTestProject) {
		return getProjectTree().getTreeItem(myTestProject);
	}

	protected void assertNoErrorsInProject() throws CoreException {
		IMarker[] markers = root().findMarkers(IMarker.PROBLEM, true,
				IResource.DEPTH_INFINITE);
		List<IMarker> errorMarkers = new LinkedList<IMarker>();
		for (int i = 0; i < markers.length; i++) {
			IMarker iMarker = markers[i];
			if (iMarker.getAttribute(IMarker.SEVERITY).toString()
					.equals("" + IMarker.SEVERITY_ERROR)) {
				errorMarkers.add(iMarker);
			}
		}
		assertEquals(
				"expected no error markers: " + printMarkers(errorMarkers), 0,
				errorMarkers.size());
	}

	private String printMarkers(List<IMarker> errorMarkers) {
		StringBuffer buffer = new StringBuffer();
		for (IMarker iMarker : errorMarkers) {
			try {
				buffer.append(iMarker.getAttribute(IMarker.MESSAGE) + "\n");
				buffer.append(iMarker.getAttribute(IMarker.SEVERITY) + "\n");
			} catch (CoreException e) {
			}
		}
		return buffer.toString();
	}

}
