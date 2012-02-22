package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class SubTypeSequencesTypeRule extends FJTypeSystemRule {

	protected Variable<Integer> var_i = new Variable<Integer>(
			createBasicType("Integer"));

	protected Variable<it.xsemantics.example.fj.fj.Type> var_argType = new Variable<it.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<java.util.List<it.xsemantics.example.fj.fj.Expression>> var_args = new Variable<java.util.List<it.xsemantics.example.fj.fj.Expression>>(
			createCollectionType(createEClassifierType(basicPackage
					.getExpression())));

	protected Variable<java.util.List<it.xsemantics.example.fj.fj.Parameter>> var_params = new Variable<java.util.List<it.xsemantics.example.fj.fj.Parameter>>(
			createCollectionType(createEClassifierType(basicPackage
					.getParameter())));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public SubTypeSequencesTypeRule() {
		this("SubTypeSequences", "|-", "<:");
	}

	public SubTypeSequencesTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<java.util.List<it.xsemantics.example.fj.fj.Expression>> getLeft() {
		return var_args;
	}

	@Override
	public Variable<java.util.List<it.xsemantics.example.fj.fj.Parameter>> getRight() {
		return var_params;
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
		return new SubTypeSequencesTypeRule("SubTypeSequences", "|-", "<:");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		equals(length(var_args), length(var_params));

		register("forall " + stringRep(length(var_args)));
		try {
			for (var_i.setValue(0); var_i.getValue() < length(var_args); var_i
					.setValue(var_i.getValue() + 1)) {

				var_argType = new Variable<it.xsemantics.example.fj.fj.Type>(
						createEClassifierType(basicPackage.getType()), null);

				applyTypeRule(env_G, var_args.getValue().get(var_i.getValue()),
						var_argType);

				applySubtypeRule(env_G, var_argType,
						var_params.getValue().get(var_i.getValue()).getType());

			}
		} catch (Throwable e) {
			registerAndThrowFailure(e);
		}
		register("end " + "forall " + stringRep(length(var_args)));

		// final check for variable initialization

	}

}
