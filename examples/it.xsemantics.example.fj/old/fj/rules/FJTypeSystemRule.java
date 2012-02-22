package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xsemantics.example.fj.typesystem.fj.FJTypeSystemDefinition;

import it.xtypes.runtime.RuntimeRule;
import it.xtypes.runtime.RuleFailedException;
import it.xtypes.runtime.TypingJudgmentEnvironment;

import it.xsemantics.example.fj.fj.FjFactory;
import it.xsemantics.example.fj.fj.FjPackage;

public abstract class FJTypeSystemRule extends RuntimeRule {

	protected FjFactory factory = FjFactory.eINSTANCE;

	protected FjPackage basicPackage = FjPackage.eINSTANCE;

	public FJTypeSystemRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	public void applyTypeRule(TypingJudgmentEnvironment environment,
			Object left, Object right) throws RuleFailedException {
		addAppliedRuleToTrace(((FJTypeSystemDefinition) runtimeTypeSystem)
				.applyTypeRule(environment, left, right));
	}

	public void applySubtypeRule(TypingJudgmentEnvironment environment,
			Object left, Object right) throws RuleFailedException {
		addAppliedRuleToTrace(((FJTypeSystemDefinition) runtimeTypeSystem)
				.applySubtypeRule(environment, left, right));
	}

	public void applyOverrideRule(TypingJudgmentEnvironment environment,
			Object left, Object right) throws RuleFailedException {
		addAppliedRuleToTrace(((FJTypeSystemDefinition) runtimeTypeSystem)
				.applyOverrideRule(environment, left, right));
	}

}
