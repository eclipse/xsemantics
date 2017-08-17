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

package org.eclipse.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class SubTypeBasicTypeRule extends FJTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.fj.fj.BasicType> var_b1 = new Variable<org.eclipse.xsemantics.example.fj.fj.BasicType>(
			createEClassifierType(basicPackage.getBasicType()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.BasicType> var_b2 = new Variable<org.eclipse.xsemantics.example.fj.fj.BasicType>(
			createEClassifierType(basicPackage.getBasicType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public SubTypeBasicTypeRule() {
		this("SubTypeBasic", "|-", "<:");
	}

	public SubTypeBasicTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.BasicType> getLeft() {
		return var_b1;
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.BasicType> getRight() {
		return var_b2;
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
		return new SubTypeBasicTypeRule("SubTypeBasic", "|-", "<:");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		equals(var_b1.getValue().getBasic(), var_b2.getValue().getBasic());

		// final check for variable initialization

	}

	@Override
	protected String ruleFailureMessage() {
		return stringRep(var_b1.getValue()) + " is not a subtype of "
				+ stringRep(var_b2.getValue());
	}

}
