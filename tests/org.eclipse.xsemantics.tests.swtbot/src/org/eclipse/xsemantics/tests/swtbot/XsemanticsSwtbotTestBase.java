/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

/**
 * 
 */
package org.eclipse.xsemantics.tests.swtbot;

import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses;
import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.monitor;
import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.root;
import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.waitForBuild;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
import org.eclipse.pde.internal.ui.IPDEUIConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.ListResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * @author bettini
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public abstract class XsemanticsSwtbotTestBase {

	protected static final String TEST_PROJECT = "MyTestProject";
	protected static SWTWorkbenchBot bot;
	protected static int SHELL_TIMEOUT = 150000;

	@BeforeClass
	public static void beforeClass() throws Exception {
		bot = new SWTWorkbenchBot();
		
		closeWelcomePage();

		// Change the perspective via the Open Perspective dialog
		// Using the menus does not seem to be reliable, so we change
		// the perspective programmatically
//		SWTBotMenu windowMenu = bot.menu("Window");
//		SWTBotMenu openPerspectiveMenu = windowMenu.menu("Open Perspective");
//		SWTBotMenu otherMenu = openPerspectiveMenu.menu("Other...");
//		otherMenu.click();
//		SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
//		openPerspectiveShell.activate();
//
//		// select the dialog
//		bot.table().select("Plug-in Development");
//		bot.button("OK").click();
		openPluginPerspective();

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
		
		SWTBotShell activeShell = null;
		int retry = 0;
		System.out.println("Checking active shell...");
		while (activeShell == null) {
			try {
				activeShell = bot.activeShell();
			} catch (WidgetNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println("Retrying in 10 seconds...");
				bot.sleep(10000);
				if (++retry > 5) {
					System.out.println("Shell is null after " + retry + " tries");
					break;
				}
			}
		}
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

	protected static void openPluginPerspective() throws InterruptedException {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					PlatformUI.getWorkbench().showPerspective(IPDEUIConstants.PERSPECTIVE_ID,       
					         PlatformUI.getWorkbench().getActiveWorkbenchWindow());
				} catch (WorkbenchException e) {
					e.printStackTrace();
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
		SWTBotTree tree = getProjectExplorer().bot().tree();
		return tree;
	}

	protected static SWTBotView getProjectExplorer() {
		SWTBotView view = bot.viewByTitle("Project Explorer");
		return view;
	}

	protected SWTBotTreeItem getProjectTreeItem(String myTestProject) {
		return getProjectTree().getTreeItem(myTestProject);
	}

	protected void waitForBuildAndAssertNoErrors() throws CoreException {
		waitForBuild();
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

	public void waitForTreeItems(final SWTBotTreeItem treeItem) {
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
			} else if (foundItems.size() == 1 && foundItems.get(0).getText().trim().isEmpty()) {
				treeItem.collapse();
				System.out.println("Only one child with empty text... retrying in " + msecs + " milliseconds..."); //$NON-NLS-1$
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

	protected void createProjectAndAssertNoErrorMarker(String projectType) throws CoreException {
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
	
		waitForBuild();
		assertNoErrorsInProject();
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
				buffer.append(iMarker.getResource() + "\n");
				buffer.append(iMarker.getAttribute(IMarker.MESSAGE) + "\n");
				buffer.append(iMarker.getAttribute(IMarker.SEVERITY) + "\n");
			} catch (CoreException e) {
			}
		}
		return buffer.toString();
	}

}
