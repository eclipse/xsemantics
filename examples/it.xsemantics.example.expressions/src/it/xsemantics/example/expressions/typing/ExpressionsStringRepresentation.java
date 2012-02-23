/**
 * 
 */
package it.xsemantics.example.expressions.typing;

import it.xsemantics.runtime.StringRepresentation;

/**
 * @author Lorenzo Bettini
 * 
 */
public class ExpressionsStringRepresentation extends StringRepresentation {

	protected String stringRep(String s) {
		return "'" + s + "'";
	}
}
