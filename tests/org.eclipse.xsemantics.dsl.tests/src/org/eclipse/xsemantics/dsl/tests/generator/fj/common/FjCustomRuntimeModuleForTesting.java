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

package org.eclipse.xsemantics.dsl.tests.generator.fj.common;

import org.eclipse.xsemantics.example.fj.FJRuntimeModule;
import org.eclipse.xsemantics.runtime.StringRepresentation;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class FjCustomRuntimeModuleForTesting extends FJRuntimeModule {
	private Class<? extends IFjTypeSystem> fjTypeSystemClass;

	public FjCustomRuntimeModuleForTesting(
			Class<? extends IFjTypeSystem> fjTypeSystemClass) {
		this.fjTypeSystemClass = fjTypeSystemClass;
	}

	@Override
	public java.lang.Class<? extends IScopeProvider> bindIScopeProvider() {
		return FjXsemanticsBasedScopeProvider.class;
	}

	public java.lang.Class<? extends IFjTypeSystem> bindIFjTypeSystem() {
		return fjTypeSystemClass;
	}

	public java.lang.Class<? extends StringRepresentation> bindStringRepresentation() {
		return FjTestsStringRepresentation.class;
	}

	public java.lang.Class<? extends AbstractDeclarativeValidator> bindAbstractDeclarativeValidator() {
		return NullTestValidator.class;
	}
}