package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class SubTypeClassTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.ClassType> var_c1 = new Variable<it.xsemantics.example.fj.fj.ClassType>(
			createEClassifierType(basicPackage.getClassType()));

	protected Variable<it.xsemantics.example.fj.fj.ClassType> var_c2 = new Variable<it.xsemantics.example.fj.fj.ClassType>(
			createEClassifierType(basicPackage.getClassType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public SubTypeClassTypeRule() {
		this("SubTypeClass", "|-", "<:");
	}

	public SubTypeClassTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.ClassType> getLeft() {
		return var_c1;
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.ClassType> getRight() {
		return var_c2;
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
		return new SubTypeClassTypeRule("SubTypeClass", "|-", "<:");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		applySubtypeRule(env_G, var_c1.getValue().getClassref(), var_c2
				.getValue().getClassref());

		// final check for variable initialization

	}

}
