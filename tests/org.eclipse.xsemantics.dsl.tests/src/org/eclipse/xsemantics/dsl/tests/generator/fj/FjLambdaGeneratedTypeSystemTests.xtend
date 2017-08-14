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

package org.eclipse.xsemantics.dsl.tests.generator.fj

import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjAbstractTests
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjInputFilesForTyping
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjTestsUtils
import org.eclipse.xsemantics.example.fj.FJStandaloneSetup
import org.eclipse.xsemantics.example.fj.fj.Class
import org.eclipse.xsemantics.example.fj.fj.FjFactory
import org.eclipse.xsemantics.runtime.RuleApplicationTrace
import org.eclipse.xsemantics.runtime.TraceUtils
import org.eclipse.xsemantics.test.fj.lambda.FjTestsForLambdas
import org.junit.Before
import org.junit.Test

class FjLambdaGeneratedTypeSystemTests extends FjAbstractTests {
	
	var FjTestsForLambdas typeSystem;

	var TraceUtils traceUtils;
	
	val inputs = new FjInputFilesForTyping
	
	val fjTestUtils = new FjTestsUtils
	
	@Before
	override void setUp() {
		super.setUp();
		with(FJStandaloneSetup);
		typeSystem = get(FjTestsForLambdas);
		traceUtils = get(TraceUtils);
	}

	@Test
	def void testExistsSubtypeSucceeds() {
		getProgram(inputs.testClassHierarchy2) => [
			assertExistsSubtype(
				fjClassForName("E"),
				fjClassForName("C"),
				true,
'''
ExistsSubtypeWithLambda: [] ||- ClassType 'class E extends D { }' <<! ClassType 'class C extends B { }'
 superclasses(class E extends D { }) = [class D extends C { }, class C extends B { }, class B extends A { }, class A { }]
 Subclassing: [] |- class C extends B { } <| class C extends B { }''',
				""
			)
		]
	}

	@Test
	def void testExistsSubtypeNotSucceeds() {
		getProgram(inputs.testClassHierarchy2) => [
			assertExistsSubtype(
				fjClassForName("A"),
				fjClassForName("B"),
				false,
				"",
'''
failed: ExistsSubtypeWithLambda: [] ||- ClassType 'class A { }' <<! ClassType 'class B extends A { }'
 failed: left.classref.superclasses.reverseView.exists[ G |- it <| right.classref ]
'''
			)
		]
	}

	def private assertExistsSubtype(Class c1,
		Class c2,
		boolean expectedSuccess,
		CharSequence expectedTrace,
		CharSequence expectedFailureTrace)
	{
		val trace = new RuleApplicationTrace
		val result = typeSystem.existsSubtype(null, trace, c1.toClassType, c2.toClassType)
		if (expectedSuccess) {
			if (result.failed()) {
				fail("FAILED WITH:\n"
						+ traceUtils.failureTraceAsString(result
								.getRuleFailedException()));
			}
			fjTestUtils.assertTrace(trace, expectedTrace)
		} else {
			if (!result.failed) {
				fail("UNEXPECTED SUCCESS WITH:\n"
						+ traceUtils.traceAsString(trace));
			}
			fjTestUtils.assertFailureTrace(result.ruleFailedException, expectedFailureTrace)
		}
	}

	def private toClassType(Class c) {
		FjFactory.eINSTANCE.createClassType => [
			classref = c
		]
	}
}