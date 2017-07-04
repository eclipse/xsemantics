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

public class TVariableTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.Variable> var_v = new Variable<it.xsemantics.example.lambda.lambda.Variable>(
			createEClassifierType(basicPackage.getVariable()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TVariableTypeRule() {
		this("TVariable", "|-", ":");
	}

	public TVariableTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Variable> getLeft() {
		return var_v;
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
		return new TVariableTypeRule("TVariable", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		assignment(
				var_t,
				castto(env(env_G, var_v.getValue().getRef()),
						it.xsemantics.example.lambda.lambda.Type.class));

		applySubstitutionRule(env_G, var_t, var_t);

		// final check for variable initialization

	}

}
