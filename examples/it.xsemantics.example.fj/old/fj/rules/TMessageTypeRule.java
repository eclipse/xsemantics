package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class TMessageTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.Message> var_m = new Variable<it.xsemantics.example.fj.fj.Message>(
			createEClassifierType(basicPackage.getMessage()));

	protected Variable<it.xsemantics.example.fj.fj.Type> var_T = new Variable<it.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TMessageTypeRule() {
		this("TMessage", "|-", ":");
	}

	public TMessageTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Message> getLeft() {
		return var_m;
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Type> getRight() {
		return var_T;
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
		return new TMessageTypeRule("TMessage", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {
		// axiom

		// final check for variable initialization

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
