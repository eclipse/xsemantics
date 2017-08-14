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

package org.eclipse.xsemantics.example.lambda.typesystem.lambda.rules;

import it.xtypes.runtime.*;

public class NotOccurVarInArrowTypeRule extends LambdaTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.lambda.lambda.TypeVariable> var_t1 = new Variable<org.eclipse.xsemantics.example.lambda.lambda.TypeVariable>(
			createEClassifierType(basicPackage.getTypeVariable()));

	protected Variable<org.eclipse.xsemantics.example.lambda.lambda.ArrowType> var_t2 = new Variable<org.eclipse.xsemantics.example.lambda.lambda.ArrowType>(
			createEClassifierType(basicPackage.getArrowType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public NotOccurVarInArrowTypeRule() {
		this("NotOccurVarInArrow", "|-", "!-");
	}

	public NotOccurVarInArrowTypeRule(String ruleName,
			String typeJudgmentSymbol, String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.lambda.lambda.TypeVariable> getLeft() {
		return var_t1;
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.lambda.lambda.ArrowType> getRight() {
		return var_t2;
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
		return new NotOccurVarInArrowTypeRule("NotOccurVarInArrow", "|-", "!-");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		applyNotoccurRule(env_G, var_t1, var_t2.getValue().getLeft());

		applyNotoccurRule(env_G, var_t1, var_t2.getValue().getRight());

		// final check for variable initialization

	}

	@Override
	protected String ruleFailureMessage() {
		return "type variable " + stringRep(var_t1.getValue().getTypevarName())
				+ " occurs in (" + stringRep(var_t2.getValue().getLeft())
				+ ") -> (" + stringRep(var_t2.getValue().getRight()) + ")";
	}

}
