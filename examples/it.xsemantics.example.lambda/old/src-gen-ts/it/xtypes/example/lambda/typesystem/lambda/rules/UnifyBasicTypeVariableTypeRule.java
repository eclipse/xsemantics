package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class UnifyBasicTypeVariableTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.TypeVariable> var_v1 = new Variable<it.xsemantics.example.lambda.lambda.TypeVariable>(
			createEClassifierType(basicPackage.getTypeVariable()));

	protected Variable<it.xsemantics.example.lambda.lambda.BasicType> var_b = new Variable<it.xsemantics.example.lambda.lambda.BasicType>(
			createEClassifierType(basicPackage.getBasicType()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t1 = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public UnifyBasicTypeVariableTypeRule() {
		this("UnifyBasicTypeVariable", "|-", "==");
	}

	public UnifyBasicTypeVariableTypeRule(String ruleName,
			String typeJudgmentSymbol, String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.BasicType> getLeft() {
		return var_b;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Type> getRight() {
		return var_t1;
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
		return new UnifyBasicTypeVariableTypeRule("UnifyBasicTypeVariable",
				"|-", "==");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_v1 = new Variable<it.xsemantics.example.lambda.lambda.TypeVariable>(
				createEClassifierType(basicPackage.getTypeVariable()), castto(
						var_t1.getValue(),
						it.xsemantics.example.lambda.lambda.TypeVariable.class));

		applyMappingRule(env_G, var_v1, var_b);

		// final check for variable initialization

	}

}
