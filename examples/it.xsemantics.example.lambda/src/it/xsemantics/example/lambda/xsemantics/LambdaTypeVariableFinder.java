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

import it.xsemantics.example.lambda.lambda.TypeVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

/**
 * @author Lorenzo Bettini
 * 
 */
public class LambdaTypeVariableFinder {

	public List<TypeVariable> findTypeVariables(EObject term) {
		return EcoreUtil2.getAllContentsOfType(term, TypeVariable.class);
	}

	public Set<String> getTypeVariableNames(EObject term) {
		Set<String> typeVariableNames = new HashSet<String>();
		List<TypeVariable> typeVariables = findTypeVariables(term);
		for (TypeVariable typeVariable : typeVariables) {
			typeVariableNames.add(typeVariable.getTypevarName());
		}
		return typeVariableNames;
	}
}
