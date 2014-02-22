/**
 * 
 */
package it.xsemantics.dsl.tests.generator.fj.common;

import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.runtime.StringRepresentation;

/**
 * @author bettini
 * 
 */
public class FjTestsStringRepresentation extends StringRepresentation {

	/**
	 * Reduces some 'noise' for ClassTypes in the RuleEnvironment
	 * 
	 * @param classType
	 * @return
	 */
	protected String stringRep(ClassType classType) {
		return classType.getClassref().getName();
	}
	
	protected String stringRep(BasicType basicType) {
		return basicType.getBasic();
	}
}
