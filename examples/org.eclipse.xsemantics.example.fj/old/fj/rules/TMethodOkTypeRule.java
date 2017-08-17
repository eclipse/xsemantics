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

import org.eclipse.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import it.xtypes.runtime.*;

public class TMethodOkTypeRule extends FJTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.fj.fj.ClassType> var_C = new Variable<org.eclipse.xsemantics.example.fj.fj.ClassType>(
			createEClassifierType(basicPackage.getClassType()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Type> var_bodyType = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
			createEClassifierType(basicPackage.getType()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Method> var_inhMethod = new Variable<org.eclipse.xsemantics.example.fj.fj.Method>(
			createEClassifierType(basicPackage.getMethod()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Method> var_otherMethod = new Variable<org.eclipse.xsemantics.example.fj.fj.Method>(
			createEClassifierType(basicPackage.getMethod()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Method> var_m = new Variable<org.eclipse.xsemantics.example.fj.fj.Method>(
			createEClassifierType(basicPackage.getMethod()));

	protected Variable<String> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TMethodOkTypeRule() {
		this("TMethodOk", "|-", ":");
	}

	public TMethodOkTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.Method> getLeft() {
		return var_m;
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
		return new TMethodOkTypeRule("TMethodOk", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		var_C = new Variable<org.eclipse.xsemantics.example.fj.fj.ClassType>(
				createEClassifierType(basicPackage.getClassType()),
				featureAssignments(
						factory.createClassType(),
						new FeatureAssignmentPair("classref", castto(
								container(var_m.getValue()),
								org.eclipse.xsemantics.example.fj.fj.Class.class))));

		register("foreach "
				+ stringRep(getAll(var_C.getValue().getClassref().getSuperclass(),
						"members", "superclass",
						org.eclipse.xsemantics.example.fj.fj.Method.class)));
		try {
			for (org.eclipse.xsemantics.example.fj.fj.Method var_inhMethod_temp : (java.util.List<org.eclipse.xsemantics.example.fj.fj.Method>) getAll(
					var_C.getValue().getClassref().getSuperclass(), "members",
					"superclass", org.eclipse.xsemantics.example.fj.fj.Method.class)) {
				var_inhMethod.setValue(var_inhMethod_temp);
				boolean or_temp_1 = false;
				// first or branch
				try {

					notEquals(var_inhMethod.getValue().getName(), var_m
							.getValue().getName());

					or_temp_1 = true;
				} catch (Throwable e) {
					registerFailure(e);
					// go on with other branches
				}

				// last or branch
				if (!or_temp_1) {
					try {
						applyOverrideRule(env_G, var_m, var_inhMethod);

					} catch (Throwable e) {
						registerAndThrowFailure(e);
					}
				}

			}
		} catch (Throwable e) {
			registerAndThrowFailure(e);
		}
		register("end "
				+ "foreach "
				+ stringRep(getAll(var_C.getValue().getClassref().getSuperclass(),
						"members", "superclass",
						org.eclipse.xsemantics.example.fj.fj.Method.class)));
		register("!exists "
				+ stringRep(FjAuxiliaryFunctions.selectMethods(var_C.getValue().getClassref())));
		try {
			boolean not_exist_temp_2 = true;
			try {
				for (java.util.Iterator<org.eclipse.xsemantics.example.fj.fj.Method> iterator = FjAuxiliaryFunctions.selectMethods(var_C
						.getValue().getClassref()).iterator(); iterator
						.hasNext();) {
					var_otherMethod.setValue(iterator.next());
					try {

						equals(var_otherMethod.getValue().getName(), var_m
								.getValue().getName());

						notEquals(var_otherMethod, var_m);

						not_exist_temp_2 = false;
						break;
					} catch (Throwable e) {
						registerFailure(e);
						if (!iterator.hasNext())
							throw new RuleFailedException("exists failed", e);
					}
				} // if we're here exists succeeded, thus !exist failed
			} catch (RuleFailedException e) {
				// OK
				not_exist_temp_2 = true;
			}
			if (!not_exist_temp_2)
				throw new RuleFailedException("not exists failed");
		} catch (Throwable e) {
			registerFailure(e);
			throw new RuleFailedException("duplicate method in the same class");
		}
		register("end " + "!exists "
				+ stringRep(FjAuxiliaryFunctions.selectMethods(var_C.getValue().getClassref())));
		var_bodyType = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
				createEClassifierType(basicPackage.getType()), null);

		applyTypeRule(
				union(env_G,
						newRuntimeEnvironmentEntry("this", var_C.getValue())),
				var_m.getValue().getBody().getExpression(), var_bodyType);

		try {
			applySubtypeRule(env_G, var_bodyType, var_m.getValue()
					.getType());
		} catch (RuleFailedException e) {
			e.setMessage("body type '" + stringRep(var_bodyType.getValue())
					+ "' is not a subtype of " + "return type '"
					+ stringRep(var_m.getValue().getType()) + "'");
			throw e;
		}

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
