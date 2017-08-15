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

public class UnifyIntTypeTypeRule extends LambdaTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.lambda.lambda.IntType> var_i1 = new Variable<org.eclipse.xsemantics.example.lambda.lambda.IntType>(
			createEClassifierType(basicPackage.getIntType()));

	protected Variable<org.eclipse.xsemantics.example.lambda.lambda.IntType> var_i2 = new Variable<org.eclipse.xsemantics.example.lambda.lambda.IntType>(
			createEClassifierType(basicPackage.getIntType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public UnifyIntTypeTypeRule() {
		this("UnifyIntType", "|-", "==");
	}

	public UnifyIntTypeTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.lambda.lambda.IntType> getLeft() {
		return var_i1;
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.lambda.lambda.IntType> getRight() {
		return var_i2;
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
		return new UnifyIntTypeTypeRule("UnifyIntType", "|-", "==");
	}

	@Override
	public void applyImpl() throws RuleFailedException {
		// axiom

		// final check for variable initialization

	}

}
