/**
 * 
 */
package it.xsemantics.example.fj.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Lorenzo Bettini
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	UtilTest.class,
	ProgramTest.class,
	FjAuxiliaryFunctionTest.class,
	FormattingTest.class,
	FjParserTests.class,
	FjSemanticsTests.class,
	FjValidatorTests.class
})
public class FjAllTests {

}
