package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class TStringConstantTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.StringConstant> var_s = new Variable<it.xsemantics.example.lambda.lambda.StringConstant>(
			createEClassifierType(basicPackage.getStringConstant()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TStringConstantTypeRule() {
		this("TStringConstant", "|-", ":");
	}

	public TStringConstantTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.StringConstant> getLeft() {
		return var_s;
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
		return new TStringConstantTypeRule("TStringConstant", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		assignment(var_t, featureAssignments(factory.createStringType()));

		// final check for variable initialization

	}

}
