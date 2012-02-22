package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class BoolConstantTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.BoolConstant> var_b = new Variable<it.xsemantics.example.fj.fj.BoolConstant>(
			createEClassifierType(basicPackage.getBoolConstant()));

	protected Variable<it.xsemantics.example.fj.fj.Type> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public BoolConstantTypeRule() {
		this("BoolConstant", "|-", ":");
	}

	public BoolConstantTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.BoolConstant> getLeft() {
		return var_b;
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Type> getRight() {
		if (right_var == null)
			right_var = new Variable<it.xsemantics.example.fj.fj.Type>(
					createEClassifierType(basicPackage.getType()), null);
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
		return new BoolConstantTypeRule("BoolConstant", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {
		// axiom

		getRight().setValue(
				castto(featureAssignments(factory.createBasicType(),
						new FeatureAssignmentPair("basic", "boolean")),
						it.xsemantics.example.fj.fj.Type.class));

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
