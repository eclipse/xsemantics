/**
 * 
 */
package it.xsemantics.dsl.generator;

import java.util.ArrayList;

/**
 * @author bettini
 * 
 */
public class XsemanticsGeneratorConstants {

	protected static ArrayList<String> resultGetMethods;

	static {
		resultGetMethods = new ArrayList<String>();
		resultGetMethods.add("getFirst()");
		resultGetMethods.add("getSecond()");
	}

	public static Iterable<String> getResultGetMethods() {
		return resultGetMethods;
	}
}
