package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class NotOccurTypeTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t1 = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t2 = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public NotOccurTypeTypeRule() {
		this("NotOccurType", "|-", "!-");
	}

	public NotOccurTypeTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Type> getLeft() {
		return var_t1;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Type> getRight() {
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
		return new NotOccurTypeTypeRule("NotOccurType", "|-", "!-");
	}

	@Override
	public void applyImpl() throws RuleFailedException {
		// axiom

		// final check for variable initialization

	}

}
