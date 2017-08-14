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

public class TNewTypeRule extends FJTypeSystemRule {

	protected Variable<java.util.List<org.eclipse.xsemantics.example.fj.fj.Field>> var_fields = new Variable<java.util.List<org.eclipse.xsemantics.example.fj.fj.Field>>(
			createCollectionType(createEClassifierType(basicPackage.getField())));

	protected Variable<Integer> var_i = new Variable<Integer>(
			createBasicType("Integer"));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Type> var_argType = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Type> var_fieldType = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.New> var_e = new Variable<org.eclipse.xsemantics.example.fj.fj.New>(
			createEClassifierType(basicPackage.getNew()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Type> var_t = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TNewTypeRule() {
		this("TNew", "|-", ":");
	}

	public TNewTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.New> getLeft() {
		return var_e;
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.Type> getRight() {
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
		return new TNewTypeRule("TNew", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_fields = new Variable<java.util.List<org.eclipse.xsemantics.example.fj.fj.Field>>(
				createCollectionType(createEClassifierType(basicPackage
						.getField())),
				getAll(var_e.getValue().getType().getClassref(), "members",
						"superclass", org.eclipse.xsemantics.example.fj.fj.Field.class));

		try {
			equals(length(var_e.getValue().getArgs()), length(var_fields));
		} catch (RuleFailedException e) {
			e.setMessage("argument number "
					+ stringRep(length(var_e.getValue().getArgs()))
					+ " is not equal to field number "
					+ stringRep(length(var_fields)));
			throw e;
		}

		register("forall " + stringRep(length(var_e.getValue().getArgs())));
		try {
			for (var_i.setValue(0); var_i.getValue() < length(var_e.getValue()
					.getArgs()); var_i.setValue(var_i.getValue() + 1)) {

				var_argType = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
						createEClassifierType(basicPackage.getType()), null);

				var_fieldType = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
						createEClassifierType(basicPackage.getType()), null);

				applyTypeRule(env_G,
						var_e.getValue().getArgs().get(var_i.getValue()),
						var_argType);

				applyTypeRule(env_G, var_fields.getValue()
						.get(var_i.getValue()), var_fieldType);

				try {
					applySubtypeRule(env_G, var_argType, var_fieldType);
				} catch (RuleFailedException e) {
					e.setMessage("argument type ("
							+ stringRep(var_argType.getValue())
							+ ") is not a subtype of field type ("
							+ stringRep(var_fieldType.getValue()) + ")");
					throw e;
				}
			}
		} catch (Throwable e) {
			registerFailure(e);
			throw new RuleFailedException("failure in checking arguments "
					+ stringRep(var_e.getValue().getArgs()));
		}
		register("end " + "forall "
				+ stringRep(length(var_e.getValue().getArgs())));
		assignment(var_t, var_e.getValue().getType());

		// final check for variable initialization

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
