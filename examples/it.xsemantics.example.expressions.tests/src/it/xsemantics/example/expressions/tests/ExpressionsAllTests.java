/**
 * 
 */
package it.xsemantics.example.expressions.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Lorenzo Bettini
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ExpressionsTypingTests.class,
	ExpressionsInterpreterTests.class,
	ExpressionsFirstTypingTests.class,
	ExpressionsFirstInterpreterTests.class
})
public class ExpressionsAllTests {

}
