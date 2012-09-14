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
	AuxiliaryFunctionTest.class,
	FormattingTest.class,
	FjParserTests.class
})
public class FjAllTests {

}
