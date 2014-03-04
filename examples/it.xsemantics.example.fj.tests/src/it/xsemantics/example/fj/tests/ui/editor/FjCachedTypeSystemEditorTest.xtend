package it.xsemantics.example.fj.tests.ui.editor

import com.google.inject.Inject
import it.xsemantics.example.fj.FJUiInjectorProvider
import it.xsemantics.example.fj.fj.FjFactory
import it.xsemantics.example.fj.fj.Program
import it.xsemantics.example.fj.typing.FjTypeSystem
import it.xsemantics.example.fj.ui.FJActivatorCustom
import it.xsemantics.runtime.caching.XsemanticsCacheResultLoggerListener
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.ui.AbstractEditorTest
import org.eclipse.xtext.ui.XtextProjectHelper
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FJUiInjectorProvider))
class FjCachedTypeSystemEditorTest extends AbstractEditorTest {
	
	val TEST_PROJECT = "mytestproject"
	
	@Inject
	XsemanticsCacheResultLoggerListener cacheResultLogger
	
	override protected getEditorId() {
		FJActivatorCustom.IT_XSEMANTICS_EXAMPLE_FJ_CACHED_TYPESYSTEM
	}

	@Before
	override void setUp() {
		super.setUp
		createJavaProjectWithXtextNature
	}

	@After
	override void tearDown() {
		cacheResultLogger.reset
	}
	
	def void createJavaProjectWithXtextNature() {
		createJavaProject(TEST_PROJECT) => [
			getProject().addNature(XtextProjectHelper::NATURE_ID)
		]
	}

	def createTestFile(CharSequence contents, String name) {
		createFile(TEST_PROJECT + "/src/" + name + ".fj", contents.toString)
	}
	
	@Test
	def void testCachedTypeSystemEditorUsesXsemanticsCache() {
		val cache = cacheFromFjEditor
		cache.addListener(cacheResultLogger)
		val editor = createTestFile(
'''
class C {
	C m() { return this; }
}
new C().m()
'''
		, "test").openEditor
		waitForAutoBuild;
		// this will trigger validation in the editor
		editor.document.modify[
			(contents.head as Program).classes +=
				FjFactory.eINSTANCE.createClass => [name = "TestClass"]
		]
		cache.removeListener(cacheResultLogger)
		println(cacheResultLogger.missed)
		println(cacheResultLogger.hits)
		assertFalse("missed was empty", cacheResultLogger.missed.empty)
		assertFalse("hits was empty", cacheResultLogger.hits.empty)
	}		

	/* 
	 * We need the same cache instance from the editor's injector*/
	def getCacheFromFjEditor() {
		val editor = createTestFile(
'''
''',
		"temp").openEditor
		waitForAutoBuild;
		val res = editor.document.readOnly[it]
		val ts = res.resourceServiceProvider.get(FjTypeSystem)
		ts.cache
	}
}