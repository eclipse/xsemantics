package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class TProgramOkTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.Program> var_p = new Variable<it.xsemantics.example.lambda.lambda.Program>(
			createEClassifierType(basicPackage.getProgram()));

	protected Variable<String> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TProgramOkTypeRule() {
		this("TProgramOk", "|-", ":");
	}

	public TProgramOkTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Program> getLeft() {
		return var_p;
	}

	@Override
	public Variable<String> getRight() {
		if (right_var == null)
			right_var = new Variable<String>(createBasicType("String"), "ok");
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
		return new TProgramOkTypeRule("TProgramOk", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_t = new Variable<it.xsemantics.example.lambda.lambda.Type>(
				createEClassifierType(basicPackage.getType()), null);

		applyTypeRule(env_G, var_p.getValue().getTerm(), var_t);

	}

}
