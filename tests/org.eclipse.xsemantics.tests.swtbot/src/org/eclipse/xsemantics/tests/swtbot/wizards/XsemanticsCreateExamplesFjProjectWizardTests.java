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
package org.eclipse.xsemantics.tests.swtbot.wizards;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;

import org.eclipse.xsemantics.tests.swtbot.XsemanticsSwtbotTestBase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author bettini
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class XsemanticsCreateExamplesFjProjectWizardTests extends XsemanticsSwtbotTestBase {

	@After
	public void runAfterEveryTest() throws CoreException {
		cleanWorkspace();
		waitForBuild();
	}

	@Test
	public void canCreateANewFJProject() throws Exception {
		createProjectAndAssertNoErrorMarker("FJ Project");
	}
}
