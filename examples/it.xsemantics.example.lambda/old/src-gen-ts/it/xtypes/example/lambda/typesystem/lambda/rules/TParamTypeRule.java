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

public class TParamTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.Parameter> var_p = new Variable<it.xsemantics.example.lambda.lambda.Parameter>(
			createEClassifierType(basicPackage.getParameter()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TParamTypeRule() {
		this("TParam", "|-", ":");
	}

	public TParamTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Parameter> getLeft() {
		return var_p;
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
		return new TParamTypeRule("TParam", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		boolean or_temp_1 = false;
		// first or branch
		try {

			notEquals(var_p.getValue().getType(), null);

			assignment(var_t, var_p.getValue().getType());

			or_temp_1 = true;
		} catch (Throwable e) {
			registerFailure(e);
			// go on with other branches
		}

		// last or branch
		if (!or_temp_1) {
			try {
				assignment(
						var_t,
						featureAssignments(factory.createTypeVariable(),
								new FeatureAssignmentPair("typevarName",
										newName("X"))));

			} catch (Throwable e) {
				registerAndThrowFailure(e);
			}
		}

		// final check for variable initialization

	}

}
