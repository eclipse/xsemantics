package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class TFieldTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.Field> var_f = new Variable<it.xsemantics.example.fj.fj.Field>(
			createEClassifierType(basicPackage.getField()));

	protected Variable<it.xsemantics.example.fj.fj.Type> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TFieldTypeRule() {
		this("TField", "|-", ":");
	}

	public TFieldTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Field> getLeft() {
		return var_f;
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Type> getRight() {
		if (right_var == null)
			right_var = new Variable<it.xsemantics.example.fj.fj.Type>(
					createEClassifierType(basicPackage.getType()), null);
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
		return new TFieldTypeRule("TField", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {
		// axiom

		getRight().setValue(var_f.getValue().getType());

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
