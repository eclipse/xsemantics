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

import org.eclipse.xsemantics.example.fj.typesystem.fj.FJTypeSystemDefinition;
import org.eclipse.xsemantics.example.fj.util.ContainingClassFinder;
import it.xtypes.runtime.TypeSystemResult;
import it.xtypes.runtime.TypingJudgmentEnvironment;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;

import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.Expression;
import org.eclipse.xsemantics.example.fj.fj.Field;
import org.eclipse.xsemantics.example.fj.fj.Method;
import org.eclipse.xsemantics.example.fj.fj.Program;
import org.eclipse.xsemantics.example.fj.fj.util.FjSwitch;

/**
 * This class is superseded by the generated type system FjTypeSystemDefinition,
 * it is here only as a wrapper for FjTypeSystemDefinition, for old unit tests
 * 
 * @author Lorenzo Bettini
 * 
 */
public class FJTypeChecker extends FjSwitch<String> {
	@Inject
	FJTypeSystemDefinition typeSystem;

	ContainingClassFinder containingClassFinder = new ContainingClassFinder();

	public String typeCheck(Expression object) {
		return getResultErrors(typeSystem.typeAsType(
				environmentForThis(object), object));
	}

	public String typeCheck(Field object) {
		return getResultErrors(typeSystem.typeAsString(
				environmentForThis(object), object));
	}

	public String typeCheck(Method object) {
		return getResultErrors(typeSystem.typeAsString(object));
	}

	public String typeCheck(Program object) {
		return getResultErrors(typeSystem.typeAsString(object));
	}

	public String typeCheck(Class object) {
		return getResultErrors(typeSystem.typeAsString(object));
	}

	/**
	 * @param result
	 * @return
	 */
	protected String getResultErrors(TypeSystemResult<?> result) {
		return (result.getFailure() != null ? result.getFailure().getMessage()
				: "");
	}

	protected TypingJudgmentEnvironment environmentForThis(EObject object) {
		return containingClassFinder.environmentForThis(object);
	}
}
