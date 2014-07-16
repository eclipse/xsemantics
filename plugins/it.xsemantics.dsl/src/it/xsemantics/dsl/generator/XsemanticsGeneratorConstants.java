/**
 * 
 */
package it.xsemantics.dsl.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lorenzo Bettini
 * 
 */
public class XsemanticsGeneratorConstants {

	protected static List<String> resultGetMethods;
	
	private XsemanticsGeneratorConstants() {
		
	}

	static {
		resultGetMethods = new ArrayList<String>();
		resultGetMethods.add("getFirst()");
		resultGetMethods.add("getSecond()");
		resultGetMethods.add("getThird()");
	}

	public static Iterable<String> getResultGetMethods() {
		return resultGetMethods;
	}
}
