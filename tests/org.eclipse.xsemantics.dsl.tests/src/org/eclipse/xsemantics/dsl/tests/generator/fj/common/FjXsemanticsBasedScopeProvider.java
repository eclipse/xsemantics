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
package org.eclipse.xsemantics.dsl.tests.generator.fj.common;

import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.ClassType;
import org.eclipse.xsemantics.example.fj.fj.Expression;
import org.eclipse.xsemantics.example.fj.fj.Selection;
import org.eclipse.xsemantics.example.fj.lookup.FjAuxiliaryFunctions;
import org.eclipse.xsemantics.example.fj.util.FjTypeUtils;
import org.eclipse.xsemantics.runtime.RuleEnvironment;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.google.inject.Inject;

/**
 * @author bettini
 * 
 */
public class FjXsemanticsBasedScopeProvider extends
		AbstractDeclarativeScopeProvider {

	@Inject
	IFjTypeSystem typeSystem;

	@Inject
	FjAuxiliaryFunctions fjAux;

	@Inject
	FjTypeUtils fjTypeUtils;

	public IScope scope_Member(Selection sel, EReference ref) {
		return Scopes.scopeFor(fjAux.getMembers(getExpressionClass(sel
				.getReceiver())));
	}

	protected Class getExpressionClass(Expression receiver) {
		ClassType classType = typeSystem.classtype(
				environmentForExpression(receiver), null, receiver).getValue();
		return (classType != null ? classType.getClassref() : null);
	}

	private RuleEnvironment environmentForExpression(Expression expression) {
		Class containingClass = EcoreUtil2.getContainerOfType(expression,
				Class.class);
		if (containingClass != null) {
			ClassType thisType = fjTypeUtils.createClassType(containingClass);
			return new RuleEnvironment(typeSystem.environmentEntry("this",
					thisType));
		}
		return null;
	}
}
