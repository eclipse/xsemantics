package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class UnifyIntTypeTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.IntType> var_i1 = new Variable<it.xsemantics.example.lambda.lambda.IntType>(
			createEClassifierType(basicPackage.getIntType()));

	protected Variable<it.xsemantics.example.lambda.lambda.IntType> var_i2 = new Variable<it.xsemantics.example.lambda.lambda.IntType>(
			createEClassifierType(basicPackage.getIntType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public UnifyIntTypeTypeRule() {
		this("UnifyIntType", "|-", "==");
	}

	public UnifyIntTypeTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.IntType> getLeft() {
		return var_i1;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.IntType> getRight() {
		return var_i2;
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
		return new UnifyIntTypeTypeRule("UnifyIntType", "|-", "==");
	}

	@Override
	public void applyImpl() throws RuleFailedException {
		// axiom

		// final check for variable initialization

	}

}
