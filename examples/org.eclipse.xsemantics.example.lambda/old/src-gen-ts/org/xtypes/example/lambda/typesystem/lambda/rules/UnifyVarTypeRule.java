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

public class UnifyVarTypeRule extends LambdaTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.lambda.lambda.TypeVariable> var_v1 = new Variable<org.eclipse.xsemantics.example.lambda.lambda.TypeVariable>(
			createEClassifierType(basicPackage.getTypeVariable()));

	protected Variable<org.eclipse.xsemantics.example.lambda.lambda.TypeVariable> var_v2 = new Variable<org.eclipse.xsemantics.example.lambda.lambda.TypeVariable>(
			createEClassifierType(basicPackage.getTypeVariable()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public UnifyVarTypeRule() {
		this("UnifyVar", "|-", "==");
	}

	public UnifyVarTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.lambda.lambda.TypeVariable> getLeft() {
		return var_v1;
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.lambda.lambda.TypeVariable> getRight() {
		return var_v2;
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
		return new UnifyVarTypeRule("UnifyVar", "|-", "==");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		boolean or_temp_1 = false;
		// first or branch
		try {

			equals(var_v1.getValue().getTypevarName(), var_v2.getValue()
					.getTypevarName());

			or_temp_1 = true;
		} catch (Throwable e) {
			registerFailure(e);
			// go on with other branches
		}

		// last or branch
		if (!or_temp_1) {
			try {
				applyMappingRule(env_G, var_v1, var_v2);

			} catch (Throwable e) {
				registerAndThrowFailure(e);
			}
		}

		// final check for variable initialization

	}

}
