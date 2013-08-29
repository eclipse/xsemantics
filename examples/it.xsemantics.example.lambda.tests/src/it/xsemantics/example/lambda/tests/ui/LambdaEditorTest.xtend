package it.xsemantics.example.lambda.tests.ui

import com.google.inject.Inject
import it.xsemantics.example.lambda.LambdaUiInjectorProvider
import it.xsemantics.example.lambda.lambda.Program
import it.xsemantics.example.lambda.ui.internal.LambdaActivator
import it.xsemantics.example.lambda.ui.typing.LambdaTermModifier
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.ui.AbstractEditorTest
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

import static extension it.xsemantics.example.lambda.tests.util.LambdaTestsUtil.*
import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(LambdaUiInjectorProvider))
class LambdaEditorTest extends AbstractEditorTest {
	
	val TEST_PROJECT = "mytestproject"
	
	@Inject LambdaTermModifier lambdaTermModifier
	
	override protected getEditorId() {
		LambdaActivator.IT_XSEMANTICS_EXAMPLE_LAMBDA_LAMBDA
	}
	
	@Before
	override void setUp() {
		super.setUp
		createJavaProjectWithXtextNature
	}
	
	def void createJavaProjectWithXtextNature() {
		createJavaProject(TEST_PROJECT) => [
			getProject().addNature(XtextProjectHelper::NATURE_ID)
		]
	}

	def createTestFile(String contents) {
		createFile(TEST_PROJECT + "/src/test.lambda", contents)
	}
	
	@Test
	def void testEntitiesEditor() {
		createTestFile("lambda x . x").openEditor
	}

	@Test
	def void testLambdaEditorContentsAsModel() {
		"x".assertEquals(
			"lambda x. x".
				openEditorWithFile.abstractionFromEditor.param.name
		)
	}

	@Test
	def void testInferAndModifyAbstractionType() throws Exception {
		"lambda x. x".
			inferAbstractionTypeAndExpect("a")
	}

	@Test
	def void testInferAndModifyComposeAbstractionType() {
		"lambda f . lambda g. lambda x. (f (g x))".
			inferAbstractionTypeAndExpect("a -> b")
	}

	@Test
	def void testInferAndModifyAbstractionWithExplicitType() {
		"lambda x : int -> string. x".
			inferAbstractionTypeAndExpect("a")
	}

	@Test
	def void testInferAndModifyNotTypableAbstractionWithType() {
		// since the type cannot be inferred the original type is not changed
		"lambda x : int -> string. x x".
			inferAbstractionTypeAndExpect("int -> string")
	}

	@Test
	def void testInferAndModifyTerm() {
		"lambda f . lambda g. lambda x. (f (g x))".
		inferTypeAndExpect(
		"lambda f : a -> b . lambda g : c -> a. lambda x : c. (f (g x))")
	}

	@Test
	def void testInferAndModifyWrongTerm() throws Exception {
		// since the type cannot be inferred the original type is not changed
		"lambda f . lambda g. lambda x. (f (f f))".
		inferTypeAndExpect(
		"lambda f . lambda g. lambda x. (f (f f))")
	}

	def private inferAbstractionTypeAndExpect(String contents, String expected) {
		expected.assertEquals(
			contents.
				modifyAbstractionWithInferredType.
					param.type.rep
		)
	}

	def private inferTypeAndExpect(String contents, String expected) {
		val file = createTestFile(contents)
		waitForAutoBuild()
		val editor = file.openEditor
		editor.modifyTermWithInferredType
		
		expected.assertEquals(editor.document.get)
	}

	def private modifyAbstractionWithInferredType(String contents) throws Exception {
		val file = createTestFile(contents)
		waitForAutoBuild()
		val editor = file.openEditor
		editor.modifyAbstractionWithInferredType
		//file.assertNoErrorMarkers
		editor.abstractionFromEditor
	}

	def private openEditorWithFile(String contents) {
		contents.createTestFile.openEditor
	}
	
	def private abstractionFromEditor(XtextEditor editor) {
		editor.document.readOnly [
			// 'it' is an XtextResource
			contents.get(0) as Program
		].term.abstraction
	}

//	def private void assertNoErrorMarkers(IFile file) {
//		assertEquals(0, file.findMarkers(EValidator.MARKER, true,
//				IResource.DEPTH_INFINITE).length);
//	}

	def private void modifyAbstractionWithInferredType(
			XtextEditor editor) {
		editor.document.modifyAbstractionWithInferredType
	}
	
	def private void modifyAbstractionWithInferredType(
			IXtextDocument xtextDocument) {
		lambdaTermModifier.modifyAbstractionWithInferredType(xtextDocument);
		saveAllEditors();
		waitForAutoBuild();
	}

	def private void modifyTermWithInferredType(
			XtextEditor editor) {
		lambdaTermModifier.modifyTermWithInferredType(editor.document);
		saveAllEditors();
		waitForAutoBuild();
	}

	def private void saveAllEditors() {
		getActivePage().saveAllEditors(false);
	}
}