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
package it.xsemantics.runtime.validation;

import it.xsemantics.runtime.ResultWithFailure;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini
 * 
 */
public class XsemanticsBasedDeclarativeValidator extends
		AbstractDeclarativeValidator {

	@Inject
	protected XsemanticsValidatorErrorGenerator errorGenerator;

	protected void generateErrors(ResultWithFailure resultWithFailure,
			EObject originalSource) {
		errorGenerator.generateErrors(this,
				resultWithFailure.getRuleFailedException(), originalSource);
	}
}
