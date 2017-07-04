/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package it.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xsemantics.example.lambda.typesystem.lambda.LambdaTypeSystemDefinition;

import it.xtypes.runtime.RuntimeRule;
import it.xtypes.runtime.RuleFailedException;
import it.xtypes.runtime.TypingJudgmentEnvironment;

import it.xsemantics.example.lambda.lambda.LambdaFactory;
import it.xsemantics.example.lambda.lambda.LambdaPackage;

public abstract class LambdaTypeSystemRule extends RuntimeRule {

	protected LambdaFactory factory = LambdaFactory.eINSTANCE;

	protected LambdaPackage basicPackage = LambdaPackage.eINSTANCE;

	public LambdaTypeSystemRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	public void applyUnifyRule(TypingJudgmentEnvironment environment,
			Object left, Object right) throws RuleFailedException {
		addAppliedRuleToTrace(((LambdaTypeSystemDefinition) runtimeTypeSystem)
				.applyUnifyRule(environment, left, right));
	}

	public void applySubstitutionRule(TypingJudgmentEnvironment environment,
			Object left, Object right) throws RuleFailedException {
		addAppliedRuleToTrace(((LambdaTypeSystemDefinition) runtimeTypeSystem)
				.applySubstitutionRule(environment, left, right));
	}

	public void applyMappingRule(TypingJudgmentEnvironment environment,
			Object left, Object right) throws RuleFailedException {
		addAppliedRuleToTrace(((LambdaTypeSystemDefinition) runtimeTypeSystem)
				.applyMappingRule(environment, left, right));
	}

	public void applyNotoccurRule(TypingJudgmentEnvironment environment,
			Object left, Object right) throws RuleFailedException {
		addAppliedRuleToTrace(((LambdaTypeSystemDefinition) runtimeTypeSystem)
				.applyNotoccurRule(environment, left, right));
	}

	public void applyTypeRule(TypingJudgmentEnvironment environment,
			Object left, Object right) throws RuleFailedException {
		addAppliedRuleToTrace(((LambdaTypeSystemDefinition) runtimeTypeSystem)
				.applyTypeRule(environment, left, right));
	}

}
