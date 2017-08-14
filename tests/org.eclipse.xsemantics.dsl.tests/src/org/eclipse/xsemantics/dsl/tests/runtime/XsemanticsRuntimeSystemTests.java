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
package org.eclipse.xsemantics.dsl.tests.runtime;

import org.eclipse.xsemantics.dsl.tests.classes.BaseClass1;
import org.eclipse.xsemantics.dsl.tests.classes.BaseClass2;
import org.eclipse.xsemantics.dsl.tests.classes.DerivedAlternativeClass1;
import org.eclipse.xsemantics.dsl.tests.classes.DerivedClass1;
import org.eclipse.xsemantics.dsl.tests.classes.DerivedClass2;
import org.eclipse.xsemantics.dsl.tests.classes.DerivedDerivedClass1;
import org.eclipse.xsemantics.dsl.tests.typesystems.TestTypeSystemWithPolymorphicDispatcher;
import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.FjPackage;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.Result2;
import org.eclipse.xsemantics.runtime.Result3;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Provider;

/**
 * @author bettini
 * 
 */
public class XsemanticsRuntimeSystemTests extends
		XsemanticsRuntimeAbstractTests {

	protected TestTypeSystemWithPolymorphicDispatcher ts;

	protected XsemanticsRuntimeSystem runtimeTypeSystem;
	
	private Object traceElement = new Object();

	public class EClassesForTesting {
		EClass C = emfUtils.createEClass("C");
		EClass B = emfUtils.createEClass("B", C);
		EClass A = emfUtils.createEClass("A", B);
	}

	public class FjClassesForTesting {
		Class D = emfUtils.createFjClass("D");

		Field df1 = emfUtils.createFjField("df1");

		Method dm1 = emfUtils.createFjMethod("dm1");

		Class C = emfUtils.createFjClass("C");

		Field f1 = emfUtils.createFjField("f1");
		Field f2 = emfUtils.createFjField("f2");

		Method m1 = emfUtils.createFjMethod("m1");
		Method m2 = emfUtils.createFjMethod("m2");

		public FjClassesForTesting() {
			C.getMembers().add(f1);
			C.getMembers().add(m1);
			C.getMembers().add(f2);
			C.getMembers().add(m2);

			D.getMembers().add(df1);
			D.getMembers().add(dm1);

			C.setSuperclass(D);
		}
	}

	private class TraceElementProvider implements Provider<Object> {

		public Object get() {
			return traceElement;
		}
		
	}

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		ts = get(TestTypeSystemWithPolymorphicDispatcher.class);
		runtimeTypeSystem = get(XsemanticsRuntimeSystem.class);
	}

	@Test
	public void testNoSuchMethod() throws RuleFailedException {
		try {
			ts.callNonExistentMethod("foo", 10);
			fail("should get an exception due to missing method");
		} catch (Exception e) {
			assertRuleFailedException(e,
					"cannot find a rule for |- foo : 10", null);
		}
	}

	@Test
	public void testNoSuchMethod2() throws RuleFailedException {
		try {
			ts.callNonExistentMethod2("foo", 10);
			fail("should get an exception due to missing method");
		} catch (Exception e) {
			assertRuleFailedException(e,
					"cannot find a rule for |- foo : 10", null);
		}
	}

	@Test
	public void testNoSuchMethod3() throws RuleFailedException {
		try {
			ts.callNonExistentMethod3("foo", 10);
			fail("should get an exception due to missing method");
		} catch (Exception e) {
			assertRuleFailedException(e,
					"cannot find a rule for |- foo : 10", null);
		}
	}

	@Test
	public void testNoSuchMethodForAuxiliary() throws RuleFailedException {
		try {
			ts.callNonExistentAuxiliary("foo", 10);
			fail("should get an exception due to missing method");
		} catch (Exception e) {
			assertRuleFailedException(e,
					"cannot find an implementation for testAuxiliaryImpl(foo, 10)", null);
		}
	}

	@Test
	public void testStringInteger() throws RuleFailedException {
		assertLeftRightPair(ts.stringIntegerMethod("foo", 10), "foo", 10);
	}

	@Test
	public void testBase1Base2() throws RuleFailedException {
		assertLeftRightPair(ts.base1base2(new BaseClass1(), new BaseClass2()),
				BaseClass1.class.getSimpleName(),
				BaseClass2.class.getSimpleName());
	}

	@Test
	public void testBase1Derived2() throws RuleFailedException {
		assertLeftRightPair(
				ts.base1base2(new BaseClass1(), new DerivedClass2()),
				BaseClass1.class.getSimpleName(),
				BaseClass2.class.getSimpleName());
	}

	@Test
	public void testDerived1Derived2() throws RuleFailedException {
		assertLeftRightPair(
				ts.base1base2(new DerivedClass1(), new DerivedClass2()),
				DerivedClass1.class.getSimpleName(),
				DerivedClass2.class.getSimpleName());
	}

	@Test
	public void testDerivedDerived1Derived2() throws RuleFailedException {
		assertLeftRightPair(
				ts.base1base2(new DerivedDerivedClass1(), new DerivedClass2()),
				DerivedDerivedClass1.class.getSimpleName(),
				DerivedClass2.class.getSimpleName());
	}

	@Test
	public void testDerivedDerived1Base2() throws RuleFailedException {
		assertLeftRightPair(
				ts.base1base2(new DerivedDerivedClass1(), new BaseClass2()),
				BaseClass1.class.getSimpleName(),
				BaseClass2.class.getSimpleName());
	}

	@Test
	public void testIsAssignable() {
		assertAssignable(new BaseClass1(), new BaseClass1(), true);
		assertAssignable(new DerivedClass1(), new BaseClass1(), true);
		assertAssignable(new BaseClass1(), new DerivedClass1(), false);
		assertAssignable(new DerivedClass2(), new BaseClass2(), true);
		assertAssignable(new DerivedDerivedClass1(), new BaseClass1(), true);
		assertAssignable(new DerivedDerivedClass1(), new BaseClass2(), false);
	}

	@Test
	public void testResultAssignable() throws RuleFailedException {
		assertLeftRightPairAsStrings(
				ts.testAssignableResult(new BaseClass1(), new BaseClass2()),
				DerivedAlternativeClass1.class.getSimpleName(),
				BaseClass2.class.getSimpleName());
	}

	@Test
	public void testResultNotAssignable() {
		try {
			ts.testAssignableResult(new DerivedClass1(), new BaseClass2());
			fail("result should not be assignable");
		} catch (RuleFailedException e) {
			assertEquals(
					DerivedAlternativeClass1.class.getSimpleName()
							+ " cannot be assigned to "
							+ DerivedClass1.class.getSimpleName(),
					e.getMessage());
		}
	}

	@Test
	public void testForNullArgument() {
		try {
			ts.testAssignableResult(new DerivedClass1(), null);
			fail("should have caught a null object argument failure");
		} catch (RuleFailedException e) {
			assertEquals("passed null object to system", e.getMessage());
		}
	}

	@Test
	public void testForAssignableWithNullArgument() throws RuleFailedException {
		assertTrue(ts.isResultAssignableTo(null, BaseClass2.class));
	}

	@Test
	public void testExtractRuleFailedException() {
		RuleFailedException original = new RuleFailedException();
		assertEquals(original,
				ts.extractRuleFailedException(new WrappedException(original)));
		NullPointerException npe = new NullPointerException();
		assertEquals(npe,
				((WrappedException) ts.extractRuleFailedException
					(new WrappedException(npe)).getCause()).getCause());
	}

	@Test
	public void testRuleFailedExceptionWithStandardException() {
		RuleFailedException ruleFailedException = ts
				.extractRuleFailedException(new Exception("foo"));
		assertTrue(ruleFailedException.getPrevious() == null);
		assertEquals("java.lang.Exception: foo",
				ruleFailedException.getMessage());
	}

	@Test
	public void testRuleFailedExceptionWithRuleFailedException() {
		final RuleFailedException ruleFailedException2 = new RuleFailedException(
				"foo");
		RuleFailedException ruleFailedException = ts
				.extractRuleFailedException(ruleFailedException2);
		assertTrue(ruleFailedException.getPrevious() == null);
		assertEquals(ruleFailedException2, ruleFailedException);
	}

	@Test
	public void testSneakyThrowRuleFailedException() {
		RuleFailedException original = new RuleFailedException();
		try {
			ts.sneakyThrowRuleFailedException(original);
			fail("should have thrown exception");
		} catch (Exception e) {
			assertSame(original, e);
		}
	}

	@Test
	public void testSneakyThrowRuleFailedExceptionWithString() {
		try {
			ts.sneakyThrowRuleFailedException("foo");
			fail("should get an exception");
		} catch (Exception e) {
			assertRuleFailedException(e, "failed: foo", null);
		}
	}

	@Test
	public void testThrowRuleFailedExceptionWithString() {
		assertThrownRuleFailedException("foo", new Exception("bar"), "bar");
	}

	@Test
	public void testThrowRuleFailedExceptionWithString2() {
		assertThrownRuleFailedException("foo",
				ts.newRuleFailedException("bar", "issue"), "failed: bar");
	}

	@Test
	public void testThrowForExplicitFail() {
		try {
			ts.throwForExplicitFail();
			fail("should get an exception");
		} catch (Exception e) {
			assertRuleFailedException(e, null, null);
		}
	}

	@Test
	public void testThrowForExplicitFailWithErrorInformation() {
		try {
			ts.throwForExplicitFail("foo",
					new ErrorInformation(emfUtils.createEObject()));
			fail("should get an exception");
		} catch (Exception e) {
			RuleFailedException ex = assertRuleFailedException(e, "foo", null);
			assertTrue(ex.getErrorInformations().get(0).getSource() != null);
		}
	}

	protected void assertThrownRuleFailedException(String message,
			Exception previous, String previousMessage) {
		try {
			ts.throwRuleFailedException(message, "issue", previous);
			fail("should get an exception");
		} catch (RuleFailedException e) {
			assertRuleFailedException(e, "failed: " + message, "issue");
			assertEquals(previousMessage, e.getCause().getMessage());
		}
	}

	@Test
	public void testThrowRuleFailedExceptionWithErrorInformation() {
		String message = "foo";
		try {
			ts.throwRuleFailedException(message, "issue", new Exception("bar"),
					new ErrorInformation(emfUtils.createEObject()));
			fail("should get an exception");
		} catch (RuleFailedException e) {
			assertRuleFailedException(e, "failed: " + message, "issue");
			assertEquals("bar", e.getCause().getMessage());
			assertTrue(e.getErrorInformations().get(0).getSource() != null);
		}
	}

	@Test
	public void testAddToTraceNull() {
		runtimeTypeSystem.addToTrace(null, new TraceElementProvider());
	}

	@Test
	public void testAddToTraceNotNull() {
		final RuleApplicationTrace ruleApplicationTrace = new RuleApplicationTrace();
		runtimeTypeSystem.addToTrace(ruleApplicationTrace, new TraceElementProvider());
		assertEquals(traceElement, ruleApplicationTrace.getTrace().get(0));
	}

	@Test
	public void testSubtraceNotNull() {
		RuleApplicationTrace newTrace = runtimeTypeSystem
				.newTrace(new RuleApplicationTrace());
		assertTrue(newTrace != null);
	}

	@Test
	public void testSubtraceNull() {
		assertTrue(runtimeTypeSystem.newTrace(null) == null);
	}

	@Test
	public void testAddAsSubtraceNull() {
		runtimeTypeSystem.addAsSubtrace(null, new RuleApplicationTrace());
	}

	@Test
	public void testAddAsSubtraceNotNull() {
		final RuleApplicationTrace ruleApplicationTrace = new RuleApplicationTrace();
		final RuleApplicationTrace subTrace = new RuleApplicationTrace();
		runtimeTypeSystem.addAsSubtrace(ruleApplicationTrace, subTrace);
		assertEquals(subTrace, ruleApplicationTrace.getTrace().get(0));
	}

	@Test
	public void testEnvironmentAccessToNullEnvironment() {
		try {
			runtimeTypeSystem.environmentAccess(null, 1, Object.class);
			fail("should have failed due to null environment");
		} catch (RuleFailedException e) {
			assertEquals("access to null environment", e.getMessage());
		}
	}

	@Test
	public void testEnvironmentAccessNotFound() {
		try {
			runtimeTypeSystem.environmentAccess(new RuleEnvironment(), 1,
					Object.class);
			fail("should have failed due to not found");
		} catch (RuleFailedException e) {
			assertEquals("no mapping in the environment for: 1", e.getMessage());
		}
	}

	@Test
	public void testEnvironmentAccessOk() throws RuleFailedException {
		RuleEnvironment environment = new RuleEnvironment();
		BaseClass1 key = new BaseClass1();
		BaseClass2 value = new DerivedClass2();
		environment.add(key, value);
		BaseClass2 result = runtimeTypeSystem.environmentAccess(environment,
				key, BaseClass2.class);
		assertEquals(value, result);
	}

	@Test
	public void testEnvironmentAccessNotAssignable() {
		RuleEnvironment environment = new RuleEnvironment();
		BaseClass1 key = new BaseClass1();
		BaseClass2 value = new BaseClass2();
		environment.add(key, value);
		try {
			runtimeTypeSystem.environmentAccess(environment, key,
					DerivedClass2.class);
			fail("should have failed for not assignable");
		} catch (RuleFailedException e) {
			assertEquals(
					"mapped value BaseClass2 cannot be assigned to DerivedClass2",
					e.getMessage());
		}
	}

	@Test
	public void testEmptyEnvironment() {
		RuleEnvironment env = runtimeTypeSystem.emptyEnvironment();
		assertTrue(env.isEmpty());
	}

	@Test
	public void testEnvironmentFromSingleMappingMapping() {
		RuleEnvironment environment = runtimeTypeSystem.environmentEntry("foo",
				1);
		assertEquals(1, environment.get("foo"));
	}

	@Test
	public void testEnvironmentCompositionWithNull() {
		RuleEnvironment environment = runtimeTypeSystem.environmentComposition(
				null, runtimeTypeSystem.environmentEntry("foo", 1));
		assertEquals(1, environment.get("foo"));
	}

	@Test
	public void testEnvironmentCompositionWithMapping() {
		RuleEnvironment original = new RuleEnvironment(
				runtimeTypeSystem.environmentEntry("first", 1));
		RuleEnvironment environment = runtimeTypeSystem.environmentComposition(
				original, runtimeTypeSystem.environmentEntry("second", 2));
		// the environment is actually a composition
		assertEquals(1, environment.get("first"));
		assertEquals(2, environment.get("second"));
		// but different from the original
		assertNull(original.get("second"));
	}

	@Test
	public void testEnvironmentCompositionWithOverridingMapping() {
		RuleEnvironment original = new RuleEnvironment(
				runtimeTypeSystem.environmentEntry("first", 1));
		RuleEnvironment environment = runtimeTypeSystem.environmentComposition(
				original, runtimeTypeSystem.environmentEntry("first", 2));
		// the environment is actually a composition
		assertEquals(1, original.get("first"));
		// but different from the original
		assertEquals(2, environment.get("first"));
	}

	@Test
	public void testClone() {
		EClass e = emfUtils.createEClass("foo");
		EClass cloned = ts.clone(e);
		assertNotSame(e, cloned);
		assertEquals(e.getName(), cloned.getName());
	}

	@Test
	public void testAddToListObject() {
		List<String> strings = new LinkedList<String>();
		ts.addToList(strings, "foo", String.class);
		ts.addToList(strings, 1, String.class);
		assertEquals(1, strings.size());
		assertEquals("foo", strings.get(0));
	}

	@Test
	public void testAddToListNull() {
		List<String> strings = new LinkedList<String>();
		ts.addToList(strings, null, String.class);
		assertEquals(0, strings.size());
	}

	@Test
	public void testAddToListList() {
		List<String> strings = Lists.newArrayList("foo", "bar");
		List<Object> strings2 = Lists.<Object> newArrayList(1, "foo2", false,
				"bar2", true);
		ts.addToList(strings, strings2, String.class);
		assertEquals(4, strings.size());
		assertEquals("[foo, bar, foo2, bar2]", strings.toString());
	}

	@Test
	public void testGetEObjectWithEObject() {
		EClass eclass = emfUtils.createEClass("foo");
		assertSame(eclass, ts.getEObject(eclass));
	}

	@Test
	public void testGetEObjectWithNonEObject() {
		assertTrue(ts.getEObject(new Integer(10)) == null);
	}

	@Test
	public void testGetListFromSingleObject() {
		EClass eclass = emfUtils.createEClass("foo");
		List<Object> list = ts.getList(eclass);
		assertEquals(1, list.size());
		assertTrue(list.contains(eclass));
	}

	@Test
	public void testGetListFromList() {
		EClass eclass = emfUtils.createEClass("foo");
		eclass.getESuperTypes().add(emfUtils.createEClass("1"));
		eclass.getESuperTypes().add(emfUtils.createEClass("2"));
		List<Object> list = ts.getList(eclass.getESuperTypes());
		assertEquals(2, list.size());
		assertAsStringRep("[1, 2]", list);
	}

	@Test
	public void testGetAllNodesInRelation() {
		List<EObject> list = ts.getAllNodesInRelation(
				new EClassesForTesting().A,
				EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		assertAsStringRep("[B, C]", list);
	}

	@Test
	public void testGetAllNodesInRelationWithCycle() {
		EClassesForTesting classes = new EClassesForTesting();
		classes.C.getESuperTypes().add(classes.A);
		List<EObject> list = ts.getAllNodesInRelation(classes.A,
				EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		assertAsStringRep("[B, C, A]", list);
	}

	@Test
	public void testGetAllNodesInRelationWithNull() {
		List<EObject> list = ts.getAllNodesInRelation(null,
				EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		assertAsStringRep("[]", list);
	}

	@Test
	public void testGetAllNodesInRelationWithNull2() {
		EClassesForTesting classes = new EClassesForTesting();
		classes.C.getESuperTypes().add(classes.A);
		List<EObject> list = new XsemanticsRuntimeSystem() {
			public java.util.List<Object> getList(Object object) {
				// a list with a NON EObject
				return Lists.newArrayList(new Object());
			};
		}.getAllNodesInRelation(classes.A,
				EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		assertAsStringRep("[]", list);
	}

	@Test
	public void testGetAll() {
		List<EClass> list = ts.getAll(new EClassesForTesting().A,
				EcorePackage.Literals.ECLASS__ESUPER_TYPES,
				EcorePackage.Literals.ECLASS__ESUPER_TYPES, EClass.class);
		assertAsStringRep("[B, C]", list);
	}

	@Test
	public void testGetAll2() {
		List<String> list = ts.getAll(new EClassesForTesting().A,
				EcorePackage.Literals.ENAMED_ELEMENT__NAME,
				EcorePackage.Literals.ECLASS__ESUPER_TYPES, String.class);
		assertAsStringRep("[A, B, C]", list);
	}

	@Test
	public void testGetAllFjFields() {
		List<Field> fields = ts.getAll(new FjClassesForTesting().C,
				FjPackage.Literals.CLASS__MEMBERS,
				FjPackage.Literals.CLASS__SUPERCLASS, Field.class);
		assertEquals(3, fields.size());
		assertAsStringRep("[Field 'f1', Field 'f2', Field 'df1']", fields);
	}

	@Test
	public void testGetAllFjMethods() {
		List<Method> methods = ts.getAll(new FjClassesForTesting().C,
				FjPackage.Literals.CLASS__MEMBERS,
				FjPackage.Literals.CLASS__SUPERCLASS, Method.class);
		assertEquals(3, methods.size());
		assertAsStringRep("[Method 'm1', Method 'm2', Method 'dm1']", methods);
	}

	@Test
	public void testGetAllWithNull() {
		List<Method> methods = ts.getAll(null,
				FjPackage.Literals.CLASS__MEMBERS,
				FjPackage.Literals.CLASS__SUPERCLASS, Method.class);
		assertAsStringRep("[]", methods);
	}

	@Test
	public void testTrimIfNotNull() {
		assertNull(ts.trimIfNotNull(null));
		assertEquals("test", ts.trimIfNotNull(" test "));
	}

	@Test
	public void testResultForFailure() {
		final String message = "test";
		
		Result<Object> result1 = ts.resultForFailure(new RuleFailedException(message));
		assertNull(result1.getValue());
		assertRuleFailedException(result1.getRuleFailedException(), message, null);
		
		Result2<Object, Object> result2 = ts.resultForFailure2(new RuleFailedException(message));
		assertNull(result2.getFirst());
		assertNull(result2.getSecond());
		assertRuleFailedException(result2.getRuleFailedException(), message, null);
		
		Result3<Object, Object, Object> result3 = ts.resultForFailure3(new RuleFailedException(message));
		assertNull(result3.getFirst());
		assertNull(result3.getSecond());
		assertNull(result3.getThird());
		assertRuleFailedException(result3.getRuleFailedException(), message, null);
	}

	protected void assertAssignable(Object result, Object destination,
			boolean expected) {
		assertTrue(
				result + " should " + (expected ? "" : "not ")
						+ "be assignable to " + destination,
				ts.isResultAssignableTo(result, destination.getClass()) == expected);
	}

	protected void assertAsStringRep(String expectedRep, List<?> list) {
		assertEquals(expectedRep, ts.stringRep(list));
	}

}
