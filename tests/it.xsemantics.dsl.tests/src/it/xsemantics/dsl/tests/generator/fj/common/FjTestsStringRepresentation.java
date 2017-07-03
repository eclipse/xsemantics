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
package it.xsemantics.dsl.tests.generator.fj.common;

import it.xsemantics.example.fj.fj.BasicType;
import it.xsemantics.example.fj.fj.ClassType;
import it.xsemantics.runtime.StringRepresentation;

/**
 * @author bettini
 * 
 */
public class FjTestsStringRepresentation extends StringRepresentation {

	/**
	 * Reduces some 'noise' for ClassTypes in the RuleEnvironment
	 * 
	 * @param classType
	 * @return
	 */
	protected String stringRep(ClassType classType) {
		return classType.getClassref().getName();
	}
	
	protected String stringRep(BasicType basicType) {
		return basicType.getBasic();
	}
}
