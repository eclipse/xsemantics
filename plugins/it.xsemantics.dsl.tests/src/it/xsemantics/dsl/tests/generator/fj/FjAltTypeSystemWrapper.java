package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.IFjTypeSystem;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Method;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.test.fj.alt.FjAltTypeSystem;

import java.util.List;

public class FjAltTypeSystemWrapper extends FjAltTypeSystem
		implements IFjTypeSystem {

	@Override
	public Result<List<it.xsemantics.example.fj.fj.Class>> superclasses(
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	@Override
	public Result<List<it.xsemantics.example.fj.fj.Class>> superclasses(
			RuleEnvironment _environment_,
			RuleApplicationTrace _trace_,
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	@Override
	public Result<List<Field>> fields(
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	@Override
	public Result<List<Field>> fields(RuleEnvironment _environment_,
			RuleApplicationTrace _trace_,
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

	@Override
	public Result<List<Method>> methods(
			it.xsemantics.example.fj.fj.Class _Class) {
		return null;
	}

}