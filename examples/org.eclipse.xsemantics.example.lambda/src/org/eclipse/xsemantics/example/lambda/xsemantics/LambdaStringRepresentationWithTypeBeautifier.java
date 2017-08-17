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

package org.eclipse.xsemantics.example.lambda.xsemantics;

import com.google.inject.Inject;
import com.google.inject.Provider;

import org.eclipse.xsemantics.example.lambda.lambda.ArrowType;
import org.eclipse.xsemantics.example.lambda.lambda.Type;

public class LambdaStringRepresentationWithTypeBeautifier extends
		LambdaStringRepresentation {

	@Inject
	protected Provider<LambdaTypeBeautifier> lambdaTypeBeautifierProvider;

	@Override
	protected String stringRep(ArrowType arrowType) {
		return getBeautifiedType(arrowType);
	}

	protected String stringRep(Type type) {
		return getBeautifiedType(type);
	}

	protected String getBeautifiedType(Type type) {
		return lambdaTypeBeautifierProvider.get().getBeautifiedString(type);
	}
}
