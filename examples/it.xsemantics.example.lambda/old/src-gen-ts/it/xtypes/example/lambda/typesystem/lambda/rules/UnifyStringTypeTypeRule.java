package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class UnifyStringTypeTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.StringType> var_s1 = new Variable<it.xsemantics.example.lambda.lambda.StringType>(
			createEClassifierType(basicPackage.getStringType()));

	protected Variable<it.xsemantics.example.lambda.lambda.StringType> var_s2 = new Variable<it.xsemantics.example.lambda.lambda.StringType>(
			createEClassifierType(basicPackage.getStringType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public UnifyStringTypeTypeRule() {
		this("UnifyStringType", "|-", "==");
	}

	public UnifyStringTypeTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.StringType> getLeft() {
		return var_s1;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.StringType> getRight() {
		return var_s2;
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
		return new UnifyStringTypeTypeRule("UnifyStringType", "|-", "==");
	}

	@Override
	public void applyImpl() throws RuleFailedException {
		// axiom

		// final check for variable initialization

	}

}
