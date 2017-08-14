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

import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.tests.loader.FJTestLoader;
import it.xsemantics.example.fj.validation.FJJavaValidator;

import java.io.IOException;
import java.util.Iterator;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import com.google.inject.Injector;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Type</b></em>'. <!-- end-user-doc -->
 */
public class TestWithLoader extends TestCase {

	/**
	 * The loader for this Type test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 */
	protected FJTestLoader loader = null;

	public Resource createResource() {
		return loader.createResource();
	}

	public Resource loadFromString(String program) throws IOException {
		return loader.loadFromString(program);
	}

	public Program loadProgramFromString(String program) throws IOException {
		return loader.loadProgramFromString(program);
	}

	public Resource loadResource(String fileName) {
		return loader.loadResource(fileName);
	}

	public Injector getInjector() {
		return loader.getInjector();
	}

	public FJJavaValidator getValidator() {
		return getInjector().getInstance(FJJavaValidator.class);
	}
	

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(TestWithLoader.class);
	}

	/**
	 * Constructs a new Type test case with the given name. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 */
	public TestWithLoader(String name) {
		super(name);
	}

	/**
	 * Sets the loader for this Type test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 */
	protected void setLoader(FJTestLoader fixture) {
		this.loader = fixture;
	}

	/**
	 * Returns the loader for this Type test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 */
	protected FJTestLoader getLoader() {
		return loader;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setLoader(new FJTestLoader());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setLoader(null);
	}

	/**
	 * Loads the specified file (which must be in the directory tests) and
	 * returns the associated program. Fails if there were errors (e.g., syntax
	 * errors) when loading the resource.
	 * 
	 * @param fileName
	 * @return
	 */
	protected Program getProgramFromResource(String fileName) {
		Resource resource = getLoader().loadResource(fileName);
		EList<Diagnostic> errors = resource.getErrors();
		if (errors.size() > 0) {
			System.err.println("unexpected errors: " + errors);
		}
		assertEquals(0, errors.size());
		EObject program = resource.getContents().get(0);
		return (Program) program;
	}

	/**
	 * Loads the specified string and returns the associated program. Fails if
	 * there were errors (e.g., syntax errors) when loading the resource.
	 * 
	 * @param prog
	 * @return
	 * @throws IOException
	 */
	protected Program getProgramFromString(String prog) throws IOException {
		Resource resource = getLoader().loadFromString(prog);
		EList<Diagnostic> errors = resource.getErrors();
		if (errors.size() > 0) {
			System.err.println("unexpected errors: " + errors);
		}
		assertEquals(0, errors.size());
		EObject program = resource.getContents().get(0);
		return (Program) program;
	}

	/**
	 * Loads the specified string representing a wrong program. Fails if there
	 * were no errors (e.g., syntax errors) when loading the resource.
	 * 
	 * @param prog
	 * @return the list of errors
	 * @throws IOException
	 */
	protected EList<Diagnostic> getErrorProgramFromString(String prog)
			throws IOException {
		Resource resource = getLoader().loadFromString(prog);
		EList<Diagnostic> errors = resource.getErrors();
		assertTrue(errors.size() > 0);
		return errors;
	}

	/**
	 * Utility functions returning the number of elements in an iterable
	 * 
	 * @param iterable
	 * @return
	 */
	protected int sizeOfIterable(Iterable<?> iterable) {
		int size = 0;

		for (@SuppressWarnings("unused")
		Object object : iterable) {
			++size;
		}

		return size;
	}

	/**
	 * Utility functions returning the number of elements in an iterable
	 * 
	 * @param iterable
	 * @return
	 */
	protected int sizeOfIterable(Iterator<?> iterable) {
		int size = 0;

		while (iterable.hasNext()) {
			++size;
			iterable.next();
		}

		return size;
	}

} // TypeTest
