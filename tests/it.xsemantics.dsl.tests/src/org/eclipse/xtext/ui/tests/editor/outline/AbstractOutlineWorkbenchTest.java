/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.addNature;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.fullBuild;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.monitor;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.waitForAutoBuild;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.createJavaProject;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineNodeComparer;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Lorenzo Bettini - Adapted to be used for any DSL
 */
public abstract class AbstractOutlineWorkbenchTest extends AbstractEditorTest {

	protected static int TAB_INDENT = 2;
	protected static int EXPECTED_TIMEOUT = 500;

	protected static String TEST_PROJECT = "test";

	protected IOutlineNodeComparer nodeComparer = new IOutlineNodeComparer.Default();

	protected IFile file;
	protected XtextEditor editor;
	protected IXtextDocument document;
	protected IViewPart outlineView;
	protected OutlinePage outlinePage;

	protected IOutlineNodeComparer comparer;

	public String fileExtension;

	@Inject
	public void setFileExtensionProvider(FileExtensionProvider extensionProvider) {
		fileExtension = extensionProvider.getPrimaryFileExtension();
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		comparer = new IOutlineNodeComparer.Default();
		createTestJavaProject();
	}

	/**
	 * This creates the Java project that will be used for the tests.
	 * @throws CoreException
	 */
	protected void createTestJavaProject() throws CoreException {
		IJavaProject javaProject = createJavaProject(TEST_PROJECT);
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		editor.close(false);
		outlineView.getSite().getPage().hideView(outlineView);
		executeAsyncDisplayJobs();
	}

	protected IOutlineNode getOutlineTree(CharSequence modelAsText)
			throws Exception {
		TreeViewer treeViewer = getOutlineTreeViewer(modelAsText);
		IOutlineNode rootNode = getOutlineRootNode(treeViewer);
		return rootNode;
	}

	protected TreeViewer getOutlineTreeViewer(CharSequence modelAsText) throws Exception {
		file = createFileInTestProject("test", modelAsText);
		editor = openEditor(file);
		return getOutlineTreeViewer();
	}

	protected TreeViewer getOutlineTreeViewer() throws PartInitException {
		document = editor.getDocument();
		outlineView = editor.getEditorSite().getPage()
				.showView("org.eclipse.ui.views.ContentOutline");
		executeAsyncDisplayJobs();
		Object adapter = editor.getAdapter(IContentOutlinePage.class);
		assertTrue(adapter instanceof OutlinePage);
		outlinePage = (OutlinePage) adapter;
		TreeViewer treeViewer = outlinePage.getTreeViewer();

		awaitForTreeViewer(treeViewer);

		assertTrue(treeViewer.getInput() instanceof IOutlineNode);
		return treeViewer;
	}

	protected TreeViewer getOutlineTreeViewerAfterEditorContentsReplacement(final CharSequence modelAsText) throws Exception {
		file = createFileInTestProject("test2", "");
		editor = openEditor(file);
		
		document = editor.getDocument();
		outlineView = editor.getEditorSite().getPage()
				.showView("org.eclipse.ui.views.ContentOutline");
		executeAsyncDisplayJobs();
		Object adapter = editor.getAdapter(IContentOutlinePage.class);
		assertTrue(adapter instanceof OutlinePage);
		outlinePage = (OutlinePage) adapter;
		TreeViewer treeViewer = outlinePage.getTreeViewer();

		awaitForTreeViewer(treeViewer);
		
		editor.getDocument().modify(new IUnitOfWork<Object, XtextResource>() {
			public Object exec(XtextResource state) throws Exception {
				editor.getDocument().set(modelAsText.toString());
				return null;
			}
		});
		//editor.getDocument().set(modelAsText.toString());
		editor.doSave(monitor());
		fullBuild();
		waitForAutoBuild();
		executeAsyncDisplayJobs();
		
		document = editor.getDocument();
		outlineView = editor.getEditorSite().getPage()
				.showView("org.eclipse.ui.views.ContentOutline");
		executeAsyncDisplayJobs();
		adapter = editor.getAdapter(IContentOutlinePage.class);
		assertTrue(adapter instanceof OutlinePage);
		outlinePage = (OutlinePage) adapter;
		treeViewer = outlinePage.getTreeViewer();

		awaitForTreeViewer(treeViewer);

		return treeViewer;
	}

	protected IFile createFileInTestProject(String fileNameWithoutExtension, CharSequence modelAsText)
			throws CoreException, InvocationTargetException,
			InterruptedException {
		return IResourcesSetupUtil.createFile(TEST_PROJECT + "/src/" + fileNameWithoutExtension + "."
				+ fileExtension, modelAsText.toString());
	}

	protected IFile getFileInTestProject(String fileNameWithoutExtension)
			throws CoreException, InvocationTargetException,
			InterruptedException {
		return IResourcesSetupUtil.root().getFile(new Path(TEST_PROJECT + "/src/" + fileNameWithoutExtension + "."
				+ fileExtension));
	}

	protected IOutlineNode getOutlineRootNode(TreeViewer treeViewer) {
		IOutlineNode rootNode = (IOutlineNode) treeViewer.getInput();
		return rootNode;
	}

	protected void awaitForTreeViewer(TreeViewer treeViewer) {
		long waitTime = 0;
		while (treeViewer.getInput() == null && waitTime < EXPECTED_TIMEOUT) {
			waitTime += 10;
			if (Display.getCurrent() != null)
				Display.getCurrent().readAndDispatch();
		}
	}

	/**
	 * The tree viewer is expanded and a string representation of the tree is
	 * built where children are indented of TAB_INDENT number of tabs; this
	 * string representation is then compared with the expected representation.
	 * 
	 * @param treeViewer
	 * @param expected
	 */
	protected void assertAllLabels(TreeViewer treeViewer, CharSequence expected) {
		treeViewer.expandAll();
		IOutlineNode rootNode = getOutlineRootNode(treeViewer);
		assertEquals(expected.toString().trim().replaceAll("\r", ""),
				outlineStringRepresentation(rootNode).trim().replaceAll("\r", ""));
	}

	protected String outlineStringRepresentation(IOutlineNode node) {
		StringBuffer buffer = new StringBuffer();
		// skip the root node
		outlineRepresentChildren(node, buffer, 0);
		return buffer.toString();
	}

	protected void outlineStringRepresentation(IOutlineNode node,
			StringBuffer buffer, int tabs) {
		outlineRepresentNode(node, buffer, tabs);
		outlineRepresentChildren(node, buffer, tabs + TAB_INDENT);
	}

	private void outlineRepresentChildren(IOutlineNode node,
			StringBuffer buffer, int tabs) {
		for (IOutlineNode child : node.getChildren()) {
			outlineStringRepresentation(child, buffer, tabs);
		}
	}

	private void outlineRepresentNode(IOutlineNode node, StringBuffer buffer,
			int tabs) {
		for (int i = 0; i < tabs; ++i) {
			buffer.append(" ");
		}
		buffer.append(node.getText().toString() + "\n");
	}

	protected void assertExpanded(TreeViewer treeViewer,
			IOutlineNode... expectedExpansion) {
		Object[] expandedElements = treeViewer.getExpandedElements();
		assertEquals(expectedExpansion.length, expandedElements.length);
		OUTER: for (Object expandedObject : expandedElements) {
			assertTrue(expandedObject instanceof IOutlineNode);
			for (IOutlineNode expectedExpanded : expectedExpansion) {
				if (nodeComparer.equals((IOutlineNode) expandedObject,
						expectedExpanded))
					continue OUTER;
			}
			fail("Unexpected expansion" + expandedObject.toString());
		}
	}

	protected void assertSelected(TreeViewer treeViewer,
			IOutlineNode... expectedSelection) {
		ISelection selection = treeViewer.getSelection();
		assertTrue(selection instanceof IStructuredSelection);
		assertEquals(expectedSelection.length,
				((IStructuredSelection) selection).size());
		OUTER: for (Iterator<?> i = ((IStructuredSelection) selection)
				.iterator(); i.hasNext();) {
			Object selectedObject = i.next();
			assertTrue(selectedObject instanceof IOutlineNode);
			for (IOutlineNode expectedSelected : expectedSelection) {
				if (nodeComparer.equals((IOutlineNode) selectedObject,
						expectedSelected))
					continue OUTER;
			}
			fail("Unexpected selection " + selectedObject.toString());
		}
	}

	protected void assertSame(IOutlineNode node, TreeItem treeItem) {
		assertTrue(treeItem.getData() instanceof IOutlineNode);
		assertTrue(comparer.equals(node, (IOutlineNode) treeItem.getData()));
	}

	protected void activate(IWorkbenchPart part) {
		editor.getSite().getPage().activate(part);
	}

	protected void executeAsyncDisplayJobs() {
		while (Display.getCurrent().readAndDispatch()) {
		}
	}
}
