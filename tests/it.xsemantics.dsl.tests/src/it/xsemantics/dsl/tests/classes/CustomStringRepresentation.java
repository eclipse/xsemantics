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
package it.xsemantics.dsl.tests.classes;

import org.eclipse.emf.ecore.EClass;

import it.xsemantics.runtime.StringRepresentation;

/**
 * @author bettini
 *
 */
public class CustomStringRepresentation extends StringRepresentation {

	protected String stringRep(EClass eClass) {
		return "EClass(name=" + eClass.getName() + ")";
	}
}
