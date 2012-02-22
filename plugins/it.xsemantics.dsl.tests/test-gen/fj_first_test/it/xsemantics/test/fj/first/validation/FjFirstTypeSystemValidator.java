package it.xsemantics.test.fj.first.validation;

import com.google.inject.Inject;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Program;
import it.xsemantics.runtime.validation.XsemanticsBasedDeclarativeValidator;
import it.xsemantics.test.fj.first.FjFirstTypeSystem;
import org.eclipse.xtext.validation.Check;

public class FjFirstTypeSystemValidator extends XsemanticsBasedDeclarativeValidator {
	@Inject
	protected FjFirstTypeSystem xsemanticsSystem;

	@Check
	public void checkMain(final Program program) {
		generateErrors(
			xsemanticsSystem.checkMain(program),
			program);
	}
	
	@Check
	public void checkClassOk(final it.xsemantics.example.fj.fj.Class clazz) {
		generateErrors(
			xsemanticsSystem.checkClassOk(clazz),
			clazz);
	}
	
	@Check
	public void checkMethodBody(final Method method) {
		generateErrors(
			xsemanticsSystem.checkMethodBody(method),
			method);
	}
	
	@Check
	public void checkField(final Field field) {
		generateErrors(
			xsemanticsSystem.checkField(field),
			field);
	}
	
	@Check
	public void checkMethodOverride(final Method method) {
		generateErrors(
			xsemanticsSystem.checkMethodOverride(method),
			method);
	}
	
	@Check
	public void checkClassHierachyNotCyclic(final it.xsemantics.example.fj.fj.Class cl) {
		generateErrors(
			xsemanticsSystem.checkClassHierachyNotCyclic(cl),
			cl);
	}
}
