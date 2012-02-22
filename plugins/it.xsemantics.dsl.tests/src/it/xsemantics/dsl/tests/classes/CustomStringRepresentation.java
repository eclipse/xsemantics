/**
 * 
 */
package it.xsemantics.dsl.tests.classes;

import org.eclipse.emf.ecore.EClass;

import it.xsemantics.runtime.StringRepresentation;

/**
 * @author bettini
 *
 */
public class CustomStringRepresentation extends StringRepresentation {

	protected String stringRep(EClass eClass) {
		return "EClass(name=" + eClass.getName() + ")";
	}
}
