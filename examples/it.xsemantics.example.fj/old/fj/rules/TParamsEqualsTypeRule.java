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

public class TParamsEqualsTypeRule extends FJTypeSystemRule {

	protected Variable<Integer> var_i = new Variable<Integer>(
			createBasicType("Integer"));

	protected Variable<java.util.List<it.xsemantics.example.fj.fj.Parameter>> var_params1 = new Variable<java.util.List<it.xsemantics.example.fj.fj.Parameter>>(
			createCollectionType(createEClassifierType(basicPackage
					.getParameter())));

	protected Variable<java.util.List<it.xsemantics.example.fj.fj.Parameter>> var_params2 = new Variable<java.util.List<it.xsemantics.example.fj.fj.Parameter>>(
			createCollectionType(createEClassifierType(basicPackage
					.getParameter())));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TParamsEqualsTypeRule() {
		this("TParamsEquals", "|-", "==");
	}

	public TParamsEqualsTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<java.util.List<it.xsemantics.example.fj.fj.Parameter>> getLeft() {
		return var_params1;
	}

	@Override
	public Variable<java.util.List<it.xsemantics.example.fj.fj.Parameter>> getRight() {
		return var_params2;
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
		return new TParamsEqualsTypeRule("TParamsEquals", "|-", "==");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		equals(length(var_params1), length(var_params2));

		register("forall " + stringRep(length(var_params1)));
		try {
			for (var_i.setValue(0); var_i.getValue() < length(var_params1); var_i
					.setValue(var_i.getValue() + 1)) {
				applyRule(env_G, "|-", "==",
						var_params1.getValue().get(var_i.getValue()).getType(),
						var_params2.getValue().get(var_i.getValue()).getType());

			}
		} catch (Throwable e) {
			registerAndThrowFailure(e);
		}
		register("end " + "forall " + stringRep(length(var_params1)));

		// final check for variable initialization

	}

}
