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

package it.xsemantics.example.lambda.tests.ui;

import static it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.getAbstraction;
import static it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.getArrowType;
import static it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.getTypeVariable;
import static it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.rep;
import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.addNature;
import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.cleanWorkspace;
import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.createFile;
import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.waitForBuild;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.addSourceFolder;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.createJavaProject;
import it.xsemantics.example.lambda.LambdaUiInjectorProvider;
import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.ui.typing.LambdaTermModifier;
import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(LambdaUiInjectorProvider.class)
public class LambdaIntegrationTest extends TestCase {
	@Inject
	protected LambdaTermModifier lambdaTermModifier;

	@BeforeClass
	public static void closeWelcome() {
		final IIntroManager introManager = PlatformUI.getWorkbench()
				.getIntroManager();
		IIntroPart part = introManager.getIntro();
		introManager.closeIntro(part);
	}

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		saveAllEditors();
		closeAllEditors();
		cleanWorkspace();
	}

	@Test
	public void testValidSimpleLambdaProgram() throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/src/foo.lambda", "lambda x. x");
		waitForBuild();
		assertNoErrorMarkers(file);
	}

	protected void assertNoErrorMarkers(IFile file) throws CoreException {
		assertEquals(0, file.findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

	protected void assertErrorMarkers(IFile file, int numOfMarkers)
			throws CoreException {
		assertEquals(numOfMarkers, file.findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length);
	}

	protected void assertContainsErrorMarkers(IFile file) throws CoreException {
		assertTrue(file.findMarkers(EValidator.MARKER, true,
				IResource.DEPTH_INFINITE).length > 0);
	}

	@Test
	public void testGetActiveEditor() throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/src/foo.lambda", "lambda x. x");
		waitForBuild();
		IXtextDocument xtextDocument = openEditorAndGetDocument(file);
		Program program = getLambdaProgramFromEditor(xtextDocument);
		assertEquals("x", getAbstraction(program.getTerm()).getParam()
				.getName());
	}

	@Test
	public void testInferAndModifyAbstractionType() throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/src/foo.lambda", "lambda x. x");
		waitForBuild();
		IXtextDocument xtextDocument = modifyAbstractionWithInferredType(file);
		assertNoErrorMarkers(file);
		Abstraction abstraction = getAbstractionFromProgramEditor(xtextDocument);
		assertEquals("a", getTypeVariable(abstraction.getParam().getType())
				.getTypevarName());
	}

	@Test
	public void testInferAndModifyComposeAbstractionType() throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/src/foo.lambda",
				"lambda f . lambda g. lambda x. (f (g x))");
		waitForBuild();
		IXtextDocument xtextDocument = modifyAbstractionWithInferredType(file);
		assertNoErrorMarkers(file);
		Abstraction abstraction = getAbstractionFromProgramEditor(xtextDocument);
		assertEquals("a -> b", rep(abstraction.getParam().getType()));
	}

	@Test
	public void testInferAndModifyAbstractionWithExplicitType()
			throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/src/foo.lambda",
				"lambda x : int -> string. x");
		waitForBuild();
		IXtextDocument xtextDocument = modifyAbstractionWithInferredType(file);
		assertNoErrorMarkers(file);
		Abstraction abstraction = getAbstractionFromProgramEditor(xtextDocument);
		assertEquals("a", rep(abstraction.getParam().getType()));
	}

	@Test
	public void testInferAndModifyNotTypableAbstractionWithType()
			throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/src/foo.lambda",
				"lambda x : int -> string. x x");
		waitForBuild();
		IXtextDocument xtextDocument = modifyAbstractionWithInferredType(file);
		assertContainsErrorMarkers(file);
		Abstraction abstraction = getAbstractionFromProgramEditor(xtextDocument);
		ArrowType arrowType = getArrowType(abstraction.getParam().getType());
		// since the type cannot be inferred the original type is not changed
		assertEquals("int -> string", rep(arrowType));
	}

	@Test
	public void testInferAndModifyTerm() throws Exception {
		createJavaProjectWithRootSrc("foo");
		IFile file = createFile("foo/src/foo.lambda",
				"lambda f . lambda g. lambda x. (f (g x))");
		waitForBuild();
		IXtextDocument xtextDocument = modifyTermWithInferredType(file);
		assertNoErrorMarkers(file);
		String newProgramText = xtextDocument.get();
		assertEquals(
				"lambda f : a -> b . lambda g : c -> a. lambda x : c. (f (g x))",
				newProgramText);
	}

	@Test
	public void testInferAndModifyWrongTerm() throws Exception {
		createJavaProjectWithRootSrc("foo");
		String originalProgramText = "lambda f . lambda g. lambda x. (f (f f))";
		IFile file = createFile("foo/src/foo.lambda", originalProgramText);
		waitForBuild();
		IXtextDocument xtextDocument = modifyTermWithInferredType(file);
		assertContainsErrorMarkers(file);
		String newProgramText = xtextDocument.get();
		assertEquals(originalProgramText, newProgramText);
	}

	protected Abstraction getAbstractionFromProgramEditor(
			IXtextDocument xtextDocument) {
		Program program = getLambdaProgramFromEditor(xtextDocument);
		Abstraction abstraction = getAbstraction(program.getTerm());
		return abstraction;
	}

	protected IXtextDocument modifyAbstractionWithInferredType(IFile file)
			throws PartInitException {
		IXtextDocument xtextDocument = openEditor(file).getDocument();
		modifyAbstractionWithInferredType(xtextDocument);
		waitForBuild();
		return xtextDocument;
	}

	protected void modifyAbstractionWithInferredType(
			IXtextDocument xtextDocument) {
		lambdaTermModifier.modifyAbstractionWithInferredType(xtextDocument);
		saveAllEditors();
	}

	protected IXtextDocument modifyTermWithInferredType(IFile file)
			throws PartInitException {
		IXtextDocument xtextDocument = openEditor(file).getDocument();
		modifyTermWithInferredType(xtextDocument);
		waitForBuild();
		return xtextDocument;
	}

	protected void modifyTermWithInferredType(IXtextDocument xtextDocument) {
		lambdaTermModifier.modifyTermWithInferredType(xtextDocument);
		saveAllEditors();
	}

	protected void saveAllEditors() {
		getWorkbenchPage().saveAllEditors(false);
	}

	protected void closeAllEditors() {
		getWorkbenchPage().closeAllEditors(false);
	}

	protected Program getLambdaProgramFromEditor(IXtextDocument xtextDocument) {
		Program program = xtextDocument
				.readOnly(new IUnitOfWork<Program, XtextResource>() {
					public Program exec(XtextResource resource) {
						return (Program) resource.getContents().get(0);
					}
				});
		return program;
	}

	protected IXtextDocument openEditorAndGetDocument(IFile file)
			throws PartInitException {
		XtextEditor activeXtextEditor = openEditor(file);
		IXtextDocument xtextDocument = activeXtextEditor.getDocument();
		return xtextDocument;
	}

	protected XtextEditor openEditor(IFile file) throws PartInitException {
		IWorkbenchPage page = getWorkbenchPage();
		IDE.openEditor(page, file);
		XtextEditor activeXtextEditor = EditorUtils.getActiveXtextEditor();
		return activeXtextEditor;
	}

	protected IWorkbenchPage getWorkbenchPage() {
		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		return page;
	}

	private IJavaProject createJavaProjectWithRootSrc(String string)
			throws CoreException {
		IJavaProject project = createJavaProject(string);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		addSourceFolder(project, "src");
		return project;
	}

}
