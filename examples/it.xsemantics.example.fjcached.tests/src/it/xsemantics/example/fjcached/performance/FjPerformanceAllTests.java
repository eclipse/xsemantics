/**
 * 
 */
package it.xsemantics.example.fjcached.performance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Lorenzo Bettini
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	FjPerformanceTest.class,
	FjCachedPerformanceTest.class
})
public class FjPerformanceAllTests {

}
