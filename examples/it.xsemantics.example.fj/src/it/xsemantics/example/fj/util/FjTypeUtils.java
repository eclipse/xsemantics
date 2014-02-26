/**
 * 
 */
package it.xsemantics.example.fj.util;

import org.eclipse.xtext.EcoreUtil2;

import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.FjFactory;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleEnvironmentEntry;

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

	public RuleEnvironment environmentWithMappedThisAsContainingClass(
			Expression expression) {
		Class containingClass = EcoreUtil2.getContainerOfType(expression,
				Class.class);
		if (containingClass != null) {
			return environmentWithMappedThis(containingClass);
		}
		return null;
	}


	public RuleEnvironment environmentWithMappedThis(Class containingClass) {
		ClassType thisType = createClassType(containingClass);
		return new RuleEnvironment(new RuleEnvironmentEntry("this",
				thisType));
	}
}
