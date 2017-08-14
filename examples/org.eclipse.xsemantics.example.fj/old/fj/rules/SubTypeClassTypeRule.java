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

public class SubTypeClassTypeRule extends FJTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.fj.fj.ClassType> var_c1 = new Variable<org.eclipse.xsemantics.example.fj.fj.ClassType>(
			createEClassifierType(basicPackage.getClassType()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.ClassType> var_c2 = new Variable<org.eclipse.xsemantics.example.fj.fj.ClassType>(
			createEClassifierType(basicPackage.getClassType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public SubTypeClassTypeRule() {
		this("SubTypeClass", "|-", "<:");
	}

	public SubTypeClassTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.ClassType> getLeft() {
		return var_c1;
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.ClassType> getRight() {
		return var_c2;
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
		return new SubTypeClassTypeRule("SubTypeClass", "|-", "<:");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		applySubtypeRule(env_G, var_c1.getValue().getClassref(), var_c2
				.getValue().getClassref());

		// final check for variable initialization

	}

}
