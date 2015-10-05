/**
 * 
 */
package it.xsemantics.example.expressions.performance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Lorenzo Bettini
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ExpressionsStandardTypeSystemPerformanceTest.class,
	ExpressionsCachedTypeSystemPerformanceTest.class
})
public class ExpressionsPerformanceAllTests {

}
