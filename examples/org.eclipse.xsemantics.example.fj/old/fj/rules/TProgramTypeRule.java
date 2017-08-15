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

public class TProgramTypeRule extends FJTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Type> var_mainType = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Program> var_p = new Variable<org.eclipse.xsemantics.example.fj.fj.Program>(
			createEClassifierType(basicPackage.getProgram()));

	protected Variable<String> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TProgramTypeRule() {
		this("TProgram", "|-", ":");
	}

	public TProgramTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.Program> getLeft() {
		return var_p;
	}

	@Override
	public Variable<String> getRight() {
		if (right_var == null)
			right_var = new Variable<String>(createBasicType("String"), "OK");
		return right_var;
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
		return new TProgramTypeRule("TProgram", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		boolean or_temp_1 = false;
		// first or branch
		try {

			equals(var_p.getValue().getMain(), null);

			or_temp_1 = true;
		} catch (Throwable e) {
			registerFailure(e);
			// go on with other branches
		}

		// last or branch
		if (!or_temp_1) {
			try {
				var_mainType = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
						createEClassifierType(basicPackage.getType()), null);

				applyTypeRule(env_G, var_p.getValue().getMain(), var_mainType);

			} catch (Throwable e) {
				registerFailure(e);
				throw new RuleFailedException("main expression "
						+ stringRep(var_p.getValue().getMain())
						+ " is not welltyped");
			}
		}

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
