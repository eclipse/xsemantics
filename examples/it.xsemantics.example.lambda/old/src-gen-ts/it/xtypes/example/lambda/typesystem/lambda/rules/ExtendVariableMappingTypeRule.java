package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class ExtendVariableMappingTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_currentMappingForV1 = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.TypeVariable> var_v1 = new Variable<it.xsemantics.example.lambda.lambda.TypeVariable>(
			createEClassifierType(basicPackage.getTypeVariable()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t1 = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public ExtendVariableMappingTypeRule() {
		this("ExtendVariableMapping", "|-", "~>");
	}

	public ExtendVariableMappingTypeRule(String ruleName,
			String typeJudgmentSymbol, String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.TypeVariable> getLeft() {
		return var_v1;
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
		return new ExtendVariableMappingTypeRule("ExtendVariableMapping", "|-",
				"~>");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		boolean or_temp_1 = false;
		// first or branch
		try {

			var_currentMappingForV1 = new Variable<it.xsemantics.example.lambda.lambda.Type>(
					createEClassifierType(basicPackage.getType()), castto(
							env(env_G, var_v1.getValue().getTypevarName()),
							it.xsemantics.example.lambda.lambda.Type.class));

			applyUnifyRule(env_G, var_currentMappingForV1, var_t1);

			or_temp_1 = true;
		} catch (Throwable e) {
			registerFailure(e);
			// go on with other branches
		}

		// last or branch
		if (!or_temp_1) {
			try {
				env_G.increment(newRuntimeEnvironmentEntry(var_v1.getValue()
						.getTypevarName(), var_t1.getValue()));
			} catch (Throwable e) {
				registerAndThrowFailure(e);
			}
		}

		// final check for variable initialization

	}

}
