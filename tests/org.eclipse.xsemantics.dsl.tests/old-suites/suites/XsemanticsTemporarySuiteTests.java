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

import org.eclipse.xsemantics.dsl.tests.XsemanticsValidatorTests;
import org.eclipse.xsemantics.dsl.tests.generator.XsemanticsGeneratorRunnerTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Useful to check that tests do not have side effects on each other.
 * 
 * @author Lorenzo Bettini
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	XsemanticsGeneratorRunnerTests.class,
	XsemanticsValidatorTests.class
})
public class XsemanticsTemporarySuiteTests {

}
