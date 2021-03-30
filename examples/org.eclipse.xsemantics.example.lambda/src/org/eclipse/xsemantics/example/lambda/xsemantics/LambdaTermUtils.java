/**
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 */
package org.eclipse.xsemantics.example.lambda.xsemantics;

import static org.eclipse.emf.ecore.util.EcoreUtil.copy;
import static org.eclipse.xtext.EcoreUtil2.eAllOfType;

import org.eclipse.xsemantics.example.lambda.lambda.Abstraction;
import org.eclipse.xsemantics.example.lambda.lambda.Term;

public class LambdaTermUtils {
	public static Term cloneWithoutTypes(final Term term) {
		final Term clone = copy(term);
		eAllOfType(clone, Abstraction.class)
			.forEach(it -> it.getParam().setType(null));
		return clone;
	}
}
