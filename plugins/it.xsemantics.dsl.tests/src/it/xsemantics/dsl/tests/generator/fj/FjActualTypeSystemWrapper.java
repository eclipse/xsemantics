package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import it.xsemantics.example.fj.fj.Class;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.fj.TypedElement;
import it.xsemantics.example.fj.typing.FjTypeSystem;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class FjActualTypeSystemWrapper extends FjTypeSystem
		implements IFjTypeSystem {

	
	public Result<List<it.xsemantics.example.fj.fj.Class>> superclasses(
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	
	public Result<List<it.xsemantics.example.fj.fj.Class>> superclasses(
			RuleEnvironment _environment_,
			RuleApplicationTrace _trace_,
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	
	public Result<List<Field>> fields(
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	
	public Result<List<Field>> fields(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_,
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	
	public Result<List<Method>> methods(
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	
	public Result<Type> typedecl(TypedElement _TypedElement) {
		return null;
	}

	
	public Result<Type> typedecl(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, TypedElement _TypedElement) {
		return null;
	}

	
	public Result<Boolean> subclass(Class _Class, Class _Class_1) {
		return null;
	}

	
	public Result<Boolean> subclass(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, Class _Class, Class _Class_1) {
		return null;
	}

	
	public Result<Boolean> check(EObject _EObject) {
		return null;
	}

	
	public Result<Boolean> check(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_, EObject _EObject) {
		return null;
	}

}