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

package org.eclipse.xsemantics.dsl.tests.suites;

import org.eclipse.xsemantics.dsl.tests.QualifiedNameTest;
import org.eclipse.xsemantics.dsl.tests.XsemanticsNodeModelUtilsTest;
import org.eclipse.xsemantics.dsl.tests.XsemanticsParsingTest;
import org.eclipse.xsemantics.dsl.tests.XsemanticsProposalsForDatatypeRulesTest;
import org.eclipse.xsemantics.dsl.tests.XsemanticsScopingTest;
import org.eclipse.xsemantics.dsl.tests.XsemanticsTypeSystemTest;
import org.eclipse.xsemantics.dsl.tests.XsemanticsUtilsTest;
import org.eclipse.xsemantics.dsl.tests.XsemanticsValidatorTest;
import org.eclipse.xsemantics.dsl.tests.XsemanticsValidatorTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	XsemanticsParsingTest.class,
	XsemanticsScopingTest.class,
	XsemanticsProposalsForDatatypeRulesTest.class,
	XsemanticsValidatorTests.class,
	XsemanticsValidatorTest.class,
	QualifiedNameTest.class,
	XsemanticsUtilsTest.class,
	XsemanticsNodeModelUtilsTest.class,
	XsemanticsTypeSystemTest.class
})
public class XsemanticsDslAllTests {

}
