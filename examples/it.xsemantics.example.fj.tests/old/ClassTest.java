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

package it.xsemantics.example.fj.tests;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.FjFactory;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.validation.FJJavaValidator;

import java.io.IOException;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Class</b></em>'. <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class ClassTest extends TestWithLoader {
	/**
	 * The fixture for this Class test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 */
	protected Class fixture = null;

	/**
	 * Sets the fixture for this Class test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 */
	public void setFixture(Class fixture) {
		this.fixture = fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(ClassTest.class);
	}

	/**
	 * Constructs a new Class test case with the given name. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 */
	public ClassTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Class test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected it.xsemantics.example.fj.fj.Class getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		setFixture(FjFactory.eINSTANCE.createClass());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
		super.tearDown();
	}

	/**
	 * Test for file class_sytanx_error.fj which contains a syntax error
	 */
	public void testClassSyntaxError() {
		Resource resource = loadResource("class_syntax_error.fj");
		EList<Diagnostic> errors = resource.getErrors();
		System.out.println(errors);
		assertEquals(2, errors.size());
	}

	/**
	 * Detects simple cycle in the hierarchy
	 * 
	 * <pre>
	 * class A extends A {
	 * }
	 * </pre>
	 * 
	 * @throws IOException
	 */
	public void testSimpleCycle() throws IOException {
		Program program = loadProgramFromString("class A extends A {}");
		String errors = getTypeChecker().typeCheck(program.getClasses().get(
				0));
		System.out.println("errors: " + errors);
		assertEquals("class hierarchy is not acyclic for Class 'A'", errors);
	}

	/**
	 * Detects cycles in the class hierarchy
	 * 
	 * A - B - C - A
	 */
	public void testAcyclic() {
		Class A = FjFactory.eINSTANCE.createClass();
		A.setName("A");
		Class B = FjFactory.eINSTANCE.createClass();
		B.setName("B");
		B.setSuperclass(A);
		Class C = FjFactory.eINSTANCE.createClass();
		C.setName("C");
		C.setSuperclass(B);
		Class A1 = FjFactory.eINSTANCE.createClass();
		A1.setName("A");
		A1.setSuperclass(C);

		// we need the resource for computing superclasses
		Resource resource = createResource();
		resource.getContents().add(A);
		resource.getContents().add(B);
		resource.getContents().add(C);
		resource.getContents().add(A1);

		FJJavaValidator validator = getValidator();
		BasicDiagnostic basicDiagnostic = new BasicDiagnostic();
		validator.validate(A1, basicDiagnostic, null);
		System.out.println("diagnostic: " + basicDiagnostic.toString());
		System.out.println("diagnostic: "
				+ basicDiagnostic.getChildren().get(0).getMessage());
		String diagnostic = basicDiagnostic.getChildren().get(0).toString();
		System.out.println("diagnostic: " + diagnostic);
		assertEquals(
				"Diagnostic ERROR code=CheckTypeFailedClass \"class hierarchy is not acyclic for Class 'A'\" at Class'A'",
				diagnostic);
	}

	/**
	 * Test for file classes with the same name in the same program
	 */
	public void testDuplicateClassesValidation() {
		Resource resource = loadResource("duplicate_classes.fj");
		Program program = (Program) resource.getContents().get(0);
		
		Class A1 = program.getClasses().get(0);
		
		FJJavaValidator validator = getValidator();
		BasicDiagnostic basicDiagnostic = new BasicDiagnostic();
		
		validator.validate(A1, basicDiagnostic, null);
		assertEquals(2, basicDiagnostic.getChildren().size());
		assertEquals("Duplicate Class 'A'",
				basicDiagnostic.getChildren().get(0).getMessage());
		assertEquals("Duplicate Class 'A'",
				basicDiagnostic.getChildren().get(1).getMessage());
	}

} // ClassTest
