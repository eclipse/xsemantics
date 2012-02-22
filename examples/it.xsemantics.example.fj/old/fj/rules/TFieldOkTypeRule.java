package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import it.xtypes.runtime.*;

public class TFieldOkTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.Class> var_C = new Variable<it.xsemantics.example.fj.fj.Class>(
			createEClassifierType(basicPackage.getClass_()));

	protected Variable<it.xsemantics.example.fj.fj.Field> var_inheritedField = new Variable<it.xsemantics.example.fj.fj.Field>(
			createEClassifierType(basicPackage.getField()));

	protected Variable<it.xsemantics.example.fj.fj.Field> var_otherField = new Variable<it.xsemantics.example.fj.fj.Field>(
			createEClassifierType(basicPackage.getField()));

	protected Variable<it.xsemantics.example.fj.fj.Field> var_f = new Variable<it.xsemantics.example.fj.fj.Field>(
			createEClassifierType(basicPackage.getField()));

	protected Variable<String> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TFieldOkTypeRule() {
		this("TFieldOk", "|-", ":");
	}

	public TFieldOkTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Field> getLeft() {
		return var_f;
	}

	@Override
	public Variable<String> getRight() {
		if (right_var == null)
			right_var = new Variable<String>(createBasicType("String"), "OK");
		return right_var;
	}

	@Override
	public TypingJudgmentEnvironment getEnvironment() {
		return env_G;
	}

	@Override
	public void setEnvironment(TypingJudgmentEnvironment environment) {
		if (environment != null)
			env_G = environment;
	}

	@Override
	public RuntimeRule newInstance() {
		return new TFieldOkTypeRule("TFieldOk", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_C = new Variable<it.xsemantics.example.fj.fj.Class>(
				createEClassifierType(basicPackage.getClass_()), castto(
						container(var_f.getValue()),
						it.xsemantics.example.fj.fj.Class.class));

		register("!exists "
				+ stringRep(getAll(var_C.getValue().getSuperclass(), "members",
						"superclass", it.xsemantics.example.fj.fj.Field.class)));
		try {
			boolean not_exist_temp_1 = true;
			try {
				for (java.util.Iterator<it.xsemantics.example.fj.fj.Field> iterator = getAll(
						var_C.getValue().getSuperclass(), "members", "superclass",
						it.xsemantics.example.fj.fj.Field.class).iterator(); iterator
						.hasNext();) {
					var_inheritedField.setValue(iterator.next());
					try {

						equals(var_inheritedField.getValue().getName(), var_f
								.getValue().getName());

						not_exist_temp_1 = false;
						break;
					} catch (Throwable e) {
						registerFailure(e);
						if (!iterator.hasNext())
							throw new RuleFailedException("exists failed", e);
					}
				} // if we're here exists succeeded, thus !exist failed
			} catch (RuleFailedException e) {
				// OK
				not_exist_temp_1 = true;
			}
			if (!not_exist_temp_1)
				throw new RuleFailedException("not exists failed");
		} catch (Throwable e) {
			registerFailure(e);
			throw new RuleFailedException("duplicate field in base class");
		}
		register("end "
				+ "!exists "
				+ stringRep(getAll(var_C.getValue().getSuperclass(), "members",
						"superclass", it.xsemantics.example.fj.fj.Field.class)));
		register("!exists " + stringRep(FjAuxiliaryFunctions.selectFields(var_C.getValue())));
		try {
			boolean not_exist_temp_2 = true;
			try {
				for (java.util.Iterator<it.xsemantics.example.fj.fj.Field> iterator = FjAuxiliaryFunctions.selectFields(var_C
						.getValue()).iterator(); iterator.hasNext();) {
					var_otherField.setValue(iterator.next());
					try {

						equals(var_otherField.getValue().getName(), var_f
								.getValue().getName());

						notEquals(var_otherField, var_f);

						not_exist_temp_2 = false;
						break;
					} catch (Throwable e) {
						registerFailure(e);
						if (!iterator.hasNext())
							throw new RuleFailedException("exists failed", e);
					}
				} // if we're here exists succeeded, thus !exist failed
			} catch (RuleFailedException e) {
				// OK
				not_exist_temp_2 = true;
			}
			if (!not_exist_temp_2)
				throw new RuleFailedException("not exists failed");
		} catch (Throwable e) {
			registerFailure(e);
			throw new RuleFailedException("duplicate field in the same class");
		}
		register("end " + "!exists " + stringRep(FjAuxiliaryFunctions.selectFields(var_C.getValue())));

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
