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
import org.eclipse.xsemantics.example.lambda.lambda.StringType;
import org.eclipse.xsemantics.example.lambda.lambda.Type;
import org.eclipse.xsemantics.example.lambda.lambda.TypeVariable;
import org.eclipse.xsemantics.example.lambda.xsemantics.LambdaStringRepresentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * For each Type to beautify, a new instance of this class must be used.
 * 
 * @author Lorenzo Bettini
 * 
 */
public class LambdaTypeBeautifier {

	private int currentChar = 97; // 'a'

	private int endChar = 122; // 'z'

	private Map<String, String> seenTypeVariableNames = new HashMap<String, String>();

	private LambdaStringRepresentation lambdaStringRepresentation = new LambdaStringRepresentation();

	private Set<String> existingTypeVariableNames = null;

	private LambdaTypeVariableFinder typeVariableFinder = new LambdaTypeVariableFinder();

	private PolymorphicDispatcher<String> getBeautifiedStringDispatcher = PolymorphicDispatcher
			.createForSingleTarget("getBeautifyStringImpl", this);

	private PolymorphicDispatcher<Void> beautifyTypeVariableDispatcher = PolymorphicDispatcher
			.createForSingleTarget("beautifyTypeVariableImpl", this);

	protected void initBeautifier(Type type) {
		if (existingTypeVariableNames == null)
			existingTypeVariableNames = typeVariableFinder
					.getTypeVariableNames(type);
	}

	public void beautifyTypeVariables(Type type) {
		initBeautifier(type);
		beautifyTypeVariableDispatcher.invoke(type);
	}

	protected void beautifyTypeVariableImpl(Type type) {

	}

	protected void beautifyTypeVariableImpl(ArrowType arrowType) {
		beautifyTypeVariables(arrowType.getLeft());
		beautifyTypeVariables(arrowType.getRight());
	}

	protected void beautifyTypeVariableImpl(TypeVariable typeVariable) {
		typeVariable.setTypevarName(getBeautifyStringImpl(typeVariable));
	}

	public String getBeautifiedString(Type type) {
		if (type == null)
			return "";
		initBeautifier(type);
		return getBeautifiedStringDispatcher.invoke(type);
	}

	protected String getBeautifyStringImpl(Type type) {
		return lambdaStringRepresentation.string(type);
	}

	protected String getBeautifyStringImpl(IntType intType) {
		return "int";
	}

	protected String getBeautifyStringImpl(StringType stringType) {
		return "string";
	}

	protected String getBeautifyStringImpl(TypeVariable typeVariable) {
		String name = typeVariable.getTypevarName();
		String existing = seenTypeVariableNames.get(name);
		if (existing != null)
			return existing;

		String beautifiedName = buildBeautifiedTypeVariableName(name);

		seenTypeVariableNames.put(name, beautifiedName);

		return beautifiedName;
	}

	protected String buildBeautifiedTypeVariableName(String name) {
		if (currentChar > endChar || !isToBeautify(name))
			return name;

		String beautifiedName = (char) currentChar++ + "";

		// make sure we don't use a type variable name which
		// already existed in the original type
		while (currentChar <= endChar
				&& existingTypeVariableNames.contains(beautifiedName)) {
			beautifiedName = (char) currentChar++ + "";
		}

		if (existingTypeVariableNames.contains(beautifiedName))
			return name;

		return beautifiedName;
	}

	protected boolean isToBeautify(String name) {
		return name.startsWith("X");
	}

	protected String getBeautifyStringImpl(ArrowType arrowType) {
		Type left = arrowType.getLeft();

		// arrow types associate to the right
		// so use ( ) for a possible recursive left arrow type
		String leftString = getBeautifiedString(left);
		if (left instanceof ArrowType) {
			leftString = "(" + leftString + ")";
		}

		return leftString + " -> " + getBeautifiedString(arrowType.getRight());
	}
}
