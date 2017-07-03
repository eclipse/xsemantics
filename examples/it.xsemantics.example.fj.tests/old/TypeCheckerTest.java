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
package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.typing.FJTypeChecker;

import java.io.IOException;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;

/**
 * @author bettini
 * 
 *         Tests for validation (type checking)
 */
public class TypeCheckerTest extends TestWithLoader {
	FJTypeChecker fixture;

	public TypeCheckerTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		fixture = getTypeChecker();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Checks method body
	 * 
	 * @throws IOException
	 */
	public void testMethod() throws IOException {
		Program program = getProgramFromString("class A { Object f; Object m() {return this.f;} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0);
		String errors = fixture.typeCheck(method);
		assertEquals("", errors);
	}

	/**
	 * Checks method body where body is a subtype of return type
	 * 
	 * @throws IOException
	 */
	public void testMethodWithSubtyping() throws IOException {
		Program program = getProgramFromString("class B {} class A extends B { A a; B m() {return this.a;} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(1)).get(0);
		String errors = fixture.typeCheck(method);
		assertTrue(errors.length() == 0);
	}

	/**
	 * body returns a basic type which is not subtype of class type
	 * 
	 * @throws IOException
	 */
	public void testMethodFail() throws IOException {
		Program program = getProgramFromString("class A { int f; Object m() {return this.f;} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0);
		String errors = fixture.typeCheck(method);
		System.out.println("error: " + errors);
		assertTrue(errors.length() != 0);
		assertEquals("rule TMethodOk cannot type: |- Method 'm' : OK", errors);
	}

	/**
	 * incorrect method override (different return types)
	 * 
	 * @throws IOException
	 */
	public void testOverriddenFail() throws IOException {
		Program program = getProgramFromString("class B { B m() {return new B();} } class A extends B { Object f; Object m() {return this.f;} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(1)).get(0);
		String errors = fixture.typeCheck(method);
		System.out.println("error: " + errors);
		assertTrue(errors.length() != 0);
		assertEquals("rule TMethodOk cannot type: |- Method 'm' : OK", errors);
	}

	/**
	 * incorrect method override (different parameters)
	 * 
	 * @throws IOException
	 */
	public void testOverriddenFail2() throws IOException {
		Program program = getProgramFromString("class B { B m(Object a, int i) {return new B();} } class A extends B { Object f; B m(Object a, String s) {return this.f;} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(1)).get(0);
		String errors = fixture.typeCheck(method);
		System.out.println("error: " + errors);
		assertTrue(errors.length() != 0);
		assertEquals("rule TMethodOk cannot type: |- Method 'm' : OK", errors);
	}

	/**
	 * correct method override
	 * 
	 * @throws IOException
	 */
	public void testOverridden() throws IOException {
		Program program = getProgramFromString("class B { B m(Object a, int i) {return new B();} } class A extends B { Object f; B m(Object c, int s) {return new B();} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(1)).get(0);
		String errors = fixture.typeCheck(method);
		System.out.println("error: " + errors);
		assertTrue(errors.length() == 0);
	}

	/**
	 * passing the wrong number of arguments to a method
	 * 
	 * @throws IOException
	 */
	public void testWrongNumberOfArgs() throws IOException {
		Program program = getProgramFromString("class A { int f; Object m() {return this.m(new A());} }");
		Expression body = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0)
				.getBody().getExpression();
		String errors = fixture.typeCheck(body);
		System.out.println("error: " + errors);
		assertTrue(errors.length() != 0);
		assertEquals(
				"rule TSelection cannot type: [this -> ClassType 'Class 'A''] |- Selection 'This 'this'' : Type",
				errors);
	}

	/**
	 * passing the argument with wrong type
	 * 
	 * @throws IOException
	 */
	public void testWrongArguments() throws IOException {
		Program program = getProgramFromString("class A { int f; Object m(Object a) {return this.m(this.f);} }");
		Expression body = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0)
				.getBody().getExpression();
		String errors = fixture.typeCheck(body);
		System.out.println("error: " + errors);
		assertTrue(errors.length() != 0);
		assertEquals(
				"rule TSelection cannot type: [this -> ClassType 'Class 'A''] |- Selection 'This 'this'' : Type",
				errors);
	}

	/**
	 * passing the arguments with right types
	 * 
	 * @throws IOException
	 */
	public void testCorrectArguments() throws IOException {
		Program program = getProgramFromString("class A { int f; Object m(Object a, int i) {return this.m(new A(10), this.f);} }");
		Expression body = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0)
				.getBody().getExpression();
		String errors = fixture.typeCheck(body);
		System.out.println("error: " + errors);
		assertTrue(errors.length() == 0);
	}

	/**
	 * Test for duplicate fields in a class and in a hierarchy
	 * 
	 * @throws IOException
	 */
	public void testDuplicateFields() throws IOException {
		Program program = getProgramFromString("class B { int h; } class A extends B { int f; int g; int f; Object h; }");
		Class classA = program.getClasses().get(1);
		Field f1 = FjAuxiliaryFunctions.selectFields(classA).get(0);
		String errors = fixture.typeCheck(f1);
		System.out.println("error: " + errors);
		assertTrue(errors.length() > 0);
		assertEquals("rule TFieldOk cannot type: [this -> ClassType 'Class 'A''] |- Field 'f' : OK", errors);
		f1 = FjAuxiliaryFunctions.selectFields(classA).get(2);
		errors = fixture.typeCheck(f1);
		System.out.println("error: " + errors);
		assertTrue(errors.length() > 0);
		assertEquals("rule TFieldOk cannot type: [this -> ClassType 'Class 'A''] |- Field 'f' : OK", errors);
		f1 = FjAuxiliaryFunctions.selectFields(classA).get(1);
		errors = fixture.typeCheck(f1);
		System.out.println("error: " + errors);
		assertTrue(errors.length() == 0);
		f1 = FjAuxiliaryFunctions.selectFields(classA).get(3);
		errors = fixture.typeCheck(f1);
		System.out.println("error: " + errors);
		assertTrue(errors.length() > 0);
		assertEquals("rule TFieldOk cannot type: [this -> ClassType 'Class 'A''] |- Field 'h' : OK", errors);
	}

	public void testDuplicateMethods() throws IOException {
		Program program = getProgramFromString("class A { A m() { return this; } Object m() { return this; } Object n() { return this; } }");
		Class classA = program.getClasses().get(0);
		Method m = FjAuxiliaryFunctions.selectMethods(classA).get(0);
		String errors = fixture.typeCheck(m);
		System.out.println("error: " + errors);
		assertTrue(errors.length() > 0);
		assertEquals("rule TMethodOk cannot type: |- Method 'm' : OK", errors);
		m = FjAuxiliaryFunctions.selectMethods(classA).get(1);
		errors = fixture.typeCheck(m);
		System.out.println("error: " + errors);
		assertTrue(errors.length() > 0);
		assertEquals("rule TMethodOk cannot type: |- Method 'm' : OK", errors);
		m = FjAuxiliaryFunctions.selectMethods(classA).get(2);
		errors = fixture.typeCheck(m);
		System.out.println("error: " + errors);
		assertTrue(errors.length() == 0);
	}

	public void testNew() throws IOException {
		Program program = getProgramFromString("class A { int f; Object a; A m() { return new A(this.f, this.a); } }");
		Class classA = program.getClasses().get(0);
		Method m = FjAuxiliaryFunctions.selectMethods(classA).get(0);
		Expression n = m.getBody().getExpression();
		String errors = fixture.typeCheck(n);
		System.out.println("errors: " + errors);
		assertTrue(errors.length() == 0);
	}

	public void testNewInheritance() throws IOException {
		Program program = getProgramFromString("class B { Object c; } class A extends B { int f; Object a; A m() { return new A(this.a, this.f, this.a); } }");
		Class classA = program.getClasses().get(1);
		Method m = FjAuxiliaryFunctions.selectMethods(classA).get(0);
		Expression n = m.getBody().getExpression();
		String errors = fixture.typeCheck(n);
		assertEquals("", errors);
	}

	/**
	 * wrong new invocation missing one argument
	 * 
	 * @throws IOException
	 */
	public void testNewFail() throws IOException {
		Program program = getProgramFromString("class A { int f; Object a; A m() { return new A(this.f); } }");
		Class classA = program.getClasses().get(0);
		Method m = FjAuxiliaryFunctions.selectMethods(classA).get(0);
		Expression n = m.getBody().getExpression();
		String errors = fixture.typeCheck(n);
		System.out.println("errors: " + errors);
		assertTrue(errors.length() > 0);
		assertEquals("rule TNew cannot type: [this -> ClassType 'Class 'A''] |- New 'ClassType 'Class 'A''' : Type",
				errors);
	}

	/**
	 * wrong new invocation, type mismatch, (with inherited fields)
	 * 
	 * @throws IOException
	 */
	public void testNewInheritanceFail() throws IOException {
		Program program = getProgramFromString("class B { Object g; } class A extends B { int f; Object a; A m() { return new A(this.a, this.f, this.f); } }");
		Class classA = program.getClasses().get(1);
		Method m = FjAuxiliaryFunctions.selectMethods(classA).get(0);
		Expression n = m.getBody().getExpression();
		String errors = fixture.typeCheck(n);
		System.out.println("errors: " + errors);
		assertTrue(errors.length() > 0);
		assertEquals("rule TNew cannot type: [this -> ClassType 'Class 'A''] |- New 'ClassType 'Class 'A''' : Type",
				errors);
	}

	/**
	 * test for correct cast
	 * 
	 * @throws IOException
	 */
	public void testCast() throws IOException {
		Program program = getProgramFromString("class B { } class A extends B { } (A) new B()");
		Expression main = program.getMain();
		String errors = fixture.typeCheck(main);
		System.out.println("errors: " + errors);
		assertTrue(errors.length() == 0);
	}

	/**
	 * test for correct cast
	 * 
	 * @throws IOException
	 */
	public void testCast2() throws IOException {
		Program program = getProgramFromString("class B { } class A extends B { } (B) new A()");
		Expression main = program.getMain();
		String errors = fixture.typeCheck(main);
		System.out.println("errors: " + errors);
		assertTrue(errors.length() == 0);
	}

	/**
	 * test for incorrect cast
	 * 
	 * @throws IOException
	 */
	public void testCastFail() throws IOException {
		Program program = getProgramFromString("class B { } class A { } (B) new A()");
		Expression main = program.getMain();
		String errors = fixture.typeCheck(main);
		System.out.println("errors: " + errors);
		assertTrue(errors.length() > 0);
		assertEquals("invalid cast", errors);
	}

	/**
	 * Detects simple cycle in the hierarchy
	 * 
	 * <pre>
	 * class A extends A {} new A()
	 * </pre>
	 * 
	 * @throws IOException
	 */
	public void testSimpleCycleAndNew() throws IOException {
		Program program = loadProgramFromString("class A extends A {} new A()");
		String errors = getTypeChecker().typeCheck(program.getClasses().get(0));
		assertEquals("class hierarchy is not acyclic for Class 'A'", errors);
	}

	/**
	 * Detects duplicate classes in a program
	 * 
	 * @throws IOException
	 */
	public void testDuplicateClasses() throws IOException {
		Program program = loadProgramFromString("class A {} class B {} class C {} class A{}");
		String errors = getTypeChecker().typeCheck(program);
		// duplicate classes is now handeld by the validator directly
		assertEquals("", errors);
	}

	/**
	 * body returns a basic type which is not subtype of the method return type
	 * 
	 * @throws IOException
	 */
	public void testWrongConstant() throws IOException {
		Program program = getProgramFromString("class A { int m() {return true;} }");
		Method method = FjAuxiliaryFunctions.selectMethods(program.getClasses().get(0)).get(0);
		String errors = fixture.typeCheck(method);
		System.out.println("error: " + errors);
		assertTrue(errors.length() != 0);
		assertEquals("rule TMethodOk cannot type: |- Method 'm' : OK",
				errors);
	}

}
