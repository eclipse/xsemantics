package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class TIntConstantTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.IntConstant> var_i = new Variable<it.xsemantics.example.lambda.lambda.IntConstant>(
			createEClassifierType(basicPackage.getIntConstant()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TIntConstantTypeRule() {
		this("TIntConstant", "|-", ":");
	}

	public TIntConstantTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.IntConstant> getLeft() {
		return var_i;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Type> getRight() {
		return var_t;
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
		return new TIntConstantTypeRule("TIntConstant", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		assignment(var_t, featureAssignments(factory.createIntType()));

		// final check for variable initialization

	}

}
