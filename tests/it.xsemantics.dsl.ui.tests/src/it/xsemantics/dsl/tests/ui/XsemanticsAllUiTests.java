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

package it.xsemantics.dsl.tests.ui;

import it.xsemantics.dsl.tests.ui.contentassist.XsemanticsProposalProviderTest;
import it.xsemantics.dsl.tests.ui.editor.XsemanticsEditorTest;
import it.xsemantics.dsl.tests.ui.outline.XsemanticsOutlineTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	XsemanticsProposalProviderTest.class,
	XsemanticsEditorTest.class,
	XsemanticsOutlineTest.class
})
public class XsemanticsAllUiTests {

}
