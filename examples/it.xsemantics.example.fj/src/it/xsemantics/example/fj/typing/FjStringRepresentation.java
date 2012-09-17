/**
 * 
 */
package it.xsemantics.example.fj.typing;

import it.xsemantics.example.fj.fj.BoolConstant;
import it.xsemantics.example.fj.fj.IntConstant;
import it.xsemantics.example.fj.fj.StringConstant;
import it.xsemantics.example.fj.fj.This;
import it.xsemantics.runtime.StringRepresentation;

/**
 * @author bettini
 * 
 */
public class FjStringRepresentation extends StringRepresentation {

	public String stringRep(StringConstant s) {
		return "'" + s.getConstant() + "'";
	}

	public String stringRep(IntConstant s) {
		return s.getConstant() + "";
	}

	public String stringRep(BoolConstant s) {
		return s.getConstant() + "";
	}

	public String stringRep(This t) {
		return "this";
	}
}
