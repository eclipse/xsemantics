package it.xsemantics.example.lambda.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class LambdaTypeSystemAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				LambdaTypeSystemAllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TypeVariableTests.class);
		suite.addTestSuite(LambdaTypeBeautifierTests.class);
		suite.addTestSuite(OccurCheckTest.class);
		suite.addTestSuite(UnifyTest.class);
		suite.addTestSuite(SubstitutionTest.class);
		suite.addTestSuite(LambdaTypeTest.class);
		suite.addTestSuite(LambdaTypeInferAndModifyTest.class);
		suite.addTestSuite(LambdaValidatorTest.class);
		//$JUnit-END$
		return suite;
	}

}
