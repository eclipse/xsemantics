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

package it.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class TMethodBodyTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.MethodBody> var_m = new Variable<it.xsemantics.example.fj.fj.MethodBody>(
			createEClassifierType(basicPackage.getMethodBody()));

	protected Variable<it.xsemantics.example.fj.fj.Type> var_t = new Variable<it.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TMethodBodyTypeRule() {
		this("TMethodBody", "|-", ":");
	}

	public TMethodBodyTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.MethodBody> getLeft() {
		return var_m;
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Type> getRight() {
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
		return new TMethodBodyTypeRule("TMethodBody", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		applyTypeRule(env_G, var_m.getValue().getExpression(), var_t);

		// final check for variable initialization

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
