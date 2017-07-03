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

package it.xsemantics.dsl.tests.suites;

import it.xsemantics.dsl.tests.QualifiedNameTest;
import it.xsemantics.dsl.tests.XsemanticsNodeModelUtilsTest;
import it.xsemantics.dsl.tests.XsemanticsParsingTest;
import it.xsemantics.dsl.tests.XsemanticsProposalsForDatatypeRulesTest;
import it.xsemantics.dsl.tests.XsemanticsScopingTest;
import it.xsemantics.dsl.tests.XsemanticsTypeSystemTest;
import it.xsemantics.dsl.tests.XsemanticsUtilsTest;
import it.xsemantics.dsl.tests.XsemanticsValidatorTest;
import it.xsemantics.dsl.tests.XsemanticsValidatorTests;

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
