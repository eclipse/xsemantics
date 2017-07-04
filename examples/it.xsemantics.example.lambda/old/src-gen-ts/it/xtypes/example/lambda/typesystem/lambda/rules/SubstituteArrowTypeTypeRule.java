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

public class SubstituteArrowTypeTypeRule extends LambdaTypeSystemRule {

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_newLeft = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_newRight = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.lambda.lambda.ArrowType> var_a = new Variable<it.xsemantics.example.lambda.lambda.ArrowType>(
			createEClassifierType(basicPackage.getArrowType()));

	protected Variable<it.xsemantics.example.lambda.lambda.Type> var_result = new Variable<it.xsemantics.example.lambda.lambda.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public SubstituteArrowTypeTypeRule() {
		this("SubstituteArrowType", "|-", "==>");
	}

	public SubstituteArrowTypeTypeRule(String ruleName,
			String typeJudgmentSymbol, String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.ArrowType> getLeft() {
		return var_a;
	}

	@Override
	public Variable<it.xsemantics.example.lambda.lambda.Type> getRight() {
		return var_result;
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
		return new SubstituteArrowTypeTypeRule("SubstituteArrowType", "|-",
				"==>");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_newLeft = new Variable<it.xsemantics.example.lambda.lambda.Type>(
				createEClassifierType(basicPackage.getType()), null);

		var_newRight = new Variable<it.xsemantics.example.lambda.lambda.Type>(
				createEClassifierType(basicPackage.getType()), null);

		applySubstitutionRule(env_G, var_a.getValue().getLeft(), var_newLeft);

		applySubstitutionRule(env_G, var_a.getValue().getRight(), var_newRight);

		var_a.getValue().setLeft(var_newLeft.getValue());

		var_a.getValue().setRight(var_newRight.getValue());

		assignment(var_result, var_a);

		// final check for variable initialization

	}

}
