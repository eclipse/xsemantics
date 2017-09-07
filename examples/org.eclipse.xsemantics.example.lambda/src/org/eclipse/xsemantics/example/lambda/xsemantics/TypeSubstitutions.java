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

import org.eclipse.xsemantics.example.lambda.lambda.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author bettini
 * 
 */
public class TypeSubstitutions {

	protected Map<String, Type> substitutions = new HashMap<String, Type>();

	public void reset() {
		substitutions.clear();
	}

	public void add(String typeVariableName, Type mapped) {
		substitutions.put(typeVariableName, mapped);
	}

	public Type mapped(String typeVariableName) {
		return substitutions.get(typeVariableName);
	}

	public Set<Entry<String, Type>> getSubstitutions() {
		return substitutions.entrySet();
	}

}
