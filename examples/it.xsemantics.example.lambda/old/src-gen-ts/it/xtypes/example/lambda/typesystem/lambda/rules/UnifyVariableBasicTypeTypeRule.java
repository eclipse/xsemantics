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

public class UnifyVariableBasicTypeTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.TypeVariable> var_v1 = new Variable<it.xsemantics.example.lambda.lambda.TypeVariable>(
			createEClassifierType(basicPackage.getTypeVariable()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_t1 = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.BasicType> var_b = new Variable<it.xsemantics.example.lambda.lambda.BasicType>(
			createEClassifierType(basicPackage.getBasicType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public UnifyVariableBasicTypeTypeRule() {
		this("UnifyVariableBasicType", "|-", "==");
	}

	public UnifyVariableBasicTypeTypeRule(String ruleName,
			String typeJudgmentSymbol, String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Type> getLeft() {
		return var_t1;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.BasicType> getRight() {
		return var_b;
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
		return new UnifyVariableBasicTypeTypeRule("UnifyVariableBasicType",
				"|-", "==");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_v1 = new Variable<it.xsemantics.example.lambda.lambda.TypeVariable>(
				createEClassifierType(basicPackage.getTypeVariable()), castto(
						var_t1.getValue(),
						it.xsemantics.example.lambda.lambda.TypeVariable.class));

		applyMappingRule(env_G, var_v1, var_b);

		// final check for variable initialization

	}

}
