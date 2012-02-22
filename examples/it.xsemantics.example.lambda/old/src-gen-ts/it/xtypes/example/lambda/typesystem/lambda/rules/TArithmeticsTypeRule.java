package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class TArithmeticsTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_termType = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.Arithmetics> var_ar = new Variable<it.xsemantics.example.lambda.lambda.Arithmetics>(
			createEClassifierType(basicPackage.getArithmetics()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_int = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TArithmeticsTypeRule() {
		this("TArithmetics", "|-", ":");
	}

	public TArithmeticsTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Arithmetics> getLeft() {
		return var_ar;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Type> getRight() {
		return var_int;
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
		return new TArithmeticsTypeRule("TArithmetics", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_termType = new Variable<it.xsemantics.example.lambda.lambda.Type>(
				createEClassifierType(basicPackage.getType()), null);

		applyTypeRule(env_G, var_ar.getValue().getTerm(), var_termType);

		applyUnifyRule(env_G, var_termType,
				featureAssignments(factory.createIntType()));

		applySubstitutionRule(env_G, var_termType, var_int);

		// final check for variable initialization

	}

}
