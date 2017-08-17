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
package org.eclipse.xsemantics.example.fj.typing;

import com.google.inject.Inject;

import org.eclipse.xsemantics.example.fj.typesystem.fj.FJTypeSystemDefinition;
import it.xtypes.runtime.TypeSystemResult;

import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.Type;

/**
 * This class is superseded by the generated type system FjTypeSystemDefinition,
 * it is here only as a wrapper for FjTypeSystemDefinition, for old unit tests
 * 
 * @author Lorenzo Bettini
 * 
 */
public class FJSubtyping {
	@Inject
	FJTypeSystemDefinition typeSystem;

	public boolean isSubtype(Type t1, Type t2) {
		return isResultTrue(typeSystem.checkSubtype(t1, t2));
	}

	public boolean isSubtype(Class c1, Class c2) {
		return isResultTrue(typeSystem.checkSubtype(c1, c2));
	}

	protected boolean isResultTrue(TypeSystemResult<Boolean> result) {
		return result.getValue() != null && result.getValue();
	}

}
