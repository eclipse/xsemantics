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

import it.xsemantics.dsl.tests.generator.fj.FjActualGeneratedTypeSystemTests;
import it.xsemantics.dsl.tests.generator.fj.FjActualGeneratedValidatorTests;
import it.xsemantics.dsl.tests.generator.fj.FjAltGeneratedTypeSystemTests;
import it.xsemantics.dsl.tests.generator.fj.FjAltGeneratedValidatorTests;
import it.xsemantics.dsl.tests.generator.fj.FjFirstCachedGeneratedTypeSystemTests;
import it.xsemantics.dsl.tests.generator.fj.FjFirstGeneratedTypeSystemTests;
import it.xsemantics.dsl.tests.generator.fj.FjFirstGeneratedValidatorTests;
import it.xsemantics.dsl.tests.generator.fj.FjLambdaGeneratedTypeSystemTests;
import it.xsemantics.dsl.tests.generator.fj.FjSepGeneratedTypeSystemTests;
import it.xsemantics.dsl.tests.generator.fj.FjSepGeneratedValidatorTests;

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
