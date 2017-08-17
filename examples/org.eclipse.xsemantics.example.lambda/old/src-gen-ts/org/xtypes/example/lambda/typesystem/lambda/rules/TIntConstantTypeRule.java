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

public class TIntConstantTypeRule extends LambdaTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.lambda.lambda.IntConstant> var_i = new Variable<org.eclipse.xsemantics.example.lambda.lambda.IntConstant>(
			createEClassifierType(basicPackage.getIntConstant()));

	protected Variable<org.eclipse.xsemantics.example.lambda.lambda.Type> var_t = new Variable<org.eclipse.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TIntConstantTypeRule() {
		this("TIntConstant", "|-", ":");
	}

	public TIntConstantTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.lambda.lambda.IntConstant> getLeft() {
		return var_i;
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.lambda.lambda.Type> getRight() {
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
		return new TIntConstantTypeRule("TIntConstant", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		assignment(var_t, featureAssignments(factory.createIntType()));

		// final check for variable initialization

	}

}
