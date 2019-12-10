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

package org.eclipse.xsemantics.example.fjcached.ui.tests

import com.google.inject.Inject
import org.eclipse.xsemantics.example.fj.fj.FjFactory
import org.eclipse.xsemantics.example.fj.typing.FjTypeSystem
import org.eclipse.xsemantics.example.fjcached.fjcached.FjCachedProgram
import org.eclipse.xsemantics.example.fjcached.ui.internal.FjcachedActivator
import org.eclipse.xsemantics.runtime.caching.XsemanticsCacheResultLoggerListener
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.testing.AbstractEditorTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.*

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(FjcachedUiInjectorProvider))
class FjCachedTypeSystemEditorTest extends AbstractEditorTest {

	val TEST_PROJECT = "mytestproject"

	@Inject
	XsemanticsCacheResultLoggerListener cacheResultLogger

	override protected getEditorId() {
		FjcachedActivator.ORG_ECLIPSE_XSEMANTICS_EXAMPLE_FJCACHED_FJCACHED
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
			getProject().addNature(XtextProjectHelper.NATURE_ID)
		]
	}

	def createTestFile(CharSequence contents, String name) {
		createFile(TEST_PROJECT + "/src/" + name + ".fjcached", contents.toString)
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
		''', "test").openEditor
		waitForBuild;
		// this will trigger validation in the editor
		editor.document.modify [
			(contents.head as FjCachedProgram).cachedprogram.classes += FjFactory.eINSTANCE.createClass => [
				name = "TestClass"
			]
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
		''', "temp").openEditor
		waitForBuild;
		val res = editor.document.readOnly[it]
		val ts = res.resourceServiceProvider.get(FjTypeSystem)
		ts.cache
	}
}
