package it.xsemantics.example.lambda.tests.ui

import org.eclipse.core.resources.IResource
import org.eclipse.emf.ecore.EValidator
import org.eclipse.xtext.junit4.ui.AbstractWorkbenchTest
import org.eclipse.xtext.ui.XtextProjectHelper
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

class LambdaWorkbenchTest extends AbstractWorkbenchTest {
	
	val TEST_PROJECT = "mytestproject"
	
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
	
	def void checkProgram(String contents, int expectedErrors) {
		val file = createFile(TEST_PROJECT + "/src/test.lambda", contents)
		waitForBuild();
		assertEquals(expectedErrors, file.findMarkers(EValidator::MARKER, true,
				IResource::DEPTH_INFINITE).size);
	}

	@Test
	def void testValidProgram() {
		checkProgram("lambda x. x", 0)
	}

	@Test
	def void testNotValidProgram() {
		checkProgram("foo", 3)
	}
}