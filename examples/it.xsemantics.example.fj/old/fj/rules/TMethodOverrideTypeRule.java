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

public class TMethodOverrideTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.Method> var_m1 = new Variable<it.xsemantics.example.fj.fj.Method>(
			createEClassifierType(basicPackage.getMethod()));

	protected Variable<it.xsemantics.example.fj.fj.Method> var_m2 = new Variable<it.xsemantics.example.fj.fj.Method>(
			createEClassifierType(basicPackage.getMethod()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TMethodOverrideTypeRule() {
		this("TMethodOverride", "|-", "~");
	}

	public TMethodOverrideTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Method> getLeft() {
		return var_m1;
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Method> getRight() {
		return var_m2;
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
		return new TMethodOverrideTypeRule("TMethodOverride", "|-", "~");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		applyRule(env_G, "|-", "==", var_m1.getValue().getParams(), var_m2
				.getValue().getParams());

		applyRule(env_G, "|-", "==", var_m1.getValue().getType(), var_m2
				.getValue().getType());

		// final check for variable initialization

	}

}
