/**
 * 
 */
package it.xsemantics.tests.swtbot;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.monitor;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.root;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.waitForAutoBuild;
import static org.junit.Assert.assertEquals;
import it.xsemantics.tests.pde.utils.PDETargetPlatformUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
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
public class XsemanticsSwtbotTestBase {

	protected static final String TEST_PROJECT = "MyTestProject";
	protected static SWTWorkbenchBot bot;
	protected static int SHELL_TIMEOUT = 150000;

	@BeforeClass
	public static void beforeClass() throws Exception {
		PDETargetPlatformUtils.setTargetPlatform();
		
		bot = new SWTWorkbenchBot();
		
		closeWelcomePage();

		// Change the perspective via the Open Perspective dialog
		SWTBotMenu windowMenu = bot.menu("Window");
		SWTBotMenu openPerspectiveMenu = windowMenu.menu("Open Perspective");
		SWTBotMenu otherMenu = openPerspectiveMenu.menu("Other...");
		otherMenu.click();
		SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
		openPerspectiveShell.activate();

		// select the dialog
		bot.table().select("Plug-in Development");
		bot.button("OK").click();

		// in SwtBot 2.2.0 we must use part name since the title
		// of the problems view also contains the items count
		// see also http://www.eclipse.org/forums/index.php/t/640194/
		
		// Error Log view is disturbing since it often shows up
		// and gets the focus, breaking many of our tests, so it's crucial
		// to close it right away.
		// Unfortunately, before Luna, the Error Log view was enabled by
		// default in Plug-in Development perspective, but in Luna it is
		// there anymore.
		if (!isLuna()) {
			bot.viewByPartName("Error Log").close();
		}
		bot.viewByPartName("Problems").show();
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

	protected static boolean isLuna() {
		String version = Platform.getBundle(PlatformUI.PLUGIN_ID).getHeaders()
				.get("Bundle-Version");

		Pattern versionPattern = Pattern.compile("\\d+\\.(\\d+)\\..*");
		Matcher m = versionPattern.matcher(version);
		if (m.matches()) {
			// org.eclipse.ui has minor number 106 for Luna
			int minorVersion = Integer.parseInt(m.group(1));
			if (minorVersion >= 106) {
				return true;
			}
		}

		return false;
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
		SWTBotTree tree = getPackageExplorer().bot().tree();
		return tree;
	}

	protected static SWTBotView getPackageExplorer() {
		SWTBotView view = bot.viewByTitle("Package Explorer");
		return view;
	}

	protected SWTBotTreeItem getProjectTreeItem(String myTestProject) {
		return getProjectTree().getTreeItem(myTestProject);
	}

	protected void waitForAutoBuildAndAssertNoErrors() throws CoreException {
		waitForAutoBuild();
		assertNoErrorsInProject();
	}

	protected void cleanProject(String projectName) throws CoreException {
		root().getProject(projectName).build(
				IncrementalProjectBuilder.CLEAN_BUILD, monitor());
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_MANUAL_BUILD,
						null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	protected static void assertNoErrorsInProject() throws CoreException {
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

	private static String printMarkers(List<IMarker> errorMarkers) {
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
