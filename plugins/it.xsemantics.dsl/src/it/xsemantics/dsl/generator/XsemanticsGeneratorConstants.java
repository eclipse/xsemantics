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

	protected static final List<String> RESULT_GET_METHODS;
	
	private XsemanticsGeneratorConstants() {
		
	}

	static {
		RESULT_GET_METHODS = new ArrayList<String>();
		RESULT_GET_METHODS.add("getFirst()");
		RESULT_GET_METHODS.add("getSecond()");
		RESULT_GET_METHODS.add("getThird()");
	}

	public static Iterable<String> getResultGetMethods() {
		return RESULT_GET_METHODS;
	}
}
