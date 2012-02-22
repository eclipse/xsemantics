package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class TIntConstantTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.IntConstant> var_i = new Variable<it.xsemantics.example.fj.fj.IntConstant>(
			createEClassifierType(basicPackage.getIntConstant()));

	protected Variable<it.xsemantics.example.fj.fj.Type> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TIntConstantTypeRule() {
		this("TIntConstant", "|-", ":");
	}

	public TIntConstantTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.IntConstant> getLeft() {
		return var_i;
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
		return new TIntConstantTypeRule("TIntConstant", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {
		// axiom

		getRight().setValue(
				castto(featureAssignments(factory.createBasicType(),
						new FeatureAssignmentPair("basic", "int")),
						it.xsemantics.example.fj.fj.Type.class));

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
