/**
 * 
 */
package it.xsemantics.example.lambda.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author bettini
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	LambdaTypeBeautifierTests.class,
	LambdaUtilsTests.class,
	TypeSubstitutionsTests.class,
	TypeVariableTests.class,
	LambdaParserTest.class,
	LambdaTypeSubstitutionTest.class,
	LambdaNotOccurTest.class,
	LambdaUnifyTest.class,
	LambdaTypeTest.class,
	LambdaUtilsTests.class,
	LambdaTypeInferAndModifyTest.class,
	LambdaValidatorTest.class
})
public class LambdaAllTests {

}
