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

public class TSelectionTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.Type> var_receiverType = new Variable<it.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<it.xsemantics.example.fj.fj.Selection> var_e = new Variable<it.xsemantics.example.fj.fj.Selection>(
			createEClassifierType(basicPackage.getSelection()));

	protected Variable<it.xsemantics.example.fj.fj.Type> var_t = new Variable<it.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TSelectionTypeRule() {
		this("TSelection", "|-", ":");
	}

	public TSelectionTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Selection> getLeft() {
		return var_e;
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
		return new TSelectionTypeRule("TSelection", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_receiverType = new Variable<it.xsemantics.example.fj.fj.Type>(
				createEClassifierType(basicPackage.getType()), null);

		applyTypeRule(env_G, var_e.getValue().getReceiver(), var_receiverType);

		applyTypeRule(env_G, var_e.getValue().getMessage(), var_t);

		// final check for variable initialization

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
