/**
 * 
 */
package it.xsemantics.example.fj.typing;

import it.xsemantics.example.fj.typesystem.fj.FJTypeSystemDefinition;
import it.xsemantics.example.fj.util.ContainingClassFinder;
import it.xtypes.runtime.TypeSystemResult;
import it.xtypes.runtime.TypingJudgmentEnvironment;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;

import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.example.fj.fj.util.FjSwitch;

/**
 * This class is superseded by the generated type system FjTypeSystemDefinition,
 * it is here only as a wrapper for FjTypeSystemDefinition, for old unit tests
 * 
 * @author Lorenzo Bettini
 * 
 */
public class FJTypeChecker extends FjSwitch<String> {
	@Inject
	FJTypeSystemDefinition typeSystem;

	ContainingClassFinder containingClassFinder = new ContainingClassFinder();

	public String typeCheck(Expression object) {
		return getResultErrors(typeSystem.typeAsType(
				environmentForThis(object), object));
	}

	public String typeCheck(Field object) {
		return getResultErrors(typeSystem.typeAsString(
				environmentForThis(object), object));
	}

	public String typeCheck(Method object) {
		return getResultErrors(typeSystem.typeAsString(object));
	}

	public String typeCheck(Program object) {
		return getResultErrors(typeSystem.typeAsString(object));
	}

	public String typeCheck(Class object) {
		return getResultErrors(typeSystem.typeAsString(object));
	}

	/**
	 * @param result
	 * @return
	 */
	protected String getResultErrors(TypeSystemResult<?> result) {
		return (result.getFailure() != null ? result.getFailure().getMessage()
				: "");
	}

	protected TypingJudgmentEnvironment environmentForThis(EObject object) {
		return containingClassFinder.environmentForThis(object);
	}
}
