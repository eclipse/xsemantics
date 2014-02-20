/**
 * 
 */
package it.xsemantics.example.fj.util;

import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.FjFactory;

/**
 * Utility functions for types
 * 
 * @author bettini
 * 
 */
public class FjTypeUtils {

	public ClassType createClassType(Class cl) {
		ClassType type = FjFactory.eINSTANCE.createClassType();
		type.setClassref(cl);
		return type;
	}

	public BasicType createBasicType(String basic) {
		BasicType type = FjFactory.eINSTANCE.createBasicType();
		type.setBasic(basic);
		return type;
	}
	
	public BasicType createStringType() {
		return createBasicType("String");
	}
	
	public BasicType createIntType() {
		return createBasicType("int");
	}

}
