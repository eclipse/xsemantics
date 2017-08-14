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
package org.eclipse.xsemantics.example.fj.tests;

import org.eclipse.xsemantics.example.fj.scoping.FJScopeProvider;

import java.io.IOException;

import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.Expression;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.example.fj.fj.New;
import org.eclipse.xsemantics.example.fj.fj.Program;
import org.eclipse.xsemantics.example.fj.fj.Selection;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author bettini
 * 
 *         Tests for scope provider
 */
public class ScopeProviderTest extends TestWithLoader {
	FJScopeProvider fixture;

	public ScopeProviderTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		fixture = new FJScopeProvider();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFieldSelection() throws IOException {
		Program program = getProgramFromString("class B { A f; } class A extends B {  A m() { return this.f; }}");

		Expression exp = program.getClasses().get(1).getMethods().get(0)
				.getBody().getExpression();
		Selection body = (Selection) exp;
		IScope scope = fixture.scope_FieldSelection_name(body, null);
		System.out.println("scope: " + scope.getAllContents());
		assertEquals(1, sizeOfIterable(scope.getAllContents()));
		assertTrue(scope.getContentByName("f") != null);
		assertEquals("f", ((Field) scope.getContentByName("f").getEObjectOrProxy())
				.getName());
	}
	
	public void testFieldSelectionInArgs() throws IOException {
		Program program = getProgramFromString("class A { int f; int m(int j) { return this.m(this.f); }}");

		Expression exp = program.getClasses().get(0).getMethods().get(0)
				.getBody().getExpression();
		Selection body = (Selection) exp;
		IScope scope = fixture.scope_FieldSelection_name(body, null);
		System.out.println("scope: " + scope.getAllContents());
		assertEquals(1, sizeOfIterable(scope.getAllContents()));
		assertTrue(scope.getContentByName("f") != null);
		assertEquals("f", ((Field) scope.getContentByName("f").getEObjectOrProxy())
				.getName());
	}

	public void testFieldSelectionChain() throws IOException {
		Program program = getProgramFromString("class B { A f; } class A extends B {  A m() { return this.f.f; }}");

		Expression exp = program.getClasses().get(1).getMethods().get(0)
				.getBody().getExpression();
		Selection body = (Selection) exp;
		IScope scope = fixture.scope_FieldSelection_name(body, null);
		System.out.println("scope: " + scope.getAllContents());
		assertEquals(1, sizeOfIterable(scope.getAllContents()));
		assertTrue(scope.getContentByName("f") != null);
		assertEquals("f", ((Field) scope.getContentByName("f").getEObjectOrProxy())
				.getName());
	}

	public void testFieldSelectionNew() throws IOException {
		Program program = getProgramFromString(
				"class B { String f; } " +
				"class A extends B { " +
				"	int g; " +
				"	A m() { return new A('foo',10).f; }" +
				"}");

		Expression exp = program.getClasses().get(1).getMethods().get(0)
				.getBody().getExpression();
		Selection body = (Selection) exp;
		IScope scope = fixture.scope_FieldSelection_name(body, null);
		System.out.println("scope: " + scope.getAllContents());
		// the elements reachable from new B().f are f and g
		assertEquals(2, sizeOfIterable(scope.getAllContents()));
		assertTrue(scope.getContentByName("f") != null);
		assertEquals("f", ((Field) scope.getContentByName("f").getEObjectOrProxy())
				.getName());
	}

	public void testMethodSelection() throws IOException {
		Program program = getProgramFromString("class B { A n() {return new A();} } class A extends B {  A m() { return this.n(); }}");

		Expression exp = program.getClasses().get(1).getMethods().get(0)
				.getBody().getExpression();
		Selection body = (Selection) exp;
		IScope scope = fixture.scope_MethodCall_name(body, null);
		System.out.println("scope: " + scope.getAllContents());
		assertEquals(2, sizeOfIterable(scope.getAllContents()));
		assertTrue(scope.getContentByName("n") != null);
		assertEquals("n", ((Method) scope.getContentByName("n").getEObjectOrProxy())
				.getName());
	}

	public void testMethodSelectionOnChain() throws IOException {
		Program program = getProgramFromString("class B { A n() {return new A();} } class A extends B {  A m() { return this.n().m(); }}");

		Expression exp = program.getClasses().get(1).getMethods().get(0)
				.getBody().getExpression();
		Selection body = (Selection) exp;
		IScope scope = fixture.scope_MethodCall_name(body, null);
		System.out.println("scope: " + scope.getAllContents());
		assertEquals(2, sizeOfIterable(scope.getAllContents()));
		assertTrue(scope.getContentByName("m") != null);
		assertEquals("m", ((Method) scope.getContentByName("m").getEObjectOrProxy())
				.getName());
	}

	public void testVariable() throws IOException {
		Program program = getProgramFromString("class A { int i; int m(A a, Object b) { return a; }}");
		Method method = program.getClasses().get(0).getMethods().get(0);
		IScope scope = fixture.scope_Variable_variable(method, null);
		System.out.println("scope: " + scope.getAllContents());
		assertEquals(2, sizeOfIterable(scope.getAllContents()));
		assertTrue(scope.getContentByName("a") != null);
		assertTrue(scope.getContentByName("b") != null);
	}
	
	public void testClass() throws IOException {
		Program program = getProgramFromString("class B {} class A extends B { Object a; }");
		Class B = program.getClasses().get(0);
		EReference extends_ = B.eClass().getEReferences().get(0);
		IScope scope = fixture.getScope(B, extends_);
		System.out.println("scope for B: " + scope.getAllContents());
		assertEquals(3, sizeOfIterable(scope.getAllContents()));
		assertTrue(scope.getContentByName("Object") != null);
		assertTrue(scope.getContentByName("A") != null);
		assertTrue(scope.getContentByName("B") != null);
	}
	
	public void testNewType() throws IOException {
		Program program = getProgramFromString("class B {} class A extends B { Object a; } new B()");
		Expression main = program.getMain();
		EReference type = ((New)main).getType().eClass().getEReferences().get(0);
		IScope scope = fixture.getScope(main, type);
		System.out.println("scope for new: " + scope.getAllContents());
		assertEquals(3, sizeOfIterable(scope.getAllContents()));
		assertTrue(scope.getContentByName("Object") != null);
		assertTrue(scope.getContentByName("A") != null);
		assertTrue(scope.getContentByName("B") != null);
	}
}
