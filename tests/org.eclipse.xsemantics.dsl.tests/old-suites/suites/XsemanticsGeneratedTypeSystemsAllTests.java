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

import org.eclipse.xsemantics.dsl.tests.generator.fj.FjActualGeneratedTypeSystemTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.FjActualGeneratedValidatorTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.FjAltGeneratedTypeSystemTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.FjAltGeneratedValidatorTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.FjFirstCachedGeneratedTypeSystemTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.FjFirstGeneratedTypeSystemTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.FjFirstGeneratedValidatorTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.FjLambdaGeneratedTypeSystemTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.FjSepGeneratedTypeSystemTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.FjSepGeneratedValidatorTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	FjFirstGeneratedTypeSystemTests.class,
	FjAltGeneratedTypeSystemTests.class,
	FjFirstGeneratedValidatorTests.class,
	FjAltGeneratedValidatorTests.class,
	FjActualGeneratedTypeSystemTests.class,
	FjActualGeneratedValidatorTests.class,
	FjSepGeneratedTypeSystemTests.class,
	FjSepGeneratedValidatorTests.class,
	FjLambdaGeneratedTypeSystemTests.class,
	FjFirstCachedGeneratedTypeSystemTests.class
})
public class XsemanticsGeneratedTypeSystemsAllTests {

}
