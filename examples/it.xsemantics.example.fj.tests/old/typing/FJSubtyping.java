/**
 * 
 */
package it.xsemantics.example.fj.typing;

import com.google.inject.Inject;

import it.xsemantics.example.fj.typesystem.fj.FJTypeSystemDefinition;
import it.xtypes.runtime.TypeSystemResult;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.Type;

/**
 * This class is superseded by the generated type system FjTypeSystemDefinition,
 * it is here only as a wrapper for FjTypeSystemDefinition, for old unit tests
 * 
 * @author Lorenzo Bettini
 * 
 */
public class FJSubtyping {
	@Inject
	FJTypeSystemDefinition typeSystem;

	public boolean isSubtype(Type t1, Type t2) {
		return isResultTrue(typeSystem.checkSubtype(t1, t2));
	}

	public boolean isSubtype(Class c1, Class c2) {
		return isResultTrue(typeSystem.checkSubtype(c1, c2));
	}

	protected boolean isResultTrue(TypeSystemResult<Boolean> result) {
		return result.getValue() != null && result.getValue();
	}

}
