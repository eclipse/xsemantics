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

public class SubClassTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.Class> var_C1 = new Variable<it.xsemantics.example.fj.fj.Class>(
			createEClassifierType(basicPackage.getClass_()));

	protected Variable<it.xsemantics.example.fj.fj.Class> var_C2 = new Variable<it.xsemantics.example.fj.fj.Class>(
			createEClassifierType(basicPackage.getClass_()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public SubClassTypeRule() {
		this("SubClass", "|-", "<:");
	}

	public SubClassTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Class> getLeft() {
		return var_C1;
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Class> getRight() {
		return var_C2;
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
		return new SubClassTypeRule("SubClass", "|-", "<:");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		boolean or_temp_1 = false;
		// first or branch
		try {

			equals(var_C2.getValue().getName(), "Object");

			or_temp_1 = true;
		} catch (Throwable e) {
			registerFailure(e);
			// go on with other branches
		}

		try {
			if (!or_temp_1) {

				equals(var_C1, var_C2);

				or_temp_1 = true;
			}
		} catch (Throwable e) {
			registerFailure(e);
			// go on with other branches
		}

		// last or branch
		if (!or_temp_1) {
			try {
				applySubtypeRule(env_G, var_C1.getValue().getSuperclass(), var_C2);

			} catch (Throwable e) {
				registerAndThrowFailure(e);
			}
		}

		// final check for variable initialization

	}

	@Override
	protected String ruleFailureMessage() {
		return stringRep(var_C1.getValue()) + " is not a subclass of "
				+ stringRep(var_C2.getValue());
	}

}
