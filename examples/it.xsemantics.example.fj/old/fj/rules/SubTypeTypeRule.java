package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class SubTypeTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.Type> var_t1 = new Variable<it.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.fj.fj.Type> var_t2 = new Variable<it.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public SubTypeTypeRule() {
		this("SubType", "|-", "<:");
	}

	public SubTypeTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Type> getLeft() {
		return var_t1;
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Type> getRight() {
		return var_t2;
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
		return new SubTypeTypeRule("SubType", "|-", "<:");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		fail(stringRep(var_t1.getValue()) + " is not a subtype of "
				+ stringRep(var_t2.getValue()));

		// final check for variable initialization

	}

}
