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

import it.xtypes.runtime.*;

public class NotOccurVarTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.TypeVariable> var_t1 = new Variable<it.xsemantics.example.lambda.lambda.TypeVariable>(
			createEClassifierType(basicPackage.getTypeVariable()));

	protected Variable<it.xsemantics.example.lambda.lambda.TypeVariable> var_t2 = new Variable<it.xsemantics.example.lambda.lambda.TypeVariable>(
			createEClassifierType(basicPackage.getTypeVariable()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public NotOccurVarTypeRule() {
		this("NotOccurVar", "|-", "!-");
	}

	public NotOccurVarTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.TypeVariable> getLeft() {
		return var_t1;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.TypeVariable> getRight() {
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
		return new NotOccurVarTypeRule("NotOccurVar", "|-", "!-");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		notEquals(var_t1.getValue().getTypevarName(), var_t2.getValue()
				.getTypevarName());

		// final check for variable initialization

	}

}
