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

package org.eclipse.xsemantics.example.lambda.ui.tests

import org.eclipse.core.resources.IResource
import org.eclipse.emf.ecore.EValidator
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.testing.AbstractWorkbenchTest
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.*

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*

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
