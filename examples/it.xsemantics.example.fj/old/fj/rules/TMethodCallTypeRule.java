package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class TMethodCallTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.MethodCall> var_m = new Variable<it.xsemantics.example.fj.fj.MethodCall>(
			createEClassifierType(basicPackage.getMethodCall()));

	protected Variable<it.xsemantics.example.fj.fj.Type> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TMethodCallTypeRule() {
		this("TMethodCall", "|-", ":");
	}

	public TMethodCallTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.MethodCall> getLeft() {
		return var_m;
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
		return new TMethodCallTypeRule("TMethodCall", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		applySubtypeRule(env_G, var_m.getValue().getArgs(), var_m.getValue()
				.getMethod().getParams());

		getRight().setValue(var_m.getValue().getMethod().getType());

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
