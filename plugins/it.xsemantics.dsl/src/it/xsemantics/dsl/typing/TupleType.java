/**
 * 
 */
package it.xsemantics.dsl.typing;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author bettini
 * 
 */
public class TupleType extends ArrayList<JvmTypeReference> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TupleType() {

	}

	public TupleType(Collection<? extends JvmTypeReference> c) {
		super(c);
	}

}
