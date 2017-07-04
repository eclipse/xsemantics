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

/**
 * 
 */
package it.xsemantics.example.lambda.xsemantics;

import it.xsemantics.example.lambda.lambda.Abstraction;
import it.xsemantics.example.lambda.lambda.ArrowType;
import it.xsemantics.example.lambda.lambda.Parameter;
import it.xsemantics.example.lambda.lambda.Term;
import it.xsemantics.example.lambda.lambda.Type;
import it.xsemantics.example.lambda.xsemantics.LambdaXsemanticsSystem;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleFailedException;

import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Lorenzo Bettini
 * 
 */
public class LambdaTypeModifier {

	@Inject
	protected LambdaXsemanticsSystem typeSystem;

	@Inject
	protected Provider<LambdaTypeBeautifier> lambdaTypeBeautifierProvider;

	private PolymorphicDispatcher<Void> setTypesDispatcher = PolymorphicDispatcher
			.createForSingleTarget("setAllTypesImpl", 2, 2, this);

	public RuleFailedException modifyAbstractionParamType(
			Abstraction abstraction) {
		Parameter param = abstraction.getParam();
		Type typeWrittenByProgrammer = param.getType();
		param.setType(null);
		RuleFailedException failure = setAbstractionParamType(abstraction);

		if (failure != null) {
			param.setType(typeWrittenByProgrammer);
		}

		return failure;
	}

	public RuleFailedException setAbstractionParamType(Abstraction abstraction) {
		Result<Type> result = typeSystem.type(new TypeSubstitutions(),
				abstraction);
		if (result.getRuleFailedException() != null)
			return result.getRuleFailedException();
		updateParameterType(abstraction.getParam(), result.getValue());
		return null;
	}

	protected void updateParameterType(Parameter parameter, Type type) {
		if (type instanceof ArrowType) {
			ArrowType arrowType = (ArrowType) type;
			Type paramType = arrowType.getLeft();
			beautifyType(paramType);
			parameter.setType(paramType);
		}
	}

	public RuleFailedException setAllTypes(Term term) {
		Result<Type> result = typeSystem.type(new TypeSubstitutions(),
				LambdaTermUtils.cloneWithoutTypes(term));
		if (result.getRuleFailedException() != null)
			return result.getRuleFailedException();
		Type inferredType = result.getValue();
		beautifyType(inferredType);
		setAllTypes(term, inferredType);
		return null;
	}

	protected void beautifyType(Type paramType) {
		lambdaTypeBeautifierProvider.get().beautifyTypeVariables(paramType);
	}

	protected void setAllTypes(Term term, Type type) {
		setTypesDispatcher.invoke(term, type);
	}

	protected void setAllTypesImpl(Term term, Type type) {

	}

	protected void setAllTypesImpl(Abstraction abstraction, ArrowType arrowType) {
		abstraction.getParam().setType(arrowType.getLeft());
		setAllTypes(abstraction.getTerm(), arrowType.getRight());
	}
}
