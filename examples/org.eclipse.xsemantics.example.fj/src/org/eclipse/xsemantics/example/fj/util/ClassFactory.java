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
package org.eclipse.xsemantics.example.fj.util;

import org.eclipse.xsemantics.example.fj.fj.Class;
import org.eclipse.xsemantics.example.fj.fj.FjFactory;

/**
 * Simple utility methods for creating classes with a name
 * and possible superclass (for testing purposes)
 * 
 * @author bettini
 * 
 */
public class ClassFactory {
	public static Class createClass(String name, Class superClass) {
		Class c = FjFactory.eINSTANCE.createClass();
		c.setName(name);
		c.setSuperclass(superClass);
		return c;
	}
	
	public static Class createClass(String name) {
		return createClass(name, null);
	}
}
