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

public class StringConstantTypeRule extends FJTypeSystemRule {

	protected Variable<it.xsemantics.example.fj.fj.StringConstant> var_s = new Variable<it.xsemantics.example.fj.fj.StringConstant>(
			createEClassifierType(basicPackage.getStringConstant()));

	protected Variable<it.xsemantics.example.fj.fj.Type> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public StringConstantTypeRule() {
		this("StringConstant", "|-", ":");
	}

	public StringConstantTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.StringConstant> getLeft() {
		return var_s;
	}

	@Override
	public Variable<it.xsemantics.example.fj.fj.Type> getRight() {
		if (right_var == null)
			right_var = new Variable<it.xsemantics.example.fj.fj.Type>(
					createEClassifierType(basicPackage.getType()), null);
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
		return new StringConstantTypeRule("StringConstant", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {
		// axiom

		getRight().setValue(
				castto(featureAssignments(factory.createBasicType(),
						new FeatureAssignmentPair("basic", "String")),
						it.xsemantics.example.fj.fj.Type.class));

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
