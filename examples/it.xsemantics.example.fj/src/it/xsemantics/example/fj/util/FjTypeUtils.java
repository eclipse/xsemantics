/**
 * 
 */
package it.xsemantics.example.fj.util;

import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.FjFactory;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.fj.TypedElement;

/**
 * Utility functions for types
 * 
 * @author bettini
 * 
 */
public class FjTypeUtils {
	/**
	 * Sets the type of a typed element as a class reference
	 * 
	 * @param typedElement
	 * @param cl
	 */
	public void setTypeClassReference(TypedElement typedElement, Class cl) {
		ClassType type = createClassType(cl);
		typedElement.setType(type);
	}

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

	/**
	 * @param type
	 * @return the string representation of the passed type (both for basic and
	 *         class types)
	 */
	public static String typeToString(Type type) {
		if (type instanceof ClassType) {
			return typeToString((ClassType) type);
		}
		if (type instanceof BasicType) {
			return typeToString((BasicType) type);
		}
		return "Unknown type: " + type;
	}

	public static String typeToString(ClassType type) {
		return (type.getClassref() != null ? type.getClassref().getName() : "");
	}

	public static String typeToString(BasicType type) {
		return type.getBasic();
	}
}
