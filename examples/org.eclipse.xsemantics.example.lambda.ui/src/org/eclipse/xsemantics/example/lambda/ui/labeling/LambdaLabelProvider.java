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
package org.eclipse.xsemantics.example.lambda.ui.labeling;

import org.eclipse.xsemantics.example.lambda.lambda.Abstraction;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class LambdaLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public LambdaLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	String text(Abstraction abstraction) {
		return "lambda ";
	}
}
