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

package org.eclipse.xsemantics.dsl.tests.generator.fj;

import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedTypeSystemTests;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import org.eclipse.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;

public class FjSepGeneratedTypeSystemTests extends
		FjAbstractGeneratedTypeSystemTests {

	public static class FjStandaloneSetupSep extends
			FjCustomStandaloneSetupForTesting {

		@Override
		protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
			return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {
				@SuppressWarnings("unused")
				public java.lang.Class<? extends FjExpectedTraces> bindFjExpectedTraces() {
					return FjSepExpectedTraces.class;
				}
			};
		}

		@Override
		protected Class<? extends IFjTypeSystem> fjTypeSystemClass() {
			return FjSepTypeSystemWrapper.class;
		}
	}

	protected Class<? extends FjCustomStandaloneSetupForTesting> fjCustomStandaloneSetupClass() {
		return FjStandaloneSetupSep.class;
	}

	@Override
	public void testSubclasses() throws Exception {
		// disabled: we don't have it in this type system
	}

	@Override
	public void testSubclassesObject() throws Exception {
		// disabled: we don't have it in this type system
	}

	@Override
	public void testSuperclasses() throws Exception {
		// disabled: we don't have it in this type system
	}

	@Override
	public void testSuperclassesWithCyclicHierarchy() throws Exception {
		// disabled: we don't have it in this type system
	}

	@Override
	public void testFieldsInHierarchy() throws Exception {
		// disabled: we don't have it in this type system
	}

	@Override
	public void testFieldsInHierarchyWithoutFields() throws Exception {
		// disabled: we don't have it in this type system
	}

	@Override
	public void testMethodsInHierarchy() throws Exception {
		// disabled: we don't have it in this type system
	}

	@Override
	public void testSubclassesFailed() throws Exception {
		// disabled: we don't have it in this type system
	}

	@Override
	public void testSubtypesBasicFailed() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertSubtypes(fields.basicField1.getType(),
				fields.basicField2.getType(), false, fields.trace,
				expectedTraces.failSubtypesBasic(), "");
	}

	@Override
	public void testSubtypesClassesFailed() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertSubtypes(fields.classField1.getType(),
				fields.classField2.getType(), false, fields.trace,
				expectedTraces.failSubtypesClasses(), "");
	}

	@Override
	public void testCheckMethodBodyNotSubtype() throws Exception {
		assertCheck(null, fjTestsUtils.fjMethodForName(
				getProgram(testFiles.testForMethodBodyNotSubtype()), "m"),
				false, trace, expectedTraces.methodCheckBodyNotSubtype(),
				"int m(String param) { return new A(param...");
	}

	@Override
	public void testCheckNewWrongSubtypeSimpler() throws Exception {
		assertCheck(null, fjTestsUtils.mainExpression(getProgram(testFiles
				.testNewWrongArgSubtypeSimpler())), false, trace,
				expectedTraces.newCheckWrongSubtypeSimpler(),
				"new A('foo') -- 'foo'");
	}

	@Override
	public void testCheckNewWrongSubtype() throws Exception {
		assertCheck(
				null,
				fjTestsUtils.mainExpression(getProgram(testFiles
						.testNewWrongArgSubtype())),
				false,
				trace,
				expectedTraces.newCheckWrongSubtype(),
				"new C(10, 'foo', new C(20, 'bar', new D(... -- new C(20, 'bar', new D()) -- new D()");
		// note that the superclass A is not present (see the base class of this
		// test class for comparison)
	}

	@Override
	public void testCheckNewWrongSubtypeBasic() throws Exception {
		assertCheck(null, fjTestsUtils.mainExpression(getProgram(testFiles
				.testNewWrongArgSubtypeBasic())), false, trace,
				expectedTraces.newCheckWrongSubtypeBasic(),
				"new C(10, 10, new B(20, 'bar')) -- 10");
	}

	@Override
	public void testCastWrong() throws Exception {
		assertCheck(null, fjTestsUtils.mainExpression(getProgram(testFiles
				.testCastWrong())), false, trace, expectedTraces.castWrong(),
				"(D) new C()");
	}

	@Override
	public void testNotEqualsBasicType() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertEqualsType(fields.basicField1.getType(),
				fields.basicField2.getType(), false, fields.trace,
				expectedTraces.failEqualsBasicType(), "");
	}

	@Override
	public void testNotEqualsClassType() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertEqualsType(fields.classField1.getType(),
				fields.classField2.getType(), false, fields.trace,
				expectedTraces.failEqualsClassType(), "");
	}

	@Override
	public void testNotEqualsTypeMixed() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertEqualsType(fields.basicField1.getType(),
				fields.classField2.getType(), false, fields.trace,
				"failed: types String and B are not comparable", "");
	}

	@Override
	public void testCheckSubclassNotOvverrideMethod() throws Exception {
		FjClassForTests classes = new FjClassForTests(
				testFiles.testSubclassNotOverrideMethod());
		assertCheck(
				null,
				classes.C,
				false,
				trace,
				expectedTraces.subclassNotOvverrideMethod(),
				"class C extends A { boolean m(String s) ... -- boolean m(String s) { return 100; }");
	}
}
