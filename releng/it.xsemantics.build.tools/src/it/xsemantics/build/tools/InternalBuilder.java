/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package it.xsemantics.build.tools;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.JavaCore;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @author Lorenzo Bettini - modified to wait for auto build
 */
public class InternalBuilder {

	@Test
	public void buildInEclipse() throws CoreException {
		long maxMem = Runtime.getRuntime().maxMemory() / (1024 * 1024);
		long free = Runtime.getRuntime().freeMemory() / (1024 * 1024);
		long used = Runtime.getRuntime().totalMemory() / (1024 * 1024);
		System.out.println("Starting build. Memory max=" + maxMem + "m, total=" + used + "m, free=" + free + "m");
		
		clearJdtIndex();
		
		//ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
		setAutoBuild(true);
		printMessage("Cleaning...");
		cleanBuild();
		printMessage("Waiting for autobuild...");
		waitForBuild();
//		printMessage("Full build...");
//		fullBuild();
//		printMessage("Waiting for autobuild...");
//		waitForBuild();
		setAutoBuild(false);
		
		clearJdtIndex();
		
		final IMarker[] markers = ResourcesPlugin.getWorkspace().getRoot()
				.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		
		Arrays.sort(markers, new Comparator<IMarker>() {
			public int compare(IMarker a, IMarker b) {
				try {
					long diff = a.getCreationTime() - b.getCreationTime();
					return diff > 0 ? 1 : (diff < 0 ? -1 : 0);
				} catch (CoreException e) {
					return 0;
				}
			}
		});
		
		int errors = 0;
		for (IMarker problem : markers) {
			String message = null;
			switch (problem.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO)) {
				case IMarker.SEVERITY_ERROR:
					message = formatMarkerMessage("Error", problem); //$NON-NLS-1$
					errors++;
					break;
				case IMarker.SEVERITY_WARNING:
					message = formatMarkerMessage("Warning", problem); //$NON-NLS-1$
					break;
				case IMarker.SEVERITY_INFO:
					message = formatMarkerMessage("Info", problem); //$NON-NLS-1$
			}

			if (message != null) {
				System.err.println(message);
			}
		}
		
		maxMem = Runtime.getRuntime().maxMemory() / (1024 * 1024);
		free = Runtime.getRuntime().freeMemory() / (1024 * 1024);
		used = Runtime.getRuntime().totalMemory() / (1024 * 1024);
		printMessage("Finished build. Memory max=" + maxMem + "m, total=" + used + "m, free=" + free + "m");
		printMessage("Garbage collecting...");
		Runtime.getRuntime().gc();
		maxMem = Runtime.getRuntime().maxMemory() / (1024 * 1024);
		free = Runtime.getRuntime().freeMemory() / (1024 * 1024);
		used = Runtime.getRuntime().totalMemory() / (1024 * 1024);
		printMessage("Memory max=" + maxMem + "m, total=" + used + "m, free=" + free + "m");
		
		Assert.assertTrue("Errors during the build: " + errors, errors == 0);
	}

	public static void cleanBuild() throws CoreException {
		ResourcesPlugin.getWorkspace().build(
				IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
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

	public static void fullBuild() throws CoreException {
		ResourcesPlugin.getWorkspace().build(
				IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
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
	
	public static void waitForBuild() {
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD,
						null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	public static void setAutoBuild(boolean b) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		try {
			IWorkspaceDescription desc = workspace.getDescription();
			desc.setAutoBuilding(b);
			workspace.setDescription(desc);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void clearJdtIndex() {
		File jdtMetadata = JavaCore.getPlugin().getStateLocation().toFile();
		boolean success = false;
		try {
			cleanFolder(jdtMetadata);
			success = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printMessage("Clean up index " + jdtMetadata.getAbsolutePath() + ": " + (success ? "success" : "fail"));
	}

	private void cleanFolder(File parentFolder) throws FileNotFoundException {
		cleanFolder(parentFolder, new FileFilter() {
			public boolean accept(File pathname) {
				return true;
			}
		});
	}
	
	private void cleanFolder(File parentFolder, FileFilter myFilter) throws FileNotFoundException {
		if (!parentFolder.exists()) {
			throw new FileNotFoundException(parentFolder.getAbsolutePath());
		}
		final File[] contents = parentFolder.listFiles(myFilter);
		for (int j = 0; j < contents.length; j++) {
			final File file = contents[j];
			if (file.isDirectory()) {
				cleanFolder(file, myFilter);
			} else {
				file.delete();
			}
		}
	}

	private String formatMarkerMessage(String type, IMarker problem) {
		StringBuilder bld = new StringBuilder();
		bld.append(type);
		bld.append(": file "); //$NON-NLS-1$
		bld.append(problem.getResource().getLocation().toOSString());
		int line = problem.getAttribute(IMarker.LINE_NUMBER, -1);
		if (line > 0) {
			bld.append(", line "); //$NON-NLS-1$
			bld.append(line);
		}
		bld.append(": "); //$NON-NLS-1$
		bld.append(problem.getAttribute(IMarker.MESSAGE, "")); //$NON-NLS-1$
		return bld.toString();
	}

	private void printMessage(String m) {
		System.err.println(m);
	}
}
