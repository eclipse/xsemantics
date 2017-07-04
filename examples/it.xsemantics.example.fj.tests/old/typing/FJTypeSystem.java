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
package it.xsemantics.example.fj.typing;

import it.xsemantics.example.fj.fj.Expression;
import it.xsemantics.example.fj.fj.Field;
import it.xsemantics.example.fj.fj.Parameter;
import it.xsemantics.example.fj.fj.Type;
import it.xsemantics.example.fj.typesystem.fj.FJTypeSystemDefinition;
import it.xsemantics.example.fj.util.ContainingClassFinder;
import it.xtypes.runtime.TypeSystemResult;
import it.xtypes.runtime.TypingJudgmentEnvironment;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;

/**
 * This class is superseded by the generated type system FjTypeSystemDefinition,
 * it is here only as a wrapper for FjTypeSystemDefinition, for old unit tests
 * 
 * @author Lorenzo Bettini
 * 
 */
public class FJTypeSystem {

	@Inject
	protected FJTypeSystemDefinition fjTypeSystem;

	ContainingClassFinder containingClassFinder = new ContainingClassFinder();

	public TypeResult getType(Expression object) {
		TypeSystemResult<Type> typeResult = fjTypeSystem.typeAsType(object);

		return new TypeResult(typeResult);
	}

	public TypeResult getTypeWithBindingOfThis(Expression object) {
		TypeSystemResult<Type> typeResult = fjTypeSystem.typeAsType(
				environmentForThis(object), object);

		return new TypeResult(typeResult);
	}

	protected TypingJudgmentEnvironment environmentForThis(EObject object) {
		return containingClassFinder.environmentForThis(object);
	}

	public TypeResult getType(Field object) {
		TypeSystemResult<Type> typeResult = fjTypeSystem.typeAsType(object);

		return new TypeResult(typeResult);
	}

	public TypeResult getType(Parameter object) {
		TypeSystemResult<Type> typeResult = fjTypeSystem.typeAsType(object);

		return new TypeResult(typeResult);
	}

}
