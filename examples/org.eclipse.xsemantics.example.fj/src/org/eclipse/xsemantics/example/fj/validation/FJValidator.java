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

package org.eclipse.xsemantics.example.fj.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xsemantics.example.fj.typing.validation.FjTypeSystemValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators = { org.eclipse.xtext.validation.ImportUriValidator.class,
		org.eclipse.xtext.validation.NamesAreUniqueValidator.class })
public class FJValidator extends FjTypeSystemValidator {

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(org.eclipse.xsemantics.example.fj.fj.FjPackage.eINSTANCE);
		return result;
	}
}
