/**
 * <copyright>
 * </copyright>
 *
 * $Id: FJAllTests.java,v 1.1 2009-11-02 11:25:13 bettini Exp $
 */
package it.xsemantics.example.fj.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>FJ</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class FJAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static Test suite() {
		TestSuite suite = new FJAllTests("FJ Tests");
		suite.addTestSuite(UtilTest.class);
		suite.addTestSuite(ProgramTest.class);
		suite.addTestSuite(AuxiliaryFunctionTest.class);
		suite.addTestSuite(FormattingTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FJAllTests(String name) {
		super(name);
	}

} //FJAllTests
