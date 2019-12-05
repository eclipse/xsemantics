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

package org.eclipse.xsemantics.example.lambda.tests;

import org.junit.Before;
import org.junit.Test;

import org.eclipse.xsemantics.example.lambda.lambda.ArrowType;
import org.eclipse.xsemantics.example.lambda.lambda.BasicType;
import org.eclipse.xsemantics.example.lambda.lambda.LambdaFactory;
import org.eclipse.xsemantics.example.lambda.lambda.Type;
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable;
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaTypeBeautifier;

import static org.eclipse.xsemantics.example.lambda.tests.util.LambdaTestsUtil.*;
import static org.junit.Assert.*;

public class LambdaTypeBeautifierTest {
	LambdaTypeBeautifier lambdaTypeBeautifier;

	@Before
	public void setUp() throws Exception {
		lambdaTypeBeautifier = new LambdaTypeBeautifier();
	}

	@Test
	public void testGetBeautifiedStringIntType() {
		BasicType type = LambdaFactory.eINSTANCE.createIntType();

		String s;

		s = lambdaTypeBeautifier.getBeautifiedString(type);
		assertEquals("int", s);
	}
	
	@Test
	public void testGetBeautifiedStringStringType() {
		BasicType type = LambdaFactory.eINSTANCE.createStringType();

		String s;

		s = lambdaTypeBeautifier.getBeautifiedString(type);
		assertEquals("string", s);
	}

	@Test
	public void testGetBeautifiedStringTypeVariable() {
		TypeVariable typeVariable1 = createTypeVariable("X1");
		TypeVariable typeVariable2 = createTypeVariable("X2");

		String s;

		s = lambdaTypeBeautifier.getBeautifiedString(typeVariable1);
		assertEquals("a", s);
		s = lambdaTypeBeautifier.getBeautifiedString(typeVariable2);
		assertEquals("b", s);
		s = lambdaTypeBeautifier.getBeautifiedString(typeVariable1);
		assertEquals("a", s);
	}

	@Test
	public void testGetBeautifiedStringArrowType() {
		ArrowType arrowType = createArrowType(
				createTypeVariable("X1"),
				createArrowType(createTypeVariable("X2"),
						createTypeVariable("X1")));
		String s;
		s = lambdaTypeBeautifier.getBeautifiedString(arrowType);
		assertEquals("a -> b -> a", s);
	}

	@Test
	public void testGetBeautifiedStringArrowType2() {
		ArrowType arrowType = createArrowType(
				createArrowType(createTypeVariable("X2"),
						createTypeVariable("X1")), createTypeVariable("X2"));
		String s;
		s = lambdaTypeBeautifier.getBeautifiedString(arrowType);
		assertEquals("(a -> b) -> a", s);
	}

	@Test
	public void testGetBeautifiedStringArrowType3() {
		ArrowType arrowType = createArrowType(
				createArrowType(createTypeVariable("X2"),
						createTypeVariable("X1")),
				createArrowType(createTypeVariable("X2"),
						createTypeVariable("X3")));
		String s;
		s = lambdaTypeBeautifier.getBeautifiedString(arrowType);
		assertEquals("(a -> b) -> a -> c", s);
	}

	@Test
	public void testBeautifyIntType() {
		BasicType type = LambdaFactory.eINSTANCE.createIntType();

		lambdaTypeBeautifier.beautifyTypeVariables(type);
	}

	@Test
	public void testBeautifyTypeVariable() {
		TypeVariable type = createTypeVariable("X1");

		lambdaTypeBeautifier.beautifyTypeVariables(type);
		assertEquals("a", type.getTypevarName());
	}

	@Test
	public void testBeautifyArrowType() {
		ArrowType arrowType = createArrowType(createTypeVariable("X2"),
				createTypeVariable("X1"));
		lambdaTypeBeautifier.beautifyTypeVariables(arrowType);
		assertEquals("a", getTypeVariable(arrowType.getLeft()).getTypevarName());
		assertEquals("b", getTypeVariable(arrowType.getRight())
				.getTypevarName());
	}

	@Test
	public void testBeautifyArrowTypeAlreadyBeautified() {
		ArrowType arrowType = createArrowType(createTypeVariable("b"),
				createTypeVariable("a"));
		lambdaTypeBeautifier.beautifyTypeVariables(arrowType);
		assertEquals("b", getTypeVariable(arrowType.getLeft()).getTypevarName());
		assertEquals("a", getTypeVariable(arrowType.getRight())
				.getTypevarName());
	}

	@Test
	public void testBeautifyArrowTypeWithExistingTypeVariables() {
		ArrowType arrowType = createArrowType(createTypeVariable("a"),
				createTypeVariable("X1"));
		lambdaTypeBeautifier.beautifyTypeVariables(arrowType);
		assertEquals("a", getTypeVariable(arrowType.getLeft()).getTypevarName());
		assertEquals("b", getTypeVariable(arrowType.getRight())
				.getTypevarName());
	}

	private TypeVariable createTypeVariable(String name) {
		TypeVariable typeVariable = LambdaFactory.eINSTANCE
				.createTypeVariable();
		typeVariable.setTypevarName(name);
		return typeVariable;
	}

	private ArrowType createArrowType(Type left, Type right) {
		ArrowType arrowType = LambdaFactory.eINSTANCE.createArrowType();
		arrowType.setLeft(left);
		arrowType.setRight(right);
		return arrowType;
	}
}
