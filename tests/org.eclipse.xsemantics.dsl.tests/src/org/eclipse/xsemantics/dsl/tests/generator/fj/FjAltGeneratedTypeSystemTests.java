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
import org.eclipse.xsemantics.example.fj.tests.FJInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.runner.RunWith;

import com.google.inject.Injector;

@InjectWith(FjAltGeneratedTypeSystemTests.FjAltGeneratedTypeSystemInjectorProvider.class)
@RunWith(XtextRunner.class)
public class FjAltGeneratedTypeSystemTests extends
		FjAbstractGeneratedTypeSystemTests {

	public static class FjAltGeneratedTypeSystemInjectorProvider extends FJInjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			return new FjCustomStandaloneSetupForTesting() {
				@Override
				protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
					return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {
						@SuppressWarnings("unused")
						public Class<? extends FjExpectedTraces> bindFjExpectedTraces() {
							return FjAltExpectedTraces.class;
						}
					};
				}

				@Override
				protected Class<? extends IFjTypeSystem> fjTypeSystemClass() {
					return FjAltTypeSystemWrapper.class;
				}
			}.createInjectorAndDoEMFRegistration();
		}
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
		FjClassForTests classes = new FjClassForTests(
				testFiles.testClassHierarchy());
		assertSubclasses(classes.A, classes.B, false, classes.trace,
				expectedTraces.failSubclasses(), "class A { } feature: name");
	}

	@Override
	public void testSubtypesBasicFailed() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertSubtypes(fields.basicField1.getType(),
				fields.basicField2.getType(), false, fields.trace,
				expectedTraces.failSubtypesBasic(), "String");
	}

	@Override
	public void testSubtypesClassesFailed() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertSubtypes(fields.classField1.getType(),
				fields.classField2.getType(), false, fields.trace,
				expectedTraces.failSubtypesClasses(),
				"A -- class A { } feature: name");
	}
	
	@Override
	public void testCheckMethodBodyNotSubtype() throws Exception {
		assertCheck(null, fjTestsUtils.fjMethodForName(
				getProgram(testFiles.testForMethodBodyNotSubtype()), "m"),
				false, trace, expectedTraces.methodCheckBodyNotSubtype(),
				"int m(String param) { return new A(param... -- String");
	}
	
	@Override
	public void testCheckNewWrongSubtypeSimpler() throws Exception {
		assertCheck(
				null,
				fjTestsUtils.mainExpression(getProgram(testFiles
						.testNewWrongArgSubtypeSimpler())),
				false,
				trace,
				expectedTraces.newCheckWrongSubtypeSimpler(),
				"new A('foo')");
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
				"new C(10, 'foo', new C(20, 'bar', new D(... -- new C(20, 'bar', new D()) -- D -- class D {} feature: name");
		// note that the superclass A is not present (see the base class of this test class
		// for comparison)
	}
	
	@Override
	public void testCheckNewWrongSubtypeBasic() throws Exception {
		assertCheck(
				null,
				fjTestsUtils.mainExpression(getProgram(testFiles
						.testNewWrongArgSubtypeBasic())),
				false,
				trace,
				expectedTraces.newCheckWrongSubtypeBasic(),
				"new C(10, 10, new B(20, 'bar'))");
	}
	
	@Override
	public void testCastWrong() throws Exception {
		assertCheck(
				null,
				fjTestsUtils.mainExpression(getProgram(testFiles
						.testCastWrong())),
				false,
				trace,
				expectedTraces.castWrong(),
				"(D) new C() -- C -- class C extends B { } feature: name -- class B extends A { } feature: name -- class A { } feature: name");
	}
	
	@Override
	public void testNotEqualsTypeMixed() throws Exception {
		FjFieldsForTests fields = new FjFieldsForTests(
				testFiles.testForSubtyping());
		assertEqualsType(fields.basicField1.getType(),
				fields.classField2.getType(), false, fields.trace,
				"failed: String and B are not comparable", "");
	}
}
