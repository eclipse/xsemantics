package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class TAbstractionTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_paramType = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_bodyType = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.Abstraction> var_fun = new Variable<it.xsemantics.example.lambda.lambda.Abstraction>(
			createEClassifierType(basicPackage.getAbstraction()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TAbstractionTypeRule() {
		this("TAbstraction", "|-", ":");
	}

	public TAbstractionTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Abstraction> getLeft() {
		return var_fun;
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
		return new TAbstractionTypeRule("TAbstraction", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_paramType = new Variable<it.xsemantics.example.lambda.lambda.Type>(
				createEClassifierType(basicPackage.getType()), null);

		applyTypeRule(env_G, var_fun.getValue().getParam(), var_paramType);

		var_bodyType = new Variable<it.xsemantics.example.lambda.lambda.Type>(
				createEClassifierType(basicPackage.getType()), null);

		env_G.increment(newRuntimeEnvironmentEntry(var_fun.getValue()
				.getParam(), var_paramType.getValue()));
		applyTypeRule(env_G, var_fun.getValue().getTerm(), var_bodyType);

		env_G.decrement(var_fun.getValue().getParam());
		applySubstitutionRule(env_G, var_paramType, var_paramType);

		applySubstitutionRule(env_G, var_bodyType, var_bodyType);

		assignment(
				var_t,
				featureAssignments(
						factory.createArrowType(),
						new FeatureAssignmentPair("left", clone(var_paramType
								.getValue())), new FeatureAssignmentPair(
								"right", clone(var_bodyType.getValue()))));

		// final check for variable initialization

	}

}
