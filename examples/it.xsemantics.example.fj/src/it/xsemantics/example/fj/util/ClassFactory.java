/**
 * 
 */
package it.xsemantics.example.fj.util;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.FjFactory;

/**
 * Simple utility methods for creating classes with a name
 * and possible superclass (for testing purposes)
 * 
 * @author bettini
 * 
 */
public class ClassFactory {
	public static Class createClass(String name, Class superClass) {
		Class c = FjFactory.eINSTANCE.createClass();
		c.setName(name);
		c.setSuperclass(superClass);
		return c;
	}
	
	public static Class createClass(String name) {
		return createClass(name, null);
	}
}
