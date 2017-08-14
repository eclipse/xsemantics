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
package org.eclipse.xsemantics.example.lambda.xsemantics;

import org.eclipse.xsemantics.example.lambda.lambda.ArrowType;
import org.eclipse.xsemantics.example.lambda.lambda.IntType;
import org.eclipse.xsemantics.example.lambda.lambda.LambdaFactory;
import org.eclipse.xsemantics.example.lambda.lambda.StringType;
import org.eclipse.xsemantics.example.lambda.lambda.Type;
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable;

/**
 * @author bettini
 * 
 */
public class LambdaUtils {

	protected int counter = 0;

	public void resetCounter() {
		counter = 0;
	}

	public TypeVariable createTypeVariable(String name) {
		TypeVariable typeVariable = LambdaFactory.eINSTANCE
				.createTypeVariable();
		typeVariable.setTypevarName(name);
		return typeVariable;
	}

	public TypeVariable createFreshTypeVariable() {
		return createTypeVariable("X" + ++counter);
	}

	public ArrowType createFreshArrowType() {
		return createArrowType(createFreshTypeVariable(),
				createFreshTypeVariable());
	}

	public ArrowType createArrowType(Type left, Type right) {
		ArrowType arrowType = LambdaFactory.eINSTANCE.createArrowType();
		arrowType.setLeft(left);
		arrowType.setRight(right);
		return arrowType;
	}

	public StringType createStringType() {
		return LambdaFactory.eINSTANCE.createStringType();
	}

	public IntType createIntType() {
		return LambdaFactory.eINSTANCE.createIntType();
	}
}
