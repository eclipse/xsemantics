package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class UnifyVariableArrowTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.TypeVariable> var_v1 = new Variable<it.xsemantics.example.lambda.lambda.TypeVariable>(
			createEClassifierType(basicPackage.getTypeVariable()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t1 = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.ArrowType> var_a2 = new Variable<it.xsemantics.example.lambda.lambda.ArrowType>(
			createEClassifierType(basicPackage.getArrowType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public UnifyVariableArrowTypeRule() {
		this("UnifyVariableArrow", "|-", "==");
	}

	public UnifyVariableArrowTypeRule(String ruleName,
			String typeJudgmentSymbol, String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Type> getLeft() {
		return var_t1;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.ArrowType> getRight() {
		return var_a2;
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
		return new UnifyVariableArrowTypeRule("UnifyVariableArrow", "|-", "==");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		applyNotoccurRule(env_G, var_t1, var_a2);

		var_v1 = new Variable<it.xsemantics.example.lambda.lambda.TypeVariable>(
				createEClassifierType(basicPackage.getTypeVariable()), castto(
						var_t1.getValue(),
						it.xsemantics.example.lambda.lambda.TypeVariable.class));

		applyMappingRule(env_G, var_v1, var_a2);

		// final check for variable initialization

	}

}
