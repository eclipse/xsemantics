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

public class TClassOkTypeRule extends FJTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Class> var_programClass = new Variable<org.eclipse.xsemantics.example.fj.fj.Class>(
			createEClassifierType(basicPackage.getClass_()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Class> var_C = new Variable<org.eclipse.xsemantics.example.fj.fj.Class>(
			createEClassifierType(basicPackage.getClass_()));

	protected Variable<String> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TClassOkTypeRule() {
		this("TClassOk", "|-", ":");
	}

	public TClassOkTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.Class> getLeft() {
		return var_C;
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
		return new TClassOkTypeRule("TClassOk", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		register("!exists "
				+ stringRep(getAll(var_C.getValue(), "superclass", "superclass",
						org.eclipse.xsemantics.example.fj.fj.Class.class)));
		try {
			boolean not_exist_temp_1 = true;
			try {
				for (java.util.Iterator<org.eclipse.xsemantics.example.fj.fj.Class> iterator = getAll(
						var_C.getValue(), "superclass", "superclass",
						org.eclipse.xsemantics.example.fj.fj.Class.class).iterator(); iterator
						.hasNext();) {
					var_programClass.setValue(iterator.next());
					try {

						equals(var_programClass.getValue().getName(), var_C
								.getValue().getName());

						not_exist_temp_1 = false;
						break;
					} catch (Throwable e) {
						registerFailure(e);
						if (!iterator.hasNext())
							throw new RuleFailedException("exists failed", e);
					}
				} // if we're here exists succeeded, thus !exist failed
			} catch (RuleFailedException e) {
				// OK
				not_exist_temp_1 = true;
			}
			if (!not_exist_temp_1)
				throw new RuleFailedException("not exists failed");
		} catch (Throwable e) {
			registerAndThrowFailure(e);
		}
		register("end "
				+ "!exists "
				+ stringRep(getAll(var_C.getValue(), "superclass", "superclass",
						org.eclipse.xsemantics.example.fj.fj.Class.class)));

	}

	@Override
	protected String ruleFailureMessage() {
		return "class hierarchy is not acyclic for "
				+ stringRep(var_C.getValue());
	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
